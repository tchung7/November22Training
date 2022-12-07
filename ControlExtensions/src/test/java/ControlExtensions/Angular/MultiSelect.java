package ControlExtensions.Angular;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MultiSelect extends ControlExtension implements ControlExtensions.MultiSelect {
	Select menu;
	List<String> selectedList = new ArrayList<>();

	public MultiSelect(WebElement mappedElement) {
		super(mappedElement);
	}

	@Override
	public void selectAll(String[] selectees) {
		this.menu = new Select(this.mappedElement);

		if (isSelectValid(selectees)) {
			if (this.menu.isMultiple() == true) {
				for (String optionName : selectees) {
					this.menu.selectByVisibleText(optionName);
				}
			} else {
				for (String optionName : selectees) {
					this.menu.selectByVisibleText(optionName);
					selectedList.add(this.menu.getFirstSelectedOption().getText());
				}
			}
		} else {
			throw new RuntimeException(
					selectees + "is not a valid select, be careful about capitalization and white spaces.");
		}
	}

	public void setMultiSelectSelection(String[] selection) {
		for (String name : selection) {
			mappedElement.sendKeys(name + Keys.ENTER);
		}
	}

	@Override
	public String[] getSelected() {
		if (this.menu != null) {
			if (this.menu.isMultiple()) {
				for (WebElement selected : this.menu.getAllSelectedOptions()) {
					selectedList.add(selected.getText());
				}
			}
		} else if (mappedElement.getTagName().equals("input")) {
			List<WebElement> selection = mappedElement
					.findElements(By.xpath("../../..//div[div[@class='css-12jo7m5']]"));
			for (WebElement element : selection) {
				selectedList.add(element.getText());
			}
		}
		return selectedList.toArray(new String[selectedList.size()]);
	}

	public boolean isSelectValid(String[] selectees) {
		for (String input : selectees) {
			for (WebElement option : menu.getOptions()) {
				if (input.equals(option.getText())) {
					return true;
				}
			}
		}
		return false;
	}
}
