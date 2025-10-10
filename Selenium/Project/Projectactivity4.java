package Activitypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
 
public class Projectactivity4 {
    WebDriver driver;
    String baseUrl = "https://alchemy.hguy.co/crm/";
    String username = "admin";
    String password = "pa$$w0rd";
 
    @BeforeClass
    public void setUp() {
        // Open Firefox browser
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void LoginTest() throws InterruptedException {
        // Enter username
        driver.findElement(By.id("user_name")).sendKeys(username);
        // Enter password
        driver.findElement(By.id("username_password")).sendKeys(password);
        // Click Login
        driver.findElement(By.id("bigbutton")).click();
 
        Thread.sleep(3000); // wait for login
 
     
    }
 
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
