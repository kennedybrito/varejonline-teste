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
		
		Funcionario f1 = new Funcionario(null, "Maria eduarda ", "855444777", "duda@teste.com.br", "12345678", LocalDate.of(2000, 07, 22));
		Funcionario f2 = new Funcionario(null, "Sara Eunice ", "857546877", "sara@teste.com.br", "12345678", LocalDate.of(1993, 10, 10));
		Funcionario f3 = new Funcionario(null, "Dwayne Johson ", "45564777", "john@teste.com.br", "12345678", LocalDate.of(1990, 01, 13));
		f1.addPerfil(Perfil.GERENTE);
		
		funrepository.saveAll(Arrays.asList(f1,f2,f3));
	}

}
