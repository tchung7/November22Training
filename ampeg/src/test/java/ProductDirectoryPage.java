import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDirectoryPage extends PageObject {

	public ProductDirectoryPage(WebDriver driver) {
		super(driver);
	}

	public ProductCategoryPage clickHeritageBassHeadsAndEnclosuresLink() {
		var productLink = this.driver
				.findElement(By.cssSelector("img[alt='Heritage Series: Bass heads & enclosures']"));
		productLink.click();

		return new ProductCategoryPage(this.driver);
	}
}
