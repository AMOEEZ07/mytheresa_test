package com.testCaseUtilities;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dataReader.Excel_DataReader;
import com.utilities.Driver;

public class SearchGrid {
	Excel_DataReader excelReader = new Excel_DataReader();

	public List<WebElement> searching(int sheetnum, String cellname, String gridname, String tablename, String filepath)
			throws Exception {
		
		Map<String, String> rowMap1 = excelReader.getRowDataMap("testdata\\" + filepath + ".xlsx", sheetnum, 1);
		
		Driver.Instance.findElement(By.id(gridname)).clear();
		
		Driver.Instance.findElement(By.id(gridname)).sendKeys(rowMap1.get(cellname));
		
		WebElement table_element = Driver.Instance.findElement(By.id(tablename));
		
		Thread.sleep(14000);
		
		List<WebElement> tr_collection = table_element.findElements(By.xpath("id('" + tablename + "')/tbody/tr"));
		
		WebElement trElement = tr_collection.get(0);
		
		List<WebElement> td_collection1 = trElement.findElements(By.xpath("td"));
		
		WebElement tdEle = td_collection1.get(0);
		
		Thread.sleep(2000);
		
		tdEle.click();
		Thread.sleep(2000);
		
		return (List<WebElement>) td_collection1;

	}
}
