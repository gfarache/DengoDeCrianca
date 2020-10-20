package br.com.dengodecrianca.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dengodecrianca.dominio.Filiacao;

@ManagedBean(name = "MBFiliacao")
@ViewScoped
public class FiliacaoBean {
	private Filiacao filiacao = new Filiacao();

	public Filiacao getFiliacao() {
		return filiacao;
	}

	public void setFiliacao(Filiacao filiacao) {
		this.filiacao = filiacao;
	}
}
