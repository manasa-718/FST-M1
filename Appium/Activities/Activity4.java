package Activities;

import static org.testng.Assert.assertEquals;

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

public class Activity4 {
	AndroidDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.contacts");
		options.setAppActivity("com.android.contacts.activities.PeopleActivity");
		options.noReset();

		// Set the Appium server URL
		URL serverURL = new URI("http://localhost:4723").toURL();

		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	@Test
	public void createContactTest() {
		driver.findElement(AppiumBy.accessibilityId("Create contact")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='First name']")).sendKeys("Aaditya");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Last name']")).sendKeys("Varma");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='+1']"))
		
				.sendKeys("999148292");
		driver.findElement(AppiumBy.xpath(
				"//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.widget.Button"))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("large_titleM2")));
		assertEquals("Aaditya Varma", driver.findElement(AppiumBy.id("large_titleM2")).getText());
	}

	// Tear down method
	@AfterClass
	public void tearDown() {
		// Close the app
		driver.quit();
	}
}