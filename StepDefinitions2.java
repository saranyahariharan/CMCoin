package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import resources.BaseClass;

public class StepDefinitions2 extends BaseClass {
	
	private WebDriver driver = initDriver();
	protected WebDriverWait wait = new WebDriverWait(driver,30);
	private String currencyName1;
	private String currencyName2;
	private String currencyName3;
	private String currencyName4;
	private String currencyName5;
	
	@Given("^we are on the homepage$")
	public void we_are_on_the_homepage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver = initDriver();
		driver.get("https://coinmarketcap.com/");
		driver.manage().window().maximize();
	}

	@When("^filter button is clicked$")
	public void filter_button_is_clicked() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		wait.until(ExpectedConditions.elementToBeClickable(By.className("cmc-table-listing__filter-button")));
		driver.findElement(By.className("cmc-table-listing__filter-button")).click();
	}

	@When("^when price drop down menu is open$")
	public void when_price_drop_down_menu_is_open() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		wait.until(ExpectedConditions.elementToBeClickable(By.className("cmc-filter-btn")));
		driver.findElements(By.className("cmc-filter-btn")).get(1).click();
	}

	@When("^when input value is entered in min price field$")
	public void when_input_value_is_entered_in_min_price_field() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("priceMin")).sendKeys("2000");
	}

	@When("^max value is selected with apply button clicked$")
	public void max_value_is_selected_with_apply_button_clicked() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String placeholderText = driver.findElement(By.name("priceMax")).getAttribute("placeholder");
		System.out.println(placeholderText);
		
		if(placeholderText != null){
			
		driver.findElement(By.cssSelector("button[data-qa-id=filter-dd-button-apply]")).click();
		
		} else {
			
			driver.findElement(By.name("priceMax")).click();
			driver.findElement(By.name("priceMax")).sendKeys("99999");
			driver.findElement(By.cssSelector("button[data-qa-id=filter-dd-button-apply]")).click();
		}
	}

	@When("^when options for first cryptocurrency are open$")
	public void when_options_for_first_cryptocurrency_are_open() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try {
			currencyName1 = driver.findElement(By.className("cmc-static-icon")).getAttribute("alt");
			System.out.println(currencyName1);
		} catch (Exception e) {
			wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.className("cmc-static-icon"))));
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
				
	}

	@When("^add to watchlist option is selected for first item$")
	public void add_to_watchlist_option_is_selected_for_first_item() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[1]/td[9]/div/div/div[2]/ul/li/span")));
		driver.findElement(By.xpath("//table/tbody/tr[1]/td[9]/div/div/div[2]/ul/li/span")).click();
	}

	@When("^when options for second cryptocurrency are open$")
	public void when_options_for_second_cryptocurrency_are_open() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String currencyName2 = driver.findElements(By.className("cmc-static-icon")).get(1).getAttribute("alt");
		System.out.println(currencyName2);
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[2]/td[9]/div/div/div/span")));
			driver.findElement(By.xpath("//table/tbody/tr[2]/td[9]/div/div/div/span")).click();	
		} catch (Exception e) {
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//table/tbody/tr[2]/td[9]/div/div/div/span")))));
			driver.findElement(By.xpath("//table/tbody/tr[2]/td[9]/div/div/div/span")).click();	
	      }
								
	}

	@When("^add to watchlist is selected for second item$")
	public void add_to_watchlist_is_selected_for_second_item() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[2]/td[9]/div/div/div[2]/ul/li/span")));
		driver.findElement(By.xpath("//table/tbody/tr[2]/td[9]/div/div/div[2]/ul/li/span")).click();
	}

	@When("^when options for third cryptocurrency are open$")
	public void when_options_for_third_cryptocurrency_are_open() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String currencyName3 = driver.findElements(By.className("cmc-static-icon")).get(2).getAttribute("alt");
		System.out.println(currencyName3);
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[3]/td[9]/div/div/div/span")));
			driver.findElement(By.xpath("//table/tbody/tr[3]/td[9]/div/div/div/span")).click();	
		} catch (Exception e) {
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//table/tbody/tr[3]/td[9]/div/div/div/span")))));
			driver.findElement(By.xpath("//table/tbody/tr[3]/td[9]/div/div/div/span")).click();	
	      }					
						
		
	}

	@When("^add to watchlist is selected for third item$")
	public void add_to_watchlist_is_selected_for_third_item() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[3]/td[9]/div/div/div[2]/ul/li/span")));
		driver.findElement(By.xpath("//table/tbody/tr[3]/td[9]/div/div/div[2]/ul/li/span")).click();
	}

	@When("^when options for fourth cryptocurrency are open$")
	public void when_options_for_fourth_cryptocurrency_are_open() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String currencyName4 = driver.findElements(By.className("cmc-static-icon")).get(3).getAttribute("alt");
		System.out.println(currencyName4);
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[4]/td[9]/div/div/div/span")));
			driver.findElement(By.xpath("//table/tbody/tr[4]/td[9]/div/div/div/span")).click();	
		} catch (Exception e) {
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//table/tbody/tr[4]/td[9]/div/div/div/span")))));
			driver.findElement(By.xpath("//table/tbody/tr[4]/td[9]/div/div/div/span")).click();	
	      }	
	}
		
		
	@When("^add to watchlist is selected for fourth item$")
	public void add_to_watchlist_is_selected_for_fourth_item() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[4]/td[9]/div/div/div[2]/ul/li/span")));
		driver.findElement(By.xpath("//table/tbody/tr[4]/td[9]/div/div/div[2]/ul/li/span")).click();
	}

	@When("^when options for fifth cryptocurrency are open$")
	public void when_options_for_fifth_cryptocurrency_are_open() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String currencyName5 = driver.findElements(By.className("cmc-static-icon")).get(4).getAttribute("alt");
		System.out.println(currencyName5);
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[5]/td[9]/div/div/div/span")));
			try {
				driver.findElement(By.xpath("//table/tbody/tr[5]/td[9]/div/div/div/span")).click();				
			} catch (Exception e) {

				WebElement fifthRowOptions = driver.findElement(By.xpath("//table/tbody/tr[5]/td[9]/div/div/div/span"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", fifthRowOptions);			
				
			}
		} catch (Exception e) {
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//table/tbody/tr[5]/td[9]/div/div/div/span")))));
			try {
				driver.findElement(By.xpath("//table/tbody/tr[5]/td[9]/div/div/div/span")).click();
			} catch (Exception e1) {
				WebElement fifthRowOptions = driver.findElement(By.xpath("//table/tbody/tr[5]/td[9]/div/div/div/span"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", fifthRowOptions);
			}				
	      }
	}

	@When("^add to watchlist is selected for fifth item$")
	public void add_to_watchlist_is_selected_for_fifth_item() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[5]/td[9]/div/div/div[2]/ul/li/span")));
		driver.findElement(By.xpath("//table/tbody/tr[5]/td[9]/div/div/div[2]/ul/li/span")).click();
	}
	

	@When("^Watchlist section is open by clicking on it$")
	public void watchlist_section_is_open_by_clicking_on_it() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Watchlist"))); 
		driver.findElement(By.linkText("Watchlist")).click();		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cmc-table__column-name")));
	}

	@Then("^all five selected cryptocurrencies will appear in the Watchlist section$")
	public void all_five_selected_cryptocurrencies_will_appear_in_the_Watchlist_section() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
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
		
		assertEquals(currencyName1,watchlistName1);
		assertEquals(currencyName2,watchlistName2);
		assertEquals(currencyName3,watchlistName3);
		assertEquals(currencyName4,watchlistName4);
		assertEquals(currencyName5,watchlistName5);
		
		driver.close();
		driver=null;
	}

}


