package ru.tutu.pages.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.tutu.pages.CommonPage;



public class PageTrain extends CommonPage{

	
	//from
	@FindBy(xpath="//*[@id=\"wrapper\"]/div[2]/div[2]/div/form/div/div/div[1]/div/div[1]/div[1]/input")
	WebElement fromInput;
	
	//to
	@FindBy(xpath="//*[@id=\"wrapper\"]/div[2]/div[2]/div/form/div/div/div[3]/div/div[1]/div[1]/input")
	WebElement toInput;
	
	//today
	@FindBy(xpath="//*[@id=\"wrapper\"]/div[2]/div[2]/div/form/div/div/div[4]/div/div[2]/span[1]")
	WebElement cDate;
	
	//today
	@FindBy(xpath="//*[@id=\"wrapper\"]/div[2]/div[2]/div/form/div/div/div[5]/button/span")
	WebElement search;
	
	
	public PageTrain(WebDriver driver) {
		super(driver);
	}

	//search from train for current date
	public void searchTrainOneWaySmokeTest(String from, String to) {
		
		fromInput.sendKeys(from);
		toInput.sendKeys(to);
		cDate.click();
		search.click();
		
		
	}

}
