package Activitypackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
 
//Goal: Print the url of the header image to the console
 
public class Projectactivity2 {
    WebDriver driver;
    
    // Setup function
    @BeforeClass
    public void setUp() {
        // Open a browser
        driver = new FirefoxDriver();
        // Navigate to the page
        driver.get("https://alchemy.hguy.co/crm/");
        
    }
    
    // Test function
    @Test    
    public void PrintUrl() {
        // Get the url of the header image.
    	   WebElement headerImage = driver.findElement(By.xpath("//img[contains(@alt, 'SuiteCRM')]"));
    	   String headerUrl = headerImage.getAttribute("src");
    	
    	//  Print the url to the console.
           System.out.println("URL of the header image is : " + headerUrl);
                      
    }
    
    @AfterClass
    public void afterClass() {
        // Close browser
        driver.close();
    }
}