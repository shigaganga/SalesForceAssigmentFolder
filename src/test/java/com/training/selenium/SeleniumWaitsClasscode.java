package com.training.selenium;


	

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.FluentWait;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import io.github.bonigarcia.wdm.WebDriverManager;

	

		/*
		 * Thread.sleep - Halt the execution for given number of milisecs
		 *  3 waits 
		 *    1. implicit wait  - Driver level . it will check for the max time before it throws exception
		 *                        it performs action as soon as it finds the element 
		 *    2. explicit wait
		 *    3. Fluent Wait
		 * 
		 */
	public class SeleniumWaitsClasscode {

		static WebDriver driver;
		
		public static void main(String[] args) throws InterruptedException {
			logintoApplication();
			homeTab();
			
		}

		static void logintoApplication() throws InterruptedException {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
	        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://selenium-prd.firebaseapp.com/");
			WebElement email = driver.findElement(By.id("email_field"));
			email.sendKeys("admin123@gmail.com");

			WebElement password = driver.findElement(By.id("password_field"));
			password.sendKeys("admin123");

			WebElement login = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
			login.click();

		}

		static void homeTab() throws InterruptedException {
			WebElement home = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
			explicitwait(home,10);
			home.click();
			

		}

		
		static void explicitwait(WebElement element,int time) {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOf(element));
			
		}
		
		static void fluentWait(WebElement element,int time) {
			
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
			wait.withTimeout(time, TimeUnit.SECONDS);
			wait.pollingEvery(200, TimeUnit.MILLISECONDS);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		/* Thread Sleep - halt the execution even the element is avialable it wont start
		 * implicit wait - driver level - check all the element 
		 * Explicit wait - element level - check only the element you mention - flexible 
		 * Fluent wait -  element level - check only for the element - additional polling time 
		 * None of them halt the execution . they only throw exeception after the max time you mentioned
		 * 
		 * if the element is found early in between it will proceed with the actions. 
		 */
		
		
	}
