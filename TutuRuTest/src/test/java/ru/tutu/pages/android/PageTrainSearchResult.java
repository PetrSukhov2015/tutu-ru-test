package ru.tutu.pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageTrainSearchResult extends PageTrain{
	
	//fires search result
	@FindBy(xpath="//*[@id=\"wrapper\"]/div[3]/div/div[1]/div/div[2]/div/div/div[1]/div/div/div")
	WebElement sResult;
	
	public PageTrainSearchResult(WebDriver driver) {
		super(driver);
		
	}

	//check the first result and print it
	public String check() {
		String textFirstResult = sResult.getText();
		System.out.println(textFirstResult);
		return textFirstResult;
	}

}
