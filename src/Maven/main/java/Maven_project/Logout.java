package Maven_project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logout {
	public WebDriver driver;
	public Logout(WebDriver dr){
		driver = dr;
	}

	private By accountLable = By.xpath("//span[@class='label' and text()='Account']");
	private By logoutBtn = By.xpath("//a[@title='Log Out']");

	/**
	 * 
	 * create logout function
	 * @author BichVT
	 * @date 17/06/2016
	 * 
	 */
	public void logout() throws InterruptedException{
		driver.findElement(accountLable).click();
		driver.findElement(logoutBtn).click();
	}


}
