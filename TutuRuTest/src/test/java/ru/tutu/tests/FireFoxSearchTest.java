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
		System.out.println("t");
		//avia
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[4]/div/div[1]/div[2]")).click();

		//from
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div[1]/div[2]/div[2]/div[1]/div[1]/input")).clear();
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div[1]/div[2]/div[2]/div[1]/div[1]/input")).sendKeys("Москва");
		//driver.findElement(By.className("b-input__form__standart m-train_form j-input_wrapper")).sendKeys("Москва");
		
		//to
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div/div[1]/div[2]/div[2]/div[3]/div[1]/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div/div[1]/div[2]/div[2]/div[3]/div[1]/input")).sendKeys("Ница");
		
		//date
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div/div[1]/div[2]/div[2]/div[4]/div[1]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("ui-datepicker-div")));
		//*[@id="ui-datepicker-div"]
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div/div[1]/div[2]/div[2]/div[7]/button/span/span[3]")).click();
		Thread.sleep(3000);

		
		String text = driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[1]/div[2]/div[4]/div[9]/div/div[1]") ).getText();
		System.out.println(text);
		Assert.assertNotNull(text);
		Thread.sleep(3000);
		//Assert.assertEquals(true,				);
		
		
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
