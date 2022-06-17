package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.utilities.Driver;

public class AdminLawyerListingObjects {

	final WebDriver Instance;
	public AdminLawyerListingObjects(WebDriver Instance)
	{
		this.Instance = Driver.Instance;
	}
	@FindBy(how=How.ID, using="navbarLawyersBtn")
	public WebElement lawyersTab;
	
	@FindBy(how=How.ID, using="LLSearch")
	public WebElement searchBox;
	
	@FindBy(how=How.CSS, using="#LLTable tr:nth-child(1) #LLLawyerEmail")
	public WebElement storingEmail_id;
	
	@FindBy(how=How.CSS, using="#LLTable tr:nth-child(1) > td:nth-child(4)")
	public WebElement storingFirstName;
	
	@FindBy(how=How.CSS, using="#LLTable tr:nth-child(1) > td:nth-child(5)")
	public WebElement storingLastName;
	
	@FindBy(how=How.CSS, using="#LLTable tr:nth-child(1) > td:nth-child(7)")
	public WebElement storingPhoneNum;
	
	@FindBy(how=How.CSS, using="#LLTable tr:nth-child(1) > td:nth-child(8)")
	public WebElement storingLawyerStatus;
	
	@FindBy(how=How.CSS, using="#LLTable tr:nth-child(1) > td:nth-child(18) > ul > li:nth-child(1)")
	public WebElement storingTargetPractice;
	
	@FindBy(how=How.CSS, using="#LLTable tr:nth-child(1) > td:nth-child(19) ")
	public WebElement storingCurrentLoc;
	
	@FindBy(how=How.CSS, using="#LLTable tr:nth-child(1) > td:nth-child(20) > ul > li:nth-child(1)")
	public WebElement storingTargetLoc;
	
	@FindBy(how=How.CSS, using="#LLTable tr:nth-child(1) > td:nth-child(22) > ul > li:nth-child(1)")
	public WebElement storingJurisdiction;
	
	@FindBy(how=How.ID, using="LLViewBtn")
	public WebElement viewBtn;
	
	@FindBy(how=How.CSS, using="li[heading=\"PREFERENCES\"] a")
	public WebElement prferenceTab;
	
	@FindBy(how=How.CSS, using="#tab-regCustom-link > a")
	public WebElement regularTab;
	
	@FindBy(how=How.CSS, using="#list-practice-areas li")
	public WebElement[] practiceAreaList_preferenceTab;
	
	@FindBy(how=How.CSS, using=".tab-content > div.tab-pane:nth-child(6) .list-practice-area:nth-child(3) > li")
	public WebElement[] practiceAreaList_regularTab;
	
	@FindBy(how=How.ID, using="tab-regCustom-job-row0")
	public WebElement firstJobregularTab;
	
	@FindBy(how=How.ID, using="tab-regCustom-job0-pqe")
	public WebElement pqeText_regularTab;
	
	@FindBy(how=How.ID, using="tab-specConnect-job0-expand")
	public WebElement exploreBtn_regularTab;
	
	@FindBy(how=How.CSS, using="button[id=\"tab-regCustom-job0-interested-btn\"]")
	public WebElement interestedBtn_regularTab;
	
	@FindBy(how=How.CSS, using="button[ng-click=\"applyToJob()\"]")
	public WebElement shareProfileBtn_regularTab;
	
	@FindBy(how=How.CSS, using="#tab-regCustom-job-row0 h3")
	public WebElement storingJobName;
	
	@FindBy(how=How.ID, using="tab-applications-row0")
	public WebElement storingJobNameVerify;
	
	@FindBy(how=How.CSS, using="#tab-applications-link >a")
	public WebElement applicationsTab;
	
					//////////////////SPEC/CONNECT TAB \\\\\\\\\\\\\\\\\\\\\
	@FindBy(how=How.CSS, using="#tab-specConnect-link >a")
	public WebElement connectTab;
	
	@FindBy(how=How.ID, using="tab-specConnect-job-row0")
	public WebElement firstJobConnectTab;
	
	@FindBy(how=How.ID, using="tab-specConnect-job0-pqe")
	public WebElement pqeText_connectTab;
	
