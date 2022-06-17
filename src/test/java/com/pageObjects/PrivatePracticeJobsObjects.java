package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.utilities.Driver;

public class PrivatePracticeJobsObjects {

	final WebDriver Instance;

	public PrivatePracticeJobsObjects(WebDriver Instance) {
		this.Instance = Driver.Instance;
	}
	@FindBy(how = How.CSS, using = "#privatePracticeJobsTableBody > div:nth-child(1) #privatePracticeJobExporeRole")
	public WebElement exploreRolesBtn;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Cancel']")
	public WebElement cancelBtn;

	@FindBy(how = How.CSS, using = "#privatePracticeJobsFirmJobs > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) #privatePracticeJobsInterested")
	public WebElement interestedJobBtn;
	
	@FindBy(how = How.CSS, using = "#privatePracticeJobsFirmJobs > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > button")
	public WebElement interestedJobBtnAfterApply;
	
	@FindBy(how = How.CSS, using = "#privatePracticeJobsShareProfile")
	public WebElement shareProfileBtn;
	
	@FindBy(how = How.CSS, using = "#privatePracticeJobsTableBody > div:nth-child(1) h2")
	public WebElement firstFirmName;
	
	@FindBy(how = How.ID, using = "navBarTrackBtn")
	public WebElement trackTab;
	
	@FindBy(how = How.ID, using = "trackPageFirmName")
	public WebElement firmNameTrackTab;
	
	@FindBy(how = How.CSS, using = "#PPJobsPADropDown > div")
	public WebElement practiceAreaList;
	@FindBy(how = How.CSS, using = "#PPJobsPADropDown > div > div > ul > li > ul")
	public WebElement practiceArealistGroup;
	
	@FindBy(how = How.CSS, using = "#PPJobsLocDropDown > div")
	public WebElement targetLocationList;
	
	@FindBy(how = How.CSS, using = "#PPJobsLocDropDown > div > div > ul > li > ul")
	public WebElement targetLocationlistGroup;
	
	@FindBy(how = How.ID, using = "PPPQE")
	public WebElement storingPQE;
	
	@FindBy(how = How.CSS, using = "#PPPQEFilter > span div.jslider-pointer:nth-child(2)")
	public WebElement leftPointer;
	
	@FindBy(how = How.CSS, using = "#PPPQEFilter > span div.jslider-pointer:nth-child(3)")
	public WebElement rightPointer;
	
	@FindBy(how = How.ID, using = "navBarPrivatePracticeJobsBtn")
	public WebElement privatePracticeJobsTab;
	
	@FindBy(how = How.ID, using = "PPPQE")
	public WebElement pqeText;
	
	@FindBy(how = How.CSS, using = "#PPFirm:nth-child(1) #PPFirmName h2")
	public WebElement firmName;
	
	@FindBy(how = How.CSS, using = "#privatePracticeJobsFirmJobs > div:nth-child(1) #PPLocTagName h5:nth-child(1)")
	public WebElement storingTagName;
	
	@FindBy(how = How.CSS, using = "#privatePracticeJobsTableBody #PPFirm:nth-child(2) #PPFirmName h2")
	public WebElement secondFirmName;
	
	@FindBy(how = How.CSS, using = "#privatePracticeJobsTableBody #PPFirm:nth-child(3) #PPFirmName h2")
	public WebElement thirdFirmName;
	
	@FindBy(how = How.CSS, using = "#trackPageJobsList div:first-of-type #trackPageJobTitle:nth-child(1)")
	public WebElement storingJobNameVerify;
	
	@FindBy(how = How.CSS, using = "#privatePracticeJobsFirmJobs > div:nth-child(1) #PPJobTitle")
	public WebElement storingJobName;
}