package ControlExtensions.Angular;

import org.openqa.selenium.WebElement;

public class RadioButton extends ControlExtension implements ControlExtensions.RadioButton {

	public RadioButton(WebElement mappedElement) {
		super(mappedElement);
	}

	@Override
	public void select() {
		if (mappedElement != null) {
			this.mappedElement.click();
		}
	}
}
