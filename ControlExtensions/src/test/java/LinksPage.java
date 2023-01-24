import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ControlExtensions.Angular.HyperLink;

public class LinksPage extends PageObject {

	@FindBy(how = How.LINK_TEXT, using = "Created")
	private WebElement createdPageLink;

	public LinksPage(WebDriver driver) {
		super(driver);
	}

	public LinksPage navigate() {
		this.driver.get("https://demoqa.com/links");
		return this;
	}

	public HyperLink getHyperLink() {
		return new HyperLink(createdPageLink);
	}

	public String getLinkResponse() {
		WebDriverWait wait = new WebDriverWait(this.driver, 10);

		var element = wait.until(ExpectedConditions.visibilityOf(this.driver.findElement(By.id("linkResponse"))));

		return element.getText();
	}
}