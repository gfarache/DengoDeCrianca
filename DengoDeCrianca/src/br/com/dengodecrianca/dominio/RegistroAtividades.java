package br.com.dengodecrianca.dominio;

public class RegistroAtividades {
	
	private Long ID;
	private String data = "";
	private String descricao = "";
	private String login = "";
	private String login_ciente = "";
		
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getLogin_ciente() {
		return login_ciente;
	}
	public void setLogin_ciente(String login_ciente) {
		this.login_ciente = login_ciente;
	}
}
