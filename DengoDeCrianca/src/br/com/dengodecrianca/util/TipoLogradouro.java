package br.com.dengodecrianca.util;

public class TipoLogradouro {
	
	private int id;
	private String displayNome;
	private String nome;
	
	public TipoLogradouro() {}
	
	public TipoLogradouro (int id, String displayNome, String nome) {
		this.id = id;
		this.displayNome = displayNome;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDisplayNome() {
		return displayNome;
	}

	public void setDisplayNome(String displayNome) {
		this.displayNome = displayNome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return nome;
	}

}
