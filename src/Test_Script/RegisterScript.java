package Test_Script;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Study_Selenium.Common;
import Study_Selenium.Logout;
import Study_Selenium.Register;

/**
2. Register account
URL: http://live.guru99.com/index.php/customer/account/create/
 * Điền các thông tin cần thiết vào form
 * Click "Register" button
 * Điền giá trӏ để verify 2 trường hợp:
 * Đăng ký thành công
 * Đăng ký thất bại
 * 
 * @author BichVT
 * 
 */

public class RegisterScript {
	/**
	 * 
	 * Register account successful
	 * @author BichVT
	 * @date: create new 20/06/2016
	 * 
	 */
	public static void registerSuccess() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		Common cm = new Common(driver);
		String registPage = "http://live.guru99.com/index.php/customer/account/create/";
		cm.openUrl(registPage);
		Register registObj = new Register(driver);
		registObj.register("Vu Thi","Sen","senvuthi1@gmail.com","1234567890","1234567890");
		if(driver.getPageSource().contains("Thank you for registering with Main Website Store"))
			System.out.println("1. Register account successfully: Pass");
		else
			System.out.println("1. Register account successfully: Fail");
		//Logout from the system
		Logout logoutObj = new Logout(driver);
		logoutObj.logout();
		cm.closeUrl();
	}
	/**
	 * 
	 * Register account without enter first name
	 * @author BichVT
	 * @date: create new 20/06/2016
	 * 
	 */
	public static void registerFailNoFirstName() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		Common cm = new Common(driver);
		String registPage = "http://live.guru99.com/index.php/customer/account/create/";
		cm.openUrl(registPage);
		Register registObj = new Register(driver);
		registObj.register(null,"Sen","senvu3@gmail.com","1234567890","1234567890");
		String expectRegist1 = "This is a required field";
		String actualRegist1;
		actualRegist1 = driver.findElement(registObj.ErrorMessNoFirstName).getText();
		if(actualRegist1.contains(expectRegist1))
			System.out.println("2. Can not register account without enter First Name: Pass");
		else
			System.out.println("2. Can not register account without enter First Name: Fail");
		cm.closeUrl();
	}	
	/**
	 * 
	 * Register account without enter last name
	 * @author BichVT
	 * @date: create new 20/06/2016
	 * 
	 */
	public static void registerFailNoLastName() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		Common cm = new Common(driver);
		String registPage = "http://live.guru99.com/index.php/customer/account/create/";
		cm.openUrl(registPage);
		Register registObj = new Register(driver);
		registObj.register("Vu Thi",null,"senvu3@gmail.com","1234567890","1234567890");
		String expectRegist2 = "This is a required field";
		String actualRegist2;
		actualRegist2 = driver.findElement(registObj.ErrorMessNoLastName).getText();
		if(actualRegist2.contains(expectRegist2))
			System.out.println("3. Can not register account without enter Last Name: Pass");
		else
			System.out.println("3. Can not register account without enter Last Name: Fail");
		cm.closeUrl();
	}
	/**
	 * 
	 * Register account without enter email
	 * @author BichVT
	 * @date: create new 20/06/2016
	 * 
	 */
	public static void registerFailNoEmail() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		Common cm = new Common(driver);
		String registPage = "http://live.guru99.com/index.php/customer/account/create/";
		cm.openUrl(registPage);
		Register registObj = new Register(driver);
		registObj.register("Vu Thi","Sen",null,"1234567890","1234567890");
		String expectRegist3 = "This is a required field";
		String actualRegist3;
		actualRegist3 = driver.findElement(registObj.ErrorMessNoEmail).getText();
		if(actualRegist3.contains(expectRegist3))
			System.out.println("4. Can not register account without enter email: Pass");
		else
			System.out.println("4. Can not register account without enter email: Fail");
		cm.closeUrl();
	}
	/**
	 * 
	 * Register account without enter password
	 * @author BichVT
	 * @date: create new 20/06/2016
	 * 
	 */
	public static void registerFailNoPass() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		Common cm = new Common(driver);
		String registPage = "http://live.guru99.com/index.php/customer/account/create/";
		cm.openUrl(registPage);
		Register registObj = new Register(driver);
		registObj.register("Vu Thi","Sen","vusen3@gmail.com",null,"1234567890");
		String expectRegist4 = "This is a required field";
		String actualRegist4;
		actualRegist4 = driver.findElement(registObj.ErrorMessNoPass).getText();
		if(actualRegist4.contains(expectRegist4))
			System.out.println("4. Can not register account without enter password: Pass");
		else
			System.out.println("4. Can not register account without enter password: Fail");
		cm.closeUrl();
	}
	/**
	 * 
	 * Register account without enter confirm password
	 * @author BichVT
	 * @date: create new 20/06/2016
	 * 
	 */
	public static void registerFailNoConfPass() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		Common cm = new Common(driver);
		String registPage = "http://live.guru99.com/index.php/customer/account/create/";
		cm.openUrl(registPage);
		Register registObj = new Register(driver);
		registObj.register("Vu Thi","Sen","vusen3@gmail.com","1234567890",null);
		String expectRegist5 = "This is a required field";
		String actualRegist5;
		actualRegist5 = driver.findElement(registObj.ErrorMessNoConfPass).getText();
		if(actualRegist5.contains(expectRegist5))
			System.out.println("5. Can not register account without enter confirm password: Pass");
		else
			System.out.println("5. Can not register account without enter conffirm password: Fail");
		cm.closeUrl();
	}
	/**
	 * 
	 * Register account with confirm password not match password
	 * @author BichVT
	 * @date: create new 20/06/2016
	 * 
	 */
	public static void registerFailConfPassNotMatch() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		Common cm = new Common(driver);
		String registPage = "http://live.guru99.com/index.php/customer/account/create/";
		cm.openUrl(registPage);
		Register registObj = new Register(driver);
		registObj.register("Vu Thi","Sen","vusen3@gmail.com","1234567890","123456789");
		String expectRegist6 = "Please make sure your passwords match";
		String actualRegist6;
		actualRegist6 = driver.findElement(registObj.ErrorMessNoMatchConfPass).getText();
		if(actualRegist6.contains(expectRegist6))
			System.out.println("6. Can not register account because Confirm Password not match Password: Pass");
		else
			System.out.println("6. Can not register account because Confirm Password not match Password: Fail");
		cm.closeUrl();
	}
	/**
	 * 
	 * Register account with duplicate email
	 * @author BichVT
	 * @date: create new 20/06/2016
	 * 
	 */
	public static void registerFailDuplicateEmail() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		Common cm = new Common(driver);
		String registPage = "http://live.guru99.com/index.php/customer/account/create/";
		cm.openUrl(registPage);
		Register registObj = new Register(driver);
		registObj.register("Vu Thi","Sen","senvuthi@gmail.com","1234567890","1234567890");
		if(driver.getPageSource().contains("There is already an account with this email address"))
			System.out.println("7. Can not register account  with duplicate email: Pass");
		else
			System.out.println("7. Can not register account  with duplicate email: Fail");
		cm.closeUrl();
	}

	public static void main(String[] args) throws InterruptedException{
		//Register account successful
		registerSuccess();
		//Register account without enter first name
		registerFailNoFirstName();
		//Register account without enter last name
		registerFailNoLastName();
		//Register account without enter email
		registerFailNoEmail();
		//Register account without enter password
		registerFailNoPass();
		//Register account without enter confirm password
		registerFailNoConfPass();
		//Register account with confirm password not match password
		registerFailDuplicateEmail();
		//Register account with duplicate email
		registerFailDuplicateEmail();
	}
}
