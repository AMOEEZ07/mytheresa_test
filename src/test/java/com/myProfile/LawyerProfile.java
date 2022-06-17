package com.myProfile;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.dataReader.Excel_DataReader;
import com.pageObjects.MyProfilePageObjects;
import com.signUp.SignUp;
import com.utilities.Driver;
import com.utilities.GenericWait;
import com.utilities.TestBase;


public class LawyerProfile extends TestBase {
	Excel_DataReader excelReader = new Excel_DataReader();
	public static String stored_currentLoc = "";
	public static String stored_lawyerNationality = "";
	public static String stored_lawyerUni = "";
	public static String stored_qualifiedIn = "";
	public static String stored_contactInfo = "";
	public static String stored_language = "";
	public static String stored_jurisdiction = "";
	public static String stored_jobRoleEmpHistory = "";
	public static String stored_targetLocEmpHistory = "";
	public static String stored_practiceAreaEmpHistory = "";
	public static String stored_jobRoleEmpHistoryEdit = "";
	
	@Test
	public void LawyerProfileTab() throws Exception {

		Logger logger = Logger.getLogger("Handling My Profile page at lawyer side");
		GenericWait GW = new GenericWait();
		PropertyConfigurator.configure("Log4j.properties");
		Map<String, String> myProfileExcelReader = excelReader.getRowDataMap("testdata\\MyProfile.xlsx", 0, 1);
		MyProfilePageObjects myProfileObjects = PageFactory.initElements(Driver.Instance, MyProfilePageObjects.class);
		Thread.sleep(4000);

		// Clicking My Profile tab
		myProfileObjects.myProfileTab.click();
		logger.info("My Profile tab has been Clicked Successfully!");
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);

		// Clicking Edit pencil button
		myProfileObjects.profileSectionEditBtn.click();
		logger.info("Edit button has been Clicked Successfully!");
		Thread.sleep(3000);

		// Clearing UnderGraduate University
		// myProfileObjects.underGraduateUni_clear.click();
		// Thread.sleep(2000);
		myProfileObjects.underGraduateUni_clear.clear();
		logger.info("Undergraduate university field has been cleared Successfully!");
		Thread.sleep(2000);

		// Clearing Nationality
		// myProfileObjects.nationality_clear.click();
		// Thread.sleep(2000);
		myProfileObjects.nationality_clear.clear();
		logger.info("Nationality field has been cleared Successfully!");
		Thread.sleep(2000);

		// Clearing Current Location
		myProfileObjects.currentLocation_clear.clear();
		logger.info("Current Location field has been cleared Successfully!");
		Thread.sleep(2000);

		// Clearing Qualified In
		myProfileObjects.qualifiedIn_datePicker.click();
		logger.info("Date has been cleared Successfully!");
		Thread.sleep(2000);
		myProfileObjects.qualifiedIn_datePickerClear.click();

		// Clicking Save button
		myProfileObjects.saveBtn.click();
		GW.WaitForJQueryLoad();
		logger.info("Save button has been Clicked Successfully!");
		Thread.sleep(3000);

		// Clicking Edit pencil button
		myProfileObjects.profileSectionEditBtn.click();
		logger.info("Edit button has been Clicked Successfully!");
		Thread.sleep(3000);

		// Giving Text to Undergraduate University
		myProfileObjects.underGraduateUni_clear.sendKeys(myProfileExcelReader.get("University"));
		logger.info("Undergraduate university field has been filled Successfully!");
		Thread.sleep(3000);

		// Giving Text to Nationality
		myProfileObjects.nationality_clear.sendKeys(myProfileExcelReader.get("Nationality"));
		logger.info("Nationality field has been filled Successfully!");
		Thread.sleep(3000);

		// Giving Text to Current Location
		myProfileObjects.currentLocation_clear.sendKeys(myProfileExcelReader.get("CurrentLocation"));
		logger.info("Current Location field has been given Successfully!");
		Thread.sleep(3000);

		// Giving Date to Qualified In
		myProfileObjects.qualifiedIn_datePicker.click();
		Thread.sleep(2000);
		myProfileObjects.todayBtn.click();
		logger.info("Date has been given Successfully!");

