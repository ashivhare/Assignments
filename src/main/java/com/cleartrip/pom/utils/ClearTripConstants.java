package com.cleartrip.pom.utils;

import java.util.Hashtable;

public class ClearTripConstants {

	//Grid
	public static final boolean GRID_RUN = false;
	
	//Environment
	public static final String ENV = "TEST"; //STAGE, QA, TEST 

	//MAINTENANCE PAGE
	
	//URLs
	public static final String CLEARTRIP_TEST_HOMEPAGE_URL = "https://www.cleartrip.com/";
	public static final String CLEARTRIP_QA_HOMEPAGE_URL  = "https://www.cleartrip.com/";
	

	// Paths
	public static final String CHROME_DRIVER_EXE = System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";
	public static final String GECKO_DRIVER_EXE = System.getProperty("user.dir")+"\\drivers\\geckodriver.exe";
	public static final String IE_DRIVER_EXE = System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe";
	public static final String REPORTS_PATH = "D:\\reports\\Clear_Trip_BDD\\";
	public static final String DATA_XLS_PATH = System.getProperty("user.dir")+"\\data\\Data.xlsx";
	public static final String TESTDATA_SHEET = "Data";
	public static final String TESTCASES_SHEET = "TestCases";

	//Data
	public static final Object RUNMODE_COL = "RunMode";
	
	//Search Flight Page
	public static final String SEARCH_FLIGHT_FORM = "//form[@id='SearchForm']";
	public static final String ONE_WAY_TRIP_TYPE_RADIO_BUTTON = "//form[@id='SearchForm']/descendant::input[@id='OneWay']";
	public static final String ROUND_TRIP_TYPE_RADIO_BUTTON = "//section[@id='GlobalNav']/following-sibling::section[@id='Home']/descendant::input[@id='RoundTrip']";
	public static final String MULTI_CITY_TRIP_TYPE_RADIO_BUTTON = "//input[@id='MultiCity']";
	public static final String RETURN_DATE_INPUT_FIELD = "//input[contains(@id,'ToDate') and not (contains(@disabled,'disabled'))]";
	
	//public static final String FROM_INPUT_FIELDS = "//strong[contains(text(),'From')]/ancestor::dt/following-sibling::dd/span/input[contains(@name,'origin') and not(contains(@disabled,'disabled'))]/input";
	//public static final String FROM_INPUT_FIELDS = "//label[@for='FromTag']/ancestor::dt/following-sibling::dd/span/input[contains(@name,'origin') and not(contains(@disabled,'disabled'))]";
	//public static final String FROM_INPUT_FIELDS = "//input[contains(@id,'RoundTrip')]/ancestor::nav[@class='row fieldRow tripType']/following-sibling::div[@id='ORtrip']/descendant::input[contains(@id,'FromTag')]";
	public static final String FROM_INPUT_FIELD = "FromTag";
	//public static final String TO_INPUT_FIELDS = "//input[contains(@name,'destination') and not(contains(@disabled,'disabled'))]";
	public static final String TO_INPUT_FIELD = "ToTag";
	//public static final String FROM_INPUT_FIELDS_AUTO_SUGGEST = "//section[@id='Home']/following-sibling::ul[@class='autoComplete' and contains(@id,'ui-id-1')]/li/a";
	public static final String FROM_INPUT_FIELD_AUTO_SUGGEST = "ui-id-1";
	public static final String TO_INPUT_FIELD_AUTO_SUGGEST = "ui-id-2";
	public static final String FROM_INPUT_FIELDS_AUTO_SUGGEST = "ui-id-";
	public static final String TO_INPUT_FIELDS_AUTO_SUGGEST = "ui-id-";	
	
	public static final String ADD_ONE_MORE_LINK ="McAddMore";

	public static final String DEPART_DATE_CALENDAR = "//input[contains(@id,'DepartDate') and not(contains(@disabled,'disabled'))]";
	public static final String RETURN_DATE_CALENDAR = "//input[contains(@id,'ReturnDate') and not(contains(@disabled,'disabled'))]";
	public static final String MONTH_BLOCK_FIRST_YEAR = "//div[contains(@class,'monthBlock first')]/descendant::span[contains(@class,'ui-datepicker-year')]";
	public static final String MONTH_BLOCK_FIRST_MONTH = "//div[contains(@class,'monthBlock first')]/descendant::span[contains(@class,'ui-datepicker-month')]";
	public static final String MONTH_BLOCK_LAST_YEAR = "//div[contains(@class,'monthBlock last')]/descendant::span[contains(@class,'ui-datepicker-year')]";
	public static final String MONTH_BLOCK_LAST_MONTH = "//div[contains(@class,'monthBlock last')]/descendant::span[contains(@class,'ui-datepicker-month')]";
	public static final String CHANGE_MONTH_LINK = "//a[contains(@class,'nextMonth')]";

	public static final String SELECT_ADULTS_DROPDOWN = "//select[@id='Adults']";
	public static final String SELECT_CHILDREN_DROPDOWN = "//select[@id='Childrens']";
	public static final String SELECT_INFANTS_DROPDOWN = "//select[@id='Infants']";
	public static final String SELECT_TRAVEL_CLASS_DROPDOWN = "//select[@id='Class' and not (contains(@disabled,'disabled'))]";
	public static final String SEARCH_FLIGHTS_BUTTON = "//input[@id='SearchBtn']";
	public static final String SEARCH_FLIGHTS_RESULTS = "//ul[@class='listView flights']/descendant::a";
	public static final String MORE_OPTIONS_LINK = "//div[@id='MoreOptionsDiv' and contains(@style,'display: block')]/descendant::a[@id='MoreOptionsLink']";
	public static final String SEARCH_FLIGHTS_RESULTS_1 = "//div[@class='selection ui-slider-range-min']/following-sibling::a";
	
	
	
	
	
	
	
	public static Hashtable<String, String> table;
	public static Hashtable<String, String> tableMBO;
	public static Hashtable<String, String> geteClearTripEnvDetails(){
		if(table==null){
			table = new Hashtable<String, String>();
			if(ENV.equals("TEST")){
				table.put("url", CLEARTRIP_TEST_HOMEPAGE_URL);
			}
			else if(ENV.equals("QA")){
				table.put("url", CLEARTRIP_QA_HOMEPAGE_URL);
			}
			
		}
		return table;
		
	}


}
