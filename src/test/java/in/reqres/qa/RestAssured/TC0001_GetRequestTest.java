package in.reqres.qa.RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;



public class TC0001_GetRequestTest {

	@Test
	public void getListUser() {

		// Specify base URI
		RestAssured.baseURI = "https://reqres.in";

		// Response Object
		RequestSpecification httprequest = RestAssured.given();

		// Response Object
		Response response = httprequest.request(Method.GET, "/api/users?page=2");

		// Print response on console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" + responseBody);

		System.out.println("---------------------------------------------------------------------------");

		// Status Code
		int statusCode = response.getStatusCode();
		System.out.println("Status Code is:" + statusCode);
		Assert.assertEquals(200, statusCode);

		System.out.println("---------------------------------------------------------------------------");

		// Status Line
		String statusLine = response.statusLine();
		System.out.println("Status Line is:" + statusLine);
		Assert.assertEquals("HTTP/1.1 200 OK", statusLine);

		System.out.println("---------------------------------------------------------------------------");

		// Json Response
		JsonPath jsonpath = response.jsonPath();
		System.out.println(jsonpath.get("page"));
		System.out.println(jsonpath.get("per_page"));
		System.out.println(jsonpath.get("total"));
		System.out.println(jsonpath.get("total_pages"));

		Assert.assertEquals(jsonpath.get("page"), 2);

		System.out.println("---------------------------------------------------------------------------");

		// Get Header Value
		String headerValue = response.header("Connection");
		System.out.println("Connection" + "-------------->" + headerValue);

		
		System.out.println("---------------------------------------------------------------------------");
		
		// Get All headers
		Headers allHeader = response.headers();
		for (Header header : allHeader) {
			System.out.println(header.getName() + "---------->" + header.getValue());

		}

	}

}
