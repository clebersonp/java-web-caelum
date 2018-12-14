package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcUsuarioDao;
import br.com.caelum.tarefas.modelo.Usuario;

@Controller // esta sendo gerenciado pelo spring
public class LoginController {

	private JdbcUsuarioDao dao;


	// boa pratica injetar algo pelo construtor
	@Autowired // sera injetado pq o JdbcUsuarioDao já esta sendo gerenciado pelo spring atraves da annotation @Repository
	public LoginController(JdbcUsuarioDao dao) {
		this.dao = dao;
	}
	
	// criando o mapeamento para retornar a pagina de login, pois esta dentro de web-inf e o usuario nao acessa diretamente
	@RequestMapping("loginForm")
	public String loginForm() {
		return "formulario-login"; // irar procurar a jsp para processar
	}
	
	// mapeando o request do form de login
	// o spring vai injetar o usuario, de acordo com os name passados no form, tem que ter o mesmo no dos campos de usuario
	// Session sera injetada pelo Spring MVC
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {
		if (dao.existeUsuario(usuario)) {
			// setar o usuario na session que foi criada pelo servlet Containner
			session.setAttribute("usuario", usuario);
			
			// retornando a jsp /WEB-INF/views/menu.jsp
			return "menu";
		}
		return "redirect:loginForm";
	}
	
	
	// Acao de logout, injetando a session para invalida-la
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginForm"; // fazendo um redirect para a acao loginForm
	}
}
