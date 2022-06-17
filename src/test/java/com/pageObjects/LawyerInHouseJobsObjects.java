package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.utilities.Driver;

public class LawyerInHouseJobsObjects {

	final WebDriver Instance;
	public LawyerInHouseJobsObjects(WebDriver Instance)
	{
		this.Instance = Driver.Instance;
	}
	
	@FindBy(how=How.ID, using="navBarInhouseBtn")
	public WebElement inHouseJobsTab;
	
	@FindBy(how=How.ID, using="PPOpportunities")
	public WebElement explorePrivatePracticeBtn;
	
	@FindBy(how = How.ID, using = "navBarPrivatePracticeJobsBtn")
	public WebElement privatePracticeJobsTab;
	
	@FindBy(how=How.CSS, using="#browse-jobs .heading-jobs-listings button")
	public WebElement exploreInHouseOppBtn;
	
	@FindBy(how = How.CSS, using = "#IHJobs div:nth-child(1) > div:nth-child(3) #IHExploreRole")
	public WebElement exploreRolesBtn;
	
	@FindBy(how = How.ID, using = "IHInterested")
	public WebElement jobInterestedBtn;
	
	@FindBy(how = How.CSS, using = "#IHJobs .inhouse-action button:nth-child(1)")
	public WebElement jobInterestedBtnAfterApply;
	
	@FindBy(how = How.ID, using = "IHShareProfile")
	public WebElement shareProfileBtn;
	
	@FindBy(how = How.CSS, using = "#IHJobs .inhouse-action .pull-right > button")
	public WebElement saveJobBtn;
	
	@FindBy(how = How.ID, using = "IHSavedJobsCount")
	public WebElement savedJobCount;
	
	@FindBy(how = How.ID, using = "navBarTrackBtn")
	public WebElement trackTab;
	
	@FindBy(how = How.CSS, using = "#IHJobs div:nth-child(1) > div > div > div:nth-child(2)  #IHJobTitle")
	public WebElement storingJobName;

	@FindBy(how = How.CSS, using = "#trackPageJobsList div:first-of-type #trackPageJobTitle:nth-child(1)")
	public WebElement storingJobNameVerify;
	
	@FindBy(how = How.ID, using = "IHSaveJobToggle")
	public WebElement toggleBtn;
	
	@FindBy(how = How.CSS, using = "#IHJobs .inhouse-action .pull-right > button")
	public WebElement unSaveJobBtn;
	
	@FindBy(how = How.ID, using = "IHEmptySJMessage")
	public WebElement saveJobHistoryDesc;
	
	@FindBy(how = How.CSS, using = "#IHLocationsFilter > div")
	public WebElement targetLocationList;
	
	@FindBy(how = How.CSS, using = "#IHLocationsFilter > div > div > ul > li > ul")
	public WebElement targetLocationlistGroup;
	
	@FindBy(how = How.CSS, using = "#IHJobs div:nth-child(1) div:nth-child(2) > div > #IHLocTag:nth-child(1)")
	public WebElement storingTagName;

	@FindBy(how = How.CSS, using = "#IHJobs div:nth-child(1) div:nth-child(2) #IHJobPQE")
	public WebElement pqeText;
	
	
}