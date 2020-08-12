package br.com.dengodecrianca.dominio;

import java.io.ByteArrayInputStream;

import br.com.dengodecrianca.util.Formatadores;

public class Aluno {
	private String matricula = "";
	private String respfin_cpf = "";
	private String nome = "";
	private String dataNascimento = "";
	private String cpf = "";
	private String rg = "";
	private String sexo = "";
	private String turno = "";
	private String nomeMae = "";
	private String coativo = "";
	private String nomePai = "";
	private ByteArrayInputStream foto = null;
	private String coAtivo = "";
	
	public void limpar() {
		matricula = "";
		nome = "";
		dataNascimento = "";
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

	public String getRespfin_cpf() {
		return respfin_cpf;
	}

	public void setRespfin_cpf(String respfin_cpf) {
		this.respfin_cpf = respfin_cpf;
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

	public String getCoAtivo() {
		return coAtivo;
	}

	public void setCoAtivo(String coAtivo) {
		this.coAtivo = coAtivo;
	}
	
	@Override
	public String toString() {
		String saida = "Matricula: " + matricula + "\nNome: " + nome+"\nData de nascimento: "+Formatadores.formataDataToTela(dataNascimento);
		return saida;
	}
	
	public static void main(String[] args) {
		Aluno a = new Aluno();
		
		a.setMatricula("2020MT001");
		a.setNome("Gustavo Farache");
		a.setDataNascimento("20180222");
		System.out.println(a);
	}
}
