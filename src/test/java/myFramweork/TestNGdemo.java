package myFramweork;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.FBLoginPage;
//import pages.*; as classes are public
import testData.ReadTestData;

//test class extends baasetest class so we can call all the common methods in all test class
//bcz creating object for calling those base methods in all test class will be hectic 
public class TestNGdemo extends BaseTest  {

	//ReadTestData readexcel;  as methods are already static
	
	//WebDriver driver ;
	FBLoginPage fbLoginpage = new FBLoginPage();
	
	
	@DataProvider
	public Object[][] getLoginData() throws IOException {
	Object[][] gmail_data	= ReadTestData.getExcelData("FB_Login");
	return gmail_data;
	}
	

	@Test(dataProvider = "getLoginData")
	public void fbLogin(String Username, String Password) 
	{ 
		
		fbLoginpage.scrollpage(driver); // using inheritance here , child class obj calling parent class method as it inherited parent class members
		fbLoginpage.clickonLangbtn();
		fbLoginpage.enterEmail(Username);
		fbLoginpage.enterPwd(Password); 
		fbLoginpage.clickLoginbtn();
		}
	
	@Test(priority=1 ,enabled = false)
	public void verifymicbtnk() 
	{
		
		  if(driver.findElement(By.xpath("//div[@class='dRYYxd']")).isEnabled()) {
		  System.out.println("voice btn present"); }
		  
		  else System.out.println("voice btn not present");
		 
	}
	

	
	
	
	@Test(priority=0 , dataProvider= "getLoginData" , enabled=false)
	public void GmailLogin(String Username , String Password)
	{
		if(driver.findElement(By.xpath("//input[@type='email' and @aria-label='Email or phone']")).isDisplayed())
		{
			System.out.println("Gmail sign in btn displayed");
			driver.findElement(By.xpath("//input[@type='email' and @aria-label='Email or phone']")).sendKeys(Username);
		}
		else 
			System.out.println("sign in btn not displayed");
		
			if(driver.findElement(By.xpath("//span[text()='Next']")).isDisplayed())
			{
				System.out.println("Login btn dispalying");
				driver.findElement(By.xpath("//span[text()='Next']")).click();	
			}
			else 
				System.out.println("login btn not displaying");
	}
	
	@Test(priority=-4 , enabled = false)
	public void verifySearchBtn() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@title='Search' and @name='q']")).sendKeys("Reached google");
		WebElement ele= driver.findElement(By.xpath("(//input[@name='btnK'])[2]"));
		System.out.println(ele.getLocation());
		
		if( driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).isDisplayed())
			System.out.println("Btn present");
		else
			System.out.println("Search btn Not Present");
	
	}	
}
