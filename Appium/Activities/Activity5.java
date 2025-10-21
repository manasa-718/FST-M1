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

public class Activity5 {
	AndroidDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.apps.messaging");
		options.setAppActivity(".ui.ConversationListActivity");
		options.noReset();

		// Set the Appium server URL
		URL serverURL = new URI("http://localhost:4723").toURL();

		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	@Test
	public void smsMessageTest() {
		driver.findElement(AppiumBy.accessibilityId("Start chat")).click();

		wait.until(ExpectedConditions
				.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"ContactSearchField\"]")))
				.sendKeys("878787878");

		wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.xpath("//android.view.View[@resource-id=\"ContactSuggestionList\"]/android.view.View")))
				.click();

		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("compose_message_text")))
				.sendKeys("Hello from Appium");
		
		driver.findElement(AppiumBy.accessibilityId("Send SMS")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.TextView")));
		//String message = driver.findElement(AppiumBy.id("message_text")).getText();
		String message = driver.findElement(AppiumBy.className("android.widget.TextView")).getText();
		System.out.println(message);
		
		assertEquals("Hello from Appium", message);

	}

	// Tear down method
	@AfterClass
	public void tearDown() {
		// Close the app
		driver.quit();
	}
}