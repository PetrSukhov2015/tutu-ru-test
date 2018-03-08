package ru.tutu.pages.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.tutu.pages.CommonPage;


public class AppPageResult extends CommonPage{

	//search results transport
	@FindBy(id="ru.tutu.tutu_emp:id/transport_type_text")
	List<WebElement> transport;
	
	public AppPageResult(WebDriver driver) {
		super(driver);
	}

	public String check() {
		List<WebElement> trans = transport;
		int i2=0;
		String text = "";
		for (WebElement tr: trans){
			//System.out.println(i2);
			text = text + tr.getAttribute("text")+"\n";
			//System.out.println(icon.toString());
			//System.out.println(icon.getTagName());		
			
			
		}
		System.out.println(text);
		return text;
	}
	
}