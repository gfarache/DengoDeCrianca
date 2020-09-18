package br.com.dengodecrianca.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hamcrest.core.SubstringMatcher;

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
		int idade = i.calculaIdade(dataNasc);
		if (idade <= 1) {
			if (idade == 0) {
				GregorianCalendar hoje = new GregorianCalendar();
			    int mesH = hoje.get(Calendar.MONTH) + 1;
			    
			    // Data do nascimento.
			    int mesN = Integer.valueOf(dataNasc.substring(3,5));
			    int meses = mesH - mesN;
			    if (meses <= 1) {
			    	this.idade  = Integer.toString(meses) + " mês";
			    } else {
			    	this.idade  = Integer.toString(meses) + " meses";
			    }
			} else {
				this.idade = Integer.toString(idade) + " ano";
			}
			
		} else {
			this.idade = Integer.toString(idade) + " anos";
		}
	}
	
	public void selectSerie() {
		String idade = this.idade.substring(0,2).trim();
		if (Integer.parseInt(idade) < 0 && Integer.parseInt(idade) >= 1) {
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
}
