package com.selenium.salesforceAssignment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AccountCreateNewViewTC11 {
	static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginSalesforce();
		AccountPageLogin();
		
		createNewview();
		//deleteview();
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
	static void AccountPageLogin() throws InterruptedException {
		
		WebElement AccountObj=driver.findElement(By.xpath("//a[@title='Accounts Tab']"));
		Thread.sleep(1000);
		Actions action=new Actions(driver);
		action.doubleClick(AccountObj).build().perform();
	}
	 static void createNewview() throws InterruptedException {
		 WebElement createviewlink=driver.findElement(By.xpath("//a[text()='Create New View']"));
		 Thread.sleep(3000);
			createviewlink.click();
			WebElement viewname=driver.findElement(By.xpath("//input[@id='fname']"));
			viewname.clear();
			viewname.sendKeys(" ViewName");
			WebElement viewUniquename=driver.findElement(By.xpath("//input[@id='devname']"));
			Thread.sleep(5000);
			viewUniquename.clear();
			viewUniquename.click();//custome validation error on second run pgm,this unique name already exist
			WebElement save2=driver.findElement(By.xpath("//form[@id='editPage']/div[3]/table/tbody/tr/td[2]/input[1] "));
			Thread.sleep(3000);
			save2.click();
			System.out.println("Testcase passed in createnewview");
	}
	/* static void deleteview() throws InterruptedException {
		 WebElement viewbox=driver.findElement(By.xpath("//select[@id='fcf']"));
		 Select selectobj=new Select(viewbox);
		 selectobj.selectByVisibleText("viewName");
		 WebElement edit=driver.findElement(By.xpath("//a[text()='Edit']"));
		 edit.click();
		 WebElement delete=driver.findElement(By.xpath("//form[@id='editPage']/div[3]/table/tbody/tr/td[2]/input[3]"));
		 delete.click();
		Alert alertobj= driver.switchTo().alert();
		 alertobj.accept();
	 }
	 */}		
			