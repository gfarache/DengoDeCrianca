package br.com.dengodecrianca.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.dengodecrianca.conexao.ConnectionFactory;
import br.com.dengodecrianca.dominio.ResponsavelFinanceiro;
//import br.com.dengodecrianca.util.Formatadores;

public class ResponsavelFinanceiroDAO {
	public boolean salvarNovoRespFin(ResponsavelFinanceiro responsavel) throws SQLException {
		boolean result = false;
		StringBuilder sql = new StringBuilder();

		sql.append(" insert into resp_financeiro ");
		sql.append(" (nome, cpf, rg, parentesco, endereco, numero, bairro, ");
		sql.append(" complemento, municipio, uf, cep, telefone, email, ");
		sql.append(" mensalidade, coativo) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());

		pstmt.setString(1, responsavel.getNome());
		pstmt.setString(2, responsavel.getCpf());
		pstmt.setString(3, responsavel.getRg());
		pstmt.setString(4, responsavel.getParentesco());
		pstmt.setString(5, responsavel.getEndereco());
		pstmt.setString(6, responsavel.getNumero());
		pstmt.setString(7, responsavel.getBairro());
		pstmt.setString(8, responsavel.getComplemento());
		pstmt.setString(9, responsavel.getMunicipio());
		pstmt.setString(10, responsavel.getUf());
		pstmt.setString(11, responsavel.getCep());
		pstmt.setString(12, responsavel.getTelefone());
		pstmt.setString(13, responsavel.getEmail());
		pstmt.setBigDecimal(14, responsavel.getMensalidade());
		pstmt.setString(15, responsavel.getCoAtivo());
		
		int i = pstmt.executeUpdate();
		
		if (i > 0) {
			System.out.println("Responsável financeiro inserido com sucesso!");
			result = true;
		} else {
			System.out.println("Erro na inserção!");
			result = false;
		}
		return result;
	}
	
	public boolean excluirRespFinanceiro(ResponsavelFinanceiro responsavel) throws SQLException {
		boolean result = false;
		StringBuilder sql = new StringBuilder();
		
		sql.append(" update resp_financeiro ");
		sql.append(" set coativo = 'I' ");
		sql.append(" where cpf = ? ");
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, responsavel.getCpf());
		
		int i = pstmt.executeUpdate();
		
		if (i > 0) {
			System.out.println("Responsável financeiro excluído com sucesso!");
			result = true;
		} else {
			System.out.println("Falha na remoção do responsável financeiro!");
			result = false;
		}
		return result;
	}
	
	public boolean editarRespFinanceiro(ResponsavelFinanceiro responsavel) throws SQLException {
		boolean result = false;
		StringBuilder sql = new StringBuilder();
		
		sql.append(" update resp_financeiro ");
		sql.append(" set cpf = ?, parentesco = ?, nome = ?, rg = ?, ");
		sql.append(" endereco = ?, numero = ?, bairro = ?, ");
		sql.append(" complemento = ?, municipio = ?, uf = ?, ");
		sql.append(" cep = ?, telefone = ?, email = ?, mensalidade = ? ");
		sql.append(" where cpf = ? ");
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, responsavel.getCpf());
		pstmt.setString(2, responsavel.getParentesco());
		pstmt.setString(3, responsavel.getNome());
		pstmt.setString(4, responsavel.getRg());
		pstmt.setString(5, responsavel.getEndereco());
		pstmt.setString(6, responsavel.getNumero());
		pstmt.setString(7, responsavel.getBairro());
		pstmt.setString(8, responsavel.getComplemento());
		pstmt.setString(9, responsavel.getMunicipio());
		pstmt.setString(10, responsavel.getUf());
		pstmt.setString(11, responsavel.getCep());
		pstmt.setString(12, responsavel.getTelefone());
		pstmt.setString(13, responsavel.getEmail());
		pstmt.setBigDecimal(14, responsavel.getMensalidade());
		pstmt.setString(15, responsavel.getCpf());
		
		int i = pstmt.executeUpdate();
		
