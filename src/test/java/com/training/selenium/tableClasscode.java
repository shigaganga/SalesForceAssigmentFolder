
package com.training.selenium;
	import java.time.Duration;
	import java.util.List;
	import org.openqa.selenium.By;
	import org.openqa.selenium.ElementNotInteractableException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.FluentWait;

	public class tableClasscode {


		public static void main(String[] args) throws InterruptedException {
			System.out.println("******login_to_firebase automation script started***********");
			String expected="Student Registration Form";
			WebDriver driver = new ChromeDriver();
			driver.get("https://qa-tekarch.firebaseapp.com/");
			System.out.println("url is entered");
		//Thread.sleep(5000);
			//entertext(webelement,username);
			WebElement usernameEle = driver.findElement(By.id("email_field"));
			
		/*	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(usernameEle));
			*/
			
			FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
			wait.withTimeout(Duration.ofSeconds(5))
			.pollingEvery(Duration.ofSeconds(2))
			.ignoring(ElementNotInteractableException.class);
			
			wait.until(ExpectedConditions.visibilityOf(usernameEle));
			
			

			
			if (usernameEle.isDisplayed()) {
				usernameEle.clear();
				usernameEle.sendKeys("admin123@gmail.com");
				System.out.println("username is entered in the username field");
			} else {
				System.out.println("username element is not displayed");
			}

			WebElement passwordEle = driver.findElement(By.id("password_field"));
			if(passwordEle.isDisplayed()) {
			passwordEle.clear();
			passwordEle.sendKeys("admin123");
			System.out.println("password is entered in the password field");
			}
			else {
				System.out.println("password element is not displayed");
			}
			
			WebElement buttonEle=driver.findElement(By.tagName("button"));
			if(buttonEle.isEnabled()) {
			buttonEle.click();
			System.out.println("button is clicked");
			}
			else {
				System.out.println("button element is not enabled");
			}

			Thread.sleep(5000);
			
			WebElement widget=driver.findElement(By.xpath("//button[contains(text(),'Widget')]"));
			Actions action=new Actions(driver);
			action.moveToElement(widget).build().perform();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[contains(text(),'Table')]")).click();
			Thread.sleep(3000);
			WebElement table=driver.findElement(By.xpath("//table/tbody"));
			List<WebElement> listOfheaders= table.findElements(By.xpath("//tr[1]/th"));
			for(WebElement ele:listOfheaders) {
				System.out.print(ele.getText()+ "-----");
			}
			System.out.println();
			List<WebElement> listOfdata= table.findElements(By.xpath("//td"));
			for(WebElement ele:listOfdata) {
				System.out.println(ele.getText());
			}
			
			System.out.println("completed");
			
		}

	}
