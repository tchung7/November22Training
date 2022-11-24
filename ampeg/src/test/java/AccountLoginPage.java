import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountLoginPage extends PageObject {

	public AccountLoginPage(WebDriver driver) {
		super(driver);
	}

	public PostLoginTools login(String user, String pwd) {
		WebElement username = driver.findElement(By.cssSelector("[id='l_email_user']"));
		WebElement password = driver.findElement(By.cssSelector("input.form-control[name='l_pass']"));

		username.sendKeys(user);
		password.sendKeys(pwd);

		var login = driver.findElement(By.cssSelector("input[value='Login']"));
		login.click();

		return new PostLoginTools(this.driver);

	}
}
