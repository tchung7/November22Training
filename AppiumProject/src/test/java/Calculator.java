import java.util.HashMap;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.windows.WindowsDriver;

public class Calculator {
	
	private WindowsDriver<WebElement> driver;
	private AppiumServiceBuilder builder;
	
	public Calculator(WindowsDriver<WebElement> driver) {
		this.driver = driver;
	}
	
	private String getMapping(String buttonLabel) {
		HashMap<String, String> idsByLabel = new HashMap<String, String>();
		idsByLabel.put("1", "num1Button");
		idsByLabel.put("3", "num3Button");
		idsByLabel.put("+", "plusButton");
		idsByLabel.put("=", "equalButton");
		idsByLabel.put("-", "minusButton");
		
		return idsByLabel.get(buttonLabel);
	}
	
	public String add(String first, String second) {
		String result = doOperation(first,second,"+");
		return result;
	}
	
	public WindowsDriver<WebElement> launch(AppiumServiceBuilder builder) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
		capabilities.setCapability("deviceName", "WindowsPC");
		URL url = null;
		
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.usingPort(4723);
		builder.withIPAddress("127.0.0.1");
		
		File file = new File("C:\\Program Files\nodejs\node.exe");
		builder.usingDriverExecutable(file);
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
		url = new URL("http://127.0.0.1:4723/wd/hub");
		this.driver = new WindowsDriver<WebElement>(url,builder capabilities);
	}
	
	public void kill() {
		driver.quit();
	}
	
	
}
