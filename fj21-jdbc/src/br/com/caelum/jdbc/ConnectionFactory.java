package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
 
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "caelum");
		} catch (SQLException e) {
			throw new RuntimeException("Falha ao conectar com o banco de dados!!");
		}
	}
	
}
