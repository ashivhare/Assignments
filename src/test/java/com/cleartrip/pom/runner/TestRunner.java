package com.cleartrip.pom.runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cleartrip.pom.basetest.BaseTest;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="D:/Incubation/ClearTrip_BDD/src/test/resources/features",
		glue = {"com.cleartrip.pom.stepdefinitions"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"},
		tags= {"@MultiWayFlightBookingTest"})

public class TestRunner extends BaseTest{

	@AfterClass
	public static void teardown() {
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", "Windows 10");
		Reporter.setTestRunnerOutput("Sample test runner output message");
	}



}
