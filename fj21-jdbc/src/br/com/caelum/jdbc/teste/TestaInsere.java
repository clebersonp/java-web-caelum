package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaInsere {
	
	public static void main(String[] args) {
		
		Contato cleberson = new Contato();
		cleberson.setNome("Cleberson");
		cleberson.setEndereco("Rua das Hortências, 785");
		cleberson.setEmail("cleberson@gmail.com");
		
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.set(1985, 2, 2);
		
		cleberson.setDataNascimento(dataNascimento);
		
		ContatoDao contatoDao = new ContatoDao();
		contatoDao.adicionar(cleberson);
		
	}
	
}
