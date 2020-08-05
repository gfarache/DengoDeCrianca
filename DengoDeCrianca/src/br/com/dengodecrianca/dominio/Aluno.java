package br.com.dengodecrianca.dominio;

public class Aluno {
	private String matricula;
	private String nome;
	private String datanascimento;
	private String cpf;
	private String rg;
	private String sexo;
	private String turno;
	private String nomeMae;
	private String nomePai;
	
	public void limpar() {
		matricula = "";
		nome = "";
		datanascimento = "";
		cpf = "";
		rg = "";
		sexo = "";
		turno = "";
		nomeMae = "";
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
	
	public String getNomePai() {
		return nomePai;
	}
	
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
}
