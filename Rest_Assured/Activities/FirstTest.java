package Activities;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstTest {
	// GET https://petstore.swagger.io/v2/pet/findByStatus?status=sold
	@Test
	public void getRequestwithQueryparam() {
		// send request and save response
		Response response = RestAssured.given().baseUri("https://petstore.swagger.io/v2/pet")
				.header("Content-Type", "application/json").header("Accept", "application/json")
				.queryParam("status", "sold")
				.when().get("/findByStatus");
		// print response
		//response.prettyPrint();
		//System.out.println(response.getBody().asString());
		//System.out.println(response.getBody().asPrettyString());
		// print status code
		//System.out.println("Status Code: " + response.getStatusCode());
		//headers
		//System.out.println("Headers: " + response.getHeaders().asList());
		//print properties
		String petStatus = response.then().extract().path("[0]['status']");
		//System.out.println("Content Type: " + response.getContentType());
		System.out.println(petStatus);
		
		//assertions
		Assert.assertEquals(petStatus, "sold");
		//restassured assertions
		response.then().
		            statusCode(200).
		            body("[0]['status']", Matchers.equalTo("sold"));
						
	}
	
	// POST https://petstore.swagger.io/v2/pet/{petId}
	@Test
	public void getRequestwithPathparam() {
		// send request and save response
		RestAssured.given().baseUri("https://petstore.swagger.io/v2/pet")
				.header("Content-Type", "application/json").header("Accept", "application/json")
				.pathParam("petId", "12")
				.when().
					get("/{petId}").
				 then().
				 	statusCode(200).
				 	body("id", Matchers.equalTo(12)).
				 	body("name", Matchers.equalTo("doggie"));
		
	
		
	}

}