package br.comvarejonline.projetoinicial.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.comvarejonline.projetoinicial.domains.Produto;
import br.comvarejonline.projetoinicial.estoque.saidas.SaidaProduto;

public class SaidaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Produto produto;
	private LocalDateTime dataSaida;
	private Integer quantidade;
	private String observacao;

	private String nome;
	
	
	public SaidaDTO() {
		super();
	}

	public SaidaDTO(SaidaProduto prod) {
		super();
		this.id = prod.getId();
		this.produto = prod.getProduto();
		this.observacao = prod.getObservacao();
		this.quantidade = prod.getQuantidade();
		
		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public LocalDateTime getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDateTime dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

	
	
	
}
