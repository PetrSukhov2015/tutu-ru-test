package ru.tutu.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.PressesKeyCode;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidAppSearchTest {

	private WebDriver driver;

	@Test
	public void test() throws InterruptedException {
		System.out.println("t");
		//Thread.sleep(3000);
		
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("ru.tutu.tutu_emp:id/action_bar_root")));
		driver.findElement(By.id("ru.tutu.tutu_emp:id/close")).click();
		//driver.findElement(By.id("ru.tutu.tutu_emp:id/action_bar_root"));
		
		//((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.BACK);
		//Thread.sleep(3000);
		List<WebElement> el = driver.findElements(By.id("ru.tutu.tutu_emp:id/city_name"));
		int i=0;
		for (WebElement e: el){
			
			//System.out.println(e.toString());
			if (i==0){
				e.clear();
				e.sendKeys("Лондон");
				//e.sendKeys("London");
				//e.sendKeys("\uD09B");
			}
			if (i==1){
				e.clear();
				e.sendKeys("Париж");
				//e.sendKeys("Paris");
				//e.sendKeys("uПариж");
				break;
			}
			i++;		
			
		}
		((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.BACK);
		((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.BACK);
		//driver.findElement(By.id("ru.tutu.tutu_emp:id/navigation_main")).click();
		
		/*
		
		*/
		//ru.tutu.tutu_emp:id/icon
		//((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.BACK);		
		driver.findElement(By.className("android.view.ViewGroup")).click();
		
		
		
		List<WebElement> icons = driver.findElements(By.className("android.widget.FrameLayout"));
		int i2=0;
		String text = null;
		for (WebElement icon: icons){
			
			//System.out.println(e.toString());
			if (i2==6){
				text = icon.getText();			
			}			
			i2++;	
			
		}
		
		
		//String text = driver.findElement(By.className("android.widget.RelativeLayout")).getText();
		System.out.println(text);
		//driver.findElement(By.id("ru.tutu.tutu_emp:id/left_part_header")).click();
		Thread.sleep(3000);
		//"ru.tutu.tutu_emp:id/city_name"[0]
		
		
		
		//driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[4]/div/div[1]/div[2]")).click();

		//driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div[1]/div[2]/div[2]/div[1]/div[1]/input")).clear();
		//driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div[1]/div[2]/div[2]/div[1]/div[1]/input")).sendKeys("Москва");
		//driver.findElement(By.className("b-input__form__standart m-train_form j-input_wrapper")).sendKeys("Москва");

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
