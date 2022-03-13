package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IllegalFormatException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.openssl.EncryptionException;


public class exceldata {
	static Workbook book;
	static Sheet sheet;
	public static String testdtasheetpath="C://Users/User/git/repository/loginagile/testdata/Book1.xlsx";
		
	public Object[][] getdata(String sheetname) throws IOException, EncryptionException, org.apache.poi.openxml4j.exceptions.InvalidFormatException  {
	
		FileInputStream file=null;
		try {
			
		file= new FileInputStream(testdtasheetpath);
		
		}catch(FileNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
		
		try {
			book=org.apache.poi.ss.usermodel.WorkbookFactory.create(file);
			
			
		}
		catch(IllegalFormatException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();	
		}
		
		
		sheet = book.getSheet(sheetname);
		Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
			
		}
		return data;
		}
}
		
		/*
		{ String data="";
		try {
			
			FileInputStream fin= new FileInputStream(xlfilepath);
			Workbook wb=	(Workbook) WorkbookFactory.create(fin);
			Sheet sht= wb.getSheet(sheetname);
			data= sht.getRow(rownum).getCell(cellnum).toString();
			
		} catch (Exception e) { e.printStackTrace();
		}
		return data;
		
			}}
			
			*/
		
		
		
	
		
	
		
	/*FileInputStream xlpath=new FileInputStream(new File("C://Users/User/git/repository/loginagile/testdata/agilelogin.xlsx"));
		//FileInputStream fin= new FileInputStream(xlpath);
		
		XSSFWorkbook wb=new XSSFWorkbook(xlpath);
		XSSFSheet sheet1=wb.getSheetAt(0);
		String str=sheet1.getRow(0).getCell(0).getStringCellValue();
		System.out.println("fetch from the excel:-"+str);
		String str1=sheet1.getRow(1).getCell(0).getStringCellValue();
		System.out.println("fetch from the excel:-"+str1);
		*/
				
/*File file = new File(xlpath);
FileInputStream fin = new FileInputStream(xlpath);
XSSFWorkbook wb= new XSSFWorkbook(fin);
XSSFSheet sht= wb.getSheet(sheetname);
//data=((org.apache.poi.ss.usermodel.Sheet) sht).getRow(rownum).getCell(cellnum).toString();
return
sht.getRow(rownum).getCell(cellnum).getStringCellValue().toString()	;*/

		

		
	
	
	
	
	
	
