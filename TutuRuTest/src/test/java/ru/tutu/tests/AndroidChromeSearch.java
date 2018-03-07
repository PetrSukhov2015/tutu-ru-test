package ru.tutu.tests;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import ru.tutu.pages.android.PageMain;
import ru.tutu.pages.android.PageTrain;
import ru.tutu.pages.android.PageTrainSearchResult;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class AndroidChromeSearch {
	private WebDriver driver;

	@Test
	public void test() throws InterruptedException {
		
		//go train page
		PageMain pm = new PageMain(driver);
		pm.train();
		
		//search something
		PageTrain pt = new PageTrain(driver);
		pt.searchTrainOneWaySmokeTest("Санкт-Петербург", "Москва");
		
		//check result
		PageTrainSearchResult sr = new PageTrainSearchResult(driver);
		Assert.assertNotNull(sr.check());
	}

	@BeforeTest
	public void beforeTest() throws MalformedURLException {
		// set some capabilities
		DesiredCapabilities capabilities = DesiredCapabilities.android();
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy s6");
		capabilities.setCapability(MobileCapabilityType.VERSION, "6.0.1");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		// create driver
		driver = new AndroidDriver(url, capabilities);

		// Open url
		driver.get("http://www.tutu.ru");

	}

	@AfterTest
	public void afterTest() {
		driver.quit();

	}

}
