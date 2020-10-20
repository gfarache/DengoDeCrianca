package br.com.dengodecrianca.bean;

import br.com.dengodecrianca.dominio.Pagamento;

public class PagamentoBean {
	
	private Pagamento pagamento = new Pagamento();

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
}
