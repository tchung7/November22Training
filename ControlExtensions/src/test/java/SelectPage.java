import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import ControlExtensions.Angular.MultiSelect;
import ControlExtensions.Angular.OldStyleMenu;

public class SelectPage extends PageObject {

	@FindBy(how = How.ID, using = "oldSelectMenu")
	private WebElement menuElement;

	public SelectPage(WebDriver driver) {
		super(driver);
	}

	public SelectPage navigate() {
		this.driver.get("https://demoqa.com/select-menu");
		return this;
	}

	public OldStyleMenu getSelectMenu() {
		return new OldStyleMenu(menuElement);
	}

	public MultiSelect getMultiSelect() {
		return new MultiSelect(menuElement);
	}

}
