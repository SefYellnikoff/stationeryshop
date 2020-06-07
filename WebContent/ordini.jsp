<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.LinkedList"%>
<%@ page import="java.util.List"%>
<%@ page import="cartoleria.Ordine"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>Ordini</title>
</head>
<body>

	<span style="font-size: x-large;">Ordini spediti:</span>
	<table id="ordini">
		<tr>
			<th>CodiceOrdine:</th>
			<th>Quantita Acquistata:</th>

			<th>Codice Prodotto:</th>
			<th>Nome Prodotto:</th>
			<th>Sconto Applicato:</th>
			<th>Prezzo Finale:</th>
			<th>DataSpedizione:</th>
			<th>Cognome Cliente:</th>
		</tr>





		<%
			LinkedList<Ordine> myOrdini = (LinkedList<Ordine>) request.getAttribute("recordOrdini");
			for (Ordine o : myOrdini) {
		%>




		<form method="post" action="EliminaOrdineServlet">
		<tr>
			<td><%=o.getCodiceOrdine()%><input style="display: none;"
				type="text" name="eliminato" value=<%=o.getCodiceOrdine()%>></input>
				<input type="submit" name="bl" value="Elimina"></input></td>
			<td><%=o.getQta()%></td>
			<td><%=o.getProdottoID()%></td>
			<td><%=o.getNomeProdotto()%></td>
			<td><%=o.getScontoApplicato()%></td>
			<td><%=o.getPrezzoFinale()%></td>
			<td><%=o.format(o.getDate())%></td>
			<td><%=o.getCognome()%></td>
		
		

		</tr>

		</form>






		<%
			}
		%>
	</table>
	<br>
	<a href="<%=request.getContextPath()%>/Welcome.jsp">Torna alla home</a>

</body>
</html>