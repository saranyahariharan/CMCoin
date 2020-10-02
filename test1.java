package cases;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class test1 {

	protected WebDriver driver;
	protected WebDriverWait wait;

	
	//create browser, driver and wait object
	
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
	
	public void validateSorting() 
	{
		 	
		//find the menu and open it		 
		 wait.until(ExpectedConditions.elementToBeClickable(By.className("cmc-tab__trigger")));
		 driver.findElement(By.className("cmc-tab__trigger")).click();
		
		 // click on Top 100
		
		 wait.until(ExpectedConditions.elementToBeClickable(By.className("cmc-link")));
		 driver.findElement(By.className("cmc-link")).click();
		
		 //check the number of results in the table
		
		 List<WebElement> results =
		 driver.findElements(By.className("cmc-table-row"));
	
		 int resultsSize = results.size(); System.out.println(resultsSize);
		
		 //Assert if there are 100 items in results
		
		 assertEquals(resultsSize, 100);	
		
	}
	  
	@After
	public void closeDriver() {
		driver.close();
		driver=null;
	}	
	
}