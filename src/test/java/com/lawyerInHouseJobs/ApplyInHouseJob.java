package com.lawyerInHouseJobs;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.dataReader.Excel_DataReader;
import com.pageObjects.LawyerInHouseJobsObjects;
import com.pageObjects.PrivatePracticeJobsObjects;
import com.utilities.Driver;
import com.utilities.GenericWait;
import com.utilities.TestBase;

@Test
public class ApplyInHouseJob extends TestBase {
	Excel_DataReader excelReader = new Excel_DataReader();
	public static String storedText_inHouseJobPageVerify = "";
	public static String storedSaveJobCount = "";
	public static String stored_jobName = "";
	public static String stored_jobNameAftrSave = "";
	public static String stored_jobCountAftrUnSave = "";
	public static String stored_savedJobHistoryDesc = "";
	public static String stored_jobNameVerify = "";

	public void applyForJob_inHouse() throws Exception {

		Logger logger = Logger.getLogger("Handling InHOuse Jobs");
		GenericWait GW = new GenericWait();
		PropertyConfigurator.configure("Log4j.properties");
		Map<String, String> inHouseJobsExcelReader = excelReader.getRowDataMap("testdata\\LawyerInhouseJobs.xlsx", 0,
				1);
		LawyerInHouseJobsObjects inHouseJobsObjects = PageFactory.initElements(Driver.Instance,
				LawyerInHouseJobsObjects.class);
		Thread.sleep(3000);

		// Clicking In-House Jobs Tab
		inHouseJobsObjects.inHouseJobsTab.click();
		logger.info("INHOUSE jobs tab has been selected Successfully!");
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);

		// Storing Text from button
		Thread.sleep(2000);
		WebElement inHouseJobPageVerify = inHouseJobsObjects.explorePrivatePracticeBtn;
		storedText_inHouseJobPageVerify = inHouseJobPageVerify.getText();
		System.out
				.println("Explore Private Practice Button text for verification is " + storedText_inHouseJobPageVerify);
		logger.info("Job Name for verification has been stored Successfully");

		// Verification of navigation to INHOUSE page by tab
		Thread.sleep(2000);
		if (storedText_inHouseJobPageVerify.equalsIgnoreCase(inHouseJobsExcelReader.get("InHouseTabVerify"))) {
			System.out.println(
					"**********Verification of navigating to Inhouse Jobs page by tab has been PASSED**********");
			assertTrue(true);
		} else {
			System.out.println(
					"**********Verification of navigating to Inhouse Jobs page by tab has been FAILED**********");
			assertTrue(false);
		}

