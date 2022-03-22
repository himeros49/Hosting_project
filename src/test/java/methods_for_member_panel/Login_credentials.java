package methods_for_member_panel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import methods.BaseClass;

public class Login_credentials extends BaseClass {
	
	
	public static String[]  get_login_credentials(WebDriver driver, String name_of_the_sheet ) throws Exception
	{
		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(name_of_the_sheet);
		
		String[] credentials = new String[2];
		
		//Username
		credentials[0] = sheet.getRow(3).getCell(19).getStringCellValue();
		//Password
		credentials[1] = sheet.getRow(4).getCell(19).getStringCellValue();

		
		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
		fi.close();
		fos.close();
	
		
		return credentials;
	}
	
	
	
	public static String[]  get_login_credentials_of_SubUser(WebDriver driver, String name_of_the_sheet ) throws Exception
	{
		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(name_of_the_sheet);
		
		String[] credentials_subuser = new String[2];
		
		//Username
		credentials_subuser[0] = sheet.getRow(16).getCell(19).getStringCellValue();
		//Password
		credentials_subuser[1] = sheet.getRow(17).getCell(19).getStringCellValue();

		
		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
		fi.close();
		fos.close();
	
		
		return credentials_subuser;
	}
	
	
	public static String[]  get_login_credentials_general(WebDriver driver, String name_of_the_sheet, int row, int column) throws Exception
	{
		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(name_of_the_sheet);
		
		String[] credentials_general = new String[2];
		
		
		//Username
		credentials_general[0] = sheet.getRow(row).getCell(column).getStringCellValue();
		//Password
		credentials_general[1] = sheet.getRow(row + 1).getCell(column).getStringCellValue();

		
		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
		fi.close();
		fos.close();
	
		
		return credentials_general;
	}
	
	


}
