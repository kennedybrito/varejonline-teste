package br.comvarejonline.projetoinicial.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.comvarejonline.projetoinicial.domains.Produto;
import br.comvarejonline.projetoinicial.dtos.ProdutoDTO;
import br.comvarejonline.projetoinicial.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id){
		Produto obj = service.findById(id);
		return ResponseEntity.ok().body(new ProdutoDTO(obj));
		
	}
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> findAll(){
		List<Produto> list = service.findAll();
		List<ProdutoDTO> listDTO = list.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	
	
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> create(@RequestBody ProdutoDTO objDTO){
		Produto newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
}

	


