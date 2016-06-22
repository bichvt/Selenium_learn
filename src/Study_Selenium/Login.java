package Study_Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Study_Selenium.Common;

public class Login {
	public WebDriver driver;
	public Login(WebDriver dr){
		driver = dr;
	}
	/**
	 * declare common locators for Login
	 * @author BichVT
	 * @date 17/06/2016
	 * 
	 */
	public String loginPage = "http://live.guru99.com/index.php/customer/account/login/";
	private By emailElement = By.id("email");
	private By passElement = By.id("pass");
	private By loginBtn = By.xpath("//button[@id='send2']");
	public By textErrorMessPass = By.xpath("//div[@id='advice-required-entry-pass']");
	public By textErrorMessEmail = By.xpath("//div[@id='advice-required-entry-email']");
	
	/**
	 * 
	 * Login function
	 * @author BichVT
	 * @date 17/06/2016
	 * 
	 */
	public void login(String email, String pass) throws InterruptedException{
		driver.findElement(emailElement).sendKeys(email); //fill email 
		driver.findElement(passElement).sendKeys(pass); // fill password 
		Thread.sleep(5000);
		driver.findElement(loginBtn).click(); //click button Login
		Thread.sleep(5000);
	}

}
