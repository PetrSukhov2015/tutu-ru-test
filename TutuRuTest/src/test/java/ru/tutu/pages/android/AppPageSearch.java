package ru.tutu.pages.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.PressesKeyCode;
import io.appium.java_client.android.AndroidKeyCode;
import ru.tutu.pages.CommonPage;

public class AppPageSearch extends CommonPage {

	
	//webelements cities
	@FindBy(id="ru.tutu.tutu_emp:id/city_name")
	List<WebElement> cities;
	
	
	//search big blue button
	@FindBy(className="android.view.ViewGroup")
	WebElement searchBugBlueButton;
	
	public AppPageSearch(WebDriver driver) {
		super(driver);
	}	


	public void searchOneWaySmokeTest(String from, String to) {
		List<WebElement> cits = cities;
		int i=0;
		for (WebElement cit: cits){			

			if (i==0){
				cit.clear();
				cit.sendKeys(from);

			}
			if (i==1){
				cit.clear();
				cit.sendKeys(to);
				break;
			}
			i++;		
			
		}
		((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.BACK);
		((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.BACK);

		searchBugBlueButton.click();
		
	}

}
