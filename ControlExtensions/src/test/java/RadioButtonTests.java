import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import foundation.TestBase;

public class RadioButtonTests extends TestBase {
	
	RadioButtonsPage page;

	@BeforeMethod
	public void setUp() {
		page = new RadioButtonsPage(this.driver).navigate();
	}

	@Test
	public void ensureYesButtonIsSelected() {
		var radioGroup = page.getRadioGroup();

		var button = radioGroup.getButton("Yes");

		button.select();

		var expectedLabel = "Yes";

		var actualLabel = radioGroup.getSelected();
		assertEquals(actualLabel, expectedLabel, "Yes should be returned.");
	}

	@Test
	public void ensureImpressiveButtonIsSelected() {
		var radioGroup = page.getRadioGroup();

		var button = radioGroup.getButton("Impressive");

		button.select();

		var expectedLabel = "Impressive";

		var actualLabel = radioGroup.getSelected();
		assertEquals(actualLabel, expectedLabel, "Impressive should be returned.");
	}

	@Test
	public void ensureNoButtonIsSelected() {
		var radioGroup = page.getRadioGroup();

		var button = radioGroup.getButton("No");

		button.select();
		
		var expectedResult = "Unable to Select 'No'.";
		var actualResult = radioGroup.getSelected();
		assertEquals(actualResult, expectedResult, "No should be returned.");
	}
}