package Test_NG;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Test_NG.Common;
import Test_NG.Logout;
import Test_NG.Register;

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
	static WebDriver driver;
	static Common cm;
	static String registPage = "http://live.guru99.com/index.php/customer/account/create/";
	static Register registObj;
	static String excelFilePath = "D:\\Selenium_Webdriver\\Data Test\\TestData.xlsx";
	static String sheetName = "Register";
	static String firstName, lastName, emailAddress, pwd, pwdConf;
	
	/**
	 * 
	 * Register account without enter first name
	 * @author BichVT
	 * @date: create new 20/06/2016
	 * 
	 */
	@Test (priority=1)
	public static void registerFailNoFirstName() throws InterruptedException,InvalidFormatException, IOException{
		firstName = cm.getDataFromExcel(excelFilePath, sheetName, 1, 0);
		lastName = cm.getDataFromExcel(excelFilePath, sheetName, 1, 1);
		emailAddress = cm.getDataFromExcel(excelFilePath, sheetName, 1, 2);
		pwd = cm.getDataFromExcel(excelFilePath, sheetName, 1, 3);
		pwdConf = cm.getDataFromExcel(excelFilePath, sheetName, 1, 4);
		registObj.register(firstName,lastName,emailAddress,pwd,pwdConf);
		String expectRegist1 = "This is a required field";
		boolean actualRegist1;
		actualRegist1 = driver.findElement(registObj.ErrorMessNoFirstName).getText().contains(expectRegist1);;
		Assert.assertTrue(actualRegist1,"1. Can not register account without enter First Name: Pass");
	}	
	/**
	 * 
	 * Register account without enter last name
	 * @author BichVT
	 * @date: create new 20/06/2016
	 * 
	 */
	@Test (priority=2)
	public static void registerFailNoLastName() throws InterruptedException,InvalidFormatException, IOException{
		firstName = cm.getDataFromExcel(excelFilePath, sheetName, 2, 0);
		lastName = cm.getDataFromExcel(excelFilePath, sheetName, 2, 1);
		emailAddress = cm.getDataFromExcel(excelFilePath, sheetName, 2, 2);
		pwd = cm.getDataFromExcel(excelFilePath, sheetName, 2, 3);
		pwdConf = cm.getDataFromExcel(excelFilePath, sheetName, 2, 4);
		registObj.register(firstName,lastName,emailAddress,pwd,pwdConf);
		String expectRegist2 = "This is a required field";
		boolean actualRegist2;
		actualRegist2 = driver.findElement(registObj.ErrorMessNoLastName).getText().contains(expectRegist2);
		Assert.assertTrue(actualRegist2,"2. Can not register account without enter Last Name: Pass");
	}
	/**
	 * 
	 * Register account without enter email
	 * @author BichVT
	 * @date: create new 20/06/2016
	 * 
	 */
	@Test (priority=3)
	public static void registerFailNoEmail() throws InterruptedException,InvalidFormatException, IOException{
		firstName = cm.getDataFromExcel(excelFilePath, sheetName, 3, 0);
		lastName = cm.getDataFromExcel(excelFilePath, sheetName, 3,1 );
		emailAddress = cm.getDataFromExcel(excelFilePath, sheetName, 3, 2);
		pwd = cm.getDataFromExcel(excelFilePath, sheetName, 3, 3);
		pwdConf = cm.getDataFromExcel(excelFilePath, sheetName, 3, 4);
		registObj.register(firstName,lastName,emailAddress,pwd,pwdConf);
		String expectRegist3 = "This is a required field";
		boolean actualRegist3;
		actualRegist3 = driver.findElement(registObj.ErrorMessNoEmail).getText().contains(expectRegist3);
		Assert.assertTrue(actualRegist3,"3. Can not register account without enter email: Pass");
	}
	/**
	 * 
	 * Register account without enter password
	 * @author BichVT
	 * @date: create new 20/06/2016
	 * 
	 */
	@Test (priority=4)
	public static void registerFailNoPass() throws InterruptedException,InvalidFormatException, IOException{
		firstName = cm.getDataFromExcel(excelFilePath, sheetName, 4, 0);
		lastName = cm.getDataFromExcel(excelFilePath, sheetName, 4, 1);
		emailAddress = cm.getDataFromExcel(excelFilePath, sheetName, 4, 2);
		pwd = cm.getDataFromExcel(excelFilePath, sheetName, 4, 3);
		pwdConf = cm.getDataFromExcel(excelFilePath, sheetName, 4, 4);
		registObj.register(firstName,lastName,emailAddress,pwd,pwdConf);
		String expectRegist4 = "This is a required field";
		boolean actualRegist4;
		actualRegist4 = driver.findElement(registObj.ErrorMessNoPass).getText().contains(expectRegist4);
		Assert.assertTrue(actualRegist4,"4. Can not register account without enter password: Pass");
	}
	/**
	 * 
	 * Register account without enter confirm password
	 * @author BichVT
	 * @date: create new 20/06/2016
	 * 
	 */
	@Test (priority=5)
	public static void registerFailNoConfPass() throws InterruptedException,InvalidFormatException, IOException{
		firstName = cm.getDataFromExcel(excelFilePath, sheetName, 5, 0);
		lastName = cm.getDataFromExcel(excelFilePath, sheetName, 5, 1);
		emailAddress = cm.getDataFromExcel(excelFilePath, sheetName, 5, 2);
		pwd = cm.getDataFromExcel(excelFilePath, sheetName, 5, 3);
		pwdConf = cm.getDataFromExcel(excelFilePath, sheetName, 5, 4);
		registObj.register(firstName,lastName,emailAddress,pwd,pwdConf);
		String expectRegist5 = "This is a required field";
		boolean actualRegist5;
		actualRegist5 = driver.findElement(registObj.ErrorMessNoConfPass).getText().contains(expectRegist5);
		Assert.assertTrue(actualRegist5,"5. Can not register account without enter confirm password: Pass");		
	}
	/**
	 * 
	 * Register account with confirm password not match password
	 * @author BichVT
	 * @date: create new 20/06/2016
	 * 
	 */
	@Test (priority=6)
	public static void registerFailConfPassNotMatch() throws InterruptedException,InvalidFormatException, IOException{
		firstName = cm.getDataFromExcel(excelFilePath, sheetName, 6, 0);
		lastName = cm.getDataFromExcel(excelFilePath, sheetName, 6, 1);
		emailAddress = cm.getDataFromExcel(excelFilePath, sheetName, 6, 2);
		pwd = cm.getDataFromExcel(excelFilePath, sheetName, 6, 3);
		pwdConf = cm.getDataFromExcel(excelFilePath, sheetName, 6, 4);
		registObj.register(firstName,lastName,emailAddress,pwd,pwdConf);
		String expectRegist6 = "Please make sure your passwords match.";
		String actualRegist6;
		actualRegist6 = driver.findElement(registObj.ErrorMessNoMatchConfPass).getText();
		Assert.assertEquals(actualRegist6, expectRegist6,"6. Can not register account because Confirm Password not match Password: Pass");
	}
	/**
	 * 
	 * Register account with duplicate email
	 * @author BichVT
	 * @date: create new 20/06/2016
	 * 
	 */
	@Test (priority=7)
	public static void registerFailDuplicateEmail() throws InterruptedException,InvalidFormatException, IOException{
		firstName = cm.getDataFromExcel(excelFilePath, sheetName, 7, 0);
		lastName = cm.getDataFromExcel(excelFilePath, sheetName, 7, 1);
		emailAddress = cm.getDataFromExcel(excelFilePath, sheetName, 7, 2);
		pwd = cm.getDataFromExcel(excelFilePath, sheetName, 7, 3);
		pwdConf = cm.getDataFromExcel(excelFilePath, sheetName, 7, 4);
		registObj.register(firstName,lastName,emailAddress,pwd,pwdConf);
		boolean result;
		result = driver.getPageSource().contains("There is already an account with this email address");
		Assert.assertTrue(result,"7. Can not register account  with duplicate email: Pass");
	}
	/**
	 * 
	 * Register account successful
	 * @author BichVT
	 * @date: create new 20/06/2016
	 * 
	 */
	@Test (priority=8)
	public static void registerSuccess() throws InterruptedException,InvalidFormatException, IOException{
		firstName = cm.getDataFromExcel(excelFilePath, sheetName, 8, 0);
		lastName = cm.getDataFromExcel(excelFilePath, sheetName, 8, 1);
		emailAddress = cm.getDataFromExcel(excelFilePath, sheetName, 8, 2);
		pwd = cm.getDataFromExcel(excelFilePath, sheetName, 8, 3);
		pwdConf = cm.getDataFromExcel(excelFilePath, sheetName, 8, 4);
		registObj.register(firstName,lastName,emailAddress,pwd,pwdConf);
		boolean result;
		result = driver.getPageSource().contains("Thank you for registering with Main Website Store.");
		Assert.assertTrue(result, "8. Register account successfully: Pass");	
		//Logout from the system
		Logout logoutObj = new Logout(driver);
		logoutObj.logout();
	}
	
	@BeforeMethod
	public static void login()throws InterruptedException {
		driver = new FirefoxDriver();
		cm = new Common(driver);
		cm.openUrl(registPage);
		registObj = new Register(driver);
	}

	@AfterMethod
	public static void closePage(){
		cm.closeUrl();
	}
}
