import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class AccountLoginTests extends AmpegTests {
	@Test
	public void ensureLoginIsSuccessful() {
		var expectedUrl = "https://ampeg.com/account/";

		var actualUrl = new HomePage(this.driver).clickSignInButton().login("miso9", "40nlyM32kn0!")
				.getToAccountHomePage().getUrl();

		assertEquals(actualUrl, expectedUrl, "Successful Login should take you to account ");

	}
}
