package br.com.dengodecrianca.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.dengodecrianca.conexao.ConnectionFactory;
import br.com.dengodecrianca.dominio.ResponsavelFinanceiro;

public class ResponsavelFinanceiroDAO {
	public void salvarNovoRespFin(ResponsavelFinanceiro responsavel) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append(" insert into resp_financeiro ");
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
	
	public void excluirRespFinanceiro(ResponsavelFinanceiro responsavel) throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" update resp_financeiro ");
		sql.append(" set coativo = 'I' ");
		sql.append(" where cpf = ? ");
		
		Connection con = ConnectionFactory.conectar();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, responsavel.getCpf());
		
		int i = pstmt.executeUpdate();
		
		if (i > 0) {
			System.out.println("Responsável financeiro excluído com sucesso!");
		} else {
			System.out.println("Falha na remoção do responsável financeiro!");
		}
	}
	
	public ResponsavelFinanceiro buscarRespFinanceiro(ResponsavelFinanceiro responsavel) throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select nome, rg, endereco, telefone, email, mensalidade, coativo ");
		sql.append(" from resp_financeiro where cpf = ? ");
		
		Connection con = ConnectionFactory.conectar();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, responsavel.getCpf());
		
		ResultSet rs = pstmt.executeQuery();
		ResponsavelFinanceiro retorno = null;
		
		if (rs.next()) {
			retorno = new ResponsavelFinanceiro();
			
			String nome = rs.getString("nome");
			String rg = rs.getString("rg");
			String endereco = rs.getString("endereco");
			String telefone = rs.getString("telefone");
			String email = rs.getString("email");
			BigDecimal mensalidade = rs.getBigDecimal("mensalidade");
			String coAtivo = rs.getString("coativo");
			
			retorno.setNome(nome);
			retorno.setRg(rg);
			retorno.setEndereco(endereco);
			retorno.setTelefone(telefone);
			retorno.setEmail(email);
			retorno.setMensalidade(mensalidade);
			retorno.setCoAtivo(coAtivo);			
		}
		return retorno;
	}
	
	public ArrayList<ResponsavelFinanceiro> listarResponsavelFinanceiro() throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select nome, cpf, rg, endereco, telefone, email, mensalidade, coativo ");
		sql.append(" from resp_financeiro ");
		
		Connection con = ConnectionFactory.conectar();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		ResultSet rs = pstmt.executeQuery();
		ArrayList<ResponsavelFinanceiro> lista = new ArrayList<ResponsavelFinanceiro>();
		
		while (rs.next()) {
			ResponsavelFinanceiro responsavel = new ResponsavelFinanceiro();
			
			String nome = rs.getString("nome");
			String cpf = rs.getString("cpf");
			String rg = rs.getString("rg");
			String endereco = rs.getString("endereco");
			String telefone = rs.getString("telefone");
			String email = rs.getString("email");
			BigDecimal mensalidade = rs.getBigDecimal("mensalidade");
			String coAtivo = rs.getString("coativo");
			
			responsavel.setNome(nome);
			responsavel.setCpf(cpf);
			responsavel.setRg(rg);
			responsavel.setEndereco(endereco);
			responsavel.setTelefone(telefone);
			responsavel.setEmail(email);
			responsavel.setMensalidade(mensalidade);
			responsavel.setCoAtivo(coAtivo);
			
			lista.add(responsavel);
		}
		return lista;
	}
}
