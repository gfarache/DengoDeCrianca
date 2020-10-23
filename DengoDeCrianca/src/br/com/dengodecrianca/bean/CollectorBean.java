package br.com.dengodecrianca.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.dengodecrianca.dominio.Contato;

@Named
@ViewScoped
public class CollectorBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Contato contato;    
    private List<Contato> contatos;
     
    @PostConstruct
    public void init() {
        contato = new Contato();
        contatos = new ArrayList<Contato>();
         
    }
     
    public void addNovo() {
        if(contatos.contains(contato)) {
            FacesMessage msg = new FacesMessage("Dublicated", "Este número já foi adicionado!");
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
}
