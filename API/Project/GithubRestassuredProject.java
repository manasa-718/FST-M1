package GITHUBProject;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GithubRestassuredProject{
	

String jsonBody = "{\n" +
    "    \"title\": \"TestAPIKey\",\n" +
    "    \"key\": \"ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIEQnqODdEMLLQt3OPjtfHAQU0PZInMPZokI2OF9CPdmr\"\n" +
    "}";

	int id;
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	
	@BeforeClass
	public void setUp() {
		

   requestSpec = new RequestSpecBuilder()
		                .setBaseUri("https://api.github.com/user/keys")
		                .addHeader("Content-Type", "application/json")
		                .addHeader("Authorization", "Bearer ghp_............")
		                .build();
		    }
	
	
	

	@Test(priority=1)
	public void postRequestTest() {
		
		Response response=given().spec(requestSpec).body(jsonBody).when().post();	
		id=response.then().extract().path("id");
		response.then().statusCode(201);
		
		
		
	}
	
	@Test(priority=2)
	public void getRequestTest() {
		
		
		
		given().spec(requestSpec).pathParam("keyId",id).when().get("/{keyId}").
		
	then().statusCode(200);
		
		
	}
	
	
	@Test(priority=3)
	public void deleteRequestTest() {
		
		
		
		given().spec(requestSpec).pathParam("keyId",id).when().delete("/{keyId}").
		
	then().statusCode(204);
		
		
	}
	
	
	

	
	

}
