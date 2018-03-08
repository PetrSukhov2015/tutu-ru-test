package ru.tutu.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.PressesKeyCode;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import ru.tutu.pages.android.AppPagePreview;
import ru.tutu.pages.android.AppPageResult;
import ru.tutu.pages.android.AppPageSearch;

public class AndroidAppSearchTest {

	private WebDriver driver;

	@Test
	public void test() throws InterruptedException {
		//close preview
				AppPagePreview pp = new AppPagePreview(driver);
				pp.close();
				
				//smoke search one way
				AppPageSearch ps = new AppPageSearch(driver);
				ps.searchOneWaySmokeTest("Лондон", "Париж");

				//check the results
				AppPageResult pr = new AppPageResult(driver);
				Assert.assertTrue( pr.check().contains("самолет") );

				//Thread.sleep(3000);
	}

	@BeforeTest
	public void beforeTest() throws MalformedURLException {
		System.out.println("b");
		//DesiredCapabilities сapabilities = new DesiredCapabilities();
		  DesiredCapabilities capabilities = new DesiredCapabilities();
		  capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy S6");
		  //capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		  capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
		  capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\sukhov\\Desktop\\app\\base.apk");
		  capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"ru.tutu.tutu_emp");
		  //capabilities.setCapability(MobileCapabilityType.LANGUAGE, "Russian");
		  //capabilities.setCapability(MobileCapabilityType.LANGUAGE, "Russian");
		  
		  //desired_capabilities['unicodeKeyboard'] = 'True'.
		  //capabilities.setCapability("appPackage", "com.videomost"); 
		  //capabilities.setCapability("app-wait-activity ", "com.Videomost.MainActivity"); ///*appActivity*/
		  //capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "ru.tutu.tutu_emp.presentation.main.MainActivity");//main.MainActivity");
		  
		  capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "ru.tutu.tutu_emp.presentation.splash.SplashActivity");//main.MainActivity");
		  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		  
		
	

	}

	@AfterTest
	public void afterTest() {
		System.out.println("a");

		driver.quit();

	}
}
