package br.com.dengodecrianca.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "MBBooleanCheckBox")
@ViewScoped
public class SelectBooleanView {
 
    private boolean cpfCheck = false;
    private boolean rgCheck = false;
    private boolean paiCheck = false;
 
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

	public boolean isPaiCheck() {
		return paiCheck;
	}

	public void setPaiCheck(boolean paiCheck) {
		this.paiCheck = paiCheck;
	}

	public void addMessageCPFAluno() {
        String checkCPF = cpfCheck ? "Campo para CPF do aluno habilitado" : "Campo para CPF do aluno desabilitado";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(checkCPF));        
    }
	
	public void addMessageRGAluno() {
		String checkRG = rgCheck ? "Campo para RG do aluno habilitado" : "Campo para RG do aluno desabilitado";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(checkRG));
	}
	
	public void addMessagePaiCheck() {
        String checkPai = paiCheck ? "Campo para pai do aluno habilitado" : "Campo para pai do aluno desabilitado";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(checkPai));        
    }
}