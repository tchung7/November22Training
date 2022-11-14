package databaseaccessor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
	private static DBConnectionManager instance;
	private Connection conn;

	private DBConnectionManager(String url) {
		try {
			this.conn = DriverManager.getConnection(url, "root", "40nlyM32kn0!");
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Connection getConnection() {
		return this.conn;
	}

	public static DBConnectionManager getInstance(String url) throws SQLException {
		if (instance == null) {
			instance = new DBConnectionManager(url);
		} else if (instance.getConnection().isClosed()) {
			instance = new DBConnectionManager(url);
		}
		return instance;
	}

	public static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
