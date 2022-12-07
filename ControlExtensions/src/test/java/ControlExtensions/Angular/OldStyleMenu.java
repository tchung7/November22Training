package ControlExtensions.Angular;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

public class OldStyleMenu extends ControlExtension implements ControlExtensions.OldStyleMenu {

	String value;

	public OldStyleMenu(WebElement mappedElement) {
		super(mappedElement);
	}

	@Override
	public void setValue(String value) {
		Select menu = new Select(this.mappedElement);
		if (isOption(value)) {
			menu.selectByVisibleText(value);
		}

		this.value = menu.getFirstSelectedOption().getText();
	}

	@Override
	public String getValue() {
		return this.value;
	}

	@Override
	public String[] getAllOptions() {
		List<String> options = new ArrayList<>();
		Select menu = new Select(this.mappedElement);
		try {
			for (WebElement option : menu.getOptions()) {
				options.add(option.getText());
			}
		} catch (NullPointerException e) {
			System.out.println("Options were unsucessfully collected.");
		}
		return options.toArray(new String[options.size()]);
	}

	public boolean isOption(String value) {
		var options = getAllOptions();
		for (String option : options) {
			if (option.equals(value)) {
				return true;
			}
		}
		return false;
	}
}
