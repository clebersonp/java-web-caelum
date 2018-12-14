<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="resources/js/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listagem de Tarefas</title>
</head>
<body>
	
	<a href="novaTarefa">Criar nova tarefa</a>
	
	<h2>Listagem de Tarefas</h2>
	<br />
	
	<table>
		<tr>
			<th>ID</th>
			<th>DESCRIÇÃO</th>
			<th>FINALIZADO</th>
			<th>DATA FINALIZAÇÃO</th>
			<th>AÇÕES</th>
		</tr>
		<!-- recuperando tarefas do atribute do model do controller de tarefas -->
		<c:forEach var="tarefa" items="${tarefas}">
			<tr>
				<td>${tarefa.id}</td>
				<td>${tarefa.descricao}</td>
<%-- 					${tarefa.finalizado ? "Finalizado" : '<a href="#" onclick='finalizaAgora(${tarefa.id})'>Finaliza Agora!</a>'} --%>
				<c:if test="${tarefa.finalizado eq true}">
					<td>Finalizado</td>
				</c:if>
				
				<c:if test="${tarefa.finalizado eq false}">
					<td id="tarefa_${tarefa.id}">
						<a href="#" onclick="finalizaAgora(${tarefa.id})">
							Finaliza agora!
						</a>
					</td>
				</c:if>
				<td>
					<fmt:formatDate value="${tarefa.dataFinalizado.time}" pattern="dd/MM/yyyy"/>
				</td>
				<td>
					<a href="removeTarefa?id=${tarefa.id}">REMOVER</a> | 
					<a href="mostraTarefa?id=${tarefa.id}">ALTERAR</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<script type="text/javascript">
		function finalizaAgora(id) {
			$.post("finalizaTarefa", {'id': id}, function() { //{'id' : id} sera feito um binding. se fosse get seria ?id=id. Essa function e um callback de sucesso
				// selecionando o elemento html através da ID e alterando o HTML dele
				$("#tarefa_"+id).html("Finalizado");
			});
		};
	</script>
</body>
</html>