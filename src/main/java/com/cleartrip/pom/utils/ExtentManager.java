package com.cleartrip.pom.utils;


import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;


public class ExtentManager {
	private static ExtentReports extent;
	public static String reportFolder="";
	/**
	 * Initializes and returns the extent report object 
	 * @return ExtentReports
	 */
	public static ExtentReports getInstance() {
		if (extent == null) {
			Date d=new Date();
			reportFolder = d.toString().replace(":", "_").replace(" ", "_");
			new File(ClearTripConstants.REPORTS_PATH+reportFolder).mkdir();
			String fileName="//Clear_Trip_Automation_Report.html";
			String reportPath = ClearTripConstants.REPORTS_PATH+reportFolder;
			extent = new ExtentReports(reportPath+fileName, true, DisplayOrder.NEWEST_FIRST);


			extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
			
			extent.addSystemInfo("Selenium Version", "3.4.0").addSystemInfo(
					"Environment", "QA").addSystemInfo("Build Number", "v1.0").addSystemInfo("Time Zone", d.toString());			
		}
		return extent;
	}	

}
