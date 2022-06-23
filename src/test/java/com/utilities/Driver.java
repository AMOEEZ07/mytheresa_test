package com.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Driver {
public static WebDriver Instance = null;
public static PropertiesInitializer properties = null; 
	
	
	public static void Initialize()
	{
		/******************************/
		File file = new File ("Config\\Confriguration.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*******************************/
		if (properties == null)
		{
			properties = new PropertiesInitializer();
			String testUrl = System.getProperty("TestURL");
			properties.setTestUrl(testUrl == null? prop.getProperty("TestURL"): testUrl);
			properties.setBrowser(prop.getProperty("Browser"));
			
		}
		/*******************************/
		if (Instance == null)
		{
			
			System.out.println("Initializing Driver");
			/*if (Configuration.Browser.browser.equalsIgnoreCase("ff"))
				Instance = new FirefoxDriver();
			
			else if (Configuration.Browser.browser.equalsIgnoreCase("ie"))
			{
				System.setProperty("webdriver.ie.driver", "Resources\\IEDriverServer.exe");
				Instance = new InternetExplorerDriver();	
			}
			else if (Configuration.Browser.browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
				Instance = new ChromeDriver();
			}*/
			if (properties.getBrowser().contentEquals("ff"))
			Instance = new FirefoxDriver();
		
		else if (properties.getBrowser().contentEquals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "Resources\\IEDriverServer.exe");
			Instance = new InternetExplorerDriver();	
		}
		else if (properties.getBrowser().contentEquals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
			Instance = new ChromeDriver();
		}
		}
		
		Instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Instance.manage().window().maximize();
	}
	
	public static void close()
	{
		System.out.println("Closing browser");
		Instance.close();
		Instance = null;
		properties = null;
	}
}
