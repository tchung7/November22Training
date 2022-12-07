import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageObject {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public ProductDirectoryPage clickProductsLink() {
		var menuLink = this.driver.findElement(By.cssSelector("a[title='Products']"));
		menuLink.click();

		return new ProductDirectoryPage(this.driver);
	}

	public SupportDirectoryPage clickSupportLink() {
		var menuLink = this.driver.findElement(By.cssSelector("a[title='Support']"));
		menuLink.click();

		return new SupportDirectoryPage(this.driver);
	}

	public AccountLoginPage clickSignInButton() {
		var userButton = this.driver.findElement(By.cssSelector("#global-topnav > ul > li.account.icon > a > span"));
		userButton.click();

		var accountLoginPageLink = this.driver.findElement(By.cssSelector("button[type='submit']"));
		accountLoginPageLink.click();

		return new AccountLoginPage(this.driver);
	}
}