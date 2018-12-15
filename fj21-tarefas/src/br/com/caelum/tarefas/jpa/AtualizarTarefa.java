package br.com.caelum.tarefas.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.modelo.Tarefa;

public class AtualizarTarefa {

	public static void main(String[] args) {
		
		Tarefa tarefa = new Tarefa();
		tarefa.setId(2L);
		tarefa.setDescricao("Alterando a descricao");
		tarefa.setDataFinalizado(Calendar.getInstance());
		tarefa.setFinalizado(true);
		
		EntityManager manager = Persistence.createEntityManagerFactory("tarefas").createEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(tarefa);
		manager.getTransaction().commit();
		
	}
	
}
