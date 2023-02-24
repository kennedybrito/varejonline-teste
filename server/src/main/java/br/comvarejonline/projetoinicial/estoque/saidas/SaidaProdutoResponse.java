package br.comvarejonline.projetoinicial.estoque.saidas;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SaidaProdutoResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long produto;
    private Integer quantidadeSaida;
    private String observacao;
    private LocalDateTime dataSaida;
    
    public SaidaProdutoResponse(SaidaProduto saidaProduto) {
        this.produto=saidaProduto.getProduto().getId();
        this.quantidadeSaida=saidaProduto.getQuantidade();
        this.observacao = saidaProduto.getObservacao();
        this.dataSaida = saidaProduto.getDataSaida();
        
    }
    
    public Long getProduto() {
        return produto;
    }

    public Integer getQuantidadeSaida() {
        return quantidadeSaida;
    }

	public String getObservacao() {
		return observacao;
	}

	public LocalDateTime getDataSaida() {
		return dataSaida;
	}
}

