package br.com.dengodecrianca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.dengodecrianca.conexao.ConnectionFactory;
import br.com.dengodecrianca.dominio.Aluno;

public class AlunosDAO {
	public void salvarNovoAluno(Aluno aluno) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append(" insert into aluno ");
		sql.append(" (matricula, nome, datanascimento, sexo, turno, nomemae, coativo ");

		if (aluno.getNomePai() != null && !aluno.getNomePai().equals("")) {
			sql.append(" ,nomepai ");
		}
		if (aluno.getCpf() != null && !aluno.getCpf().equals("")) {
			sql.append(" ,cpf ");
		}
		if (aluno.getRg() != null && aluno.getRg().equals("")) {
			sql.append(", rg ");
		}

		sql.append(" ) values (?,?,?,?,?,?,? ");

		if (aluno.getNomePai() != null && !aluno.getNomePai().equals("")) {
			sql.append(" , '" + aluno.getNomePai() + "' ");
		}
		if (aluno.getCpf() != null && !aluno.getCpf().equals("")) {
			sql.append(" , '" + aluno.getCpf() + "' ");
		}
		if (aluno.getRg() != null && aluno.getRg().equals("")) {
			sql.append(", '" + aluno.getRg() + "'");
		}

		Connection con = ConnectionFactory.conectar();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());

		pstmt.setString(1, aluno.getMatricula());
		pstmt.setString(2, aluno.getNome());
		pstmt.setString(3, aluno.getDatanascimento());
		pstmt.setString(4, aluno.getSexo());
		pstmt.setString(5, aluno.getTurno());
		pstmt.setString(6, aluno.getNomeMae());
		pstmt.setString(7, "A");

		int i = pstmt.executeUpdate();
		
		if (i > 0) {
			System.out.println("Aluno inserido com sucesso!");
		} else {
			System.out.println("Erro na inserção!");
		}
	}
	
	public void excluirAluno(Aluno aluno) throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" update alunos ");
		sql.append(" set coativo = 'I' ");
		sql.append(" where matricula = ? ");
		
		Connection con = ConnectionFactory.conectar();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, aluno.getMatricula());
		
		int i = pstmt.executeUpdate();
		
		if (i > 0) {
			System.out.println("Aluno removido com sucesso!");
		} else {
			System.out.println("Falha na remoção do aluno!");
		}
	}
}
