package com.vtiger.genericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this class is used to fetch and write data into the excel sheet
 * @author sanu
 *
 */
public class ExcelUtility {
	/**
	 * this method fetches string data from excel sheet
	 * @param sheet
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getStringDataFromExcelSheet(String sheet,int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/OpportunityExcelData.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	return workbook.getSheet(sheet).getRow(rowNo).getCell(cellNo).toString();
	}
	/**
	 * this method fetches boolean data from excel sheet
	 * @param sheet
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public boolean getBooleanDataFromExcelSheet(String sheet,int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/OpportunityExcelData.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	return workbook.getSheet(sheet).getRow(rowNo).getCell(cellNo).getBooleanCellValue();
	}
	/**
	 * this method fetches numeric data from excel sheet
	 * @param sheet
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public double getNumericDataFromExcelSheet(String sheet,int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/OpportunityExcelData.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	return workbook.getSheet(sheet).getRow(rowNo).getCell(cellNo).getNumericCellValue();
	}
	/**
	 * this method write data into the excel sheet
	 * @param sheet
	 * @param rowNo
	 * @param cellNo
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeValueToExcelSheet(String sheet,int rowNo,int cellNo,String value) throws EncryptedDocumentException, IOException {
		String filePath="./src/test/resources/OpportunityExcelData.xlsx";
		FileInputStream fis=new FileInputStream(filePath);
		Workbook workbook = WorkbookFactory.create(fis);
		workbook.getSheet(sheet).getRow(rowNo).createCell(cellNo).setCellValue(value);
		FileOutputStream fos=new FileOutputStream(filePath);
		workbook.write(fos);
		workbook.close();
		
		 
	}
}
