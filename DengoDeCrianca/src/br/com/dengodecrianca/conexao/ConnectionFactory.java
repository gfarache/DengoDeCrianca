package br.com.dengodecrianca.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String USUARIO = "root";
	private static final String SENHA = "root";
	private static final String URL = "jdbc:mysql://localhost:3306/dengodecrianca";
	
	public static Connection conectar() throws SQLException {
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}
	
	/*public static void main(String[] args) {
		try {
			Connection conexao = ConnectionFactory.conectar();
			System.out.println("Conectado com sucesso!");
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Conexão falhou!");
		}
	}*/
}
