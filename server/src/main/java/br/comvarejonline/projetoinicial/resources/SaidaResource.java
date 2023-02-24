package br.comvarejonline.projetoinicial.resources;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.comvarejonline.projetoinicial.dtos.SaidaDTO;
import br.comvarejonline.projetoinicial.estoque.saidas.SaidaProduto;
import br.comvarejonline.projetoinicial.repositories.SaidaRepository;
import br.comvarejonline.projetoinicial.services.SaidaService;

@RestController
@RequestMapping(value = "/saidas")
public class SaidaResource {
	
	@Autowired
	private SaidaService service;
	
	@Autowired
	private SaidaRepository repository;
	
	@Autowired
	private final EntityManager manager;
	
	public SaidaResource(SaidaRepository repository,EntityManager manager) {
        this.manager=manager;
        this.repository = repository;
       
    }
	
	
	@GetMapping
	public ResponseEntity<List<SaidaProduto>> findAll2(){
		List<SaidaProduto> list = repository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<SaidaDTO> findById(@PathVariable Long id){
		SaidaProduto obj = service.findById(id);
		return ResponseEntity.ok().body(new SaidaDTO(obj));
		
	}
}
	
	
	
	
	

