package br.com.dengodecrianca.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dengodecrianca.dao.AlunosDAO;
import br.com.dengodecrianca.dominio.Aluno;
import br.com.dengodecrianca.util.Idade;

@ManagedBean(name = "MBAluno")
@ViewScoped
public class AlunoBean {
	private Aluno aluno;
	private String idade;
	private String dataNasc;
	private String serie;
	private String turno;
	private String mensalidade;
	private String sexoAluno;
	private ArrayList<Aluno> itens;
	private ArrayList<Aluno> itensFiltrados;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}
	
	public String getDataNasc() {
		return dataNasc;
	}
	
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	public String getSerie() {
		return serie;
	}
	
	public void setSerie(String serie) {
		this.serie = serie;
	}
	
	public String getTurno() {
		return turno;
	}
	
	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	public String getMensalidade() {
		return mensalidade;
	}
	
	public void setMensalidade(String mensalidade) {
		this.mensalidade = mensalidade;
	}
	
	public String getSexoAluno() {
		return sexoAluno;
	}
	
	public void setSexoAluno(String sexoAluno) {
		this.sexoAluno = sexoAluno;
	}

	public ArrayList<Aluno> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Aluno> itens) {
		this.itens = itens;
	}

	public ArrayList<Aluno> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Aluno> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void listarAlunos(){
		AlunosDAO alunoDAO = new AlunosDAO();
		
		try {
			itens = alunoDAO.listar();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void calculaIdade() {
		Idade i = new Idade();
		String idade = i.calculaIdade(dataNasc);			
	}
	
	public void selectSerie() {
		String idade = this.idade.substring(0,2).trim();
		if (this.idade.contains(" mês") || this.idade.contains(" meses")) {
			serie = "Berçário";
		} else if (Integer.parseInt(idade) == 1) {
			serie = "Berçário";
		} else if (Integer.parseInt(idade) > 1 && Integer.parseInt(idade) <= 2) {
			serie = "Jardim I";
		} else if (Integer.parseInt(idade) > 2 && Integer.parseInt(idade) <= 3) {
			serie = "Jardim II";
		} else if (Integer.parseInt(idade) > 3 && Integer.parseInt(idade) <= 4) {
			serie = "1º período";
		} else if (Integer.parseInt(idade) > 4 && Integer.parseInt(idade) <= 5) {
			serie = "2º período";
		} else if (Integer.parseInt(idade) > 5 && Integer.parseInt(idade) <= 6) {
			serie = "1º ano - E.F.";
		} else if (Integer.parseInt(idade) > 6 && Integer.parseInt(idade) <= 7) {
			serie = "2º ano - E.F.";
		} else if (Integer.parseInt(idade) > 7 && Integer.parseInt(idade) <= 8) {
			serie = "3º ano - E.F.";
		} else if (Integer.parseInt(idade) > 8 && Integer.parseInt(idade) <= 9) {
			serie = "4º ano - E.F.";
		} else if (Integer.parseInt(idade) > 9 && Integer.parseInt(idade) <= 10) {
			serie = "5º ano - E.F.";
		}
	}
	
	public void getBancoMensalidade() {
		if (turno != null && turno.equals("I")) {
			mensalidade = "R$ 800,00";
		} else if (turno != null && turno.equals("MPM")) {
			mensalidade = "R$ 400,00";
		} else if (turno != null && turno.equals("MPT")) {
			mensalidade = "R$ 400,00";
		}
	}
}
