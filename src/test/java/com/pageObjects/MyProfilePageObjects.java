package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.utilities.Driver;

public class MyProfilePageObjects {
	final WebDriver Instance;
	public MyProfilePageObjects(WebDriver Instance)
	{
		this.Instance = Driver.Instance;
	}
	
	@FindBy(how=How.ID, using="PAUniversity")
	public WebElement storingLawyerUni;
	
	@FindBy(how=How.ID, using="PANationality")
	public WebElement storingLawyerNationality;
	
	@FindBy(how=How.ID, using="PALocations")
	public WebElement storingLawyerCurrentLocation;
	
	@FindBy(how=How.ID, using="PAQualifiedIn")
	public WebElement storingqualificationYear;
	
	@FindBy(how=How.ID, using="navBarMyProfileBtn")
	public WebElement myProfileTab;
	
	@FindBy(how=How.ID, using="PAUniversity")
	public WebElement lawyerUniversity;
	
	@FindBy(how=How.ID, using="law-firm")
	public WebElement profileSectionEditBtn;
	
	@FindBy(how=How.ID, using="PAUniEdit")
	public WebElement underGraduateUni_clear;
	
	@FindBy(how=How.ID, using="PANationalityEdit")
	public WebElement nationality_clear;
	
	@FindBy(how=How.ID, using="PACurLocEdit")
	public WebElement currentLocation_clear;
	
	@FindBy(how=How.CSS, using=".ui-datepicker #datepicker")
	public WebElement qualifiedIn_datePicker;
	
	@FindBy(how=How.XPATH, using="//button[text()='Clear']")
	public WebElement qualifiedIn_datePickerClear;
	
	@FindBy(how=How.ID, using="PAProfileEditSave")
	public WebElement saveBtn;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Today']")
	public WebElement todayBtn;
	
	@FindBy(how=How.ID, using="edit-phone")
	public WebElement contactInfoEditBtn;
	
	@FindBy(how=How.ID, using="PAEditPhone")
	public WebElement contactInfo_clear;
	
	@FindBy(how=How.ID, using="editPhoneSave")
	public WebElement contactInfoSavBtn;
	
	@FindBy(how=How.ID, using="PALawyerPhone")
	public WebElement storingContactInfo;
	
	@FindBy(how=How.CSS, using="button[id=\"edit-languages\"]")
	public WebElement languagesEditBtn;
	
	@FindBy(how=How.CSS, using=".lang-modal ul.pref-language-list > li:nth-child(2) span")
	public WebElement frenchLanguage;
	
	@FindBy(how = How.CSS, using = "#LPSaveBtn")
	public WebElement saveLanguageBtn;
	
	@FindBy(how=How.CSS, using="#PALangList > li:nth-child(1)")
	public WebElement storingLanguageText;
	
	@FindBy(how=How.ID, using="edit-jurisdictions")
	public WebElement jurisdictionEditPencilBtn;
	
	@FindBy(how=How.CSS, using="#LPJurisdictionList > li:nth-child(2) span")
	public WebElement checkboxClickJurisdiction;
	
	@FindBy(how=How.ID, using="LPSaveBtn")
	public WebElement jurisdictionSaveBtn;
	
	@FindBy(how=How.CSS, using="#PAJurisdictionList li:nth-child(1)")
	public WebElement storingJurisdictionText;
	
	@FindBy(how=How.ID, using="PADeleteCV")
	public WebElement cvDeleteBtn;
	
	@FindBy(how=How.CSS, using="#add-employment:nth-child(1)")
	public WebElement addBtnEmpHistory;
	
	@FindBy(how=How.ID, using="EFEmpName")
	public WebElement employerName;
	
	@FindBy(how=How.CSS, using="ul[class=\"dropdown-menu ng-isolate-scope\"]")
	public WebElement employerNameDropdownList;
			
			
	@FindBy(how=How.ID, using="EFJobTitle")
	public WebElement jobTitle;
	
	@FindBy(how=How.ID, using="EFDatePickerFrom")
	public WebElement datePickerFrom;
	
	@FindBy(how=How.ID, using="EFDatePickerTo")
	public WebElement datePickerTo;
	
	@FindBy(how=How.CSS, using="div[class=\"row\"] div[class=\"col-md-6\"]:nth-child(1) button[class=\"btn btn-default btn-sm pull-left\"]")
	public WebElement datePickerCalendar_leftBtn;
	
	@FindBy(how=How.ID, using="select-locations")
	public WebElement empHistoryLocationBtn;
	
	@FindBy(how=How.ID, using="select-practice-areas")
	public WebElement empHistoryPracticeAreaBtn;
	
	@FindBy(how=How.CSS, using="#EFLocationList:nth-child(1) > ul > li:nth-child(1) > label > span")
	public WebElement empHistoryLocation;
	
	@FindBy(how=How.CSS, using="#EFLocListSave")
	public WebElement empHistoryLocationSaveBtn;
	
