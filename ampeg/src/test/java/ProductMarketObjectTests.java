import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ProductMarketObjectTests extends AmpegTests {
	@Test
	public void ensurezzZoundsProductPageLoads() {
		
		var expectedurl = "https://www.zzounds.com/item--AMPSVTH50H?siid=261454";

		var actualurl = new HomePage(this.driver)
				.clickProductsLink()
				.clickHeritageBassHeadsAndEnclosuresLink()
				.clickProductBuyNowLink()
				.getzZoundsProductListing();

		assertEquals(actualurl, expectedurl, "Retailer's Product Listing Page should load.");
	}
}