package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

//will have all common methods e.g javascript , actions class ,, drag drop
//all page class will inherit this calss to use its methods
public class BasePage {

public static WebDriver driver;
	
	
	
/*
 * public BasePage(WebDriver driver) { BasePage.driver= driver;
 * //PageFactory.initElements(driver, this); }
 */
	 
	 
	
	public void scrollpage(WebDriver driver)
	{
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
	 
	}
	
	
	
	
}
