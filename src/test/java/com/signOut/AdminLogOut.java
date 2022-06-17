package com.signOut;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.pageObjects.LogoutPageObjects;
import com.pageObjects.PrivatePracticeJobsObjects;
import com.utilities.Driver;
import com.utilities.GenericWait;
import com.utilities.TestBase;

@Test
public class AdminLogOut extends TestBase {
	public void adminSignOut() throws Exception {

		Logger logger = Logger.getLogger("Handling logout flow for the user");
		GenericWait GW = new GenericWait();
		PropertyConfigurator.configure("Log4j.properties");
		LogoutPageObjects logOutObjects = PageFactory.initElements(Driver.Instance, LogoutPageObjects.class);
		Thread.sleep(2000);

		// Clicking Logout Dropdown
		logOutObjects.admin_logOutDropDown.click();
		logger.info("Logout dropdown has been Clicked Successfully!");
		Thread.sleep(3000);

		// Clicking Logout Dropdown
		logOutObjects.admin_logOutDropDownBtn.click();
		logger.info("Logout dropdown button has been Clicked Successfully!");
		GW.WaitForJQueryLoad();
		Thread.sleep(3000);

	}

}
