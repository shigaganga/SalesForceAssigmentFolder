package com.selenium.salesforceAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AccountReportTC14 {
	static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginSalesforce();
		AccountPageLogin();
	AccountReport();
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
	private static void AccountReport() throws InterruptedException {
	WebElement lastactivity=driver.findElement(By.xpath("//a[text()='Accounts with last activity > 30 days']"));
	Thread.sleep(3000);
	lastactivity.click();
	System.out.println("Last activity displayed");
		//WebElement datefield=driver.findElement(By.xpath("//input[@name='dateColumn']"));
		//Thread.sleep(5000);
		//WebElement datearrow=driver.findElement(By.xpath("//img[@id='ext-gen148']"));
		//Select selectob=new Select(datearrow);
		//selectob.selectByVisibleText("Last Activity");
		WebElement from=driver.findElement(By.xpath("//input[@id=\"ext-comp-1042\"]"));
		from.sendKeys("3/2/2024");
		//enterkey
		from.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		WebElement Savebutton=driver.findElement(By.id("ext-gen49"));
		Savebutton.click();
		WebElement reportname=driver.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']"));
		reportname.sendKeys("lastactivityReport");
		WebElement uniquename=driver.findElement(By.xpath("//input[@id='saveReportDlg_DeveloperName']"));
		uniquename.click();
		Thread.sleep(2000);
		WebElement save=driver.findElement(By.xpath("//table[@id='dlgSaveAndRun']/tbody/tr[2]/td[2]/em/button"));
		save.click();
		
		
		
		 
		System.out.println("testcase passed");
	}

	}

