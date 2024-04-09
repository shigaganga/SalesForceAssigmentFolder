package com.selenium.salesforceAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AccountCreateTC10 {
	static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginSalesforce();
		AccountPageLogin();
		newAccountCreate();
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
	static void newAccountCreate() throws InterruptedException {
	WebElement newbutton=driver.findElement(By.xpath("//input[@name='new']"));
	Thread.sleep(1000);
	newbutton.click();
	WebElement Accountname=driver.findElement(By.xpath(" //input[@id='acc2']"));
	Accountname.clear();
	Accountname.sendKeys("Selenium Automation");
	
	WebElement type=driver.findElement(By.xpath("//select[@id='acc6']"));
	Select selectob=new Select(type);
	selectob.selectByVisibleText("Technology Partner");
	
	WebElement priority=driver.findElement(By.xpath("//select[@id='00NHp00000blNWX']"));
	Thread.sleep(2000);
	Select selectob2=new Select(priority);
	selectob2.selectByVisibleText("High");
	
	WebElement sLA=driver.findElement(By.xpath("//select[@id='00NHp00000blNWZ']"));
	Thread.sleep(2000);
	Select selectob3=new Select(sLA);
	selectob3.selectByVisibleText("Gold");

	WebElement SLAnum=driver.findElement(By.xpath("	//input[@id='00NHp00000blNWb']"));
	Thread.sleep(2000);
	SLAnum.clear();
	SLAnum.sendKeys(" 2568");
	WebElement date=driver.findElement(By.xpath("//input[@id='00NHp00000blNWa']"));
	date.sendKeys("3/12/2024");
	WebElement save=driver.findElement(By.xpath("//td[@id=\"topButtonRow\"]/input[1]"));
	Thread.sleep(1000);
	save.click();
	System.out.println("testcase passed,new Account page is displayed");
}
}
