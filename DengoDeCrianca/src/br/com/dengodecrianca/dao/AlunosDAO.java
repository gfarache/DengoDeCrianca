package br.com.dengodecrianca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.dengodecrianca.conexao.ConnectionFactory;
import br.com.dengodecrianca.dominio.Aluno;

public class AlunosDAO {
	public void salvarNovoAluno(Aluno aluno) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append(" insert into aluno ");
		sql.append(" (matricula, nome, dataNascimento, sexo, turno, nomemae, coativo ");

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

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());

		pstmt.setString(1, aluno.getMatricula());
		pstmt.setString(2, aluno.getNome());
		pstmt.setString(3, aluno.getDataNascimento());
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
		
		sql.append(" update aluno ");
		sql.append(" set coativo = 'I' ");
		sql.append(" where matricula = ? ");
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, aluno.getMatricula());
		
		int i = pstmt.executeUpdate();
		
		if (i > 0) {
			System.out.println("Aluno removido com sucesso!");
		} else {
			System.out.println("Falha na remoção do aluno!");
		}
	}
	
	public Aluno buscarAluno(Aluno aluno) throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select matricula, resp_financeiro_cpf, nome, dataNascimento, ");
		sql.append(" cpf, rg, sexo, turno, nomemae, nomepai, coativo ");
		sql.append(" from aluno where matricula = ? ");
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, aluno.getMatricula());
		
		ResultSet rs = pstmt.executeQuery();
		Aluno retorno = null;
		
		if (rs.next()) {
			retorno = new Aluno();
			String matricula = rs.getString("matricula");
			String respfin_cpf = rs.getString("resp_financeiro_cpf");
			String nome = rs.getString("nome");
			String dataNascimento = rs.getString("dataNascimento");
			String cpf = rs.getString("cpf");
			String rg = rs.getString("rg");
			String sexo = rs.getString("sexo");
			String turno = rs.getString("turno");
			String nomeMae = rs.getString("nomemae");
			String nomePai = rs.getString("nomepai");
			String coativo = rs.getString("coativo");
			
			retorno.setMatricula(matricula);
			retorno.setRespfin_cpf(respfin_cpf);
			retorno.setNome(nome);
			retorno.setDataNascimento(dataNascimento);
			retorno.setCpf(cpf);
			retorno.setRg(rg);
			retorno.setSexo(sexo);
			retorno.setTurno(turno);
			retorno.setNomeMae(nomeMae);
			retorno.setNomePai(nomePai);
			retorno.setCoAtivo(coativo);
		}		
		return retorno;
	}
	
	public ArrayList<Aluno> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select matricula, resp_financeiro_cpf, nome, dataNascimento, ");
		sql.append(" cpf, rg, sexo, turno, nomemae, nomepai, coativo ");
		sql.append(" from aluno order by nome ");
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Aluno> lista = new ArrayList<Aluno>();
		
		while (rs.next()) {
			Aluno aluno = new Aluno();
			String matricula = rs.getString("matricula");
			String respfin_cpf = rs.getString("resp_financeiro_cpf");
			String nome = rs.getString("nome");
			String dataNascimento = rs.getString("dataNascimento");
			String cpf = rs.getString("cpf");
			String rg = rs.getString("rg");
			String sexo = rs.getString("sexo");
			String turno = rs.getString("turno");
			String nomeMae = rs.getString("nomemae");
			String nomePai = rs.getString("nomepai");
			String coativo = rs.getString("coativo");
			
			aluno.setMatricula(matricula);
			aluno.setRespfin_cpf(respfin_cpf);
			aluno.setNome(nome);
			aluno.setDataNascimento(dataNascimento);
			aluno.setCpf(cpf);
			aluno.setRg(rg);
			aluno.setSexo(sexo);
			aluno.setTurno(turno);
			aluno.setNomeMae(nomeMae);
			aluno.setNomePai(nomePai);
			aluno.setCoAtivo(coativo);
			
			lista.add(aluno);
		}
		return lista;		
	}
}
