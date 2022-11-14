package databaseaccessor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtility implements DatabaseAccessor {

	private static Statement stmt;

	public DatabaseUtility() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/sakila";
		DBConnectionManager DBInstance = DBConnectionManager.getInstance(url);
		Connection conn = DBInstance.getConnection();
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	}

	@Override
	public String[] ExecuteSingleStringColumn(String sql) throws SQLException {
		String[] result = null;

		try {
			ResultSet rs = stmt.executeQuery(sql);

			result = new String[getNumofRows(rs)];

			int i = 0;
			rs.beforeFirst();

			while (rs.next()) {
				result[i] = rs.getString(1);
				i++;
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return result;
	}

	@Override
	public int[] ExecuteSingleIntColumn(String sql) throws SQLException {
		int[] result = null;
		try {
			ResultSet rs = stmt.executeQuery(sql);

			result = new int[getNumofRows(rs)];

			int i = 0;
			rs.beforeFirst();

			while (rs.next()) {
				result[i] = rs.getInt(1);
				i++;
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return result;
	}

	@Override
	public String ExecuteSingleStringCell(String sql) throws SQLException {
		String result = null;
		try {
			ResultSet rs = stmt.executeQuery(sql);

			rs.first();
			result = rs.getString(1);
		} catch (SQLException e) {
			printSQLException(e);
		}
		return result;
	}

	@Override
	public int setId(String sql) throws SQLException {
		int id = 0;

		try {
			ResultSet res = stmt.executeQuery(sql);

			res.first();
			id = res.getInt(1);
		} catch (SQLException e) {
			printSQLException(e);
		}
		return id;
	}

	public int getNumofRows(ResultSet rs) throws SQLException {
		int rowcount = 0;
		ResultSet res = rs;

		while (res.next()) {
			rowcount++;
		}
		return rowcount;
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
