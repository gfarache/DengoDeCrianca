package br.com.dengodecrianca.dominio;

public class Usuario {
	
	private String login = "";
	private String perfil = "";
	private String senha = "";
	private String coativo = "";
	private String matricula = "";
	
	public void limpar() {
		login = "";
		perfil = "";
		senha = "";
		matricula = "";
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

	public String getCoativo() {
		return coativo;
	}

	public void setCoativo(String coativo) {
		this.coativo = coativo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}
