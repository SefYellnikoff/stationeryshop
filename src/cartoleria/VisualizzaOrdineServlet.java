package cartoleria;

import java.io.PrintWriter;
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

@WebServlet("/VisualizzaOrdineServlet")
public class VisualizzaOrdineServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public VisualizzaOrdineServlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		try {

			java.sql.Connection currentCon;
			String nomeCliente = request.getParameter("nome");
			String	cognomeCliente = request.getParameter("cognome");
			String query_VisualizzaOrdine = "SELECT *\r\n" + 
					"FROM sef_db_test.Cartoleria_Ordini where Nome=? AND Cognome=?";
			currentCon = ConnectionManager.getConnection();
			PreparedStatement ps = currentCon.prepareStatement(query_VisualizzaOrdine);
			ps.setString(1,nomeCliente);
			ps.setString(2,cognomeCliente);
			System.out.println(query_VisualizzaOrdine);
			ResultSet rs =ps.executeQuery();
			
			LinkedList<Ordine> mieiOrdini = new LinkedList<>();
			
			while (rs.next()) {// 
				Ordine myordine= new Ordine();
				myordine.setCodiceOrdine(rs.getInt(1));
				myordine.setCognome(rs.getString(2));
				myordine.setQta(rs.getInt(3));
				myordine.setProdottoID(4);
				GregorianCalendar cal = new GregorianCalendar();
		        cal.setTime(rs.getDate(5));
		        myordine.setDate(cal);
		        myordine.setScontoApplicato(rs.getInt(6));
		        myordine.setPrezzoFinale(rs.getFloat(7));
		        myordine.setNome(rs.getString(8));
		        mieiOrdini.add(myordine);
				
			}
			
			
			
			request.setAttribute("myOrdine", mieiOrdini);
			RequestDispatcher dispatcher = request.getRequestDispatcher( "/mieiOrdini.jsp");
			dispatcher.forward(request, response);
			
			currentCon.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
