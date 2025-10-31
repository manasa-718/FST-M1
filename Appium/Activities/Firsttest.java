package Activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;

public class Firsttest {
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException
	{
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setApp("C:/Users/RabiMajumder/Desktop/APKs/calculator.apk");
        options.noReset();
        
        //for android
//        options.setAppPackage("com.google.android.calculator");
//        options.setAppActivity("com.android.calculator2.Calculator");
        
        URL serverURL = new URI("http://localhost:4723").toURL();
        driver = new AndroidDriver(serverURL, options);
	}
	
//	//ForIOS:
//		@BeforeClass
//			public void iOSSetUp() throws MalformedURLException, URISyntaxException {
//				// Set the capabilities
//				XCUITestOptions options = new XCUITestOptions();
//				options.setPlatformName("ios");
//				options.setAutomationName("XCUITest");
//				options.setApp("path/to/app.ipa");
//				options.noReset();
//				// Set the Appium server URL
//		}
	
	
		
	// Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}