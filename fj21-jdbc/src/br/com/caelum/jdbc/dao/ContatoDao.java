package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.exception.DAOException;
import br.com.caelum.jdbc.modelo.Contato;
import br.com.caelum.jdbc.util.DateUtils;

public class ContatoDao {

	private static final String FALHA_FECHAR_CONEXAO = "Falha ao fechar conexão do banco de dados!";
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
			ps.setDate(4, DateUtils.parse(contato.getDataNascimento()));
			
			ps.execute();
			ps.close();
			
		} catch (SQLException ex) {
			throw new DAOException("Falha ao adicionar o contato!");
		} finally {
			try {
				if (this.connection != null) {
					this.connection.close();
				}
			} catch (SQLException e) {
				System.out.println(FALHA_FECHAR_CONEXAO);
			}
		}
	}
	
	public List<Contato> getLista() {
		try {
			List<Contato> contatos = new ArrayList<>();
			String sql = "select * from contatos";
			
			PreparedStatement ps = this.connection.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				Contato contato = new Contato();
				contato.setId(resultSet.getLong("id"));
				contato.setNome(resultSet.getString("nome"));
				contato.setEmail(resultSet.getString("email"));

				contato.setDataNascimento(DateUtils.parse(resultSet.getDate("dataNascimento")));
				contatos.add(contato);
			}
			
			ps.close();
			resultSet.close();
			return contatos;

		} catch (SQLException ex) {
			throw new DAOException("Falha ao recuperar lista de contatos!");
		} finally {
			if (this.connection != null) {
				try {
					this.connection.close();
				} catch (SQLException e) {
					throw new DAOException(FALHA_FECHAR_CONEXAO);
				}
			}
		}
	}
}