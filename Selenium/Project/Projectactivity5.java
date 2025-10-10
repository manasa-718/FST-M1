package Activitypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
 
public class Projectactivity5 {
    WebDriver driver;
    String baseUrl = "https://alchemy.hguy.co/crm/";
    String username = "admin";
    String password = "pa$$w0rd";
 
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
 
    @Test
    public void getNavigationBarColor() throws InterruptedException {
        driver.findElement(By.id("user_name")).sendKeys(username);
        driver.findElement(By.id("username_password")).sendKeys(password);
        driver.findElement(By.id("bigbutton")).click();
 
        Thread.sleep(3000);
 
        WebElement navBar = driver.findElement(By.id("toolbar"));
        String color = navBar.getCssValue("background-color");
        System.out.println("Navigation menu color: " + color);
    }
 
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}