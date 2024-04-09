package com.selenium.salesforceAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginErrorMessageTC1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.salesforce.com/login");
		Thread.sleep(2000);
		WebElement usernamefield=driver.findElement(By.id("username"));
		usernamefield.sendKeys("shiga@tekarch.com");
		WebElement passwordfield=driver.findElement(By.id("password"));
		passwordfield.sendKeys(" ");
		WebElement login=driver.findElement(By.id("Login"));
		login.click();
		WebElement error=driver.findElement(By.xpath("//div[@id='error']"));
		String expectederrormsg="Please enter your password.";
		String actualerrormsg=error.getText();
		System.out.println(actualerrormsg);
		if(expectederrormsg.equals(actualerrormsg))
		System.out.println("testcase is passed,both actual and expected are same message");
	
	}

}