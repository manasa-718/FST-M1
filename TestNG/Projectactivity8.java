package Activitypackage;

import java.time.Duration;
import java.util.List;
 
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
 
public class Projectactivity8 {
WebDriver driver;
@BeforeClass
public void beforeMethod() {
        driver = new FirefoxDriver();        
        driver.get("http://alchemy.hguy.co/crm");
    }
@Test
public void testCase1() {
	//a. open the browser and login
driver.findElement(By.id("user_name")).sendKeys("admin");
driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
driver.findElement(By.id("bigbutton")).click();
 
//b. Navigate to the Sales -> Accounts page.
 
WebElement SalesMenu= driver.findElement(By.xpath("//a[text()='Sales']"));
Assert.assertTrue(SalesMenu.isDisplayed(),"Sales menu item exists.");
SalesMenu.click();
   
WebElement Accounts = driver.findElement(By.id("moduleTab_9_Accounts"));
    Accounts.click();
 
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='list view table-responsive']")));
    
            // c. Wait for table to load and print first 5 odd-numbered rows
       
        WebElement table = driver.findElement(By.cssSelector("table.list.view.table-responsive"));
        List<WebElement> rows = table.findElements(By.cssSelector("tbody tr"));
 
        System.out.println("First 5 odd-numbered rows:");
        int count = 0;
        for (int i = 0; i < rows.size(); i++) {
            if (i % 2 == 0) { // odd-numbered rows (0-based index)
                WebElement nameCell = rows.get(i).findElement(By.cssSelector("td:nth-child(3)")); // Name column
                System.out.println(nameCell.getText());
                count++;
                if (count == 5) break;
            }
        }
    }
//d.Close the browser.
    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
 
