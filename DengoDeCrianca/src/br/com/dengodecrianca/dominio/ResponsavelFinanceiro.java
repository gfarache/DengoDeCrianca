package br.com.dengodecrianca.dominio;

import java.math.BigDecimal;

public class ResponsavelFinanceiro {
	private String cpf = "";
	private String parentesco = "";
	private String nome = "";
	private String rg = "";
	private String tipo_logradouro = "";
	private String nome_logradouro = "";
	private String numero_logradouro = "";
	private String bairro_logradouro = "";
	private String municipio_logradouro = "";
	private String uf_logradouro = "";
	private String cep_logradouro = "";
	private String telefone = "";
	private String email = "";
	private BigDecimal mensalidade = BigDecimal.ZERO;
	private String coAtivo = "";
	
	public void limpar() {
		cpf = "";
		parentesco = "";
		nome = "";
		rg = "";
		tipo_logradouro = "";
		nome_logradouro = "";
		numero_logradouro = "";
		bairro_logradouro = "";
		municipio_logradouro = "";
		uf_logradouro = "";
		cep_logradouro = "";
		telefone = "";
		email = "";
		mensalidade = BigDecimal.ZERO;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
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

	public BigDecimal getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(BigDecimal mensalidade) {
		this.mensalidade = mensalidade;
	}

	public String getCoAtivo() {
		return coAtivo;
	}

	public void setCoAtivo(String coAtivo) {
		this.coAtivo = coAtivo;
	}

	
}
