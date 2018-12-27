package com.cleartrip.pom.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cleartrip.pom.pages.base.BasePage;
import com.cleartrip.pom.utils.ClearTripConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SearchFlightPage extends BasePage {

	@FindBy(xpath=ClearTripConstants.ONE_WAY_TRIP_TYPE_RADIO_BUTTON)
	WebElement oneWayTrip;

	@FindBy(xpath=ClearTripConstants.ROUND_TRIP_TYPE_RADIO_BUTTON)
	WebElement roundWayTrip;

	@FindBy(xpath=ClearTripConstants.MULTI_CITY_TRIP_TYPE_RADIO_BUTTON)
	WebElement multiCitTrip;

	@FindBy(xpath=ClearTripConstants.RETURN_DATE_INPUT_FIELD)
	WebElement returnDateInputField;

	@FindBy(id=ClearTripConstants.FROM_INPUT_FIELD)
	WebElement cityFromFields;

	@FindBy(id=ClearTripConstants.TO_INPUT_FIELD)
	WebElement cityToFields;

	@FindBy(id=ClearTripConstants.FROM_INPUT_FIELD_AUTO_SUGGEST)
	WebElement fromCityFieldAutoSuggest;

	@FindBy(id=ClearTripConstants.TO_INPUT_FIELD_AUTO_SUGGEST)
	WebElement toCityFieldAutoSuggest;

	@FindBy(id=ClearTripConstants.ADD_ONE_MORE_LINK)
	WebElement addMoreLink;

	@FindBy(xpath=ClearTripConstants.DEPART_DATE_CALENDAR)
	List<WebElement> departDateCalendar;
	
	@FindBy(xpath=ClearTripConstants.RETURN_DATE_CALENDAR)
	WebElement returnDateCalendar;
	
	@FindBy(xpath=ClearTripConstants.MONTH_BLOCK_FIRST_YEAR)
	WebElement monthBlockFirstYear;

	@FindBy(xpath=ClearTripConstants.MONTH_BLOCK_FIRST_MONTH)
	WebElement monthBlockFirstMonth;

	@FindBy(xpath=ClearTripConstants.MONTH_BLOCK_LAST_YEAR)
	WebElement monthBlockLastYear;

	@FindBy(xpath=ClearTripConstants.MONTH_BLOCK_LAST_MONTH)
	WebElement monthBlockLastMonth;

	@FindBy(xpath=ClearTripConstants.CHANGE_MONTH_LINK)
	WebElement changeMonthLink;
	
	@FindBy(xpath=ClearTripConstants.SELECT_ADULTS_DROPDOWN)
	WebElement selectAdults;
	
	@FindBy(xpath=ClearTripConstants.SELECT_CHILDREN_DROPDOWN)
	WebElement selectChildren;
	
	@FindBy(xpath=ClearTripConstants.SELECT_INFANTS_DROPDOWN)
	WebElement selectInfants;
	
	@FindBy(xpath=ClearTripConstants.MORE_OPTIONS_LINK)
	WebElement moreOptionsLink;
		
	@FindBy(xpath=ClearTripConstants.SELECT_TRAVEL_CLASS_DROPDOWN)
	WebElement selectTravelClass;

	@FindBy(xpath=ClearTripConstants.SEARCH_FLIGHTS_BUTTON)
	WebElement searchFlightsButton;
	
	@FindAll({
			  @FindBy(xpath=ClearTripConstants.SEARCH_FLIGHTS_RESULTS),
			  @FindBy(xpath=ClearTripConstants.SEARCH_FLIGHTS_RESULTS_1)
			})
	WebElement searchFlightsResults;
	

	public SearchFlightPage() {

	}

	public SearchFlightPage(WebDriver driver, ExtentTest test) {
		super(driver,test);
	}

	public boolean selectTripType(String tripType) {

		test.log(LogStatus.INFO, "Selecting the trip type as -> "+tripType);
		boolean status=false;
		switch(tripType) {

		case "OneWay":
			takeScreenshot();
			status=true;
			break;

		case "RoundTrip":	
			roundWayTrip.click();
			boolean returnDateField = isElementPresent(ClearTripConstants.RETURN_DATE_INPUT_FIELD);
			takeScreenshot();
			if(returnDateField) {
				status=true;
			}

			break;

		case "MultiCity":	
			multiCitTrip.click();
			int fromFields = countElements(ClearTripConstants.ADD_ONE_MORE_LINK);
			takeScreenshot();
			if(fromFields==1) {
				status=true;
			}

			break;
		}

		return status;

	}


	public void enterFromCity(String fromCity) {

		try {

			explicitWait(driver, 20, cityFromFields);
			cityFromFields.clear();
			cityFromFields.sendKeys(fromCity);
			Thread.sleep(1000);
			explicitWait(driver, 20, fromCityFieldAutoSuggest);
			List<WebElement> autoSuggestFromOptions = fromCityFieldAutoSuggest.findElements(By.tagName("li"));
			autoSuggestFromOptions.get(0).click();
			takeScreenshot();

		} catch (Exception e) {
			e.printStackTrace();
			reportFailure("Could not select From City properly");
		}

	}

	public void enterToCity(String toCity) {

		try {

			explicitWait(driver, 20, cityToFields);
			cityToFields.clear();
			cityToFields.sendKeys(toCity);
			Thread.sleep(1000);
			explicitWait(driver, 20, toCityFieldAutoSuggest);
			List<WebElement> autoSuggestToOptions = toCityFieldAutoSuggest.findElements(By.tagName("li"));
			autoSuggestToOptions.get(0).click();
			takeScreenshot();
		} catch (Exception e) {
			e.printStackTrace();
			reportFailure("Could not select To City properly");
		}

	}

	public void enterFromCity(String[] fromCity) {
		int count = 4;
		try {
			for(int i=1;i<=fromCity.length;i++) {
				String fromID = "FromTag"+i;
				String fromAutoSuggest = "ui-id-"+count;
				WebElement fromField = driver.findElement(By.id(fromID));
				fromField.clear();
				fromField.sendKeys(fromCity[i-1]);
				Thread.sleep(1000);
				explicitWait(driver, 20, driver.findElement(By.id(fromAutoSuggest)));
				List<WebElement> fromAutoSuggestOptions = driver.findElement(By.id(fromAutoSuggest)).findElements(By.tagName("li"));
				System.out.println(fromAutoSuggestOptions.size());
				fromAutoSuggestOptions.get(0).click();
				count = count+2;

			}
			takeScreenshot();
		} catch (InterruptedException e) {
			e.printStackTrace();
			reportFailure("Could not select From City properly");
		}


	}

	public void enterToCity(String[] toCity) {
		int count = 5;
		try {
			for(int i=1;i<=toCity.length;i++) {
				String fromID = "ToTag"+i;
				String toAutoSuggest = "ui-id-"+count;
				WebElement fromField = driver.findElement(By.id(fromID));
				fromField.clear();
				fromField.sendKeys(toCity[i-1]);
				Thread.sleep(1000);
				explicitWait(driver, 20, driver.findElement(By.id(toAutoSuggest)));
				List<WebElement> fromAutoSuggestOptions = driver.findElement(By.id(toAutoSuggest)).findElements(By.tagName("li"));
				fromAutoSuggestOptions.get(0).click();
				count = count+2;
			}
			takeScreenshot();
		} catch (InterruptedException e) {
			e.printStackTrace();
			reportFailure("Could not select To City properly");
		}

	}

	public void selectDepartDate(String[] departDates) {
		test.log(LogStatus.INFO, "Selecting departure dates");
		
		try {
			for(int i=0;i<departDates.length;i++) {
				System.out.println(departDateCalendar.size());
				System.out.println(departDates[i]);
				departDateCalendar.get(i).click();
				String year = departDates[i].split("-")[2];
				int month = Integer.parseInt(departDates[i].split("-")[1]);
				String date = departDates[i].split("-")[0];

				Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(departDates[i]);  
				SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");  
				String strDate = formatter.format(date1); 
				String calMonth = strDate.split(" ")[1]; 

				while(!((monthBlockFirstYear.getText().equals(year) && monthBlockFirstMonth.getText().equals(calMonth)) || (monthBlockLastYear.getText().equals(year) && monthBlockLastMonth.getText().equals(calMonth)))) {

					changeMonthLink.click();
				}

				String targetDate = "//td[@data-year="+"'"+year+"'"+" and @data-month="+"'"+(month-1)+"'"+"]/a[text()="+"'"+date+"'"+"]";
				System.out.println(targetDate);
				driver.findElement(By.xpath(targetDate)).click();
			}
			takeScreenshot();
		} catch (NumberFormatException e) {
			e.printStackTrace();
			reportFailure("Could not select departure date");
		} catch (ParseException e) {
			e.printStackTrace();
			reportFailure("Could not select departure date");
		} catch (Exception e) {
			e.printStackTrace();
			reportFailure("Could not select departure date");
		}



	}

	
	public void selectReturnDate(String returnDate) {
		test.log(LogStatus.INFO, "Selecting return date");
		
		try {
				returnDateCalendar.click();
				String year = returnDate.split("-")[2];
				int month = Integer.parseInt(returnDate.split("-")[1]);
				String date = returnDate.split("-")[0];

				Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(returnDate);  
				SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");  
				String strDate = formatter.format(date1); 
				String calMonth = strDate.split(" ")[1]; 

				while(!((monthBlockFirstYear.getText().equals(year) && monthBlockFirstMonth.getText().equals(calMonth)) || (monthBlockLastYear.getText().equals(year) && monthBlockLastMonth.getText().equals(calMonth)))) {
					changeMonthLink.click();
				}

				String targetDate = "//td[@data-year="+"'"+year+"'"+" and @data-month="+"'"+(month-1)+"'"+"]/a[text()="+"'"+date+"'"+"]";
				System.out.println(targetDate);
				driver.findElement(By.xpath(targetDate)).click();
				takeScreenshot();
		} catch (NumberFormatException e) {
			e.printStackTrace();
			reportFailure("Could not select departure date");
		} catch (ParseException e) {
			e.printStackTrace();
			reportFailure("Could not select departure date");
		} catch (Exception e) {
			e.printStackTrace();
			reportFailure("Could not select departure date");
		}

	}

	public void fillPassengerDetails(String[] passengerDetails) {
		test.log(LogStatus.INFO, "Filling passenger details");
		
		try {
			Select sel = new Select(selectAdults);
			sel.selectByValue(passengerDetails[0]);
			
			sel = new Select(selectChildren);
			sel.selectByValue(passengerDetails[1]);
			
			sel = new Select(selectInfants);
			sel.selectByValue(passengerDetails[2]);
			
			if(isElementPresent(ClearTripConstants.MORE_OPTIONS_LINK)) {
				moreOptionsLink.click();
			}
			
			sel = new Select(selectTravelClass);
			sel.selectByValue(passengerDetails[3]);
			takeScreenshot();
		} catch (Exception e) {
			e.printStackTrace();
			reportFailure("Could not fill passenger details");
		}
		
		test.log(LogStatus.INFO, "Filled passenger details successfully");
	}
	
	
	public Object searchFlights() {
		test.log(LogStatus.INFO, "Searching flights");
		try {
			searchFlightsButton.click();
			Thread.sleep(1000);
			explicitWait(driver, 90, searchFlightsResults);
			test.log(LogStatus.INFO, "Search flight results are displayed properly");
			takeScreenshot();
			SearchFlightResultsPage sfrPage = new SearchFlightResultsPage(driver, test);
			PageFactory.initElements(driver, sfrPage);
			return sfrPage;
		} catch (Exception e) {
			e.printStackTrace();
			reportFailure("Flights could not be searched with the given details");
		}
		
		SearchFlightPage sfPage = new SearchFlightPage(driver, test);
		PageFactory.initElements(driver, sfPage);
		return sfPage;
		
	}

}
