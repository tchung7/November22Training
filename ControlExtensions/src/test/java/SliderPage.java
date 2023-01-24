import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import ControlExtensions.Angular.Slider;

public class SliderPage extends PageObject {

	@FindBy(how = How.ID, using = "sliderContainer")
	private WebElement sliderElement;

	public SliderPage(WebDriver driver) {
		super(driver);
	}

	public SliderPage navigate() {
		this.driver.get("https://demoqa.com/slider");
		return this;
	}

	public Slider getSlider() {
		return new Slider(sliderElement);
	}

}
