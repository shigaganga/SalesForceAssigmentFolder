
package com.selenium.salesforceAssignment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AccountMergeTC13 {
	static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginSalesforce();
		AccountPageLogin();
		merge();
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

public static void merge() throws InterruptedException {
	WebElement mergeAccount=driver.findElement(By.xpath("//a[text()='Merge Accounts']"));
	mergeAccount.click();
	WebElement srchBox=driver.findElement(By.xpath("//input[@id='srch']"));
	srchBox.sendKeys("me");
	//form[@id="stageForm"]/div/div[2]/div[4]/input[2]
	WebElement findAccounts=driver.findElement(By.xpath("//form[@id='stageForm']/div/div[2]/div[4]/input[2]"));
	findAccounts.click();
	WebElement next=driver.findElement(By.xpath("//form[@id='stageForm']/div/div[2]/div[5]/div/input[1]"));
	Thread.sleep(5000);
	next.click();
	WebElement merge=driver.findElement(By.xpath("//form[@id='stageForm']/div/div[2]/div[5]/div/input[2]"));
	Thread.sleep(5000);
	merge.click();
	Alert alertob=driver.switchTo().alert();
	alertob.accept();
	System.out.println("Account page displayed with merged account");//second run error so create new account selenium
	
}
}
