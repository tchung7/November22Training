package ControlExtensions.Angular;

import org.openqa.selenium.WebElement;

public class HyperLink extends ControlExtension implements ControlExtensions.HyperLink {

	public HyperLink(WebElement mappedElement) {
		super(mappedElement);
	}

	@Override
	public void click() {
		this.mappedElement.click();

	}
}
