package com.utilities;

import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;



public class TestBase {
//	ExtentTest testInfo;
//	 ExtentHtmlReporter htmlReporter;

//	 @BeforeMethod
//	 public void BeforeM(Method method){
//	
//	  PropertyConfigurator.configure("Log4j.properties");
//	 }
//	 @BeforeMethod
//	 public void BeforeM(Method method){
//	String testName=method.getName();
//	//  testInfo=ExtentManager.GetExtent().createTest(testName);
//	 // PropertyConfigurator.configure("Log4j.properties");
//	 }

	@BeforeSuite
	public void beforeSuite() {
		Driver.Initialize();
		
	}

	@AfterMethod
	 public void AfterM(ITestResult result){
	  if (result.getStatus()==ITestResult.SUCCESS){
	  System.out.println("The test method named as: " + result.getName() + " is Passed");
	  }
	  else if (result.getStatus()==ITestResult.FAILURE){
		  System.out.println( "The test method named as: " + result.getName() + " is Failed");
	  }
	  else if (result.getStatus()==ITestResult.SKIP){
		  System.out.println( "The test method named as: " + result.getName() + " is Skipped");
	  }
	 }
	
	
	@AfterSuite
	public void afterSuite() {
		
		Driver.Instance.close();
		Driver.Instance.quit();


	}
}
