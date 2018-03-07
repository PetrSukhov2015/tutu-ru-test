package ru.tutu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageSearchResult extends CommonPage{
	//calendar
	@FindBy(xpath="/html/body/div[2]/div[6]/div[1]/div[2]/div[4]/div[9]/div/div[1]")
	WebElement result;
	
	public PageSearchResult(WebDriver driver) {
		super(driver);
		
	}

	public String check() {
		
		//String text = driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[1]/div[2]/div[4]/div[9]/div/div[1]") ).getText();
		String text = result.getText();
		System.out.println(text);
		return text;
	}

}
