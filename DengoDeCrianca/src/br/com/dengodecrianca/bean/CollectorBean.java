package br.com.dengodecrianca.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import br.com.dengodecrianca.dominio.Contato;

@ManagedBean (name = "CollectorBean")
@ViewScoped
public class CollectorBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Contato contato;
    private List<Contato> contatos;
    private String telefone;
    private String tipoContato;
    
    public void ContatoBean() {
    	contatos = new ArrayList<Contato>();
    }
     
    @PostConstruct
    public void init() {
        contato = new Contato();
        contatos = new ArrayList<Contato>();         
    }
     
    public void createNew() {
        if(contatos.contains(contato)) {
            FacesMessage msg = new FacesMessage("Duplicated", "Este número já foi adicionado!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } 
        else {
            contatos.add(contato);
            contato = new Contato();
        }
    }
     
    public String reinit() {
        contato = new Contato();         
        return null;
    }
 
    public Contato getContato() {
        return contato;
    }
 
    public List<Contato> getContatos() {
        return contatos;
    }
    
    public String getTelefone() {
		return telefone;
	}
    
    public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
    
    public String getTipoContato() {
		return tipoContato;
	}
    
    public void setTipoContato(String tipoContato) {
		this.tipoContato = tipoContato;
	}
}
