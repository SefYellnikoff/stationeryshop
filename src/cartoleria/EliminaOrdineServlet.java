package cartoleria;

import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EliminaOrdineServlet")
public class EliminaOrdineServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EliminaOrdineServlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		try {

			java.sql.Connection currentCon;
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			String cancellaNome = request.getParameter("eliminato");
			String query_cancellaOrdine = "delete  from sef_db_test.Cartoleria_ordini where CodiceOrdine=?";
			currentCon = ConnectionManager.getConnection();
			PreparedStatement ps = currentCon.prepareStatement(query_cancellaOrdine);
			ps.setString(1, cancellaNome);
			System.out.println(query_cancellaOrdine);
			ps.executeUpdate();
			response.sendRedirect(request.getContextPath() + "/deleted.jsp");
			
			currentCon.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
