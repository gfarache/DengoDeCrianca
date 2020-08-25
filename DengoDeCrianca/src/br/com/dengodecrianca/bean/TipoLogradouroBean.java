package br.com.dengodecrianca.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.dengodecrianca.service.LogradouroService;
import br.com.dengodecrianca.util.TipoLogradouro;

@Named
@RequestScoped
public class TipoLogradouroBean {
	private TipoLogradouro tipoLogradouro;
	private List<TipoLogradouro> tiposLogradouros;
	
	@Inject
	private LogradouroService service;
	
	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public List<TipoLogradouro> getTiposLogradouros() {
		return tiposLogradouros;
	}

	public void setTiposLogradouros(List<TipoLogradouro> tiposLogradouros) {
		this.tiposLogradouros = tiposLogradouros;
	}

	public void setService(LogradouroService service) {
		this.service = service;
	}
	
	@PostConstruct
	public void init(){
		tiposLogradouros = service.getTipoLogradouros();
	}
}
