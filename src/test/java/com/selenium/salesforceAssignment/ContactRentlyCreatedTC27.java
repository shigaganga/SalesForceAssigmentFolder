package com.selenium.salesforceAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactRentlyCreatedTC27 {
	static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginSalesforce();
		contactTab();
	RecentlyCreatedContact();

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

	private static void contactTab() throws InterruptedException {
		WebElement contactObj=driver.findElement(By.xpath("//li[@id=\"Contact_Tab\"]/a"));
		Thread.sleep(1000);
		Actions action=new Actions(driver);
		action.click(contactObj).build().perform();
		System.out.println("contact page is displayed");
	}
	private static void RecentlyCreatedContact() {
		WebElement rightDropdownBox=driver.findElement(By.id("hotlist_mode"));
		Select selectob=new Select(rightDropdownBox);
		selectob.selectByVisibleText("Recently Created");
		System.out.println("testcase passed,recently created contact page is displayed");
	}

}
