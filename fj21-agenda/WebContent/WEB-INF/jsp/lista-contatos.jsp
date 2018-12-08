<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- importar a tag lib do jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista contatos</title>
</head>
<body>

<!-- importar um arquivo jsp -->
	<c:import url="cabecalho.jsp" />

	<!--  instanciando um bean com a tag jsp, já é importado em um arquivo jsp default -->
	
	<!-- agora a logica fara isso para nos e adicionara a lista de contatos como attribute da requisicao -->
<%-- 	<jsp:useBean id="dao" class="br.com.caelum.agenda.dao.ContatoDao" /> --%>

	<table border="1px solid #ccc" cellpadding="5px" cellspacing="0">
	
		<tr>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Endereço</th>
			<th>Data Nascimento</th>
			<th>Ação</th>
		</tr>
	
		<!-- percorre contatos montando as linhas da tabela -->
			<!-- nao usaremos mais dessa forma pois iremos recuperar a lista de contatos do backend pelo attribute contatos -->
<%-- 		<c:forEach var="contato" items="${dao.lista}" varStatus="status"> --%>

			<!-- o attribute contatos, configurado no request sera utilizado diretamente via expression language -->
			<c:forEach var="contato" items="${contatos}" varStatus="status">
			<tr style="background-color: ${status.index % 2 eq 0 ? '#eee' : '#fff'}">
				<td>${contato.nome}</td>

				<td>
				
					<!-- switch case -->
					<c:choose>
						<c:when test="${not empty contato.email}">
							<a href="mailto:${contato.email}">${contato.email}</a>
						</c:when>
						<c:otherwise>
							E-mail não informado
						</c:otherwise>
					</c:choose>
					
					<!--  a tag lib c nao tem else -->
					<!--
					<c:if test="${not empty contato.email}">
						<a href="mailto:${contato.email}">${contato.email}</a>
					</c:if>
					<c:if test="${empty contato.email}">
						E-mail não informado
					</c:if>
					-->
				</td>

				<td>${contato.endereco}</td>
				<td>
					<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/>
				</td>
				<td>
					<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<!-- importar o rodape jsp -->
	<c:import url="rodape.jsp" />
</body>
</html>