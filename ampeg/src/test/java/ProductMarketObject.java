import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductMarketObject extends PageObject {

	public ProductMarketObject(WebDriver driver) {
		super(driver);
	}

	public String getzZoundsProductListing() {
		String originalWindow = this.driver.getWindowHandle();
		var parentElement = this.driver
				.findElement(By.cssSelector("div[data-cid='7ff9478b-2905-4ebb-a5d5-d75fbe318749']"));
		parentElement.findElement(By.linkText("Buy Now")).click();

		WebDriverWait wait = new WebDriverWait(this.driver, 10);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		for (String windowHandle : this.driver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				this.driver.switchTo().window(windowHandle);
				break;
			}
		}

		var retailerUrl = this.driver.getCurrentUrl();

		return retailerUrl;
	}
}