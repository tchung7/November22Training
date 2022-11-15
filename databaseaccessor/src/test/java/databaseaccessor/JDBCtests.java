package databaseaccessor;

import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class JDBCtests {

	private DatabaseAccessor db;

	@Test
	public void testA1() throws SQLException {
		var expectedResult = new String[] {"Ziguinchor"
, "Zhoushan", "Zhezqazghan", "Zeleznogorsk", "Zaria", "Zapopan", "Zaoyang", "Zanzibar", "Zalantun", "Yuzhou"};
		
		var actualResult = db.ExecuteSingleStringColumn("select city from city order by city desc limit 10");
		
		Assert.assertEquals(actualResult, expectedResult, "Executed Query does not match expected result");
		System.out.println(Arrays.toString(actualResult));
	}

	@Test
	public void testB3() throws SQLException {
		var expectedResult = "11.99";
		var actualResult = db.ExecuteSingleStringCell("select max(amount) from payment");
		
		Assert.assertEquals(actualResult, expectedResult, "Executed Query does not match expected result");
		System.out.println(actualResult);
	}

	@Test
	public void testC6() throws SQLException {
		var expectedResult = "Action: DARN FORRESTER; Animation: DARES PLUTO, LAWLESS VISION, OSCAR GOLD; Children: CIRCUS YOUTH; Classics: DYNAMITE TARZAN; Comedy: CONTROL ANTHEM, HATE HANDICAP, SADDLE ANTITRUST; Documentary: ADAPTATION HOLES, PELICAN COMFORTS; Drama: JACKET FRISCO, SCORPION APOLLO; Family: HOMICIDE PEACH; Games: DAZED PUNK; Horror: ACE GOLDFINGER; Music: PERSONAL LADYBUGS, RUNNER MADIGAN, TAXI KICK; New: CHINATOWN GLADIATOR, JUMANJI BLADE, RUN PACIFIC; Sci-Fi: RAGING AIRPLANE; Travel: LEATHERNECKS DWARFS, SHAWSHANK BUBBLE";
		
		var actor_id = db.setId("select actor_id from actor where first_name = \"Bob\" and last_name = \"Fawcett\"");
		var actualResult = db.ExecuteSingleStringCell("select film_info from actor_info where actor_id = " + actor_id);
		
		Assert.assertEquals(actualResult, expectedResult, "Executed Query does not match expected result");
		System.out.println(actualResult);
	}

	@Test
	public void testD7() throws SQLException {
		var expectedResult = new int[] {73,74,75,76};

		var film_id = db.setId("select film_id from film as f where f.title = 'Alien Center'");
		var actualResult = db.ExecuteSingleIntColumn("call film_in_stock(" + film_id + ", 2, @out_value)");
		
		Assert.assertEquals(actualResult, expectedResult, "Executed Query does not match expected result");
		System.out.println(Arrays.toString(actualResult));
	}

	@BeforeMethod
	public void setUp() throws SQLException {
		this.db = new DatabaseUtility();
	}

}
