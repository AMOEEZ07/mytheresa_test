package com.utilities;

import org.testng.annotations.BeforeSuite;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;



public class TestBase {

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
