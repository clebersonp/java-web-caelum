<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>E.L Expression Language</title>
</head>
<body>
	Digite sua idade e pressione o botão:
	<br />
	
	<!-- estou invocando uma jsp. Pois toda JSP e uma servlet -->
	<form action="mostra-idade.jsp" method="post">
		Idade: <input type="text" name="idade" /> <input type="submit" />
	</form>
</body>
</html>