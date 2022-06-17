package com.adminLawyerListing;

import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.dataReader.Excel_DataReader;
import com.pageObjects.AdminLawyerListingObjects;
import com.utilities.Driver;
import com.utilities.GenericWait;
import com.utilities.TestBase;

public class ConnectTab extends TestBase {
	Excel_DataReader excelReader = new Excel_DataReader();

	public static String stored_jobName = "";
	public static String stored_jobNameVerify = "";
	public static String stored_lexstepJobDate = "";

	void drag_drop(WebElement source, WebElement target) {
		WebElement drag2 = source;
		WebElement dropto2 = target;
		Actions builder2 = new Actions(Driver.Instance);
		builder2.dragAndDrop(drag2, dropto2).perform();
	}

	@Test
	public void LawyerListingConnectTab() throws Exception {

		Logger logger = Logger.getLogger("Handling Lawyer Listing flows at admin side in Connect tab");
		GenericWait GW = new GenericWait();
		PropertyConfigurator.configure("Log4j.properties");
		Map<String, String> lawyerListingExcelReader = excelReader.getRowDataMap("testdata\\SignUp.xlsx", 0, 1);
		AdminLawyerListingObjects lawyerListingObjects = PageFactory.initElements(Driver.Instance,
				AdminLawyerListingObjects.class);
		Thread.sleep(4000);
		
		// Clicking Connect tab
		lawyerListingObjects.connectTab.click();
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);
		
		// CLicking first firm in Connect Tab
		lawyerListingObjects.firstJobConnectTab.click();
		logger.info("Firm has been clicked Successfully");
		Thread.sleep(3000);

		String[] practiceAreaList = new String[] { "Acquisition/Leveraged Finance", "Asset Finance",
				"Contentious Financial Regulation", "Funds", "General Lending", "High Yield", "Islamic Finance",
				"Non-contentious Financial Regulation", "Projects: Construction",
				"Projects: Energy & Natural Resources", "Projects: Infrastructure and PFI/PPP", "Real Estate Finance",
				"Restructuring & Insolvency", "Trade Finance" };

		List<WebElement> practiceAreaConnectTab = Driver.Instance
				.findElements(By.cssSelector("#tab-specConnect-job0-list-practice > li"));
		// Verification
		boolean found = false;
		int j = 0;
		for (j = 0; j < practiceAreaList.length; j++) {
			for (int i = 0; i < practiceAreaConnectTab.size(); i++) {
				if (practiceAreaConnectTab.get(i).getText().equalsIgnoreCase(practiceAreaList[j])) {
					System.out.println("The matching Practice Area's name is " + practiceAreaConnectTab.get(i).getText());
					found = true;
					System.out.println("**********VERIFICATION Passed- Practice Area in Connect Tab**********");
					break;
				}
			}
			if (found)
				break;
		}
		if (!found) {
			System.out.println("**********VERIFICATION Failed- Practice Area in Connect Tab********** ");
		}
		
		String[] targetLocationList = new String[] { "Aberdeen", "Belfast",
				"Birmingham", "Bristol", "Cambridge", "Coventry", "Edinburgh",
				"Exeter", "Glasgow","Leeds", "Leicester", "Liverpool",
				"London", "Manchester","Milton Keynes","Newcastle","Nottingham","Oxford","Portsmouth","Reading","Sheffield","South Africa","Southampton","Wales","Winchester"};

		List<WebElement> targetLocConnectTab = Driver.Instance
				.findElements(By.cssSelector("#tab-specConnect-job0-list-location >li"));
		// Verification
		boolean found1 = false;
		int k = 0;
		for (k = 0; k < targetLocationList.length; k++) {
			for (int l = 0; l < targetLocConnectTab.size(); l++) {
				if (targetLocConnectTab.get(l).getText().equalsIgnoreCase(targetLocationList[k])) {
					System.out.println("The matching Target Locations's name is " + targetLocConnectTab.get(l).getText());
					found1 = true;
					System.out.println("**********VERIFICATION Passed- Target Location in Connect Tab**********");
					break;
				}
			}
			if (found1)
				break;
		}
		if (!found1) {
			System.out.println("**********VERIFICATION Failed- Target Location in Connect Tab**********");
		}
		
		// Positioning Right-Pointer
		JavascriptExecutor js = (JavascriptExecutor) Driver.Instance;
		WebElement rightPointer = Driver.Instance
				.findElement(By.cssSelector("#tab-specConnect-filter-pqe td > div.jslider-pointer:nth-child(3)"));
		js.executeScript("arguments[0].setAttribute('style', 'left: 46.2%')", rightPointer);
		Thread.sleep(2000);
		drag_drop(
				Driver.Instance
						.findElement(By.cssSelector("#tab-specConnect-filter-pqe td > div.jslider-pointer:nth-child(3)")),
				rightPointer);
		Thread.sleep(2000);

