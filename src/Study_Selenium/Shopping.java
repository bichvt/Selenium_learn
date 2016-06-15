package Study_Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * 4. Shopping
URL: http://live.guru99.com
- Chọn sản phẩm
- Điền số lượng
- Điền đầy đủ thông tin form để hoàn thành quá trình shopping
 */ 

public class Shopping {
	public static String mobilePage = "http://live.guru99.com/index.php/mobile.html";
	public static WebDriver driver = new FirefoxDriver();

	//Add product to cart
	public static void addCart() throws InterruptedException{
		Common cm = new Common(driver);
		cm.openUrl(mobilePage);
		//Chọn sản phẩm là Samsung Galaxy and click Add to Cart button
		driver.findElement(By.xpath("//img[@id='product-collection-image-3']")).click();
		//Xóa số lượng cũ
		driver.findElement(By.id("qty")).clear();
		//Điền số lượng muốn mua
		driver.findElement(By.id("qty")).sendKeys("3");
		//Click Add to Cart
		driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
		//Click button [Proceed to Checkout] để đi tiếp
		driver.findElement(By.xpath("//button[@title='Proceed to Checkout']")).click();
		Thread.sleep(5000);
	}

	public static void checkoutMethod() throws InterruptedException{
		Common cm = new Common(driver);
		//Chon [Check out as Guest]
		driver.findElement(By.id("login:guest")).click();
		//Click tiếp Continue button
		driver.findElement(By.id("onepage-guest-register-button")).click();
		Thread.sleep(5000);
	}
	public static void billingInformation() throws InterruptedException{
		Common cm = new Common(driver);
		/** Fill thong tin can thiet cua Guest */
		driver.findElement(By.id("billing:firstname")).sendKeys("Nguyen"); //fill first name
		driver.findElement(By.id("billing:lastname")).sendKeys("Tuan Hung"); //fill last name
		driver.findElement(By.id("billing:email")).sendKeys("hungnt14@gmail.com"); //fill email address
		driver.findElement(By.id("billing:street1")).sendKeys("toa nha FPT, Duy Tan"); //fill address
		Select country = new Select(driver.findElement(By.xpath("//*[@name='billing[country_id]']/../select"))); // Chon country
		country.selectByVisibleText("Vietnam");
		country.selectByValue("VN");
		driver.findElement(By.id("billing:city")).sendKeys("Ha Noi"); //fill city
		driver.findElement(By.id("billing:postcode")).sendKeys("84"); //fill zip
		driver.findElement(By.id("billing:telephone")).sendKeys("0934496956"); //fill telephone
		driver.findElement(By.xpath("//button[@title='Continue']")).click(); //Click Continue button
		Thread.sleep(5000);
	}
	public static void shippingMethod() throws InterruptedException{
		Common cm = new Common(driver);
		driver.findElement(By.xpath("//button[@onclick='shippingMethod.save()']")).click(); //Click Continue button
		Thread.sleep(5000);
	}
	public static void paymentInformation() throws InterruptedException{
		Common cm = new Common(driver);
		driver.findElement(By.id("p_method_checkmo")).click(); // Chọn radio button [Check/Money order]
		driver.findElement(By.xpath("//button[@onclick='payment.save()']")).click(); // Click Continue button
		Thread.sleep(5000);
	}
	public static void orderReview() throws InterruptedException{
		Common cm = new Common(driver);
		driver.findElement(By.xpath("//button[@title='Place Order']")).click(); // Click Place Order button
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

	//main function
	public static void main(String[] args) throws InterruptedException{
		addCart();
		checkoutMethod();
		billingInformation();
		shippingMethod();
		paymentInformation();
		orderReview();
	}
}