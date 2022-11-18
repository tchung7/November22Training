package databaseaccessor;

import java.sql.SQLException;

import org.testng.annotations.BeforeMethod;

public abstract class DatabaseTests {
	protected SakilaQueries sakilaQueries;

	@BeforeMethod
	public void setUp() throws SQLException {
		var connectionString = "jdbc:mysql://localhost/sakila?user=root&password=40nlyM32kn0!";
		this.sakilaQueries = new SakilaQueries(new DatabaseUtility(connectionString));
	}
}
