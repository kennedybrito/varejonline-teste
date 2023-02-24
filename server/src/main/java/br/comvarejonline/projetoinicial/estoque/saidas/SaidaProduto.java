package br.comvarejonline.projetoinicial.estoque.saidas;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.comvarejonline.projetoinicial.domains.Produto;

@Entity(name = "Saida")
public class SaidaProduto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Produto produto;

	private LocalDateTime dataSaida;

	private Integer quantidade;
	
	private String observacao;

	public SaidaProduto() {
		super();
	}

	public SaidaProduto(Produto produto, LocalDateTime dataSaida, Integer quantidade, String observacao) {
		
		this.produto = produto;
		this.dataSaida = dataSaida;
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
	
	
	
	

	
}
