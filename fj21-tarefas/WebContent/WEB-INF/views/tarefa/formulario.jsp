<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adiciona Tarefa</title>
</head>
<body>
	<form action="adicionaTarefa" method="post">
		Descrição: <br/>
		
		<!--
		taglib do spring para recuperar a msg de erro do BindingResult do controller.
		Recupero o erro de um campo especifico do obj tarefa.
	-->
	<form:errors path="tarefa.descricao" cssStyle="color: red;" /> <br />
		
		<textarea rows="5" cols="100" name="descricao"></textarea><br/>
		<input type="submit" value="Adicionar">
	</form>
</body>
</html>