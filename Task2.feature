@Task2
Feature: Watchlist option lists all currencies that are selected

  @Scenario2
  Scenario: Cryptocurrencies can be individually selected, added to Watchlist and visible in the Watchlist section
    Given we are on the homepage
    When filter button is clicked
    And when price drop down menu is open
    And when input value is entered in min price field
    And max value is selected with apply button clicked
    And when options for first cryptocurrency are open 
    And add to watchlist option is selected for first item
    And when options for second cryptocurrency are open 
    And add to watchlist is selected for second item
    And when options for third cryptocurrency are open 
    And add to watchlist is selected for third item
    And when options for fourth cryptocurrency are open 
    And add to watchlist is selected for fourth item
    And when options for fifth cryptocurrency are open 
    And add to watchlist is selected for fifth item
    And Watchlist section is open by clicking on it
    Then all five selected cryptocurrencies will appear in the Watchlist section

