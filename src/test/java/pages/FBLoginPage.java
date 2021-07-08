package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import drivers.DriverProvider;

import org.openqa.selenium.WebElement;
import pages.BasePage;
import testData.ReadTestData;

//this will have all the element and method to perform action on those elemements
public class FBLoginPage extends BasePage {

  //WebDriver driver;
   
  public FBLoginPage()
  {
	//super(driver);
	driver= DriverProvider.getDriver();
	 PageFactory.initElements(driver, this);
  }
	

 @FindBy(xpath= "//a[@title='English (UK)']")
  private WebElement EngLangbtn ;
 
@FindBy(xpath="//input[@aria-label='Email address or phone number']")
private WebElement emailTextbox;

@FindBy(xpath="//input[@aria-label='Password']")
private WebElement pwdtextbox;

@FindBy(xpath="//button[@name='login']")
private WebElement loginbtn;

//create public methods to use above welebelements in test class


  public void clickonLangbtn()
  {
	
	 // System.out.println(EngLangbtn);
    EngLangbtn.click();  
       
}
 
  public void enterEmail(String username)
  {
	  emailTextbox.sendKeys(username);
  }
  
  public void enterPwd(String password)
  {
	  pwdtextbox.sendKeys(password);
  }
  
  public void clickLoginbtn()
  {
	  loginbtn.click();
  }
}