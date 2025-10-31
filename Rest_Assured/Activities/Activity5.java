package Activities;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Activity5 {

	String sshKey ="ssh- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	 int keyId;
  RequestSpecification requestSpec;
  ResponseSpecification responseSpec;
  @BeforeClass
  public void setup()
  {
	  requestSpec = new RequestSpecBuilder().
	  setBaseUri("https://api.github.com/user/keys").
	  addHeader("Content-Type","application/json").
	  addHeader("Authorization","token TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT").
	  addHeader("X-GitHub-Api-Version", "2022-11-28").
	  build();
	  
	  responseSpec = new ResponseSpecBuilder().
	  expectBody("title",Matchers.equalTo("TestKey")).
	  expectResponseTime(Matchers.lessThanOrEqualTo(3000L)).
	  build();
  }
  @Test(priority =1)
  public void postRequestURL()
  {
	  HashMap<String, String> reqBody = new  HashMap<>();
	  reqBody.put("title", "TestKey");
	  reqBody.put("key", sshKey);
	  
	  Response response = RestAssured.given().
			  spec(requestSpec).body(reqBody).log().all().
			  when().post();
	  keyId= response.then().extract().path("id");
	  response.then().statusCode(201).spec(responseSpec).log().all();
  }
  
  @Test(priority =2)
  public void getRequestURL()
  {

	  RestAssured.given().
			  spec(requestSpec).pathParam("keyId",keyId).log().all().when().get("/{keyId}").
			  then().statusCode(200).spec(responseSpec);
	  
  }
  
  
  @Test(priority =3)
  public void deleteRequestURL()
  {

	  RestAssured.given().
			  spec(requestSpec).pathParam("keyId",keyId).log().all().when().delete("/{keyId}").
			  then().statusCode(204);	  
  }

}