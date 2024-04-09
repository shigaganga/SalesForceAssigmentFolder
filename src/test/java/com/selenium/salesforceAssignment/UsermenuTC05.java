package com.selenium.salesforceAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UsermenuTC05 {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
LoginSalesforce();
usermenuDropdown();

	}
	static void LoginSalesforce() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	driver.get("https://www.salesforce.com/login");
	Thread.sleep(2000);
	WebElement usernamefield=driver.findElement(By.id("username"));
	usernamefield.sendKeys("shiga@tekarch.com");
	WebElement passwordfield=driver.findElement(By.id("password"));
	passwordfield.sendKeys(" Kanmani@2018");
	WebElement login=driver.findElement(By.id("Login"));
	login.click();
}
	static void usermenuDropdown() throws InterruptedException {
		WebElement profilenameElement = driver.findElement(By.id("userNavLabel"));
		Thread.sleep(2000);
		profilenameElement.click();
		System.out.println("testcase passed,usemenudropdown visible");
	}
}

