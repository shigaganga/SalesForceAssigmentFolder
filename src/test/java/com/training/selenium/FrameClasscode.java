package com.training.selenium;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class FrameClasscode { 
		
		public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.globalsqa.com/demo-site/select-elements/");
			Thread.sleep(4000);
			
			WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
			
			driver.switchTo().frame(frame);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//li[contains(text(),'Item ')]")).click();
		    driver.close();
		    
		    //Different between driver.close and driver.quit.

		}

	}