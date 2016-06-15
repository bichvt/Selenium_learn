package Study_Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Common functions
 * 
 * 
 * @author BichVT
 * 
 */

public class Common {
	public static WebDriver driver;
	
	//init driver
	public Common(WebDriver dr){
		driver = dr;
	}

	//Open URL
	public static void openUrl(String baseUrl) throws InterruptedException{
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	//close URL
	public static void closeUrl(){
		driver.close();
	}
}
