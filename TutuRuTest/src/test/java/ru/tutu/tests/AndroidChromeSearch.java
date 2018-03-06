package ru.tutu.tests;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class AndroidChromeSearch {
	private WebDriver driver;
	
	
	@Test
	public void test() throws InterruptedException {
		System.out.println("t");
		
		//train
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/a[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[2]/div/form/div/div/div[1]/div/div[1]/div[1]/input")).sendKeys("Владивосток");
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[2]/div/form/div/div/div[3]/div/div[1]/div[1]/input")).sendKeys("Москва");
		
		//driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[4]/div/div[1]/div[2]")).click();

		//driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div[1]/div[2]/div[2]/div[1]/div[1]/input")).clear();
		//driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div[1]/div[2]/div[2]/div[1]/div[1]/input")).sendKeys("Москва");
		//driver.findElement(By.className("b-input__form__standart m-train_form j-input_wrapper")).sendKeys("Москва");
		Thread.sleep(3000);
	}

	@BeforeTest
	public void beforeTest() throws MalformedURLException {
		System.out.println("b");
		// Create object of  DesiredCapabilities class and specify android platform
		DesiredCapabilities capabilities=DesiredCapabilities.android();
		 
		 
		// set the capability to execute test in chrome browser
		 capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,BrowserType.CHROME);
		 
		// set the capability to execute our test in Android Platform
		   capabilities.setCapability(MobileCapabilityType.PLATFORM,Platform.ANDROID);
		 
		// we need to define platform name
		  capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		 
		// Set the device name as well (you can give any name)
		 capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Galaxy s6");
		 
		 // set the android version as well 
		   capabilities.setCapability(MobileCapabilityType.VERSION,"6.0.1");
		   //capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		 // Create object of URL class and specify the appium server address
		 URL url= new URL("http://127.0.0.1:4723/wd/hub");
		 
		// Create object of  AndroidDriver class and pass the url and capability that we created
		 driver = new AndroidDriver(url, capabilities);
		 
		// Open url
		  driver.get("http://www.tutu.ru");
		 
		  
		
	

	}

	@AfterTest
	public void afterTest() {
		System.out.println("a");

		driver.quit();

	}

}
