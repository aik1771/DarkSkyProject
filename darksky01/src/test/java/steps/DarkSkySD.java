package steps;

import com.darksky.DriverWrapper;
import com.darksky.PageElements;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DarkSkySD extends DriverWrapper{
	
	PageElements landing = new PageElements();
	@Given("^I am on darksky page$")
	public void iAmOnDarkskyPage() throws Throwable {
	 
		initializeWebDriver();
	}

	@When("^I Clear search text field$")
	public void iClearSearchTextField() throws Throwable {
	  
		
		landing.clickSearchField();
	   
	}

	@When("^I Enter address or zipcode into the search field$")
	public void iEnterAddressOrZipcodeIntoTheSearchField() throws Throwable {
	
		
		landing.setSearchField();
	
	}
	
	@Then("^I verify timeline is displayed with two hours incremented$")
	public void iVerifyTimelineIsDisplayedWithTwoHoursIncremented() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    landing.getTime();
	}

	@Then("^I Click on search magnifying glass$")
	public void iClickOnSearchMagnifyingGlass() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		landing.clickSearch();
	   
	}

	@Then("^Verify current temperature is between low and high value$")
	public void verifyCurrentTemperatureIsBetweenLowAndHighValue() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		landing.findTemperature();
		landing.checkTemepratureRange();
	    
	}

}
