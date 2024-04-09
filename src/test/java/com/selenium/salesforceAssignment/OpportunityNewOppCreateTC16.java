
package com.selenium.salesforceAssignment;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpportunityNewOppCreateTC16 {

	static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginSalesforce();
		Opportunity();
		createOpportunity() ;
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
	 static void createOpportunity() throws InterruptedException {
		
		 WebElement newopp= driver.findElement(By.xpath("//form[@id='hotlist']/table/tbody/tr/td[2]/input"));
		// Thread.sleep(5000);
		 newopp.click();
		 String currentWindowHandle=driver.getWindowHandle();
			System.out.println("Title of the current window:" + driver.getTitle());
		 WebElement oppname=driver.findElement(By.xpath("//input[@id='opp3']"));
		 oppname.sendKeys("MyNewOpportunity2");
		 WebElement accname=driver.findElement(By.xpath("//input[@id='opp4']"));
		WebElement Searchicon=driver.findElement(By.xpath("//a[@id='opp4_lkwgt']/img"));
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
	WebElement closeDate=driver.findElement(By.xpath("//div[@id=\"ep\"]/div[2]/div[3]/table/tbody/tr[2]/td[4]/div/span/span/a"));
	closeDate.click();
	
	WebElement stage=driver.findElement(By.xpath("//select[@id='opp11']"));
	Select selectobj=new Select(stage);
	selectobj.selectByIndex(2);
	WebElement leadsource=driver.findElement(By.xpath("//select[@id='opp6']"));
	Select selectobj2=new Select(leadsource);
	selectobj2.selectByIndex(2);
	WebElement primaryCampaign=driver.findElement(By.xpath("//input[@id='opp17']"));
	 String currentWindowHandle2=driver.getWindowHandle();
		System.out.println("Title of the current window:" + driver.getTitle());
	
	WebElement searchicon2=driver.findElement(By.xpath("//a[@id='opp17_lkwgt']/img"));//*a* in searchbox
	searchicon2.click();
	Set<String>windowHandles2=driver.getWindowHandles();
	for(String newWindowHandle2:windowHandles2) {
		 if (!newWindowHandle2.equals(currentWindowHandle2))
	        {
	        
			 driver.switchTo().window(newWindowHandle2);
	        }
			
}

	System.out.println("Title of the new window:" + driver.getTitle());	
	WebElement frameEle4=driver.findElement(By.xpath("//frame[@id='searchFrame']"));
	Thread.sleep(1000);
	driver.switchTo().frame(frameEle4);
	WebElement input2=driver.findElement(By.xpath("//form[@id='theForm']/div/div[2]/input[1]"));
	input2.sendKeys("*a*");
	Thread.sleep(1000);
	WebElement go2=driver.findElement(By.xpath("//input[@name='go']"));
	Thread.sleep(1000);
	go2.click();
	driver.switchTo().defaultContent();
	WebElement frameEle5=driver.findElement(By.xpath("//frame[@id='resultsFrame']"));
	driver.switchTo().frame(frameEle5);
	WebElement table2=driver.findElement(By.xpath("//form[@id='new']/div/div[3]/div/div[2]/table/tbody/tr[2]/th/a"));
	//System.out.println(table.getText());
	table2.click();
	driver.switchTo().window(currentWindowHandle);
	WebElement saveopp=driver.findElement(By.xpath("//td[@id='bottomButtonRow']/input[1]"));
	saveopp.click();
	System.out.println("Testcase passed new opportunity created");
	
	}
	 }
	 
