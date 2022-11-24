import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostLoginTools extends PageObject {

	public PostLoginTools(WebDriver driver) {
		super(driver);
	}

	public AccountHomePage getToAccountHomePage() {
		driver.navigate().to("https://ampeg.com/account/");

		return new AccountHomePage(this.driver);

	}

	public AccountPersonalInfoPage clickPersonalInfo() {
		var userButton = this.driver.findElement(By.cssSelector("#global-topnav > ul > li.account.icon > a > span"));
		userButton.click();

		var accountPersonalInfoPageLink = this.driver.findElement(By.cssSelector("a[href='/account/personalinfo/']"));
		accountPersonalInfoPageLink.click();

		return new AccountPersonalInfoPage(this.driver);
	}
}
