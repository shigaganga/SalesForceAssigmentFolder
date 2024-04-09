package com.selenium.salesforceAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeadTodaysLeadTC23 {
	static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginSalesforce();
		lead();
Defaultview();
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
		//a[@title='Leads Tab - Selected']
		WebElement leadobj=driver.findElement(By.xpath("//a[text()='Leads']"));
		Thread.sleep(4000);
		Actions action=new Actions(driver);
		action.doubleClick(leadobj).build().perform();
		System.out.println("leadpage displayed");
}
	static void Defaultview() throws InterruptedException{
		WebElement viewbox=driver.findElement(By.xpath("//select[@id='fcf']"));
		Select selectob3=new Select(viewbox);//form[@id='filter_element']/div/span/span[1]/input"
		selectob3.selectByVisibleText("Today's Leads");
		WebElement go=driver.findElement(By.xpath("//input[@title='Go!']"));
		go.click();
		System.out.println("Todays Lead page is displayed");

	}

}
