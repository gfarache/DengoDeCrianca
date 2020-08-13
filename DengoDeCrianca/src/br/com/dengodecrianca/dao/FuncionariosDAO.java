package br.com.dengodecrianca.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.dengodecrianca.conexao.ConnectionFactory;
import br.com.dengodecrianca.dominio.Funcionario;

public class FuncionariosDAO {
	public void salvarNovoFuncionario(Funcionario funcionario) throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" insert into funcionario ");
		sql.append(" (matricula, nome, rg, cpf, sexo, datanascimento, tipo_logradouro, nome_logradouro, numero_logradouro, ");
		sql.append(" bairro_logradouro, municipio_logradouro, uf_logradouro, cep_logradouro, ");
		sql.append(" telefone, cargo, salario, dataadmissao, coativo ");
		
		if (funcionario.getEmail() != null && !funcionario.getEmail().equals("")) {
			sql.append(" , email ");
		}
		if (funcionario.getFoto() != null) {
			sql.append(" , foto");
		}
		sql.append(" ) "); 
		sql.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ");
		if (funcionario.getEmail() != null && !funcionario.getEmail().equals("")) {
			sql.append(" ,'"+funcionario.getEmail()+"' ");
		}
		if (funcionario.getFoto() != null) {
			//faltam comandos
		}
		sql.append(" ) ");
		
		Connection con = ConnectionFactory.conectar();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, funcionario.getNome());
		pstmt.setString(2, funcionario.getNome());
		pstmt.setString(3, funcionario.getRg());
		pstmt.setString(4, funcionario.getCpf());
		pstmt.setString(5, funcionario.getSexo());
		pstmt.setString(6, funcionario.getDataNascimento());
		pstmt.setString(7, funcionario.getTipo_logradouro());
		pstmt.setString(8, funcionario.getNome_logradouro());
		pstmt.setString(9, funcionario.getNumero_logradouro());
		pstmt.setString(10, funcionario.getBairro_logradouro());
		pstmt.setString(11, funcionario.getMunicipio_logradouro());
		pstmt.setString(12, funcionario.getUf_logradouro());
		pstmt.setString(13, funcionario.getCep_logradouro());
		pstmt.setString(14, funcionario.getTelefone());
		pstmt.setString(15, funcionario.getCargo());
		pstmt.setBigDecimal(16, funcionario.getSalario());
		pstmt.setString(17, funcionario.getDataAdmissao());
		pstmt.setString(18, "A");
		
		int i = pstmt.executeUpdate();
		
		if (i > 0) {
			System.out.println("Funcionário cadastrado com sucesso!");
		} else {
			System.out.println("Cadastro de funcionário falhou!");
		}
	}
	
	public void excluirFuncionario(Funcionario funcionario) throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" update funcionario ");
		sql.append(" set coativo = 'I' ");
		sql.append(" where cpf = ? ");
		
		Connection con = ConnectionFactory.conectar();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, funcionario.getCpf());		
		
		int i = pstmt.executeUpdate();
		
		if (i > 0) {
			System.out.println("Funcionário removido com sucesso!");
		} else {
			System.out.println("Remoção de funcionário falhou!");
		}
	}
	
	public Funcionario buscarFuncionario(Funcionario funcionario) throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select matricula, cpf, rg, nome, datanascimento, sexo ");
		sql.append(" endereco, telefone, email, cargo, salario, dataadmissao, datademissao, ");
		sql.append(" coativo from funcionario where matricula = ? ");
		
		Connection con = ConnectionFactory.conectar();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, funcionario.getMatricula());
		
		ResultSet rs = pstmt.executeQuery();
		Funcionario retorno = null;
		
		if (rs.next()) {
			retorno = new Funcionario();
			String matricula = rs.getString("matricula");
			String cpf = rs.getString("cpf");
			String rg = rs.getString("rg");
			String nome = rs.getString("nome");
			String dataNascimento = rs.getString("datanascimento");
			String sexo = rs.getString("sexo");
			String endereco = rs.getString("endereco");
			String telefone = rs.getString("telefone");
			String email = rs.getString("email");
			String cargo = rs.getString("cargo");
			BigDecimal salario = rs.getBigDecimal("salario");
			String dataAdmissao = rs.getString("dataadmissao");
			String dataDemissao = rs.getString("datademissao");
			String coativo = rs.getString("coativo");
			
			retorno.setMatricula(matricula);
			retorno.setCpf(cpf);
			retorno.setRg(rg);
			retorno.setNome(nome);
			retorno.setDataNascimento(dataNascimento);
			retorno.setSexo(sexo);
			retorno.setEndereco(endereco);
			retorno.setTelefone(telefone);
			retorno.setEmail(email);
			retorno.setCargo(cargo);
			retorno.setSalario(salario);
			retorno.setDataAdmissao(dataAdmissao);
			retorno.setDataDemissao(dataDemissao);
			retorno.setCoAtivo(coativo);
		}		
		return retorno;
	}
	
	public ArrayList<Funcionario> listarFuncionarios() throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select matricula, nome, cpf, rg, datanascimento, sexo, endereco, ");
		sql.append(" telefone, email, cargo, salario, dataadmissao, coativo ");
		sql.append(" from funcionario order by nome ");
		
		Connection con = ConnectionFactory.conectar();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Funcionario funcionario = new Funcionario();
			
			String matricula = rs.getString("matricula");
			String nome = rs.getString("nome");
			String cpf = rs.getString("cpf");
			String rg = rs.getString("rg");
			String dataNascimento = rs.getString("datanascimento");
			String sexo = rs.getString("sexo");
			String endereco = rs.getString("endereco");
			String telefone = rs.getString("telefone");
			String email = rs.getString("email");
			String cargo = rs.getString("cargo");
			BigDecimal salario = rs.getBigDecimal("salario");
			String dataAdmissao = rs.getString("dataadmissao");
			String coAtivo = rs.getString("coativo");
			
			funcionario.setMatricula(matricula);
			funcionario.setNome(nome);
			funcionario.setCpf(cpf);
			funcionario.setRg(rg);
			funcionario.setDataNascimento(dataNascimento);
			funcionario.setSexo(sexo);
			funcionario.setEndereco(endereco);
			funcionario.setTelefone(telefone);
			funcionario.setEmail(email);
			funcionario.setCargo(cargo);
			funcionario.setSalario(salario);
			funcionario.setDataAdmissao(dataAdmissao);
			funcionario.setCoAtivo(coAtivo);
			
			lista.add(funcionario);
		}
		
		return lista;
	}
}
