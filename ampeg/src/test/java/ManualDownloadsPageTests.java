import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ManualDownloadsPageTests extends AmpegTests {
	@Test
	public void ensurev4BManualpdfLoads() {
		var expectedurl = "https://ampeg.com/data/6/0a020a4177de6008ae7026058/application/pdf/Quick%20Start%20Guide%20-%20English%20.pdf";

		var actualurl = new HomePage(this.driver).clickSupportLink().clickCurrentManualsLink().clickv4B()
				.clickEnglishQuickStartGuide();

		assertEquals(actualurl, expectedurl, "Manual for V-4B Product should load.");
	}
}