		if (i > 0) {
			System.out.println("Responsável financeiro editado com sucesso!");
			result = true;
		} else {
			System.out.println("Falha na edição do responsável financeiro!");
			result = false;
		}
		return result;
	}
	
	public ResponsavelFinanceiro buscarRespFinanceiro(ResponsavelFinanceiro responsavel) throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select nome, rg, endereco, numero, bairro, ");
		sql.append(" complemento, municipio, uf, cep, ");
		sql.append(" telefone, email, mensalidade, coativo ");
		sql.append(" from resp_financeiro where cpf = ? ");
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, responsavel.getCpf());
		
		ResultSet rs = pstmt.executeQuery();
		ResponsavelFinanceiro retorno = null;
		
		if (rs.next()) {
			retorno = new ResponsavelFinanceiro();
			
			String nome = rs.getString("nome");
			String rg = rs.getString("rg");
			String endereco = rs.getString("endereco");
			String numero = rs.getString("numero");
			String bairro = rs.getString("bairro");
			String complemento = rs.getString("complemento");
			String municipio = rs.getString("municipio");
			String uf = rs.getString("uf");
			String cep = rs.getString("cep");
			String telefone = rs.getString("telefone");
			String email = rs.getString("email");
			BigDecimal mensalidade = rs.getBigDecimal("mensalidade");
			String coAtivo = rs.getString("coativo");
			
			retorno.setNome(nome);
			retorno.setRg(rg);
			retorno.setEndereco(endereco);
			retorno.setNumero(numero);
			retorno.setBairro(bairro);
			retorno.setComplemento(complemento);
			retorno.setMunicipio(municipio);
			retorno.setUf(uf);
			retorno.setCep(cep);
			retorno.setTelefone(telefone);
			retorno.setEmail(email);
			retorno.setMensalidade(mensalidade);
			retorno.setCoAtivo(coAtivo);			
		}
		return retorno;
	}
	
	public ArrayList<ResponsavelFinanceiro> listarResponsavelFinanceiro() throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select nome, cpf, rg, parentesco, endereco, numero, bairro, ");
		sql.append(" complemento, municipio, uf, cep, telefone, email, ");
		sql.append(" mensalidade, coativo from resp_financeiro where coativo = 'A' ");
		sql.append(" order by nome "); 
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		ResultSet rs = pstmt.executeQuery();
		ArrayList<ResponsavelFinanceiro> lista = new ArrayList<ResponsavelFinanceiro>();
		
		while (rs.next()) {
			ResponsavelFinanceiro responsavel = new ResponsavelFinanceiro();
			
			String nome = rs.getString("nome");
			String cpf = rs.getString("cpf");
			String rg = rs.getString("rg");
			String parentesco = rs.getString("parentesco");
			String endereco = rs.getString("endereco");
			String numero = rs.getString("numero");
			String bairro = rs.getString("bairro");
			String complemento = rs.getString("complemento");
			String municipio = rs.getString("municipio");
			String uf = rs.getString("uf");
			String cep = rs.getString("cep");
			String telefone = rs.getString("telefone");
			String email = rs.getString("email");
			BigDecimal mensalidade = rs.getBigDecimal("mensalidade");
			String coAtivo = rs.getString("coativo");
			
			responsavel.setNome(nome);
			//responsavel.setCpf(Formatadores.colocaFormatoCpf(cpf));
			responsavel.setCpf(cpf);
			responsavel.setRg(rg);
			responsavel.setParentesco(parentesco);
			responsavel.setEndereco(endereco);
			responsavel.setNumero(numero);
			responsavel.setBairro(bairro);
			responsavel.setComplemento(complemento);
			responsavel.setMunicipio(municipio);
			responsavel.setUf(uf);
			responsavel.setCep(cep);
			responsavel.setTelefone(telefone);
			responsavel.setEmail(email);
			responsavel.setMensalidade(mensalidade);
			responsavel.setCoAtivo(coAtivo);
			
			lista.add(responsavel);
		}
		return lista;
	}
	
	public static void main(String[] args) {
		ResponsavelFinanceiro r = new ResponsavelFinanceiro();
		ResponsavelFinanceiroDAO dao = new ResponsavelFinanceiroDAO();
		
		r.setNome("Gustavo Farache");
		r.setCpf("77453816220");
		r.setRg("1476993-0 SSP/AM");
		r.setParentesco("Pai");
		r.setEndereco("Avenida Genebra");
		r.setNumero("7");
		r.setBairro("Planalto");
		r.setComplemento("Quadra 12");
		r.setMunicipio("Manaus");
		r.setUf("AM");
		r.setCep("69045380");
		r.setTelefone("92-98223-0453");
		r.setEmail("gfarache@gmail.com");
		r.setMensalidade(BigDecimal.valueOf(800.00));
		r.setCoAtivo("A");
		
		try {
			dao.salvarNovoRespFin(r);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
