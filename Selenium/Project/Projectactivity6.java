package Activitypackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
 
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
public class Projectactivity6 {
 
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
	public void verifyActivitiesMenu() {
 
		WebElement username = driver.findElement(By.id("user_name"));
		WebElement password = driver.findElement(By.id("username_password"));
		WebElement login = driver.findElement(By.id("bigbutton"));
 
		username.sendKeys("admin");
		password.sendKeys("pa$$w0rd");
		login.click();
 
		WebElement activitiesMenu = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Activities']")));
 
		Assert.assertTrue(activitiesMenu.isDisplayed(), "Activities menu is  displayed.");
		Assert.assertTrue(activitiesMenu.isEnabled(), "Activities menu is  clickable.");
 
		activitiesMenu.click();
 
		System.out.println("Activities menu is present and clickable.");
	}
 
	@AfterClass
	public void teardown() {
		driver.quit();
	}
 
}
