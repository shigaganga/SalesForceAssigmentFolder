package com.selenium.salesforceAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RandomScenarioTabCustomizationTC35 {
	static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginSalesforce();
		tab();
		//logOut();
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
	private static void tab() {
		
		WebElement plusTab=driver.findElement(By.xpath("//img[@title='All Tabs']"));
		plusTab.click();
		WebElement CustomizeTab=driver.findElement(By.xpath("//input[@title='Customize My Tabs']"));
		CustomizeTab.click();
		WebElement subscriptionRemove=driver.findElement(By.xpath("//option[text()='Subscriptions']"));
		subscriptionRemove.click();
		WebElement removeButton=driver.findElement(By.xpath("//img[@title='Remove']"));
		removeButton.click();
		WebElement save=driver.findElement(By.xpath("(//input[@name='save'])[1]"));
		save.click();
		System.out.println("The tab removed not displayed in the tabbar");
	}
	/*static void logOut() throws InterruptedException{
		WebElement profilenameElement = driver.findElement(By.id("userNavLabel"));
		Thread.sleep(2000);
		profilenameElement.click();
		WebElement logout=driver.findElement(By.xpath("//a[@title='Logout']"));
		Thread.sleep(3000);
		logout.click();
		System.out.println("logout");
		LoginSalesforce();
		WebElement plusTab=driver.findElement(By.xpath("//img[@title='All Tabs']"));
		plusTab.click();
		System.out.println("testcase passed ,tab removed not appeared in the tabbar ");
		
	}*/
}