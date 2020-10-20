package br.com.dengodecrianca.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dengodecrianca.dao.ResponsavelFinanceiroDAO;
import br.com.dengodecrianca.dominio.ResponsavelFinanceiro;
import br.com.dengodecrianca.util.Mensagem;

@ManagedBean(name = "MBRespFin")
@ViewScoped
public class ResponsavelFinanceiroBean {
	private ResponsavelFinanceiro respFin = new ResponsavelFinanceiro();
	private ArrayList<ResponsavelFinanceiro> itens;
	private ArrayList<ResponsavelFinanceiro> itensFiltrados;
	
	public ResponsavelFinanceiro getRespFin() {
		return respFin;
	}

	public void setRespFin(ResponsavelFinanceiro respFin) {
		this.respFin = respFin;
	}
	
	public ArrayList<ResponsavelFinanceiro> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<ResponsavelFinanceiro> itens) {
		this.itens = itens;
	}
	
	public ArrayList<ResponsavelFinanceiro> getItensFiltrados() {
		return itensFiltrados;
	}
	
	public void setItensFiltrados(ArrayList<ResponsavelFinanceiro> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void ListarRespFin() {
		ResponsavelFinanceiroDAO respDAO = new ResponsavelFinanceiroDAO();
		
		try {
			itens = respDAO.listarResponsavelFinanceiro();
			
		} catch (Exception e) {
			Mensagem.addMessageError("Erro ao listar os responsáveis financeiros!");
			Mensagem.addMessageError(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void prepararNovo(){
		respFin = new ResponsavelFinanceiro();
	}
	
	public void novoRespFin() {
		boolean result = false;
		try{
			ResponsavelFinanceiroDAO respDAO = new ResponsavelFinanceiroDAO();
			result = respDAO.salvarNovoRespFin(respFin);
			if (result) {
				Mensagem.addMessageSuccess("Responsável adicionado com sucesso!");
			}
			itens = respDAO.listarResponsavelFinanceiro();
			
		} catch (SQLException e) {
			Mensagem.addMessageError("Erro ao salvar novo Responsável!");
			Mensagem.addMessageError(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
	public void excluirRespFin(){
		boolean result = false;
		try{
			ResponsavelFinanceiroDAO respDAO = new ResponsavelFinanceiroDAO();
			result = respDAO.excluirRespFinanceiro(respFin);
			if (result) {
				Mensagem.addMessageSuccess("Responsável excluído com sucesso!");
			}
			itens = respDAO.listarResponsavelFinanceiro();
		} catch (SQLException e) {
			Mensagem.addMessageError("Erro ao excluir o Responsável Financeiro!\n"
								   + "Verifique se o mesmo não possui um ou mais alunos associados a ele!");
			Mensagem.addMessageError(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void editarRespFin(){
		boolean result = false;
		try{
			ResponsavelFinanceiroDAO respDAO = new ResponsavelFinanceiroDAO();
			result = respDAO.editarRespFinanceiro(respFin);
			if (result) {
				Mensagem.addMessageSuccess("Responsável editado com sucesso!");
			}
			itens = respDAO.listarResponsavelFinanceiro();
		} catch (SQLException e) {
			Mensagem.addMessageError("Erro ao editar o Responsável Financeiro!\n"
								   + "Verifique se o mesmo não possui um ou mais alunos associados a ele!");
			Mensagem.addMessageError(e.getMessage());
			e.printStackTrace();
		}
	}
}
