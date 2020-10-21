package br.com.dengodecrianca.dominio;

import java.math.BigDecimal;

public class Pagamento {
	
	private ResponsavelFinanceiro responsavel;
	private int mes;
	private int ano;
	private String descricao;
	private BigDecimal valor = BigDecimal.ZERO;
	private String data;
	private String hora;
	private BigDecimal multa = BigDecimal.ZERO;
	
	public ResponsavelFinanceiro getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(ResponsavelFinanceiro responsavel) {
		this.responsavel = responsavel;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public BigDecimal getMulta() {
		return multa;
	}
	public void setMulta(BigDecimal multa) {
		this.multa = multa;
	}
}
