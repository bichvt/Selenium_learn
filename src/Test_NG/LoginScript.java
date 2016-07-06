package Test_NG;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Common functions
 * 
 * 
 * @author BichVT
 * 
 */

public class LoginScript {
	static WebDriver driver;
	static Common cm;
	static String loginPage = "http://live.guru99.com/index.php/customer/account/login/";
	static Login loginObj;
	static String excelFilePath = "D:\\Selenium_Webdriver\\Data Test\\TestData.xlsx";
	static String sheetName = "Login";
	static String userName, passWord;

	/**
	 * 
	 * Login fail with invalid email
	 * @author BichVT
	 * @date 17/06/2016
	 * 
	 */
	@Test (priority=1)
	public static void loginFailEmail() throws InterruptedException,InvalidFormatException, IOException{
		userName = cm.getDataFromExcel(excelFilePath, sheetName, 1, 0);
		passWord = cm.getDataFromExcel(excelFilePath, sheetName, 1, 1);
		loginObj.login(userName,passWord);
		//loginObj.login("bichvt233aaaa@gmail.com","123456789");
		boolean Result = driver.getPageSource().contains("Invalid login or password");
		Assert.assertTrue(Result,"1. Login with invalid email:Pass");
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
	public static void loginFailPassword() throws InterruptedException,InvalidFormatException, IOException{
		userName = cm.getDataFromExcel(excelFilePath, sheetName, 2, 0);
		passWord = cm.getDataFromExcel(excelFilePath, sheetName, 2, 1);
		loginObj.login(userName,passWord);
		boolean Result = driver.getPageSource().contains("Invalid login or password");
		Assert.assertTrue(Result,"2. Login with invalid password: Pass");
	}
	/**
	 * 
	 * Login fail with blank email
	 * @author BichVT
	 * @date 17/06/2016
	 * 
	 */
	@Test (priority=3)
	public static void loginFailNoEmail() throws InterruptedException,InvalidFormatException, IOException{
		userName = cm.getDataFromExcel(excelFilePath, sheetName, 3, 0);
		passWord = cm.getDataFromExcel(excelFilePath, sheetName, 3, 1);
		loginObj.login(userName,passWord);
		String expectLogin1 = "This is a required field.";
		String actualLogin1;
		actualLogin1 = driver.findElement(loginObj.textErrorMessEmail).getText();
		Assert.assertEquals(actualLogin1, expectLogin1,"3. Login without enter email: Pass");
	}

	/**
	 * 
	 * Login fail with blank password
	 * @author BichVT
	 * @date 17/06/2016
	 * 
	 */
	@Test (priority=4)
	public static void loginFailNoPass() throws InterruptedException,InvalidFormatException, IOException{
		userName = cm.getDataFromExcel(excelFilePath, sheetName, 4, 0);
		passWord = cm.getDataFromExcel(excelFilePath, sheetName, 4, 1);
		loginObj.login(userName,passWord);
		String expectLogin2 = "This is a required field.";
		String actualLogin2;
		actualLogin2 = driver.findElement(loginObj.textErrorMessPass).getText(); 
		Assert.assertEquals(actualLogin2, expectLogin2,"4. Login without enter password: Pass");
	}
	/**
	 * 
	 * Login fail with both blank email and password
	 * @author BichVT
	 * @date 17/06/2016
	 * 
	 */
	@Test (priority=5)
	public static void loginFailNoEmailPass() throws InterruptedException,InvalidFormatException, IOException{
		userName = cm.getDataFromExcel(excelFilePath, sheetName, 5, 0);
		passWord = cm.getDataFromExcel(excelFilePath, sheetName, 5, 1);
		loginObj.login(userName,passWord);
		String expectLogin = "This is a required field.";
		boolean actualResultMail, actualResultPass;
		actualResultMail = driver.findElement(loginObj.textErrorMessEmail).getText().contentEquals(expectLogin); 
		actualResultPass = driver.findElement(loginObj.textErrorMessPass).getText().contentEquals(expectLogin); ; 
		Assert.assertTrue(actualResultMail&&actualResultPass,"5. Login without enter email and password: Pass");
	}
	/**
	 * 
	 * Login successful
	 * @author BichVT
	 * @date 17/06/2016
	 * 
	 */
	@Test (priority=6)
	public static void loginSuccess() throws InterruptedException,InvalidFormatException, IOException{
		userName = cm.getDataFromExcel(excelFilePath, sheetName, 6, 0);
		passWord = cm.getDataFromExcel(excelFilePath, sheetName, 6, 1);
		loginObj.login(userName,passWord);
		String expectLogin2 = "My Account";
		String actualLogin2;
		//get actualLogin
		actualLogin2 = driver.getTitle();
		Assert.assertEquals(actualLogin2, expectLogin2,"6. Login successfully: Pass");
		//Logout from the system
		Logout logoutObj = new Logout(driver);
		logoutObj.logout();
	} 

	@BeforeMethod
	public static void login()throws InterruptedException,InvalidFormatException, IOException {
		driver = new FirefoxDriver();
		cm = new Common(driver);
		cm.openUrl(loginPage);
		loginObj = new Login(driver);
	}

	@AfterMethod
	public static void closePage(){
		cm.closeUrl();
	}
}

