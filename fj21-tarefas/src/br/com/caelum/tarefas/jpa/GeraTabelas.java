package br.com.caelum.tarefas.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeraTabelas {

	public static void main(String[] args) {
		
		// Cria uma fabrica de entity manager factory baseado no arquivo persistence.xml
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		
		factory.close();
	}
	
}
