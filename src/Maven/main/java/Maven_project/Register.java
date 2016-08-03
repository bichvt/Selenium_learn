package Maven_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register {
	public WebDriver driver;
	public Register(WebDriver dr){
		driver = dr;
	}
	/**
	 * Register common variables
	 * @author BichVT
	 * @date 20/06/2016
	 * 
	 */
	public String registPage = "http://live.guru99.com/index.php/customer/account/create/";
	public By firstNameElenment = By.id("firstname");
	public  By lastNameElenment= By.id("lastname");
	public  By emailElenment= By.id("email_address");
	public  By passElenment= By.id("password");
	public  By confPassElenment= By.id("confirmation");
	public By registerBtn= By.xpath("//button[@title='Register']");
	public By ErrorMessNoFirstName = By.xpath("//div[@id='advice-required-entry-firstname']");
	public By ErrorMessNoLastName = By.xpath("//div[@id='advice-required-entry-lastname']");
	public By ErrorMessNoEmail = By.xpath("//div[@id='advice-required-entry-email_address']");
	public By ErrorMessNoPass = By.xpath("//div[@id='advice-required-entry-password']");
	public By ErrorMessNoConfPass = By.xpath("//div[@id='advice-required-entry-confirmation']");
	public By ErrorMessNoMatchConfPass = By.xpath("//div[@id='advice-validate-cpassword-confirmation']");
	
	
	/**
	 * Register common function
	 * @author BichVT
	 * @date 20/06/2016
	 * 
	 */
	public void register(String firstName, String lastName, String email, String pass, String confPass) throws InterruptedException{
		driver.findElement(firstNameElenment).sendKeys(firstName);
		driver.findElement(lastNameElenment).sendKeys(lastName);
		driver.findElement(emailElenment).sendKeys(email);
		driver.findElement(passElenment).sendKeys(pass);
		driver.findElement(confPassElenment).sendKeys(confPass);
		driver.findElement(registerBtn).click();
		Thread.sleep(5000);
	}
}
