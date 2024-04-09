package com.selenium.salesforceAssignment;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RandomScenarioBlockEventTc36 {
	static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginSalesforce();
		 HomeTab();
		 EventCalender();
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
	private static void HomeTab() throws InterruptedException {
		WebElement HomeObj=driver.findElement(By.xpath("//a[text()='Home']"));
		Thread.sleep(1000);	
		HomeObj.click();
//Actions action=new Actions(driver);
//action.click(HomeObj).build().perform();
		System.out.println("home page is displayed");
	}
	private static void EventCalender() throws InterruptedException {
		WebElement calendelink=driver.findElement(By.xpath("//div[@id=\"ptBody\"]/div/div[2]/span[2]/a"));
		calendelink.click();
		//div[@id="p:f:j_id25:j_id61:28:j_id64"]/a
		WebElement eightPM=driver.findElement(By.xpath("//div[@id='p:f:j_id25:j_id61:28:j_id64']"));
		eightPM.click();
		String currentWindowHandle=driver.getWindowHandle();
		System.out.println("Title of the current window:" + driver.getTitle());
		WebElement subjectombo=driver.findElement(By.xpath("//table[@class='detailList']/tbody/tr[2]/td[2]/div/a/img"));
		WebDriverWait wait = new WebDriverWait(driver , 10);
		wait.until(ExpectedConditions.elementToBeClickable(subjectombo));
		subjectombo.click();
		Set<String>windowHandles=driver.getWindowHandles();
		for(String newWindowHandle:windowHandles) {
			 if (!newWindowHandle.equals(currentWindowHandle))
		        {
				 driver.switchTo().window(newWindowHandle);
		        }	
	}	
	
		System.out.println("Title of the new window:" + driver.getTitle());	
WebElement otherOption=driver.findElement(By.xpath("//div[2][@class='choicesBox tertiaryPalette brandSecondaryBrd']/ul/li[5]/a"));
WebDriverWait wait2 = new WebDriverWait(driver , 10);
wait.until(ExpectedConditions.elementToBeClickable(otherOption));
otherOption.click();
driver.switchTo().window(currentWindowHandle);
WebElement endTime=driver.findElement(By.xpath("//input[@id='EndDateTime_time']"));
endTime.clear();
endTime.sendKeys("9:00 PM");
//Select selectobj=new Select(endTime);
//selectobj.selectByIndex(9);
WebElement saveEvent=driver.findElement(By.xpath("//td[@id='bottomButtonRow']/input[1]"));
saveEvent.click();
System.out.println("Testcasepassed event displayed");
	}}
