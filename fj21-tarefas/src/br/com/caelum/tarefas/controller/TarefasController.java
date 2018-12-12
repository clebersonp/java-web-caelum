package br.com.caelum.tarefas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class TarefasController {

	// mapeamento da url
	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/formulario"; // mapeamento da jsp
	}
	
	// o @Valid é para falar ao spring para passar para o hibernate validator fazer as validacoes
	// o BindingResult é para o spring mvc não lancar a exception e eu conseguir captura-la
	@RequestMapping("adicionaTarefa")
	public String adiciona(final @Valid Tarefa tarefa, BindingResult result) { // o spring se vira para fazer o binding, o campo do form tem que ser o mesmo do dominio
		
		if (result.hasFieldErrors("descricao")) { // campo do obj tarefa.descricao
			return "tarefa/formulario"; // continua na mesma pagina
		}
		
		final JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}
	
	@RequestMapping("listaTarefas") // mapeamento da url
	public String lista(final Model model) { // spring injeta um Model para passar algo para a jsp
		final JdbcTarefaDao dao = new JdbcTarefaDao();
		final List<Tarefa> tarefas = dao.lista();
		model.addAttribute("tarefas", tarefas); // semelhando ao HttpServletRequest.setAttribute
		
		return "tarefa/lista"; // retorna uma pagina jsp
	}
	
	/*@RequestMapping("adicionaTarefa")
	public ModelAndView adiciona(final Tarefa tarefa) { // o spring se vira para fazer o binding, o campo do form tem que ser o mesmo do dominio
		final JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.adiciona(tarefa);
		final ModelAndView model = new ModelAndView("tarefa/adicionada");
		model.addObject("tarefa", tarefa.getDescricao());
		return model;
	}*/
}
