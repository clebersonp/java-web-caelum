<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="resources/js/jquery.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui.js"></script>
<link href="resources/css/jquery.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Altera Tarefa</title>
</head>
<body>
	<h3>Alterar tarefa - ${tarefa.id}</h3>
	<form action="alteraTarefa" method="post">
		<input type="hidden" name="id" value="${tarefa.id}">
		
		Descrição:<br />
		<textarea name="descricao" rows="5" cols="100">
		<%-- --%>${tarefa.descricao}<%-- --%>
		</textarea>
		<br />
		
		Finalizado? <input type="checkbox" name="finalizado" value="true" ${tarefa.finalizado ? 'checked' : ''} /><br />
		
		Data de finalização: <br />
		<input id="dataFinalizado" type="text" name="dataFinalizado" value="<fmt:formatDate value="${tarefa.dataFinalizado.time}" pattern="dd/MM/yyyy" />" />
		<br />
		
		<input type="submit" value="Alterar" />
	</form>
	
	<script type="text/javascript">
		$("#dataFinalizado").datepicker({dateFormat: 'dd/mm/yy'});
	</script>
</body>
</html>