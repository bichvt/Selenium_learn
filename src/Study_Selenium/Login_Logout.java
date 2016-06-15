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

public class Login_Logout {
	public static String loginPage = "http://live.guru99.com/index.php/customer/account/login/";
	public static WebDriver driver = new FirefoxDriver();

	//Login success
	public static void loginSuccess(String validEmail, String validPass) throws InterruptedException{
		Common cm = new Common(driver);
		cm.openUrl(loginPage);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("email")).sendKeys(validEmail); //fill email đã được đăng kí thành công
		driver.findElement(By.id("pass")).sendKeys(validPass); // fill password đã đăng kí thành công
		driver.findElement(By.xpath("//button[@id='send2']")).click(); //click button Login
		Thread.sleep(5000);
		String expectLogin2 = "My Account";
		String actualLogin2="";
		//get actualLogin
		actualLogin2 = driver.getTitle();
		if(actualLogin2.contentEquals(expectLogin2))
			System.out.println("Login successfully. Pass");
		else
			System.out.println("Fail");	
	}

	//Logout from the system
	public static void logout() throws InterruptedException{
		Common cm = new Common(driver);
		driver.findElement(By.xpath("//span[@class='label' and text()='Account']")).click();
		driver.findElement(By.xpath("//a[@title='Log Out']")).click();
		System.out.println("Logged out from the system");
		cm.closeUrl();
	}


	//Login fail
	public static void loginFailEmail(String invalidEmail, String validPass) throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		Common cm = new Common(driver);
		cm.openUrl(loginPage);
		driver.findElement(By.id("email")).sendKeys(invalidEmail); //fill email
		driver.findElement(By.id("pass")).sendKeys(validPass); //fill password
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='send2']")).click(); //click Login button
		Thread.sleep(5000);
		String expectLogin1 = "Invalid login or password";
		Boolean actualLogin1;
		actualLogin1 = driver.getPageSource().contains("Invalid login or password"); //get actualLogin
		if(driver.getPageSource().contains(expectLogin1)==actualLogin1)
			System.out.println("Not can login. Pass");
		else
			System.out.println("Fail");
		cm.closeUrl();
	}

	//main function
	public static void main(String[] args) throws InterruptedException{
		String invalidEmail = "bichvt233aaa@gmail.com";
		String validPass = "123456789";
		String validEmail = "bichvt233@gmail.com";
		//Check login success
		loginSuccess(validEmail,validPass);
		//Check logout
		logout();
		//Check Login fail
		loginFailEmail(invalidEmail,validPass);
	}
}