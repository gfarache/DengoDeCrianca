package br.com.dengodecrianca.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

import br.com.dengodecrianca.util.TipoLogradouro;

@Named
@ApplicationScoped
public class LogradouroService {
	
	private List<TipoLogradouro> logradouros;
	
	@PostConstruct
	public void init() {
		logradouros = new ArrayList<TipoLogradouro>();
		logradouros.add(new TipoLogradouro(0, "Aeroporto","aeroporto"));
		logradouros.add(new TipoLogradouro(1, "Alameda","alameda"));
		logradouros.add(new TipoLogradouro(2, "Área","area"));
		logradouros.add(new TipoLogradouro(3, "Avenida", "avenida"));
		logradouros.add(new TipoLogradouro(4, "Beco", "beco"));
		logradouros.add(new TipoLogradouro(5, "Campo","campo"));
		logradouros.add(new TipoLogradouro(6, "Chácara", "chacara"));
		logradouros.add(new TipoLogradouro(7, "Colônia", "colonia"));
		logradouros.add(new TipoLogradouro(8, "Condomínio", "condominio"));
		logradouros.add(new TipoLogradouro(9, "Conjunto", "conjunto"));
		logradouros.add(new TipoLogradouro(10, "Distrito", "distrito"));
		logradouros.add(new TipoLogradouro(11, "Esplanada", "esplanada"));
		logradouros.add(new TipoLogradouro(12, "Estação", "estacao"));
		logradouros.add(new TipoLogradouro(13, "Estrada", "estrada"));
		logradouros.add(new TipoLogradouro(14, "Favela", "favela"));
		logradouros.add(new TipoLogradouro(15, "Feira", "feira"));
		logradouros.add(new TipoLogradouro(16, "Jardim", "jardim"));
		logradouros.add(new TipoLogradouro(17, "Ladeira", "ladeira"));
		logradouros.add(new TipoLogradouro(18, "Lago", "lago"));
		logradouros.add(new TipoLogradouro(19, "Lagoa", "lagoa"));
		logradouros.add(new TipoLogradouro(20, "Largo", "largo"));
		logradouros.add(new TipoLogradouro(21, "Loteamento", "loteamento"));
		logradouros.add(new TipoLogradouro(22, "Morro", "morro"));
		logradouros.add(new TipoLogradouro(23, "Núcleo", "nucleo"));
		logradouros.add(new TipoLogradouro(24, "Parque", "parque"));
		logradouros.add(new TipoLogradouro(25, "Passarela", "passarela"));
		logradouros.add(new TipoLogradouro(26, "Pátio", "patio"));
		logradouros.add(new TipoLogradouro(27, "Praça", "praca"));
		logradouros.add(new TipoLogradouro(28, "Quadra", "quadra"));
		logradouros.add(new TipoLogradouro(29, "Recanto", "recanto"));
		logradouros.add(new TipoLogradouro(30, "Residencial", "residencial"));
		logradouros.add(new TipoLogradouro(31, "Rodovia", "rodovia"));
		logradouros.add(new TipoLogradouro(32, "Rua", "rua"));
		logradouros.add(new TipoLogradouro(33, "Setor", "setor"));
		logradouros.add(new TipoLogradouro(34, "Sítio", "sitio"));
		logradouros.add(new TipoLogradouro(35, "Travessa", "travessa"));
		logradouros.add(new TipoLogradouro(36, "Trecho", "trecho"));
		logradouros.add(new TipoLogradouro(37, "Trevo", "trevo"));
		logradouros.add(new TipoLogradouro(38, "Vale", "vale"));
		logradouros.add(new TipoLogradouro(39, "Vereda", "vereda"));
		logradouros.add(new TipoLogradouro(40, "Via", "via"));
		logradouros.add(new TipoLogradouro(41, "Viaduto", "viaduto"));
		logradouros.add(new TipoLogradouro(42, "Viela", "viela"));
		logradouros.add(new TipoLogradouro(43, "Vila", "vila")) ;
	}
	
	public List<TipoLogradouro> getTipoLogradouros() {
		return logradouros;
	}

}
