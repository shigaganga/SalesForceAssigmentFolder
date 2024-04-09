package com.selenium.salesforceAssignment;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RandomScenarioBlockingAnEventWeekltTC37 {
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
		WebElement fourPM=driver.findElement(By.xpath("//div[@id='p:f:j_id25:j_id61:20:j_id64']"));
		fourPM.click();
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
endTime.sendKeys("7:00 PM");

//Select selectobj=new Select(endTime);
//selectobj.selectByIndex(7);
WebElement recurrence=driver.findElement(By.xpath("//input[@id='IsRecurrence']"));
//Thread.sleep(3000);
recurrence.click();
WebElement weekly=driver.findElement(By.id("rectypeftw"));
//Thread.sleep(3000);
weekly.click();
WebElement endDate=driver.findElement(By.xpath("//input[@id='RecurrenceEndDateOnly']"));
//Thread.sleep(3000);
endDate.clear();
endDate.sendKeys("4/20/2024");
System.out.println("sendkeys");
//driver.switchTo().alert().dismiss();

WebElement saveEvent=driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Save']"));
//driver.manage().window();
WebDriverWait wait3 = new WebDriverWait(driver , 10);
wait.until(ExpectedConditions.elementToBeClickable(saveEvent));
saveEvent.click();
WebElement monthview=driver.findElement(By.className("monthViewIcon"));
WebDriverWait wait4 = new WebDriverWait(driver , 10);
wait.until(ExpectedConditions.elementToBeClickable(monthview));
monthview.click();
System.out.println("Testcasepassed event edit month view displayed");
}
}