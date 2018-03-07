package ru.tutu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageSearch extends CommonPage{
	//avia Page
	@FindBy(xpath="//*[@id=\"wrapper\"]/div[4]/div/div[1]/div[2]")
	WebElement aviaSpan;
	
	//avia from input
	@FindBy(xpath="/html/body/div[1]/div[5]/div/div[1]/div[2]/div[2]/div[1]/div[1]/input")
	WebElement aviaFrom;
	
	//avia to input
	@FindBy(xpath="//*[@id=\"wrapper\"]/div[5]/div/div[1]/div[2]/div[2]/div[3]/div[1]/input")
	WebElement aviaTo;
	
	//date
	@FindBy(xpath="//*[@id=\"wrapper\"]/div[5]/div/div[1]/div[2]/div[2]/div[4]/div[1]")
	WebElement date;
	
	//calendar
	@FindBy(id="ui-datepicker-div")
	WebElement calendar;
		
	//select date
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[1]/a")	
	WebElement selectDate;
		
	//search
	@FindBy(xpath="//*[@id=\"wrapper\"]/div[5]/div/div[1]/div[2]/div[2]/div[7]/button/span/span[3]")	
	WebElement searchButton;
		
		
	WebDriverWait wait;
	WebElement element;
		
	
	public PageSearch(WebDriver driver) {
		super(driver);		
	}

	//search some tickets
	public void searchAviaOneWaySmokeTest(String from, String to) {
		
		//avia
		aviaSpan.click();
		
		//from
		aviaFrom.sendKeys(from);
		
		//to
		aviaTo.sendKeys(to);
		
		//open date
		date.click();
		
		wait = new WebDriverWait(driver, 10);
		element = wait.until(ExpectedConditions.elementToBeClickable(calendar));
		//element = wait.until(ExpectedConditions.elementToBeClickable(By.id("ui-datepicker-div")));
		
		selectDate.click();
		searchButton.click();
	}

}

