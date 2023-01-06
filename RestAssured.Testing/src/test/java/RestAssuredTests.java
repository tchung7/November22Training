import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;

public class RestAssuredTests {
	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "https://reqres.in/";
	}
	
	@Test
	
	public void getRequestwithQueryParam() {
		String email = given().contentType("application/json")
			      .body("data.email")
			      .when()
			      .post(uri + "/movie")
			      .then()
			      .assertThat()
			      .statusCode(HttpStatus.CREATED.value())
			      .extract()
			      .path("id");
			    assertThat(movieId).isEqualTo(11);
		get("/api/users/2").then().statusCode(200).assertThat().body("email", equalTo("janet.weaver@reqres.in"));
	}
	
}
