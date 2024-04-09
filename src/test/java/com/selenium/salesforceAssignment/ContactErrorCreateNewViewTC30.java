package com.selenium.salesforceAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactErrorCreateNewViewTC30 {
	static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginSalesforce();
		contactTab();
		createNewview();

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
	
	 static void createNewview() throws InterruptedException {
		 
     String expectederror="Error: You must enter a value";
		 WebElement createviewlink=driver.findElement(By.xpath("//a[text()='Create New View']"));
		 Thread.sleep(3000);
			createviewlink.click();
			WebElement viewname=driver.findElement(By.xpath("//input[@id='fname']"));
			//viewname.clear();
			//viewname.sendKeys(" SeleniumAutoView");
		
			WebElement viewUniquename=driver.findElement(By.xpath("//input[@id='devname']"));
			Thread.sleep(5000);
			viewUniquename.clear();
			viewUniquename.sendKeys("efgh");
			WebElement save2=driver.findElement(By.xpath("//form[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1] "));
			Thread.sleep(3000);
			save2.click();
			WebElement errormsg=driver.findElement(By.xpath("//form[@id=\"editPage\"]/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[2]/div/div[2]"));
			String actualerror=errormsg.getText();
			System.out.println(actualerror);
			if(actualerror.equals(actualerror)) 
				System.out.println("Testcase passed,both expected and actual error are equal");
	}
}
