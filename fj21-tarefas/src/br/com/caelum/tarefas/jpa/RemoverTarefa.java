package br.com.caelum.tarefas.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.modelo.Tarefa;

public class RemoverTarefa {

	public static void main(String[] args) {
		
		EntityManager manager = Persistence.createEntityManagerFactory("tarefas").createEntityManager();
		
		Tarefa tarefa = manager.find(Tarefa.class, 2L);
		
		manager.getTransaction().begin();
		manager.remove(tarefa);
		manager.getTransaction().commit();
		
	}
}
