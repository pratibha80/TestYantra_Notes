package com.crm.SeleniumProject_Maven.GenericsLib;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



/**
 * 
 * @author Pratibha
 *
 */

public class ExcelFileUtility {
	/**
	 * this method will read the dat FROM Excel sheet
	 * @return 
	 * @throws Throwable 
	 */
        public String getExcelData(String sheetName, int rownum,int cellnum ) throws Throwable
        {
        	FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
        	
        	Workbook wb = WorkbookFactory.create(fis);
        	 Sheet sheet = wb.getSheet(sheetName);
        	 
        	 Row row = sheet.getRow(rownum);
        	 Cell cell = row.getCell(cellnum);
        	 String value = cell.getStringCellValue();
        	 return value;
        	 
        }
        
        /**
         * 
         */
        public Object[][] getExcelData(String sheetName ) throws Throwable
        {
        	FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
        	
        	Workbook wb = WorkbookFactory.create(fis);
        	 Sheet sheet = wb.getSheet(sheetName);
        	 
        	 int lastrow = sheet.getLastRowNum();
        	 short lastcell = sheet.getRow(0).getLastCellNum();
               
        Object [] [] data=new Object [lastrow] [lastcell];
        
        for (int i=0;i<lastrow;i++)
        {
        	for(int j=0;j<lastcell;j++)
        	{
        		data [i] [j]= sheet.getRow(i+1).getCell(j).getStringCellValue();
        	}
        }
        
        return data;
        
}
}