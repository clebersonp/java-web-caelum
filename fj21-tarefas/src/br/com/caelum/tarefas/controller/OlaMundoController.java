package br.com.caelum.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// essa classe sera uma controller spring
@Controller
public class OlaMundoController {

	// mapeio as acoes com requestmapping do spring
	@RequestMapping("/olaMundoSpring")
	public String execute() {
		System.out.println("Executando a lógica com Spring MVC");
		return "ok"; // pagina que será concatenado /WEB-INF/views/ok.jsp
	}
}
