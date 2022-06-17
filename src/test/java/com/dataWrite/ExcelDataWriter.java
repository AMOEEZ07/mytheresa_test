package com.dataWrite;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataWriter {

	public void setCellValue(String value) {
		String filepath = "F:\\lexstep-automation-project\\LexStep_Automation\\testdata\\SignUp.xlsx";
		FileInputStream fis = null;
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			Row r = sheet.getRow(0); // 10-1
			if (r == null) {
				// First cell in the row, create
				r = sheet.createRow(0);
			}

			Cell c = r.getCell(3); // 4-1
			if (c == null) {
				// New cell
				c = r.createCell(3, Cell.CELL_TYPE_STRING);
			}
			c.setCellValue(value);
			FileOutputStream fos = new FileOutputStream(filepath);
			workbook.write(fos);
			fos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void modifyExistingWorkbook(String value) throws IOException {
		FileInputStream fsIP= new FileInputStream(new File("F:\\lexstep-automation-project\\LexStep_Automation\\testdata\\SignUp.xlsx")); //Read the spreadsheet that needs to be updated
        
        XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
          
        XSSFSheet worksheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it.
          
        Cell cell = null; // declare a Cell object
        
        cell = worksheet.getRow(1).getCell(3);   // Access the second cell in second row to update the value
          
        cell.setCellValue(value);  // Get current cell value value and overwrite the value
          
        fsIP.close(); //Close the InputStream
         
        FileOutputStream output_file =new FileOutputStream(new File("F:\\lexstep-automation-project\\LexStep_Automation\\testdata\\SignUp.xlsx"));  //Open FileOutputStream to write updates
          
        wb.write(output_file); //write changes
          
        output_file.close();  //close the stream
	}

}