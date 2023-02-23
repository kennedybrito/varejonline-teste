package br.comvarejonline.projetoinicial;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.comvarejonline.projetoinicial.domains.Funcionario;
import br.comvarejonline.projetoinicial.enums.Perfil;
import br.comvarejonline.projetoinicial.repositories.FuncionarioRepository;

@SpringBootApplication
public class ProjetoInicialApplication implements CommandLineRunner{
	
	@Autowired
	private FuncionarioRepository funrepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoInicialApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Funcionario f1 = new Funcionario(null, "teste ", "855444777", "teste@teste.com.br", "12345678", LocalDate.of(2018, 07, 22));
		f1.addPerfil(Perfil.GERENTE);
		
		funrepository.saveAll(Arrays.asList(f1));
	}


}
