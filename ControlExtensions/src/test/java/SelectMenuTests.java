import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ControlExtensions.OldStyleMenu;
import ControlExtensions.Angular.MultiSelect;
import foundation.TestBase;

public class SelectMenuTests extends TestBase {
	
	SelectPage page;

	@BeforeMethod
	public void setUp() {
		page = new SelectPage(this.driver).navigate();
	}

	@Test
	public void ensuresetMenuValueWorks() {

		OldStyleMenu menu = page.getSelectMenu();

		var expectedResult = "Black";

		menu.setValue("Black");
		var actualResult = menu.getValue();

		assertEquals(actualResult, expectedResult, "Value expected is Black.");
	}

	@Test
	public void ensureallOptionsAreCollected() {

		OldStyleMenu menu = page.getSelectMenu();

		var expectedResult = new String[] { "Red", "Blue", "Green", "Yellow", "Purple", "Black", "White", "Voilet",
				"Indigo", "Magenta", "Aqua" };

		var actualResult = menu.getAllOptions();

		assertEquals(actualResult, expectedResult, "Options in top down order should be returned.");
	}

	@Test
	public void ensureMultiSelectWorks() {

		var expectedResult = new String[] { "Red", "Voilet" };

		MultiSelect selector = page.getMultiSelect();

		selector.selectAll(expectedResult);
		var actualResult = selector.getSelected();

		assertEquals(actualResult, expectedResult, "Red and Voilet should be returned.");
	}
}
