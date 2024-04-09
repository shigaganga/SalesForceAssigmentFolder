package com.training.selenium;

	import org.openqa.selenium.By;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;

	
	import io.github.bonigarcia.wdm.WebDriverManager;

	/*  Locators 
	 *    - 8 locators , id name xpath, cssSelector className
	 *             partial link text 
	 *             Linktest
	 *             tagName
	 *    We need to identify that element uniquely 
	 *    To perform the action 
	 *    We need data . sendKeys - input data
	 *                   click ? 
	 *                   
	 *    xpath 
	 *         - Absolute 
	 *          - Relative - //tagname[@attribute='value']
	 *                       //tagname[text()='value']
	 *                       //tagname[contains(text(),'value')]
	 *          
	 *     Actions
	 *     Radio button
	 *     Checkbox
	 *     Dropdown
	 *     Alerts
	 *     
	 * 
	 * 
	 */

	public class DropdownClasscode {
	
		
		public static void main(String[] args) throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			
		   driver.get("https://selenium-prd.firebaseapp.com/");
		   Thread.sleep(2000);
		   WebElement email = driver.findElement(By.id("email_field"));
		   email.sendKeys("admin123@gmail.com");
		   
		   WebElement password = driver.findElement(By.id("password_field"));
		   password.sendKeys("admin123");
		   
		   WebElement login = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
		   login.click();
		   
		   Thread.sleep(3000);
		   WebElement home = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		   home.click();
		   
		   WebElement female = driver.findElement(By.xpath("//input[@value='female']"));
		   female.click();
		   
		   WebElement citydropdown = driver.findElement(By.id("city"));
		   Select city = new Select(citydropdown);
		   city.selectByVisibleText("GOA");
		   
		   WebElement coursedropdown = driver.findElement(By.name("course"));
		   Select course = new Select(coursedropdown);
		   course.selectByIndex(3);
		   
		   /*  We need to identify the drop down element
		    *  Create an object of Select class by passing element to constructor
		    *  the Select Object 
		    *      - 1. selectbyIndex
		    *        2. SelectbyValue
		    *        3. SelectbyVisibleText.
		    * 
		    */
		   
		   
		   
		   
		   
		   
			
			
		}
		

		
		
		
	}
