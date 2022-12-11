package ControlExtensions.Angular;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RadioGroup extends ControlExtension implements ControlExtensions.RadioGroup {

	public RadioGroup(List<WebElement> mappedElementList) {
		super(mappedElementList);
	}

	@Override
	public RadioButton getButton(String label) {
		var labels = getLabels();
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
		var labels = getLabels();
		var inputs = getInputs();
		boolean isSelected = false;

		for (int i = 0; i < inputs.size(); i++) {
			isSelected = inputs.get(i).isSelected();
			if (isSelected == true) {
				return labels.get(i).getText();
			}
		}
		throw new RuntimeException("'No' cannot be selected.");
	}

	public List<WebElement> getLabels() {
		List<WebElement> labels = new ArrayList<>();
		
		for (WebElement radioButtonContainer : mappedElementList) {
			var radioButtonLabel = radioButtonContainer.findElement(By.tagName("label"));
			labels.add(radioButtonLabel);
		}
		return labels;
	}
	
	public List<WebElement> getInputs() {
		List<WebElement> inputs = new ArrayList<>();
		
		for (WebElement radioButtonContainer : mappedElementList) {
			var radioButtonInput = radioButtonContainer.findElement(By.tagName("input"));
			inputs.add(radioButtonInput);
		}
		return inputs;
	}
}
