package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInitializer {

	private String browser;
	
	public DriverInitializer(String browser) {
		this.browser= browser;
	}
	
	public WebDriver init() {
		WebDriver driver = null;
		 WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		DriverProvider.setDriver(driver);
		   return  driver ;
	}
	
	
	
}