		// Clicking Save button
		myProfileObjects.saveBtn.click();
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);
		logger.info("Save button has been Clicked Successfully!");

		// Storing Lawyer University
		Thread.sleep(2000);
		WebElement uniName = myProfileObjects.storingLawyerUni;
		stored_lawyerUni = uniName.getText();
		System.out.println("Lawyer University is " + stored_lawyerUni);
		logger.info("Lawyer undergraduate University has been stored Successfully");
		Thread.sleep(2000);

		// Verification of Lawyer University
		Thread.sleep(2000);
		if (stored_lawyerUni.equalsIgnoreCase(myProfileExcelReader.get("University"))) {
			System.out.println("**********Verification of editing lawyer undergraduate has been passed**********");
			assertTrue(true);
		} else {
			System.out.println("**********Verification of editing lawyer undergraduate has been failed**********");
			assertTrue(false);
		}
		
		// Storing Lawyer Nationality
		Thread.sleep(2000);
		WebElement nationalityName = myProfileObjects.storingLawyerNationality;
		stored_lawyerNationality = nationalityName.getText();
		System.out.println("Lawyer nationality is " + stored_lawyerNationality);
		logger.info("Lawyer undergraduate University has been stored Successfully");
		Thread.sleep(2000);

		// Verification of Lawyer Nationality
		Thread.sleep(2000);
		if (stored_lawyerNationality.equalsIgnoreCase(myProfileExcelReader.get("Nationality"))) {
			System.out.println("**********Verification of editing nationality has been passed**********");
			assertTrue(true);
		} else {
			System.out.println("**********Verification of editing lawyer nationality has been failed**********");
			assertTrue(false);
		}
		
		// Storing Lawyer Location
		Thread.sleep(2000);
		WebElement locationName = myProfileObjects.storingLawyerCurrentLocation;
		stored_currentLoc = locationName.getText();
		System.out.println("Lawyer current location is " + stored_currentLoc);
		logger.info("Lawyer current location has been stored Successfully");
		Thread.sleep(2000);

		// Verification of Lawyer Location
		Thread.sleep(2000);
		if (stored_currentLoc.equalsIgnoreCase(myProfileExcelReader.get("CurrentLocation"))) {
			System.out.println("**********Verification of editing lawyer location has been passed**********");
			assertTrue(true);
		} else {
			System.out.println("**********Verification of editing lawyer location has been failed**********");
			assertTrue(false);
		}
		
