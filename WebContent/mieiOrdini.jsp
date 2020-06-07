<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="cartoleria.Ordine"%>
<%@ page import="java.util.LinkedList"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<style>
#ordini {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 50%;
  
}

#ordini td, #ordini th {
  border: 1px solid #ff00ff;
  padding: 8px;
  justify-content:center;
  text-align:center;
}



#ordini tr:hover {background-color: pink;}

#ordini th {
  padding-top: 6px;
  padding-bottom: 6px;
  text-align: left;
  background-color: #8080ff;
  color: black;
}
</style>
<meta charset="ISO-8859-1">
<title>Miei Ordini</title>
</head>
<body>
	<span style="font-size: x-large;">Ordini effettuati:</span>
	<table id="ordini">
		<tr>
			<th>CodiceOrdine:</th>
			<th>Quantita Acquistata:</th>

			<th>Codice Prodotto:</th>

			<th>Sconto Applicato:</th>
			<th>Prezzo Finale:</th>
			<th>DataSpedizione:</th>
			<th>Cognome Cliente:</th>
		</tr>
		<%
			LinkedList<Ordine> mieiOrdini = (LinkedList<Ordine>) request.getAttribute("myOrdine");
			for (Ordine m : mieiOrdini) {
		%>

		<form method="post" action="EliminaOrdineServlet">
			<tr>
				<td><%=m.getCodiceOrdine()%><input style="display: none;"
					type="text" name="eliminato" value=<%=m.getCodiceOrdine()%>></input>
					<input type="submit" name="bl" value="Elimina"></input></td>
				<td><%=m.getQta()%></td>
				<td><%=m.getProdottoID()%></td>

				<td><%=m.getScontoApplicato()%></td>
				<td><%=m.getPrezzoFinale()%></td>
				<td><%=m.format(m.getDate())%></td>
				<td><%=m.getCognome()%></td>



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