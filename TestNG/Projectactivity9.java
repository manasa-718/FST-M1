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
public class Projectactivity9 {
WebDriver driver;
@BeforeClass 
public void beforeMethod() {
        driver = new FirefoxDriver();        
        driver.get("http://alchemy.hguy.co/crm");
    }
@Test
public void testCase1() { 
driver.findElement(By.id("user_name")).sendKeys("admin");
driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
driver.findElement(By.id("bigbutton")).click();
WebElement SalesMenu= driver.findElement(By.xpath("//a[text()='Sales']"));
Assert.assertTrue(SalesMenu.isDisplayed(),"Sales menu item exists.");
SalesMenu.click();
WebElement Leads = driver.findElement(By.id("moduleTab_9_Leads"));
Leads.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='list view table-responsive']")));
for(int i=1;i<=10;i++) {
//i=i+1;
System.out.println("Row No:"+i);
WebElement name= driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr["+i+"]/td[3]"));
WebElement username= driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr["+i+"]/td[8]"));
System.out.println("Name is:"+name.getText());
System.out.println("UserName is:"+username.getText());
}

}
@AfterClass
public void closeup() {
driver.quit();
}
}