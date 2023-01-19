import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidApp {
	
	private AndroidDriver<AndroidElement> driver;
	
	public AndroidApp(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}
	
	
}
