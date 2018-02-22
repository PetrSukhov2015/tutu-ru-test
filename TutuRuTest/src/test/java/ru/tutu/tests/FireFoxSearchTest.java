package ru.tutu.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ru.tutu.pages.*;

public class FireFoxSearchTest {

	 private WebDriver driver;
	 
	    @BeforeMethod
		public void setUp() throws Exception {
	    	System.setProperty("webdriver.gecko.driver","D:\\work\\testing\\auto.ru\\geckodriver.exe");
	    	driver = new FirefoxDriver();
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	driver.get("https://www.tutu.ru/");

	    }
	 
	    @AfterMethod
		public void tearDown() throws Exception {
	        driver.quit();
	    }
	 
	    @Test
	    public void search(){

	        
	    }


}
