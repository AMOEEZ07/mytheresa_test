package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.utilities.Driver;

public class LogoutPageObjects {

	final WebDriver Instance;

	public LogoutPageObjects(WebDriver Instance) {
		this.Instance = Driver.Instance;
	}
	@FindBy(how = How.ID, using = "adminNewbieNavDropdown")
	public WebElement admin_logOutDropDown;
	
	@FindBy(how = How.ID, using = "adminNewbieNavSignout")
	public WebElement admin_logOutDropDownBtn;
	
	@FindBy(how = How.ID, using = "lawyerNavDropdown")
	public WebElement lawyer_logOutDropDown;
	
	@FindBy(how = How.ID, using = "lawyerNavSignout")
	public WebElement lawyer_logOutDropDownBtn;
	
	
}