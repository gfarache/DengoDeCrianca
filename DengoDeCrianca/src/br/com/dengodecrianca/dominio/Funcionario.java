package br.com.dengodecrianca.dominio;

import java.math.BigDecimal;

public class Funcionario {
	private String nome = "";
	private String cpf = "";
	private String rg = "";
	private String endereco = "";
	private String telefone = "";
	private String email = "";
	private String cargo = "";
	private BigDecimal salario = BigDecimal.ZERO;
	private String dataAdmissao = "";
	private String dataDemissao = "";
	
	public void limpar() {
		nome = "";
		cpf = "";
		rg = "";
		endereco = "";
		telefone = "";
		email = "";
		cargo = "";
		salario = BigDecimal.ZERO;
		dataAdmissao = "";
		dataDemissao = "";
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(String dataDemissao) {
		this.dataDemissao = dataDemissao;
	}
}
