package com.adminLawyerListing;

import static org.testng.Assert.assertTrue;

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

public class LawyerListingVerifyRegularTab extends TestBase {
	Excel_DataReader excelReader = new Excel_DataReader();

	public static String stored_jurisdiction = "";
	public static String stored_targetLoc = "";
	public static String stored_currentLoc = "";
	public static String stored_targetPractice = "";
	public static String stored_lawyerStatus = "";
	public static String stored_phoneNumber = "";
	public static String stored_lastName = "";
	public static String stored_firstName = "";
	public static String stored_eMAil = "";
	public static String stored_jobName = "";
	public static String stored_jobNameVerify = "";

	void drag_drop(WebElement source, WebElement target) {
		WebElement drag2 = source;
		WebElement dropto2 = target;
		Actions builder2 = new Actions(Driver.Instance);
		builder2.dragAndDrop(drag2, dropto2).perform();
	}

	@Test
	public void LawyerListingRegularTab() throws Exception {

		Logger logger = Logger.getLogger("Handling Lawyer Listing flows at admin side");
		GenericWait GW = new GenericWait();
		PropertyConfigurator.configure("Log4j.properties");
		Map<String, String> lawyerListingExcelReader = excelReader.getRowDataMap("testdata\\SignUp.xlsx", 0, 1);
		AdminLawyerListingObjects lawyerListingObjects = PageFactory.initElements(Driver.Instance,
				AdminLawyerListingObjects.class);
		Thread.sleep(4000);

		// Clicking Lawyers tab
		lawyerListingObjects.lawyersTab.click();
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);

		// Storing email in Private Practice Jobs tab
		Thread.sleep(2000);
		WebElement email = lawyerListingObjects.storingEmail_id;
		stored_eMAil = email.getText();
		System.out.println("Email is " + stored_eMAil);
		Thread.sleep(2000);

