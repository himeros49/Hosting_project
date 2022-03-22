package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLutils {
	
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public static int getRowCount(String xlfilepath, String xlSheet ) throws Exception
	{
		File source = new File(xlfilepath);
		fi = new FileInputStream(source);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}
	
	
	public static int getCellCount(String xlfilepath, String xlSheet, int rownum) throws Exception
	{
		File source = new File(xlfilepath);
		fi = new FileInputStream(source);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		row = ws.getRow(rownum);
		int cellcount =row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	
	
	public static String getCellData(String xlfilepath, String xlSheet, int rownum, int column) throws Exception
	{
		File source = new File(xlfilepath);
		fi = new FileInputStream(source);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		row = ws.getRow(rownum);
		cell = row.getCell(column);
		String data;
		
		try{
			DataFormatter formatter= new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		}
		catch(Exception x)
		{
			data= "";
		}
		
		wb.close();
		fi.close();
		return data;
	}
	
	
	
	public static void setCellData(String xlfilepath, String xlSheet, int rownum, int column,String data) throws Exception
	{
		File source = new File(xlfilepath);
		fi = new FileInputStream(source);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		row = ws.getRow(rownum);
		cell = row.getCell(column);
		cell.setCellValue(data);
		
		fo =new FileOutputStream(xlfilepath);
		wb.write(fo);
		fi.close();
		fo.close();
		
	}
	
	
	
	
	
	
	
	
	

}
