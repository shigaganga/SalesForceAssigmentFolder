package com.selenium.salesforceAssignment;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactEditCheckSaveAndNewTC32 {
	static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginSalesforce();
		contactTab();
		editview();

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

	private static void contactTab() throws InterruptedException {
		WebElement contactObj=driver.findElement(By.xpath("//li[@id=\"Contact_Tab\"]/a"));
		Thread.sleep(1000);
		Actions action=new Actions(driver);
		action.click(contactObj).build().perform();
		System.out.println("contact page is displayed");
		
	}
	static void editview() throws InterruptedException {//td[@id="bottomButtonRow"]/input[1]
		WebElement newbutton=driver.findElement(By.xpath("//form[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		Thread.sleep(5000);
		newbutton.click();
		WebElement continueEle=driver.findElement(By.xpath("//input[@title='Continue']"));
		Thread.sleep(5000);
		continueEle.click();		
		WebElement lastname=driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		lastname.sendKeys("Indian1");
		 String currentWindowHandle=driver.getWindowHandle();
		 System.out.println("title of current window;"+driver.getTitle());
		 WebElement accname=driver.findElement(By.xpath("//input[@id='con4']"));
			WebElement Searchicon=driver.findElement(By.xpath("//a[@id='con4_lkwgt']/img"));
			Searchicon.click();
			Set<String>windowHandles=driver.getWindowHandles();
			for(String newWindowHandle:windowHandles) {
				 if (!newWindowHandle.equals(currentWindowHandle))
			        {
			        
					 driver.switchTo().window(newWindowHandle);
			        }
					
		}

			System.out.println("Title of the new window:" + driver.getTitle());	
		WebElement frameEle=driver.findElement(By.xpath("//frame[@id='searchFrame']"));
		Thread.sleep(1000);
		driver.switchTo().frame(frameEle);
		WebElement input=driver.findElement(By.xpath("//form[@id='theForm']/div/div[2]/input[1]"));
		input.sendKeys("sa");
		Thread.sleep(1000);
		WebElement go=driver.findElement(By.xpath("//input[@name='go']"));
		Thread.sleep(1000);
		go.click();
		driver.switchTo().defaultContent();
		WebElement frameEle2=driver.findElement(By.xpath("//frame[@id='resultsFrame']"));
		driver.switchTo().frame(frameEle2);
		WebElement table=driver.findElement(By.xpath("//form[@id='new']/div/div[3]/div/div[2]/table/tbody/tr[2]/th/a"));
		//System.out.println(table.getText());
		table.click();
		driver.switchTo().window(currentWindowHandle);
		WebElement saveNew=driver.findElement(By.xpath("//td[@id='bottomButtonRow']/input[2]"));
		saveNew.click();
		System.out.println("test case passed");
	}
}
