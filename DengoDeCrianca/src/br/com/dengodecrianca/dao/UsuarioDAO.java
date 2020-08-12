package br.com.dengodecrianca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.dengodecrianca.conexao.ConnectionFactory;
import br.com.dengodecrianca.dominio.Usuario;

public class UsuarioDAO {
	public void salvarNovoUsuario(Usuario usuario) throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" insert into usuarios (login, cpf, senha, perfil) ");
		sql.append(" values (?,?,?,?) ");
		
		Connection con = ConnectionFactory.conectar();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, usuario.getLogin());
		pstmt.setString(2, usuario.getCpf());
		pstmt.setString(3, usuario.getSenha());
		pstmt.setString(4, usuario.getPerfil());
		
		int i = pstmt.executeUpdate();
		
		if (i > 0) {
			System.out.println("Usuário cadastrado com sucesso!");
		} else {
			System.out.println("Cadastro de Usuário falhou!");
		}
	}
	
	public void excluirUsuario(Usuario usuario) throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" update usuarios ");
		sql.append(" set coativo = 'I' ");
		sql.append(" where login = ? and cpf = ? ");
		
		Connection con = ConnectionFactory.conectar();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, usuario.getLogin());
		pstmt.setString(2, usuario.getCpf());
		
		int i = pstmt.executeUpdate();
		
		if (i > 0) {
			System.out.println("Usuário removido com sucesso!");
		} else {
			System.out.println("Falha na remoção de usuário!");
		}
	}
	
	public Usuario buscarUsuario(Usuario usuario) throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select cpf, senha, perfil, coativo ");
		sql.append(" from usuario where login = ?");
		
		Connection con = ConnectionFactory.conectar();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, usuario.getLogin());
		
		ResultSet rs = pstmt.executeQuery();
		Usuario retorno = null;
		
		if (rs.next()) {
			retorno = new Usuario();
			
			String cpf = rs.getString("cpf");
			String senha = rs.getString("senha");
			String perfil = rs.getString("perfil");
			String coAtivo = rs.getString("coativo");
			
			retorno.setCpf(cpf);
			retorno.setSenha(senha);
			retorno.setPerfil(perfil);
			retorno.setCoAtivo(coAtivo);			
		}		
		return retorno;	
	}
	
	public ArrayList<Usuario> listarUsuarios() throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select login, cpf, senha, perfil, coativo ");
		sql.append(" from usuario order by login ");
		
		Connection con = ConnectionFactory.conectar();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		ResultSet rs = pstmt.executeQuery();		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		while (rs.next()) {
			Usuario usuario = new Usuario();
			
			String login = rs.getString("login");
			String cpf = rs.getString("cpf");
			String senha = rs.getString("senha");
			String perfil = rs.getString("perfil");
			String coAtivo = rs.getString("coativo");
			
			usuario.setLogin(login);
			usuario.setCpf(cpf);
			usuario.setSenha(senha);
			usuario.setPerfil(perfil);
			usuario.setCoAtivo(coAtivo);
			
			lista.add(usuario);
		}
		return lista;
	}
}
