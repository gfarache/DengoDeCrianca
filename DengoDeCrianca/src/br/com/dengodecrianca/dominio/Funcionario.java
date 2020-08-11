package br.com.dengodecrianca.dominio;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;

public class Funcionario {
	private String matricula = "";
	private String nome = "";
	private String cpf = "";
	private String rg = "";
	private String dataNascimento = "";
	private String sexo = "";
	private String endereco = "";
	private String telefone = "";
	private String email = "";
	private String cargo = "";
	private BigDecimal salario = BigDecimal.ZERO;
	private String dataAdmissao = "";
	private String dataDemissao = "";
	private ByteArrayInputStream foto = null;
	private String coAtivo = "";
	
	public void limpar() {
		matricula = "";
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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

	public ByteArrayInputStream getFoto() {
		return foto;
	}

	public void setFoto(ByteArrayInputStream foto) {
		this.foto = foto;
	}

	public String getCoAtivo() {
		return coAtivo;
	}

	public void setCoAtivo(String coAtivo) {
		this.coAtivo = coAtivo;
	}
}
