package br.com.dengodecrianca.dominio;

public class Contato {
	
	private Aluno aluno;
	private ResponsavelFinanceiro responsavel;
	private String telefone;
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
         
        return (contato.getTelefone() != null && contato.getTelefone().equals(this.telefone) && 
        		(contato.getTipo() != null && contato.getTipo().equals(this.tipo)) &&
        		(contato.getDescricao() != null && contato.getDescricao().equals(this.descricao)));
    }
 
    public int hashCode() {
        int hash = 1;
        if (telefone != null)
            hash = hash * 31 + telefone.hashCode();
        
        if (tipo != null)
        	hash = hash * 29 + tipo.hashCode();
        
        if (descricao != null)
        	hash = hash * 23 + tipo.hashCode();
        
        return hash;
    }
}
