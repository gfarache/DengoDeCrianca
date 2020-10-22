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
    private boolean maeRespFin = false;
    private boolean paiRespFin = false;
    private boolean outroRespFin = false;
    private boolean editarSerieAluno = false;
    //private boolean editarValorMensalidade = false;
 
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

	public boolean isMaeRespFin() {
		return maeRespFin;
	}

	public void setMaeRespFin(boolean maeRespFin) {
		this.maeRespFin = maeRespFin;
	}

	public boolean isPaiRespFin() {
		return paiRespFin;
	}

	public void setPaiRespFin(boolean paiRespFin) {
		this.paiRespFin = paiRespFin;
	}

	public boolean isOutroRespFin() {
		return outroRespFin;
	}

	public void setOutroRespFin(boolean outroRespFin) {
		this.outroRespFin = outroRespFin;
	}
	
	public boolean isEditarSerieAluno() {
		return editarSerieAluno;
	}
	
	public void setEditarSerieAluno(boolean editarSerieAluno) {
		this.editarSerieAluno = editarSerieAluno;
	}
	
	/*
	public boolean isEditarValorMensalidade() {
		return editarValorMensalidade;
	}
	
	public void setEditarValorMensalidade(boolean editarValorMensalidade) {
		this.editarValorMensalidade = editarValorMensalidade;
	}
	*/

	public void addMessageCPFAluno() {
        String checkCPF = cpfCheck ? "Campo para CPF do aluno habilitado" : "Campo para CPF do aluno desabilitado";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(checkCPF));
    }
	
	public void addMessageRGAluno() {
		String checkRG = rgCheck ? "Campo para RG do aluno habilitado" : "Campo para RG do aluno desabilitado";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(checkRG));
	}
	
	public void addMessagePaiCheck() {
        String checkPai = paiCheck ? "Campo de pai do aluno habilitado" : "Campo de pai do aluno desabilitado";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(checkPai));
    }
	
	public void addMessageRespFinMae() {
		String checkMaeResp = maeRespFin ? "Mãe selecionada como responsável financeiro do aluno" : "Mãe desabilitada para responsável financeiro do aluno";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(checkMaeResp));
	}
	
	public void addMessageRespFinPai() {
		String checkPaiResp = paiRespFin ? "Pai selecionado como responsável financeiro do aluno" : "Pai desabilitado para responsável financeiro do aluno";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(checkPaiResp));
	}
	
	public void addMessageRespFinOutro() {
		String checkOutroResp = outroRespFin ? "Campo responsável financeiro do aluno habilitado" : "Campo responsável financeiro do aluno desabilitado";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(checkOutroResp));
	}
	
	public void addMessageEditarSerieAluno() {
		String checkEditarSerie = editarSerieAluno ? "Edição de série para o aluno foi habilitado" : "Edição de série para o aluno foi desabilitado";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(checkEditarSerie));
	}
}