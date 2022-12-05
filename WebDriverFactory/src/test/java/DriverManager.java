import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public abstract class DriverManager {
	
	private WebDriver driver;

	public abstract void createDriver();

	public WebDriver getDriver() {
		createDriver();
		return this.driver;
	}

	protected void setDriver() {
		var chromeDriverManager = new ChromeDriverManager();

		if (this.driver == null) {
			if (this.getClass().equals(chromeDriverManager.getClass())) {
				this.driver = new ChromeDriver();
			} else {
				this.driver = new EdgeDriver();
			}
		}
	}

	public void quitDriver() {
		if (this.driver == null) {
			return;
		}
		this.driver.quit();
	}
}
