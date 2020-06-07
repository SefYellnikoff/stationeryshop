package cartoleria;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SpedizioniServlet")
public class SpedizioniServlet  extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SpedizioniServlet() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		
		try {
			
			java.sql.Connection currentCon;
			ResultSet rs;
			String myQuery = "SELECT *\r\n" + 
					"FROM sef_db_test.Cartoleria_prodotto\r\n" + 
					"INNER JOIN  sef_db_test.Cartoleria_ordini\r\n" + 
					"ON sef_db_test.Cartoleria_prodotto.ProdottoID =  sef_db_test.Cartoleria_ordini.ProdottoID;"; 
			currentCon = ConnectionManager.getConnection();
			Statement stmt = null;
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(myQuery);
			LinkedList<Ordine> myOrdini = new LinkedList<>();
			
			while (rs.next()) {
				
				Ordine ordine= new Ordine();
				ordine.setProdottoID(rs.getInt(1));
				ordine.setNomeProdotto(rs.getString(2));
				ordine.setProduttore(rs.getString(3));
				ordine.setPrezzoProdotto(rs.getFloat(4));
				ordine.setPeso(rs.getFloat(5));
				ordine.setCodiceOrdine(rs.getInt(6));
				ordine.setCognome(rs.getString(7));
				ordine.setQta(rs.getInt(8));
				ordine.setProdottoID(9);
				GregorianCalendar cal = new GregorianCalendar();
		        cal.setTime(rs.getDate(10));
				ordine.setDate(cal);
				ordine.setScontoApplicato(rs.getInt(11));
				ordine.setPrezzoFinale(rs.getFloat(12));
				ordine.setNome(rs.getString(13));
				myOrdini.add(ordine);
				
				
			}
			request.setAttribute("recordOrdini", myOrdini);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ordini.jsp");
			dispatcher.forward(request, response);
			currentCon.close();
		
			}catch  (Exception e){
				e.printStackTrace();
		}
			
	}
	
	

}
