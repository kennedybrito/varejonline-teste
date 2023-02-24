package br.comvarejonline.projetoinicial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.comvarejonline.projetoinicial.estoque.saidas.SaidaProduto;
import br.comvarejonline.projetoinicial.repositories.SaidaRepository;

@Service
public class SaidaService {
	
	@Autowired
	SaidaRepository repository;

	public SaidaProduto findById(Long id) {
		Optional<SaidaProduto> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<SaidaProduto> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}



	


}
