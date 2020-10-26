package br.com.dengodecrianca.dominio;

public class Contato {
	
	private Aluno aluno;
	private ResponsavelFinanceiro responsavel;
	private String contato;
	private String descricao;
	private String tipo;
		
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public ResponsavelFinanceiro getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(ResponsavelFinanceiro responsavel) {
		this.responsavel = responsavel;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean equals(Object obj) {
        if(!(obj instanceof Contato))
            return false;
         
        Contato contato = (Contato) obj;
         
        return (contato.getContato() != null && contato.getContato().equals(this.contato) && 
        		(contato.getTipo() != null && contato.getTipo().equals(this.tipo)));
    }
 
    public int hashCode() {
        int hash = 1;
        if(contato != null)
            hash = hash * 31 + contato.hashCode(); 
        return hash;
    }
}
