package br.com.dengodecrianca.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBMatricula")
@ViewScoped
public class MatriculaBean {
	
	public void novo() {
		
		System.out.println("teste");
	}
}
