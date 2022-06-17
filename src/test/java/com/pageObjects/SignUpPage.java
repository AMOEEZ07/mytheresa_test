package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.utilities.Driver;

public class SignUpPage {

	final WebDriver Instance;

	public SignUpPage(WebDriver Instance) {
		this.Instance = Driver.Instance;
	}
	@FindBy(how = How.ID, using = "navbarSignupBtn")
	public WebElement SignUp_tab;

	@FindBy(how = How.ID, using = "signupFirstname")
	public WebElement first_Name;

	@FindBy(how = How.ID, using = "signupLastname")
	public WebElement last_Name;

	@FindBy(how = How.ID, using = "signupEmail")
	public WebElement email_Address;

	@FindBy(how = How.ID, using = "signupCemail")
	public WebElement confirm_Email;

	@FindBy(how = How.ID, using = "signupPassword")
	public WebElement password;

	@FindBy(how = How.ID, using = "signupSubmit")
	public WebElement get_Started;
	
	@FindBy(how = How.ID, using = "mobileNavbar")
	public WebElement Menu_DropDown;
	
	@FindBy(how = How.ID, using = "adminNewbieNavDropdown")
	public WebElement User_Name;
	
	@FindBy(how = How.ID, using = "adminNewbieNavSignout")
	public WebElement Sign_Out;
	
}
