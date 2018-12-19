package com.cleartrip.pom.stepdefinitions;

import org.openqa.selenium.support.PageFactory;

import com.cleartrip.pom.basetest.BaseTest;
import com.cleartrip.pom.pages.SearchFlightPage;

import cucumber.api.java.en.When;

public class ClearTrip_MultiCity_Flight_Search_Test extends BaseTest {
	SearchFlightPage sfPage;	

		
		@When("^User enters \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
		public void user_enters(String FromCity1, String ToCity1, String FromCity2, String ToCity2, String FromCity3, String ToCity3) throws Throwable {
		sfPage = new SearchFlightPage(driver,test);
		PageFactory.initElements(driver, sfPage);	
		//Enter From and To Cities
		String[] fromCities = {FromCity1,FromCity2,FromCity3};
		sfPage.enterFromCity(fromCities);
		
		String[] toCities = {ToCity1,ToCity2,ToCity3};
		sfPage.enterToCity(toCities);
		sfPage.selectTripType("MultiCity");

	}

		@When("^User enters \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
		public void user_enters(String DepartOn1, String DepartOn2, String DepartOn3, String adults, String children, String infants, String classOfTravel) throws Throwable {

		String[] departDate = {DepartOn1,DepartOn2,DepartOn3};
		sfPage.selectDepartDate(departDate);
		String[] passengerDetails = {adults,children,infants,classOfTravel};
		sfPage.fillPassengerDetails(passengerDetails);
	}


}

