package databaseaccessor;

import java.sql.SQLException;

public interface DatabaseAccessor {
	public String[] ExecuteSingleStringColumn(String sql) throws SQLException;

	public int[] ExecuteSingleIntColumn(String sql) throws SQLException;

	public String ExecuteSingleStringCell(String sql) throws SQLException;

	public int setId(String sql) throws SQLException;
}
