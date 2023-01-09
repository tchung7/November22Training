import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import JSONSerializer.Data;
import JSONSerializer.User;
import JSONSerializer.Users;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestAssuredTests {

	private static String postRequestBody = "{\n" + "  \"email\": \"eve.holt@reqres.in\",\n"
			+ "  \"password\": \"cityslicka\"\n}";

	private static String updateRequestBody = "{\n" + "  \"name\": \"Morpheus2\"\n}";

	private static final SimpleDateFormat df = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");

	private static final SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.port = 443;
	}

	@Test

	public void getRequestwithQueryParam() {
		String expected = "janet.weaver@reqres.in";
		String actual = given().contentType(ContentType.JSON).body("data.email").when().get("/api/users/2").then()
				.assertThat().statusCode(200).extract().path("email");
		assertEquals(actual, expected, "Incorrect email was retrieved.");
	}

	@Test

	public void verifyEmailFieldIsCorrect() {
		get("/api/users/2").then().assertThat().body("data.email", equalTo("janet.weaver@reqres.in"));
	}

	@Test

	public void verifyReponseToken() {
		Response response = given().contentType(ContentType.JSON).and().body(postRequestBody).when().post("/api/login")
				.then().assertThat().statusCode(200).extract().response();

		assertEquals(response.jsonPath().getString("token"), "QpwL5tke4Pnpja7X4");
	}

	@Test

	public void verifyDeleteResponseStatusCodeIsCorrect() {
		given().contentType(ContentType.JSON).when().delete("/api/users/2").then().statusCode(204);

		/*
		 * HTTP Status 204 (No Content) indicates that the server has successfully
		 * fulfilled the request and that there is no content to send in the response
		 * payload body.
		 */
	}

	@Test

	public void ensurePatchResponseIsCorrect() throws ParseException {
		Response response = given().contentType(ContentType.JSON).and().body(updateRequestBody).when()
				.patch("/api/users/2").then().body("name", equalTo("Morpheus2"))
				.body("updatedAt", instanceOf(String.class)).statusCode(200).extract().response();
		Date expected_date = df.parse(response.getHeader("date"));
		Date actual_date = df2.parse(response.jsonPath().getString("updatedAt"));
		assertEquals(actual_date.toString(), expected_date.toString());
	}

	@Test

	public void ensurePutResponseIsCorrect() throws ParseException {
		Response response = given().contentType(ContentType.JSON).and().body(updateRequestBody).when()
				.put("/api/users/2").then().body("name", equalTo("Morpheus2"))
				.body("updatedAt", instanceOf(String.class)).statusCode(200).extract().response();
		Date expected_date = df.parse(response.getHeader("date"));
		Date actual_date = df2.parse(response.jsonPath().getString("updatedAt"));
		assertEquals(actual_date.toString(), expected_date.toString());
	}

	@Test

	public void verifyJSONUserInfoDeserializerWorks() throws ParseException {
		User user2 = get("/api/users/2").as(User.class);
		assertEquals(user2.getData().getUserId(), "2");
		assertEquals(user2.getData().getEmail(), "janet.weaver@reqres.in");
		assertEquals(user2.getData().getFirstName(), "Janet");
		assertEquals(user2.getData().getLastName(), "Weaver");
		assertEquals(user2.getData().getAvatar(), "https://reqres.in/img/faces/2-image.jpg");
		assertEquals(user2.getSupport().getUrl(), "https://reqres.in/#support-heading");
		assertEquals(user2.getSupport().getText(),
				"To keep ReqRes free, contributions towards server costs are appreciated!");
	}

	@Test

	public void verifyJSONUsersCollectionDeserializerWorks() throws ParseException {
		Users users = get("/api/users?page=2").as(Users.class);
		for (Data user : users.getData()) {
			assertNotNull(user.getUserId());
			assertNotNull(user.getEmail());
			assertNotNull(user.getFirstName());
			assertNotNull(user.getLastName());
			assertNotNull(user.getAvatar());
		}

	}

}
