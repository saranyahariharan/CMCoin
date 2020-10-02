package cases;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test2 {


		protected WebDriver driver;
		protected WebDriverWait wait;
		
		@Before
		public void setUp() throws Exception {
			
			 System.setProperty("webdriver.chrome.driver","C:\\Users\\savet\\chromedriver.exe"); 
			 driver = new ChromeDriver();
			
			 driver.get("https://coinmarketcap.com/");
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 
			 wait = new WebDriverWait(driver,30);
			 	  	
		}
		
		@Test
		
		public void validateWatchlistFeature() 
		{
			 	
						
			//find the button and click on it
			
			wait.until(ExpectedConditions.elementToBeClickable(By.className("cmc-table-listing__filter-button")));
			driver.findElement(By.className("cmc-table-listing__filter-button")).click();
			
			// click on the Price menu
			
			wait.until(ExpectedConditions.elementToBeClickable(By.className("cmc-filter-btn")));
			driver.findElements(By.className("cmc-filter-btn")).get(1).click();
			
			//enter the values
			
			driver.findElement(By.name("priceMin")).sendKeys("2000");
			
			String placeholderText = driver.findElement(By.name("priceMax")).getAttribute("placeholder");
			System.out.println(placeholderText);
			
			if(placeholderText != null){
				
			driver.findElement(By.cssSelector("button[data-qa-id=filter-dd-button-apply]")).click();
			
			} else {
				
				driver.findElement(By.name("priceMax")).click();
				driver.findElement(By.name("priceMax")).sendKeys("99999");
				driver.findElement(By.cssSelector("button[data-qa-id=filter-dd-button-apply]")).click();
			}
										
			//add 5 items to watchlist and get their alt attribute strings
																	
			// item 1
			
			String currencyName1;
			try {
				currencyName1 = driver.findElement(By.className("cmc-static-icon")).getAttribute("alt");
				System.out.println(currencyName1);
			} catch (Exception e) {
				wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(By.className("cmc-static-icon")))));
				currencyName1 = driver.findElement(By.className("cmc-static-icon")).getAttribute("alt");
				System.out.println(currencyName1);
			}
			
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[1]/td[9]/div/div/div[1]/span")));
				driver.findElement(By.xpath("//table/tbody/tr[1]/td[9]/div/div/div[1]/span")).click();	
				
			} catch (Exception e) {
				wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//table/tbody/tr[1]/td[9]/div/div/div[1]/span")))));
				driver.findElement(By.xpath("//table/tbody/tr[1]/td[9]/div/div/div[1]/span")).click();	
		
		      }
					
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[1]/td[9]/div/div/div[2]/ul/li/span")));
			driver.findElement(By.xpath("//table/tbody/tr[1]/td[9]/div/div/div[2]/ul/li/span")).click();
					
			// item 2
			
			String currencyName2 = driver.findElements(By.className("cmc-static-icon")).get(1).getAttribute("alt");
			System.out.println(currencyName2);
			
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[2]/td[9]/div/div/div/span")));
				driver.findElement(By.xpath("//table/tbody/tr[2]/td[9]/div/div/div/span")).click();	
			} catch (Exception e) {
				wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//table/tbody/tr[2]/td[9]/div/div/div/span")))));
				driver.findElement(By.xpath("//table/tbody/tr[2]/td[9]/div/div/div/span")).click();	
		      }
								
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[2]/td[9]/div/div/div[2]/ul/li/span")));
			driver.findElement(By.xpath("//table/tbody/tr[2]/td[9]/div/div/div[2]/ul/li/span")).click();
													
			// item 3
			
			String currencyName3 = driver.findElements(By.className("cmc-static-icon")).get(2).getAttribute("alt");
			System.out.println(currencyName3);
			
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[3]/td[9]/div/div/div/span")));
				driver.findElement(By.xpath("//table/tbody/tr[3]/td[9]/div/div/div/span")).click();	
			} catch (Exception e) {
				wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//table/tbody/tr[3]/td[9]/div/div/div/span")))));
				driver.findElement(By.xpath("//table/tbody/tr[3]/td[9]/div/div/div/span")).click();	
		      }					
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[3]/td[9]/div/div/div[2]/ul/li/span")));
			driver.findElement(By.xpath("//table/tbody/tr[3]/td[9]/div/div/div[2]/ul/li/span")).click();
									
			// item 4
			
			String currencyName4 = driver.findElements(By.className("cmc-static-icon")).get(3).getAttribute("alt");
			System.out.println(currencyName4);
			
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[4]/td[9]/div/div/div/span")));
				driver.findElement(By.xpath("//table/tbody/tr[4]/td[9]/div/div/div/span")).click();	
			} catch (Exception e) {
				wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//table/tbody/tr[4]/td[9]/div/div/div/span")))));
				driver.findElement(By.xpath("//table/tbody/tr[4]/td[9]/div/div/div/span")).click();	
		      }				
						
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[4]/td[9]/div/div/div[2]/ul/li/span")));
			driver.findElement(By.xpath("//table/tbody/tr[4]/td[9]/div/div/div[2]/ul/li/span")).click();
						
			// item 5
			
			String currencyName5 = driver.findElements(By.className("cmc-static-icon")).get(4).getAttribute("alt");
			System.out.println(currencyName5);
			 
			
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[5]/td[9]/div/div/div/span")));
				try {
					driver.findElement(By.xpath("//table/tbody/tr[5]/td[9]/div/div/div/span")).click();				
				} catch (Exception e) {
					//WebElement fifthRowOptions = driver.findElement(By.xpath("//table/tbody/tr[5]/td[9]/div/div/div/span"));
					//JavascriptExecutor executor = (JavascriptExecutor)driver;
					//executor.executeScript("arguments[0].scrollIntoView()", fifthRowOptions);
					WebElement fifthRowOptions = driver.findElement(By.xpath("//table/tbody/tr[5]/td[9]/div/div/div/span"));
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", fifthRowOptions);			
					
				}
			} catch (Exception e) {
				wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//table/tbody/tr[5]/td[9]/div/div/div/span")))));
				try {
					driver.findElement(By.xpath("//table/tbody/tr[5]/td[9]/div/div/div/span")).click();
				} catch (Exception e1) {
					//WebElement fifthRowOptions = driver.findElement(By.xpath("//table/tbody/tr[5]/td[9]/div/div/div/span"));
					//JavascriptExecutor executor = (JavascriptExecutor)driver;
					//executor.executeScript("arguments[0].scrollIntoView()", fifthRowOptions);
					WebElement fifthRowOptions = driver.findElement(By.xpath("//table/tbody/tr[5]/td[9]/div/div/div/span"));
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", fifthRowOptions);
				}				
		      }
						
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table/tbody/tr[5]/td[9]/div/div/div[2]/ul/li/span")));
			driver.findElement(By.xpath("//table/tbody/tr[5]/td[9]/div/div/div[2]/ul/li/span")).click();
							
			// open watchlist
			
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Watchlist"))); 
			driver.findElement(By.linkText("Watchlist")).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cmc-table__column-name"))); 
			
			//get the list of all items in watchlist 
			
			String watchlistName1 = driver.findElement(By.className("cmc-static-icon")).getAttribute("alt");
			System.out.println(watchlistName1);
			String watchlistName2 = driver.findElements(By.className("cmc-static-icon")).get(1).getAttribute("alt");
			System.out.println(watchlistName2);
			String watchlistName3 = driver.findElements(By.className("cmc-static-icon")).get(2).getAttribute("alt");
			System.out.println(watchlistName3);
			String watchlistName4 = driver.findElements(By.className("cmc-static-icon")).get(3).getAttribute("alt");
			System.out.println(watchlistName4);
			String watchlistName5 = driver.findElements(By.className("cmc-static-icon")).get(4).getAttribute("alt");
			System.out.println(watchlistName5);
			
								
			//Assert the values - compare items from the first page to the ones on watchlist
			
			assertEquals(currencyName1,watchlistName1);
			assertEquals(currencyName2,watchlistName2);
			assertEquals(currencyName3,watchlistName3);
			assertEquals(currencyName4,watchlistName4);
			assertEquals(currencyName5,watchlistName5);
															
		}
		
		@After
		public void closeDriver() {
			driver.close();
			driver=null;
		}	

}
