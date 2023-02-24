package br.comvarejonline.projetoinicial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.comvarejonline.projetoinicial.domains.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