		// Searching email-ID in the search E-mailBox
		lawyerListingObjects.searchBox.sendKeys(stored_eMAil);
		logger.info("E-mail has been entered in the grid successfully");
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);


		// Storing First name 
		Thread.sleep(2000); 
		WebElement firstName =lawyerListingObjects.storingFirstName; 
		stored_firstName =firstName.getText(); System.out.println("Lawyer first name is " +stored_firstName);
		logger.info("Lawyer first name has been stored Successfully");
		Thread.sleep(2000);

		// Verification of First name 
		Thread.sleep(2000); 
		if(stored_firstName.equalsIgnoreCase(lawyerListingExcelReader.get("FirstName"))
				) 
		{ 
			System.out.println("**********Verification of lawyers first name has been passed**********"); 
			assertTrue(true); 
		} 
		else 
		{ 
			System.out.println("**********Verification of lawyers first name has been failed**********"); 
			assertTrue(false); 
		}

		
		// Storing Last name 
		Thread.sleep(2000); 
		WebElement lastName =lawyerListingObjects.storingLastName; 
		stored_lastName = lastName.getText();
		System.out.println("Lawyer last name is " + stored_lastName);
		logger.info("Lawyer last name has been stored Successfully");
		Thread.sleep(2000);

		// Verification of First name 
		Thread.sleep(2000); 
		if(stored_lastName.equalsIgnoreCase(lawyerListingExcelReader.get("LastName")))
		{ 
			System.out.println("**********Verification of lawyers last name has been passed**********"); 
			assertTrue(true); 
		} 
		else { 
			System.out.println("**********Verification of lawyers last name has been failed**********"); 
			assertTrue(false); 
		}

		// Storing phone number 
		Thread.sleep(2000); 
		WebElement phoneNumber =lawyerListingObjects.storingPhoneNum; 
		stored_phoneNumber =phoneNumber.getText(); 
		System.out.println("Lawyer phone number is " +stored_phoneNumber);
		logger.info("Lawyer phone number has been stored Successfully");
		Thread.sleep(2000);

		// Verification of First name 
		Thread.sleep(2000); 
		if(stored_phoneNumber.equalsIgnoreCase(lawyerListingExcelReader.get("ContactNumber"))) 
		{ 
			System.out.println("**********Verification of lawyers phone number has been passed**********"); 
			assertTrue(true); 
		} 
		else 
		{ 
			System.out.println("**********Verification of lawyers phone number has been failed**********"); 
			assertTrue(false); 
		}

		// Storing lawyer status 
		Thread.sleep(2000); 
		WebElement lawyerStatus =lawyerListingObjects.storingLawyerStatus; 
		stored_lawyerStatus =lawyerStatus.getText(); 
		System.out.println("Lawyer status is " +stored_lawyerStatus);
		logger.info("Lawyer status has been stored Successfully");
		Thread.sleep(2000);

		
		// Verification 
		Thread.sleep(2000); 
		if(stored_lawyerStatus.equalsIgnoreCase(lawyerListingExcelReader.get("StatusAfterApproval"))) 
		{ 
			System.out.println("**********Verification of lawyers status has been passed**********"); 
			assertTrue(true); 
		} 
		else 
		{ 
			System.out.println("**********Verification of lawyers status has been failed**********"); 
			assertTrue(false); 
		}

		// Storing Target Practice 
		Thread.sleep(2000); 
		WebElement targetPrac =lawyerListingObjects.storingTargetPractice; 
		stored_targetPractice =targetPrac.getText(); System.out.println("Lawyer target practice is " +stored_targetPractice);
		logger.info("Lawyer target practice has been stored Successfully");
		Thread.sleep(2000);

		// Verification of Target Practice 
		Thread.sleep(2000); 
		if(stored_targetPractice.equalsIgnoreCase(lawyerListingExcelReader.get("PracticeAreas"))) 
		{ 
			System.out.println("**********Verification of lawyers target practice has been passed**********"); 
			assertTrue(true); 
		}
		else { 
			System.out.println("**********Verification of lawyers target practice has been failed**********"); 
			assertTrue(false); 
		}

		// Storing current Location 
		Thread.sleep(2000); 
		WebElement currentLoc =lawyerListingObjects.storingCurrentLoc; 
		stored_currentLoc =currentLoc.getText(); 
		System.out.println("Lawyer current location is " +stored_currentLoc);
		logger.info("Lawyer current location has been stored Successfully");
		Thread.sleep(2000);

		// Verification of Target Practice 
		Thread.sleep(2000); 
		if(stored_currentLoc.equalsIgnoreCase(lawyerListingExcelReader.get("CurrentLocation"))) 
		{ System.out.println("**********Verification of lawyers current location has been passed**********"); 
		assertTrue(true); 
		} 
		else
		{ 
			System.out.println("**********Verification of lawyers current location has been failed**********"); 
			assertTrue(false); 
		}

		// Storing Target Location 
		Thread.sleep(2000); 
		WebElement targetLoc =lawyerListingObjects.storingTargetLoc; 
		stored_targetLoc =targetLoc.getText(); 
		System.out.println("Lawyer target location is " +stored_targetLoc);
		logger.info("Lawyer target location has been stored Successfully");
		Thread.sleep(2000);

		// Verification of Target Practice 
		Thread.sleep(2000); 
		if(stored_targetLoc.equalsIgnoreCase(lawyerListingExcelReader.get("TargetLoc1"))) 
		{ 
			System.out.println("**********Verification of lawyers target location has been passed**********"); 
			assertTrue(true); } 
		else 
		{ 
			System.out.println("**********Verification of lawyers target location has been failed**********"); 
			assertTrue(false); 
		}

		// Storing jurisdiction 
		Thread.sleep(2000); 
		WebElement jurisdiction =lawyerListingObjects.storingJurisdiction; 
		stored_jurisdiction =jurisdiction.getText(); 
		System.out.println("Lawyer jurisdiction is " +stored_jurisdiction);
		logger.info("Lawyer jurisdiction has been stored Successfully");
		Thread.sleep(2000);

		// Verification of Target Practice 
		Thread.sleep(2000); 
		if(stored_jurisdiction.equalsIgnoreCase(lawyerListingExcelReader.get("Jurisdictions"))) 
		{ 
			System.out.println("**********Verification of lawyers jurisdiction has been passed**********"); 
			assertTrue(true); 
		} 
		else { 
			System.out.println("**********Verification of lawyers jurisdiction has been failed**********"); 
			assertTrue(false); 
		}


		// Clicking view button
		lawyerListingObjects.viewBtn.click();
		logger.info("View button has been clicked Successfully");
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);

		// // CLicking Preference Tab
		// lawyerListingObjects.prferenceTab.click();
		// logger.info("Preference tab has been clicked Successfully");

		// CLicking Regular Tab
		lawyerListingObjects.regularTab.click();
		logger.info("Regular tab has been clicked Successfully");
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);

		// CLicking first firm in Regular Tab
		lawyerListingObjects.firstJobregularTab.click();
		logger.info("Firm has been clicked Successfully");
		Thread.sleep(3000);

		String[] practiceAreaList = new String[] { "Acquisition/Leveraged Finance", "Asset Finance",
				"Contentious Financial Regulation", "Funds", "General Lending", "High Yield", "Islamic Finance",
				"Non-contentious Financial Regulation", "Projects: Construction",
				"Projects: Energy & Natural Resources", "Projects: Infrastructure and PFI/PPP", "Real Estate Finance",
				"Restructuring & Insolvency", "Trade Finance" };

		List<WebElement> practiceAreaRegularTab = Driver.Instance
				.findElements(By.cssSelector("#tab-regCustom-job0-list-practice > li"));
		// Verification
		boolean found = false;
		int j = 0;
		for (j = 0; j < practiceAreaList.length; j++) {
			for (int i = 0; i < practiceAreaRegularTab.size(); i++) {
				if (practiceAreaRegularTab.get(i).getText().equalsIgnoreCase(practiceAreaList[j])) {
					System.out.println("The matching Practice Area's name is " + practiceAreaRegularTab.get(i).getText());
					found = true;
					System.out.println("**********VERIFICATION Passed- Practice Area in Regular Tab**********");
					break;
				}
			}
			if (found)
				break;
		}
		if (!found) {
			System.out.println("**********VERIFICATION Failed- Practice Area in Regular Tab********** ");
		}
		
		String[] targetLocationList = new String[] { "Aberdeen", "Belfast",
				"Birmingham", "Bristol", "Cambridge", "Coventry", "Edinburgh",
				"Exeter", "Glasgow","Leeds", "Leicester", "Liverpool",
				"London", "Manchester","Milton Keynes","Newcastle","Nottingham","Oxford","Portsmouth","Reading","Sheffield","South Africa","Southampton","Wales","Winchester"};

		List<WebElement> targetLocRegularTab = Driver.Instance
				.findElements(By.cssSelector("#tab-regCustom-job0-list-location >li"));
		// Verification
		boolean found1 = false;
		int k = 0;
		for (k = 0; k < targetLocationList.length; k++) {
			for (int l = 0; l < targetLocRegularTab.size(); l++) {
				if (targetLocRegularTab.get(l).getText().equalsIgnoreCase(targetLocationList[k])) {
					System.out.println("The matching Target Locations's name is " + targetLocRegularTab.get(l).getText());
					found1 = true;
					System.out.println("**********VERIFICATION Passed- Target Location in Regular Tab**********");
					break;
				}
			}
			if (found1)
				break;
		}
		if (!found1) {
			System.out.println("**********VERIFICATION Failed- Target Location in Regular Tab**********");
		}
		
		// Positioning Right-Pointer
		JavascriptExecutor js = (JavascriptExecutor)Driver.Instance; 
		WebElement rightPointer = Driver.Instance.findElement(By.cssSelector("#tab-regCustom-filter-pqe td > div.jslider-pointer:nth-child(3)"));
		js.executeScript("arguments[0].setAttribute('style', 'left: 46.2%')", rightPointer);
		Thread.sleep(2000);
		drag_drop(Driver.Instance.findElement(By.cssSelector("#tab-regCustom-filter-pqe td > div.jslider-pointer:nth-child(3)")),
				rightPointer);
		Thread.sleep(2000);

		// Positioning Left-Pointer 
