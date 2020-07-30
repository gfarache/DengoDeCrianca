package br.com.dengodecrianca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.dengodecrianca.conexao.ConnectionFactory;
import br.com.dengodecrianca.dominio.Funcionario;

public class FuncionariosDAO {
	public void salvarNovoFuncionario(Funcionario funcionario) throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" insert into funcionarios ");
		sql.append(" (nome, rg, cpf, endereco, telefone, cargo, salario, dataadmissao ");
		
		if (funcionario.getEmail() != null && !funcionario.getEmail().equals("")) {
			sql.append(" , email ");
		}
		sql.append(" ) "); 
		sql.append(" values (?,?,?,?,?,?,?,? ");
		if (funcionario.getEmail() != null && !funcionario.getEmail().equals("")) {
			sql.append(" ,'"+funcionario.getEmail()+"' ");
		}
		sql.append(" ) ");
		
		Connection con = ConnectionFactory.conectar();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, funcionario.getNome());
		pstmt.setString(2, funcionario.getRg());
		pstmt.setString(3, funcionario.getCpf());
		pstmt.setString(4, funcionario.getEndereco());
		pstmt.setString(5, funcionario.getTelefone());
		pstmt.setString(6, funcionario.getCargo());
		pstmt.setBigDecimal(7, funcionario.getSalario());
		pstmt.setString(8, funcionario.getDataAdmissao());
		
		int i = pstmt.executeUpdate();
		
		if (i > 0) {
			System.out.println("Funcion�rio cadastrado com sucesso!");
		} else {
			System.out.println("Cadastro de funcion�rio falhou!");
		}
	}
}