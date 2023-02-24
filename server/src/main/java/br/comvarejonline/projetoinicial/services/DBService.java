package br.comvarejonline.projetoinicial.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.comvarejonline.projetoinicial.domains.Funcionario;
import br.comvarejonline.projetoinicial.domains.Produto;
import br.comvarejonline.projetoinicial.enums.Perfil;
import br.comvarejonline.projetoinicial.repositories.FuncionarioRepository;
import br.comvarejonline.projetoinicial.repositories.ProdutoRepository;

@Service
public class DBService {
	
	@Autowired
	private FuncionarioRepository funrepository;
	
	@Autowired
	private ProdutoRepository prodRepository;
	
	
	
	public void instaciaDB() {
		
		Funcionario f1 = new Funcionario(null, "Maria eduarda ", "855444777", "duda@teste.com.br", "12345678");
		Funcionario f2 = new Funcionario(null, "Sara Eunice ", "857546877", "sara@teste.com.br", "12345678");
		Funcionario f3 = new Funcionario(null, "Dwayne Johson ", "45564777", "john@teste.com.br", "12345678");
		f1.addPerfil(Perfil.GERENTE);
		
		Produto p1 = new Produto(null, "caneta", "aaa456987766514455", 1, 0);
		Produto p2 = new Produto(null, "caneta Compactor", "aa112256987766514455", 1, 10);
		
		funrepository.saveAll(Arrays.asList(f1,f2,f3));
		prodRepository.saveAll(Arrays.asList(p1,p2));
		
	}

}
