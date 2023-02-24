package br.comvarejonline.projetoinicial.estoque.entradas;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.comvarejonline.projetoinicial.domains.Produto;

@Entity(name = "Entrada")
public class EntradaProduto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Produto produto;

	private LocalDateTime dataEntrada;

	private Integer quantidade;
	
	private String observacao;

	public EntradaProduto() {
		super();
	}

	public EntradaProduto(Produto produto, LocalDateTime dataEntrada, Integer quantidade, String observacao) {
		
		this.produto = produto;
		this.dataEntrada = dataEntrada;
		this.quantidade = quantidade;
		this.observacao = observacao;
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

	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
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
	
	
	
	

	
}
