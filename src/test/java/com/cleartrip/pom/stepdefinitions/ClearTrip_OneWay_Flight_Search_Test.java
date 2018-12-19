package com.cleartrip.pom.stepdefinitions;

import org.openqa.selenium.support.PageFactory;

import com.cleartrip.pom.basetest.BaseTest;
import com.cleartrip.pom.pages.LaunchPage;
import com.cleartrip.pom.pages.SearchFlightPage;
import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ClearTrip_OneWay_Flight_Search_Test extends BaseTest {
	//String testCaseName="LoginTest";
	//ExtentTest test = extent.startTest("Search_Flights_One_Way_Test");
	Object page;
	LaunchPage lp;
	SearchFlightPage sfPage;

	@Given("^user is on clear trip search flight Page \"([^\"]*)\"$")
	public void user_is_on_clear_trip_search_flight_Page(String browser) throws Throwable {
		
		init(browser);
		lp = new LaunchPage(driver,test);
		PageFactory.initElements(driver, lp);
		page = lp.gotoSearchFlightPage();
		if(!(page instanceof SearchFlightPage)) {
			reportFailure("Clear Trip site is not displayed properly");
		}else {
			Reporter.addStepLog("Clear Trip site is displayed properly to search flights");
		}


	}

	@When("^User click on \"([^\"]*)\"$")
	public void user_click_on(String tripType) throws Throwable {
		sfPage = (SearchFlightPage) page;
		if(!sfPage.selectTripType(tripType)) {
			reportFailure("Could not select the trip type -> "+tripType);
		}else {
			Reporter.addStepLog("Selected the trip type successfully as -> "+tripType);
		}


	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String fromCity, String toCity) throws Throwable {
		sfPage.enterFromCity(fromCity);
		sfPage.enterToCity(toCity);

	}

	@When("^User enters \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void user_enters(String departOn, String adults, String children, String infants, String classOfTravel) throws Throwable {
		String[] departDate = {departOn};
		sfPage.selectDepartDate(departDate);
		String[] passengerDetails = {adults,children,infants,classOfTravel};
		sfPage.fillPassengerDetails(passengerDetails);

	}

	@Then("^User clicks on the searchflight button$")
	public void user_clicks_on_the_searchflight_button() throws Throwable {


	}

	@Then("^User gets available flights for the given details$")
	public void user_gets_available_flights_for_the_given_details() throws Throwable {
		sfPage.searchFlights();

	}

}

