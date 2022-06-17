package com.adminLawyerListing;

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
import com.pageObjects.AdminLawyerListingObjects;
import com.utilities.Driver;
import com.utilities.GenericWait;
import com.utilities.TestBase;

public class DropDownVerifications_connectTab extends TestBase {
	Excel_DataReader excelReader = new Excel_DataReader();

	public static String stored_selectivityText = "";

	@Test
	public void filtersVerification_connectTab() throws Exception {

		Logger logger = Logger.getLogger("Handling Lawyer Drop-Down flows at admin side in Connect tab");
		GenericWait GW = new GenericWait();
		PropertyConfigurator.configure("Log4j.properties");
		Map<String, String> lawyerListingExcelReader = excelReader.getRowDataMap("testdata\\SignUp.xlsx", 0, 1);
		AdminLawyerListingObjects lawyerListingObjects = PageFactory.initElements(Driver.Instance,
				AdminLawyerListingObjects.class);
		Thread.sleep(4000);

//		// // CLicking Regular Tab
//		// lawyerListingObjects.regularTab.click();
//		// logger.info("Regular tab has been clicked Successfully");
//		// GW.WaitForJQueryLoad();
//		// Thread.sleep(3000);
//
//		// Clicking Lawyers tab
//		lawyerListingObjects.lawyersTab.click();
//		GW.WaitForJQueryLoad();
//		Thread.sleep(3000);
//
//		Driver.Instance.findElement(By.cssSelector("#LLTable > tbody > tr:nth-child(1) #LLViewBtn")).click();
//		Thread.sleep(3000);

		// Clicking Connect tab
		lawyerListingObjects.connectTab.click();
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);

		// Clicking Practice Area Drop Down
		lawyerListingObjects.practiceAreaDropdown_connectTab.click();
		logger.info("Practice area drop-down has been clicked Successfully in Connect tab");
		Thread.sleep(3000);

		// Clicking Banking/Finance
		lawyerListingObjects.bankingFinance_connectTab.click();
		logger.info("Banking/Finance has been clicked Successfully in Connect tab");
		Thread.sleep(3000);

		// Clicking Acquisition/Leveraged Finance
		lawyerListingObjects.acquisitionLeveragedFinance_connectTab.click();
		logger.info("Acquisition/Leveraged Finance has been clicked Successfully in Connect tab");
		Thread.sleep(3000);

		// Skip Scenario and verification for Practice Area filtration
		if (GenericWait.existsElement(
				".tab-content > div:nth-child(7) .custom-table-body  > div[ng-if=\"noJobs\"]:nth-child(1) h3")) {
			System.out.println(
					"**********No jobs to show in Connect Tab after selecting a value from Practice Areas filter**********");
			assertTrue(true);
		} else {
			// Clicking first firm in Regular Tab
			lawyerListingObjects.firstJobconnectTab.click();
			logger.info("Firm has been clicked Successfully in connect tab");
			Thread.sleep(3000);

			String[] practiceAreaList = new String[] { "Acquisition/Leveraged Finance" };

			List<WebElement> practiceAreaConnectTab = Driver.Instance
					.findElements(By.cssSelector("#tab-specConnect-job0-list-practice > li"));
			// Verification
			boolean found = false;
			int j = 0;
			for (j = 0; j < practiceAreaList.length; j++) {
				for (int i = 0; i < practiceAreaConnectTab.size(); i++) {

					if (practiceAreaConnectTab.get(i).getText().equalsIgnoreCase(practiceAreaList[j])) {
						System.out.println("The matching Practice Area's name in Connect tab is "
								+ practiceAreaConnectTab.get(i).getText());
						found = true;
						System.out.println(
								"**********VERIFICATION Passed- Practice Area in Connect Tab after selecting a value from Practice Areas filter**********");
						break;
					}
				}
				if (found)
					break;
			}
			if (!found) {
				System.out.println(
						"**********VERIFICATION Failed- Practice Area in Connect Tab after selecting a value from Practice Areas filter********** ");
				assertTrue(false);
			}
		}

		// Clicking Target Location Drop Down
		lawyerListingObjects.targetLocationDropdown_connectTab.click();
		logger.info("Target location drop-down has been clicked Successfully in connect tab");
		Thread.sleep(3000);

		// Clicking UK
		lawyerListingObjects.UK_connectTab.click();
		logger.info("Banking/Finance has been clicked Successfully in connect tab");
		Thread.sleep(3000);

