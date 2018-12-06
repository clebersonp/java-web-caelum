<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*,
					br.com.caelum.agenda.dao.ContatoDao,
					br.com.caelum.agenda.modelo.Contato,
					java.text.SimpleDateFormat"
					%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listando os Contatos</title>
</head>
<body>
	<h1>Listando Contatos</h1>
	<hr/>
	
	<%-- JSP será interpretada como uma servlet e devolve a resposta ao cliente. JSP e interpretado, nao precisa reiniciar o servidor ao alterar uma JSP --%>
	
	<table border="1px solid ">
		<tr>
			<td>Nome</td>
			<td>Email</td>
			<td>Endereço</td>
			<td>Data Nascimento</td>
		</tr>
		
		<%
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.getLista();
			
			for (Contato contato : contatos) {
				String dataNascimento = new SimpleDateFormat("dd/MM/yyyy").format(contato.getDataNascimento().getTime());
		%>
		<tr>
			<td><%= contato.getNome() %></td>
			<td><%= contato.getEmail() %></td>
			<td><%= contato.getEndereco() %></td>
			<td><%= dataNascimento %></td>
		</tr>

		<% } %>
				
	</table>
	
</body>
</html>