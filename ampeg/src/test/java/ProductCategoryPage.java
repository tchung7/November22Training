import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductCategoryPage extends PageObject {

	public ProductCategoryPage(WebDriver driver) {
		super(driver);
	}

	public ProductMarketObject clickProductBuyNowLink() {
		var productDetailLink = this.driver.findElement(By.cssSelector("[data-product='99-26-1205']"));
		productDetailLink.click();

		return new ProductMarketObject(this.driver);
	}
}