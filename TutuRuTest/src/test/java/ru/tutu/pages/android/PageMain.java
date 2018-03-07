package ru.tutu.pages.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.tutu.pages.CommonPage;


	
public class PageMain extends CommonPage{

	//calendar
	@FindBy(xpath="//*[@id=\"wrapper\"]/div[2]/a[2]")
	WebElement train;
	
	
	public PageMain(WebDriver driver) {
		super(driver);
	}
	//go train
	public void train() {
		train.click();
		
		
	}

}