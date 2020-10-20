package br.com.dengodecrianca.dominio;

import java.io.ByteArrayInputStream;

import br.com.dengodecrianca.util.Formatadores;

public class Aluno {
	
	private String matricula;
	private String nome;
	private String dataNascimento;
	private String cpf;
	private String rg;
	private String sexo;
	private String turno;
	private ByteArrayInputStream foto = null;
	private String coAtivo;
	private ResponsavelFinanceiro responsavel;
	private Filiacao filiacao;
	
	public void limpar() {
		matricula = "";
		nome = "";
		dataNascimento = "";
		cpf = "";
		rg = "";
		sexo = "";
		turno = "";
		coAtivo = "";
		responsavel = null;
		filiacao = null;
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
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
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
	
	public ResponsavelFinanceiro getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(ResponsavelFinanceiro responsavel) {
		this.responsavel = responsavel;
	}

	public Filiacao getFiliacao() {
		return filiacao;
	}

	public void setFiliacao(Filiacao filiacao) {
		this.filiacao = filiacao;
	}

	@Override
	public String toString() {
		String saida = "Matricula: " + matricula + "\nNome: " + nome+"\nData de nascimento: "+Formatadores.formataDataToTela(dataNascimento);
		return saida;
	}
	
	public static void main(String[] args) {
		Aluno a = new Aluno();
		
		a.setMatricula("2020-001");
		a.setNome("Gustavo Farache");
		a.setDataNascimento("20180222");
		System.out.println(a);
	}
}
