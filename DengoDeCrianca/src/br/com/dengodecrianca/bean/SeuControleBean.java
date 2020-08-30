package br.com.dengodecrianca.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "SeuControle")
@ViewScoped
public class SeuControleBean {
	private String tipoConsulta;
	private String txtConsulta;
	
	public String getTipoConsulta() {
		return tipoConsulta;
	}
	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}
	public String getTxtConsulta() {
		return txtConsulta;
	}
	public void setTxtConsulta(String txtConsulta) {
		this.txtConsulta = txtConsulta;
	}
}
