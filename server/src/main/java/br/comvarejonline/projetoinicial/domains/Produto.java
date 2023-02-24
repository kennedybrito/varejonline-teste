package br.comvarejonline.projetoinicial.domains;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.comvarejonline.projetoinicial.dtos.ProdutoDTO;

@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String nome;
	
	@Column(unique = true)
	private String codBarras;
	
	private Integer quantminima;
	private Integer saldoInicial;
	
	
	public Produto() {
		super();
	}


	public Produto(Long id, String nome, String codBarras, Integer quantminima, Integer saldoInicial) {
		super();
		this.id = id;
		this.nome = nome;
		this.codBarras = codBarras;
		this.quantminima = quantminima;
		this.saldoInicial = saldoInicial;
	}
	
	public Produto(ProdutoDTO prod) {
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


	@Override
	public int hashCode() {
		return Objects.hash(codBarras, nome);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(codBarras, other.codBarras) && Objects.equals(nome, other.nome);
	}
	
	
	
	

	
	
	
	
}
