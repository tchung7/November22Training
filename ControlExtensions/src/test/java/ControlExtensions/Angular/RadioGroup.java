package ControlExtensions.Angular;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RadioGroup extends ControlExtension implements ControlExtensions.RadioGroup {

	List<WebElement> labels = new ArrayList<>();
	List<WebElement> inputs = new ArrayList<>();

	public RadioGroup(List<WebElement> mappedElementList) {
		super(mappedElementList);
		this.createSubContainers();
	}

	@Override
	public RadioButton getButton(String label) {
		RadioButton radioButton = null;

		for (int i = 0; i < labels.size(); i++) {
			if (labels.get(i).getText().equals(label)) {
				radioButton = new RadioButton(labels.get(i));
				break;
			}
		}
		return radioButton;
	}

	@Override
	public String getSelected() {
		boolean isSelected = false;

		for (int i = 0; i < inputs.size(); i++) {
			isSelected = inputs.get(i).isSelected();
			if (isSelected == true) {
				return labels.get(i).getText();
			}
		}
		throw new RuntimeException("'No' cannot be selected.");
	}

	public void createSubContainers() {
		for (WebElement radioButtonContainer : mappedElementList) {

			var radioButtonLabel = radioButtonContainer.findElement(By.tagName("label"));
			labels.add(radioButtonLabel);
			var radioButtonInput = radioButtonContainer.findElement(By.tagName("input"));
			inputs.add(radioButtonInput);
		}
	}
}
