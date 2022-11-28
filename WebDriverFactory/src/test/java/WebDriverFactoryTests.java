import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverFactoryTests {
	private static String browser = "edge";
	DriverManager driverManager;
	WebDriver driver;
	private String baseUrl;

	@BeforeMethod
	public void beforeMethod() {
		this.baseUrl = "https://www.ampeg.com";
		this.launchDriver();
	}

	@AfterMethod
	public void afterMethod() {
		driverManager.quitDriver();
	}

	@Test
	public void launchGoogleTest() {
		driver.get("https://www.google.com");
		assertEquals(driver.getTitle(), "Google", "Google should be navigated to.");
	}

	@Test
	public void ensureWebDriverisCorrect() {
		var expectedDriver = this.driverManager.getDriver();
		assertEquals(this.driver, expectedDriver, "WebDriver should be configured for the correct browser. ");
	}

	private void launchDriver() {
		this.driverManager = DriverManagerFactory.getManager(browser);
		System.out.println(driverManager.getClass().getName());
		this.driver = driverManager.getDriver();
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.driver.manage().window().maximize();
		this.driver.navigate().to(this.baseUrl);
	}
}
