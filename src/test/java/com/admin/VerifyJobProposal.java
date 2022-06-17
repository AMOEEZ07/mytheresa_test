package com.admin;

import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.dataReader.Excel_DataReader;
import com.pageObjects.AdminJobProposalObjects;
import com.pageObjects.PrivatePracticeJobsObjects;
import com.privatePracticeJobs.ApplyForJob;
import com.utilities.Driver;
import com.utilities.GenericWait;
import com.utilities.TestBase;

@Test
public class VerifyJobProposal extends TestBase {
	Excel_DataReader excelReader = new Excel_DataReader();
	public static String stored_JobName = "";
	public static String stored_eMAil = "";
	public static String stored_lexstepJobDate = "";	

	public void verifyingApplyingForJob_adminSide() throws Exception {

		Logger logger = Logger.getLogger("Verifing Job Proposal at Admin Side");
		GenericWait GW = new GenericWait();
		PropertyConfigurator.configure("Log4j.properties");
		Map<String, String> rowMap = excelReader.getRowDataMap("testdata\\Lawyer_login.xlsx", 0, 1);
		AdminJobProposalObjects adminProposalVerifyObjects = PageFactory.initElements(Driver.Instance,
				AdminJobProposalObjects.class);
		Thread.sleep(4000);

//		// Clicking Lawyers Tab
//		adminProposalVerifyObjects.lawyersTab.click();
//		GW.WaitForJQueryLoad();
//		logger.info("Lawyers tab has been clciked successfully");
//		Thread.sleep(3000);

		// Clicking Lawyers Tab
		adminProposalVerifyObjects.lawyersTab.click();
		GW.WaitForJQueryLoad();
		logger.info("Lawyers tab has been clciked successfully");
		Thread.sleep(3000);
		
//		// Storing Job Name in Private Practice Jobs tab
//		Thread.sleep(2000);
//		WebElement email = adminProposalVerifyObjects.storingEmail_id;
//		stored_eMAil = email.getText();
//		System.out.println("Email is " + stored_eMAil);
//		Thread.sleep(2000);
		
		// Searching email-ID in the search E-mailBox
		adminProposalVerifyObjects.searchBox.sendKeys(rowMap.get("Email"));
//		adminProposalVerifyObjects.searchBox.sendKeys(stored_eMAil);
		logger.info("E-mail has been entered in the grid successfully");
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);

		// Clicking View button
		adminProposalVerifyObjects.viewBtn.click();
		logger.info("View button has been clciked successfully");
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);

		// Clicking Application tab
		adminProposalVerifyObjects.applicationTab.click();
		logger.info("Application tab has been clicked successfully");
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);

		// Storing Job Name in Private Practice Jobs tab
		Thread.sleep(2000);
		WebElement jobName = adminProposalVerifyObjects.jobTitle;
		stored_JobName = jobName.getText();
		System.out.println("Job name is " + stored_JobName);
		logger.info("Job Name has been stored Successfully");
		Thread.sleep(2000);

		// Verification
		Thread.sleep(2000);
		if (stored_JobName.equalsIgnoreCase(ApplyForJob.stored_jobName)) {
			System.out.println("**********Verification of sending a job proposal has been passed at admin side based on name of job**********");
			assertTrue(true);
		} else {
			System.out.println("**********Verification of sending a job proposal has been failed at admin side based on name of job**********");
			assertTrue(false);
		}
		
		// Getting date of local system
		DateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		System.out.println("Current date of local system is " + date1);

		// Storing date in application
		Thread.sleep(2000); 
		WebElement lexstepJobDate =adminProposalVerifyObjects.storingLexstepJobDate; 
		stored_lexstepJobDate =lexstepJobDate.getText(); 
		System.out.println("Date of applied job is " +stored_lexstepJobDate);
		logger.info("Date of applied job has been stored Successfully");
		Thread.sleep(2000);

		// Verification of First name 
		Thread.sleep(2000); 
		if(stored_lexstepJobDate.equalsIgnoreCase("INDICATED INTEREST ON " + date1)) 
		{ 
			System.out.println("**********Date Verification on Application tab after applying job has been PASSED**********"); 
			assertTrue(true); 
		} 
		else 
		{ 
			System.out.println("**********Date Verification on Application tab after applying job has been FAILED**********"); 
			assertTrue(false); 
		}

	}
}
