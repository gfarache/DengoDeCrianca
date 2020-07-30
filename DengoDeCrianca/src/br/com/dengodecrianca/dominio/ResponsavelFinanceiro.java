package br.com.dengodecrianca.dominio;

import java.math.BigDecimal;

public class ResponsavelFinanceiro {
	private String nome = "";
	private String cpf = "";
	private String rg = "";
	private String endereco = "";
	private String telefone = "";
	private String email = "";
	private BigDecimal mensalidade = BigDecimal.ZERO;
	
	public void limpar() {
		nome = "";
		cpf = "";
		rg = "";
		endereco = "";
		telefone = "";
		email = "";
		mensalidade = BigDecimal.ZERO;
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(BigDecimal mensalidade) {
		this.mensalidade = mensalidade;
	}
}
