package ru.tutu.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.tutu.pages.*;

public class FireFoxSearchTest {
	private WebDriver driver;

	@Test
	public void test() throws InterruptedException {
		//search avia
		PageSearch ps = new PageSearch(driver);
		ps.searchAviaOneWaySmokeTest("Москва","Ница");
		//check result
		PageSearchResult sr = new PageSearchResult(driver);
		Assert.assertNotNull( sr.check() );
		
		
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("b");
		System.setProperty("webdriver.gecko.driver","C:\\Users\\sukhov\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");
    	driver = new FirefoxDriver();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	//driver.get("https://auto.ru/");
		driver.get("https://www.tutu.ru");
	

	}

	@AfterTest
	public void afterTest() {
		System.out.println("a");

		driver.quit();

	}


}
