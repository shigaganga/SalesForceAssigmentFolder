package com.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalculatorAssignment {
	static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		logintoApplication();
		calculatortab();
	calcOperations();
	driver.close();
	}

	static void logintoApplication() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		
	   driver.get("https://selenium-prd.firebaseapp.com/");
	   Thread.sleep(2000);
	   WebElement email = driver.findElement(By.id("email_field"));
	   email.sendKeys("admin123@gmail.com");
	   
	   WebElement password = driver.findElement(By.id("password_field"));
	   password.sendKeys("admin123");
	   
	   WebElement login = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
	   login.click();
	  
	}
	static void calculatortab() throws InterruptedException {
		WebElement calculatorElement = driver.findElement(By.xpath("//a[contains(text(),'Calculator')]"));
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		//action.moveToElement(calculatorElement).build().perform();
		action.doubleClick(calculatorElement).build().perform();
		
	}
static void calcOperations() throws InterruptedException {
	
	WebElement four=driver.findElement(By.xpath("//input[@value='4']"));
	Thread.sleep(2000);
	four.click();
	
	WebElement mult=driver.findElement(By.xpath("//input[@value='x']"));
	Thread.sleep(2000);
	mult.click();
	mult.sendKeys("*");
	WebElement six=driver.findElement(By.xpath("//input[@value='3']"));
	Thread.sleep(1000);
	six.click();
	WebElement equals=driver.findElement(By.xpath("//input[@value='=']"));
	Thread.sleep(2000);
	equals.click();

	WebElement displays=driver.findElement(By.id("display"));
	Thread.sleep(2000);
		System.out.print("Result="+displays.getAttribute("value"));

}
}
