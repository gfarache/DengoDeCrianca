package br.com.dengodecrianca.dominio;

public class Usuario {
	private String cpf = "";
	private String login = "";
	private String perfil = "";
	private String senha = "";
	private String coAtivo = "";
	
	public void limpar() {
		cpf = "";
		login = "";
		perfil = "";
		senha = "";
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getCoAtivo() {
		return coAtivo;
	}

	public void setCoAtivo(String coAtivo) {
		this.coAtivo = coAtivo;
	}
	
}
