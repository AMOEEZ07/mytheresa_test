package com.JavaError;

import java.util.Date;
import java.util.Set;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;
import com.utilities.Driver;
import com.utilities.TestBase;
import org.openqa.selenium.devtools.DevTools;

//import org.openqa.selenium.devtools.v84.log.log;
public class javaError extends TestBase {

	DevTools devTools;
	@Test
	public void consoleError() throws Exception {
	
	        Driver.Instance.navigate().to(Driver.properties.getTestUrl());
			LogEntries logEntries = Driver.Instance.manage().logs().get(LogType.BROWSER);
			for (LogEntry entry : logEntries) {
			System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
    }
		Set<String> logtyp = Driver.Instance.manage().logs().getAvailableLogTypes();
	      for (String s : logtyp) {
	         System.out.println(s);
	      }
	}
}