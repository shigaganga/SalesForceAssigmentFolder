package com.selenium.salesforceAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactMyContactViewTC28 {
	static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginSalesforce();
		contactTab();
		MyContactview();
	}
	
	
	
	static void LoginSalesforce() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.get("https://www.salesforce.com/login");
		Thread.sleep(2000);
		WebElement usernamefield=driver.findElement(By.id("username"));
		usernamefield.clear();
		usernamefield.sendKeys("shiga@tekarch.com");
		WebElement passwordfield=driver.findElement(By.id("password"));
		passwordfield.clear();
		passwordfield.sendKeys(" Kanmani@2018");
		WebElement login=driver.findElement(By.id("Login"));
		login.click();
	}

	private static void contactTab() throws InterruptedException {
		WebElement contactObj=driver.findElement(By.xpath("//li[@id=\"Contact_Tab\"]/a"));
		Thread.sleep(1000);
		Actions action=new Actions(driver);
		action.click(contactObj).build().perform();
		System.out.println("contact page is displayed");
	}
	private static void MyContactview() throws InterruptedException {
		WebElement viewDropdownBox=driver.findElement(By.xpath("//select[@name='fcf']"));
		Thread.sleep(5000);
		Select selectob=new Select(viewDropdownBox);
		selectob.selectByVisibleText("My Contacts");
		System.out.println("testcase passed,My contacts page view is page is displayed");
		
	}
	
}
