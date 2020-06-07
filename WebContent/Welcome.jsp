<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styleHome.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body id="home">
	<h1>Benvenuto nella Cartoleria Engim</h1>

	<form action="SpedizioniServlet">
		<div class="card text-white bg-info mb-3" style="max-width: 18rem;">
			<div class="card-header">Header</div>
			<div class="card-body">
				<h5 class="card-title">Success card title</h5>
				<p class="card-text">
					<button id="first_button" type="submit" name="ordiniSpediti"
						value="Visualizza" class="btn radius btn-dark">
						Mostra: <br>Visualizza Spedizioni
					</button>
				</p>
			</div>
		</div>
	</form>
	
	
	<form class="formStyle" action="form.jsp">
		<div class="card border-secondary mb-3" style="max-width: 18rem;">
			<div class="card-header">Header</div>
			<div class="card-body">
				<h5 class="card-title">Success card title</h5>
				<p class="card-text">
					<button id="first_button" type="submit" name="ordiniSpediti"
						value="Visualizza" class="btn radius btn-dark">
						Invia: <br>Invia Ordine
					</button>
				</p>
			</div>
		</div>
	</form>
	<br>
	
	<form class="form3" action="formCliente.jsp">
		<div class="card text-white bg-info mb-3" style="max-width: 18rem;">
			<div class="card-header">Header</div>
			<div class="card-body">
				<h5 class="card-title">Success card title</h5>
				<p class="card-text">
					<button id="first_button" type="submit" name="ordiniSpediti"
						value="Visualizza" class="btn radius btn-dark">
						Visualizza: <br>Visualizza Ordine Cliente
					</button>
				</p>
			</div>
		</div>
	</form>
	<br>












</body>
</html>