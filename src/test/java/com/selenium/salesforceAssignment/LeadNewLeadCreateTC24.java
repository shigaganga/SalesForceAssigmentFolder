package com.selenium.salesforceAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeadNewLeadCreateTC24 {
	static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginSalesforce();
		lead();
LeadCreate();
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
		System.out.println("login to salesforce");
	}
	static void lead() throws InterruptedException {
		
		WebElement leadobj=driver.findElement(By.xpath("//a[text()='Leads']"));
		Thread.sleep(4000);
		leadobj.click();
		System.out.println("leadpage displayed");
}//form[@id='editPage']/div/div[2]/div[2]/table/tbody/tr[1]/td[2]/div/select
	private static void LeadCreate() throws InterruptedException {
		// TODO Auto-generated method stub
		WebElement newcreate=driver.findElement(By.xpath("//form[@id='hotlist']/table/tbody/tr/td[2]/input"));
		Thread.sleep(4000);
		newcreate.click();
		Thread.sleep(4000);
		WebElement lastname=driver.findElement(By.xpath("//input[@id='name_lastlea2']"));
		lastname.sendKeys("abcdef");
		WebElement companyName=driver.findElement(By.xpath("//input[@id='lea3']"));
		companyName.sendKeys("ABCDEF");
		WebElement save=driver.findElement(By.xpath("//td[@id='bottomButtonRow']/input[1]"));
		save.click();
		System.out.println("test case passed,new lead saved");
	}}