package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.filtro.FiltroConexao;
import br.com.caelum.agenda.modelo.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {

	private static final long serialVersionUID = -4318901175419319634L;
	
	
	// Metodos doGet e doPost, para forcar qual o cliente usara e so implementar, o service e mais generico, funciona para os dois tipos.
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// recupera a connection que foi passada como atributo pelo filtro de conexao
		Connection connection = (Connection) req.getAttribute(FiltroConexao.CHAVE_CONNECTION);
		
		// recupera os dados digitados no form
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String dataForm = req.getParameter("dataNascimento");
		Calendar dataNascimento = this.recuperarData(dataForm, "dd/MM/yyyy");
		
		// criar um contato
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);

		// salvar no banco de dados
		ContatoDao dao = new ContatoDao(connection);
		dao.adiciona(contato);
		
		// recuperando o dispacher para seguir em frente com o request passando qual sera minha jsp processada
		RequestDispatcher rd = req.getRequestDispatcher("contato-adicionado.jsp");
		
		// pede para seguir em frente com a requisicao
		rd.forward(req, res);
		
	}
	
	private Calendar recuperarData(String data, String pattern) {
		if (data != null && pattern != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			try {
				Date date = sdf.parse(data);
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(date);
				
				return dataNascimento;
			} catch (ParseException e) {
				System.out.println("Ocorreu um erro na conversão da data");
				return null;
			}
		}
		return null;
	}

}