package br.comvarejonline.projetoinicial.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import br.comvarejonline.projetoinicial.domains.Funcionario;
import br.comvarejonline.projetoinicial.enums.Perfil;

public class FuncionarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	protected Long id;
	protected String nome;
	protected String cpf;
	protected String email;
	protected String senha;
	protected Set<Integer> perfis = new HashSet<>();
	
	
	public FuncionarioDTO() {
		super();
		addPerfis(Perfil.OPERADOR);
	}

	public FuncionarioDTO(Funcionario fun) {
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
		return perfis.stream().map( x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfis(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}



	
	
	
}
