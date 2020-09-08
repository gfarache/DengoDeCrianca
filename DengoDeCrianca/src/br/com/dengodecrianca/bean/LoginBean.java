package br.com.dengodecrianca.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.dengodecrianca.dominio.Funcionario;
import br.com.dengodecrianca.dominio.Usuario;
import br.com.dengodecrianca.util.Formatadores;
import br.com.dengodecrianca.dao.FuncionariosDAO;
import br.com.dengodecrianca.dao.UsuarioDAO;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login;
	private String senha;	
	private Usuario usuario;
	private Funcionario funcionario;
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String logar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		FuncionariosDAO funcionarioDAO = new FuncionariosDAO();
		try{
			usuario = usuarioDAO.usuarioLogin(login);
			funcionario = funcionarioDAO.buscarFuncionario(usuario.getMatricula());
			funcionario.setNome(Formatadores.primeiraLetraMaiuscula(funcionario.getNome()));
			funcionario.setCpf(Formatadores.colocaFormato_CPF_CNPJ(funcionario.getCpf()));
			if (login.equals(usuario.getLogin()) && senha.equals(usuario.getSenha())){
				return "/faces/restricted/inicio.xhtml";
			} else {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario e/ou senha inválidos!", ""));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		usuario = null;
		return "/login";
	}
	
}
