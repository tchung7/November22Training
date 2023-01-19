import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.windows.WindowsDriver;

public abstract class AndroidAutomation {
	
	private AndroidDriver<AndroidElement> driver;
	protected AndroidApp androidApp;
	
	@BeforeTest
	public void setup() {
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.usingPort(4723);
		builder.withIPAddress("127.0.0.1");
		this.driver = launch(builder);
		this.androidApp = new AndroidApp(driver);
	}
	
	@AfterTest
	public void cleanUp() {
		kill();
	}
	
	public AndroidDriver<AndroidElement> launch(AppiumServiceBuilder builder) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("avd", "Nexus S API 33");
		capabilities.setCapability("platformName", "android");
		
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
		
		return new AndroidDriver<AndroidElement>(service, capabilities);
	}
	
	public void kill() {
		driver.quit();
	}
}
