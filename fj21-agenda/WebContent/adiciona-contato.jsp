<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adiciona contato</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<link href="css/jquery.css" rel="stylesheet">
</head>
<body>
	<c:import url="cabecalho.jsp" />

	<h1>Adiciona contato</h1>
	<hr/>
	
	<!-- Url que sera mapeada pelo servlet -->
	<form action="adicionaContato" method="post">
		<label for="nome">Nome:</label>
		<input name="nome" id="nome"><br/>
		
		<label for="email">Email:</label>
		<input name="email" id="email"><br/>
		
		<label for="endereco">Endereço:</label>
		<input name="endereco" id="endereco"><br/>
		
		<label for="dataNascimento">Data Nascimento:</label>
		<caelum:campoData id="dataNascimento" />
		
		<input type="submit" value="Enviar">
	</form>
	
	<c:import url="rodape.jsp" />
</body>
</html>