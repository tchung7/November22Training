package databaseaccessor;

import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.Arrays;

import org.testng.annotations.BeforeMethod;

public class JDBCtests {

	private DatabaseAccessor db;

	@Test
	public void testA1() throws SQLException {
		var result = db.ExecuteSingleStringColumn("select city from city order by city desc limit 10");
		System.out.println(Arrays.toString(result));
	}

	@Test
	public void testB3() throws SQLException {
		var result = db.ExecuteSingleStringCell("select max(amount) from payment");
		System.out.println(result);
	}

	@Test
	public void testC6() throws SQLException {
		var actor_id = db.setId("select actor_id from actor where first_name = \"Bob\" and last_name = \"Fawcett\"");
		var result = db.ExecuteSingleStringCell("select film_info from actor_info where actor_id = " + actor_id);
		System.out.println(result);
	}

	@Test
	public void testD7() throws SQLException {
		var film_id = db.setId("select film_id from film as f where f.title = 'Alien Center'");
		var result = db.ExecuteSingleIntColumn("call film_in_stock(" + film_id + ", 2, @out_value)");
		System.out.println(Arrays.toString(result));
	}

	@BeforeMethod
	public void setUp() throws SQLException {
		this.db = new DatabaseUtility();
	}

}
