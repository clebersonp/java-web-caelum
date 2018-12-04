package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.ContatoDao;

public class TestaLista {

	public static void main(String[] args) {
		
		ContatoDao contatoDao = new ContatoDao();
		System.out.println(contatoDao.getLista());
	}
}