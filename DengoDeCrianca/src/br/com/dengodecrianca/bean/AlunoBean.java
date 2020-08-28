package br.com.dengodecrianca.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dengodecrianca.dao.AlunosDAO;
import br.com.dengodecrianca.dominio.Aluno;

@ManagedBean(name = "MBAluno")
@ViewScoped
public class AlunoBean {
	private Aluno aluno;
	private ArrayList<Aluno> itens;
	private ArrayList<Aluno> itensFiltrados;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
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
}
