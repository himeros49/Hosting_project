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

public class Order_summary_page extends BaseClass{

			
	public static void capture_data_from_order_summary_page(WebDriver driver, String name_of_sheet) throws Exception {
		
		
				//**********************************CAPTURING DATA************************************//
				//********************YOUR ORDER SUMMARY(Before creating Account )********************//
				
				File source = new File(xlpath);
				FileInputStream fi = new FileInputStream(source);
				XSSFWorkbook wb = new XSSFWorkbook(fi);
				XSSFSheet sheet = wb.getSheet(name_of_sheet);
				
				CellStyle style = wb.createCellStyle();
				style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				
				 


				int starting_row_from = 5;
				int column_number= 2;


				//YOUR ORDER SUMMARY (Before Creating Account) (Excel Sheet)
				String linux_price = driver.findElement(By.xpath("//div[@class='price-plans subtotalprice']")).getText();
				sheet.getRow(starting_row_from).createCell(column_number).setCellValue(linux_price);
//				sheet.getRow(starting_row_from).getCell(column_number).setCellStyle(style);
//				ChangeForegroundColourForAutomation(name_of_sheet, starting_row_from, column_number);
				System.out.println(linux_price);
							
				String hosting_price=driver.findElement(By.xpath("(//div[@class='price-plans'])[1]")).getText();
				sheet.getRow(starting_row_from+1).createCell(column_number).setCellValue(hosting_price);
//				ChangeForegroundColourForAutomation(name_of_sheet, starting_row_from+1, column_number);
				System.out.println(hosting_price);

				String hosting_managed_price=driver.findElement(By.xpath("(//div[@class='price-plans'])[2]")).getText();
				sheet.getRow(starting_row_from+2).createCell(column_number).setCellValue(hosting_managed_price);
//				ChangeForegroundColourForAutomation(name_of_sheet, starting_row_from+2, column_number);
				System.out.println(hosting_managed_price);
				
			
				String setup_fees = driver.findElement(By.xpath("//div[contains(@class,'price-plans setupprice')]")).getText();
				sheet.getRow(starting_row_from+3).createCell(column_number).setCellValue(setup_fees);
//				ChangeForegroundColourForAutomation(name_of_sheet, starting_row_from+3, column_number);
				System.out.println(setup_fees);

				String subtotal = driver.findElement(By.xpath("//div[contains(@class,'price-plans mainprice')]")).getText();
				sheet.getRow(starting_row_from+4).createCell(column_number).setCellValue(subtotal);
//				ChangeForegroundColourForAutomation(name_of_sheet, starting_row_from+4, column_number);
				System.out.println(subtotal);

				String total = driver.findElement(By.xpath("//div[contains(@class,'price-plans total_amount_price')]")).getText();
				sheet.getRow(starting_row_from+5).createCell(column_number).setCellValue(total);
//				ChangeForegroundColourForAutomation(name_of_sheet, starting_row_from+5, column_number);
				System.out.println(total);



				String automated_linux_price = sheet.getRow(starting_row_from).getCell(column_number).getStringCellValue();
				String automated_hosting_price = sheet.getRow(starting_row_from+1).getCell(column_number).getStringCellValue();
				String automated_hosting_managed_price = sheet.getRow(starting_row_from+2).getCell(column_number).getStringCellValue();
				String automated_setup_fees = sheet.getRow(starting_row_from+3).getCell(column_number).getStringCellValue();
				String automated_subtotal = sheet.getRow(starting_row_from+4).getCell(column_number).getStringCellValue();
				String automated_total = sheet.getRow(starting_row_from+5).getCell(column_number).getStringCellValue();


				String default_linux_price = sheet.getRow(starting_row_from).getCell(column_number).getStringCellValue();
				String default_hosting_price = sheet.getRow(starting_row_from+1).getCell(column_number).getStringCellValue();
				String default_hosting_managed_price = sheet.getRow(starting_row_from+2).getCell(column_number).getStringCellValue();
				String default_setup_fees = sheet.getRow(starting_row_from+3).getCell(column_number).getStringCellValue();
				String default_subtotal = sheet.getRow(starting_row_from+4).getCell(column_number).getStringCellValue();
				String default_total = sheet.getRow(starting_row_from+5).getCell(column_number).getStringCellValue();


				

				
				
				if(automated_linux_price.equals(default_linux_price))
				{
					sheet.getRow(starting_row_from).createCell(column_number+1).setCellValue("pass");
				}
				else
				{
					
					sheet.getRow(starting_row_from).createCell(column_number+1).setCellValue("fail");
//					ChangeForegroundColourForFailedResult(name_of_sheet, starting_row_from, column_number+1);
					
				}

				if(automated_hosting_price.equals(default_hosting_price))
				{
					sheet.getRow(starting_row_from+1).createCell(column_number+1).setCellValue("pass");
				}
				else
				{
					sheet.getRow(starting_row_from+1).createCell(column_number+1).setCellValue("fail");
//					ChangeForegroundColourForFailedResult(name_of_sheet, starting_row_from+1, column_number+1);
					
					
				}

				if(automated_hosting_managed_price.equals(default_hosting_managed_price))
				{
					sheet.getRow(starting_row_from+2).createCell(column_number+1).setCellValue("pass");
				}
				else
				{
					sheet.getRow(starting_row_from+2).createCell(column_number+1).setCellValue("fail");
//					ChangeForegroundColourForFailedResult(name_of_sheet, starting_row_from+2, column_number+1);
				}

				if(automated_setup_fees.equals(default_setup_fees))
				{
					sheet.getRow(starting_row_from+3).createCell(column_number+1).setCellValue("pass");
				}
				else
				{
					sheet.getRow(starting_row_from+3).createCell(column_number+1).setCellValue("fail");
//					ChangeForegroundColourForFailedResult(name_of_sheet, starting_row_from+3, column_number+1);
					
				}

				if(automated_subtotal.equals(default_subtotal))
				{
					sheet.getRow(starting_row_from+4).createCell(column_number+1).setCellValue("pass");
				}
				else
				{
					sheet.getRow(starting_row_from+4).createCell(column_number+1).setCellValue("fail");
//					ChangeForegroundColourForFailedResult(name_of_sheet, starting_row_from+4, column_number+1);;
					
				}


				if(automated_total.equals(default_total))
				{
					sheet.getRow(starting_row_from+5).createCell(column_number+1).setCellValue("pass");
				}
				else
				{
					sheet.getRow(starting_row_from+5).createCell(column_number+1).setCellValue("fail");
//					ChangeForegroundColourForFailedResult(name_of_sheet, starting_row_from+5, column_number+1);
				}



				int starting_row_for_blocks = 15;
				int column_number_blocks = 3;


				//Upper blocks
				String quantity = driver.findElement(By.xpath("(//div[@class='accordin-btn-less-add'])[1]")).getText();
				sheet.getRow(starting_row_for_blocks).createCell(column_number_blocks).setCellValue(quantity);
				//ChangeForegroundColourForAutomation(name_of_sheet, starting_row_for_blocks, column_number_blocks);
				System.out.println(quantity);


				String SetupFees = driver.findElement(By.xpath("(//div[contains(@class,'quan text-right')])[1]")).getText();
				sheet.getRow(starting_row_for_blocks).createCell(column_number_blocks+2).setCellValue(SetupFees);
//				ChangeForegroundColourForAutomation(name_of_sheet, starting_row_for_blocks, column_number_blocks+2);
				System.out.println(SetupFees);


				String Price = driver.findElement(By.xpath("(//div[contains(@class,'quan text-right')])[2]")).getText();
				sheet.getRow(starting_row_for_blocks).createCell(column_number_blocks+4).setCellValue(Price);
//				ChangeForegroundColourForAutomation(name_of_sheet, starting_row_for_blocks, column_number_blocks+4);
				System.out.println(Price);


				String automated_quantity= sheet.getRow(starting_row_for_blocks).getCell(column_number_blocks).getStringCellValue();
				String automated_SetupFees = sheet.getRow(starting_row_for_blocks).getCell(column_number_blocks+2).getStringCellValue();
				String automated_Price = sheet.getRow(starting_row_for_blocks).getCell(column_number_blocks+4).getStringCellValue();


				String default_quantity = sheet.getRow(starting_row_for_blocks).getCell(column_number_blocks-1).getStringCellValue();
				String default_SetupFees = sheet.getRow(starting_row_for_blocks).getCell(column_number_blocks+1).getStringCellValue();
				String default_Price = sheet.getRow(starting_row_for_blocks).getCell(column_number_blocks+3).getStringCellValue();


				if(automated_quantity.equals(default_quantity) && automated_SetupFees.equals(default_SetupFees) && automated_Price.equals(default_Price))
				{
					sheet.getRow(starting_row_for_blocks).createCell(column_number_blocks+5).setCellValue("pass");
				}
				else
				{
					sheet.getRow(starting_row_for_blocks).createCell(column_number_blocks+5).setCellValue("fail");
//					ChangeForegroundColourForFailedResult(name_of_sheet, starting_row_for_blocks, column_number_blocks+5);
					
				}

				///Lower Blocks
				String Hosting_quantity_quantity = driver.findElement(By.xpath("(//div[@class='plan-summry-wm']//small)[1]")).getText();
				sheet.getRow(starting_row_for_blocks+3).createCell(column_number_blocks).setCellValue(Hosting_quantity_quantity);
//				ChangeForegroundColourForAutomation(name_of_sheet, starting_row_for_blocks+3, column_number_blocks);
				System.out.println(Hosting_quantity_quantity);

				String Hosting_quantity_setup_fees = driver.findElement(By.xpath("//div[@id='userrate_setupfee_73']")).getText();
				sheet.getRow(starting_row_for_blocks+3).createCell(column_number_blocks+2).setCellValue(Hosting_quantity_setup_fees);
//				ChangeForegroundColourForAutomation(name_of_sheet, starting_row_for_blocks+3, column_number_blocks+2);
				System.out.println(Hosting_quantity_setup_fees);


				String Hosting_quantity_setup_price = driver.findElement(By.xpath("//div[@id='userrate_73']")).getText();
				sheet.getRow(starting_row_for_blocks+3).createCell(column_number_blocks+4).setCellValue(Hosting_quantity_setup_price);
//				ChangeForegroundColourForAutomation(name_of_sheet, starting_row_for_blocks+3, column_number_blocks+4);
				System.out.println(Hosting_quantity_setup_price);



				String automated_Hosting_quantity_quantity= sheet.getRow(starting_row_for_blocks+3).getCell(column_number_blocks).getStringCellValue();
				String automated_Hosting_quantity_setup_fees = sheet.getRow(starting_row_for_blocks+3).getCell(column_number_blocks+2).getStringCellValue();
				String automated_Hosting_quantity_setup_price = sheet.getRow(starting_row_for_blocks+3).getCell(column_number_blocks+4).getStringCellValue();


				String default_Hosting_quantity_quantity = sheet.getRow(starting_row_for_blocks+3).getCell(column_number_blocks-1).getStringCellValue();
				String default_Hosting_quantity_setup_fees = sheet.getRow(starting_row_for_blocks+3).getCell(column_number_blocks+1).getStringCellValue();
				String default_Hosting_quantity_setup_price = sheet.getRow(starting_row_for_blocks+3).getCell(column_number_blocks+3).getStringCellValue();


				if(automated_Hosting_quantity_quantity.equals(default_Hosting_quantity_quantity) && automated_Hosting_quantity_setup_fees.equals(default_Hosting_quantity_setup_fees) && automated_Hosting_quantity_setup_price.equals(default_Hosting_quantity_setup_price))
				{
					sheet.getRow(starting_row_for_blocks+3).createCell(column_number_blocks+5).setCellValue("pass");
				}
				else
				{
					sheet.getRow(starting_row_for_blocks+3).createCell(column_number_blocks+5).setCellValue("fail");
//					ChangeForegroundColourForFailedResult(name_of_sheet, starting_row_for_blocks+3, column_number_blocks+5);
				}	



				String Hosting_managed_percentage_quantity = driver.findElement(By.xpath("(//div[@class='plan-summry-wm']//small)[2]")).getText();
				sheet.getRow(starting_row_for_blocks+4).createCell(column_number_blocks).setCellValue(Hosting_managed_percentage_quantity);
//				ChangeForegroundColourForAutomation(name_of_sheet, starting_row_for_blocks+4, column_number_blocks);
				System.out.println(Hosting_managed_percentage_quantity);

				String Hosting_managed_percentage_setup_fees = driver.findElement(By.xpath("//div[@id='userrate_setupfee_74']")).getText();
				sheet.getRow(starting_row_for_blocks+4).createCell(column_number_blocks+2).setCellValue(Hosting_managed_percentage_setup_fees);
//				ChangeForegroundColourForAutomation(name_of_sheet, starting_row_for_blocks+4, column_number_blocks+2);
				System.out.println(Hosting_managed_percentage_setup_fees);


				String Hosting_managed_percentage_setup_price = driver.findElement(By.xpath("//div[@id='userrate_74']")).getText();
				sheet.getRow(starting_row_for_blocks+4).createCell(column_number_blocks+4).setCellValue(Hosting_managed_percentage_setup_price);
//				ChangeForegroundColourForAutomation(name_of_sheet, starting_row_for_blocks+4, column_number_blocks+4);
				System.out.println(Hosting_managed_percentage_setup_price);


				String automated_Hosting_managed_percentage_quantity= sheet.getRow(starting_row_for_blocks+4).getCell(column_number_blocks).getStringCellValue();
				String automated_Hosting_managed_percentage_setup_fees = sheet.getRow(starting_row_for_blocks+4).getCell(column_number_blocks+2).getStringCellValue();
				String automated_Hosting_managed_percentage_setup_price = sheet.getRow(starting_row_for_blocks+4).getCell(column_number_blocks+4).getStringCellValue();


				String default_Hosting_managed_percentage_quantity = sheet.getRow(starting_row_for_blocks+4).getCell(column_number_blocks-1).getStringCellValue();
				String default_Hosting_managed_percentage_setup_fees = sheet.getRow(starting_row_for_blocks+4).getCell(column_number_blocks+1).getStringCellValue();
				String default_Hosting_managed_percentage_setup_price = sheet.getRow(starting_row_for_blocks+4).getCell(column_number_blocks+3).getStringCellValue();


				if(automated_Hosting_managed_percentage_quantity.equals(default_Hosting_managed_percentage_quantity) && automated_Hosting_managed_percentage_setup_fees.equals(default_Hosting_managed_percentage_setup_fees) && automated_Hosting_managed_percentage_setup_price.equals(default_Hosting_managed_percentage_setup_price))
				{
					sheet.getRow(starting_row_for_blocks+4).createCell(column_number_blocks+5).setCellValue("pass");
				}
				else
				{
					sheet.getRow(starting_row_for_blocks+4).createCell(column_number_blocks+5).setCellValue("fail");
//					ChangeForegroundColourForFailedResult(name_of_sheet, starting_row_for_blocks+4, column_number_blocks+5);
					
				}	

				FileOutputStream fos = new FileOutputStream(source);
				wb.write(fos);
				wb.close();
				fi.close();
				fos.close();

				Thread.sleep(5000);
		
				//***********************************CAPTURING DATA ENDS HERE******************************************//
		
		
	}


	
}
