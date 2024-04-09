package com.selenium.salesforceAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserMenuMysettingsTC07 {
	static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginSalesforce();
		usermenuDropdown();
		mySettings() ;
		PersonalDisplay();
		emailLink();
		 calenderRemainders();
		 
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
static void mySettings() throws InterruptedException {
	WebElement settings=driver.findElement(By.xpath("//a[@title='My Settings']"));
	settings.click();
}
static void PersonalDisplay() throws InterruptedException {
	
	WebElement personal=driver.findElement(By.id("PersonalInfo_font"));
	personal.click();
	WebElement loginHistory=driver.findElement(By.id("LoginHistory_font"));
	loginHistory.click();
	WebElement displayFormat=driver.findElement(By.id("DisplayAndLayout_font"));
	Thread.sleep(2000);
	displayFormat.click();
	WebElement customizTab=driver.findElement(By.xpath("//span[@id='CustomizeTabs_font']"));
	customizTab.click();
	WebElement selectId=driver.findElement(By.xpath("//select[@id='p4']"));
	Thread.sleep(2000);
	Select chatterSel=new Select(selectId);
	chatterSel.selectByVisibleText("Salesforce Chatter");
	WebElement report=driver.findElement(By.xpath("//option[@value='report']"));
	Thread.sleep(2000);
	report.click();
	WebElement add= driver.findElement(By.xpath("//img[@title='Add']"));
	Thread.sleep(2000);
	add.click();
	WebElement save=driver.findElement(By.xpath("//input[@title='Save']"));
	Thread.sleep(2000);
	save.click();
}
static void emailLink() throws InterruptedException {
	WebElement email=driver.findElement(By.xpath("//div[@id=\"EmailSetup\"]/a"));
	Thread.sleep(2000);
	email.click();
	WebElement emailSettings=driver.findElement(By.xpath("//span[@id='EmailSettings_font']"));
	Thread.sleep(2000);
	emailSettings.click();
	WebElement emailNameBox=driver.findElement(By.xpath("//input[@id='sender_name']"));
	emailNameBox.clear();
	emailNameBox.sendKeys("Shiga");
	WebElement emailBox=driver.findElement(By.xpath("//input[@id='sender_email']"));
	emailBox.clear();
	emailBox.sendKeys("Shigaganga@gmail.com");
	
	WebElement bccradioButton=driver.findElement(By.xpath("//input[@id='auto_bcc0']"));
	if(!bccradioButton.isSelected()) {
		bccradioButton.click();
	}
		WebElement save=driver.findElement(By.xpath("//input[@title='Save']"));
		save.click();
	}
static void calenderRemainders() throws InterruptedException {
	WebElement calender=driver.findElement(By.id("CalendarAndReminders_font"));
	Thread.sleep(2000);
	calender.click();
	WebElement activityRemainder=driver.findElement(By.xpath("//span[@id='Reminders_font']"));
	Thread.sleep(2000);
	activityRemainder.click();
	WebElement openRemainder=driver.findElement(By.id("testbtn"));
	openRemainder.click();
	System.out.println("Test case is passed,calender remainder works fine");
	
	
} 
}
