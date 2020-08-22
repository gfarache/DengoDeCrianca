package br.com.dengodecrianca.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Mensagem {
	public static void addMessageSuccess(String mensagem) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, msg);
	}
	
	public static void addMessageError(String mensagem) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, msg);
	}
}
