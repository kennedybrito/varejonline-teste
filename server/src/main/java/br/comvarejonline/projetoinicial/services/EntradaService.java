package br.comvarejonline.projetoinicial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.comvarejonline.projetoinicial.estoque.entradas.EntradaProduto;
import br.comvarejonline.projetoinicial.repositories.EntradaRepository;

@Service
public class EntradaService {
	
	@Autowired
	EntradaRepository repository;

	public EntradaProduto findById(Long id) {
		Optional<EntradaProduto> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<EntradaProduto> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}





}