		// Clicking Private Practice Jobs tab
		inHouseJobsObjects.privatePracticeJobsTab.click();
		logger.info("Private Practice Jobs tab has been selected Successfully!");
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);

		// Clicking Explore In-House Opportunities
		inHouseJobsObjects.exploreInHouseOppBtn.click();
		logger.info("Explore InHouse Opp Btn has been selected Successfully!");
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);

		// Verification of navigation to INHOUSE page by tab
		Thread.sleep(2000);
		if (storedText_inHouseJobPageVerify.equalsIgnoreCase(inHouseJobsExcelReader.get("InHouseTabVerify"))) {
			System.out.println(
					"**********Verification of navigating to Inhouse Jobs page by Explore InHouse Opportunities Btn has been PASSED**********");
		} else {
			System.out.println(
					"**********Verification of navigating to Inhouse Jobs page by Explore InHouse Opportunities Btn has been FAILED**********");
		}

		// Storing Job Name in IN-HOUSE JOBS tab
		Thread.sleep(2000);
		WebElement jobName = inHouseJobsObjects.storingJobName;
		stored_jobName = jobName.getText();
		System.out.println("Job name is " + stored_jobName);
		logger.info("Job Name has been stored Successfully");
		Thread.sleep(2000);

		// Clicking Explore Roles button
		inHouseJobsObjects.exploreRolesBtn.click();
		logger.info("Explore Roles button has been Clicked Successfully!");
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);

		// Clicking Explore Interested button
		inHouseJobsObjects.jobInterestedBtn.click();
		logger.info("Interested button has been Clicked Successfully!");
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);

		// Clicking Share Profile button
		inHouseJobsObjects.shareProfileBtn.click();
		logger.info("Share button has been Clicked Successfully!");
		GW.WaitForJQueryLoad();
		// privateJobsObjects.cancelBtn.click();
		Thread.sleep(3000);

		// Verification button
		if (inHouseJobsObjects.jobInterestedBtnAfterApply.isEnabled()) {
			System.out.println("**********Verification is failed- Interested button is still enabled !!**********");
		} else {
			System.out.println("**********Verification is passed- Interested button is disabled !!**********");
		}

		// Clicking Track tab
		inHouseJobsObjects.trackTab.click();
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);

		// Storing Job Name in Track tab
		Thread.sleep(2000);
		WebElement jobNameVerify = inHouseJobsObjects.storingJobNameVerify;
		stored_jobNameVerify = jobNameVerify.getText();
		System.out.println("Job name for verification in track tab is " + stored_jobNameVerify);
		logger.info("Job Name for verification has been stored Successfully");

		// Verification
		Thread.sleep(2000);
		if (stored_jobName.equalsIgnoreCase(stored_jobNameVerify)) {
			System.out.println("**********Verification of sending a job proposal has been passed**********");
		} else {
			System.out.println("**********Verification of sending a job proposal has been failed**********");
		}

		// Clicking In-House Jobs Tab
		inHouseJobsObjects.inHouseJobsTab.click();
		logger.info("INHOUSE jobs tab has been selected Successfully!");
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);
		
		// Clicking Explore Roles button
		inHouseJobsObjects.exploreRolesBtn.click();
		logger.info("Explore Roles button has been Clicked Successfully!");
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);

		// Skip Scenario
		if (GenericWait.existsElement("#IHJobs div.inner-list-inhouse:nth-child(2) div.inhouse-action button.btn-saved")) {
			// Clicking UnSave button
			inHouseJobsObjects.unSaveJobBtn.click();
			logger.info("Un-Save button has been Clicked Successfully!");
			GW.WaitForJQueryLoad();
			Thread.sleep(3000);
		}
		
		// Clicking Save button
		inHouseJobsObjects.saveJobBtn.click();
		logger.info("Save button has been Clicked Successfully!");
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);

		// Storing Job Count
		Thread.sleep(2000);
		WebElement saveJobCount = inHouseJobsObjects.savedJobCount;
		storedSaveJobCount = saveJobCount.getText();
		System.out.println("Save job count is " + storedSaveJobCount);
		logger.info("Save Job Count has been stored Successfully");

		// Verification of Saving a job
		Thread.sleep(2000);
		if (storedSaveJobCount.equalsIgnoreCase(inHouseJobsExcelReader.get("SaveJobCount"))) {
			System.out.println("**********Verification of saving a job has been PASSED**********");
		} else {
			System.out.println("**********Verification of saving a job has been FAILED**********");
		}

		// Clicking Toggle button
		inHouseJobsObjects.toggleBtn.click();
		logger.info("Toggle button has been selected Successfully!");
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);

		// Storing Job Name after saving a job
		Thread.sleep(2000);
		WebElement jobNameaftrSave = inHouseJobsObjects.storingJobName;
		stored_jobNameAftrSave = jobNameaftrSave.getText();
		System.out.println("Job name after saving is " + stored_jobNameAftrSave);
		logger.info("Job Name after saving has been stored Successfully");
		Thread.sleep(2000);

		// Verification of Saving a job
		Thread.sleep(2000);
		if (stored_jobNameAftrSave.equalsIgnoreCase(stored_jobName)) {
			System.out.println("**********Verification of saving a job has been PASSED**********");
		} else {
			System.out.println("**********Verification of saving a job has been FAILED**********");
		}

		// Clicking Toggle button
		inHouseJobsObjects.toggleBtn.click();
		logger.info("Toggle button has been selected Successfully!");
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);

		// Clicking Explore Roles button
		inHouseJobsObjects.exploreRolesBtn.click();
		logger.info("Explore Roles button has been Clicked Successfully!");
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);

		// Clicking UnSave button
		inHouseJobsObjects.unSaveJobBtn.click();
		logger.info("Un-Save button has been Clicked Successfully!");
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);

		// Storing Job Count after unsave
		Thread.sleep(2000);
		WebElement JobCountAftrunSave = inHouseJobsObjects.savedJobCount;
		stored_jobCountAftrUnSave = JobCountAftrunSave.getText();
		System.out.println("Save job count after unsave is " + stored_jobCountAftrUnSave);
		logger.info("Save Job Count after unsaving a job has been stored Successfully");

		// Verification of Saved Job Count after unsaving a job
		Thread.sleep(2000);
		if (stored_jobCountAftrUnSave.equalsIgnoreCase(inHouseJobsExcelReader.get("JobCountAftrUnSave"))) {
			System.out.println("**********Verification of un-saving a job has been PASSED**********");
		} else {
			System.out.println("**********Verification of un-saving a job has been FAILED**********");
		}

		// Clicking Toggle button
		Thread.sleep(2000);
		inHouseJobsObjects.toggleBtn.click();
		logger.info("Toggle button has been selected Successfully!");
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);

		// Storing Job Count after unsave
		Thread.sleep(2000);
		WebElement savedJobDesc = inHouseJobsObjects.saveJobHistoryDesc;
		stored_savedJobHistoryDesc = savedJobDesc.getText();
		System.out.println("Save job toggle description is " + stored_savedJobHistoryDesc);
		logger.info("Save job toggle description has been stored Successfully");

		// Verification of Saved Job Count after unsaving a job
		Thread.sleep(2000);
		if (stored_savedJobHistoryDesc.equalsIgnoreCase(inHouseJobsExcelReader.get("SavedJobsHistory"))) {
			System.out.println("**********Verification of un-saving a job has been PASSED**********");
		} else {
			System.out.println("**********Verification of un-saving a job has been FAILED**********");
		}

		// Clicking Toggle button
		Thread.sleep(2000);
		inHouseJobsObjects.toggleBtn.click();
		logger.info("Toggle button has been selected Successfully!");
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);

	}
}