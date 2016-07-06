package Test_NG;
import org.openqa.selenium.WebDriver;

/**
 * Common functions
 * 
 * 
 * @author BichVT
 * 
 */

public class Common {
	public WebDriver driver;
	
	//init driver
	public Common(WebDriver dr){
		driver = dr;
	}
	
	//Open URL
	public void openUrl(String baseUrl) throws InterruptedException{
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
	
	//close URL
	public void closeUrl(){
		driver.close();
	}
}
