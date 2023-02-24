package br.comvarejonline.projetoinicial.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.comvarejonline.projetoinicial.domains.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	
	Optional<Funcionario> findByEmail(String email);

}
