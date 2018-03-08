package ru.tutu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {
	public WebDriver driver;
	public CommonPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
}
