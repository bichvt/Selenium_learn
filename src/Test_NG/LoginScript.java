package Test_NG;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Common functions
 * 
 * 
 * @author BichVT
 * 
 */

public class LoginScript {
	static WebDriver driver = new FirefoxDriver();
	static Common cm;
	static String loginPage = "http://live.guru99.com/index.php/customer/account/login/";
	static Login loginObj;
	
	/**
	 * 
	 * Login fail with invalid email
	 * @author BichVT
	 * @date 17/06/2016
	 * 
	 */
	@Test (priority=1)
	public static void loginFailEmail() throws InterruptedException{
		loginObj.login("bichvt233aaaa@gmail.com","123456789");
		if(driver.getPageSource().contains("Invalid login or password"))
			System.out.println("2. Not can login with invalid email: Pass");
		else
			System.out.println("2. Not can login with invalid email: Fail");
		driver.findElement(loginObj.emailElement).clear();
		driver.findElement(loginObj.passElement).clear(); 
		Thread.sleep(5000);
	}
	/**
	 * 
	 * Login fail with invalid password
	 * @author BichVT
	 * @date 17/06/2016
	 * 
	 */
	@Test (priority=2)
	public static void loginFailPassword() throws InterruptedException{
		loginObj.login("bichvt233@gmail.com","1234567890123");
		if(driver.getPageSource().contains("Invalid login or password"))
			System.out.println("3. Not can login with invalid password: Pass");
		else
			System.out.println("3. Not can login with invalid password: Fail");
		driver.findElement(loginObj.emailElement).clear();
		driver.findElement(loginObj.passElement).clear(); 
		Thread.sleep(5000);
	}
	/**
	 * 
	 * Login fail with blank email
	 * @author BichVT
	 * @date 17/06/2016
	 * 
	 */
	@Test (priority=3)
	public static void loginFailNoEmail() throws InterruptedException{
		loginObj.login(null,"123456789");
		String expectLogin1 = "This is a required field";
		String actualLogin1;
		actualLogin1 = driver.findElement(loginObj.textErrorMessEmail).getText();
		if(actualLogin1.contains(expectLogin1))
			System.out.println("4. Not can login without enter email: Pass");
		else
			System.out.println("4. Not can login without enter email: Fail");
		driver.findElement(loginObj.passElement).clear(); 
		Thread.sleep(5000);
	}

	/**
	 * 
	 * Login fail with blank password
	 * @author BichVT
	 * @date 17/06/2016
	 * 
	 */
	@Test (priority=4)
	public static void loginFailNoPass() throws InterruptedException{
		loginObj.login("bichvt233@gmail.com",null);
		String expectLogin2 = "This is a required field.";
		String actualLogin2;
		actualLogin2 = driver.findElement(loginObj.textErrorMessPass).getText(); //get actualLogin
		if(actualLogin2.contains(expectLogin2))
			System.out.println("5. Not can login without enter password: Pass");
		else
			System.out.println("5. Not can login without enter password: Fail");
		driver.findElement(loginObj.emailElement).clear();
		Thread.sleep(5000);
	}
	/**
	 * 
	 * Login fail with both blank email and password
	 * @author BichVT
	 * @date 17/06/2016
	 * 
	 */
	@Test (priority=5)
	public static void loginFailNoEmailPass() throws InterruptedException{
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
		Thread.sleep(5000);
	}
	/**
	 * 
	 * Login successful
	 * @author BichVT
	 * @date 17/06/2016
	 * 
	 */
	@Test (priority=6)
	public static void loginSuccess() throws InterruptedException{
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
	}
	
	@BeforeTest
	public static void login()throws InterruptedException {
		cm = new Common(driver);
		cm.openUrl(loginPage);
		loginObj = new Login(driver);
	}

	@AfterTest
	public static void closePage(){
		cm.closeUrl();
	}
}

