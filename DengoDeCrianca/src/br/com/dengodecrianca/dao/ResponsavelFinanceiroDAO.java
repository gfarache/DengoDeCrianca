package br.com.dengodecrianca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.dengodecrianca.conexao.ConnectionFactory;
import br.com.dengodecrianca.dominio.ResponsavelFinanceiro;

public class ResponsavelFinanceiroDAO {
	public void salvarNovoRespFin(ResponsavelFinanceiro responsavel) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append(" insert into responsavelfinanceiro ");
		sql.append(" (nome, cpf, rg, endereco, telefone, email, mensalidade) ");
		sql.append(" values (?,?,?,?,?,?,?) ");
		
		Connection con = ConnectionFactory.conectar();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());

		pstmt.setString(1, responsavel.getNome());
		pstmt.setString(2, responsavel.getCpf());
		pstmt.setString(3, responsavel.getRg());
		pstmt.setString(4, responsavel.getEndereco());
		pstmt.setString(5, responsavel.getTelefone());
		pstmt.setString(6, responsavel.getEmail());
		pstmt.setBigDecimal(7, responsavel.getMensalidade());
		
		int i = pstmt.executeUpdate();
		
		if (i > 0) {
			System.out.println("Responsável financeiro inserido com sucesso!");
		} else {
			System.out.println("Erro na inserção!");
		}
	}

}
