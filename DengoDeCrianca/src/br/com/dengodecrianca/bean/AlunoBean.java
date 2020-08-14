package br.com.dengodecrianca.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.dengodecrianca.dao.AlunosDAO;
import br.com.dengodecrianca.dominio.Aluno;

@ManagedBean(name = "MBAluno")
@ViewScoped
public class AlunoBean {
	private ListDataModel<Aluno> item;

	public ListDataModel<Aluno> getItem() {
		return item;
	}

	public void setItem(ListDataModel<Aluno> item) {
		this.item = item;
	}
	
	@PostConstruct
	public void listarAlunos(){
		AlunosDAO alunoDAO = new AlunosDAO();
		
		try {
			ArrayList<Aluno> lista = alunoDAO.listar();
			item = new ListDataModel<Aluno>(lista);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
