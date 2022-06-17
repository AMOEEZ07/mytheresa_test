package com.login;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Map;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.dataReader.Excel_DataReader;
import com.pageObjects.LoginPage;
import com.utilities.Driver;
import com.utilities.GenericWait;
import com.utilities.TestBase;

public class LawyerLogin extends TestBase {
	Excel_DataReader excelReader = new Excel_DataReader();
	ExtentTest testInfo;
	public static String stored_homepage = "";
	@Test
	public void lexstep_lawyerLogin() throws Exception {
		Logger logger = Logger.getLogger("Login");
		Driver.Instance.navigate().to(Driver.properties.getTestUrl());
		LoginPage LoginPage = PageFactory.initElements(Driver.Instance, LoginPage.class);

		GenericWait GW = new GenericWait();

		Map<String, String> rowMap = excelReader.getRowDataMap("testdata\\Lawyer_login.xlsx", 0, 1);

		// GW.WaitForElementToBeClickAble( LoginPage.Login_bar);

		// String UserName = rowMap.get("UserName").toString();
//		 GW.WaitForElementToBeClickAble(LoginPage.Login_tab);
		Thread.sleep(3000);
//		Long MailCounter = Long.parseLong(rowMap.get("MailCounter"));
//		String Mail = rowMap.get("Email") + (--MailCounter) + rowMap.get("MailDomain");
//		LoginPage.email_address.sendKeys(Mail);
		LoginPage.email_address.sendKeys(rowMap.get("Email"));
		Thread.sleep(1000);

		logger.info(rowMap.get("Email") + " has been entered in Email Address field");
		// String Password = rowMap.get("Password").toString();

		LoginPage.password.sendKeys(rowMap.get("Password"));
		logger.info(rowMap.get("Password") + " has been entered in Password field");

		GW.WaitForElementToBeClickAble(LoginPage.loginBtn);
		Thread.sleep(5000);

		// Storing Job Name in Private Practice Jobs tab before filtration
		Thread.sleep(2000);
		WebElement homepage = LoginPage.storingLawyerName;
		stored_homepage = homepage.getText();
		System.out.println("User Name is " + stored_homepage);
		logger.info("User Name has been stored Successfully");
		Thread.sleep(2000);

		// Verification
		Thread.sleep(2000);
		if (stored_homepage.equalsIgnoreCase(rowMap.get("Name"))) {
			System.out.println("**********SIGN-IN SUCCESSFULL AS LAWYER**********");
			assertTrue(true);
		} else {
			System.out.println("**********SIGN-IN IS NOT SUCCESSFULL AS LAWYER**********");
			assertTrue(false);
		}
	}
}