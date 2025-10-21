package Activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {
	AndroidDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {

		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");

		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();

		// Server URL
		URL serverURL = new URI("http://localhost:4723").toURL();

		// Driver initialization
		driver = new AndroidDriver(serverURL, options);

		// Open Selenium page
		driver.get("https://training-support.net");
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test
	public void pageTitleTest() {
//		Locate the heading on the page and print it to console.
		String pageHeading=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Training Support']"))).getText();
		System.out.println(pageHeading);
		
//		Locate the About Us button and click it.
		driver.findElement(AppiumBy.accessibilityId("About Us")).click();
		
//		Print the heading on the About Us page to the console
		System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='About Us']"))).getText());
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}