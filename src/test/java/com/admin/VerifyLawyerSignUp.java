package com.admin;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.dataReader.Excel_DataReader;
import com.pageObjects.AdminJobProposalObjects;
import com.pageObjects.PrivatePracticeJobsObjects;
import com.privatePracticeJobs.ApplyForJob;
import com.utilities.Driver;
import com.utilities.GenericWait;
import com.utilities.TestBase;

@Test
public class VerifyLawyerSignUp extends TestBase {
	Excel_DataReader excelReader = new Excel_DataReader();
	 public static String stored_eMAil = "";
	 public static String stored_lawyerStatus = "";
	 
	public void verifyingLawyerSignup_adminSide() throws Exception {

		Logger logger = Logger.getLogger("Verifing Job Proposal at Admin Side");
		GenericWait GW = new GenericWait();
		PropertyConfigurator.configure("Log4j.properties");
		Map<String, String> rowMap = excelReader.getRowDataMap("testdata\\SignUp.xlsx", 0, 1);
		AdminJobProposalObjects adminProposalVerifyObjects = PageFactory.initElements(Driver.Instance,
				AdminJobProposalObjects.class);
		Thread.sleep(4000);
		
		// Clicking Lawyers Tab
		adminProposalVerifyObjects.lawyersTab.click();
		GW.WaitForJQueryLoad();
		logger.info("Lawyers tab has been clciked successfully");
		Thread.sleep(3000);
		
		// Storing Job Name in Private Practice Jobs tab
		Thread.sleep(2000);
		WebElement email = adminProposalVerifyObjects.storingEmail_id;
		stored_eMAil = email.getText();
		System.out.println("Email is " + stored_eMAil);
		Thread.sleep(2000);
		
		// Searching email-ID in the search E-mailBox
		adminProposalVerifyObjects.searchBox.sendKeys(stored_eMAil);
		logger.info("E-mail has been entered in the grid successfully");
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);

		// Clicking Actions button
		adminProposalVerifyObjects.actionsDropDown.click();
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);
		
//		adminProposalVerifyObjects.lawyerStatus.click();
//		Thread.sleep(2000);
		// Selecting Lawyer Status
		Select selectStatus = new Select(adminProposalVerifyObjects.lawyerStatus);
		List<WebElement> statusType = selectStatus.getOptions();
		for (int i = 0; i <= statusType.size(); i++) {
			if (statusType.get(i).getText().equalsIgnoreCase(rowMap.get("Status"))) {
				statusType.get(i).click();
				Thread.sleep(1000);
				break;
			}
		}
		
		// Clicking Save button
		adminProposalVerifyObjects.saveBtn.click();
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);
		
		// Storing Lawyer Status
		Thread.sleep(2000);
		WebElement lawyerStatus = adminProposalVerifyObjects.storingLawyerStatus;
		stored_lawyerStatus = lawyerStatus.getText();
		System.out.println("Job name is " + stored_lawyerStatus);
		logger.info("Lawyer Status has been stored Successfully");
		Thread.sleep(2000);

		// Verification
		Thread.sleep(2000);
		if (stored_lawyerStatus.equalsIgnoreCase(rowMap.get("StatusAfterApproval"))) {
			System.out.println("**********Verification of approving a job proposal has been passed**********");
			assertTrue(true);
		} else {
			System.out.println("**********Verification of approving a job proposal has been failed**********");
			assertTrue(false);
		}
		
	}
}