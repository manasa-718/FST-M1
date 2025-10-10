package Activitypackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
 
//Goal: Read the title of the website and verify the text
 
public class Projectactivity1 {
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
    public void TitleTest() {
        // Get the title of the website.
    	   String title = driver.getTitle();
           System.out.println("Title is: " + title);
        
        //Make sure it matches “SuiteCRM” exactly.
           Assert.assertEquals(title, "SuiteCRM");
                       
    }
    
    @AfterClass
    public void afterClass() {
        // Close browser
        driver.close();
    }
}
