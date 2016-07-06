package Test_NG;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Study_Selenium.Common;
import Study_Selenium.Shopping;

/**
 * 4. Shopping
URL: http://live.guru99.com
- Chọn sản phẩm
- Điền số lượng
- Điền đầy đủ thông tin form để hoàn thành quá trình shopping
 */ 

public class ShoppingScript {
	static WebDriver driver = new FirefoxDriver();
	static Common cm;
	static String mobilePage = "http://live.guru99.com/index.php/mobile.html";
	static Shopping shoppingObj;

	@Test (priority=1)
	public void addToCart() throws InterruptedException{
		driver.findElement(shoppingObj.samsungGalaxyElement).click();
		driver.findElement(shoppingObj.quantityElement).clear();
		driver.findElement(shoppingObj.quantityElement).sendKeys("4");
		driver.findElement(shoppingObj.addCartBtn).click();
		driver.findElement(shoppingObj.proceedCheckoutBtn).click();
		Thread.sleep(5000);
	}

	@Test (priority=2)
	public static void checkoutMethod() throws InterruptedException{
		//Chon [Check out as Guest]
		driver.findElement(shoppingObj.guestElement).click();
		//Click tiếp Continue button
		driver.findElement(shoppingObj.registerBtn).click();
		Thread.sleep(5000);
	}
	@Test (priority=3)
	public static void billingInformation() throws InterruptedException{
		/** Fill thong tin can thiet cua Guest */
		driver.findElement(shoppingObj.guestFirstNameElement).sendKeys("Nguyen"); //fill first name
		driver.findElement(shoppingObj.guestLastNameElement).sendKeys("Tuan Hung"); //fill last name
		driver.findElement(shoppingObj.guestEmailElement).sendKeys("hungnt14@gmail.com"); //fill email address
		driver.findElement(shoppingObj.guestStreet1Element).sendKeys("toa nha FPT, Duy Tan"); //fill address
		Select country = new Select(driver.findElement(shoppingObj.countrySelectElement)); // Chon country
		country.selectByVisibleText("Vietnam");
		country.selectByValue("VN");
		driver.findElement(shoppingObj.guestCityElement).sendKeys("Ha Noi"); //fill city
		driver.findElement(shoppingObj.guestPostCodeElement).sendKeys("84"); //fill zip
		driver.findElement(shoppingObj.guestPhoneElement).sendKeys("0934496956"); //fill telephone
		driver.findElement(shoppingObj.countinuteBtn).click(); //Click Continue button
		Thread.sleep(5000);
	}
	@Test (priority=4)
	public static void shippingMethod() throws InterruptedException{
		driver.findElement(shoppingObj.saveMethodShipBtn).click();
		Thread.sleep(5000);
	}
	@Test (priority=5)
	public static void paymentInformation() throws InterruptedException{
		driver.findElement(shoppingObj.checkMethodRadio).click(); // Chọn radio button [Check/Money order]
		driver.findElement(shoppingObj.savePaymentBtn).click(); // Click Continue button
		Thread.sleep(5000);
	}
	@Test (priority=6)
	public static void orderReview() throws InterruptedException{
		driver.findElement(shoppingObj.placeOrderBtn).click();
		Thread.sleep(5000);
		if(driver.getPageSource().contains("Thank you for your purchase!"))
		{
			System.out.println("Shopping finished successfully!"); 
		}
		else
		{
			System.out.println("Shopping not finish. Check again."); 
		}	
	}
	@BeforeTest
	public static void login()throws InterruptedException {
		cm = new Common(driver);
		cm.openUrl(mobilePage);
		shoppingObj = new Shopping(driver);
	}

	@AfterTest
	public static void closePage(){
		cm.closeUrl();
	}
}
