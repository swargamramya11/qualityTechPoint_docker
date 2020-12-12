package com.qualitypointtech.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.qualitypointtech.baseclasses.Logs;

public class ExcelWrite {
	static WebDriver driver;
	static Logs log=new Logs(driver);
	static File f=new File("testdata/qualitypointtech.xlsx");
//method to read data from excel
public static void write(int columnIndex,String name)
	{
		try {
			FileInputStream fis = new FileInputStream(f);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sh=wb.getSheet("Sheet1");
			XSSFRow Row = sh.getRow(1);
			
			XSSFCell cell=Row.createCell(columnIndex);
			cell.setCellValue(name);
			FileOutputStream fo=new FileOutputStream(f);
			wb.write(fo);
			}
			catch(FileNotFoundException e) 
			{
				System.out.println("FileNotFound exception occured");
				log.update("FileNotFound exception occured");
			}
			catch(IOException e)
			{
				System.out.println("IO exception occured");
				log.update("IO exception occured");
			}
	}
}
