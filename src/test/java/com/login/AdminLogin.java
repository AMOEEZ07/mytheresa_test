package com.login;

import static org.testng.Assert.assertTrue;

import java.util.Map;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.dataReader.Excel_DataReader;
import com.pageObjects.LoginPage;
import com.utilities.Driver;
import com.utilities.GenericWait;
import com.utilities.TestBase;

public class AdminLogin extends TestBase {
	Excel_DataReader excelReader = new Excel_DataReader();
	ExtentTest testInfo;
	public static String stored_homepage = "";

	@Test
	public void lexstep_adminLogin() throws Exception {
		Logger logger = Logger.getLogger("Login");
		Driver.Instance.navigate().to(Driver.properties.getTestUrl());
		LoginPage LoginPage = PageFactory.initElements(Driver.Instance, LoginPage.class);

		GenericWait GW = new GenericWait();

		Map<String, String> rowMap = excelReader.getRowDataMap("testdata\\AdminLogin.xlsx", 0, 1);

		// GW.WaitForElementToBeClickAble( LoginPage.Login_bar);

		// String UserName = rowMap.get("UserName").toString();
		// GW.WaitForElementToBeClickAble(LoginPage.Login_tab);
		Thread.sleep(5000);
		LoginPage.email_address.sendKeys(rowMap.get("Email"));

		logger.info(rowMap.get("Email") + " has been entered in Email Address field");
		// String Password = rowMap.get("Password").toString();

		LoginPage.password.sendKeys(rowMap.get("Password"));
		logger.info(rowMap.get("Password") + " has been entered in Password field");

		GW.WaitForElementToBeClickAble(LoginPage.loginBtn);

		Thread.sleep(5000);

		// Storing User Name after sign-in
		Thread.sleep(2000);
		WebElement homepage = LoginPage.storingAdminName;
		stored_homepage = homepage.getText();
		System.out.println("User Name is " + stored_homepage);
		logger.info("User Name has been stored Successfully");
		Thread.sleep(2000);

		// Verification
		Thread.sleep(2000);
		if (stored_homepage.equalsIgnoreCase(rowMap.get("Name"))) {
			System.out.println("**********SIGN-IN SUCCESSFULL AS ADMIN**********");
			assertTrue(true);
		} else {
			System.out.println("**********SIGN-IN NOT SUCCESSFULL AS ADMIN**********");
			assertTrue(false);
		}
	}
}