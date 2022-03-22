package methods_for_member_panel_partner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import methods.BaseClass;

public class Service_details extends BaseClass{
	
	public static void capture_service_details(WebDriver driver, String name_of_the_sheet, int row) throws Exception
	{
		
		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(name_of_the_sheet);
		
		
		int number_of_rows_present_in_webtable = 6;
		int column = 1;
		
		for(int i=1; i<=number_of_rows_present_in_webtable; i++)
		{
			String service_details = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td["+i+"]")).getText();
			sheet.getRow(row).getCell(column + i).setCellValue(service_details);
		}
		
		
		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
		fi.close();
		fos.close();
		
	}
	
	
	public static void capture_current_service(WebDriver driver, String name_of_the_sheet, int row) throws Exception
	{
		
		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(name_of_the_sheet);
		
		
		int number_of_columns_present_in_webtable = 9;
		int column = 0;
		
		for(int i=1; i<=number_of_columns_present_in_webtable; i++)
		{
			String service_details = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td["+i+"]")).getText();
			sheet.getRow(row).getCell(column + i).setCellValue(service_details);
		}
		
		//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[1]
		//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[2]
		//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[9]
		
		
		
		
		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
		fi.close();
		fos.close();
		
	}
	
	
	
	
	
	
	

}
