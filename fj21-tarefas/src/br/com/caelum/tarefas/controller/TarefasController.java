package br.com.caelum.tarefas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller // ja esta sendo gerenciado pelo spring
public class TarefasController {

	private JdbcTarefaDao dao;

	@Autowired // injetara pois o JdbcTarefaDao esta sendo gerenciado pelo spring atraves da annotation @Repository
	public TarefasController(JdbcTarefaDao dao) {
		this.dao = dao;
	}
	
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
		
		dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}
	
	@RequestMapping("listaTarefas") // mapeamento da url
	public String lista(final Model model) { // spring injeta um Model para passar algo para a jsp
		final List<Tarefa> tarefas = dao.lista();
		model.addAttribute("tarefas", tarefas); // semelhando ao HttpServletRequest.setAttribute
		
		return "tarefa/lista"; // retorna uma pagina jsp
	}
	
	@RequestMapping("removeTarefa")
	public String remove(final Tarefa tarefa) { // o spring mvc vai injetar a instancia tarefa, passando o valor da tela no campo id para o campo do objeto
		dao.remove(tarefa);
		return "redirect:listaTarefas"; // redirect vao ter 2 requisicoes, na primeira vai retornar um 302 status code
		// return "foward:listaTarefas"; // foward vai fazer apenas uma requisicao, parecido com o foward do requestdispatcher
	}
	
	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) {
		Tarefa tarefaDoBanco = dao.buscaPorId(id);
		
		model.addAttribute("tarefa", tarefaDoBanco);
		
		return "tarefa/mostra";
	}
	
	@RequestMapping("alteraTarefa")
	public String altera(final Tarefa tarefa) {
		dao.altera(tarefa);
		
		return "redirect:listaTarefas";
	}
	
	@ResponseBody // retorna 200 OK como default
	@RequestMapping("finalizaTarefa")
	public void finaliza(Long id) {
		dao.finaliza(id);
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
