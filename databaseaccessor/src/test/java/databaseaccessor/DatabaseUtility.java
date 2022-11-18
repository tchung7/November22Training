package databaseaccessor;

import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseUtility implements DatabaseAccessor {

	private String connectionString;
	DBConnectionManager DBInstance;

	public DatabaseUtility(String connectionString) {
		this.connectionString = connectionString;
	}

	@Override
	public String[] executeSingleColumn(String sql) throws SQLException {
		var resultArray = new ArrayList<String>();
		var dataRows = execute(sql);

		for (var dataRow : dataRows) {
			resultArray.add(dataRow.getCellValue(dataRow.getColumns()[0]));
		}

		return resultArray.toArray(String[]::new);
	}

	@Override
	public String executeSingleCell(String sql) throws SQLException {
		var dataRows = execute(sql);

		var dataRow = dataRows[0];
		var firstColumn = dataRow.getColumns()[0];
		var cellValue = dataRow.getCellValue(firstColumn);

		return cellValue;
	}

	@Override
	public DataRow[] executeStoredProcedure(String storedProc, HashMap<String, String> inParameters,
			HashMap<String, String> outParameters) throws SQLException {
		var rows = new ArrayList<DataRow>();

		this.DBInstance = DBConnectionManager.getInstance(this.connectionString);

		var sql = "{call " + storedProc + " (?, ?)}";

		var statement = DBInstance.prepareCallableStatement(sql);

		inParameters.forEach((parameterName, parameterValue) -> {
			try {
				statement.setString(parameterName, parameterValue);
			} catch (SQLException e) {
				throw new RuntimeException(new Exception(e.getMessage()));
			}
		});

		outParameters.forEach((parameterName, parameterValue) -> {
			try {
				statement.registerOutParameter(parameterName, Types.NVARCHAR);
			} catch (SQLException e) {
				throw new RuntimeException(new Exception(e.getMessage()));
			}
			try {
				statement.setString(parameterName, parameterValue);
			} catch (SQLException e) {
				throw new RuntimeException(new Exception(e.getMessage()));
			}
		});

		boolean hasResults = statement.execute();

		while (hasResults) {
			var resultSet = statement.getResultSet();

			hasResults = statement.getMoreResults();
		}

		ArrayList<DataRow> result = null;

		this.DBInstance.closeConnection();

		return rows.toArray(DataRow[]::new);

	}

	@Override
	public DataRow[] execute(String sql) throws SQLException {
		var rows = new ArrayList<DataRow>();
		this.DBInstance = DBConnectionManager.getInstance(this.connectionString);

		var resultSet = DBInstance.getResultSet(sql);
		var columnCount = resultSet.getMetaData().getColumnCount();

		while (resultSet.next()) {

			var dataRow = new ResultDataRow();

			for (var column = 1; column <= columnCount; column++) {

				var columnName = resultSet.getMetaData().getColumnName(column);
				var cellValue = resultSet.getString(column);

				dataRow.addColumn(columnName);
				dataRow.setValue(columnName, cellValue);
			}

			rows.add(dataRow);
		}
		this.DBInstance.closeConnection();

		return rows.toArray(new DataRow[rows.size()]);
	}
}
