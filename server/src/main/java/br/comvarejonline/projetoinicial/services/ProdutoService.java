package br.comvarejonline.projetoinicial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.comvarejonline.projetoinicial.domains.Produto;
import br.comvarejonline.projetoinicial.dtos.ProdutoDTO;
import br.comvarejonline.projetoinicial.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository repository;

	public Produto findById(Long id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<Produto> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}


	public Produto create(ProdutoDTO objDTO) {
		objDTO.setId(null);
		Produto newObj = new Produto(objDTO);
		return repository.save(newObj);
	}
	


}
