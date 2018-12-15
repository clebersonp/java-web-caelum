package br.com.caelum.tarefas.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.caelum.tarefas.modelo.Tarefa;

public class BuscaTarefa {

	public static void main(String[] args) {
		
		
		EntityManager manager = Persistence.createEntityManagerFactory("tarefas").createEntityManager();
		
		Query query = manager.createQuery("select t from Tarefa as t where t.finalizado = :paramFinalizado");
		query.setParameter("paramFinalizado", true);
		
		List<Tarefa> resultList = query.getResultList();
		
		resultList.forEach(System.out::println);
		
		manager.close();
	}
}
