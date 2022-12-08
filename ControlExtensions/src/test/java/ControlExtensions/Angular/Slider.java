package ControlExtensions.Angular;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Slider extends ControlExtension implements ControlExtensions.Slider {

	WebElement slider = this.mappedElement.findElement(By.tagName("input"));
	WebElement sliderValue = mappedElement.findElement(By.id("sliderValue"));;

	public Slider(WebElement mappedElement) {
		super(mappedElement);
	}

	@Override
	public void setValue(String value) {
		int currentPosition = Integer.parseInt(sliderValue.getAttribute("value"));

		if (currentPosition > Integer.parseInt(value)) {
			while (!sliderValue.getAttribute("value").equals(value)) {
				this.slider.sendKeys(Keys.ARROW_LEFT);
			}
		} else if (currentPosition < Integer.parseInt(value)) {
			while (!sliderValue.getAttribute("value").equals(value)) {
				this.slider.sendKeys(Keys.ARROW_RIGHT);
			}
		}
	}

	@Override
	public String getValue() {
		return this.sliderValue.getAttribute("value");
	}
}
