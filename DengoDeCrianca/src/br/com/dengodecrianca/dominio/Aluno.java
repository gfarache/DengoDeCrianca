package br.com.dengodecrianca.dominio;

import java.io.ByteArrayInputStream;

public class Aluno {
	private String matricula = "";
	private String nome = "";
	private String datanascimento = "";
	private String cpf = "";
	private String rg = "";
	private String sexo = "";
	private String turno = "";
	private String nomeMae = "";
	private String coativo = "";
	private String nomePai = "";
	private ByteArrayInputStream foto = null;
	
	public void limpar() {
		matricula = "";
		nome = "";
		datanascimento = "";
		cpf = "";
		rg = "";
		sexo = "";
		turno = "";
		nomeMae = "";
		coativo = "";
		nomePai = "";
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
	
	public String getDatanascimento() {
		return datanascimento;
	}
	
	public void setDatanascimento(String datanascimento) {
		this.datanascimento = datanascimento;
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
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getTurno() {
		return turno;
	}
	
	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	public String getNomeMae() {
		return nomeMae;
	}
	
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	
	public String getCoativo() {
		return coativo;
	}

	public void setCoativo(String coativo) {
		this.coativo = coativo;
	}

	public String getNomePai() {
		return nomePai;
	}
	
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public ByteArrayInputStream getFoto() {
		return foto;
	}

	public void setFoto(ByteArrayInputStream foto) {
		this.foto = foto;
	}
}
