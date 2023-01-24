package foundation;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {

	@Override
	public void createDriver() {
		var driverPath = "C:\\Users\\trist\\Downloads\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		this.setDriver(new ChromeDriver());
	}
}
