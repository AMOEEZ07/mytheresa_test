package com.privatePracticeJobs;

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
import com.pageObjects.PrivatePracticeJobsObjects;
import com.utilities.Driver;
import com.utilities.GenericWait;
import com.utilities.TestBase;

@Test
public class SearchJobByPqeSlider extends TestBase {
	Excel_DataReader excelReader = new Excel_DataReader();
	public static String storedPQE = "";
	// public static String storedJobName_AfterFilter = "";

	void drag_drop(WebElement source, WebElement target) {
		WebElement drag2 = source;
		WebElement dropto2 = target;
		Actions builder2 = new Actions(Driver.Instance);
		builder2.dragAndDrop(drag2, dropto2).perform();
	}

	public void selectJobByRangeLocator_ppTab() throws Exception {

		Logger logger = Logger.getLogger("Handling Private Practice Jobs tab at lawyer side through Range Locator");
		GenericWait GW = new GenericWait();
		PropertyConfigurator.configure("Log4j.properties");
		Map<String, String> privateJobsExcelReader = excelReader
				.getRowDataMap("testdata\\PrivatePracticeJobsLawyer.xlsx", 0, 1);
		PrivatePracticeJobsObjects privateJobsObjects = PageFactory.initElements(Driver.Instance,
				PrivatePracticeJobsObjects.class);
		Thread.sleep(3000);
		
		// Positioning Right-Pointer
		JavascriptExecutor js = (JavascriptExecutor) Driver.Instance;
		WebElement rightPointer = Driver.Instance.findElement(By.cssSelector("#PPPQEFilter > span div.jslider-pointer:nth-child(3)"));
		js.executeScript("arguments[0].setAttribute('style', 'left: 36.4%')", rightPointer);
		Thread.sleep(2000);
		drag_drop(Driver.Instance.findElement(By.cssSelector("#PPPQEFilter > span div.jslider-pointer:nth-child(3)")),
				rightPointer);
		Thread.sleep(2000);

		// Positioning Left-Pointer
		WebElement leftPointer = Driver.Instance.findElement(By.cssSelector("#PPPQEFilter > span div.jslider-pointer:nth-child(2)"));
		js.executeScript("arguments[0].setAttribute('style', 'left: 18.2%')", leftPointer);
		Thread.sleep(2000);
		drag_drop(Driver.Instance.findElement(By.cssSelector("#PPPQEFilter > span div.jslider-pointer:nth-child(2)")),leftPointer);
		Thread.sleep(2000);

		// Clicking 1st Firm name
		privateJobsObjects.firmName.click();
		logger.info("Firm Name has been clicked Successfully");
		Thread.sleep(2000);

		// Verification
		int j = 0;
		String[] pqe = new String[] { "NQ", "NQ-1", "1", "5", "5+", "5-6", "5-7", "6", "6+", "6-7", "7", "7+" };
		for (j = 0; j < pqe.length; j++) {
			if (privateJobsObjects.pqeText.getText().equalsIgnoreCase(pqe[j])) {
				System.out.println(
						"**********VERIFICATION FAILED- The job doesnot exist within the selected range of PQE**********");
				break;
			}

		}
		if (j == pqe.length) {
			System.out.println(
					"**********VERIFICATION PASSED- The job exists within the selected range of PQE**********");
		}

		// Closing 1st Firm name
		privateJobsObjects.firmName.click();
		Thread.sleep(2000);

		// Clicking 2nd Firm name
		privateJobsObjects.secondFirmName.click();
		Thread.sleep(2000);

		// Verification
		for (j = 0; j < pqe.length; j++) {
			if (privateJobsObjects.pqeText.getText().equalsIgnoreCase(pqe[j])) {
				System.out.println(
						"**********VERIFICATION FAILED- The job doesnot exist within the selected range of PQE**********");
				break;
			}

		}
		if (j == pqe.length) {
			System.out.println(
					"**********VERIFICATION PASSED- The job exists within the selected range of PQE**********");
		}

		// Closing 2nd Firm name
		privateJobsObjects.secondFirmName.click();
		Thread.sleep(2000);
		
		// Clicking 3rd Firm name
		privateJobsObjects.thirdFirmName.click();
		Thread.sleep(2000);

		// Verification
		for (j = 0; j < pqe.length; j++) {
			if (privateJobsObjects.pqeText.getText().equalsIgnoreCase(pqe[j])) {
				System.out.println(
						"**********VERIFICATION FAILED- The job doesnot exist within the selected range of PQE**********");
				break;
			}

		}
		if (j == pqe.length) {
			System.out.println(
					"**********VERIFICATION PASSED- The job exists within the selected range of PQE**********");
		}

		// Closing 3rd Firm name
		privateJobsObjects.thirdFirmName.click();
		Thread.sleep(2000);
		
	}
}
