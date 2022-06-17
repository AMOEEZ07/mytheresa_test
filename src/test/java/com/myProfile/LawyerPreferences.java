package com.myProfile;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
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
import com.utilities.Driver;
import com.utilities.GenericWait;
import com.utilities.TestBase;

@Test
public class LawyerPreferences extends TestBase {
	Excel_DataReader excelReader = new Excel_DataReader();
	public static String stored_practiceAreaExpertise = "";
	public static String stored_targetLoc = "";

	
	public void LawyerPreferencesTab() throws Exception {

		Logger logger = Logger.getLogger("Handling Preferences tab at lawyer side");
		GenericWait GW = new GenericWait();
		PropertyConfigurator.configure("Log4j.properties");
		Map<String, String> myProfileExcelReader = excelReader.getRowDataMap("testdata\\MyProfile.xlsx", 0, 1);
		MyProfilePageObjects myProfileObjects = PageFactory.initElements(Driver.Instance, MyProfilePageObjects.class);
		Thread.sleep(4000);

//		// Clicking My Profile tab
//		myProfileObjects.myProfileTab.click();
//		logger.info("My Profile tab has been Clicked Successfully!");
//		GW.WaitForJQueryLoad();
//		Thread.sleep(2000);
		
		// Clicking Preferences tab
		myProfileObjects.preferencesTab.click();
		logger.info("Preferences tab has been Clicked Successfully!");
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);
		
		// Clicking Practice Area Expertise edit button
		myProfileObjects.practiceAreaExpertiseEdit_btn.click();
		logger.info("Edit button has been Clicked Successfully!");
		Thread.sleep(2000);
		
		// Skip Scenario
		if (GenericWait.existsElement("#LPPracticeAreasList:nth-child(3) input[checked=\"checked\"]")) {
			myProfileObjects.practiceAreaList_charities.click();
			Thread.sleep(3000);
			// Clicking save button
			myProfileObjects.practiceExpertiseSavBtn.click();
			logger.info("Save button has been Clicked Successfully!");
			GW.WaitForJQueryLoad();
			Thread.sleep(2000);
			// Clicking Practice Area Expertise edit button
			myProfileObjects.practiceAreaExpertiseEdit_btn.click();
			logger.info("Edit button has been Clicked Successfully!");
			Thread.sleep(2000);
		}
		
		// Clicking charities check box in Practice Area expertise
		myProfileObjects.practiceAreaList_charities.click();
		logger.info("Practice Area has been selected Successfully!");
		
		// Clicking Save button
		myProfileObjects.practiceExpertiseSavBtn.click();
		logger.info("Save button has been Clicked Successfully!");
		GW.WaitForJQueryLoad();
		Thread.sleep(2000);
		
		// Storing Lawyer Practice Area Expertise
		Thread.sleep(2000);
		WebElement practiceExpertiseTag = myProfileObjects.storingPracticeExpertiseText;
		stored_practiceAreaExpertise = practiceExpertiseTag.getText();
		System.out.println("Practice Area Expertise is " + stored_practiceAreaExpertise);
		logger.info("Practice Area Expertise of lawyer has been stored Successfully");
		Thread.sleep(2000);

		// Verification of Lawyer Practice Area Expertise
		Thread.sleep(2000);
		if (stored_practiceAreaExpertise.equalsIgnoreCase(myProfileExcelReader.get("PracticeAreaExpertise"))) {
			System.out.println("**********Verification of editing nationality has been passed**********");
			assertTrue(true);
		} else {
			System.out.println("**********Verification of editing lawyer nationality has been failed**********");
			assertTrue(false);
		}
		
		// Clicking Target LocationEdit button
		myProfileObjects.targetLocEditBtn.click();
		logger.info("Edit button has been Clicked Successfully!");
		Thread.sleep(2000);
		
		// Clicking expand button
		myProfileObjects.targetLocExpanBtn.click();
		logger.info("Expand button has been Clicked Successfully!");
		Thread.sleep(2000);
		
		// Skip Scenario
		if (GenericWait.existsElement("#LPLocationsList:nth-child(8) ul.practice-area-list li:nth-child(1) input[checked=\"checked\"]")) {
			myProfileObjects.targetLocCheckboxSelection.click();
			Thread.sleep(3000);
			// Clicking save button
			myProfileObjects.practiceExpertiseSavBtn.click();
			logger.info("Save button has been Clicked Successfully!");
			GW.WaitForJQueryLoad();
			Thread.sleep(2000);
			// Clicking Target LocationEdit button
			myProfileObjects.targetLocEditBtn.click();
			logger.info("Edit button has been Clicked Successfully!");
			Thread.sleep(2000);
			
		}
		
		myProfileObjects.targetLocCheckboxSelection.click();
		logger.info("Checkbox button has been Clicked Successfully!");
		Thread.sleep(2000);
		
		// Clicking save button
		myProfileObjects.practiceExpertiseSavBtn.click();
		logger.info("Save button has been Clicked Successfully!");
		GW.WaitForJQueryLoad();
		Thread.sleep(2000);

		// Storing Target Location
		Thread.sleep(2000);
		WebElement locationName = myProfileObjects.storingLocText;
		stored_targetLoc = locationName.getText();
		System.out.println("Lawyer target location is " + stored_targetLoc);
		logger.info("Lawyer current location has been stored Successfully");
		Thread.sleep(2000);

