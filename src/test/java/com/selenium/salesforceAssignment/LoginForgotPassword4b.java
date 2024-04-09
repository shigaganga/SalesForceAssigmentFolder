package com.selenium.salesforceAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginForgotPassword4b {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeDriver driver=new ChromeDriver();
driver.get("https://www.salesforce.com/login");
Thread.sleep(2000);
String expected="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
WebElement usernamefield=driver.findElement(By.id("username"));
usernamefield.sendKeys("123");
WebElement passwordfield=driver.findElement(By.id("password"));
passwordfield.sendKeys("22131 ");
WebElement login=driver.findElement(By.id("Login"));
login.click();
Thread.sleep(5000);
WebElement error=driver.findElement(By.xpath("//div[@id='error']"));
String AcualErrMsg=error.getText();
System.out.println("Actual error msg : "+AcualErrMsg);
if(expected.equals(AcualErrMsg))
System.out.println("test case passed");
	}

}


