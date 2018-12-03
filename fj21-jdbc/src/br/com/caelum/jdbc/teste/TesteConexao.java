package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.caelum.jdbc.ConnectionFactory;

public class TesteConexao {

	public static void main(String[] args) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		System.out.println("Conexão aberta com sucesso!");
		connection.close();
	}

}