		// Verification of Lawyer Location
		Thread.sleep(2000);
		if (stored_targetLoc.equalsIgnoreCase(myProfileExcelReader.get("TargetLoc"))) {
			System.out.println("**********Verification of editing lawyer location has been passed**********");
			assertTrue(true);
		} else {
			System.out.println("**********Verification of editing lawyer location has been failed**********");
			assertTrue(false);
		}
		
		// Clicking Private Practice Jobs tab
		myProfileObjects.privatePracticeJobsTab.click();
		GW.WaitForJQueryLoad();
		Thread.sleep(2000);
		
		// Searching & selecting Practice Area from drop-down
		Thread.sleep(3000);
		myProfileObjects.practiceAreaList.click();											
		List<WebElement> practiceAreaLinks = Driver.Instance.findElements(By.cssSelector("#PPJobsPADropDown > div > div > ul > li > ul > li > a"));
		for (int j = 0; j < practiceAreaLinks.size(); j++) {
			if (practiceAreaLinks.get(j).getText().equalsIgnoreCase(myProfileExcelReader.get("PracticeAreaExpertise"))) {
				practiceAreaLinks.get(j).click();
				logger.info(
						"**********Verification successfull- The Practice Area exists in the dropdown on Private Practice Jobs Tab**********");
				GW.WaitForJQueryLoad();
				Thread.sleep(4000);
				break;
			}
		}
		
		// Searching & selecting Target Locations from drop-down
		Thread.sleep(3000);
		myProfileObjects.targetLocationList.click();
		WebElement locationUlElement = myProfileObjects.targetLocationlistGroup;
		List<WebElement> locationLiSpans = locationUlElement.findElements(By.cssSelector("#PPJobsLocDropDown > div > div > ul > li > ul > li > ul > li > a > span"));
		List<WebElement> locationLinks = locationUlElement.findElements(By.cssSelector("#PPJobsLocDropDown > div > div > ul > li > ul > li > ul > li > a"));
		for (int j = 0; j < locationLiSpans.size(); j++) {
			if (locationLiSpans.get(j).getText().equalsIgnoreCase(myProfileExcelReader.get("TargetLoc"))) {
				locationLinks.get(j).click();
				logger.info(
						"**********Verification successfull- The Target Location exists in the dropdown on Private Practice Jobs Tab**********");
				GW.WaitForJQueryLoad();
				Thread.sleep(4000);
				break;
			}
		}
		
		// Clearing & restoring My Practice Area
		Thread.sleep(2000);
		myProfileObjects.practiceAreaList.click();
		Thread.sleep(2000);
		myProfileObjects.practiceAreaDefaultlist.click();
		
		// Clearing & restoring My Target Location
		Thread.sleep(2000);
		myProfileObjects.targetLocationList.click();
		Thread.sleep(2000);
		myProfileObjects.targetLocationDefaultlist.click();
		GW.WaitForJQueryLoad();
		
		// Clicking In House Jobs Tab
		Thread.sleep(3000);
		myProfileObjects.inHouseJobsTab.click();
		GW.WaitForJQueryLoad();
		Thread.sleep(2000);
		
		// Searching & selecting Practice Area from drop-down
		Thread.sleep(3000);
		myProfileObjects.practiceAreaList_inHouseTab.click();
		Thread.sleep(1000);
		List<WebElement> practiceAreaLinks_inhouseTab = Driver.Instance.findElements(By.cssSelector("#IHPracticeAreasFilter > div > div > ul > li > ul > li > a"));
		for (int j = 0; j < practiceAreaLinks_inhouseTab.size(); j++) {
			if (practiceAreaLinks_inhouseTab.get(j).getText()
					.equalsIgnoreCase(myProfileExcelReader.get("PracticeAreaExpertise"))) {
				practiceAreaLinks_inhouseTab.get(j).click();
				logger.info(
						"**********Verification successfull- The Practice Area exists in the dropdown on InHouse Jobs Tab**********");
				GW.WaitForJQueryLoad();
				Thread.sleep(4000);
				break;
			}
		}

		// Searching & selecting Target Locations from drop-down
		Thread.sleep(3000);
		myProfileObjects.targetLocationList_inHouseTab.click();
		WebElement locationUlElementJobsTab = myProfileObjects.targetLocationlistGroup_inHouseTab;
		List<WebElement> locationLiSpansJobsTab = locationUlElementJobsTab.findElements(By.cssSelector("#IHLocationsFilter > div > div > ul > li > ul > li > ul > li > a > span"));
		List<WebElement> locationLinksJobsTab = locationUlElementJobsTab.findElements(By.cssSelector("#IHLocationsFilter > div > div > ul > li > ul > li > ul > li > a"));
		for (int j = 0; j < locationLiSpansJobsTab.size(); j++) {
			if (locationLiSpansJobsTab.get(j).getText().equalsIgnoreCase(myProfileExcelReader.get("TargetLoc"))) {
				locationLinksJobsTab.get(j).click();
				logger.info("**********Verification successfull- The selected location exists in the dropdown on InHouse Jobs Tab**********");
				GW.WaitForJQueryLoad();
				Thread.sleep(4000);
				break;
			}
		}
		
		// Clearing & restoring My Practice Area
		Thread.sleep(2000);
		myProfileObjects.practiceAreaList_inHouseTab.click();
		Thread.sleep(2000);
		myProfileObjects.practiceAreaDefaultlist_inHouseTab.click();
		
		// Clearing & restoring My Target Location
		Thread.sleep(2000);
		myProfileObjects.targetLocationList_inHouseTab.click();
		Thread.sleep(2000);
		myProfileObjects.targetLocationDefaultlist_inHouseTab.click();
		
	}
}