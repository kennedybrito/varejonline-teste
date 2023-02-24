package br.comvarejonline.projetoinicial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.comvarejonline.projetoinicial.estoque.entradas.EntradaProduto;

public interface EntradaRepository extends JpaRepository<EntradaProduto, Long> {
	
}
