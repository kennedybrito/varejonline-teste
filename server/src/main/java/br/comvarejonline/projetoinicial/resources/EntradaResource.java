package br.comvarejonline.projetoinicial.resources;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.comvarejonline.projetoinicial.domains.Produto;
import br.comvarejonline.projetoinicial.dtos.EntradaDTO;
import br.comvarejonline.projetoinicial.dtos.ProdutoDTO;
import br.comvarejonline.projetoinicial.estoque.entradas.EntradaProduto;
import br.comvarejonline.projetoinicial.repositories.EntradaRepository;
import br.comvarejonline.projetoinicial.services.EntradaService;

@RestController
@RequestMapping(value = "/entradas")
public class EntradaResource {
	
	@Autowired
	private EntradaService service;
	
	@Autowired
	private EntradaRepository repository;
	
	@Autowired
	private final EntityManager manager;
	
	public EntradaResource(EntradaRepository repository,EntityManager manager) {
        this.manager=manager;
        this.repository = repository;
       
    }
	
	@PreAuthorize("hasAnyRole('OPERADOR')")
	@GetMapping
	public ResponseEntity<List<EntradaProduto>> findAll2(){
		List<EntradaProduto> list = repository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PreAuthorize("hasAnyRole('OPERADOR')")
	@GetMapping(value="/{id}")
	public ResponseEntity<EntradaDTO> findById(@PathVariable Long id){
		EntradaProduto obj = service.findById(id);
		return ResponseEntity.ok().body(new EntradaDTO(obj));
		
	}
}
	
	
	
	
	

