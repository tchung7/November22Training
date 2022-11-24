import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SupportDirectoryPage extends PageObject {

	public SupportDirectoryPage(WebDriver driver) {
		super(driver);
	}

	public ManualsDirectoryPage clickCurrentManualsLink() {
		var childElement = this.driver.findElement(By.xpath("//*[contains(text(), 'CURRENT MANUALS')]"));
		var manualsLink = childElement.findElement(By.xpath("./.."));
		manualsLink.click();

		return new ManualsDirectoryPage(this.driver);
	}
}
