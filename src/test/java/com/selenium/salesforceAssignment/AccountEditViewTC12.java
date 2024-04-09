

package com.selenium.salesforceAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AccountEditViewTC12 {

	static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginSalesforce();
		AccountPageLogin();
	Editview();
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
	static void Editview() throws InterruptedException {
	WebElement selectView=driver.findElement(By.xpath("//select[@name='fcf']"));
	Thread.sleep(3000);
	Select selectobj=new Select(selectView);
	selectobj.selectByVisibleText("newSeleniumAutoView");
	WebElement edit=driver.findElement(By.xpath("//a[text()='Edit']"));
	Thread.sleep(2000);
	edit.click();
	WebElement viewname=driver.findElement(By.xpath("//input[@id='fname']"));
	viewname.clear();
	viewname.sendKeys(" viewnewSeleniumAutoView");
	WebElement viewUniquename=driver.findElement(By.xpath("//input[@id='devname']"));
	Thread.sleep(5000);
	//viewUniquename.clear();
	viewUniquename.click();//custome validation error on second run pgm,this unique name already exist
	//select[@id='fcol1']
	WebElement AccountName=driver.findElement(By.xpath("//select[@id='fcol1']"));
	Select select1=new Select(AccountName);
	select1.selectByVisibleText("Account Name");
	WebElement equals=driver.findElement(By.xpath("//select[@id='fop1']"));
	Select select2=new Select(equals);
	select2.selectByVisibleText("equals");
	WebElement value1=driver.findElement(By.xpath("//input[@name='fval1']"));
	value1.sendKeys("a");
	WebElement lastActivity=driver.findElement(By.xpath("//select[@id='colselector_select_0']/option[32]"));
	lastActivity.click();
	//a[@id='colselector_select_0_right']/img
	WebElement Add=driver.findElement(By.xpath("//a[@id='colselector_select_0_right']/img"));
	Add.click();
	WebElement save2=driver.findElement(By.xpath("//form[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1] "));
	Thread.sleep(3000);
	save2.click();//if i am again run no such element exception because viewname changed to newviewname
	System.out.println("testcase passed");
	}
}