package com.signUp;

import java.io.IOException;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.dataReader.Excel_DataReader;
import com.dataWrite.ExcelDataWriter;
import com.pageObjects.SignUpPage;
import com.utilities.Driver;
import com.utilities.GenericWait;
import com.utilities.TestBase;

public class SignUp extends TestBase {
	ExcelDataWriter excelWriter = new ExcelDataWriter ();
	Excel_DataReader excelReader = new Excel_DataReader();
	public static String eMail = "";
	@Test
	public void UserSignUp() throws InterruptedException {

		Logger logger = Logger.getLogger("SignUp");

		Driver.Instance.navigate().to(Driver.properties.getTestUrl());

		Thread.sleep(3000);
		SignUpPage signUpPage = PageFactory.initElements(Driver.Instance, SignUpPage.class);
		GenericWait GW = new GenericWait();
		Map<String, String> rowMap = excelReader.getRowDataMap("testdata\\SignUp.xlsx", 0, 1);

		// Clicking Sign-up button 
		
		// String UserName = rowMap.get("UserName").toString();
		GW.WaitForElementToBeClickAble(signUpPage.SignUp_tab);
		logger.info("Sign up tab has been clicked successfully");
		signUpPage.first_Name.sendKeys(rowMap.get("FirstName"));

		logger.info(rowMap.get("FirstName") + " has been entered in First Name field");
		// String Password = rowMap.get("Password").toString();

		signUpPage.last_Name.sendKeys(rowMap.get("LastName"));
		logger.info(rowMap.get("password") + " has been entered in lastname field");

		Long MailCounter = Long.parseLong(rowMap.get("MailCounter"));
		eMail = rowMap.get("Email") + MailCounter + rowMap.get("MailDomain");
		try {
			excelWriter.modifyExistingWorkbook((++MailCounter).toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		signUpPage.email_Address.sendKeys(eMail);
		logger.info(eMail + " has been entered in Email Address field");
		Thread.sleep(2000);
		
		signUpPage.confirm_Email.sendKeys(eMail);
		logger.info(eMail + " has been entered in Confirm Email Address field");
		
//		signUpPage.email_Address.sendKeys(rowMap.get("Email"));
//		logger.info(rowMap.get("Email") + " has been entered in Email Address field");
//		
//		signUpPage.confirm_Email.sendKeys(rowMap.get("Email"));
//		logger.info(rowMap.get("Email") + " has been entered in Confirm Email Address field");

		
		signUpPage.password.sendKeys(rowMap.get("Password"));
		logger.info(rowMap.get("Password") + " has been entered in Password field");
		GW.WaitForElementToBeClickAble(signUpPage.get_Started);
		
	    
	}
}
