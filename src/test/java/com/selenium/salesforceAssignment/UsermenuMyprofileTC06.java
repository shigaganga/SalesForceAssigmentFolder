



package com.selenium.salesforceAssignment;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UsermenuMyprofileTC06 {
	static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginSalesforce();
		usermenuDropdown();
		myProfileMethod();	}
	
	static void LoginSalesforce() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.get("https://www.salesforce.com/login");
		Thread.sleep(2000);
		WebElement usernamefield=driver.findElement(By.id("username"));
		usernamefield.sendKeys("shiga@tekarch.com");
		WebElement passwordfield=driver.findElement(By.id("password"));
		passwordfield.sendKeys(" Kanmani@2018");
		WebElement login=driver.findElement(By.id("Login"));
		
		login.click();
	}
	static void usermenuDropdown() throws InterruptedException {
		WebElement usernameElement = driver.findElement(By.id("userNavLabel"));
		Thread.sleep(3000);
		usernameElement.click();}

		public static void myProfileMethod() throws InterruptedException {
		WebElement myProfile=driver.findElement(By.xpath("//a[@title='My Profile']"));
		Thread.sleep(2000);
		myProfile.click();
		WebElement editPen=driver.findElement(By.xpath("//*[@id='chatterTab']/div[2]/div[2]/div[1]/h3/div/div/a/img"));
		Thread.sleep(2000);
		editPen.click();
	driver.switchTo().frame("contactInfoContentId");
		WebElement about=driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		Thread.sleep(5000);
		about.click();
		WebElement lastname=driver.findElement(By.id("lastName"));
		Thread.sleep(5000);
		lastname.clear();
		lastname.sendKeys("Ganga");
		WebElement saveAll=driver.findElement(By.xpath("//input[@value='Save All']"));
		Thread.sleep(5000);
		saveAll.click();
	driver.switchTo().defaultContent();
		WebElement post=driver.findElement(By.xpath("//a[@id='publisherAttachTextPost']/span[1]"));
		Thread.sleep(3000);
		post.click();
		WebElement frameEle=driver.findElement(By.xpath("//iframe[@title='Rich Text Editor, publisherRichTextEditor']"));
   driver.switchTo().frame(frameEle);
		WebElement textArea=driver.findElement(By.xpath("/html/body"));
	Thread.sleep(3000);
		textArea.sendKeys("Hello teams");
	driver.switchTo().defaultContent();
		WebElement share=driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
		Thread.sleep(3000);
		share.click();
		
		
		//Actions action = new Actions(driver);
		//action.click(share).build().perform();
	WebElement file=driver.findElement(By.xpath("//a[@id='publisherAttachContentPost']/span[1]"));
	file.click();
	WebElement uploadfile=driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']"));
	uploadfile.click();
	WebElement chosefile1=driver.findElement(By.xpath("//input[@id='chatterFile']"));
	chosefile1.sendKeys("C:\\Users\\shiga\\imagesProfile.jpg");
	
	WebElement moderator=driver.findElement(By.id("displayBadge"));
	Actions action=new Actions(driver);
	action.moveToElement(moderator).build().perform();
	WebElement uploadphoto=driver.findElement(By.xpath("//a[text()='Add Photo']"));
	WebDriverWait wait = new WebDriverWait(driver , 10);
		wait.until(ExpectedConditions.elementToBeClickable(uploadphoto));
	if(uploadphoto.isDisplayed())
	uploadphoto.click();
	WebElement frame1=driver.findElement(By.id("uploadPhotoContentId"));//"C:\Users\shiga\imagesProfile.jpg"
	driver.switchTo().frame(frame1);
	WebElement choosefile=driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadInputFile']"));
	WebDriverWait wait2=new WebDriverWait(driver, 20);
	wait2.until(ExpectedConditions.visibilityOf(choosefile));
			
choosefile.sendKeys("C:\\Users\\shiga\\imagesProfile.jpg");
WebElement save=driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadBtn']"));
Thread.sleep(6000);
save.click();
driver.switchTo().defaultContent();
WebElement frame3=driver.findElement(By.id("uploadPhotoContentId"));
Thread.sleep(6000);
WebElement save2=driver.findElement(By.xpath("//input[@id='j_id0:j_id7:save']"));
WebDriverWait wait3=new WebDriverWait(driver, 20);
wait2.until(ExpectedConditions.visibilityOf(save2));
save2.click();

}}