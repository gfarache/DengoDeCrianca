package br.com.dengodecrianca.dominio;

import java.math.BigDecimal;

public class DesempenhoAluno {
	
	private Aluno aluno = new Aluno();
	private Disciplina disciplina = new Disciplina();
	private BigDecimal nota = BigDecimal.ZERO;
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public BigDecimal getNota() {
		return nota;
	}
	public void setNota(BigDecimal nota) {
		this.nota = nota;
	}
}
