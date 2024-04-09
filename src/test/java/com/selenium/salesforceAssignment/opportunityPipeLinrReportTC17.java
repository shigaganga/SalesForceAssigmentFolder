package com.selenium.salesforceAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class opportunityPipeLinrReportTC17 {
	static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginSalesforce();
		Opportunity();
		OppPipelineReport() ;
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
	 private static void OppPipelineReport() {
			// TODO Auto-generated method stub
		WebElement oppPipeline=driver.findElement(By.xpath("//a[text()='Opportunity Pipeline']"));
		oppPipeline.click();
		System.out.println("report Page with the Opportunities that are pipelined is displayed.");
		
		}}