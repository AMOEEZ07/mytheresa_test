package com.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;

import com.utilities.Driver;
import com.utilities.TestBase;

public class GenericWait {

	static WebDriverWait wait = new WebDriverWait(Driver.Instance, 60);
	static JavascriptExecutor jsExec = (JavascriptExecutor) Driver.Instance;

	public void WaitForElementToBeClickAble(WebElement element) {
		WebElement Newelement = wait.until(ExpectedConditions.elementToBeClickable(element));
		Newelement.click();
	}

	/******************* Wait until Ajax call is completed ****************/
	public static void WaitForElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/************************** Wait for JQuery Load ******************************/
	public static void WaitForJQueryLoad() {
		// Wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) Driver.Instance)
				.executeScript("return jQuery.active") == 0);

		// Get JQuery is Ready
		boolean jqueryReady = (Boolean) jsExec.executeScript("return jQuery.active==0");

		// Wait JQuery until it is Ready!
		if (!jqueryReady) {
			System.out.println("Waiting for JQuery to Load");
			// Wait for jQuery to load
			wait.until(jQueryLoad);
		} else {
			System.out.println("JQuery is already loaded!");
		}
	}

	public void WaitForElementToExiste() {
		WebElement Newelement = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#runStatus span")));
	}

	public boolean skipScenarioElementExistence() {
		try {
			Driver.Instance.findElement(By.cssSelector(".ui-dialog-titlebar button"));
			System.out.println("catch me not");
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("catch me");
			return false;
		}finally {
			return false;
		}  
	}

	/****************** Wait until JS Load *******************************/
	// Wait Until JS Ready
	public static void WaitUntilJSReady() {
		// Wait for Javascript to load
		ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) Driver.Instance)
				.executeScript("return document.readyState").toString().equals("complete");

		// Get JS is Ready
		boolean jsReady = (Boolean) jsExec.executeScript("return document.readyState").toString().equals("complete");

		// Wait Javascript until it is Ready!
		if (!jsReady) {
			System.out.println("JS in NOT Ready!");
			// Wait for Javascript to load
			wait.until(jsLoad);
		} else {
			System.out.println("JS is Ready!");
		}
	}
	
	public static boolean existsElement(String selector) {
	    try {
	    	 Driver.Instance.findElement(By.cssSelector(selector));
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	    return true;
	} 
}
