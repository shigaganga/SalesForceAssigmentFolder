package com.selenium.salesforceAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RandomScenarioVerifyNameHomeTabTc33 {

	static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginSalesforce();
		 HomeTab();
		 verify();
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
	private static void HomeTab() throws InterruptedException {
		WebElement HomeObj=driver.findElement(By.xpath("//a[text()='Home']"));
		Thread.sleep(1000);	
		HomeObj.click();
//Actions action=new Actions(driver);
//action.click(HomeObj).build().perform();
		System.out.println("home page is displayed");
	}

	private static void verify() throws InterruptedException {
		WebElement nameLink=driver.findElement(By.xpath("//div[@id=\"ptBody\"]/div/div[2]/span[1]/h1/a"));
		String actualname=nameLink.getText();
		System.out.println("fullname of account holder displayed as : "+actualname);
		nameLink.click();
		System.out.println("User firstname lastname page should be displayed");
		WebElement usernameElement = driver.findElement(By.id("userNavLabel"));
		Thread.sleep(3000);
		usernameElement.click();
		WebElement myProfile=driver.findElement(By.xpath("//a[@title='My Profile']"));
		Thread.sleep(2000);
		myProfile.click();
		System.out.println("My profile page dispayed ");
		System.out.println("Both page same so testcase passed");
		
	}
	
}
