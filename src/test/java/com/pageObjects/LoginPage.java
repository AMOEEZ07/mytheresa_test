package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.utilities.Driver;

public class LoginPage {
	final WebDriver Instance;
	public LoginPage(WebDriver Instance)
	{
		this.Instance = Driver.Instance;
	}
	
	@FindBy(how=How.ID, using="navbarLoginBtn")
	public WebElement Login_tab;
	
	@FindBy(how=How.ID, using="signInEmail")
	public WebElement email_address;
	
	
	
	@FindBy(how=How.CSS, using="input[placeholder=\"Email\"]")
	public WebElement email_addressd1;
	
	
	@FindBy(how=How.CSS, using="input[placeholder=\"Password\"]")
	public WebElement passwordd1;
	
	
			@FindBy(how=How.CSS, using="button[class=\"btn btn-info btn-lg btn-block ng-binding\"]")
	public WebElement logind1;
	
	@FindBy(how=How.ID, using="signInPassword")
	public WebElement password;
	
	@FindBy(how=How.ID, using="signInSubmit")
	public WebElement loginBtn;
	
	@FindBy(how=How.ID, using="navbarLoginBtn")
	public WebElement Login_bar;
	
	@FindBy(how=How.ID, using="navbarLawyersBtn")
	public WebElement Lawyer_Tab;
	
	@FindBy(how=How.ID, using="adminNewbieNavDropdown")
	public WebElement storingAdminName;
	
	@FindBy(how=How.ID, using="lawyerNavDropdown")
	public WebElement storingLawyerName;

}
