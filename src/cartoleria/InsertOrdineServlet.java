package cartoleria;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertOrdineServlet")
public class InsertOrdineServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public InsertOrdineServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			java.sql.Connection currentCon;
			String query_checkCliente;
			query_checkCliente = "SELECT Count(*) FROM sef_db_test.Cartoleria_Cliente WHERE Nome=? AND Cognome=?";
			currentCon = ConnectionManager.getConnection();
			PreparedStatement ps = currentCon.prepareStatement(query_checkCliente);
			ps.setString(1, request.getParameter("nome"));
			ps.setString(2, request.getParameter("cognome"));
			System.out.println(query_checkCliente);
			ResultSet rs = ps.executeQuery();

			int numberOfRows = 0;
			if (rs.next()) {
				numberOfRows = rs.getInt(1);
				System.out.println("numberOfRows= " + numberOfRows);
			} else {
				System.out.println("error: could not get the record counts");
			}

			if (numberOfRows == 0) {
				String query_InsertCliente;
				query_InsertCliente = "INSERT INTO  sef_db_test.Cartoleria_Cliente VALUES (?,?,?,?,?,?) ";
				PreparedStatement ps2 = currentCon.prepareStatement(query_InsertCliente);
				ps2.setString(1, request.getParameter("nome"));
				ps2.setString(2, request.getParameter("cognome"));
				ps2.setString(3, request.getParameter("via"));
				ps2.setString(4, request.getParameter("citta"));
				ps2.setString(5, request.getParameter("cap"));
				ps2.setString(6, request.getParameter("paese"));
				System.out.println(query_InsertCliente);
				ps2.executeUpdate();
			}
			String query_SommaSpese;
			query_SommaSpese = "SELECT\r\n" + "TRUNCATE(SUM(PrezzoFinale),0) PrezzoFinale \r\n"
					+ "FROM sef_db_test.Cartoleria_Ordini WHERE Cognome=? AND Nome =?";
			PreparedStatement ps3 = currentCon.prepareStatement(query_SommaSpese);
			ps3.setString(1, request.getParameter("cognome"));
			ps3.setString(2, request.getParameter("nome"));
			System.out.println(query_SommaSpese);
			ResultSet ris = ps3.executeQuery();

			int scontoDaApplicare = 0;
			float spesaTotale = 0;
			float sconto;
			while (ris.next()) {
				spesaTotale=ris.getFloat(1);
				
			}
			System.out.println(spesaTotale);
			
			String query_prodottoID_prezzo;
			int codiceProdotto =0;
			float prezzoProdotto = 0;
			query_prodottoID_prezzo="Select ProdottoID,Prezzo\r\n" + 
					"FROM sef_db_test.Cartoleria_Prodotto\r\n" + 
					"WHERE NomeProdotto=?";
			PreparedStatement ps4 = currentCon.prepareStatement(query_prodottoID_prezzo);
			ps4.setString(1, request.getParameter("prodotto"));
			ResultSet risu = ps4.executeQuery();
			
			while (risu.next()) {
				codiceProdotto=risu.getInt(1);
				prezzoProdotto=risu.getFloat(2);
			
			}
			
			float spesaAttuale;
			int qta = Integer.parseInt(request.getParameter("qta"));
			spesaAttuale = prezzoProdotto* qta;
			scontoDaApplicare= calcolaSconto(spesaTotale);
			sconto = spesaAttuale*scontoDaApplicare/100;
			float prezzoFinale= spesaAttuale-sconto;

			
			String query_InsertOrdine;
			query_InsertOrdine = "INSERT INTO  sef_db_test.Cartoleria_Ordini (Cognome,Qta,ProdottoID,DataSpedizione,ScontoApplicato,PrezzoFinale,Nome) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement ps5 = currentCon.prepareStatement(query_InsertOrdine);
			
		
			
			ps5.setString(1, request.getParameter("cognome"));
			ps5.setInt(2, qta);
			ps5.setInt(3, codiceProdotto);
			ps5.setDate(4, new Date(new java.util.Date().getTime()));
			ps5.setInt(5, scontoDaApplicare);
			ps5.setFloat(6, prezzoFinale);
			ps5.setString(7, request.getParameter("nome"));
			System.out.println(query_InsertOrdine);
			ps5.executeUpdate();
			
			Ordine ultimoOrdine = new Ordine();
			ultimoOrdine.setQta(qta);
			ultimoOrdine.setScontoApplicato(scontoDaApplicare);
			ultimoOrdine.setProdottoID(codiceProdotto);
			ultimoOrdine.setCognome(request.getParameter("cognome"));
			ultimoOrdine.setNome(request.getParameter("nome"));
			ultimoOrdine.setSpesaAttuale(spesaAttuale);
			ultimoOrdine.setPrezzoFinale(prezzoFinale);
			request.setAttribute("ultimoOrdine", ultimoOrdine);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher( "/form.jsp");
			dispatcher.forward(request, response);
			
			currentCon.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	public int calcolaSconto(float spesaTot) {
		
		int scontoDaApplicare =0;
		
		if ((spesaTot >= 50) && (spesaTot <= 100)) {
			scontoDaApplicare = 5;
		}
		if ((spesaTot >= 100) && (spesaTot <= 500)) {
			scontoDaApplicare = 10;
		}
		if ((spesaTot >= 500) && (spesaTot <= 1000)) {
			scontoDaApplicare = 15;
		}
		if (spesaTot > 1000) {
			scontoDaApplicare = 20;
		}
		return scontoDaApplicare;
	}

}
