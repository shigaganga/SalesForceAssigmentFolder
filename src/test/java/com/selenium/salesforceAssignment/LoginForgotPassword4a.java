package com.selenium.salesforceAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginForgotPassword4a {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeDriver driver=new ChromeDriver();
driver.get("https://www.salesforce.com/login");
Thread.sleep(2000);
WebElement forgotPW=driver.findElement(By.id("forgot_password_link"));
forgotPW.click();
WebElement forgotusername=driver.findElement(By.xpath("//input[@id='un']"));
forgotusername.sendKeys("shiga@tekarch.com");
WebElement continueEle=driver.findElement(By.xpath("//input[@id='continue']"));
continueEle.click();
System.out.println("testcase passed,forgot password window opened ");
	}

}

