package br.com.dengodecrianca.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.dengodecrianca.dao.ResponsavelFinanceiroDAO;
import br.com.dengodecrianca.dominio.ResponsavelFinanceiro;
import br.com.dengodecrianca.util.Mensagem;

@ManagedBean(name = "MBRespFin")
@ViewScoped
public class RespFinBean {
	private ListDataModel<ResponsavelFinanceiro> item;
	private ResponsavelFinanceiro respFin;

	public ListDataModel<ResponsavelFinanceiro> getItem() {
		return item;
	}

	public void setItem(ListDataModel<ResponsavelFinanceiro> item) {
		this.item = item;
	}
	
	public ResponsavelFinanceiro getRespFin() {
		return respFin;
	}

	public void setRespFin(ResponsavelFinanceiro respFin) {
		this.respFin = respFin;
	}

	@PostConstruct
	public void ListarRespFin() {
		ResponsavelFinanceiroDAO respDAO = new ResponsavelFinanceiroDAO();
		
		try {
			ArrayList<ResponsavelFinanceiro> lista = respDAO.listarResponsavelFinanceiro();
			item = new ListDataModel<ResponsavelFinanceiro>(lista);
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
			ArrayList<ResponsavelFinanceiro> lista = respDAO.listarResponsavelFinanceiro();
			item = new ListDataModel<ResponsavelFinanceiro>(lista);
		} catch (SQLException e) {
			Mensagem.addMessageError("Erro ao salvar novo Responsável!");
			Mensagem.addMessageError(e.getMessage());
			e.printStackTrace();
		}
	}

}
