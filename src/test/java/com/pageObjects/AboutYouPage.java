package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.utilities.Driver;

public class AboutYouPage {
	final WebDriver Instance;
	public AboutYouPage(WebDriver Instance)
	{
		this.Instance = Driver.Instance;
	}
	
	@FindBy(how=How.ID, using="newProfileCurrentEmp")
	public WebElement CurrentEmpField;
	
	@FindBy(how=How.CSS, using="#newProfileUniversityDiv #newProfileUniName")
	public WebElement EmpUniversityField;
	
	
	@FindBy(how=How.ID, using="newProfileNationality")
	public WebElement EmpNationality;
	
	@FindBy(how=How.ID, using="newProfileCurrentLoc")
	public WebElement EmpCurrentLocation;
	
	@FindBy(how=How.ID, using="newProfileContactNumber")
	public WebElement EmpPhoneNum;
	
	@FindBy(how=How.ID, using="datepicker")
	public WebElement DatePicker;
	
	
	@FindBy(how=How.CSS, using="#newProfileJurisdiction > li:nth-child(5) > label")
	public WebElement Jurisdictions;
	
	@FindBy(how=How.CSS, using="#newProfilePracticeAreas:nth-child(1) span.checkbox-group-heading")
	public WebElement practiceAreaExpertise;
	
	@FindBy(how=How.CSS, using="#newProfileLocations:nth-child(1) span.checkbox-group-heading")
	public WebElement targetLocation;
	
	@FindBy(how=How.CSS, using="#newProfileLocations:nth-child(8) > span:nth-child(1) > i")
	public WebElement targetLocationExpandBtn;
	
	@FindBy(how=How.CSS, using="#newProfileLocations:nth-child(8) #targetLocationsUl > li:nth-child(2) span")
	public WebElement targetLocation1;
	
	@FindBy(how=How.CSS, using="#newProfileJurisdictionList > li:nth-child(1)")
	public WebElement storingJurisdiction;
	
	@FindBy(how=How.CSS, using="#newProfilePracticeAreasList > li:nth-child(1)")
	public WebElement storingPracticeArea;
	
	@FindBy(how=How.CSS, using="#newProfileLocationsList li:nth-child(1)")
	public WebElement storingTargetLoc;
	
	@FindBy(how=How.ID, using="newProfileSRAID")
	public WebElement sraID;
	
	@FindBy(how=How.ID, using="newProfileRequestAccess")
	public WebElement requestAccessBtn;
	
	@FindBy(how=How.ID, using="newProfileRequestAccessMessage")
	public WebElement accessRequestedSuccessMsg;
	
	@FindBy(how=How.ID, using="newProfileSelectPracticeAreas")
	public WebElement SelectPractice;
	
	
	@FindBy(how=How.ID, using="newProfileSelectLocations")
	public WebElement SelectLocation;
	
	@FindBy(how=How.ID, using="select-jurisdiction")
	public WebElement Jurisdiction_Btn ;
	
	
	@FindBy(how=How.ID, using="newProfileModalNext")
	public WebElement NextBtn ;
	
	
	@FindBy(how=How.ID, using="practiceAreasUl")
	public WebElement PracticeArea ;
	
	@FindBy(how=How.ID, using="targetLocationsUl")
	public WebElement Target_Loction ;
	
	@FindBy(how=How.ID, using="profile_chosecv")
	public WebElement newProfileUploadCV ;
	
	@FindBy(how=How.ID, using="newProfileRequestAccess")
	public WebElement RequestAccess_BTn ;
	
	@FindBy(how=How.CSS, using="div.ui-datepicker > ul:nth-child(2) span.btn-group > button:nth-child(1)")
	public WebElement SelectMonth ;
	
	@FindBy(how=How.CSS, using="#newProfileUniversityDiv ul.dropdown-menu:nth-child(2) > li > a")
	public WebElement University_List ;
	
	@FindBy(how=How.CSS, using="#newProfileNationalityDiv ul.dropdown-menu:nth-child(2) > li > a")
	public WebElement nationality_list ;

	@FindBy(how=How.CSS, using="#newProfileCurrentLocationDiv ul.dropdown-menu:nth-child(2) > li > a")
	public WebElement currentLoc_list ;
	
}