package br.comvarejonline.projetoinicial.domains;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.comvarejonline.projetoinicial.dtos.FuncionarioDTO;
import br.comvarejonline.projetoinicial.enums.Perfil;

@Entity
public class Funcionario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	protected String nome;
	
	@Column(unique = true)
	protected String cpf;
	@Column(unique = true)
	protected String email;
	protected String senha;


	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name= "PERFIS")
	protected Set<Integer> perfis = new HashSet<>();
	
	
	
	
	public Funcionario() {
		addPerfil(Perfil.OPERADOR);
	}

	public Funcionario(Long id, String nome, String cpf, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		
		addPerfil(Perfil.OPERADOR);
		
	}
	
	public Funcionario(FuncionarioDTO fun) {
		super();
		this.id = fun.getId();
		this.nome = fun.getNome();
		this.cpf = fun.getCpf();
		this.email = fun.getEmail();
		this.senha = fun.getSenha();
		this.perfis = fun.getPerfis().stream().map(x-> x.getCodigo()).collect(Collectors.toSet());
		
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}
		
		
	@Override
	public int hashCode() {
		return Objects.hash(cpf, email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email);
	}
	
	
	
	
}
