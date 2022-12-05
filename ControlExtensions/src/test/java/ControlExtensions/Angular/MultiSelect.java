package ControlExtensions.Angular;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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

		if (this.menu.isMultiple() == true) {
			try {
				for (String optionName : selectees) {
					this.menu.selectByVisibleText(optionName);
				}
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			}
		} else {
			try {
				for (String optionName : selectees) {
					this.menu.selectByVisibleText(optionName);
					selectedList.add(this.menu.getFirstSelectedOption().getText());
				}
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String[] getSelected() {
		if (this.menu.isMultiple()) {
			for (WebElement selected : this.menu.getAllSelectedOptions()) {
				selectedList.add(selected.getText());
			}
			return selectedList.toArray(new String[selectedList.size()]);
		} else {
			return selectedList.toArray(new String[selectedList.size()]);
		}
	}
}
