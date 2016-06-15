package Study_Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
2. Register account
URL: http://live.guru99.com/index.php/customer/account/create/
 * Điền các thông tin cần thiết vào form
 * Click "Register" button
 * Điền giá trӏ để verify 2 trường hợp:
 * Đăng ký thành công
 * Đăng ký thất bại
 * 
 * 
 * @author BichVT
 * 
 */

public class Register_Account {
	public static String createAcc = "http://live.guru99.com/index.php/customer/account/create/";
	public static WebDriver driver = new FirefoxDriver();

	//Register account successful
	public static void registerSuccess(String firstName, String lastName, String email, String pass, String confirmPass) throws InterruptedException{
		Common cm = new Common(driver);
		cm.openUrl(createAcc);
		driver.findElement(By.id("firstname")).sendKeys(firstName); //Fill First name
		driver.findElement(By.id("lastname")).sendKeys(lastName); //Fill Last name
		driver.findElement(By.id("email_address")).sendKeys(email); //Fill Email Address
		driver.findElement(By.id("password")).sendKeys(pass); //Fill Password
		driver.findElement(By.id("confirmation")).sendKeys(confirmPass); //Fill Confirm Password
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@title='Register']")).click(); //Click "Register" button
		Thread.sleep(5000);
		if(driver.getPageSource().contains("Thank you for registering with Main Website Store"))
			System.out.println("Register successfully. Pass");
		else
			System.out.println("Test 1 fail");
	}

	//Logout from the system
	public static void logout() throws InterruptedException{
		Common cm = new Common(driver);
		driver.findElement(By.xpath("//span[@class='label' and text()='Account']")).click();
		driver.findElement(By.xpath("//a[@title='Log Out']")).click();
		cm.closeUrl();
	}

	//Register account fail
	public static void registerFail(String firstName, String lastName, String email, String pass, String confirmPass) throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		Common cm = new Common(driver);
		cm.openUrl(createAcc);
		//Fill new data
		driver.findElement(By.id("firstname")).sendKeys(firstName); //Fill First name
		driver.findElement(By.id("lastname")).sendKeys(lastName); //Fill Last name
		driver.findElement(By.id("email_address")).sendKeys(email); //Fill Email Address đã được dăng kí trước đó
		driver.findElement(By.id("password")).sendKeys(pass); //Fill Password
		driver.findElement(By.id("confirmation")).sendKeys(confirmPass); // Fill Confirm Password
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@title='Register']")).click(); //Click "Register" button
		Thread.sleep(5000);
		if(driver.getPageSource().contains("There is already an account with this email address"))
			System.out.println("Register fail due to duplicate email . Pass");
		else
			System.out.println("Test 2 fail");

		cm.closeUrl();
	}

	//Create main function
	public static void main(String[] args) throws InterruptedException{
		String firstName1 = "Vu";
		String lastName1 = "Bich";
		String email1 = "thaibinh521@gmail.com";
		String pass1= "123456789";
		String confirmPass1 = "123456789";
		String firstName2 = "Bui";
		String lastName2 = "Phung";
		String pass2 = "1234567890";
		String confirmPass2 = "1234567890";
		//Register account successful
		registerSuccess(firstName1, lastName1, email1, pass1, confirmPass1);
		//Logout from the sysstem
		logout();
		//Register account fail
		registerFail(firstName2, lastName2, email1, pass2, confirmPass2);

	}
}
