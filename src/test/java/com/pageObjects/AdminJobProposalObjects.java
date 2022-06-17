package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.utilities.Driver;

public class AdminJobProposalObjects {

	final WebDriver Instance;
	public AdminJobProposalObjects(WebDriver Instance)
	{
		this.Instance = Driver.Instance;
	}
	@FindBy(how=How.ID, using="navbarLawyersBtn")
	public WebElement lawyersTab;
	
	@FindBy(how=How.ID, using="LLSearch")
	public WebElement searchBox;
	
	@FindBy(how=How.ID, using="LLViewBtn")
	public WebElement viewBtn;
	
	@FindBy(how=How.ID, using="tab-applications-link")
	public WebElement applicationTab;
	
	@FindBy(how=How.CSS, using="#adminAppliedJobs:first-of-type #AAJJob:nth-child(2) div:nth-child(2) h4")
	public WebElement jobTitle;
	
	@FindBy(how=How.CSS, using="#adminAppliedJobs #AAJJob:nth-child(2) small/*text()")
	public WebElement storingLexstepJobDate;
	
	@FindBy(how=How.CSS, using="#LLTable tr:nth-child(1) #LLActionsBtn")
	public WebElement actionsDropDown;
	
	@FindBy(how=How.CSS, using=".modal-body:nth-child(2) div.row:nth-child(9) span.panel-default select")
	public WebElement lawyerStatus;
	
	@FindBy(how=How.CSS, using="#LLTable tr:nth-child(1) #LLLawyerEmail")
	public WebElement storingEmail_id;
	
	@FindBy(how=How.CSS, using="#LLTable tr:nth-child(1) #LLLawyerStatus")
	public WebElement storingLawyerStatus;
	
	@FindBy(how = How.ID, using = "LLActionsSave")
	public WebElement saveBtn;
}