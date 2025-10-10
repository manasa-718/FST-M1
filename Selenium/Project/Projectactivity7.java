package Activitypackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
public class Projectactivity7 {
 
	WebDriver driver;
	WebDriverWait wait;
 
	@BeforeClass
	public void setup() {
 
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("http://alchemy.hguy.co/crm");
		Assert.assertEquals(driver.getTitle(), "SuiteCRM");
 
	}
 
	@Test
	public void DisplayPhoneNumber() {
 
		WebElement username = driver.findElement(By.id("user_name"));
		WebElement password = driver.findElement(By.id("username_password"));
		WebElement login = driver.findElement(By.id("bigbutton"));
 
		username.sendKeys("admin");
		password.sendKeys("pa$$w0rd");
		login.click();
 
		WebElement salesmenu = driver.findElement(By.xpath("//a[text()='Sales']"));
 
		wait.until(ExpectedConditions.visibilityOf(salesmenu));
 
		Actions actions = new Actions(driver);
		actions.moveToElement(salesmenu).build().perform();
 
		WebElement leadsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Leads']")));
		leadsMenu.click();
 
		WebElement infoIcon = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//span[contains(@class,'suitepicon-action-info')])[1]")));
 
		infoIcon.click();
 
		WebElement phoneNumber = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='phone']")));
		System.out.println("Phone Number : " + phoneNumber.getText());
 
	}
 
	@AfterClass
	public void teardown() {
		driver.quit();
	}
}