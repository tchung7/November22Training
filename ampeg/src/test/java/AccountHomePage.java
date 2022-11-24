import org.openqa.selenium.WebDriver;

public class AccountHomePage extends PageObject {

	protected AccountHomePage(WebDriver driver) {
		super(driver);
	}

	public String getUrl() {
		var url = this.driver.getCurrentUrl();
		return url;
	}
}
