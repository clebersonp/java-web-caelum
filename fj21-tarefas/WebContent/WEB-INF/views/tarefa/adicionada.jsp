<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tarefa Adicionada</title>
</head>
<body>
	<h2>Nova Tarefa "${tarefa.descricao}" adiciona com sucesso!!!!</h2> <br />
	
	<%-- chamando a action novaTarefa na controller --%>
	<a href="novaTarefa">Nova Tarefa</a> <br />

	<%-- chamando a action listaTarefas na controller --%>
	<a href="listaTarefas">Listar Tarefas</a> <br /> 
	
</body>
</html>