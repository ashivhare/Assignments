package com.cleartrip.pom.pages.base;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.cleartrip.pom.utils.ClearTripConstants;
import com.cleartrip.pom.utils.ExtentManager;
import com.cucumber.listener.Reporter;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class BasePage{

	
	public WebDriver driver;
	public ExtentTest test;


	/**
	 * Default Constructor
	 */
	public BasePage(){}

	/**
	 * Overloaded Constructor
	 * @param driver
	 * @param test
	 */
	public BasePage(WebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

	}

	
	public boolean isElementPresent(String locator){
		//test.log(LogStatus.INFO, "Trying to find the Required Element");
		int s = driver.findElements(By.xpath(locator)).size();
		if(s==0){
			////test.log(LogStatus.INFO, "Required Element not found-> "+locator);
			return false;
		}
		else{
			//test.log(LogStatus.INFO, "Found Required Element-> "+locator);
			return true;
		}
	}

	/**
	 * Take Screenshot
	 */
	public void takeScreenshot(){
		Date d = new Date();
		String screenshotFile=d.toString().replace(":","_").replace(" ", "_")+".png";	
		new File(ClearTripConstants.REPORTS_PATH+ExtentManager.reportFolder+"//screenshot").mkdirs();
		String filePath =ClearTripConstants.REPORTS_PATH+ExtentManager.reportFolder+"//screenshot//"+screenshotFile;

		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(srcFile, new File(filePath));
			Reporter.addScreenCaptureFromPath(filePath);
		}catch(IOException e){

			e.printStackTrace();

		}
		//test.log(LogStatus.INFO, test.addScreenCapture(".//screenshot/" + screenshotFile));

	}

	/**
	 * Report Failure
	 * @param failureMessage
	 */
	public void reportFailure(String failureMessage){
		//test.log(LogStatus.FAIL, failureMessage);
		takeScreenshot();
		Assert.fail("Test failed");
	}
	
	
	public int countElements(String multiCityFromInputField) {
		
		int count = driver.findElements(By.id(multiCityFromInputField)).size();
		
		return count;
	}

}