		// Positioning Left-Pointer
		// JavascriptExecutor js = (JavascriptExecutor)Driver.Instance;
		WebElement leftPointer = Driver.Instance
				.findElement(By.cssSelector("#tab-specConnect-filter-pqe td > div.jslider-pointer:nth-child(2)"));
		js.executeScript("arguments[0].setAttribute('style', 'left: 30.8%')", leftPointer);
		Thread.sleep(2000);
		drag_drop(
				Driver.Instance
						.findElement(By.cssSelector("#tab-specConnect-filter-pqe td > div.jslider-pointer:nth-child(2)")),
				leftPointer);
		Thread.sleep(2000);

		// Verification
		int m = 0;
		String[] pqe = new String[] { "PQE: NQ", "PQE: NQ-1", "PQE: 1", "PQE: 5", "PQE: 5+", "PQE: 5-6", "PQE: 5-7",
				"PQE: 6", "PQE: 6+", "PQE: 6-7", "PQE: 7", "PQE: 7+" };
		for (m = 0; m < pqe.length; m++) {
			if (lawyerListingObjects.pqeText_connectTab.getText().equalsIgnoreCase(pqe[m])) {
				System.out.println(
						"**********VERIFICATION FAILED- The job doesnot exist within the selected range of PQE on Connect Tab**********");
				break;
			}

		}
		if (m == pqe.length) {
			System.out.println(
					"**********VERIFICATION PASSED- The job exists within the selected range of PQE on Connect Tab**********");
		}

		// CLicking first firm in Connect Tab
		lawyerListingObjects.firstJobConnectTab.click();
		logger.info("Firm has been clicked Successfully");
		Thread.sleep(3000);

		// Storing Job Name in Regular tab
		Thread.sleep(2000);
		WebElement jobName = lawyerListingObjects.storingJobName_connectTab;
		stored_jobName = jobName.getText();
		System.out.println("Job name in Connect tab is " + stored_jobName);
		logger.info("Job Name has been stored Successfully in Connect tab");
		Thread.sleep(2000);

		// Clicking interested button
		lawyerListingObjects.interestedBtn_connectTab.click();
		Thread.sleep(2000);
		
		// Clicking Share Profile button
//		Driver.Instance.findElement(By.cssSelector("button[ng-click=\"cancel()\"]")).click();
		lawyerListingObjects.shareProfileBtn_regularTab.click();
		Thread.sleep(2000);
		
		// Verification of button disabling
		if (GenericWait.existsElement("#tab-specConnect-job0-shared-btn /*button[ng-disabled=\"true\"]")) {
			System.out.println("**********Verification is passed- Interested button in Connect tab is disabled !!**********");
			assertTrue(true);
		} else {
			System.out.println("**********Verification is failed- Interested button in Connect tab is still enabled !!**********");
			assertTrue(false);
		}
		
		
		
		// Skip Scenario
		if (GenericWait.existsElement("#tab-specConnect-job-row0.appliedjob")) {
			System.out.println("**********Verification is passed- Background color against applied job changed succesfully in Connect tab !!**********");
			assertTrue(true);
		} else {
			System.out.println("**********Verification is failed- Background color against applied job did not change in Connect tab !!**********");
			assertTrue(false);
		}
		
		// Clicking Application tab
		lawyerListingObjects.applicationsTab.click();
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);

		// Storing Job Name in Applications tab
		Thread.sleep(2000);
		WebElement jobNameVerify = lawyerListingObjects.storingJobNameVerify_applicationsTab;
		stored_jobNameVerify = jobNameVerify.getText();
		System.out.println("Job name for verification in Applications tab is " + stored_jobNameVerify);
		logger.info("Job Name for verification has been stored Successfully");

		// Verification
		Thread.sleep(2000);
		if (stored_jobName.equalsIgnoreCase(stored_jobNameVerify)) {
			System.out.println("**********Verification of sending a job proposal has been passed in Connect Tab**********");
			assertTrue(true);
		} else {
			System.out.println("**********Verification of sending a job proposal has been failed in Connect Tab**********");
			assertTrue(false);
		}
		
		// Getting date of local system
		DateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		System.out.println("Current date of local system is " + date1);

		// Storing date in application
		Thread.sleep(2000); 
		WebElement lexstepJobDate =lawyerListingObjects.storingLexstepJobDate; 
		stored_lexstepJobDate =lexstepJobDate.getText(); 
		System.out.println("Lawyer first name is " +stored_lexstepJobDate);
		logger.info("Lawyer first name has been stored Successfully");
		Thread.sleep(2000);

		// Verification of First name 
		Thread.sleep(2000); 
		if(stored_lexstepJobDate.equalsIgnoreCase("INDICATED INTEREST OFF-PLATFORM ON " + date1)) 
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