	@FindBy(how=How.CSS, using="#tab-specConnect-job-row0 h3")
	public WebElement storingJobName_connectTab;
	
	@FindBy(how=How.CSS, using="button[id=\"tab-specConnect-job0-interested-btn\"]")
	public WebElement interestedBtn_connectTab;
	
	@FindBy(how=How.CSS, using="button[ng-click=\"applyToJob()\"]")
	public WebElement shareProfileBtn_connectTab;
	
	@FindBy(how=How.ID, using="tab-applications-row0")
	public WebElement storingJobNameVerify_applicationsTab;
	
	@FindBy(how=How.CSS, using="#adminAppliedJobs #AAJJob:nth-child(2) small/*text()")
	public WebElement storingLexstepJobDate;
	
	////////////////// DropDownVerifications_regularConnectTab \\\\\\\\\\\\\\\\\\\\\
	@FindBy(how=How.ID, using="tab-regCustom-filter-prac")
	public WebElement practiceAreaDropdown_regularTab;
	
	@FindBy(how=How.CSS, using=".dropdown.open > .dropdown-menu > div > label > span")
	public WebElement bankingFinance_regularTab;
	
	@FindBy(how=How.CSS, using=".dropdown.open > .dropdown-menu > div > ul > li:nth-child(1) span")
	public WebElement acquisitionLeveragedFinance_regularTab;
	
	@FindBy(how=How.ID, using="tab-regCustom-filter-loc")
	public WebElement targetLocationDropdown_regularTab;
	
	@FindBy(how=How.CSS, using=".dropdown.open > .dropdown-menu > div:nth-child(1) > label > span")
	public WebElement UK_regularTab;
	
	@FindBy(how=How.ID, using="tab-regCustom-filter-selectivity")
	public WebElement selectivityDropdown_regularTab;
	
	@FindBy(how=How.CSS, using="#tab-regCustom-filter-selectivity > option")
	public WebElement selectivityDropdownList_regularTab;
	
	@FindBy(how=How.CSS, using=".tab-content > div:nth-child(6) .custom-table-body:nth-child(1) > div[ng-if=\"noJobs\"]:nth-child(1) h3")
	public WebElement noJobsToShow_regularTab;
	
	@FindBy(how=How.CSS, using="#tab-regCustom-job-row0-expanded> div:nth-child(1)  h5.ng-binding:nth-child(3)")
	public WebElement storingSelectivityText_RegularTab;
	
	@FindBy(how=How.CSS, using="#tab-regCustom-job-row1")
	public WebElement secondJobregularTab;
	
	////////////////// DropDownVerifications_connectTab \\\\\\\\\\\\\\\\\\\\\
	@FindBy(how=How.ID, using="tab-specConnect-filter-prac")
	public WebElement practiceAreaDropdown_connectTab;
	
	@FindBy(how=How.CSS, using=".dropdown.open > .dropdown-menu > div > label > span")
	public WebElement bankingFinance_connectTab;
	
	@FindBy(how=How.CSS, using=".dropdown.open > .dropdown-menu > div > ul > li:nth-child(1) span")
	public WebElement acquisitionLeveragedFinance_connectTab;
	
	@FindBy(how=How.ID, using="tab-specConnect-job-row0")
	public WebElement firstJobconnectTab;
	
	@FindBy(how=How.ID, using="tab-specConnect-filter-loc")
	public WebElement targetLocationDropdown_connectTab;
	
	@FindBy(how=How.CSS, using=".dropdown.open > .dropdown-menu > div:nth-child(1) > label > span")
	public WebElement UK_connectTab;
	
	@FindBy(how=How.ID, using="tab-specConnect-filter-selectivity")
	public WebElement selectivityDropdown_connectTab;
	
	@FindBy(how=How.CSS, using="#tab-specConnect-job-row0-expanded> div:nth-child(1)  h5.ng-binding:nth-child(3)")
	public WebElement storingSelectivityText_connectTab;
	
	@FindBy(how=How.CSS, using="#tab-specConnect-job-row1")
	public WebElement secondJobConnectTab;
}