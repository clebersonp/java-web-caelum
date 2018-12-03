package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {

	private Connection connection;
	
	public ContatoDao() {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void adicionar(Contato contato) {
		String sql = "insert into contatos(nome, email, endereco, dataNascimento) values (?, ?, ?, ?)";
		
		try {
			
			PreparedStatement ps = this.connection.prepareStatement(sql);
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getEmail());
			ps.setString(3, contato.getEndereco());
			ps.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			ps.execute();
			ps.close();
			
		} catch (SQLException ex) {
			throw new RuntimeException("Falha ao adicionar o contato!");
		} finally {
			try {
				if (this.connection != null) {
					this.connection.close();
				}
			} catch (SQLException e) {
				System.out.println("Falha ao fechar conexão com o banco de dados!");
			}
		}
	}
	
}