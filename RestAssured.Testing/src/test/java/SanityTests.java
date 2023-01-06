import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
public class SanityTests {
	
	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "https://reqres.in/";
	}
  @Test
  public void f() {
  }
}
