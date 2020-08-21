package br.com.dengodecrianca.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.dengodecrianca.dao.ResponsavelFinanceiroDAO;
import br.com.dengodecrianca.dominio.ResponsavelFinanceiro;

@ManagedBean(name = "MBResp_Fin")
@ViewScoped
public class Resp_FinBean {
	private ListDataModel<ResponsavelFinanceiro> item;

	public ListDataModel<ResponsavelFinanceiro> getItem() {
		return item;
	}

	public void setItem(ListDataModel<ResponsavelFinanceiro> item) {
		this.item = item;
	}
	
	@PostConstruct
	public void ListarRespFin() {
		ResponsavelFinanceiroDAO respDAO = new ResponsavelFinanceiroDAO();
		
		try {
			ArrayList<ResponsavelFinanceiro> lista = respDAO.listarResponsavelFinanceiro();
			item = new ListDataModel<ResponsavelFinanceiro>(lista);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
