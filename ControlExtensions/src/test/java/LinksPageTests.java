import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ControlExtensions.Angular.HyperLink;
import foundation.TestBase;

public class LinksPageTests extends TestBase {

	LinksPage page;

	@BeforeMethod
	public void setUp() {
		page = new LinksPage(this.driver).navigate();
	}

	@Test
	public void doesCreatedLinkWork() {
		HyperLink hyperLink = page.getHyperLink();

		hyperLink.click();

		var expectedResult = "Link has responded with staus 201 and status text Created";

		var actualResult = page.getLinkResponse();

		assertEquals(actualResult, expectedResult, "Link Response should be as displayed.");
	}
}
