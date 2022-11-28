import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ManualDownloadsPageTests extends AmpegTests {
	@Test
	public void ensurev4BManualpdfLoads() {

		var actualurl = new HomePage(this.driver)
				.clickSupportLink()
				.clickCurrentManualsLink()
				.clickv4B()
				.clickEnglishQuickStartGuide();

		assertEquals(actualurl, this.driver.getCurrentUrl(), "Manual for V-4B Product should load.");
	}
}
