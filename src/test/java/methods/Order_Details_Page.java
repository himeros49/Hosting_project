package methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Order_Details_Page extends BaseClass {
	
	
	
	/*   Where To Use     Q11 site --> Billing --> Orders --> List --> choose any from list  */
	
	
	
	/*   This Class contains Three generic Methods 
	 
		1. "capture_data_of_order_details_page_before_approval" ------> This method Will Capture Data Before product approval of the Product
		
		2. "approve_order"  ------> This method will approve the product (always called after 1st method)
		
		3. "capture_data_of_order_details_page_after_approval"  ------> This method Will Capture Data After product Approval of the Product
		(always called after 1st and  2nd method)
		
		4. "go_to_invoice"  ------> this will leads directly to invoice
		(always called after 3rd method) 
 		
	*/
	
	public static void capture_data_of_order_details_page_before_approval(WebDriver driver, String name_of_sheet) throws Exception
	{
		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(name_of_sheet);

		int starting_row_number = 39;
		int column_number = 1;
	
		String order_number = driver.findElement(By.xpath("(//table[contains(@class,'table table-bordered')]//td)[1]")).getText();
		sheet.getRow(starting_row_number).createCell(column_number).setCellValue(order_number);
//		ChangeForegroundColourForAutomation(name_of_sheet, starting_row_number, column_number);
		System.out.println(order_number);

		String order_dateTime = driver.findElement(By.xpath("(//table[contains(@class,'table table-bordered')]//td)[2]")).getText();
		sheet.getRow(starting_row_number+1).createCell(column_number).setCellValue(order_dateTime);
//		ChangeForegroundColourForAutomation(name_of_sheet, starting_row_number+1, column_number);
		System.out.println(order_dateTime);

		String due_date = driver.findElement(By.xpath("(//table[contains(@class,'table table-bordered')]//td)[3]")).getText();
		sheet.getRow(starting_row_number+2).createCell(column_number).setCellValue(due_date);
//		ChangeForegroundColourForAutomation(name_of_sheet, starting_row_number+2, column_number);
		System.out.println(due_date);


		//Before Approval
		String order_status = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[4]/span[1]")).getText();
		sheet.getRow(starting_row_number+5).createCell(column_number).setCellValue(order_status);
//		ChangeForegroundColourForAutomation(name_of_sheet, starting_row_number+5, column_number);
		System.out.println("Order Status before approval"+ order_status);  



		String automated_order_status_before= sheet.getRow(starting_row_number+5).getCell(column_number).getStringCellValue();

		String default_order_status_before = sheet.getRow(starting_row_number+5).getCell(column_number-1).getStringCellValue();

		if (automated_order_status_before.equals(default_order_status_before))
		{
			sheet.getRow(starting_row_number+5).createCell(column_number+1).setCellValue("pass");
		}
		else
		{
			sheet.getRow(starting_row_number+5).createCell(column_number+1).setCellValue("fail");
//			ChangeForegroundColourForFailedResult(name_of_sheet, starting_row_number+5, column_number+1);
		}	



		String order_amount = driver.findElement(By.xpath("(//table[contains(@class,'table table-bordered')]//td)[5]")).getText();
		sheet.getRow(starting_row_number+ 9).createCell(column_number).setCellValue(order_amount);
//		ChangeForegroundColourForAutomation(name_of_sheet, starting_row_number+9, column_number);
		System.out.println(order_amount);


		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
		fi.close();
		fos.close();

		Thread.sleep(5000);





	}


	public static void approve_order(WebDriver driver) throws Exception
	{
		//Tick Checkbox
		driver.findElement(By.xpath("(//label[contains(@class,'kt-checkbox kt-checkbox--tick')]//span)[1]")).click();
		Thread.sleep(5000);

		//click Approve Button
		driver.findElement(By.xpath("(//button[contains(@class,'btn btn-brand')])[1]")).click();
		Thread.sleep(5000);

		//click OK button
		driver.findElement(By.xpath("//button[@type='button'][contains(.,'Ok')]")).click();
		Thread.sleep(20000);
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='kt-portlet__head-title']//a[1]")));
		
	}

	

	public static void capture_data_of_order_details_page_after_approval(WebDriver driver, String name_of_the_sheet) throws Exception
	{
		
		
		
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//h3[@class='kt-portlet__head-title']//a[1]"))));
		

		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(name_of_the_sheet);
	
		
		//After Approval
		String order_status = driver.findElement(By.xpath("(//table[contains(@class,'table table-bordered')]/following::table)[2]/tbody[1]/tr[1]/td[4]/span[1]")).getText();
		sheet.getRow(46).createCell(1).setCellValue(order_status);
		ChangeForegroundColourForAutomation(name_of_the_sheet, 46, 1);
		
		System.out.println("Order status After Approval" + order_status); 


		String automated_order_status_after= sheet.getRow(46).getCell(1).getStringCellValue();

		String default_order_status_after = sheet.getRow(46).getCell(0).getStringCellValue();

		if (automated_order_status_after.equals(default_order_status_after))
		{
			sheet.getRow(46).createCell(2).setCellValue("pass");
		}
		else
		{
			sheet.getRow(46).createCell(2).setCellValue("fail");
			ChangeForegroundColourForFailedResult(name_of_the_sheet, 46, 2);
		}	


		//		        String order_success = driver.findElement(By.xpath("(//div[@class='alert-text'])[3]")).getText();
		//		        sheet.getRow(13).createCell(5).setCellValue(order_success);
		//		        System.out.println(order_success);
		//		        
		String order_invoice = driver.findElement(By.xpath("//h3[@class='kt-portlet__head-title']//a[1]")).getText();
		sheet.getRow(49).createCell(1).setCellValue(order_invoice);
		ChangeForegroundColourForAutomation(name_of_the_sheet, 49, 1);
		System.out.println(order_invoice);



		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
		fi.close();
		fos.close();

		Thread.sleep(3000);

	}


	public static void go_to_invoice(WebDriver driver) throws Exception
	{
		
		try
		{
			logger.info("Leeme try");
		WebElement go_to_invoice = driver.findElement(By.xpath("//h3[@class='kt-portlet__head-title']//a[1]"));
		go_to_invoice.click();
		Thread.sleep(5000);
		
		}
		catch(Exception x)
		{
			logger.info("catch block ........help me!!!!!!");
			driver.navigate().refresh();
			Thread.sleep(10000);
			WebElement go_to_invoice = driver.findElement(By.cssSelector("form#update_order>div>div>div:nth-of-type(2)>div>div:nth-of-type(2)>h3>a"));
			go_to_invoice.click();
			Thread.sleep(5000);	
		}
		
		
	}






}
