
package com.selenium.salesforceAssignment;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UsermenuDeveloperConsoleTC08 {static ChromeDriver driver;
public static void main(String[] args) throws InterruptedException {
	LoginSalesforce();
	usermenuDropdown();
	developercon();
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
	WebElement usernameElement = driver.findElement(By.id("userNavLabel"));
	Thread.sleep(3000);
	usernameElement.click();
}

static void developercon() throws InterruptedException {
	WebElement currentwindow=driver.findElement(By.xpath("//div[@id='userNav']"));
	Thread.sleep(2000);
	String currentWindowHandle=driver.getWindowHandle();
	System.out.println("Title of the current window:" + driver.getTitle());
	WebElement developerfield=driver.findElement(By.xpath("//a[@title='Developer Console (New Window)']"));
	developerfield.click();
	Set<String>windowHandles=driver.getWindowHandles();
	for(String newWindowHandle:windowHandles) 
	 {
			driver.switchTo().window(newWindowHandle);
		}
	
	System.out.println("Title of the new window:" + driver.getTitle());
	driver.close();
	driver.switchTo().window(currentWindowHandle);
	//System.out.println("Title of the current window after closing new window:" + driver.getTitle());
	System.out.println("testcase passed");
}

}