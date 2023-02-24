package br.comvarejonline.projetoinicial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.comvarejonline.projetoinicial.estoque.saidas.SaidaProduto;

public interface SaidaRepository extends JpaRepository<SaidaProduto, Long> {
	
}
