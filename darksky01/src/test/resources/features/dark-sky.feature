Feature: DarkSky Search Feature

  Background:
    Given I am on darksky page

 
  Scenario: Verify deal of the day price amount
    When I Clear search text field
    And I Enter address or zipcode into the search field
    Then I Click on search magnifying glass
    And Verify current temperature is between low and high value
   