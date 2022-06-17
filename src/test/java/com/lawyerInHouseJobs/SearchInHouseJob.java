package com.lawyerInHouseJobs;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
public class SearchInHouseJob extends TestBase {
	Excel_DataReader excelReader = new Excel_DataReader();

	void drag_drop(WebElement source, WebElement target) {
		WebElement drag2 = source;
		WebElement dropto2 = target;
		Actions builder2 = new Actions(Driver.Instance);
		builder2.dragAndDrop(drag2, dropto2).perform();
	}

	public void searchingJob_inHouse() throws Exception {

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
		Thread.sleep(2000);
		
		// Searching & selecting Target Locations from drop-down
		Thread.sleep(3000);
		inHouseJobsObjects.targetLocationList.click();
		WebElement locationUlElement = inHouseJobsObjects.targetLocationlistGroup;
		List<WebElement> locationLiSpans = locationUlElement
				.findElements(By.cssSelector("#IHLocationsFilter > div > div > ul > li > ul > li > a > span"));
		List<WebElement> locationLinks = locationUlElement
				.findElements(By.cssSelector("#IHLocationsFilter > div > div > ul > li > ul > li > a"));
		for (int j = 0; j < locationLiSpans.size(); j++) {
			if (locationLiSpans.get(j).getText().equalsIgnoreCase(inHouseJobsExcelReader.get("MyTargetLocation"))) {
				locationLinks.get(j).click();
				logger.info("My Target Location has been selected Successfully!");
				GW.WaitForJQueryLoad();
				Thread.sleep(4000);
				break;
			}
		}

		// Verification
		int i = 0;
		String[] myTargetLocation = new String[] { "AFRICA", "Morocco", "South Africa" };
		for (i = 0; i < myTargetLocation.length; i++) {
			if (inHouseJobsObjects.storingTagName.getText().equalsIgnoreCase(myTargetLocation[i])) {
				System.out
						.println("**********VERIFICATION PASSED- The job lies within the selected criteria**********");
				break;
			}

		}
		if (i == myTargetLocation.length) {
			System.out.println(
					"**********VERIFICATION FAILED- The job doesnot lie within the selected criteria**********");
		}

		// Setting left and right Pointers for PQE Slider
		
		// Positioning Left-Pointer
		JavascriptExecutor js = (JavascriptExecutor) Driver.Instance;
		WebElement leftPointer = Driver.Instance.findElement(By.cssSelector("div.filter-bar span div.jslider-pointer:nth-child(2)"));
		js.executeScript("arguments[0].setAttribute('style', 'left: 18.2%')", leftPointer);
		Thread.sleep(2000);
		drag_drop(Driver.Instance.findElement(By.cssSelector("div.filter-bar span div.jslider-pointer:nth-child(2)")),
				leftPointer);
		Thread.sleep(2000);

		// Positioning Right-Pointer
		WebElement rightPointer = Driver.Instance
				.findElement(By.cssSelector("div.filter-bar span div.jslider-pointer:nth-child(3)"));
		js.executeScript("arguments[0].setAttribute('style', 'left: 36.4%')", rightPointer);
		Thread.sleep(2000);
		drag_drop(Driver.Instance.findElement(By.cssSelector("div.filter-bar span div.jslider-pointer:nth-child(3)")),
				rightPointer);
		Thread.sleep(2000);
		
		// Verification
		int j = 0;
		String[] pqe = new String[] { "NQ", "NQ-1", "1", "5", "5+", "5-6", "5-7", "6", "6+", "6-7", "7", "7+" };
		for (j = 0; j < pqe.length; j++) {
			if (inHouseJobsObjects.pqeText.getText().equalsIgnoreCase(pqe[j])) {
				System.out.println(
						"**********VERIFICATION FAILED- The job doesnot exist within the selected range of PQE**********");
				break;
			}

		}
		if (j == pqe.length) {
			System.out.println(
					"**********VERIFICATION PASSED- The job exists within the selected range of PQE**********");
		}
		
	}
}