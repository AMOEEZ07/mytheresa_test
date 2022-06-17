package com.signUp;

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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.dataReader.Excel_DataReader;
import com.pageObjects.AboutYouPage;
import com.utilities.Driver;
import com.utilities.GenericWait;
import com.utilities.TestBase;

public class About_you extends TestBase {
	Excel_DataReader excelReader = new Excel_DataReader();
	public static String storedJurisdictions = "";
	public static String storedPracticeArea = "";
	public static String storedTargetLoc = "";
	public static String stored_successMsg = "";

	@Test
	public void aboutYouDetail_signUp() throws Exception {
		Logger logger = Logger.getLogger("SignUp");
		AboutYouPage aboutYouPage = PageFactory.initElements(Driver.Instance, AboutYouPage.class);
		GenericWait GW = new GenericWait();
		Map<String, String> rowMap = excelReader.getRowDataMap("testdata\\SignUp.xlsx", 0, 1);

		// String UserName = rowMap.get("UserName").toString();
		Thread.sleep(5000);
		aboutYouPage.CurrentEmpField.clear();
		aboutYouPage.CurrentEmpField.sendKeys(rowMap.get("CurrentEmployee"));
		
		logger.info(rowMap.get("CurrentEmployee") + " has been entered in Current Employee field");
		// String Password = rowMap.get("Password").toString();
		aboutYouPage.EmpUniversityField.clear();
		aboutYouPage.EmpUniversityField.sendKeys(rowMap.get("Undergraduate_University"));
	Thread.sleep(3000);
		WebElement universityUL=aboutYouPage.University_List;
//		List<WebElement> universityLI=universityUL.findElements(By.tagName("li"));
//		universityLI.get(0).click();
	aboutYouPage.University_List.click();
	Thread.sleep(3000);
		logger.info(rowMap.get("Undergraduate_University") + " has been entered in Undergraduate University field");
		
		aboutYouPage.EmpNationality.click();
		
		aboutYouPage.EmpNationality.sendKeys(rowMap.get("Nationality"));
		
		logger.info(rowMap.get("Nationality") + " has been entered in Nationality field");
		
		Thread.sleep(3000);
		aboutYouPage.nationality_list.click();
		Thread.sleep(3000);
				aboutYouPage.EmpCurrentLocation.clear();
		
		aboutYouPage.EmpCurrentLocation.sendKeys(rowMap.get("CurrentLocation"));
		Thread.sleep(3000);
		aboutYouPage.currentLoc_list.click();
		Thread.sleep(3000);
		logger.info(rowMap.get("CurrentLocation") + " has been entered in Current Location field");
		aboutYouPage.EmpPhoneNum.clear();
		aboutYouPage.EmpPhoneNum.sendKeys(rowMap.get("ContactNumber"));
		logger.info(rowMap.get("ContactNumber") + " has been entered in Contact Number field");
		
	//	GW.WaitForElementToBeClickAble(aboutYouPage.DatePicker);
		//GW.WaitForElementToBeClickAble(aboutYouPage.SelectMonth);
		
		
		Thread.sleep(3000);
//		GW.WaitForElementToBeClickAble(aboutYouPage.DatePicker);
		aboutYouPage.DatePicker.click();
		Thread.sleep(2000);
//		GW.WaitForElementToBeClickAble(aboutYouPage.SelectMonth);
		aboutYouPage.SelectMonth.click();
		GW.WaitForElementToBeClickAble(aboutYouPage.Jurisdiction_Btn);
		Thread.sleep(3000);
		aboutYouPage.Jurisdictions.click();
		Thread.sleep(2000);
		GW.WaitForElementToBeClickAble(aboutYouPage.NextBtn);
		Thread.sleep(2000);
		aboutYouPage.practiceAreaExpertise.click();
		Thread.sleep(2000);
		GW.WaitForElementToBeClickAble(aboutYouPage.NextBtn);
		Thread.sleep(2000);
		GW.WaitForElementToBeClickAble(aboutYouPage.targetLocation);
		Thread.sleep(2000);
		GW.WaitForElementToBeClickAble(aboutYouPage.targetLocationExpandBtn);
		Thread.sleep(2000);
		GW.WaitForElementToBeClickAble(aboutYouPage.targetLocation1);
		Thread.sleep(2000);
		
		GW.WaitForElementToBeClickAble(aboutYouPage.NextBtn);
		
		// Storing Text from Jurisdictions
		Thread.sleep(2000);
		WebElement jurisdictionsVerify = aboutYouPage.storingJurisdiction;
		storedJurisdictions = jurisdictionsVerify.getText();
		System.out.println("The selected Jurisdiction is " + storedJurisdictions);
		logger.info("The selected Jurisdiction has been stored Successfully");

		// Verification of navigation to INHOUSE page by tab
		Thread.sleep(2000);
		if (storedJurisdictions.equalsIgnoreCase(rowMap.get("Jurisdictions"))) {
			System.out.println(
					"**********Verification of saving Jurisdictions has been PASSED**********");
		} else {
			System.out.println(
					"**********Verification of saving Jurisdictions has been FAILED**********");
		}
		
		// Storing Text from Practice Area
		Thread.sleep(2000);
		WebElement practiceAreaVerify = aboutYouPage.storingPracticeArea;
		storedPracticeArea = practiceAreaVerify.getText();
		System.out.println("The selected Practice Area is " + storedPracticeArea);
		logger.info("The selected Practice Area has been stored Successfully");

		// Verification of navigation to INHOUSE page by tab
		Thread.sleep(2000);
		if (storedPracticeArea.equalsIgnoreCase(rowMap.get("PracticeAreas"))) {
			System.out.println(
					"**********Verification of saving Practice Areas has been PASSED**********");
			assertTrue(true);
		} else {
			System.out.println(
					"**********Verification of saving Practice Areas has been FAILED**********");
			assertTrue(false);
		}
		
		// Storing Text from Target Location
		Thread.sleep(2000);
		WebElement targetLocVerify = aboutYouPage.storingTargetLoc;
		storedTargetLoc = targetLocVerify.getText();
		System.out.println("The selected Target Loc is " + storedTargetLoc);
		logger.info("The selected Target Location has been stored Successfully");

		// Verification of navigation to INHOUSE page by tab
		Thread.sleep(2000);
		if (storedTargetLoc.equalsIgnoreCase(rowMap.get("TargetLoc"))) {
			System.out.println("**********Verification of saving Target Location has been PASSED**********");
			assertTrue(true);
		} else {
			System.out.println("**********Verification of saving Target Location has been FAILED**********");
			assertTrue(false);
		}
		
		// Giving SRA ID
		Thread.sleep(2000);
		aboutYouPage.sraID.sendKeys(rowMap.get("SRAid"));
		Thread.sleep(2000);
		UploadFileUsingAutoIt(Driver.Instance);
		
		// Clicking Request Access
		Thread.sleep(2000);
		aboutYouPage.requestAccessBtn.click();
		GW.WaitForJQueryLoad();
		
		// Storing Job Name in Private Practice Jobs tab before filtration
		Thread.sleep(4000);
		WebElement confirmationSuccessMsg = aboutYouPage.accessRequestedSuccessMsg;
		stored_successMsg = confirmationSuccessMsg.getText();
		System.out.println("Confirmation Message is " + stored_successMsg);
		logger.info("Confirmation Message is has been stored Successfully");
		Thread.sleep(2000);

		// Verification
		Thread.sleep(2000);
		if (stored_successMsg.equalsIgnoreCase(rowMap.get("AccessRequested"))) {
			System.out.println("**********Request successfully sent to Admin for signup**********");
			assertTrue(true);
		} else {
			System.out.println("**********Request not sent to Admin for signing up**********");
			assertTrue(false);
		}
	}
		public void UploadFileUsingAutoIt(WebDriver driver) throws InterruptedException, IOException, AWTException {

			driver.findElement(By.id("newProfileUploadCV")).click();
			Thread.sleep(2000);
			
//			Copy your file's absolute path to the clipboard

			StringSelection ss = new StringSelection("F:\\asd.docx");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//			Paste the file's absolute path into the File name field of the File Upload dialog box

			//native key strokes for CTRL, V and ENTER keys
			
			Robot robot = new Robot();
		    robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    robot.keyPress(KeyEvent.VK_CONTROL);
		    robot.keyPress(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_CONTROL);
		    robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    Thread.sleep(2000);
		}
}
