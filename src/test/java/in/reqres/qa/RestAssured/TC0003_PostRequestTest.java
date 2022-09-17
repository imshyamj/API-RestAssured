package in.reqres.qa.RestAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC0003_PostRequestTest {

	
	@SuppressWarnings("unchecked")
	@Test
	public void createUser() {

		RestAssured.baseURI = "https://reqres.in";

		RequestSpecification httpRequest = RestAssured.given();

		// Request Payload sending along with Post request
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "morpheus");
		requestParams.put("job", "leader");

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());

		Response response = httpRequest.request(Method.POST, "/api/users");

		// Print response on console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" + responseBody);

		System.out.println("---------------------------------------------------------------------------");

		// Status Code
		int statusCode = response.getStatusCode();
		System.out.println("Status Code is:" + statusCode);
		Assert.assertEquals(201, statusCode);

		System.out.println("---------------------------------------------------------------------------");

		// Get Header Value
		String headerValue = response.header("Connection");
		System.out.println("Connection" + "-------------->" + headerValue);

	}

}