		// Skip Scenario for Target Location and verification
		if (GenericWait.existsElement(
				".tab-content > div:nth-child(7) .custom-table-body  > div[ng-if=\"noJobs\"]:nth-child(1) h3")) {
			System.out.println(
					"**********No jobs to show in Connect Tab after selecting a value from Target Location filter**********");
			assertTrue(true);
		} else {
			// CLicking first firm in Regular Tab
			lawyerListingObjects.firstJobconnectTab.click();
			logger.info("Firm has been clicked Successfully in connect tab");
			Thread.sleep(3000);

			String[] targetLocationList = new String[] { "South Africa" };

			List<WebElement> targetLocConnectTab = Driver.Instance
					.findElements(By.cssSelector("#tab-specConnect-job0-list-location >li"));
			// Verification
			boolean found1 = false;
			int k = 0;
			for (k = 0; k < targetLocationList.length; k++) {
				for (int l = 0; l < targetLocConnectTab.size(); l++) {
					if (targetLocConnectTab.get(l).getText().equalsIgnoreCase(targetLocationList[k])) {
						System.out.println(
								"The matching Target Locations's name is " + targetLocConnectTab.get(l).getText());
						found1 = true;
						System.out.println(
								"**********VERIFICATION Passed- Target Location in Connect Tab after selecting a value from Target Location filter**********");
						break;
					}
				}
				if (found1)
					break;
			}
			if (!found1) {
				System.out.println(
						"**********VERIFICATION Failed- Target Location in Connect Tab after selecting a value from Target Location filter**********");
				assertTrue(false);

			}
		}

		// Selecting Selectivity value from filter
		lawyerListingObjects.selectivityDropdown_connectTab.click();
		Thread.sleep(1000);
		Select selectSelectivity = new Select(lawyerListingObjects.selectivityDropdown_connectTab);
		List<WebElement> options1 = selectSelectivity.getOptions();
		for (int i = 0; i <= options1.size(); i++) {
			if (options1.get(i).getText().equalsIgnoreCase("$$$$")) {
				options1.get(i).click();
				logger.info("Selectivity has been selected Successfully");
				Thread.sleep(1000);
				break;
			}
		}

		// Skip Scenario for selectivity and verification
		if (GenericWait.existsElement(
				".tab-content > div:nth-child(7) .custom-table-body  > div[ng-if=\"noJobs\"]:nth-child(1) h3")) {
			System.out.println("**********No jobs to show in Connect Tab**********");
			assertTrue(true);
		} else {
			// CLicking first firm in Regular Tab
			lawyerListingObjects.firstJobconnectTab.click();
			logger.info("Firm has been clicked Successfully in connect tab");
			Thread.sleep(3000);

			// Storing Job Name in Applications tab
			Thread.sleep(2000);
			WebElement selectivityVerify = lawyerListingObjects.storingSelectivityText_connectTab;
			stored_selectivityText = selectivityVerify.getText();
			System.out.println("Selectivity value for the job in Connect tab is " + stored_selectivityText);
			logger.info("Selectivity value for the job in Connect tab has been stored Successfully");

			// Verification
			Thread.sleep(2000);
			if (stored_selectivityText.equalsIgnoreCase(lawyerListingExcelReader.get("Selectivity"))) {
				System.out.println(
						"**********Verification PASSED- Selectivity value for the job in Connect tab exists in the range**********");
				assertTrue(true);
			} else {
				System.out.println(
						"**********Verification FAILED- Selectivity value for the job in Connect tab doesnot exist in the range**********");
				assertTrue(false);
			}
		}

		// Skip Scenario and again verification for Practice Area filtration after
		// applying all filters
		if (GenericWait.existsElement(
				".tab-content > div:nth-child(7) .custom-table-body  > div[ng-if=\"noJobs\"]:nth-child(1) h3")) {
			System.out.println("**********No jobs to show in Connect Tab after applying all filters**********");
			assertTrue(true);
		} else {

			String[] practiceAreaList = new String[] { "Acquisition/Leveraged Finance" };

			List<WebElement> practiceAreaConnectTab = Driver.Instance
					.findElements(By.cssSelector("#tab-specConnect-job0-list-practice > li"));
			// Verification
			boolean found = false;
			int j = 0;
			for (j = 0; j < practiceAreaList.length; j++) {
				for (int i = 0; i < practiceAreaConnectTab.size(); i++) {

					if (practiceAreaConnectTab.get(i).getText().equalsIgnoreCase(practiceAreaList[j])) {
						System.out.println(
								"The matching Practice Area's name is " + practiceAreaConnectTab.get(i).getText());
						found = true;
						System.out.println(
								"**********VERIFICATION Passed- Practice Area in Connect Tab after applying all filters**********");
						break;
					}
				}
				if (found)
					break;
			}
			if (!found) {
				System.out.println(
						"**********VERIFICATION Failed- Practice Area in Connect Tab after applying all filters********** ");
				assertTrue(false);
			}
		}

