import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import ControlExtensions.Angular.RadioGroup;

public class RadioButtonsPage extends PageObject {

	@FindBy(how = How.CSS, using = "*[class~='custom-control']")
	private List<WebElement> radioGroup;

	public RadioButtonsPage(WebDriver driver) {
		super(driver);
	}

	public RadioButtonsPage navigate() {
		this.driver.get("https://demoqa.com/radio-button");
		return this;
	}

	public RadioGroup getRadioGroup() {
		return new RadioGroup(radioGroup);
	}
}
