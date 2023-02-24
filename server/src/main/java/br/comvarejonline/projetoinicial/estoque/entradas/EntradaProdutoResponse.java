package br.comvarejonline.projetoinicial.estoque.entradas;

import java.io.Serializable;
import java.time.LocalDateTime;

public class EntradaProdutoResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long produto;
    private Integer quantidadeEntrada;
    private String observacao;
    private LocalDateTime dataEntrada;
    
    public EntradaProdutoResponse(EntradaProduto entradaProduto) {
        this.produto=entradaProduto.getProduto().getId();
        this.quantidadeEntrada=entradaProduto.getQuantidade();
        this.observacao = entradaProduto.getObservacao();
        this.dataEntrada = entradaProduto.getDataEntrada();
        
    }
    
    public Long getProduto() {
        return produto;
    }

    public Integer getQuantidadeEntrada() {
        return quantidadeEntrada;
    }

	public String getObservacao() {
		return observacao;
	}

	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}
}