	@FindBy(how=How.CSS, using="div[name=\"jobTo\"] table[aria-labelledby^=datepicker] tbody tr:first-of-type td:first-of-type span")
	public WebElement endDatePicker;
	
	@FindBy(how=How.CSS, using="div[name=\"jobFrom\"] table[aria-labelledby^=datepicker] tbody tr:first-of-type td:first-of-type span")
	public WebElement startDatePicker;
	
	@FindBy(how=How.CSS, using="#EFPracticeAreasList:nth-child(3) > label > span")
	public WebElement empHistorypracticeAreaList;
	
	@FindBy(how=How.CSS, using="#empHistorySection div:nth-child(1) #EHJobTitle:nth-child(1)")
	public WebElement storingJobRoleEmpHistory;
	
	@FindBy(how=How.CSS, using="#empHistorySection > div:nth-child(2) > div #EHLocationList > li:nth-child(1)")
	public WebElement storingTargetLocEmpHistory;
	
	@FindBy(how=How.CSS, using="#empHistorySection > div:nth-child(2) > div #EHPracticeAreasList > li:nth-child(1)")
	public WebElement storingPracticeAreaEmpHistory;
	
	@FindBy(how=How.CSS, using="#empHistorySection > div:nth-child(2) a #edit-empHistory")
	public WebElement editPencilEmpHistory;
	
	@FindBy(how=How.CSS, using="#empHistorySection > div:nth-child(2) #delete-empHistory")
	public WebElement deleteBtnEmpHistory;
	
	
			//****************************************PREFERENCES TAB****************************************\\
	@FindBy(how=How.ID, using="PAPrefrences")
	public WebElement preferencesTab;
	
	@FindBy(how=How.CSS, using=".tab-content > div:nth-child(2) button[id=\"edit-practice\"]")
	public WebElement practiceAreaExpertiseEdit_btn;
	
	@FindBy(how=How.CSS, using="#LPPracticeAreasList:nth-child(3) > label > span")
	public WebElement practiceAreaList_charities;
	
	@FindBy(how=How.CSS, using="button[ng-click=\"save()\"]")
	public WebElement practiceExpertiseSavBtn;
	
	@FindBy(how=How.CSS, using="button[class=\"btn btn-info\"]")
	public WebElement empHistorySavBtn;
	
	@FindBy(how=How.CSS, using="#PAPracticeAreasList > li:nth-child(15)")
	public WebElement storingPracticeExpertiseText;
	
	@FindBy(how=How.CSS, using=".tab-content > div:nth-child(2) button[id=\"edit-location\"]")
	public WebElement targetLocEditBtn;
	
	@FindBy(how=How.CSS, using="#LPLocationsList:nth-child(8) #LPLocExpand")
	public WebElement targetLocExpanBtn;
	
	@FindBy(how=How.CSS, using="#LPLocationsList:nth-child(8) > ul > li:nth-child(1) > label > span")
	public WebElement targetLocCheckboxSelection;
	
	@FindBy(how=How.CSS, using="#PALocationsList li:nth-child(2)")
	public WebElement storingLocText;
	
	@FindBy(how=How.ID, using="navBarPrivatePracticeJobsBtn")
	public WebElement privatePracticeJobsTab;
	
	@FindBy(how = How.CSS, using = "#PPJobsLocDropDown > div")
	public WebElement targetLocationList;
	
	@FindBy(how = How.CSS, using = "#IHLocationsFilter > div")
	public WebElement targetLocationList_inHouseTab;
	
	@FindBy(how = How.CSS, using = "#PPJobsPADropDown > div")
	public WebElement practiceAreaList;
	
	@FindBy(how = How.CSS, using = "#IHPracticeAreasFilter  > div")
	public WebElement practiceAreaList_inHouseTab;
	
	@FindBy(how = How.CSS, using = "#PPJobsLocDropDown > div > div > ul > li > ul")
	public WebElement targetLocationlistGroup;
	
	@FindBy(how = How.CSS, using = "#IHLocationsFilter > div > div > ul > li > ul")
	public WebElement targetLocationlistGroup_inHouseTab;
	
	@FindBy(how = How.CSS, using = "#PPJobsPADropDown > div > div > ul > li > ul")
	public WebElement practiceArealistGroup;
	
	@FindBy(how = How.CSS, using = "#PPJobsPADropDown div.list > ul > li > a")
	public WebElement practiceAreaDefaultlist;
	
	@FindBy(how = How.CSS, using = "#IHPracticeAreasFilter div.list > ul > li > a")
	public WebElement practiceAreaDefaultlist_inHouseTab;

	@FindBy(how = How.CSS, using = "#PPJobsLocDropDown > div > div > ul > li > a")
	public WebElement targetLocationDefaultlist;
	
	@FindBy(how = How.CSS, using = "#IHLocationsFilter > div > div > ul > li > a")
	public WebElement targetLocationDefaultlist_inHouseTab;
	
	@FindBy(how=How.ID, using="navBarInhouseBtn")
	public WebElement inHouseJobsTab;
}