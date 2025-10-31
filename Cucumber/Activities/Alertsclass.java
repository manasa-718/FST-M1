package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertsClass extends BaseClass {
	
	Alert alert;
	
	@Given("User is on the page")
	public void openPage() {
		driver.get("https://training-support.net/webelements/alerts");
		Assertions.assertEquals(driver.getTitle(), "Selenium: Alerts");
	}
	
	@When("User clicks the Simple Alert button")
	public void SimpleButtonClick() {
		driver.findElement(By.cssSelector("button#simple")).click();
	}
	
	@When("User clicks the Confirmation Alert button")
	public void confirmButtonClick() {
		driver.findElement(By.cssSelector("button#confirmation")).click();
	}
	
	@When("User clicks the Prompt Alert button")
	public void PromptButtonClick() {
		driver.findElement(By.cssSelector("button#prompt")).click();
	}
	
	@Then("Alert opens")
	public void alertSwitch() {
		alert=driver.switchTo().alert(); 
	}
	
	@And("Read the text from it and print it")
	public void SimpleAlertText() {
	
	String text=alert.getText();
	
	System.out.println("Alert says:"+text);
		
	}
	
	@And("Close the alert")
	
	public void acceptAlert() {
		alert.accept();
	}
	
	@And("Close the alert with Cancel")
	
	public void cancelAlert() {
		alert.dismiss();
	}
	
	
	@And("Write a custom message in it")
	
	public void writeToPrompt() {
		alert.sendKeys("Harika");
		
	}
	
	
	@And("Read the result text")
	
	public void resultText() {
	String resulttext=	driver.findElement(By.id("result")).getText();
	System.out.println("Action performed: " + resulttext);
	}
	
	
	

}