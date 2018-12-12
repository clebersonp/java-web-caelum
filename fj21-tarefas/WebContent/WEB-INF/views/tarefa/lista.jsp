<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listagem de Tarefas</title>
</head>
<body>
	<h2>Listagem de Tarefas</h2>
	<br />
	
	<table>
		<tr>
			<th>ID</th>
			<th>DESCRIÇÃO</th>
			<th>FINALIZADO</th>
			<th>DATA FINALIZAÇÃO</th>
		</tr>
		<!-- recuperando tarefas do atribute do model do controller de tarefas -->
		<c:forEach var="tarefa" items="${tarefas}">
			<tr>
				<td>${tarefa.id}</td>
				<td>${tarefa.descricao}</td>
				<td>${tarefa.finalizado ? "SIM" : "NÃO"}</td>
				<td>
					<fmt:formatDate value="${tarefa.dataFinalizado.time}" pattern="dd/MM/yyyy"/>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>