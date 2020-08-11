package br.com.dengodecrianca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
	public void editarUsuario(Usuario usuario) throws SQLException {
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
}
