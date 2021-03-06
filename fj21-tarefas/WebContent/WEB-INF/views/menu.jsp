<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu do Sistema Tarefas</title>
</head>
<body>
<h2>Página inicial da Lista de Tarefas</h2>

<%-- o usuario sera recuperado da session que setamos no controller --%>
<p>Bem vindo, ${fn:toUpperCase(usuario.login)}</p>

<%-- chamando a action novaTarefa na controller --%>
<a href="novaTarefa">Nova Tarefa</a> <br />

<%-- chamando a action listaTarefas na controller --%>
<a href="listaTarefas">Listar Tarefas</a> <br />

<%-- fazendo o logout --%>
<a href="logout">Sair do sistema</a>

</body>
</html>