package br.com.caelum.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class TarefasController {

	// mapeamento da url
	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/formulario"; // mapeamento da jsp
	}
	
	/*@RequestMapping("adicionaTarefa")
	public String adiciona(final Tarefa tarefa) { // o spring se vira para fazer o binding, o campo do form tem que ser o mesmo do dominio
		final JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}*/
	
	@RequestMapping("adicionaTarefa")
	public ModelAndView adiciona(final Tarefa tarefa) { // o spring se vira para fazer o binding, o campo do form tem que ser o mesmo do dominio
		final JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.adiciona(tarefa);
		final ModelAndView model = new ModelAndView("tarefa/adicionada");
		model.addObject("tarefa", tarefa.getDescricao());
		return model;
	}
}
