package Test_Script;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Study_Selenium.Common;
import Study_Selenium.Login;
import Study_Selenium.Logout;

/**
 * Common functions
 * 
 * 
 * @author BichVT
 * 
 */

public class LoginScript {
	/**
	 * 
	 * Login successful
	 * @author BichVT
	 * @date 17/06/2016
	 * 
	 */
	public static void loginSuccess() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		Common cm = new Common(driver);
		String loginPage = "http://live.guru99.com/index.php/customer/account/login/";
		cm.openUrl(loginPage);
		Login loginObj = new Login(driver);
		loginObj.login("bichvt233@gmail.com","123456789");
		String expectLogin2 = "My Account";
		String actualLogin2="";
		//get actualLogin
		actualLogin2 = driver.getTitle();
		if(actualLogin2.contentEquals(expectLogin2))
			System.out.println("1. Login successfully: Pass");
		else
			System.out.println("1. Login successfully: Fail");	
		//Logout from the system
		Logout logoutObj = new Logout(driver);
		logoutObj.logout();
		cm.closeUrl();
	}

	/**
	 * 
	 * Login fail with invalid email
	 * @author BichVT
	 * @date 17/06/2016
	 * 
	 */
	public static void loginFailEmail() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		Common cm = new Common(driver);
		String loginPage = "http://live.guru99.com/index.php/customer/account/login/";
		cm.openUrl(loginPage);
		Login loginObj = new Login(driver);
		loginObj.login("bichvt233aaaaa@gmail.com","123456789");
		if(driver.getPageSource().contains("Invalid login or password"))
			System.out.println("2. Not can login with invalid email: Pass");
		else
			System.out.println("2. Not can login with invalid email: Fail");
		cm.closeUrl();
	}
	/**
	 * 
	 * Login fail with invalid password
	 * @author BichVT
	 * @date 17/06/2016
	 * 
	 */
	public static void loginFailPassword() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		Common cm = new Common(driver);
		String loginPage = "http://live.guru99.com/index.php/customer/account/login/";
		cm.openUrl(loginPage);
		Login loginObj = new Login(driver);
		loginObj.login("bichvt233@gmail.com","1234567890123");
		if(driver.getPageSource().contains("Invalid login or password"))
			System.out.println("3. Not can login with invalid password: Pass");
		else
			System.out.println("3. Not can login with invalid password: Fail");
		cm.closeUrl();
	}
	/**
	 * 
	 * Login fail with blank email
	 * @author BichVT
	 * @date 17/06/2016
	 * 
	 */
	public static void loginFailNoEmail() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		Common cm = new Common(driver);
		String loginPage = "http://live.guru99.com/index.php/customer/account/login/";
		cm.openUrl(loginPage);
		Login loginObj = new Login(driver);
		loginObj.login(null,"123456789");
		String expectLogin1 = "This is a required field";
		String actualLogin1;
		actualLogin1 = driver.findElement(loginObj.textErrorMessEmail).getText();
		if(actualLogin1.contains(expectLogin1))
			System.out.println("4. Not can login without enter email: Pass");
		else
			System.out.println("4. Not can login without enter email: Fail");
		cm.closeUrl();
	}

	/**
	 * 
	 * Login fail with blank password
	 * @author BichVT
	 * @date 17/06/2016
	 * 
	 */
	public static void loginFailNoPass() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		Common cm = new Common(driver);
		String loginPage = "http://live.guru99.com/index.php/customer/account/login/";
		cm.openUrl(loginPage);
		Login loginObj = new Login(driver);
		loginObj.login("bichvt233@gmail.com",null);
		String expectLogin2 = "This is a required field.";
		String actualLogin2;
		actualLogin2 = driver.findElement(loginObj.textErrorMessPass).getText(); //get actualLogin
		if(actualLogin2.contains(expectLogin2))
			System.out.println("5. Not can login without enter password: Pass");
		else
			System.out.println("5. Not can login without enter password: Fail");
		cm.closeUrl();
	}
	/**
	 * 
	 * Login fail with both blank email and password
	 * @author BichVT
	 * @date 17/06/2016
	 * 
	 */
	public static void loginFailNoEmailPass() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		Common cm = new Common(driver);
		String loginPage = "http://live.guru99.com/index.php/customer/account/login/";
		cm.openUrl(loginPage);
		Login loginObj = new Login(driver);
		loginObj.login(null,null);
		String expectLogin1 = "This is a required field";
		String expectLogin2 = "This is a required field";
		String actualLogin1, actualLogin2;
		actualLogin1 = driver.findElement(loginObj.textErrorMessEmail).getText(); 
		actualLogin2 = driver.findElement(loginObj.textErrorMessPass).getText(); 
		if(actualLogin1.contains(expectLogin1)&&actualLogin2.contains(expectLogin2))
			System.out.println("6. Not can login without enter email and password: Pass");
		else
			System.out.println("6. Not can login without enter email and password: Fail");
		cm.closeUrl();
	}

	//main function
	public static void main(String[] args) throws InterruptedException{
		//Check login success
		loginSuccess();
		//Check Login fail with invalid email
		loginFailEmail();
		//Check login fail with invalid password
		loginFailPassword();
		//Check login fail without enter email
		loginFailNoEmail();
		//Check login fail without enter password
		loginFailNoPass();
		//Check login fail without enter email and password
		loginFailNoEmailPass();

	}
}