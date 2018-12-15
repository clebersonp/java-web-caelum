package br.com.caelum.tarefas.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.modelo.Tarefa;

public class AdicionaTarefa {

	public static void main(String[] args) {
		
		// crio o meu obj
		Tarefa tarefa = new Tarefa();
		tarefa.setDescricao("Outra tarefa");
		tarefa.setFinalizado(true);
		tarefa.setDataFinalizado(Calendar.getInstance());
		
		// recupero o entity manager que possui operacoes pertinentes ao banco de dados
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager em = factory.createEntityManager();
		
		// operacoes de insert, delete e update precisao de uma transacao
		em.getTransaction().begin();
		em.persist(tarefa);
		em.getTransaction().commit();
		
		System.out.println("ID da tarefa: " + tarefa.getId());
		
		// fechando meu entity manager
		em.close();
		
	}
	
}
