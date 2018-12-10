package br.com.caelum.agenda.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

// toda e qualquer requisição será executado esse filtro
@WebFilter("/*")
public class FiltroTempoDeExecucao implements Filter {


	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		//  sera executado quando entrar no filtro, inicio da requisicao
		long inicio = System.currentTimeMillis();
		
		chain.doFilter(req, resp);
		
		// sera executado quando estiver voltando da requisição, ou seja, na saida
		long fim = System.currentTimeMillis();
		String uri = ((HttpServletRequest) req).getRequestURI();
		String parametros = ((HttpServletRequest) req).getParameter("logica");
		System.out.println("Tempo da requisição de  " 
								+ uri + "?logica=" + parametros
								+ " demorou em (ms): " + (fim - inicio));
	}

	// sera executado quando o servidor parar
	@Override
	public void destroy() {
	}

	// sera executado quando o servidor iniciar
	@Override
	public void init(FilterConfig config) throws ServletException {
	}
}
