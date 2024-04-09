package com.training.selenium;



	

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;

	import io.github.bonigarcia.wdm.WebDriverManager;

	/*   iframes - How to switch to frames - frame id , frame element 
	 *   Windows and tab - how to switch to windows and tab - windowhandles
	 *   Window alerts -    accept and dismiss 
	 *   close and quit 
	 *   maximize the screen
	 *   
	 *   1. Mouse Hover
	 *   2. Double Click
	 *   3. Drag and drop
	 *   4. Tool Tip
	 * 
	 */
	public class DoubleClickTooltipClassCode {
		
		static WebDriver driver;
		
		static Actions actions;
		
		
		public static void main(String[] args) throws InterruptedException {
			logintoApplication();
			homeTab();
			InteractionsTab();
			//doubleClick();
			toolTip();
		}


		static void logintoApplication() throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		   driver.get("https://selenium-prd.firebaseapp.com/");
		   Thread.sleep(2000);
		   WebElement email = driver.findElement(By.id("email_field"));
		   email.sendKeys("admin123@gmail.com");
		   
		   WebElement password = driver.findElement(By.id("password_field"));
		   password.sendKeys("admin123");
		   
		   WebElement login = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
		   login.click();
		   
		}
		
		static void homeTab() throws InterruptedException {
			  Thread.sleep(3000);
			   WebElement home = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
			   home.click();
			
		}	
		
		
		static void InteractionsTab() {
			
			WebElement interaction = driver.findElement(By.xpath("//button[contains(text(),'Intractions')]"));
			actions = new Actions(driver);
			actions.moveToElement(interaction).build().perform();
			
			
		}
		
		static void doubleClick() {
			
			driver.findElement(By.xpath("//a[contains(text(),'Double Click')]")).click();
			
			WebElement btnDoubleClick = driver.findElement(By.xpath("//button[contains(text(),'Double Click')]"));
			actions = new Actions(driver);
			actions.doubleClick(btnDoubleClick).build().perform();
		}
		
	static void toolTip() {
			
			driver.findElement(By.xpath("//a[contains(text(),'Tool Tip')]")).click();
			
			WebElement Right = driver.findElement(By.className("tooltipr"));
			actions = new Actions(driver);
			actions.moveToElement(Right).build().perform();
			
			WebElement righttooltip = driver.findElement(By.className("tooltiptextr"));
			
			String actualText = righttooltip.getText();
			String ExpectedToolTip = "Right";
			System.out.println(actualText);

			
			
			
			
			
		}
		
		
	}
