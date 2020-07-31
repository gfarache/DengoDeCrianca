package br.com.dengodecrianca.dominio;

public class Usuario {
	private String nuusuario = ""; //CPF
	private String login = "";
	private String perfil = "";
	private String senha = "";
	
	public void limpar() {
		nuusuario = "";
		login = "";
		perfil = "";
		senha = "";
	}

	public String getNuusuario() {
		return nuusuario;
	}

	public void setNuusuario(String nuusuario) {
		this.nuusuario = nuusuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
