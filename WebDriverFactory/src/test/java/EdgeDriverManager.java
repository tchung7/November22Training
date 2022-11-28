public class EdgeDriverManager extends DriverManager {
	
	@Override
	public void createDriver() {
		var driverPath = "C:\\Users\\trist\\Downloads\\edgedriver_win64\\msedgedriver.exe";
		System.setProperty("webdriver.edge.driver", driverPath);
		this.setDriver();
	}
}
