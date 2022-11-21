package databaseaccessor;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionManager {
	private static DBConnectionManager instance;
	private Connection conn;
	private Statement stmt;

	private DBConnectionManager(String connectionString) {
		try {
			this.conn = DriverManager.getConnection(connectionString);
			this.stmt = conn.createStatement();	
		} catch (SQLException e) {
			printSQLException(e);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static DBConnectionManager getInstance(String connectionString) throws SQLException {
		if (instance == null) {
			instance = new DBConnectionManager(connectionString);
		} else if (instance.getConnection().isClosed()) {
			instance = new DBConnectionManager(connectionString);
		}
		return instance;
	}

	public Connection getConnection() {
		return this.conn;
	}
	
	public CallableStatement prepareCallableStatement(String sql) {
		CallableStatement statement = null;
		try {
			statement = this.conn.prepareCall(sql);
		} catch (SQLException e) {
			printSQLException(e);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		return statement;
	}
	
	public ResultSet getResultSet(String sql) {
		ResultSet results = null;
		try {
			results = this.stmt.executeQuery(sql);
		} catch (SQLException e) {
			printSQLException(e);
		}
		return results;
	}
	
	public void closeConnection() {
		try {
			if(this.conn != null) {
				this.conn.close();
			}
		} catch(SQLException e) {
			printSQLException(e);
		}
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
