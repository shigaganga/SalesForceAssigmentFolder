package com.training.selenium;



	

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	/* launch application without Webdriver Manager
	 * Not Selenium 4 
	 * 
	 * 
	 */
	

		/* Day 2 Locators
		 * 1. id   - Yes
		 * 2. name - Yes
		 * 3. cssSelector -input#email_field
		 * 4. class
		 * 5. partial link text
		 * 6. link text
		 * 7. tagName
		 * 8. xpath
		 * 
		 *  1. Test case - Sequence of steps - Functional/Automation
		 *  2. Input data for the sequence     Functional/Automation
		 *  3. Webelements    - Browser - 
		 *  
		 *  On webelement you perform actions with the input data 	
		 *   *  .
		 *  TextBox
		 *  Button
		 *  Radio Button
		 *  Dropdown
		 *  Labels
		 *  Checkbox
		 *  TextArea
		 *  Link
		 *  Images
		 *  Tool Tips
		 *  Alerts 
		 *    
		 *    
		 *  
		 *  
		 * 
		 * 
		 */
	public class CssClasscode {
	  public static void main(String[] args) {
		
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver = new ChromeDriver();
		 driver.get("https://login.salesforce.com"); 
		 
		WebElement usernameLabel= driver.findElement(By.cssSelector("label.label.usernamelabel"));
		 
		String strUsername = usernameLabel.getText();
		System.out.println(strUsername);
		
		/*  xpath
		 *    Absolute xpath - /html/body/input[2]
		 *    Relative xpath 
		 * 			//tagName[@attribute='value']
		 * 
		 *   //a[@href='/secur/forgotpassword.jsp?locale=us']		
		 *   //a[@id='forgot_password_link']  
		 *   //a[text()='Forgot Your Password?']	
		 *   
		 *   //tagName[contains(text(),'')]
		 *   //div[contains(text(),'Inc')]
		 *   
		 *   	
		 * 
		 */
		  
	}	
		

	}
