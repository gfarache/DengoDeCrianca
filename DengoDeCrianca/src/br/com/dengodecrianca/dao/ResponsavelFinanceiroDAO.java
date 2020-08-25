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
		sql.append(" (nome, cpf, rg, parentesco, tipo_logradouro, nome_logradouro, numero_logradouro, ");
		sql.append(" bairro_logradouro, municipio_logradouro, uf_logradouro, cep_logradouro, ");
		sql.append(" telefone, email, mensalidade, coativo) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());

		pstmt.setString(1, responsavel.getNome());
		pstmt.setString(2, responsavel.getCpf());
		pstmt.setString(3, responsavel.getRg());
		pstmt.setString(4, responsavel.getParentesco());
		pstmt.setString(5, responsavel.getTipo_logradouro());
		pstmt.setString(6, responsavel.getNome_logradouro());
		pstmt.setString(7, responsavel.getNumero_logradouro());
		pstmt.setString(8, responsavel.getBairro_logradouro());
		pstmt.setString(9, responsavel.getMunicipio_logradouro());
		pstmt.setString(10, responsavel.getUf_logradouro());
		pstmt.setString(11, responsavel.getCep_logradouro());
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
	
	public void excluirRespFinanceiro(ResponsavelFinanceiro responsavel) throws SQLException {
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
		} else {
			System.out.println("Falha na remoção do responsável financeiro!");
		}
	}
	
	public ResponsavelFinanceiro buscarRespFinanceiro(ResponsavelFinanceiro responsavel) throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select nome, rg, tipo_logradouro, nome_logradouro, numero_logradouro, ");
		sql.append(" bairro_logradouro, municipio_logradouro, uf_logradouro, cep_logradouro, ");
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
			String tpLogradouro = rs.getString("tipo_logradouro");
			String noLogradouro = rs.getString("nome_logradouro");
			String nuLogradouro = rs.getString("numero_logradouro");
			String baLogradouro = rs.getString("bairro_logradouro");
			String muLogradouro = rs.getString("municipio_logradouro");
			String ufLogradouro = rs.getString("uf_logradouro");
			String cepLogradouro = rs.getString("cep_logradouro");
			String telefone = rs.getString("telefone");
			String email = rs.getString("email");
			BigDecimal mensalidade = rs.getBigDecimal("mensalidade");
			String coAtivo = rs.getString("coativo");
			
			retorno.setNome(nome);
			retorno.setRg(rg);
			retorno.setTipo_logradouro(tpLogradouro);
			retorno.setNome_logradouro(noLogradouro);
			retorno.setNumero_logradouro(nuLogradouro);
			retorno.setBairro_logradouro(baLogradouro);
			retorno.setMunicipio_logradouro(muLogradouro);
			retorno.setUf_logradouro(ufLogradouro);
			retorno.setCep_logradouro(cepLogradouro);
			retorno.setTelefone(telefone);
			retorno.setEmail(email);
			retorno.setMensalidade(mensalidade);
			retorno.setCoAtivo(coAtivo);			
		}
		return retorno;
	}
	
	public ArrayList<ResponsavelFinanceiro> listarResponsavelFinanceiro() throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select nome, cpf, rg, parentesco, tipo_logradouro, nome_logradouro, numero_logradouro, ");
		sql.append(" bairro_logradouro, municipio_logradouro, uf_logradouro, cep_logradouro, ");
		sql.append(" telefone, email, mensalidade, coativo from resp_financeiro ");
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
			String tpLogradouro = rs.getString("tipo_logradouro");
			String noLogradouro = rs.getString("nome_logradouro");
			String nuLogradouro = rs.getString("numero_logradouro");
			String baLogradouro = rs.getString("bairro_logradouro");
			String muLogradouro = rs.getString("municipio_logradouro");
			String ufLogradouro = rs.getString("uf_logradouro");
			String cepLogradouro = rs.getString("cep_logradouro");
			String telefone = rs.getString("telefone");
			String email = rs.getString("email");
			BigDecimal mensalidade = rs.getBigDecimal("mensalidade");
			String coAtivo = rs.getString("coativo");
			
			responsavel.setNome(nome);
			//responsavel.setCpf(Formatadores.colocaFormatoCpf(cpf));
			responsavel.setCpf(cpf);
			responsavel.setRg(rg);
			responsavel.setParentesco(parentesco);
			responsavel.setTipo_logradouro(tpLogradouro);
			responsavel.setNome_logradouro(noLogradouro);
			responsavel.setNumero_logradouro(nuLogradouro);
			responsavel.setBairro_logradouro(baLogradouro);
			responsavel.setMunicipio_logradouro(muLogradouro);
			responsavel.setUf_logradouro(ufLogradouro);
			responsavel.setCep_logradouro(cepLogradouro);
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
		r.setTipo_logradouro("Avenida");
		r.setNome_logradouro("Genebra");
		r.setNumero_logradouro("7");
		r.setBairro_logradouro("Planalto");
		r.setMunicipio_logradouro("Manaus");
		r.setUf_logradouro("AM");
		r.setCep_logradouro("69045380");
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
