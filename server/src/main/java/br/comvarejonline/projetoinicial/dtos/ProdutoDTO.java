package br.comvarejonline.projetoinicial.dtos;

import java.io.Serializable;

import br.comvarejonline.projetoinicial.domains.Produto;

public class ProdutoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String codBarras;
	private Integer quantminima;
	private Integer saldoInicial;
	
	
	
	public ProdutoDTO() {
		super();
	}

	public ProdutoDTO(Produto prod) {
		super();
		this.id = prod.getId();
		this.nome = prod.getNome();
		this.codBarras = prod.getCodBarras();
		this.quantminima = prod.getQuantminima();
		this.saldoInicial = prod.getSaldoInicial();
		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public Integer getQuantminima() {
		return quantminima;
	}

	public void setQuantminima(Integer quantminima) {
		this.quantminima = quantminima;
	}

	public Integer getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(Integer saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	
	

	
	
	
}
