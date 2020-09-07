package br.com.dengodecrianca.bean;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class SelectOneMenuView {
	private String sexoAluno;
	private String turno;

	public String getSexoAluno() {
		return sexoAluno;
	}

	public void setSexoAluno(String sexoAluno) {
		this.sexoAluno = sexoAluno;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}	
}