//		JavascriptExecutor js = (JavascriptExecutor)Driver.Instance; 
		WebElement leftPointer = Driver.Instance.findElement(By.cssSelector("#tab-regCustom-filter-pqe td > div.jslider-pointer:nth-child(2)")); 
		js.executeScript("arguments[0].setAttribute('style', 'left: 30.8%')",leftPointer); 
		Thread.sleep(2000); 
		drag_drop(Driver.Instance.findElement(By.cssSelector("#tab-regCustom-filter-pqe td > div.jslider-pointer:nth-child(2)")),leftPointer); 
		Thread.sleep(2000);
		
		// Verification
		int m = 0;
		String[] pqe = new String[] { "PQE: NQ", "PQE: NQ-1", "PQE: 1", "PQE: 5", "PQE: 5+", "PQE: 5-6", "PQE: 5-7", "PQE: 6", "PQE: 6+", "PQE: 6-7", "PQE: 7", "PQE: 7+" };
		for (m = 0; m < pqe.length; m++) {
			if (lawyerListingObjects.pqeText_regularTab.getText().equalsIgnoreCase(pqe[m])) {
				System.out.println(
						"**********VERIFICATION FAILED- The job doesnot exist within the selected range of PQE  on Regular Tab**********");
				break;
			}

		}
		if (m == pqe.length) {
			System.out.println(
					"**********VERIFICATION PASSED- The job exists within the selected range of PQE on Regular Tab**********");
		}

