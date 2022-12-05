import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ControlExtensions.Angular.Slider;
import foundation.TestBase;

public class SliderPageTests extends TestBase {
	
	SliderPage page;
	Slider slider;

	@BeforeMethod
	public void setUp() {
		page = new SliderPage(this.driver).navigate();
	}

	@Test
	public void ensureSliderisOn80() {
		this.slider = page.getSlider();

		var expectedResult = "80";

		this.slider.setValue("80");
		var actualResult = this.slider.getValue();

		assertEquals(actualResult, expectedResult, "Value expected is 80.");
	}

	@Test
	public void ensureSliderisOn17() {
		this.slider = page.getSlider();

		var expectedResult = "17";

		this.slider.setValue("17");
		var actualResult = this.slider.getValue();

		assertEquals(actualResult, expectedResult, "Value expected is 17.");
	}

	@Test
	public void ensureSliderisOn0() {
		this.slider = page.getSlider();

		var expectedResult = "0";

		this.slider.setValue("0");
		var actualResult = this.slider.getValue();

		assertEquals(actualResult, expectedResult, "Value expected is 0.");
	}

	@Test
	public void ensureSliderisOn100() {
		this.slider = page.getSlider();

		var expectedResult = "100";

		this.slider.setValue("100");
		var actualResult = this.slider.getValue();

		assertEquals(actualResult, expectedResult, "Value expected is 100.");
	}
}
