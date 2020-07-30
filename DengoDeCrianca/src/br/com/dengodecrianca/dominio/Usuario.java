package br.com.dengodecrianca.dominio;

public class Usuario {
	private String nuusuario = ""; //CPF
	private String nome = "";
	private String perfil = "";
	
	public void limpar() {
		nuusuario = "";
		nome = "";
		perfil = "";
	}

	public String getNuusuario() {
		return nuusuario;
	}

	public void setNuusuario(String nuusuario) {
		this.nuusuario = nuusuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
}
