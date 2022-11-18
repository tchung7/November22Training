package databaseaccessor;

import java.sql.SQLException;
import java.util.HashMap;

public interface DatabaseAccessor {
	public String[] executeSingleColumn(String sql) throws SQLException;

	public String executeSingleCell(String sql) throws SQLException;

	DataRow[] execute(String sql) throws SQLException;

	DataRow[] executeStoredProcedure(String storeProc, HashMap<String, String> inParameters,
			HashMap<String, String> outParameters) throws SQLException;
}
