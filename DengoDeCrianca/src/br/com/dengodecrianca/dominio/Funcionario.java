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
	private String tipo_logradouro = "";
	private String nome_logradouro = "";
	private String numero_logradouro = "";
	private String bairro_logradouro = "";
	private String municipio_logradouro = "";
	private String uf_logradouro = "";
	private String cep_logradouro = "";
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
		dataNascimento = "";
		sexo = "";
		tipo_logradouro = "";
		nome_logradouro = "";
		numero_logradouro = "";
		bairro_logradouro = "";
		municipio_logradouro = "";
		uf_logradouro = "";
		cep_logradouro = "";
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

	public String getTipo_logradouro() {
		return tipo_logradouro;
	}

	public void setTipo_logradouro(String tipo_logradouro) {
		this.tipo_logradouro = tipo_logradouro;
	}

	public String getNome_logradouro() {
		return nome_logradouro;
	}

	public void setNome_logradouro(String nome_logradouro) {
		this.nome_logradouro = nome_logradouro;
	}

	public String getNumero_logradouro() {
		return numero_logradouro;
	}

	public void setNumero_logradouro(String numero_logradouro) {
		this.numero_logradouro = numero_logradouro;
	}

	public String getBairro_logradouro() {
		return bairro_logradouro;
	}

	public void setBairro_logradouro(String bairro_logradouro) {
		this.bairro_logradouro = bairro_logradouro;
	}

	public String getMunicipio_logradouro() {
		return municipio_logradouro;
	}

	public void setMunicipio_logradouro(String municipio_logradouro) {
		this.municipio_logradouro = municipio_logradouro;
	}

	public String getUf_logradouro() {
		return uf_logradouro;
	}

	public void setUf_logradouro(String uf_logradouro) {
		this.uf_logradouro = uf_logradouro;
	}

	public String getCep_logradouro() {
		return cep_logradouro;
	}

	public void setCep_logradouro(String cep_logradouro) {
		this.cep_logradouro = cep_logradouro;
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