		// Skip Scenario for Target Location and verification after applying all filters
		if (GenericWait.existsElement(
				".tab-content > div:nth-child(7) .custom-table-body  > div[ng-if=\"noJobs\"]:nth-child(1) h3")) {
			System.out.println("**********No jobs to show in Connect Tab after applying all filters**********");
			assertTrue(true);
		} else {

			String[] targetLocationList = new String[] { "South Africa" };

			List<WebElement> targetLocConnectTab = Driver.Instance
					.findElements(By.cssSelector("#tab-specConnect-job0-list-location >li"));
			// Verification
			boolean found1 = false;
			int k = 0;
			for (k = 0; k < targetLocationList.length; k++) {
				for (int l = 0; l < targetLocConnectTab.size(); l++) {
					if (targetLocConnectTab.get(l).getText().equalsIgnoreCase(targetLocationList[k])) {
						System.out.println(
								"The matching Target Locations's name is " + targetLocConnectTab.get(l).getText());
						found1 = true;
						System.out.println(
								"**********VERIFICATION Passed- Target Location in Connect Tab after applying all filters**********");
						break;
					}
				}
				if (found1)
					break;
			}
			if (!found1) {
				System.out.println(
						"**********VERIFICATION Failed- Practice Area in Connect Tab after applying all filters**********");
				assertTrue(false);

			}
		}

		// CLicking second job in regular tab if it exists and verifying after applying
		// all filters
		if (GenericWait.existsElement("#tab-specConnect-job-row1")) {
			// CLicking second job in regular tab if it exists and verifying after applying
			// all filters
			lawyerListingObjects.secondJobConnectTab.click();
			logger.info("Second Firm has been clicked Successfully in connect tab");
			Thread.sleep(3000);

			String[] practiceAreaList = new String[] { "Acquisition/Leveraged Finance" };

			List<WebElement> practiceAreaConnectTab = Driver.Instance
					.findElements(By.cssSelector("#tab-specConnect-job1-list-practice > li"));
			// Verification of practice area
			boolean found = false;
			int j = 0;
			for (j = 0; j < practiceAreaList.length; j++) {
				for (int i = 0; i < practiceAreaConnectTab.size(); i++) {

					if (practiceAreaConnectTab.get(i).getText().equalsIgnoreCase(practiceAreaList[j])) {
						System.out.println(
								"The matching Practice Area's name is " + practiceAreaConnectTab.get(i).getText());
						found = true;
						System.out.println(
								"**********VERIFICATION Passed- Practice Area in Connect Tab after applying all filters against 2nd job**********");
						assertTrue(true);
						break;
					}
				}
				if (found)
					break;
			}
			if (!found) {
				System.out.println(
						"**********VERIFICATION Failed- Practice Area in Connect Tab after applying all filters  against 2nd job********** ");
				assertTrue(false);
			}

			String[] targetLocationList = new String[] { "South Africa" };

			List<WebElement> targetLocConnectTab = Driver.Instance
					.findElements(By.cssSelector("#tab-specConnect-job1-list-location >li"));
			// Verification of target location
			boolean found1 = false;
			int k = 0;
			for (k = 0; k < targetLocationList.length; k++) {
				for (int l = 0; l < targetLocConnectTab.size(); l++) {
					if (targetLocConnectTab.get(l).getText().equalsIgnoreCase(targetLocationList[k])) {
						System.out.println(
								"The matching Target Locations's name is " + targetLocConnectTab.get(l).getText());
						found1 = true;
						System.out.println(
								"**********VERIFICATION Passed- Target Location in Connect Tab after applying all filters against 2nd job**********");
						break;
					}
				}
				if (found1)
					break;
			}
			if (!found1) {
				System.out.println(
						"**********VERIFICATION Failed- Practice Area in Connect Tab after applying all filters against 2nd job**********");
				assertTrue(false);

			}
		}

		else {

			System.out.println("**********No second job exists in Connect Tab after applying all filters**********");
		}

	}
}