//		// Clicking explore button
//		lawyerListingObjects.exploreBtn_regularTab.click();
//		Thread.sleep(2000);
		
		// CLicking first firm in Regular Tab
		lawyerListingObjects.firstJobregularTab.click();
		logger.info("Firm has been clicked Successfully");
		Thread.sleep(3000);
		
		// Storing Job Name in Regular tab
		Thread.sleep(2000);
		WebElement jobName = lawyerListingObjects.storingJobName;
		stored_jobName = jobName.getText();
		System.out.println("Job name in Regular tab is " + stored_jobName);
		logger.info("Job Name has been stored Successfully");
		Thread.sleep(2000);

		// Clicking interested button
		lawyerListingObjects.interestedBtn_regularTab.click();
		Thread.sleep(2000);
		
		// Clicking Share Profile button
//		Driver.Instance.findElement(By.cssSelector("button[ng-click=\"cancel()\"]")).click();
		lawyerListingObjects.shareProfileBtn_regularTab.click();
		Thread.sleep(2000);
		
		// Verification of button disabling
		if (GenericWait.existsElement("#tab-regCustom-job0-shared-btn /*button[ng-disabled=\"true\"]")) {
			System.out.println("**********Verification is passed- Interested button is disabled !!**********");
		} else {
			System.out.println("**********Verification is failed- Interested button is still enabled !!**********");
		}
		
		
		
		// Skip Scenario
		if (GenericWait.existsElement("#tab-regCustom-job-row0.appliedjob")) {
			System.out.println("**********Verification is passed- Background color against applied job changed succesfully !!**********");
		} else {
			System.out.println("**********Verification is failed- Background color against applied job did not change !!**********");
		}
		
		// Clicking Application tab
		lawyerListingObjects.applicationsTab.click();
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);
		
		// Storing Job Name in Application tab
		Thread.sleep(2000);
		WebElement jobNameVerify = lawyerListingObjects.storingJobNameVerify;
		stored_jobNameVerify = jobNameVerify.getText();
		System.out.println("Job name for verification in Applications tab is " + stored_jobNameVerify);
		logger.info("Job Name for verification has been stored Successfully");

		// Verification
		Thread.sleep(2000);
		if (stored_jobName.equalsIgnoreCase(stored_jobNameVerify)) {
			System.out.println("**********Verification of sending a job proposal has been passed**********");
			assertTrue(true);
		} else {
			System.out.println("**********Verification of sending a job proposal has been failed**********");
			assertTrue(false);
		}
	}
}