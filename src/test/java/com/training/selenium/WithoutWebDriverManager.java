package com.training.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

//we create a selenium maven project
//add dependencies for selenium and webDriverManager{

public class WithoutWebDriverManager {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
String chromepath="C:\\Users\\Public\\Desktop\\Google Chrome.lnk";
System.getProperty("webdriver.chrome.driver", chromepath);
WebDriver driver=new ChromeDriver();
driver.get("https://selenium-prd.firebaseapp.com/home.html");
WebElement emailfield=driver.findElement(By.id("email_field"));
emailfield.sendKeys("admin123@gmail.com");
WebElement passwordfield=driver.findElement(By.id("password_field"));
passwordfield.sendKeys("admin123");
WebElement login=driver.findElement(By.xpath("//button[contains(text(), 'Login to Account')]"));
login.click(); 
driver.close();

	}

}
