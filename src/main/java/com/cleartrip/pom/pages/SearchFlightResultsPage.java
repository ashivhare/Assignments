package com.cleartrip.pom.pages;

import org.openqa.selenium.WebDriver;

import com.cleartrip.pom.pages.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;

public class SearchFlightResultsPage extends BasePage{
	
	public SearchFlightResultsPage() {
		
	}
	
	public SearchFlightResultsPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

}
