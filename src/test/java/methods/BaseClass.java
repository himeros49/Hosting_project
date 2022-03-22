package methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import features.QA11_hostinglinux_partnerPanel;
import utilities.ReadConfig;

public class BaseClass {
	
	
	
	//Location Of Excel Sheet
	public static String xlpath = System.getProperty("user.dir") + "/src/main/resources/Q11-Hosting.xlsx";
	
	public static Logger logger = LogManager.getLogger(QA11_hostinglinux_partnerPanel.class);
	
	
	
	
	//Creating Object Of ReadConfig class(present in utilities Section)
	public static ReadConfig readconfig = new ReadConfig();
	
	protected static String BaseUrl = readconfig.openURL();

	protected static String valid_admin_username= readconfig.getadmin_username();

	protected static String valid_admin_password= readconfig.getadmin_password();
	
	
	
	protected static String BaseUrl_partner = readconfig.openpartnerURL();

	protected static String valid_partner_username= readconfig.getpartner_username();

	protected static String valid_partner_password= readconfig.getpartner_password();
	
	
	
	public static String BaseUrl_member = readconfig.openmemberURL();
	
	public static String BaseUrl_member_partner = readconfig.openmember_partnerURL();
	
	public static String BaseUrl_market = readconfig.openmarketURL();
	
	
	/**************************************** METHODS *******************************************/
	
	
	
	//This Method will take ScreenShot
	public static void captureScreen(WebDriver driver, String nameoffile) throws Exception
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "Screenshot" + nameoffile + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
		
	}
	
	
	
	//Method for Generating Random Alphabets
	public static String randomstring(int length)
	{
		String generatedString = RandomStringUtils.randomAlphabetic(length);
		return (generatedString);
	}
	
	
	//Method for Generating Random Numbers
	public static String randomnumber(int length)
	{
		String generatedStringInNumber = RandomStringUtils.randomNumeric(length);
		return (generatedStringInNumber);
	}
	
	//Method for Generating Random AlphaNumeric
	public static String randomAlphanumeric(int length)
	{
		String generatedStringInAlphanumeric = RandomStringUtils.randomAlphanumeric(length);
		return (generatedStringInAlphanumeric);
	}
	
	//For Coloring Foreground of Cell(for Automation)
	public static XSSFCell ChangeForegroundColourForAutomation(String name_of_sheet,int rownumber, int columnnumber) throws Exception
	{
		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(name_of_sheet);
		
		//For Coloring Foreground of Cell(for Automation) 
		CellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.TAN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		XSSFRow row = sheet.getRow(rownumber);
		
		XSSFCell cell = row.createCell(columnnumber);
		
		cell.setCellStyle(style);
		
		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();	
		return cell;
	}
	
	
	
	//For Coloring Foreground of Cell(for fail result)
	public static void ChangeForegroundColourForFailedResult(String name_of_sheet,int rownumber, int columnnumber) throws Exception
	{
		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(name_of_sheet);
		
		//For Coloring Foreground of Cell(for fail result)
		CellStyle style_fail = wb.createCellStyle();
		style_fail.setFillForegroundColor(IndexedColors.RED.getIndex());
		style_fail.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		sheet.getRow(rownumber).createCell(columnnumber).setCellStyle(style_fail);
		
		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();	
	}
	
	
	
	//Get Today's Date 
	public static String getTodaysDate() {
		
		SimpleDateFormat sd = new SimpleDateFormat("dd-mm-yyyy");
	    Date date = new Date();
	    sd.setTimeZone(TimeZone.getTimeZone("IST"));
	    System.out.println(sd.format(date));
		return sd.format(date);
	}
	
	//Get Further Date 
	public static String getfurtherDate(int plusday) {
			
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	        Calendar c = Calendar.getInstance();
	        c.setTime(new Date()); // Using today's date
	        c.add(Calendar.DATE, plusday); // Adding 5 days
	        String output = sdf.format(c.getTime());
	        System.out.println(output);
	        return output;
		}
	
	
	
	
	
	

}
