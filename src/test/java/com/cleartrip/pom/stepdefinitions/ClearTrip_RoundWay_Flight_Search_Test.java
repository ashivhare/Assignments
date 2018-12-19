package com.cleartrip.pom.stepdefinitions;

import org.openqa.selenium.support.PageFactory;

import com.cleartrip.pom.basetest.BaseTest;
import com.cleartrip.pom.pages.SearchFlightPage;

import cucumber.api.java.en.When;

public class ClearTrip_RoundWay_Flight_Search_Test extends BaseTest {
	
	@When("^User enters \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void user_enters(String departOn, String returnOn, String adults, String children, String infants, String classOfTravel) throws Throwable {
		SearchFlightPage sfPage = new SearchFlightPage(driver,test);
		PageFactory.initElements(driver, sfPage);
		String[] departDate = {departOn};
		sfPage.selectDepartDate(departDate);
		sfPage.selectReturnDate(returnOn);
		String[] passengerDetails = {adults,children,infants,classOfTravel};
		sfPage.fillPassengerDetails(passengerDetails);
	    
	}


}

