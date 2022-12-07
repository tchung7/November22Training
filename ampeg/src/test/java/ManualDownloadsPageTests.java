import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

public class ManualDownloadsPageTests extends AmpegTests {
	
	@Test
	public void ensurev4BManualpdfLoads() {
		
		var actualResult = new HomePage(this.driver)
				.clickSupportLink()
				.clickCurrentManualsLink()
				.clickv4B()
				.clickEnglishQuickStartGuide()
				.getFileEmbed();
		
		
		var expectedResult = this.driver.findElement(By.tagName("embed")).getAttribute("name");
	
		assertEquals(actualResult, expectedResult, "Manual for V-4B Product should load.");
	}
}
