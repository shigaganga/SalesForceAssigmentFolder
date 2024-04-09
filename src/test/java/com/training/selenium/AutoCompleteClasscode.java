package com.training.selenium;


	import java.util.List;

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
	public class AutoCompleteClasscode {
		
		static WebDriver driver;
		
		static Actions actions;
		
		
		public static void main(String[] args) throws InterruptedException {
			logintoApplication();
			homeTab();
			WidgetTab();
			autocomplete("a","Afghanistan");
			
			
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
		
		
		static void WidgetTab() {
			
			WebElement widget = driver.findElement(By.xpath("//button[contains(text(),'Widget')]"));
			actions = new Actions(driver);
			actions.moveToElement(widget).build().perform();
			
			
		}
		
		static void autocomplete(String input, String ExpectedCountry) throws InterruptedException {
			WebElement autocomplete = driver.findElement(By.xpath("//a[text()='AutoComplete']"));
			Thread.sleep(3000);
			autocomplete.click();
			
			WebElement country = driver.findElement(By.id("myInput"));
			Thread.sleep(3000);
			country.sendKeys(input);
			
			List<WebElement> countryList = driver.findElements(By.xpath("//div[@id='myInputautocomplete-list']/div"));
			Thread.sleep(3000);
			for(WebElement elementcountry:countryList) {
				System.out.println(elementcountry.getText());
				
				if(elementcountry.getText().equalsIgnoreCase(ExpectedCountry)) {
					elementcountry.click();
					break;
					
				}
				
				
			}
			
		}
		
		
		
		
	}
