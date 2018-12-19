package com.cleartrip.pom.basetest;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.cleartrip.pom.utils.ClearTripConstants;
import com.cleartrip.pom.utils.ExtentManager;
import com.cucumber.listener.Reporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest {

	public static WebDriver driver;
	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest test;
	//public Xls_Reader xls = new Xls_Reader(ClearTripConstants.DATA_XLS_PATH);
	//public String sheet = ClearTripConstants.TESTDATA_SHEET;

	public void init(String bType) {

		if(bType.equals("Chrome")) {
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);

			System.setProperty("webdriver.chrome.driver", ClearTripConstants.CHROME_DRIVER_EXE);
			driver = new ChromeDriver(options);
		}else if(bType.equals("Mozilla")) {
			System.setProperty("webdriver.gecko.driver", ClearTripConstants.GECKO_DRIVER_EXE);
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);



	}

	public void takeScreenshot(){
		Date d = new Date();
		String screenshotFile=d.toString().replace(":","_").replace(" ", "_")+".png";	
		new File(ClearTripConstants.REPORTS_PATH+ExtentManager.reportFolder+"//screenshot").mkdirs();
		String filePath =ClearTripConstants.REPORTS_PATH+ExtentManager.reportFolder+"//screenshot//"+screenshotFile;
		//System.setProperty(filePath,screenshotFile);
		//Store screenshots in that file
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(srcFile, new File(filePath));
			Reporter.addScreenCaptureFromPath(filePath);
		}catch(IOException e){

			e.printStackTrace();

		}
		//test.log(LogStatus.INFO, test.addScreenCapture(".//screenshot/" + screenshotFile));

	}

	public void reportFailure(String failureMessage){
		//test.log(LogStatus.FAIL, failureMessage);
		Reporter.addStepLog(failureMessage);
		takeScreenshot();
		Assert.fail("Test failed");
	}

}

