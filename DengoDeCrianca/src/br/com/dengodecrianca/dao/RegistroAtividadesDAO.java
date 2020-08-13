package br.com.dengodecrianca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.dengodecrianca.conexao.ConnectionFactory;
import br.com.dengodecrianca.dominio.RegistroAtividades;

public class RegistroAtividadesDAO {
	public void salvarNovoRegistro(RegistroAtividades registro) throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" insert into registroatividades ");
		sql.append(" login, descricao, data) ");
		sql.append(" values (?,?,?) ");
		
		Connection con = ConnectionFactory.conectar();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());

		pstmt.setString(1, registro.getLogin());
		pstmt.setString(2, registro.getDescricao());
		pstmt.setString(3, registro.getData());
		
		int i = pstmt.executeUpdate();
		
		if (i > 0) {
			System.out.println("Registro salvo com sucesso!");
		} else {
			System.out.println("Erro ao salvar registro!");
		}
	}
	
	public void checarRegistro(RegistroAtividades registro) throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" update registroatividades ");
		sql.append(" set login_ciente = ? ");
		sql.append(" where id = ? ");
		
		Connection con = ConnectionFactory.conectar();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, registro.getLogin_ciente());
		pstmt.setLong(2, registro.getID());
		
		int i = pstmt.executeUpdate();
		
		if (i > 0) {
			System.out.println("Registro de Atividades verificado com sucesso!");
		} else {
			System.out.println("Falha! Registro de Atividade não foi verificado!");
		}
	}
	
	public ArrayList<RegistroAtividades> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select id, login, login_ciente, descricao, data ");
		sql.append(" from registroatividades order by id ");
		
		Connection con = ConnectionFactory.conectar();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<RegistroAtividades> retorno = new ArrayList<RegistroAtividades>();
		
		while (rs.next()) {
			RegistroAtividades registro = new RegistroAtividades();
			
			Long id = rs.getLong("id");
			String login = rs.getString("login");
			String login_ciente = rs.getString("login_ciente");
			String descricao = rs.getString("descricao");
			String data = rs.getString("data");
			
			registro.setID(id);
			registro.setLogin(login);
			registro.setLogin_ciente(login_ciente);
			registro.setDescricao(descricao);
			registro.setData(data);
			
			retorno.add(registro);
		}
		
		return retorno;
	}
}
