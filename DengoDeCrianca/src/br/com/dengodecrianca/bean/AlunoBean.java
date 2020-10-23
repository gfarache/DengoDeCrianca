package br.com.dengodecrianca.bean;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dengodecrianca.dao.AlunosDAO;
import br.com.dengodecrianca.dominio.Aluno;
import br.com.dengodecrianca.dominio.ResponsavelFinanceiro;
import br.com.dengodecrianca.dominio.Contato;
import br.com.dengodecrianca.util.Idade;

@ManagedBean(name = "MBAluno")
@ViewScoped
public class AlunoBean {
	private Aluno aluno = new Aluno();
	private ResponsavelFinanceiro responsavel = new ResponsavelFinanceiro();
	private Contato contato = new Contato();
	private String idade;
	private String serie;
	private ArrayList<Aluno> itens;
	private ArrayList<Aluno> itensFiltrados;

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

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
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
		this.idade = i.calculaIdade(aluno.getDataNascimento());
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
		if (aluno.getTurno() == null || aluno.getTurno().equals("")) {
			responsavel.setMensalidade(BigDecimal.ZERO);			
		} else if (aluno.getTurno() != null && aluno.getTurno().equals("I")) {
			responsavel.setMensalidade(new BigDecimal(800));
		} else if (aluno.getTurno() != null && aluno.getTurno().equals("MPM")) {
			responsavel.setMensalidade(new BigDecimal(400));
		} else if (aluno.getTurno() != null && aluno.getTurno().equals("MPT")) {
			responsavel.setMensalidade(new BigDecimal(400));
		}
	}
}
