package Test_Script;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import Study_Selenium.Common;

/** 1. Verify element, click, type elements
 * URL: http://only-testing-blog.blogspot.in/2013/09/test.html
 * Send key to textbox
 * Click button
 * Select checkbox/radio button
 * Click link
 * Back page
 * Verify an element in table
 * Study how to upload file (optional)
 * 
 * @author BichVT
 * @date: create new 21/06/2016
 * 
*/

public class VerifyElement {
	public static void main(String[] args) throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		Common cm = new Common(driver);
		String testUrl = "http://only-testing-blog.blogspot.in/2013/09/test.html";
		cm.openUrl(testUrl);
		By fnameElement = By.id("fname");
		By submitBtn = By.id("submitButton");
		By bikeCheckbox = By.xpath("//*[@value='Bike']");
		By boatCheckbox = By.xpath("//*[@value='Boat']");
		By maleRadio = By.xpath("//*[@value='male']");
		By homeLink = By.linkText("Home");
		By browserBtn = By.name("img");
		By comboboxElement = By.xpath("//*[@name='combo_box']/../select");
		By rowtableElement = By.xpath("//table/tbody/tr[3]/td[1]");
		//Send key to textbox
		driver.findElement(fnameElement).sendKeys("Vu Thi Bich");	
		Thread.sleep(5000);
		//Select 2 check box [I have a bike] and [I have a boat]
		driver.findElement(bikeCheckbox).click();
		driver.findElement(boatCheckbox).click();
		Thread.sleep(5000);
		//Select radio button Male
		driver.findElement(maleRadio).click();
		Thread.sleep(5000);
		//Upload file
		driver.findElement(browserBtn).sendKeys("D:\\BichVT\\Su thoi\\20160615_201915.jpg"); 
		Thread.sleep(5000);
		//Select item in combo box
		Select orderBy = new Select(driver.findElement(comboboxElement));
		orderBy.selectByVisibleText("Saab");
		orderBy.selectByValue("USA");
		//Verify an element =31 in Test table 
		String actualTableElement = driver.findElement(rowtableElement).getText();
		if(actualTableElement.equals("31"))
			System.out.println("Test Table contains element 31");
		else
			System.out.println("Test Table not contains element 31");
		//Click button Submit Query
		driver.findElement(submitBtn).click();
		Thread.sleep(5000);
		//Click link Home on the page
		driver.findElement(homeLink).click();
		Thread.sleep(5000);
		// Back page
		driver.navigate().back();
		Thread.sleep(5000);
		cm.closeUrl();
	}

}
