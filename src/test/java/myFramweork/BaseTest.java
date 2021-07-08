package myFramweork;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import bsh.ParseException;
import drivers.DriverInitializer;
import drivers.DriverProvider;
import testData.ReadJasonData;
import testData.ReadTestData;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

 
 	ReadTestData readexcel;
 	ReadJasonData jdata;
 	
 	public static WebDriver driver=new DriverInitializer("chrome").init();
 	
 	
	/*
	 * @BeforeSuite
	 * @Parameters(value= {"browser"}) 
	 * public void setup(String browser) //public
	 * void setup() 
	 * { 
	 * if (browser.equalsIgnoreCase("chrome")) 
	 * { //setup the browser
	 * WebDriverManager.chromedriver().setup(); 
	 * driver =new ChromeDriver();
	 * driver.manage().deleteAllCookies(); } else
	 * if(browser.equalsIgnoreCase("firefox")) {
	 * WebDriverManager.firefoxdriver().setup(); driver= new FirefoxDriver();
	 * driver.manage().deleteAllCookies(); }
	 * 
	 * }
	 */
	 
	@BeforeTest
	public void LaunchApplication() throws IOException, ParseException, InterruptedException, org.json.simple.parser.ParseException
	{
		
		//ReadTestData testdata = new ReadTestData();
		driver.navigate().to(ReadTestData.configFileReader());	
		//implicit wait
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	
		
		ReadTestData.readWriteJSON();
	//	System.out.println("this is from POJO file" + jdata.url);
	}
	
	
	@AfterTest
	public void TearDown()
	{
     driver.quit();
		
	}
}
