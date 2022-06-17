package com.testCaseUtilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import com.dataReader.Excel_DataReader;
import com.utilities.TestBase;


public class LawyerVerification extends TestBase {
	Excel_DataReader excelReader = new Excel_DataReader();

		public Map<String, String> verification(int sheetnum, String cellname, String gridname, String tablename,
				String filepath) throws Exception {

			Logger logger = Logger.getLogger("Newbie Verification");
			PropertyConfigurator.configure("Log4j.properties");
			Thread.sleep(2000);
			SearchGrid search = new SearchGrid();
			List<WebElement> tdEle = search.searching(sheetnum, cellname, gridname, tablename, filepath);
			Map<String, String> userVerify = excelReader.getRowDataMap("testdata\\" + filepath + ".xlsx", sheetnum, 1);
			Map<String, String> Failure_Records = new HashMap<String, String>();
			Thread.sleep(2000);
			// for (int i = 0; i <= tdEle.size(); i++) {
			if (tdEle.get(3).getText().equalsIgnoreCase(userVerify.get("FirstName"))) {
				logger.info("Expected Firstname: " + userVerify.get("FirstName") + " and Actual:" + tdEle.get(3).getText() + " MATCHED");

			} else {
				Failure_Records.put("FirstName","Actual: " + tdEle.get(3).getText() + " Expected: " + userVerify.get("firstname"));
			}

			if (tdEle.get(4).getText().equalsIgnoreCase(userVerify.get("LastName"))) {
				logger.info("Expected Lastname: " + userVerify.get("LastName") + " and Actual:" + tdEle.get(4).getText() + " MATCHED");

			} else {
				Failure_Records.put("LastName","Actual: " + tdEle.get(4).getText() + " Expected: " + userVerify.get("lastname"));
			}

			if (tdEle.get(5).getText().equalsIgnoreCase(userVerify.get("Email"))) {
				logger.info("Expected Email: " + userVerify.get("Email") + " and Actual:" + tdEle.get(5).getText() + " MATCHED");
			} else {
				Failure_Records.put("Email", "Actual: " + tdEle.get(5).getText() + " Expected: " + userVerify.get("Email"));
			}
			if (tdEle.get(7).getText().equalsIgnoreCase(userVerify.get("Status"))) {
				logger.info("Expected Status: " + userVerify.get("Status") + " and Actual:" + tdEle.get(7).getText() + " MATCHED");
			} else {
				Failure_Records.put("Status", "Actual: " + tdEle.get(7).getText() + " Expected: " + userVerify.get("Status"));
			}

			System.out.println(Failure_Records);
			return Failure_Records;

		
	}
	
	
}
