package br.com.dengodecrianca.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "MBBooleanCheckBox")
@ViewScoped
public class SelectBooleanView {
 
    private boolean cpfCheck;  
    private boolean rgCheck;
 
    public boolean isCpfCheck() {
		return cpfCheck;
	}

	public void setCpfCheck(boolean cpfCheck) {
		this.cpfCheck = cpfCheck;
	}

	public boolean isRgCheck() {
		return rgCheck;
	}

	public void setRgCheck(boolean rgCheck) {
		this.rgCheck = rgCheck;
	}

	public void addMessageCPFAluno() {
        String checkCPF = cpfCheck ? "CPF Aluno Habilitado" : "CPF Aluno desabilitado";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(checkCPF));        
    }
	
	public void addMessageRGAluno() {
		String checkRG = rgCheck ? "RG Aluno Habilitado" : "RG Aluno desabilitado";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(checkRG));
	}
}