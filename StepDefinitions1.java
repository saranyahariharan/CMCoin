package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import resources.BaseClass;

public class StepDefinitions1 extends BaseClass {
	
		private WebDriver driver = initDriver();

		@Given("^the https://coinmarketcap\\.com/ is open and we are on the homepage$")
		public void the_https_coinmarketcap_com_is_open_and_we_are_on_the_homepage() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			driver = initDriver();	
			driver.get("https://coinmarketcap.com/");
			driver.manage().window().maximize();	    
		}

		@When("^the Cryptocurrencies drop down menu is open$")
		public void the_Cryptocurrencies_drop_down_menu_is_open() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			
			driver.findElement(By.className("cmc-tab__trigger")).click();
		    
		}

		@When("^when Top (\\d+) option in the menu is selected under All currencies$")
		public void when_Top_option_in_the_menu_is_selected_under_All_currencies(int arg1) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		
			driver.findElement(By.className("cmc-link")).click();
		    
		}

		@Then("^top (\\d+) results are visible in the list$")
		public void top_results_are_visible_in_the_list(int arg1) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			
			List<WebElement> results = driver.findElements(By.className("cmc-table-row"));			
			int resultsSize = results.size();
			System.out.println(resultsSize);
			assertEquals(resultsSize, 100);
			
			driver.close();
			driver=null;
		}

}
