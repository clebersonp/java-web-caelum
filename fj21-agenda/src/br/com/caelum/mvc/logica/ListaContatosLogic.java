package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.filtro.FiltroConexao;
import br.com.caelum.agenda.modelo.Contato;

public class ListaContatosLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// recebendo a connection do filtro
		Connection connection = (Connection) request.getAttribute(FiltroConexao.CHAVE_CONNECTION);
		List<Contato> contatos = new ContatoDao(connection).getLista();
		
		// quando queremos passar algo para o front usamos attribute
		request.setAttribute("contatos", contatos);
		
		return "/WEB-INF/jsp/lista-contatos.jsp";
	}

}
