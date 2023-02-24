package br.comvarejonline.projetoinicial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.comvarejonline.projetoinicial.domains.Funcionario;
import br.comvarejonline.projetoinicial.dtos.FuncionarioDTO;
import br.comvarejonline.projetoinicial.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository repository;
	
	
	public Funcionario findById(Long id) {
		Optional<Funcionario> obj = repository.findById(id);
		return obj.orElse(null);
	}


	public List<Funcionario> findAll() {
		return repository.findAll();
	}


	public Funcionario create(FuncionarioDTO objDTO) {
		objDTO.setId(null);
		Funcionario newObj = new Funcionario(objDTO);
		return repository.save(newObj);
	}
	
	

}
