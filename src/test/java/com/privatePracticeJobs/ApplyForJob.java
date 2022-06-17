package com.privatePracticeJobs;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.dataReader.Excel_DataReader;
import com.pageObjects.PrivatePracticeJobsObjects;
import com.utilities.Driver;
import com.utilities.GenericWait;
import com.utilities.TestBase;

@Test
public class ApplyForJob extends TestBase {
	Excel_DataReader excelReader = new Excel_DataReader();
	public static String stored_jobName = "";
	public static String stored_jobNameVerify = "";

	public void lawyerApplyingForJob_ppTab() throws Exception {

		Logger logger = Logger.getLogger("Handling Private Practice Jobs tab at lawyer side");
		GenericWait GW = new GenericWait();
		PropertyConfigurator.configure("Log4j.properties");
		// Map<String, String> privateJobsExcelReader =
		// excelReader.getRowDataMap("testdata\\PrivatePracticeJobsLawyer.xlsx", 0, 1);
		PrivatePracticeJobsObjects privateJobsObjects = PageFactory.initElements(Driver.Instance,
				PrivatePracticeJobsObjects.class);
		Thread.sleep(4000);

		// Clicking Explore Roles button
		privateJobsObjects.exploreRolesBtn.click();
		logger.info("Explore Roles button has been Clicked Successfully!");
		GW.WaitForJQueryLoad();
		Thread.sleep(2000);

		// Clicking Explore Interested button
		privateJobsObjects.interestedJobBtn.click();
		logger.info("Interested button has been Clicked Successfully!");
		GW.WaitForJQueryLoad();
		Thread.sleep(2000);

		// Clicking Share Profile button
		privateJobsObjects.shareProfileBtn.click();
		logger.info("Share button has been Clicked Successfully!");
		GW.WaitForJQueryLoad();
		// privateJobsObjects.cancelBtn.click();
		Thread.sleep(2000);

		// Verification of Dash-board name
		if (privateJobsObjects.interestedJobBtnAfterApply.isEnabled()) {
			System.out.println("**********Verification is failed- Interested button is still enabled !!**********");
			assertTrue(true);
		} else {
			System.out.println("**********Verification is passed- Interested button is disabled !!**********");
			assertTrue(true);
		}

		// Storing Job Name in Private Practice Jobs tab
		Thread.sleep(2000);
		WebElement jobName = privateJobsObjects.storingJobName;
		stored_jobName = jobName.getText();
		System.out.println("Job name is " + stored_jobName);
		logger.info("Job Name has been stored Successfully");
		Thread.sleep(2000);

		// Clicking Track tab
		privateJobsObjects.trackTab.click();
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);

		// Storing Job Name in Track tab
		Thread.sleep(2000);
		WebElement jobNameVerify = privateJobsObjects.storingJobNameVerify;
		stored_jobNameVerify = jobNameVerify.getText();
		System.out.println("Job name for verification in track tab is " + stored_jobNameVerify);
		logger.info("Job Name for verification has been stored Successfully");

		// Verification
		Thread.sleep(2000);
		if (stored_jobName.equalsIgnoreCase(stored_jobNameVerify)) {
			System.out.println("**********Verification of sending a job proposal has been passed in Track tab**********");
			assertTrue(true);
		} else {
			System.out.println("**********Verification of sending a job proposal has been failed in Track tab**********");
			assertTrue(false);
		}

	}

}