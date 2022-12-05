package ControlExtensions.Angular;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

public class OldStyleMenu extends ControlExtension implements ControlExtensions.OldStyleMenu {

	List<String> options = new ArrayList<>();
	String value;

	public OldStyleMenu(WebElement mappedElement) {
		super(mappedElement);
	}

	@Override
	public void setValue(String value) {
		Select menu = new Select(this.mappedElement);
		try {
			menu.selectByVisibleText("Black");
			;
			throw new NoSuchElementException();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

		this.value = menu.getFirstSelectedOption().getText();
	}

	@Override
	public String getValue() {
		return this.value;
	}

	@Override
	public String[] getAllOptions() {
		Select menu = new Select(this.mappedElement);
		try {
			for (WebElement option : menu.getOptions()) {
				options.add(option.getText());
			}
			if (options == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			System.out.println("Options were unsucessfully collected.");
		}
		return options.toArray(new String[options.size()]);
	}
}
