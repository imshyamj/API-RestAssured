package in.reqres.qa.RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC0002_AuthenticationTest {

	@Test
	public void authentication() {

		// Specify base URI
		RestAssured.baseURI = "https://api.github.com";

		// Basic authentication
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
		authScheme.setUserName("imshyamj");
		authScheme.setPassword("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");
		RestAssured.authentication = authScheme;

		// Response Object
		RequestSpecification httpRequest = RestAssured.given();

		// Response Object
		Response response = httpRequest.request(Method.GET, "/user/repos");

		// Print response on console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" + responseBody);

	}

}
