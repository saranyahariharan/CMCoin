@Task1
Feature: Cryptocurrencies drop down menu sorting options

	@Scenario1  
	  Scenario: Selecting top 100 currencies in the Cryptocurrency menu will list top 100 currencies
	    Given the https://coinmarketcap.com/ is open and we are on the homepage
	    When the Cryptocurrencies drop down menu is open
	    And when Top 100 option in the menu is selected under All currencies
	    Then top 100 results are visible in the list 

