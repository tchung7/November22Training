import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class V4bManualDownloadPage extends PageObject {

	public V4bManualDownloadPage(WebDriver driver) {
		super(driver);
	}

	public String clickEnglishQuickStartGuide() {
		var childElement = this.driver.findElement(By.xpath("//*[contains(text(), 'Quick Start Guide')]"));
		var parentElement = childElement.findElement(By.xpath("./.."));
		parentElement.findElement(By.tagName("a")).click();

		return this.driver.getCurrentUrl();
	}

}
