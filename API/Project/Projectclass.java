package project;

package Project;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Projectclass {
	// Declare Request and Response specifications objects
	
		RequestSpecification RequestSpec;
		ResponseSpecification ResponseSpec;
		int keyId;
		String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIIB59q+e1or+zD83hVJotk6DUnZt9lXbWkjnYQyyI8bW";
		
		@BeforeClass
		public void setUp() {
			// Create request specification
			RequestSpec = new RequestSpecBuilder().
					setBaseUri("https://api.github.com/user/keys").
					addHeader("Content-Type","application/json").
					addHeader("Authorization", "Bearer ....").
					addHeader("X-GitHub-Api-Version", "2022-11-28").
					build();
			
			// Create a response Specification
			ResponseSpec = new ResponseSpecBuilder().
					expectBody("title",Matchers.equalTo("TestAPIKey")).
					expectBody("key", Matchers.equalTo(sshKey)).
					expectResponseTime(lessThanOrEqualTo(5000L)).
					build();
		}
		
		@Test(priority = 1)
		//POST 
		public void postRequestTest() {
			Map <String, String> reqBody = new HashMap<>();
			reqBody.put("title", "TestAPIKey");
			reqBody.put("key", sshKey);
			// Send request and save the response
			Response response = given().spec(RequestSpec).body(reqBody).
								when().post();
			// Extract PetId from the response
			this.keyId = response.then().extract().path("id");
			// Assertions
			response.then().spec(ResponseSpec);
			
		}
		//GET 
		@Test(priority = 2)
		public void getRequestTest() {
			// Send request, get request, Assert
			given().spec(RequestSpec).pathParam("keyId",this.keyId).
			when().get("/{keyId}").
			then().spec(ResponseSpec).body("title",equalTo("TestAPIKey"));
			
		}
		//DELETE
		@Test(priority = 3)
		public void deleteRequestTest() {
			// Send request, get request, Assert
			given().spec(RequestSpec).pathParam("KeyId",this.keyId).
			// log().all(). --> this prints all the values
			when().delete("/{KeyId}").
			then().statusCode(204);
			
		}
}
