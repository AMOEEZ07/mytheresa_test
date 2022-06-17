package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.utilities.Driver;

public class LawyersPage {

	final WebDriver Instance;
	public LawyersPage(WebDriver Instance)
	{
		this.Instance = Driver.Instance;
	}
	
	@FindBy(how=How.ID, using="LLSearch")
	public WebElement SearchBox;
	
	@FindBy(how=How.ID, using="LLTable")
	public WebElement LawyersTable;
	

}
	

