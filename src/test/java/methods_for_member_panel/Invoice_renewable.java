package methods_for_member_panel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import methods.BaseClass;

public class Invoice_renewable extends BaseClass{
	
	
	public static void capture_details_of_invoice_autoRenewable_on(WebDriver driver, String name_of_the_sheet ) throws Exception
	{
		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(name_of_the_sheet);


		Thread.sleep(5000);


		//INVOICE
		String Invoice_Date= driver.findElement(By.xpath("(//span[@class='m-invoice__text'])[2]")).getText();
		sheet.getRow(4).createCell(1).setCellValue(Invoice_Date);
		System.out.println(Invoice_Date);

		String Invoice_Due_Date= driver.findElement(By.xpath("(//span[@class='m-invoice__text'])[3]")).getText();
		sheet.getRow(5).createCell(1).setCellValue(Invoice_Due_Date);
		System.out.println(Invoice_Due_Date);



		int start_row = 8;
		
		
		int number_of_rows_present_in_web_table = 3;
		
		
		//Description
		for(int i=1; i<=number_of_rows_present_in_web_table; i++)
		{
			String description =  driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/following::table/tbody[1]/tr["+i+"]/td[2]")).getText();
			sheet.getRow(start_row + i).getCell(1).setCellValue(description);
			System.out.println(description);
		}
		
		//HSC_Code
		for(int i=1; i<=number_of_rows_present_in_web_table; i++)
		{
															   
			String HSC_Code =  driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/following::table/tbody[1]/tr["+i+"]/td[3]")).getText();
			sheet.getRow(start_row + i).getCell(3).setCellValue(HSC_Code);
			System.out.println(HSC_Code);
		}
		
		//Quantity
		for(int i=1; i<=number_of_rows_present_in_web_table; i++)
		{
													
			String quantity =  driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/following::table/tbody[1]/tr["+i+"]/td[4]")).getText();
			sheet.getRow(start_row + i).getCell(5).setCellValue(quantity);
			System.out.println(quantity);
		}

		//UOM
		for(int i=1; i<=number_of_rows_present_in_web_table; i++)
		{
			
			String UOM =  driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/following::table/tbody[1]/tr["+i+"]/td[5]")).getText();
			sheet.getRow(start_row + i).getCell(7).setCellValue(UOM);
			System.out.println(UOM);
		}


		//Rate
		for(int i=1; i<=number_of_rows_present_in_web_table; i++)
		{
											 	 	 	
			String rate =  driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/following::table/tbody[1]/tr["+i+"]/td[6]")).getText();
			sheet.getRow(start_row + i).getCell(9).setCellValue(rate);
			System.out.println(rate);
		}


		//Total
		for(int i=1; i<=number_of_rows_present_in_web_table; i++)
		{
															
			String total =  driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/following::table/tbody[1]/tr["+i+"]/td[7]")).getText();
			sheet.getRow(start_row + i).getCell(11).setCellValue(total);
			System.out.println(total);
		}
		
		
		//Taxable Value
		for(int i=1; i<=number_of_rows_present_in_web_table; i++)
		{
			
			String Taxable_value =  driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/following::table/tbody[1]/tr["+i+"]/td[8]")).getText();
			sheet.getRow(start_row + i).getCell(13).setCellValue(Taxable_value);
			System.out.println(Taxable_value);
		}
		
		

		String automated_Invoice_Goods_description_Linux = sheet.getRow(start_row+1).getCell(1).getStringCellValue();
		String automated_Invoice_Goods_description_addon = sheet.getRow(start_row+2).getCell(1).getStringCellValue();
		String automated_Invoice_Goods_description_addon2 = sheet.getRow(start_row+3).getCell(1).getStringCellValue();

		String default_Invoice_Goods_description_Linux = sheet.getRow(start_row+1).getCell(0).getStringCellValue();
		String default_Invoice_Goods_description_addon = sheet.getRow(start_row+2).getCell(0).getStringCellValue();
		String default_Invoice_Goods_description_addon2 = sheet.getRow(start_row+3).getCell(0).getStringCellValue();



		String automated_Invoice_Goods_description_Linux_HSC_Code = sheet.getRow(start_row+1).getCell(3).getStringCellValue();
		String automated_Invoice_Goods_description_addon_HSC_Code =  sheet.getRow(start_row+2).getCell(3).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_HSC_Code =  sheet.getRow(start_row+3).getCell(3).getStringCellValue();

		String default_Invoice_Goods_description_Linux_HSC_Code =  sheet.getRow(start_row+1).getCell(2).getStringCellValue();
		String default_Invoice_Goods_description_addon_HSC_Code =  sheet.getRow(start_row+2).getCell(2).getStringCellValue();
		String default_Invoice_Goods_description_addon2_HSC_Code=  sheet.getRow(start_row+3).getCell(2).getStringCellValue();

		

		String automated_Invoice_Goods_description_Linux_quantity =   sheet.getRow(start_row+1).getCell(5).getStringCellValue();
		String automated_Invoice_Goods_description_addon_quantity = sheet.getRow(start_row+2).getCell(5).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_quantity =  sheet.getRow(start_row+3).getCell(5).getStringCellValue();

		String default_Invoice_Goods_description_Linux_quantity =  sheet.getRow(start_row+1).getCell(4).getStringCellValue();
		String default_Invoice_Goods_description_addon_quantity = sheet.getRow(start_row+2).getCell(4).getStringCellValue();
		String default_Invoice_Goods_description_addon2_quantity=  sheet.getRow(start_row+3).getCell(4).getStringCellValue();


		
		String automated_Invoice_Goods_description_Linux_UOM = sheet.getRow(start_row+1).getCell(7).getStringCellValue();
		String automated_Invoice_Goods_description_addon_UOM = sheet.getRow(start_row+2).getCell(7).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_UOM = sheet.getRow(start_row+3).getCell(7).getStringCellValue();

		String default_Invoice_Goods_description_Linux_UOM = sheet.getRow(start_row+1).getCell(6).getStringCellValue();
		String default_Invoice_Goods_description_addon_UOM = sheet.getRow(start_row+2).getCell(6).getStringCellValue();
		String default_Invoice_Goods_description_addon2_UOM= sheet.getRow(start_row+3).getCell(6).getStringCellValue();



		String automated_Invoice_Goods_description_Linux_Rate = sheet.getRow(start_row+1).getCell(9).getStringCellValue();
		String automated_Invoice_Goods_description_addon_Rate = sheet.getRow(start_row+2).getCell(9).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_Rate = sheet.getRow(start_row+3).getCell(9).getStringCellValue();

		String default_Invoice_Goods_description_Linux_Rate = sheet.getRow(start_row+1).getCell(8).getStringCellValue();
		String default_Invoice_Goods_description_addon_Rate = sheet.getRow(start_row+2).getCell(8).getStringCellValue();
		String default_Invoice_Goods_description_addon2_Rate= sheet.getRow(start_row+3).getCell(8).getStringCellValue();



		String automated_Invoice_Goods_description_Linux_Total = sheet.getRow(start_row+1).getCell(11).getStringCellValue();
		String automated_Invoice_Goods_description_addon_Total = sheet.getRow(start_row+2).getCell(11).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_Total= sheet.getRow(start_row+3).getCell(11).getStringCellValue();

		String default_Invoice_Goods_description_Linux_Total = sheet.getRow(start_row+1).getCell(10).getStringCellValue();
		String default_Invoice_Goods_description_addon_Total = sheet.getRow(start_row+2).getCell(10).getStringCellValue();
		String default_Invoice_Goods_description_addon2_Total= sheet.getRow(start_row+3).getCell(10).getStringCellValue();


		String automated_Invoice_Goods_description_Linux_Taxable_value = sheet.getRow(start_row+1).getCell(13).getStringCellValue();
		String automated_Invoice_Goods_description_addon_Taxable_value = sheet.getRow(start_row+2).getCell(13).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_Taxable_value= sheet.getRow(start_row+3).getCell(13).getStringCellValue();

		String default_Invoice_Goods_description_Linux_Taxable_value = sheet.getRow(start_row+1).getCell(12).getStringCellValue();
		String default_Invoice_Goods_description_addon_Taxable_value = sheet.getRow(start_row+2).getCell(12).getStringCellValue();
		String default_Invoice_Goods_description_addon2_Taxable_value= sheet.getRow(start_row+3).getCell(12).getStringCellValue();



		String Invoice_Total_Discount= driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[4]/td[2]")).getText();
		sheet.getRow(13).createCell(13).setCellValue(Invoice_Total_Discount);
		System.out.println(Invoice_Total_Discount);

		String Invoice_SubTotal= driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[5]/td[2]")).getText();
		sheet.getRow(14).createCell(13).setCellValue(Invoice_SubTotal);
		System.out.println(Invoice_SubTotal);

		String Invoice_Total_Amount= driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[6]/td[2]")).getText();
		sheet.getRow(15).createCell(13).setCellValue(Invoice_Total_Amount);
		System.out.println(Invoice_Total_Amount);


		String automated_Invoice_Total_Discount = sheet.getRow(13).getCell(13).getStringCellValue();
		String automated_Invoice_SubTotal= sheet.getRow(14).getCell(13).getStringCellValue();
		String automated_Invoice_Total_Amount = sheet.getRow(15).getCell(13).getStringCellValue();


		String default_Invoice_Total_Discount = sheet.getRow(13).getCell(12).getStringCellValue();
		String default_Invoice_SubTotal = sheet.getRow(14).getCell(12).getStringCellValue();
		String default_Invoice_Total_Amount= sheet.getRow(15).getCell(12).getStringCellValue();



		if(automated_Invoice_Goods_description_Linux.equals(default_Invoice_Goods_description_Linux) 
				&& automated_Invoice_Goods_description_Linux_HSC_Code.equals(default_Invoice_Goods_description_Linux_HSC_Code) 
				&& automated_Invoice_Goods_description_Linux_quantity==(default_Invoice_Goods_description_Linux_quantity) 
				&& automated_Invoice_Goods_description_Linux_UOM.equals(default_Invoice_Goods_description_Linux_UOM)
				&& automated_Invoice_Goods_description_Linux_Rate.equals(default_Invoice_Goods_description_Linux_Rate) 
				&& automated_Invoice_Goods_description_Linux_Total.equals(default_Invoice_Goods_description_Linux_Total) 
				&& automated_Invoice_Goods_description_Linux_Taxable_value.equals(default_Invoice_Goods_description_Linux_Taxable_value))
		{
			sheet.getRow(start_row+1).createCell(14).setCellValue("pass");
		}
		else
		{
			sheet.getRow(start_row+1).createCell(14).setCellValue("fail");
		}


		if(automated_Invoice_Goods_description_addon.equals(default_Invoice_Goods_description_addon) 
				&& automated_Invoice_Goods_description_addon_HSC_Code.equals(default_Invoice_Goods_description_addon_HSC_Code) 
				&& automated_Invoice_Goods_description_addon_quantity==(default_Invoice_Goods_description_addon_quantity) 
				&& automated_Invoice_Goods_description_addon_UOM.equals(default_Invoice_Goods_description_addon_UOM)
				&& automated_Invoice_Goods_description_addon_Rate.equals(default_Invoice_Goods_description_addon_Rate) 
				&& automated_Invoice_Goods_description_addon_Total.equals(default_Invoice_Goods_description_addon_Total)
				&& automated_Invoice_Goods_description_addon_Taxable_value.equals(default_Invoice_Goods_description_addon_Taxable_value))
		{
			sheet.getRow(start_row+2).createCell(14).setCellValue("pass");
		}
		else
		{
			sheet.getRow(start_row+2).createCell(14).setCellValue("fail");
		}


		if(automated_Invoice_Goods_description_addon2.equals(default_Invoice_Goods_description_addon2) 
				&& automated_Invoice_Goods_description_addon2_HSC_Code.equals(default_Invoice_Goods_description_addon2_HSC_Code) 
				&& automated_Invoice_Goods_description_addon2_quantity==(default_Invoice_Goods_description_addon2_quantity) 
				&& automated_Invoice_Goods_description_addon2_UOM.equals(default_Invoice_Goods_description_addon2_UOM)
				&& automated_Invoice_Goods_description_addon2_Rate.equals(default_Invoice_Goods_description_addon2_Rate) 
				&& automated_Invoice_Goods_description_addon2_Total.equals(default_Invoice_Goods_description_addon2_Total)
				&& automated_Invoice_Goods_description_addon2_Taxable_value.equals(default_Invoice_Goods_description_addon2_Taxable_value))
		{
			sheet.getRow(start_row+3).createCell(14).setCellValue("pass");
		}
		else
		{
			sheet.getRow(start_row+3).createCell(14).setCellValue("fail");
		}


		if(automated_Invoice_Total_Discount.equals(default_Invoice_Total_Discount))
		{
			sheet.getRow(13).createCell(14).setCellValue("pass");
		}
		else
		{
			sheet.getRow(13).createCell(14).setCellValue("fail");
		}


		if(automated_Invoice_SubTotal.equals(default_Invoice_SubTotal))
		{
			sheet.getRow(14).createCell(14).setCellValue("pass");
		}
		else
		{
			sheet.getRow(14).createCell(14).setCellValue("fail");
		}


		if(automated_Invoice_Total_Amount.equals(default_Invoice_Total_Amount))
		{
			sheet.getRow(15).createCell(14).setCellValue("pass");
		}
		else
		{
			sheet.getRow(15).createCell(14).setCellValue("fail");
		}

		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
		fi.close();
		fos.close();
	}

	
	public static void capture_details_of_invoice_autoRenewable_off(WebDriver driver, String name_of_the_sheet ) throws Exception
	{
		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(name_of_the_sheet);


		Thread.sleep(5000);


		//INVOICE
		String Invoice_Date= driver.findElement(By.xpath("(//span[@class='m-invoice__text'])[2]")).getText();
		sheet.getRow(21).createCell(1).setCellValue(Invoice_Date);
		System.out.println(Invoice_Date);

		String Invoice_Due_Date= driver.findElement(By.xpath("(//span[@class='m-invoice__text'])[3]")).getText();
		sheet.getRow(22).createCell(1).setCellValue(Invoice_Due_Date);
		System.out.println(Invoice_Due_Date);



		int start_row = 25;
		
		
		int number_of_rows_present_in_web_table = 3;
		
		
		//Description
		for(int i=1; i<=number_of_rows_present_in_web_table; i++)
		{
			String description =  driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr["+i+"]/td[2]")).getText();
			sheet.getRow(start_row + i).getCell(1).setCellValue(description);
			System.out.println(description);
		}
		
		//HSC_Code
		for(int i=1; i<=number_of_rows_present_in_web_table; i++)
		{
															   
			String HSC_Code =  driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr["+i+"]/td[3]")).getText();
			sheet.getRow(start_row + i).getCell(3).setCellValue(HSC_Code);
			System.out.println(HSC_Code);
		}
		
		//Quantity
		for(int i=1; i<=number_of_rows_present_in_web_table; i++)
		{
													
			String quantity =  driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr["+i+"]/td[4]")).getText();
			sheet.getRow(start_row + i).getCell(5).setCellValue(quantity);
			System.out.println(quantity);
		}

		//UOM
		for(int i=1; i<=number_of_rows_present_in_web_table; i++)
		{
			
			String UOM =  driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr["+i+"]/td[5]")).getText();
			sheet.getRow(start_row + i).getCell(7).setCellValue(UOM);
			System.out.println(UOM);
		}


		//Rate
		for(int i=1; i<=number_of_rows_present_in_web_table; i++)
		{
											 	 	 	
			String rate =  driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr["+i+"]/td[6]")).getText();
			sheet.getRow(start_row + i).getCell(9).setCellValue(rate);
			System.out.println(rate);
		}


		//Total
		for(int i=1; i<=number_of_rows_present_in_web_table; i++)
		{
															
			String total =  driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr["+i+"]/td[7]")).getText();
			sheet.getRow(start_row + i).getCell(11).setCellValue(total);
			System.out.println(total);
		}



		//Discount
		for(int i=1; i<=number_of_rows_present_in_web_table; i++)
		{

			String discount =  driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr["+i+"]/td[8]")).getText();
			sheet.getRow(start_row + i).getCell(13).setCellValue(discount);
			System.out.println(discount);
		}
		
		
		//Taxable Value
		for(int i=1; i<=number_of_rows_present_in_web_table; i++)
		{

			String Taxable_value =  driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr["+i+"]/td[9]")).getText();
			sheet.getRow(start_row + i).getCell(15).setCellValue(Taxable_value);
			System.out.println(Taxable_value);
		}
		
		

		String automated_Invoice_Goods_description_Linux = sheet.getRow(start_row+1).getCell(1).getStringCellValue();
		String automated_Invoice_Goods_description_addon = sheet.getRow(start_row+2).getCell(1).getStringCellValue();
		String automated_Invoice_Goods_description_addon2 = sheet.getRow(start_row+3).getCell(1).getStringCellValue();

		String default_Invoice_Goods_description_Linux = sheet.getRow(start_row+1).getCell(0).getStringCellValue();
		String default_Invoice_Goods_description_addon = sheet.getRow(start_row+2).getCell(0).getStringCellValue();
		String default_Invoice_Goods_description_addon2 = sheet.getRow(start_row+3).getCell(0).getStringCellValue();



		String automated_Invoice_Goods_description_Linux_HSC_Code = sheet.getRow(start_row+1).getCell(3).getStringCellValue();
		String automated_Invoice_Goods_description_addon_HSC_Code =  sheet.getRow(start_row+2).getCell(3).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_HSC_Code =  sheet.getRow(start_row+3).getCell(3).getStringCellValue();

		String default_Invoice_Goods_description_Linux_HSC_Code =  sheet.getRow(start_row+1).getCell(2).getStringCellValue();
		String default_Invoice_Goods_description_addon_HSC_Code =  sheet.getRow(start_row+2).getCell(2).getStringCellValue();
		String default_Invoice_Goods_description_addon2_HSC_Code=  sheet.getRow(start_row+3).getCell(2).getStringCellValue();

		

		String automated_Invoice_Goods_description_Linux_quantity =   sheet.getRow(start_row+1).getCell(5).getStringCellValue();
		String automated_Invoice_Goods_description_addon_quantity = sheet.getRow(start_row+2).getCell(5).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_quantity =  sheet.getRow(start_row+3).getCell(5).getStringCellValue();

		String default_Invoice_Goods_description_Linux_quantity =  sheet.getRow(start_row+1).getCell(4).getStringCellValue();
		String default_Invoice_Goods_description_addon_quantity = sheet.getRow(start_row+2).getCell(4).getStringCellValue();
		String default_Invoice_Goods_description_addon2_quantity=  sheet.getRow(start_row+3).getCell(4).getStringCellValue();


		
		String automated_Invoice_Goods_description_Linux_UOM = sheet.getRow(start_row+1).getCell(7).getStringCellValue();
		String automated_Invoice_Goods_description_addon_UOM = sheet.getRow(start_row+2).getCell(7).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_UOM = sheet.getRow(start_row+3).getCell(7).getStringCellValue();

		String default_Invoice_Goods_description_Linux_UOM = sheet.getRow(start_row+1).getCell(6).getStringCellValue();
		String default_Invoice_Goods_description_addon_UOM = sheet.getRow(start_row+2).getCell(6).getStringCellValue();
		String default_Invoice_Goods_description_addon2_UOM= sheet.getRow(start_row+3).getCell(6).getStringCellValue();



		String automated_Invoice_Goods_description_Linux_Rate = sheet.getRow(start_row+1).getCell(9).getStringCellValue();
		String automated_Invoice_Goods_description_addon_Rate = sheet.getRow(start_row+2).getCell(9).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_Rate = sheet.getRow(start_row+3).getCell(9).getStringCellValue();

		String default_Invoice_Goods_description_Linux_Rate = sheet.getRow(start_row+1).getCell(8).getStringCellValue();
		String default_Invoice_Goods_description_addon_Rate = sheet.getRow(start_row+2).getCell(8).getStringCellValue();
		String default_Invoice_Goods_description_addon2_Rate= sheet.getRow(start_row+3).getCell(8).getStringCellValue();



		String automated_Invoice_Goods_description_Linux_Total = sheet.getRow(start_row+1).getCell(11).getStringCellValue();
		String automated_Invoice_Goods_description_addon_Total = sheet.getRow(start_row+2).getCell(11).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_Total= sheet.getRow(start_row+3).getCell(11).getStringCellValue();

		String default_Invoice_Goods_description_Linux_Total = sheet.getRow(start_row+1).getCell(10).getStringCellValue();
		String default_Invoice_Goods_description_addon_Total = sheet.getRow(start_row+2).getCell(10).getStringCellValue();
		String default_Invoice_Goods_description_addon2_Total= sheet.getRow(start_row+3).getCell(10).getStringCellValue();



		String automated_Invoice_Goods_description_Linux_Discount = sheet.getRow(start_row+1).getCell(13).getStringCellValue();
		String automated_Invoice_Goods_description_addon_Discount = sheet.getRow(start_row+2).getCell(13).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_Discount = sheet.getRow(start_row+3).getCell(13).getStringCellValue();

		String default_Invoice_Goods_description_Linux_Discount = sheet.getRow(start_row+1).getCell(12).getStringCellValue();
		String default_Invoice_Goods_description_addon_Discount = sheet.getRow(start_row+2).getCell(12).getStringCellValue();
		String default_Invoice_Goods_description_addon2_Discount= sheet.getRow(start_row+3).getCell(12).getStringCellValue();



		String automated_Invoice_Goods_description_Linux_Taxable_value = sheet.getRow(start_row+1).getCell(15).getStringCellValue();
		String automated_Invoice_Goods_description_addon_Taxable_value = sheet.getRow(start_row+2).getCell(15).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_Taxable_value= sheet.getRow(start_row+3).getCell(15).getStringCellValue();

		String default_Invoice_Goods_description_Linux_Taxable_value = sheet.getRow(start_row+1).getCell(14).getStringCellValue();
		String default_Invoice_Goods_description_addon_Taxable_value = sheet.getRow(start_row+2).getCell(14).getStringCellValue();
		String default_Invoice_Goods_description_addon2_Taxable_value= sheet.getRow(start_row+3).getCell(14).getStringCellValue();



		String Invoice_Total_Discount= driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[4]/td[2]")).getText();
		sheet.getRow(30).createCell(13).setCellValue(Invoice_Total_Discount);
		System.out.println(Invoice_Total_Discount);

		String Invoice_SubTotal= driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[5]/td[2]")).getText();
		sheet.getRow(31).createCell(13).setCellValue(Invoice_SubTotal);
		System.out.println(Invoice_SubTotal);

		String Invoice_Total_Amount= driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[6]/td[2]")).getText();
		sheet.getRow(32).createCell(13).setCellValue(Invoice_Total_Amount);
		System.out.println(Invoice_Total_Amount);


		String automated_Invoice_Total_Discount = sheet.getRow(30).getCell(13).getStringCellValue();
		String automated_Invoice_SubTotal= sheet.getRow(31).getCell(13).getStringCellValue();
		String automated_Invoice_Total_Amount = sheet.getRow(32).getCell(13).getStringCellValue();


		String default_Invoice_Total_Discount = sheet.getRow(30).getCell(12).getStringCellValue();
		String default_Invoice_SubTotal = sheet.getRow(31).getCell(12).getStringCellValue();
		String default_Invoice_Total_Amount= sheet.getRow(32).getCell(12).getStringCellValue();



		if(automated_Invoice_Goods_description_Linux.equals(default_Invoice_Goods_description_Linux) 
				&& automated_Invoice_Goods_description_Linux_HSC_Code.equals(default_Invoice_Goods_description_Linux_HSC_Code) 
				&& automated_Invoice_Goods_description_Linux_quantity==(default_Invoice_Goods_description_Linux_quantity) 
				&& automated_Invoice_Goods_description_Linux_UOM.equals(default_Invoice_Goods_description_Linux_UOM)
				&& automated_Invoice_Goods_description_Linux_Rate.equals(default_Invoice_Goods_description_Linux_Rate) 
				&& automated_Invoice_Goods_description_Linux_Total.equals(default_Invoice_Goods_description_Linux_Total)
				&& automated_Invoice_Goods_description_Linux_Discount.equals(default_Invoice_Goods_description_Linux_Discount) 
				&& automated_Invoice_Goods_description_Linux_Taxable_value.equals(default_Invoice_Goods_description_Linux_Taxable_value))
		{
			sheet.getRow(start_row+1).createCell(16).setCellValue("pass");
		}
		else
		{
			sheet.getRow(start_row+1).createCell(16).setCellValue("fail");
		}


		if(automated_Invoice_Goods_description_addon.equals(default_Invoice_Goods_description_addon) 
				&& automated_Invoice_Goods_description_addon_HSC_Code.equals(default_Invoice_Goods_description_addon_HSC_Code) 
				&& automated_Invoice_Goods_description_addon_quantity==(default_Invoice_Goods_description_addon_quantity) 
				&& automated_Invoice_Goods_description_addon_UOM.equals(default_Invoice_Goods_description_addon_UOM)
				&& automated_Invoice_Goods_description_addon_Rate.equals(default_Invoice_Goods_description_addon_Rate) 
				&& automated_Invoice_Goods_description_addon_Total.equals(default_Invoice_Goods_description_addon_Total)
				&& automated_Invoice_Goods_description_addon_Discount.equals(default_Invoice_Goods_description_addon_Discount) 
				&& automated_Invoice_Goods_description_addon_Taxable_value.equals(default_Invoice_Goods_description_addon_Taxable_value))
		{
			sheet.getRow(start_row+2).createCell(16).setCellValue("pass");
		}
		else
		{
			sheet.getRow(start_row+2).createCell(16).setCellValue("fail");
		}


		if(automated_Invoice_Goods_description_addon2.equals(default_Invoice_Goods_description_addon2) 
				&& automated_Invoice_Goods_description_addon2_HSC_Code.equals(default_Invoice_Goods_description_addon2_HSC_Code) 
				&& automated_Invoice_Goods_description_addon2_quantity==(default_Invoice_Goods_description_addon2_quantity) 
				&& automated_Invoice_Goods_description_addon2_UOM.equals(default_Invoice_Goods_description_addon2_UOM)
				&& automated_Invoice_Goods_description_addon2_Rate.equals(default_Invoice_Goods_description_addon2_Rate) 
				&& automated_Invoice_Goods_description_addon2_Total.equals(default_Invoice_Goods_description_addon2_Total)
				&& automated_Invoice_Goods_description_addon2_Discount.equals(default_Invoice_Goods_description_addon2_Discount) 
				&& automated_Invoice_Goods_description_addon2_Taxable_value.equals(default_Invoice_Goods_description_addon2_Taxable_value))
		{
			sheet.getRow(start_row+3).createCell(16).setCellValue("pass");
		}
		else
		{
			sheet.getRow(start_row+3).createCell(16).setCellValue("fail");
		}


		if(automated_Invoice_Total_Discount.equals(default_Invoice_Total_Discount))
		{
			sheet.getRow(30).createCell(14).setCellValue("pass");
		}
		else
		{
			sheet.getRow(30).createCell(14).setCellValue("fail");
		}


		if(automated_Invoice_SubTotal.equals(default_Invoice_SubTotal))
		{
			sheet.getRow(31).createCell(14).setCellValue("pass");
		}
		else
		{
			sheet.getRow(31).createCell(14).setCellValue("fail");
		}


		if(automated_Invoice_Total_Amount.equals(default_Invoice_Total_Amount))
		{
			sheet.getRow(32).createCell(14).setCellValue("pass");
		}
		else
		{
			sheet.getRow(32).createCell(14).setCellValue("fail");
		}

		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
		fi.close();
		fos.close();
	}
	
	
	

}
