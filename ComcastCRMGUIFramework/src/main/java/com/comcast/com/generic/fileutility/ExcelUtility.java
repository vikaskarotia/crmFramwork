package com.comcast.com.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;


public class ExcelUtility {

    Sheet sh=null;
    Row   row=null;

	public String getData(String sheetName, int rownum, int column) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./configAppData/excelData.xlsx");
		sh=WorkbookFactory.create(fis).getSheet("work");
		row=sh.getRow(1);
		String data = row.getCell(0).getStringCellValue();
		return data;
		
	}
	

	public int getRowCount() {
		return sh.getLastRowNum();
		 }
	
}
