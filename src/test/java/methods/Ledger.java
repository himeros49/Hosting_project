package methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Ledger extends BaseClass {
	
	
	public static void capture_details_of_legder_before_payment(WebDriver driver, String name_of_the_sheet) throws Exception 
	{
		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(name_of_the_sheet);
		
		
		//Debit Amount
		String debit_amount = driver.findElement(By.xpath("(//span[@class='kt-widget25__number'])[1]")).getText();
		sheet.getRow(41).getCell(6).setCellValue(debit_amount);
		
		//Credit Amount 
		String credit_amount= driver.findElement(By.xpath("(//span[@class='kt-widget25__number'])[2]")).getText();
		sheet.getRow(42).getCell(6).setCellValue(credit_amount);
		
		//Balance
		String balance = driver.findElement(By.xpath("(//span[@class='kt-widget25__number'])[3]")).getText();
		sheet.getRow(43).getCell(6).setCellValue(balance);
		

		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
		fi.close();
		fos.close();
		
	}
	
	public static void capture_details_of_legder_after_payment(WebDriver driver, String name_of_the_sheet) throws Exception 
	{
		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(name_of_the_sheet);
		
		
		//Debit Amount
		String debit_amount = driver.findElement(By.xpath("(//span[@class='kt-widget25__number'])[1]")).getText();
		sheet.getRow(41).getCell(7).setCellValue(debit_amount);
		
		//Credit Amount 
		String credit_amount= driver.findElement(By.xpath("(//span[@class='kt-widget25__number'])[2]")).getText();
		sheet.getRow(42).getCell(7).setCellValue(credit_amount);
		
		//Balance
		String balance = driver.findElement(By.xpath("(//span[@class='kt-widget25__number'])[3]")).getText();
		sheet.getRow(43).getCell(7).setCellValue(balance);
		

		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
		fi.close();
		fos.close();
		
	}
	

}
