import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProviderTests {
	@Test
	public void canGetTexasName() {
		var expectedState = "Texas";

		var actualState = States.Texas.Name;

		Assert.assertEquals(actualState, expectedState, "The state name should be returned.");
	}

	@Test
	public void canGetTexasAbbreviation() {
		var expectedStateAbbr = "TX";

		var actualStateAbbr = States.Texas.Abbr;

		Assert.assertEquals(actualStateAbbr, expectedStateAbbr, "Correct Abbreviation should be returned");
	}

	@Test
	public void canGetTexasCity() {
		var expectedCity = "Houston";

		var actualCity = Cities.Houston.Name;

		Assert.assertEquals(actualCity, expectedCity, "The City name should be returned.");
	}

	@Test
	public void canGetCaliforniaFromObjectMother() {
		var expectedState = "California";

		var actualState = getState(LocationObjectMothers.SanFrancisco());

		Assert.assertEquals(actualState.Name, expectedState, "The correst state should be returned.");
	}

	@Test
	public void canGetHawaiiName() {
		var expectedState = "Hawaii";

		var actualState = States.Hawaii.Name;

		Assert.assertEquals(actualState, expectedState, "The state name should be returned.");
	}

	@Test
	public void canGetHawaiiAbbreviation() {
		var expectedStateAbbr = "HI";

		var actualStateAbbr = States.Hawaii.Abbr;

		Assert.assertEquals(actualStateAbbr, expectedStateAbbr, "Correct Abbreviation should be returned");
	}

	@Test
	public void canGetHawaiiCity() {
		var expectedCity = "Honolulu";

		var actualCity = Cities.Honolulu.Name;

		Assert.assertEquals(actualCity, expectedCity, "The City name should be returned.");
	}

	@Test
	public void canGetTexasFromObjectMother() {
		var expectedState = "Texas";

		var actualState = getState(LocationObjectMothers.Houston());

		Assert.assertEquals(actualState.Name, expectedState, "The correst state should be returned.");
	}

	private State getState(LocationObjectMother mother) {
		return mother.State;
	}
}
