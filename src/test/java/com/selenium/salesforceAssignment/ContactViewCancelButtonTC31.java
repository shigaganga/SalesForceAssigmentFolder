package com.selenium.salesforceAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactViewCancelButtonTC31 {
	static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginSalesforce();
		contactTab();
		createNewview();

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
	
	 static void createNewview() throws InterruptedException {
		 
     
		 WebElement createviewlink=driver.findElement(By.xpath("//a[text()='Create New View']"));
		 Thread.sleep(3000);
			createviewlink.click();
			WebElement viewname=driver.findElement(By.xpath("//input[@id='fname']"));
			viewname.clear();
			viewname.sendKeys(" ContactView");
		
			WebElement viewUniquename=driver.findElement(By.xpath("//input[@id='devname']"));
			Thread.sleep(5000);
			viewUniquename.clear();
			viewUniquename.sendKeys("ContactUniqueView");
			WebElement cancel=driver.findElement(By.xpath("//form[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[2]"));
			cancel.click();
			System.out.println("test case passed,canceled so return back to contact homepage");
}}
