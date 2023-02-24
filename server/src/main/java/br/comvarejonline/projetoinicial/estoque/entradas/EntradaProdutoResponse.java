package br.comvarejonline.projetoinicial.estoque.entradas;

import java.io.Serializable;

public class EntradaProdutoResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long produto;
    private Integer quantidadeEntrada;
    
    public EntradaProdutoResponse(EntradaProduto entradaProduto) {
        this.produto=entradaProduto.getProduto().getId();
        this.quantidadeEntrada=entradaProduto.getQuantidade();
    }
    
    public Long getProduto() {
        return produto;
    }

    public Integer getQuantidadeEntrada() {
        return quantidadeEntrada;
    }
}

