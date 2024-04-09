package com.selenium.salesforceAssignment;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class opportubitiesDropdownVeifyTC15 {
	static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginSalesforce();
		Opportunity();
		verifydropDown();
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
	 static void Opportunity(){
	WebElement oppob=driver.findElement(By.xpath("//a[text()='Opportunities']"));
	WebDriverWait wait=new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOf(oppob));
	oppob.click();
	}
	 
	 static void verifydropDown() {
	WebElement oppDropDown=driver.findElement(By.xpath("//select[@id='fcf']"));
	WebDriverWait wait1=new WebDriverWait(driver,10);
	wait1.until(ExpectedConditions.visibilityOf(oppDropDown));
	oppDropDown.click();
	System.out.println("opportunity dropdown is clicked,testcase passed");
	}
}
