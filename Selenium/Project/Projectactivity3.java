package Activitypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Projectactivity3 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
       
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get("https://alchemy.hguy.co/crm");
    }

    @Test
    public void printFooterCopyright() {
        // Locate the footer element (adjust XPath if needed)
        WebElement footerText = driver.findElement(By.xpath("//div[@class='footer']//div[@class='company']"));

        System.out.println("Footer Text: " + footerText.getText());
    }

    @AfterClass
    public void tearDown() {
       
        if (driver != null) {
            driver.quit();
        }
    }
}
