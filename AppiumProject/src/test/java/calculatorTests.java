import java.net.MalformedURLException;

import org.testng.annotations.Test;

public class calculatorTests {
	private Calculator calculator;
	
  @Test
  public void canDoBasicAddition() throws MalformedURLException {
	  driver.findElementByName("One").click();
      driver.findElementByName("Plus").click();
      driver.findElementByName("Two").click();
      driver.findElementByName("Equals").click();
      Assert.assertEquals(driver.findElementByAccessibilityId("CalculatorResults").getText(), "Display is 3");
  }
}
