package com.selenium.salesforceAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RandomScenariosEditProfileTC34 {
	static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginSalesforce();
		 HomeTab();
		 EditLastname();
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
	private static void EditLastname() throws InterruptedException {
		WebElement nameLink=driver.findElement(By.xpath("//div[@id=\"ptBody\"]/div/div[2]/span[1]/h1/a"));
		nameLink.click();
		WebElement editPen=driver.findElement(By.xpath("//*[@id='chatterTab']/div[2]/div[2]/div[1]/h3/div/div/a/img"));
		Thread.sleep(2000);
		editPen.click();
	driver.switchTo().frame("contactInfoContentId");
		WebElement about=driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		Thread.sleep(5000);
		about.click();
		WebElement lastname=driver.findElement(By.id("lastName"));
		Thread.sleep(5000);
		lastname.clear();
		lastname.sendKeys("abcd");
		WebElement saveAll=driver.findElement(By.xpath("//input[@value='Save All']"));
		Thread.sleep(5000);
		saveAll.click();
		System.out.println("updated lastname is displayed");
		
	}
}
