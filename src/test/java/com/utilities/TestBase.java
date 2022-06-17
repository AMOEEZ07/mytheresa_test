package com.utilities;

import org.testng.annotations.BeforeSuite;
import java.lang.reflect.Method;

import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.testCaseUtilities.ExtentManager;
import com.utilities.Driver;

public class TestBase {
	 ExtentTest testInfo;
	 ExtentHtmlReporter htmlReporter;
	 
	 @BeforeMethod
	 public void BeforeM(Method method){
	  String testName=method.getName();
	  testInfo=ExtentManager.GetExtent().createTest(testName);
	  PropertyConfigurator.configure("Log4j.properties");
	 }

	 @AfterMethod
	 public void AfterM(ITestResult result){
	  if (result.getStatus()==ITestResult.SUCCESS){
	   testInfo.log(Status.PASS, "The test method named as: " + result.getName() + " is Passed");
	  }
	  else if (result.getStatus()==ITestResult.FAILURE){
	   testInfo.log(Status.FAIL, "The test method named as: " + result.getName() + " is Failed");
	  }
	  else if (result.getStatus()==ITestResult.SKIP){
	   testInfo.log(Status.SKIP, "The test method named as: " + result.getName() + " is Skipped");
	  }
	 }
	@BeforeSuite
	public void beforeSuite() {
		Driver.Initialize();
		
	}

	@AfterSuite
	public void afterSuite() {
		 ExtentManager.GetExtent().flush();
		 
		 SendEmail.email();
		Driver.Instance.close();
		Driver.Instance.quit();
		// reports.flush();

	}
}
