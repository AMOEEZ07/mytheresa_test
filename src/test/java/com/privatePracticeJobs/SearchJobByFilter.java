package com.privatePracticeJobs;

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
import com.pageObjects.PrivatePracticeJobsObjects;
import com.utilities.Driver;
import com.utilities.GenericWait;
import com.utilities.TestBase;

@Test
public class SearchJobByFilter extends TestBase {
	Excel_DataReader excelReader = new Excel_DataReader();
	public static String storedJobName_BeforFilter = "";
	public static String storedJobName_AfterFilter = "";

	public void selectJobDropdown_ppTab() throws Exception {

		Logger logger = Logger.getLogger("Handling Private Practice Jobs tab at lawyer side through filteration");
		GenericWait GW = new GenericWait();
		PropertyConfigurator.configure("Log4j.properties");
		Map<String, String> privateJobsExcelReader = excelReader.getRowDataMap("testdata\\PrivatePracticeJobsLawyer.xlsx", 0, 1);
		PrivatePracticeJobsObjects privateJobsObjects = PageFactory.initElements(Driver.Instance,PrivatePracticeJobsObjects.class);
		Thread.sleep(3000);

		// Clicking Private Practice Jobs Tab
		privateJobsObjects.privatePracticeJobsTab.click();
		GW.WaitForJQueryLoad();
		Thread.sleep(2000);

		// Searching & selecting Target Locations from drop-down
		Thread.sleep(3000);
		privateJobsObjects.targetLocationList.click();
		WebElement locationUlElement = privateJobsObjects.targetLocationlistGroup;
		List<WebElement> locationLiSpans = locationUlElement.findElements(By.cssSelector("#PPJobsLocDropDown > div > div > ul > li > ul > li > a > span"));
		List<WebElement> locationLinks = locationUlElement.findElements(By.cssSelector("#PPJobsLocDropDown > div > div > ul > li > ul > li > a"));
		for (int j = 0; j < locationLiSpans.size(); j++) {
			if (locationLiSpans.get(j).getText().equalsIgnoreCase(privateJobsExcelReader.get("MyTargetLocation"))) {
				locationLinks.get(j).click();
				logger.info("My Target Location has been selected Successfully!");
				GW.WaitForJQueryLoad();
				Thread.sleep(4000);
				break;
			}
		}

		// Clicking 1st firm name in the grid
		Thread.sleep(4000);
		privateJobsObjects.firstFirmName.click();
		Thread.sleep(2000);
		// Verification
		int i = 0;
		String[] myTargetLocation = new String[] { "AFRICA", "Morocco", "South Africa" };
		for (i = 0; i < myTargetLocation.length; i++) {
			if (privateJobsObjects.storingTagName.getText().equalsIgnoreCase(myTargetLocation[i])) {
				System.out
						.println("**********VERIFICATION PASSED- The job lies within the selected criteria**********");
				break;
			}

		}
		if (i == myTargetLocation.length) {
			System.out.println(
					"**********VERIFICATION FAILED- The job doesnot lie within the selected criteria**********");
		}

		// Closing 1st firm name in the grid
		privateJobsObjects.firstFirmName.click();
		Thread.sleep(2000);

		// Clicking 2nd Firm in the grid
		privateJobsObjects.secondFirmName.click();
		Thread.sleep(2000);

		// Verification
		for (i = 0; i < myTargetLocation.length; i++) {
			if (privateJobsObjects.storingTagName.getText().equalsIgnoreCase(myTargetLocation[i])) {
				System.out
						.println("**********VERIFICATION PASSED- The job lies within the selected criteria**********");
				break;
			}

		}
		if (i == myTargetLocation.length) {
			System.out.println(
					"**********VERIFICATION FAILED- The job doesnot lie within the selected criteria**********");
		}

		// Closing 2nd Firm in the grid
		privateJobsObjects.secondFirmName.click();
		Thread.sleep(2000);

		// Clicking 3rd Firm in the grid
		privateJobsObjects.thirdFirmName.click();
		Thread.sleep(2000);

		// Verification
		for (i = 0; i < myTargetLocation.length; i++) {
			if (privateJobsObjects.storingTagName.getText().equalsIgnoreCase(myTargetLocation[i])) {
				System.out
						.println("**********VERIFICATION PASSED- The job lies within the selected criteria**********");
				break;
			}

		}
		if (i == myTargetLocation.length) {
			System.out.println(
					"**********VERIFICATION FAILED- The job doesnot lie within the selected criteria**********");
		}

		// Closing 3rd Firm in the grid
		privateJobsObjects.thirdFirmName.click();
		Thread.sleep(2000);

	}
}