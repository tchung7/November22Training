import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManualsDirectoryPage extends PageObject {

	public ManualsDirectoryPage(WebDriver driver) {
		super(driver);
	}

	public V4bManualDownloadPage clickv4B() {
		var downloadPageLink = this.driver.findElement(By.cssSelector("a[alt='V-4B']"));
		downloadPageLink.click();
		return new V4bManualDownloadPage(this.driver);
	}
}
