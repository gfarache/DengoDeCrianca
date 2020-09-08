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
		
		sql.append(" insert into usuarios (login, senha, perfil, coativo, funcionario_matricula) ");
		sql.append(" values (?,?,?,?) ");
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, usuario.getLogin());
		pstmt.setString(2, usuario.getSenha());
		pstmt.setString(3, usuario.getPerfil());
		pstmt.setString(4, usuario.getCoativo());
		pstmt.setObject(5, usuario.getMatricula());
		
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
		sql.append(" where login = ? ");
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, usuario.getLogin());
		
		int i = pstmt.executeUpdate();
		
		if (i > 0) {
			System.out.println("Usuário removido com sucesso!");
		} else {
			System.out.println("Falha na remoção de usuário!");
		}
	}
	
	public Usuario usuarioLogin(String login) throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select login, senha, perfil, funcionario_matricula ");
		sql.append(" from usuario where login = ? and coativo = 'A' ");
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, login);
		
		ResultSet rs = pstmt.executeQuery();
		Usuario retorno = null;
		
		if (rs.next()) {
			retorno = new Usuario();
			
			String loginBanco = rs.getString("login");
			String senhaBanco = rs.getString("senha");
			String perfil = rs.getString("perfil");
			String funcMatricula = rs.getString("funcionario_matricula");
			
			retorno.setLogin(loginBanco);
			retorno.setSenha(senhaBanco);
			retorno.setPerfil(perfil);
			retorno.setMatricula(funcMatricula);
		}		
		return retorno;	
	}
	
	public Usuario buscarUsuario(Usuario usuario) throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select login, senha, perfil, coativo, funcionario_matricula ");
		sql.append(" from usuario where login = ?");
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, usuario.getLogin());
		
		ResultSet rs = pstmt.executeQuery();
		Usuario retorno = null;
		
		if (rs.next()) {
			retorno = new Usuario();
			
			String login = rs.getString("login");
			String senha = rs.getString("senha");
			String perfil = rs.getString("perfil");
			String coAtivo = rs.getString("coativo");
			
			retorno.setSenha(login);
			retorno.setSenha(senha);
			retorno.setPerfil(perfil);
			retorno.setCoativo(coAtivo);			
		}		
		return retorno;	
	}
	
	public ArrayList<Usuario> listarUsuarios() throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select login, senha, perfil, coativo, funcionario_matricula ");
		sql.append(" from usuario order by login ");
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		ResultSet rs = pstmt.executeQuery();		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		while (rs.next()) {
			Usuario usuario = new Usuario();
			
			String login = rs.getString("login");
			String senha = rs.getString("senha");
			String perfil = rs.getString("perfil");
			String coativo = rs.getString("coativo");
			String matricula = rs.getString("funcionario_matricula");
			
			usuario.setLogin(login);
			usuario.setSenha(senha);
			usuario.setPerfil(perfil);
			usuario.setCoativo(coativo);
			usuario.setMatricula(matricula);
			
			lista.add(usuario);
		}
		return lista;
	}
}
