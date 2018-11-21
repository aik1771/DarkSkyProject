Feature: DarkSky Search Feature

  Background:
    Given I am on darksky page

 
  @today-temperature
  Scenario: Verify deal of the day price amount
    When I expand todays timeline
    Then I verify lowest and highest temp is displayed correctly