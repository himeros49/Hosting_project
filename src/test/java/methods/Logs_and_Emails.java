package methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logs_and_Emails extends BaseClass {



	public static void capture_details_of_logs(WebDriver driver, String name_of_the_sheet, int number_of_rows) throws Exception {

		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(name_of_the_sheet);
		
		int row = 96;
		
		
		
		//S.No.
		for(int i=1; i<=number_of_rows; i++)
		{											  
			String sno = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr["+i+"]/td[1]")).getText();
			sheet.getRow(row + i).getCell(0).setCellValue(sno);
		}
		
		//For Date And Time 
		 for(int i=1; i<=number_of_rows; i++) {
			 												
			 String date_time = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr["+i+"]/td[2]")).getText();
			 sheet.getRow(row + i).getCell(1).setCellValue(date_time);
		
		 }
		 
		 //Description
		 for(int i=1; i<=number_of_rows; i++) {
			 													
			 String description = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr["+i+"]/td[3]/div[1]")).getText();
			 sheet.getRow(row + i).getCell(2).setCellValue(description);
		
		 }
		 
		//User
		 for(int i=1; i<=number_of_rows; i++) {
			 											
			 String user = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr["+i+"]/td[4]")).getText();
			 sheet.getRow(row + i).getCell(3).setCellValue(user);
		
		 }
		 
		//IPAddress
		 for(int i=1; i<=number_of_rows; i++) {
			 
			 String ipaddress = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr["+i+"]/td[5]")).getText();
			 sheet.getRow(row + i).getCell(4).setCellValue(ipaddress);
		
		 }

		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
		fi.close();
		fos.close();

	}
	
	
	
	public static void capture_details_of_emails(WebDriver driver, String name_of_the_sheet,int number_of_rows) throws Exception {

		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(name_of_the_sheet);
		
		int row = 108;
		
		
		//S.No.
		for(int i=1; i<=number_of_rows; i++)
		{											  
			String sno = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr["+ i +"]/td[1]")).getText();
			sheet.getRow(row + i).getCell(0).setCellValue(sno);
		}
		
		//Date 
		 for(int i=1; i<=number_of_rows; i++) {
			 String date_time = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr["+ i +"]/td[2]")).getText();
			 sheet.getRow(row + i).getCell(1).setCellValue(date_time);
		
		 }
		 
		 //Module
		 for(int i=1; i<=number_of_rows; i++) {
			 
			 String module = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr["+ i +"]/td[3]")).getText();
			 sheet.getRow(row + i).getCell(2).setCellValue(module);
		
		 }
		 
		//Subject
		 for(int i=1; i<=number_of_rows; i++) {
			 
			 String subject = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr["+i+"]/td[4]")).getText();
			 sheet.getRow(row + i).getCell(3).setCellValue(subject);
		
		 }
		 
		//EmailTo
		 for(int i=1; i<=number_of_rows; i++) {
			 
			 String emailto = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr["+i+"]/td[5]")).getText();
			 sheet.getRow(row + i).getCell(4).setCellValue(emailto);
		
		 }
		 
		//User Name
		 for(int i=1; i<=number_of_rows; i++) {
			 
			 String username = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr["+i+"]/td[6]")).getText();
			 sheet.getRow(row + i).getCell(5).setCellValue(username);
		
		 }
		 
		 

		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
		fi.close();
		fos.close();

	}
	
	
	
	
	
}
