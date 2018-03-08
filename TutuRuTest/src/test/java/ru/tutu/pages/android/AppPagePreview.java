package ru.tutu.pages.android;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.tutu.pages.CommonPage;



public class AppPagePreview extends CommonPage{

	//close
	@FindBy(id="ru.tutu.tutu_emp:id/close")
	WebElement close;
	
	public AppPagePreview(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void close() {
		close.click();
		
		
	}

}