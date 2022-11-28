public class DriverManagerFactory {

	public static DriverManager getManager(String browserType) {
		DriverManager driverManager = null;
		switch (browserType) {
		case "chrome": {
			driverManager = new ChromeDriverManager();
			break;
		}
		case "edge": {
			driverManager = new EdgeDriverManager();
			break;
		}
		}
		return driverManager;
	}
}