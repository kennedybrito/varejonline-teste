package br.comvarejonline.projetoinicial.services;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.comvarejonline.projetoinicial.domains.Funcionario;
import br.comvarejonline.projetoinicial.enums.Perfil;
import br.comvarejonline.projetoinicial.repositories.FuncionarioRepository;

@Service
public class DBService {
	
	@Autowired
	private FuncionarioRepository funrepository;
	
	
	public void instaciaDB() {
		
		Funcionario f1 = new Funcionario(null, "teste ", "855444777", "teste@teste.com.br", "12345678", LocalDate.of(2018, 07, 22));
		f1.addPerfil(Perfil.GERENTE);
		
		funrepository.saveAll(Arrays.asList(f1));
	}

}
