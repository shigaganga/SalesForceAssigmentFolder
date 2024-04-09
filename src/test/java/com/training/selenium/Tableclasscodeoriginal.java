package com.training.selenium;

	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	
		public class Tableclasscodeoriginal {

		
		static WebDriver driver ;
		
		public static void main(String[] args) {
			
			WebDriverManager.chromedriver().setup();
			
			 driver = new ChromeDriver();
			
			driver.get("https://www.w3schools.com/html/html_tables.asp");
			
			/*
			 * List<WebElement> tableData=
			 * driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/td"));
			 * 
			 * for(WebElement element :tableData) { System.out.println(element.getText()); }
			 */
			
			findtext("Germany");
			finddatainTable("Germany");
			finddatainTable(5,1);
			finddatainTable(2,3,"Germany");
			
			/* overlaoding method 
			 * find a text in the complete table
			 * you can get a value from a cell
			 * you verify the data is present in a cell and compare
			 * 
			 */
			
		}
		
		private static void finddatainTable(int rowid, int colid, String expectedText) {
			
			WebElement tableData= driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+rowid+"]/td["+colid+"]"));
			String actualText = tableData.getText();
			
			if(actualText.equalsIgnoreCase(expectedText)) {
				System.out.println("Expected Text "+expectedText+"is present in the row "+rowid+" and in column"+colid+"");
			}
			
		}

		private static void finddatainTable(int rowid, int colid) {
		WebElement tableData= driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+rowid+"]/td["+colid+"]"));
			
		System.out.println(tableData.getText());
			
			
		}

		static void findtext(String FindString) {
			
		WebElement element = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr/td[contains(text(),'"+FindString+"')]"));
		System.out.println(element.getText());
		
		}
		
		
		
		static void finddatainTable(String FindString) {
			
			List<WebElement> tableData= driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/td"));
			
			for(WebElement tbdata : tableData) {
				if(tbdata.getText().equalsIgnoreCase(FindString)) {
					System.out.println("Expected Value is present ");
					break;
				}
				
			}
			
		}
		
		

	}