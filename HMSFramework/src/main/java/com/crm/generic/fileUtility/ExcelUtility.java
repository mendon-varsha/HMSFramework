package com.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelUtility {
	
public String readDataFromExcel(String sheet, int row, int cell) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream("./src/test/resources/testdata");
	Workbook workbook = WorkbookFactory.create(fis);
	String value = workbook.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
	return value;
}


public void writeDataToExcel(String sheet, int row, int cell,String data) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream("./src/test/resources/testdata");
	Workbook workbook = WorkbookFactory.create(fis);
	workbook.getSheet(sheet).getRow(row).createCell(cell).setCellValue(data);
	
	FileOutputStream fos=new FileOutputStream("./src/test/resources/testdata");
	workbook.write(fos);
	workbook.close();
}

public int getRowCount(String sheet) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream("./src/test/resources/testdata");
	Workbook workbook = WorkbookFactory.create(fis);
	int rowcount = workbook.getSheet(sheet).getLastRowNum();
	return rowcount;
	
}

public int getCellCount(String sheet,int row) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream("./src/test/resources/testdata");
	Workbook workbook = WorkbookFactory.create(fis);
	int cellcount = workbook.getSheet(sheet).getRow(row).getLastCellNum();
	return cellcount;
}
}
