<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Cliente</title>
</head>
<body>

<form method="POST" style="margin-top: 30px; text-align: center"action="VisualizzaOrdineServlet">
		<span>Nome:</span> 
		<input type="text" name="nome" /><br>
		<span>Cognome:</span>
		<input type="text" name="cognome" /> <br>
		<input type="submit" value="Visualizza">
	</form>
	<br>
	<a href="<%=request.getContextPath()%>/Welcome.jsp">Torna alla home</a>
</body>
</html>