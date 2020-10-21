package br.com.dengodecrianca.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "MBMatricula")
@SessionScoped
public class MatriculaBean {
	
	public void novo(String value) {
		
		System.out.println("teste: "+value);
	}
}
