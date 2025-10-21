package Activities;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {

	AndroidDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {

		File apkFile = new File("src/test/resources/Calculator.apk");

		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setApp(apkFile.getAbsolutePath());
		options.noReset();

		URL serverUrl = new URI("http://localhost:4723").toURL();
		driver = new AndroidDriver(serverUrl, options);
	}

	@Test
	public void multilpyTest() {
		driver.findElement(AppiumBy.id("digit_4")).click();;
		driver.findElement(AppiumBy.accessibilityId("multiply")).click();;
		driver.findElement(AppiumBy.id("digit_9")).click();;
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		String result=driver.findElement(AppiumBy.id("result_final")).getText();
		assertEquals(result, "36");
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
