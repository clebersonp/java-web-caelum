package br.com.caelum.tarefas.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// interceptor no spring funciona como um filtro no servlet
// precisamos registrar esse interceptor no spring-context.xml
public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	// sera executado antes da acao do controller
	// o return true e igual ao chain.doFilter(request, response) ou seja, continuar e toca o barco
	// o return false nao continua as requisicoes
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// verificar as uri
		final String uri = request.getRequestURI();
		
		// se não for nenhuma dessas acoes deixa continuar
		if (uri.endsWith("loginForm") ||
				uri.endsWith("efetuaLogin") ||
					uri.contains("/resources/")) {
			return true;
		}
		
		
		// valida se o usuario esta logado pela session
		if (request.getSession().getAttribute("usuario") != null) {
			return true;
		}
		
		// senao ira para a tela de login
		response.sendRedirect("loginForm");
		return false;
		
	}
	
	// sera executado apos a acao da controller, na volta
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
	
	// sera executado apos processar o jsp
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
	
}
