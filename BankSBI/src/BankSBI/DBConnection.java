package BankSBI;

import java.sql.*;

public class DBConnection {
	private static final String url="jdbc:mysql://localhost/jdbc";
	private static final String name="root";
	private static final String password="Revenge@2700";
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, name, password);
	}
}
