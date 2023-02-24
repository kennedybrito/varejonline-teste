package br.comvarejonline.projetoinicial.estoque.saidas;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.comvarejonline.projetoinicial.domains.Produto;

public class SaidaProdutoRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	
    private Integer quantidade;
    
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private String dataSaida;
    
    private String observacao;

	public SaidaProdutoRequest() {
		super();
	}

	public SaidaProdutoRequest(Integer quantidade, String dataSaida, String observacao) {
		super();
		this.quantidade = quantidade;
		this.dataSaida = dataSaida;
		this.observacao = observacao;
	}
    
	public SaidaProduto toModelo(Produto produto){
        
        LocalDateTime data=LocalDateTime.parse(dataSaida, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        return new SaidaProduto(produto,data,quantidade,observacao);
    }

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
	
}