//		// Storing Lawyer Qualified In
//		Thread.sleep(2000);
//		WebElement qualifiedIn = myProfileObjects.storingqualificationYear;
//		stored_qualifiedIn = qualifiedIn.getText();
//		System.out.println("Lawyer qualified In" + stored_qualifiedIn);
//		logger.info("Lawyer qualified in has been stored Successfully");
//		Thread.sleep(2000);
//
//		// Verification of Qualification Date
//		Thread.sleep(2000);
//		if (stored_qualifiedIn.equalsIgnoreCase(myProfileExcelReader.get("QualifiedIn"))) {
//			System.out.println("**********Verification of editing lawyer qualified In has been passed**********");
//		} else {
//			System.out.println("**********Verification of editing lawyer qualified In has been failed**********");
//		}
			
		// Clicking CONTACT INFO edit pencil button
		myProfileObjects.contactInfoEditBtn.click();
		logger.info("Contact Info Profile section edit button clicked Successfully");
		
		// Clearing contact Info and inserting new Value
		myProfileObjects.contactInfo_clear.clear();
		logger.info("Contact Info number has been cleared Successfully");
		Thread.sleep(1000);
		myProfileObjects.contactInfo_clear.sendKeys(myProfileExcelReader.get("ContactNumber"));
		logger.info("Contact Info number has been given Successfully");
		
		// Clicking Save button
		myProfileObjects.contactInfoSavBtn.click();
		logger.info("Save button has been clicked Successfully");
		GW.WaitForJQueryLoad();
		Thread.sleep(2000);
		
		// Storing Phone number in Contact Info
		Thread.sleep(2000);
		WebElement contactNum = myProfileObjects.storingContactInfo;
		stored_contactInfo = contactNum.getText();
		System.out.println("Lawyer Contact Info number is " + stored_contactInfo);
		logger.info("Lawyer Contact Info number has been stored Successfully");
		Thread.sleep(2000);

		// Verification of Lawyer Location
		Thread.sleep(2000);
		if (stored_contactInfo.equalsIgnoreCase(myProfileExcelReader.get("ContactNumber"))) {
			System.out.println("**********Verification of editing lawyer Contact Info number has been passed**********");
			assertTrue(true);
		} else {
			System.out.println("**********Verification of editing lawyer Contact Info number has been failed**********");
			assertTrue(false);
		}	
					
		// Clicking Edit Languages button
		myProfileObjects.languagesEditBtn.click();
		logger.info("Languages Profile section edit button clicked Successfully");
		Thread.sleep(1000);
		
		// Skip Scenario
		if (GenericWait.existsElement(".lang-modal ul.pref-language-list > li:nth-child(2) input[checked=\"checked\"]")) {
			// Selecting Language
			myProfileObjects.frenchLanguage.click();
			logger.info("Languages Profile section has been selecetd Successfully");
			Thread.sleep(2000);
			
			// Clicking Save button
			myProfileObjects.saveLanguageBtn.click();
			logger.info("Save button has been clicked Successfully");
			GW.WaitForJQueryLoad();
			Thread.sleep(2000);
			
			// Clicking Edit Languages button
			myProfileObjects.languagesEditBtn.click();
			logger.info("Languages Profile section edit button clicked Successfully");
			Thread.sleep(1000);
		}
		
		// Selecting Language
		myProfileObjects.frenchLanguage.click();
		logger.info("Languages Profile section has been selecetd Successfully");
		Thread.sleep(2000);
		
		// Clicking Save button
		myProfileObjects.saveLanguageBtn.click();
		logger.info("Save button has been clicked Successfully");
		GW.WaitForJQueryLoad();
		Thread.sleep(2000);
		
		// Storing Language in Contact Info
		Thread.sleep(2000);
		WebElement language = myProfileObjects.storingLanguageText;
		stored_language = language.getText();
		System.out.println("Stored language is " + stored_language);
		logger.info("Language has been stored Successfully");
		Thread.sleep(2000);

		// Verification of Lawyer Location
		Thread.sleep(2000);
		if (stored_language.equalsIgnoreCase(myProfileExcelReader.get("SelectedLang"))) {
			System.out.println("**********Verification of editing language has been passed**********");
			assertTrue(true);
		} else {
			System.out.println("**********Verification of editing language has been failed**********");
			assertTrue(false);
		}	

		
		// Clicking Jurisdictions Edit pencil button
		myProfileObjects.jurisdictionEditPencilBtn.click();
		logger.info("Jurisdiction Profile section edit button clicked Successfully");
		Thread.sleep(2000);
		
		// Skip Scenario
		if (GenericWait.existsElement("#LPJurisdictionList > li:nth-child(2) input[ng-checked=\"true\"]")) {
			// Clicking Jurisdictions check-box
			myProfileObjects.checkboxClickJurisdiction.click();
			logger.info("Jurisdiction selected Successfully from the list");
			Thread.sleep(2000);
			
			// Clicking Jurisdiction Save Button
			myProfileObjects.jurisdictionSaveBtn.click();
			logger.info("Save button has been clicked Successfully");
			GW.WaitForJQueryLoad();
			Thread.sleep(2000);
			
			// Clicking Jurisdictions Edit pencil button
			myProfileObjects.jurisdictionEditPencilBtn.click();
			logger.info("Jurisdiction Profile section edit button clicked Successfully");
			Thread.sleep(2000);
		}
		
		// Clicking Jurisdictions check-box
		myProfileObjects.checkboxClickJurisdiction.click();
		logger.info("Jurisdiction selected Successfully from the list");
		Thread.sleep(2000);
		
		// Clicking Jurisdiction Save Button
		myProfileObjects.jurisdictionSaveBtn.click();
		logger.info("Save button has been clicked Successfully");
		GW.WaitForJQueryLoad();
		Thread.sleep(2000);
		
		// Storing Jurisdictions
		Thread.sleep(2000);
		WebElement jurisdiction = myProfileObjects.storingJurisdictionText;
		stored_jurisdiction = jurisdiction.getText();
		System.out.println("Stored Jurisdiction is " + stored_jurisdiction);
		logger.info("Jurisdiction has been stored Successfully");
		Thread.sleep(2000);

		// Verification of Lawyer Location
		Thread.sleep(2000);
		if (stored_jurisdiction.equalsIgnoreCase(myProfileExcelReader.get("Jurisdiction"))) {
			System.out.println("**********Verification of editing jurisdiction has been passed**********");
			assertTrue(true);
		} else {
			System.out.println("**********Verification of editing jurisdiction has been failed**********");
			assertTrue(false);
		}

		Thread.sleep(2000);
		UploadFileForThreeTimes(Driver.Instance);
		Thread.sleep(1000);
		UploadFileForThreeTimes(Driver.Instance);
		Thread.sleep(1000);
		UploadFileForThreeTimes(Driver.Instance);
		Thread.sleep(1000);
		UploadFileUsingAutoIt(Driver.Instance);
		Thread.sleep(2000);
		// EMPLOYEMENT HISTORY SECTION
		// Clicking add button
		myProfileObjects.addBtnEmpHistory.click();
		logger.info("Add button has been clicked Successfully");
		Thread.sleep(3000);
		
		// Giving Employer Name
		myProfileObjects.employerName.sendKeys(myProfileExcelReader.get("EmpHistoryName"));
		logger.info("Employer Name has been given Successfully");
		Thread.sleep(3000);
		myProfileObjects.employerNameDropdownList.click();
		Thread.sleep(3000);
		
		// Giving Job Title
		myProfileObjects.jobTitle.sendKeys(myProfileExcelReader.get("JobTitleEmpHis"));
		logger.info("Job Title has been given Successfully");
		Thread.sleep(3000);
		
		// Selecting Start Date from Date Picker
		myProfileObjects.datePickerFrom.click();
		Thread.sleep(2000);
		
		// Clicking left button
		myProfileObjects.datePickerCalendar_leftBtn.click();
		Thread.sleep(2000);
		myProfileObjects.datePickerCalendar_leftBtn.click();
		Thread.sleep(2000);
		myProfileObjects.startDatePicker.click();
		Thread.sleep(2000);
		
		// Selecting Stop Date
		myProfileObjects.datePickerTo.click();
		Thread.sleep(2000);
		myProfileObjects.endDatePicker.click();
		Thread.sleep(2000);
		// Clicking Locations button
		myProfileObjects.empHistoryLocationBtn.click();
		Thread.sleep(2000);
		myProfileObjects.empHistoryLocation.click();
		
		// Clicking Save button
		myProfileObjects.empHistoryLocationSaveBtn.click();
		Thread.sleep(2000);

		// Clicking Practice Area button
		myProfileObjects.empHistoryPracticeAreaBtn.click();
		Thread.sleep(2000);
		myProfileObjects.empHistorypracticeAreaList.click();
		Thread.sleep(2000);
		
		// Clicking Save button
		myProfileObjects.practiceExpertiseSavBtn.click();
		Thread.sleep(2000);
		
		// Clicking Save button
		myProfileObjects.empHistorySavBtn.click();
		Thread.sleep(2000);
		
		// Storing Job Role in Employment History Section
		Thread.sleep(2000);
		WebElement jobRoleHistorySection = myProfileObjects.storingJobRoleEmpHistory;
		stored_jobRoleEmpHistory = jobRoleHistorySection.getText();
		System.out.println("Lawyer Employment History Job role is " + stored_jobRoleEmpHistory);
		logger.info("Lawyer Employment History Job role has been stored Successfully");
		Thread.sleep(2000);

		// Verification of Job Role in Employment History Section
		Thread.sleep(2000);
		if (stored_jobRoleEmpHistory.equalsIgnoreCase(myProfileExcelReader.get("JobTitleEmpHis"))) {
			System.out.println("**********Verification of adding Job Title Employment History has been passed**********");
			assertTrue(true);
		} else {
			System.out.println("**********Verification of adding Job Title Employment History has been failed**********");
			assertTrue(false);
		}
		
		// Storing Target Location in Employment History Section
		Thread.sleep(2000);
		WebElement targetLocHistorySection = myProfileObjects.storingTargetLocEmpHistory;
		stored_targetLocEmpHistory = targetLocHistorySection.getText();
		System.out.println("Lawyer Employment History Target Location is " + stored_targetLocEmpHistory);
		logger.info("Lawyer Employment History Target Location has been stored Successfully");
		Thread.sleep(2000);

		// Verification of Target Location in Employment History Section
		Thread.sleep(2000);
		if (stored_targetLocEmpHistory.equalsIgnoreCase(myProfileExcelReader.get("EmpHistoryLoc"))) {
			System.out.println("**********Verification of adding Target Location in Employment History Section has been passed**********");
			assertTrue(true);
		} else {
			System.out.println("**********Verification of adding Target Location in Employment History Section has been passed**********");
			assertTrue(false);
		}
		
		// Storing Practice Area in Employment History Section
		Thread.sleep(2000);
		WebElement practiceAreaHistorySection = myProfileObjects.storingPracticeAreaEmpHistory;
		stored_practiceAreaEmpHistory = practiceAreaHistorySection.getText();
		System.out.println("Lawyer Employment Practice Area is " + stored_practiceAreaEmpHistory);
		logger.info("Lawyer Employment History Practice Area has been stored Successfully");
		Thread.sleep(2000);

		// Verification of Practice Area in Employment History Section
		Thread.sleep(2000);
		if (stored_practiceAreaEmpHistory.equalsIgnoreCase(myProfileExcelReader.get("PracticeAreaEmpHistory"))) {
			System.out.println("**********Verification of adding Practice Area in Employment History Section has been passed**********");
			assertTrue(true);
		} else {
			System.out.println("**********Verification of adding Practice Area in Employment History Section has been failed**********");
			assertTrue(false);
		}
		
		// Clicking Edit pencil Employment history section
		myProfileObjects.editPencilEmpHistory.click();
		
		// Editing Employer Name
		myProfileObjects.employerName.clear();
		Thread.sleep(1000);
		myProfileObjects.employerName.sendKeys(myProfileExcelReader.get("EmpHistoryNameEdit"));
		logger.info("Employer Name has been given Successfully");
		Thread.sleep(3000);
		myProfileObjects.employerNameDropdownList.click();
		Thread.sleep(3000);
		
		// Editing Job Title
		myProfileObjects.jobTitle.clear();
		Thread.sleep(1000);
		myProfileObjects.jobTitle.sendKeys(myProfileExcelReader.get("JobTitleEmpHistoryEdit"));
		logger.info("Job Title has been given Successfully");
		Thread.sleep(3000);
		
		// Clicking Save button
		myProfileObjects.empHistorySavBtn.click();
		Thread.sleep(2000);
		
		// Storing Job Role in Employment History Section after Edit
		Thread.sleep(2000);
		WebElement jobRoleHistorySectionEdit = myProfileObjects.storingJobRoleEmpHistory;
		stored_jobRoleEmpHistoryEdit = jobRoleHistorySectionEdit.getText();
		System.out.println("Lawyer Employment History Job role is " + stored_jobRoleEmpHistoryEdit);
		logger.info("Lawyer Employment History Job role has been stored Successfully");
		Thread.sleep(2000);

		// Verification of Job Role in Employment History Section after Edit
		Thread.sleep(2000);
		if (stored_jobRoleEmpHistoryEdit.equalsIgnoreCase(myProfileExcelReader.get("JobTitleEmpHistoryEdit"))) {
			System.out.println("**********Verification of editing Lawyer Employment History has been passed**********");
			assertTrue(true);
		} else {
			System.out.println("**********Verification of adding Lawyer Employment History has been failed**********");
			assertTrue(false);
		}
		
		// Deleting the created Job History
		myProfileObjects.deleteBtnEmpHistory.click();
		Thread.sleep(2000);
		
		// Verification
		if (GenericWait.existsElement("#empHistorySection > div:nth-child(2) a.btn-noline-info:nth-child(2)")) {
			System.out.println("**********Verification of Deleting Lawyer Employment History has been failed**********");
			assertTrue(false);
			Thread.sleep(3000);
		}
		else {
			System.out.println("**********Verification of Deleting Lawyer Employment History has been passed**********");
			assertTrue(true);
		}
		
	}

	public void UploadFileForThreeTimes(WebDriver driver) throws InterruptedException, IOException, AWTException {

		driver.findElement(By.cssSelector("div.col-md-offset-6 > button")).click();
		Thread.sleep(2000);

		// Copy your file's absolute path to the clipboard

		StringSelection ss = new StringSelection("F:\\asd.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		// Paste the file's absolute path into the File name field of the File Upload
		// dialog box

		// native key strokes for CTRL, V and ENTER keys

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);

	}
	
	public void UploadFileUsingAutoIt(WebDriver driver) throws InterruptedException, IOException, AWTException {

		driver.findElement(By.cssSelector("div.col-md-offset-6 > button")).click();
		Thread.sleep(2000);

		// Copy your file's absolute path to the clipboard

		StringSelection ss = new StringSelection("F:\\asd.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		// Paste the file's absolute path into the File name field of the File Upload
		// dialog box

		// native key strokes for CTRL, V and ENTER keys

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(5000);

		if (GenericWait.existsElement("button[class=\"btn btn-w-md btn-line-info ng-hide\"]")) {
			System.out.println("********************Upload CV button is not appearing********************");
		} else {
			System.out.println("********************Upload CV button is appearing********************");
		}

		// Deleting CV
		if (GenericWait.existsElement("button[ng-click=\"deleteCV(loggedInLawyer.user.user_ID)\"]")
				|| GenericWait.existsElement("deleteCV(loggedInLawyer.user.user_ID, cv)")) {
			driver.findElement(By.cssSelector(
					"div[ng-controller=\"CVCtrl\"] h5[class=\"row ng-scope\"]:nth-child(1) button[class=\"btn btn-noline-info btn-xs\"]:nth-child(2)"))
					.click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("button[ng-click=\"yes()\"] ")).click();
			Thread.sleep(2000);
		} else {
			System.out.println("No CV uploaded");
		}

	}
}
