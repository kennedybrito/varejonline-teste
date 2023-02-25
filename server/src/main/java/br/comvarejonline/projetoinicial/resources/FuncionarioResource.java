package br.comvarejonline.projetoinicial.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.comvarejonline.projetoinicial.domains.Funcionario;
import br.comvarejonline.projetoinicial.dtos.FuncionarioDTO;
import br.comvarejonline.projetoinicial.services.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioResource {
	
	@Autowired
	private FuncionarioService service;
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping(value="/{id}")
	public ResponseEntity<FuncionarioDTO> findById(@PathVariable Long id){
		Funcionario obj = service.findById(id);
		return ResponseEntity.ok().body(new FuncionarioDTO(obj));
		
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping
	public ResponseEntity<List<FuncionarioDTO>> findAll(){
		List<Funcionario> list = service.findAll();
		List<FuncionarioDTO> listDTO = list.stream().map(obj -> new FuncionarioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public ResponseEntity<FuncionarioDTO> create(@RequestBody FuncionarioDTO objDTO){
		Funcionario newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	
}
