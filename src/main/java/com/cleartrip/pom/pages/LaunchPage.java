package com.cleartrip.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cleartrip.pom.pages.base.BasePage;
import com.cleartrip.pom.utils.ClearTripConstants;
import com.cucumber.listener.Reporter;
import com.relevantcodes.extentreports.ExtentTest;


public class LaunchPage extends BasePage {

	@FindBy(xpath=ClearTripConstants.SEARCH_FLIGHT_FORM)
	WebElement searchFlightForm;


	public LaunchPage() {

	}

	public LaunchPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}


	public Object gotoSearchFlightPage(){
		Reporter.addStepLog("Opening the URL - > "+ ClearTripConstants.geteClearTripEnvDetails().get("url"));
		driver.get(ClearTripConstants.geteClearTripEnvDetails().get("url"));
		Reporter.addStepLog("Opened the URL - > "+ ClearTripConstants.geteClearTripEnvDetails().get("url"));

		boolean searchForm = isElementPresent(ClearTripConstants.SEARCH_FLIGHT_FORM);
		if(searchForm) {
			SearchFlightPage sfPage = new SearchFlightPage(driver,test);
			PageFactory.initElements(driver, sfPage);
			return sfPage;
		}else {
			LaunchPage lPage = new LaunchPage(driver,test);
			PageFactory.initElements(driver, lPage);
			return lPage;
		}

	}
}
