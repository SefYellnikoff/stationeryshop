package cartoleria;

import java.sql.*;
import java.util.*;

public class ConnectionManager {

	static Connection con;
	static String url;

	public static Connection getConnection() {

		try {

			String url = "jdbc:mysql://localhost:3306/sef_db_test";
			Class.forName("com.mysql.cj.jdbc.Driver");

			try {
				con = DriverManager.getConnection(url, "sefora", "sefora");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		catch (ClassNotFoundException e) {
			System.out.println(e);
		}

		return con;
	}
}