<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="cartoleria.Ordine"%>
<!DOCTYPE html>
<html>
<head>
<script>
function validateForm(){
	
	var contr_dati = /[a-zA-Z]/;
    if(document.frm.nome.value=="" || !contr_dati.test(document.frm.nome.value))
    {
      alert("Scrivi il tuo nome");
      document.frm.nome.focus();
      
      return false;
    }
    if(document.frm.cognome.value==""|| !contr_dati.test(document.frm.cognome.value))
    {
      alert("Scrivi il tuo cognome");
      document.frm.cognome.focus();
      return false;
    }
    if(document.frm.via.value==""|| !contr_dati.test(document.frm.via.value))
    {
      alert("Scrivi la via");
      document.frm.via.focus();
      return false;
    }
    if(document.frm.citta.value==""|| !contr_dati.test(document.frm.citta.value))
    {
      alert("Scrivi la tua citta");
      document.frm.citta.focus();
      return false;
    }
    
    if(document.frm.paese.value==""|| !contr_dati.test(document.frm.paese.value))
    {
      alert("Scrivi il tuo paese");
      document.frm.paese.focus();
      return false;
    }
    if(document.frm.prodotto.value==""|| !contr_dati.test(document.frm.prodotto.value))
    {
      alert("Scrivi la quantita che vuoi acquistare");
      document.frm.prodotto.focus();
      return false;
    }
   
    
}
</script>
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
<title>Form</title>
</head>
<body>
	<form  name="frm" style="margin-top: 30px; text-align: center"action="InsertOrdineServlet" onSubmit="return validateForm()">
		<span>Nome:</span> 
		<input type="text" name="nome" /><br>
		<span>Cognome:</span>
		<input type="text" name="cognome" /> <br>
		<span>Via:</span>
		<input type="text" name="via" /><br>
		<span>Citta:</span>
		<input type="text" name="citta" /><br>
		<span>Cap:</span>
		<input type="text" name="cap" /><br>
		<span>Paese:</span>
		<input type="text" name="paese"/><br>
		<span>Nome Prodotto richiesto:</span>
		<input type="text" name="prodotto"/><br>
		<span>Quantita:</span>
		<input type="number" min="1" max="100" name="qta"/><br>
		<br> 
		 <input type="submit"value="Ordina!">
	</form>
	
	
	<%
	
	Ordine ultimoOrdine= (Ordine) request.getAttribute("ultimoOrdine");
	if(ultimoOrdine != null){
	 
	
	%>
	
	
		<span style="font-size:x-large;">Riepilogo Ordine:</span>
		<table id="ordini">
				<tr>
					<th>Nome Acquirente:</th>
					<th>Cognome Acquirente:</th>
					<th>Quantita acquistata:</th>
					<th>Codice Prodotto:</th>
					
					<th>Sconto Applicato:</th>
					<th>Prezzo Finale:</th>
					
				</tr>
				<tr>
					<td><%= ultimoOrdine.getNome()%> </td>
					<td><%= ultimoOrdine.getCognome()%> </td>
					<td><%=ultimoOrdine.getQta()%> </td>
					<td><%=ultimoOrdine.getProdottoID()%> </td>
					
					<td> <%= ultimoOrdine.getScontoApplicato()%></td>
					<td> <%= ultimoOrdine.getPrezzoFinale()%></td>
					
					
				</tr>
				
		</table>		
		<!-- SISTEMARECODICE ORDINE -->
			<%}%>	
			
			<br>	
	<a href="<%=request.getContextPath()%>/Welcome.jsp">Torna alla home</a>
	
	
</body>
</html>