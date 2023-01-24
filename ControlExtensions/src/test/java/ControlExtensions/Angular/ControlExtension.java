package ControlExtensions.Angular;

import java.util.List;

import org.openqa.selenium.WebElement;

public abstract class ControlExtension {

	protected WebElement mappedElement;
	protected List<WebElement> mappedElementList;

	public ControlExtension(WebElement mappedElement) {
		this.mappedElement = mappedElement;
	}

	public ControlExtension(List<WebElement> mappedElementList) {
		this.mappedElementList = mappedElementList;
	}
}