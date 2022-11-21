package databaseaccessor;

public interface DataRow {
	String[] getColumns();
	String getCellValue(String columnName);
}
