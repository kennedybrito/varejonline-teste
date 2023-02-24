package br.comvarejonline.projetoinicial.estoque.entradas;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.comvarejonline.projetoinicial.domains.Produto;

public class EntradaProdutoRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	
    private Integer quantidade;
    
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private String dataEntrada;
    
    private String observacao;

	public EntradaProdutoRequest() {
		super();
	}

	public EntradaProdutoRequest(Integer quantidade, String dataEntrada, String observacao) {
		super();
		this.quantidade = quantidade;
		this.dataEntrada = dataEntrada;
		this.observacao = observacao;
	}
    
	public EntradaProduto toModelo(Produto produto){
        
        LocalDateTime data=LocalDateTime.parse(dataEntrada, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        return new EntradaProduto(produto,data,quantidade,observacao);
    }

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
	
}
