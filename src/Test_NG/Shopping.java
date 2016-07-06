package Test_NG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Shopping {
	public WebDriver driver;
	public Shopping(WebDriver dr){
		driver = dr;
	}
	/**
	 * common variables using for shopping
	 * @author BichVT
	 * @date: create new AddToCart function 20/06/2016
	 * 
	 */
	String mobilePage = "http://live.guru99.com/index.php/mobile.html";
	public By samsungGalaxyElement = By.xpath("//img[@id='product-collection-image-3']");
	public By quantityElement = By.id("qty");
	public By addCartBtn = By.xpath("//button[@title='Add to Cart']");
	public By proceedCheckoutBtn = By.xpath("//button[@title='Proceed to Checkout']");
	public By guestElement = By.id("login:guest");
	public By registerBtn = By.id("onepage-guest-register-button");
	public By guestFirstNameElement = By.id("billing:firstname");
	public By guestLastNameElement = By.id("billing:lastname");
	public By guestEmailElement = By.id("billing:email");
	public By guestStreet1Element = By.id("billing:street1");
	public By countrySelectElement = By.xpath("//*[@name='billing[country_id]']/../select");
	public By guestCityElement = By.id("billing:city");
	public By guestPostCodeElement = By.id("billing:postcode");
	public By guestPhoneElement = By.id("billing:telephone");
	public By countinuteBtn = By.xpath("//button[@title='Continue']");
	public By saveMethodShipBtn = By.xpath("//button[@onclick='shippingMethod.save()']");
	public By checkMethodRadio = By.id("p_method_checkmo");
	public By savePaymentBtn = By.xpath("//button[@onclick='payment.save()']");
	public By placeOrderBtn = By.xpath("//button[@title='Place Order']");
	
}
