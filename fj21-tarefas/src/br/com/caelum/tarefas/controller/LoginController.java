package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcUsuarioDao;
import br.com.caelum.tarefas.modelo.Usuario;

@Controller
public class LoginController {

	// criando o mapeamento para retornar a pagina de login, pois esta dentro de web-inf e o usuario nao acessa diretamente
	@RequestMapping("loginForm")
	public String loginForm() {
		return "formulario-login";
	}
	
	// mapeando o request do form de login
	// o spring vai injetar o usuario, de acordo com os name passados no form, tem que ter o mesmo no dos campos de usuario
	// Session sera injetada pelo Spring MVC
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {
		final JdbcUsuarioDao dao = new JdbcUsuarioDao();
		if (dao.existeUsuario(usuario)) {
			// setar o usuario na session que foi criada pelo servlet Containner
			session.setAttribute("usuario", usuario);
			
			// retornando a jsp /WEB-INF/views/menu.jsp
			return "menu";
		}
		return "redirect:loginForm";
	}
}
