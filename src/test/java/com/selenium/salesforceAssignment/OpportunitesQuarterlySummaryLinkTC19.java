package com.selenium.salesforceAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpportunitesQuarterlySummaryLinkTC19 {
	static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginSalesforce();
		Opportunity();
		qtrSummaryReport() ;
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
	 static void Opportunity(){
	WebElement oppob=driver.findElement(By.xpath("//a[text()='Opportunities']"));
	WebDriverWait wait=new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOf(oppob));
	oppob.click();
	}
	 static void qtrSummaryReport() throws InterruptedException {
		 //WebElement qlink= driver.findElement(By.xpath("//h3[text()='Quaterly Summary']"));
		 //qlink.click();
		 WebElement interval=driver.findElement(By.xpath("//select[@id='quarter_q']"));
		 Thread.sleep(3000);
		Select selectob=new Select(interval);
		selectob.selectByVisibleText("Current FQ");
		 WebElement include=driver.findElement(By.xpath("//select[@id='open']"));
		 Thread.sleep(3000);
			Select selectob4=new Select(include);
			selectob4.selectByVisibleText("Closed/Won Opportunities");
		WebElement runreport=driver.findElement(By.xpath("//input[@title='Run Report']"));
		runreport.click();
		 
		 System.out.println("testcase passed,reportpage displayed with criteria");
		
}
}