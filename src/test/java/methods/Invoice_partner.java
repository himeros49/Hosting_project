package methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Invoice_partner extends BaseClass {
	
	
	public static void capture_invoice_ordered_with_bank(WebDriver driver,String name_of_the_sheet) throws Exception {
		
		
		
		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(name_of_the_sheet);


		Thread.sleep(5000);


		//INVOICE
		
		String Invoice_Number= driver.findElement(By.xpath("(//table[@class='invoice']//table)[3]/tbody[1]/tr[1]/td[2]")).getText();
		sheet.getRow(53).createCell(1).setCellValue(Invoice_Number);
		System.out.println(Invoice_Number);

		String Invoice_Date= driver.findElement(By.xpath("(//table[@class='invoice']//table)[3]/tbody[1]/tr[2]/td[2]")).getText();
		sheet.getRow(54).createCell(1).setCellValue(Invoice_Date);
		System.out.println(Invoice_Date);

//		String Invoice_Due_Date= driver.findElement(By.xpath("(//table[@class='invoice']//table)[4]/tbody[1]/tr[1]/td[2]")).getText();
//		sheet.getRow(55).createCell(1).setCellValue(Invoice_Due_Date);
//		System.out.println(Invoice_Due_Date);

		String Invoice_Unpaid= driver.findElement(By.xpath("(//table[@class='invoice']//table)[4]/tbody[1]/tr[2]/td[1]/b[1]")).getText();
		sheet.getRow(53).createCell(2).setCellValue(Invoice_Unpaid);
		System.out.println(Invoice_Unpaid);



		XSSFRow row_Invoice_Goods_description_Linux = sheet.getRow(60);
		XSSFRow row_Invoice_Goods_description_addon = sheet.getRow(61);
		XSSFRow row_Invoice_Goods_description_addon2 = sheet.getRow(62);


		String Invoice_Goods_description_Linux= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[2]/td[2]")).getText();
		row_Invoice_Goods_description_Linux.createCell(1).setCellValue(Invoice_Goods_description_Linux);

		row_Invoice_Goods_description_Linux.createCell(0).setCellValue(Invoice_Goods_description_Linux);
		System.out.println(Invoice_Goods_description_Linux);

		String Invoice_Goods_description_addon= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[3]/td[2]")).getText();
		row_Invoice_Goods_description_addon.createCell(1).setCellValue(Invoice_Goods_description_addon);
		System.out.println(Invoice_Goods_description_addon);

		String Invoice_Goods_description_addon2= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[4]/td[2]")).getText();
		row_Invoice_Goods_description_addon2.createCell(1).setCellValue(Invoice_Goods_description_addon2);
		System.out.println(Invoice_Goods_description_addon2);



		String automated_Invoice_Goods_description_Linux = row_Invoice_Goods_description_Linux.getCell(1).getStringCellValue();
		String automated_Invoice_Goods_description_addon = row_Invoice_Goods_description_addon.getCell(1).getStringCellValue();
		String automated_Invoice_Goods_description_addon2 = row_Invoice_Goods_description_addon2.getCell(1).getStringCellValue();

		String default_Invoice_Goods_description_Linux = row_Invoice_Goods_description_Linux.getCell(0).getStringCellValue();
		String default_Invoice_Goods_description_addon = row_Invoice_Goods_description_addon.getCell(0).getStringCellValue();
		String default_Invoice_Goods_description_addon2 = row_Invoice_Goods_description_addon2.getCell(0).getStringCellValue();




		String Invoice_Goods_description_Linux_HSC_Code= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[2]/td[3]")).getText();
		row_Invoice_Goods_description_Linux.createCell(3).setCellValue(Invoice_Goods_description_Linux_HSC_Code);
		System.out.println(Invoice_Goods_description_Linux_HSC_Code);

		String Invoice_Goods_description_addon_HSC_Code= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[3]/td[3]")).getText();
		row_Invoice_Goods_description_addon.createCell(3).setCellValue(Invoice_Goods_description_addon_HSC_Code);
		System.out.println(Invoice_Goods_description_addon_HSC_Code);

		String Invoice_Goods_description_addon2_HSC_Code= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[4]/td[3]")).getText();
		row_Invoice_Goods_description_addon2.createCell(3).setCellValue(Invoice_Goods_description_addon2_HSC_Code);
		System.out.println(Invoice_Goods_description_addon2_HSC_Code);


		String automated_Invoice_Goods_description_Linux_HSC_Code = row_Invoice_Goods_description_Linux.getCell(3).getStringCellValue();
		String automated_Invoice_Goods_description_addon_HSC_Code = row_Invoice_Goods_description_addon.getCell(3).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_HSC_Code = row_Invoice_Goods_description_addon2.getCell(3).getStringCellValue();

		String default_Invoice_Goods_description_Linux_HSC_Code = row_Invoice_Goods_description_Linux.getCell(2).getStringCellValue();
		String default_Invoice_Goods_description_addon_HSC_Code = row_Invoice_Goods_description_addon.getCell(2).getStringCellValue();
		String default_Invoice_Goods_description_addon2_HSC_Code= row_Invoice_Goods_description_addon2.getCell(2).getStringCellValue();

		
		//		DataFormatter formatter = new DataFormatter();
		//String val = formatter.formatCellValue(sheet.getRow(56).getCell(5));


		String Invoice_Goods_description_Linux_quantity= (String) driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[2]/td[4]")).getText();
		row_Invoice_Goods_description_Linux.createCell(5).setCellValue(Invoice_Goods_description_Linux_quantity);
		//        String val = formatter.formatCellValue(sheet.getRow(56).getCell(5));
		//  sheet.getRow(56).createCell(5).setCellType(String);
		System.out.println(Invoice_Goods_description_Linux_quantity);

		String Invoice_Goods_description_addon_quantity= (String) driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[3]/td[4]")).getText();
		row_Invoice_Goods_description_addon.createCell(5).setCellValue(Invoice_Goods_description_addon_quantity);
		//        String val1 = formatter.formatCellValue(sheet.getRow(56).getCell(5));
		System.out.println(Invoice_Goods_description_addon_quantity);

		String Invoice_Goods_description_addon2_quantity= (String) driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[4]/td[4]")).getText();
		row_Invoice_Goods_description_addon2.createCell(5).setCellValue(Invoice_Goods_description_addon2_quantity);
		//        String val2 = formatter.formatCellValue(sheet.getRow(56).getCell(5));
		System.out.println(Invoice_Goods_description_addon2_quantity);


		String automated_Invoice_Goods_description_Linux_quantity =  row_Invoice_Goods_description_Linux.getCell(5).getStringCellValue();
		String automated_Invoice_Goods_description_addon_quantity = row_Invoice_Goods_description_addon.getCell(5).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_quantity =  row_Invoice_Goods_description_addon2.getCell(5).getStringCellValue();

		String default_Invoice_Goods_description_Linux_quantity =  row_Invoice_Goods_description_Linux.getCell(4).getStringCellValue();
		String default_Invoice_Goods_description_addon_quantity = row_Invoice_Goods_description_addon.getCell(4).getStringCellValue();
		String default_Invoice_Goods_description_addon2_quantity=  row_Invoice_Goods_description_addon2.getCell(4).getStringCellValue();




		String Invoice_Goods_description_Linux_UOM= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[2]/td[5]")).getText();
		row_Invoice_Goods_description_Linux.createCell(7).setCellValue(Invoice_Goods_description_Linux_UOM);
		System.out.println(Invoice_Goods_description_Linux_UOM);

		String Invoice_Goods_description_addon_UOM= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[3]/td[5]")).getText();
		row_Invoice_Goods_description_addon.createCell(7).setCellValue(Invoice_Goods_description_addon_UOM);
		System.out.println(Invoice_Goods_description_addon_UOM);

		String Invoice_Goods_description_addon2_UOM= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[4]/td[5]")).getText();
		row_Invoice_Goods_description_addon2.createCell(7).setCellValue(Invoice_Goods_description_addon2_UOM);
		System.out.println(Invoice_Goods_description_addon2_UOM);

		String automated_Invoice_Goods_description_Linux_UOM = row_Invoice_Goods_description_Linux.getCell(7).getStringCellValue();
		String automated_Invoice_Goods_description_addon_UOM = row_Invoice_Goods_description_addon.getCell(7).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_UOM =row_Invoice_Goods_description_addon2.getCell(7).getStringCellValue();

		String default_Invoice_Goods_description_Linux_UOM = row_Invoice_Goods_description_Linux.getCell(6).getStringCellValue();
		String default_Invoice_Goods_description_addon_UOM = row_Invoice_Goods_description_addon.getCell(6).getStringCellValue();
		String default_Invoice_Goods_description_addon2_UOM= row_Invoice_Goods_description_addon2.getCell(6).getStringCellValue();




		String Invoice_Goods_description_Linux_Rate= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[2]/td[6]")).getText();
		row_Invoice_Goods_description_Linux.createCell(9).setCellValue(Invoice_Goods_description_Linux_Rate);
		System.out.println(Invoice_Goods_description_Linux_Rate);

		String Invoice_Goods_description_addon_Rate= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[3]/td[6]")).getText();
		row_Invoice_Goods_description_addon.createCell(9).setCellValue(Invoice_Goods_description_addon_Rate);
		System.out.println(Invoice_Goods_description_addon_Rate);

		String Invoice_Goods_description_addon2_Rate= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[4]/td[6]")).getText();
		row_Invoice_Goods_description_addon2.createCell(9).setCellValue(Invoice_Goods_description_addon2_Rate);
		System.out.println(Invoice_Goods_description_addon2_Rate);

		String automated_Invoice_Goods_description_Linux_Rate = row_Invoice_Goods_description_Linux.getCell(9).getStringCellValue();
		String automated_Invoice_Goods_description_addon_Rate = row_Invoice_Goods_description_addon.getCell(9).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_Rate = row_Invoice_Goods_description_addon2.getCell(9).getStringCellValue();

		String default_Invoice_Goods_description_Linux_Rate = row_Invoice_Goods_description_Linux.getCell(8).getStringCellValue();
		String default_Invoice_Goods_description_addon_Rate = row_Invoice_Goods_description_addon.getCell(8).getStringCellValue();
		String default_Invoice_Goods_description_addon2_Rate= row_Invoice_Goods_description_addon2.getCell(8).getStringCellValue();




		String Invoice_Goods_description_Linux_Total= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[2]/td[7]")).getText();
		row_Invoice_Goods_description_Linux.createCell(11).setCellValue(Invoice_Goods_description_Linux_Total);
		System.out.println(Invoice_Goods_description_Linux_Total);

		String Invoice_Goods_description_addon_Total= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[3]/td[7]")).getText();
		row_Invoice_Goods_description_addon.createCell(11).setCellValue(Invoice_Goods_description_addon_Total);
		System.out.println(Invoice_Goods_description_addon_Total);

		String Invoice_Goods_description_addon2_Total= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[4]/td[7]")).getText();
		row_Invoice_Goods_description_addon2.createCell(11).setCellValue(Invoice_Goods_description_addon2_Total);
		System.out.println(Invoice_Goods_description_addon2_Total);


		String automated_Invoice_Goods_description_Linux_Total = row_Invoice_Goods_description_Linux.getCell(11).getStringCellValue();
		String automated_Invoice_Goods_description_addon_Total = row_Invoice_Goods_description_addon.getCell(11).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_Total= row_Invoice_Goods_description_addon2.getCell(11).getStringCellValue();

		String default_Invoice_Goods_description_Linux_Total = row_Invoice_Goods_description_Linux.getCell(10).getStringCellValue();
		String default_Invoice_Goods_description_addon_Total = row_Invoice_Goods_description_addon.getCell(10).getStringCellValue();
		String default_Invoice_Goods_description_addon2_Total= row_Invoice_Goods_description_addon2.getCell(10).getStringCellValue();



		String Invoice_Goods_description_Linux_Taxable_value= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[2]/td[8]")).getText();
		row_Invoice_Goods_description_Linux.createCell(13).setCellValue(Invoice_Goods_description_Linux_Taxable_value);
		System.out.println(Invoice_Goods_description_Linux_Taxable_value);

		String Invoice_Goods_description_addon_Taxable_value= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[3]/td[8]")).getText();
		row_Invoice_Goods_description_addon.createCell(13).setCellValue(Invoice_Goods_description_addon_Taxable_value);
		System.out.println(Invoice_Goods_description_addon_Taxable_value);

		String Invoice_Goods_description_addon2_Taxable_value= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[4]/td[8]")).getText();
		row_Invoice_Goods_description_addon2.createCell(13).setCellValue(Invoice_Goods_description_addon2_Taxable_value);
		System.out.println(Invoice_Goods_description_addon2_Taxable_value);


		String automated_Invoice_Goods_description_Linux_Taxable_value = row_Invoice_Goods_description_Linux.getCell(13).getStringCellValue();
		String automated_Invoice_Goods_description_addon_Taxable_value = row_Invoice_Goods_description_addon.getCell(13).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_Taxable_value= row_Invoice_Goods_description_addon2.getCell(13).getStringCellValue();

		String default_Invoice_Goods_description_Linux_Taxable_value = row_Invoice_Goods_description_Linux.getCell(12).getStringCellValue();
		String default_Invoice_Goods_description_addon_Taxable_value = row_Invoice_Goods_description_addon.getCell(12).getStringCellValue();
		String default_Invoice_Goods_description_addon2_Taxable_value= row_Invoice_Goods_description_addon2.getCell(12).getStringCellValue();



		String Invoice_SubTotal= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[5]/td[2]")).getText();
		sheet.getRow(64).createCell(13).setCellValue(Invoice_SubTotal);
		System.out.println(Invoice_SubTotal);

		String Invoice_Total_Amount= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[6]/td[2]")).getText();
		sheet.getRow(65).createCell(13).setCellValue(Invoice_Total_Amount);
		System.out.println(Invoice_Total_Amount);

		
		String automated_Invoice_SubTotal= sheet.getRow(64).getCell(13).getStringCellValue();
		String automated_Invoice_Total_Amount = sheet.getRow(65).getCell(13).getStringCellValue();

		String default_Invoice_SubTotal = sheet.getRow(64).getCell(12).getStringCellValue();
		String default_Invoice_Total_Amount= sheet.getRow(65).getCell(12).getStringCellValue();



		if(automated_Invoice_Goods_description_Linux.equals(default_Invoice_Goods_description_Linux) 
				&& automated_Invoice_Goods_description_Linux_HSC_Code.equals(default_Invoice_Goods_description_Linux_HSC_Code) 
				&& automated_Invoice_Goods_description_Linux_quantity==(default_Invoice_Goods_description_Linux_quantity) 
				&& automated_Invoice_Goods_description_Linux_UOM.equals(default_Invoice_Goods_description_Linux_UOM)
				&& automated_Invoice_Goods_description_Linux_Rate.equals(default_Invoice_Goods_description_Linux_Rate) 
				&& automated_Invoice_Goods_description_Linux_Total.equals(default_Invoice_Goods_description_Linux_Total) 
				&& automated_Invoice_Goods_description_Linux_Taxable_value.equals(default_Invoice_Goods_description_Linux_Taxable_value))
		{
			row_Invoice_Goods_description_Linux.createCell(14).setCellValue("pass");
		}
		else
		{
			row_Invoice_Goods_description_Linux.createCell(14).setCellValue("fail");
		}


		if(automated_Invoice_Goods_description_addon.equals(default_Invoice_Goods_description_addon) 
				&& automated_Invoice_Goods_description_addon_HSC_Code.equals(default_Invoice_Goods_description_addon_HSC_Code) 
				&& automated_Invoice_Goods_description_addon_quantity==(default_Invoice_Goods_description_addon_quantity) 
				&& automated_Invoice_Goods_description_addon_UOM.equals(default_Invoice_Goods_description_addon_UOM)
				&& automated_Invoice_Goods_description_addon_Rate.equals(default_Invoice_Goods_description_addon_Rate) 
				&& automated_Invoice_Goods_description_addon_Total.equals(default_Invoice_Goods_description_addon_Total)
				&& automated_Invoice_Goods_description_addon_Taxable_value.equals(default_Invoice_Goods_description_addon_Taxable_value))
		{
			row_Invoice_Goods_description_addon.createCell(14).setCellValue("pass");
		}
		else
		{
			row_Invoice_Goods_description_addon.createCell(14).setCellValue("fail");
		}


		if(automated_Invoice_Goods_description_addon2.equals(default_Invoice_Goods_description_addon2) 
				&& automated_Invoice_Goods_description_addon2_HSC_Code.equals(default_Invoice_Goods_description_addon2_HSC_Code) 
				&& automated_Invoice_Goods_description_addon2_quantity==(default_Invoice_Goods_description_addon2_quantity) 
				&& automated_Invoice_Goods_description_addon2_UOM.equals(default_Invoice_Goods_description_addon2_UOM)
				&& automated_Invoice_Goods_description_addon2_Rate.equals(default_Invoice_Goods_description_addon2_Rate) 
				&& automated_Invoice_Goods_description_addon2_Total.equals(default_Invoice_Goods_description_addon2_Total) 
				&& automated_Invoice_Goods_description_addon2_Taxable_value.equals(default_Invoice_Goods_description_addon2_Taxable_value))
		{
			row_Invoice_Goods_description_addon2.createCell(14).setCellValue("pass");
		}
		else
		{
			row_Invoice_Goods_description_addon2.createCell(14).setCellValue("fail");
		}



		if(automated_Invoice_SubTotal.equals(default_Invoice_SubTotal))
		{
			sheet.getRow(64).createCell(14).setCellValue("pass");
		}
		else
		{
			sheet.getRow(64).createCell(14).setCellValue("fail");
		}


		if(automated_Invoice_Total_Amount.equals(default_Invoice_Total_Amount))
		{
			sheet.getRow(65).createCell(14).setCellValue("pass");
		}
		else
		{
			sheet.getRow(65).createCell(14).setCellValue("fail");
		}



		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
		
		
	}

	

	public static void capture_invoice_ordered_with_paypal(WebDriver driver,String name_of_the_sheet) throws Exception 
	{
		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(name_of_the_sheet);


		Thread.sleep(5000);


		//INVOICE
		
		String Invoice_Number= driver.findElement(By.xpath("(//table[@class='invoice']//table)[3]/tbody[1]/tr[1]/td[2]")).getText();
		sheet.getRow(53).createCell(1).setCellValue(Invoice_Number);
		System.out.println(Invoice_Number);

		String Invoice_Date= driver.findElement(By.xpath("(//table[@class='invoice']//table)[3]/tbody[1]/tr[2]/td[2]")).getText();
		sheet.getRow(54).createCell(1).setCellValue(Invoice_Date);
		System.out.println(Invoice_Date);

		String Invoice_Due_Date= driver.findElement(By.xpath("(//table[@class='invoice']//table)[4]/tbody[1]/tr[1]/td[2]")).getText();
		sheet.getRow(55).createCell(1).setCellValue(Invoice_Due_Date);
		System.out.println(Invoice_Due_Date);

		String Invoice_paid= driver.findElement(By.xpath("(//table[@class='invoice']//table)[4]/tbody[1]/tr[2]/td[2]")).getText();
		sheet.getRow(56).createCell(1).setCellValue(Invoice_paid);
		System.out.println(Invoice_paid);



		XSSFRow row_Invoice_Goods_description_Linux = sheet.getRow(60);
		XSSFRow row_Invoice_Goods_description_addon = sheet.getRow(61);
		XSSFRow row_Invoice_Goods_description_addon2 = sheet.getRow(62);


		String Invoice_Goods_description_Linux= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[2]/td[2]")).getText();
		row_Invoice_Goods_description_Linux.createCell(1).setCellValue(Invoice_Goods_description_Linux);

		row_Invoice_Goods_description_Linux.createCell(0).setCellValue(Invoice_Goods_description_Linux);
		System.out.println(Invoice_Goods_description_Linux);

		String Invoice_Goods_description_addon= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[3]/td[2]")).getText();
		row_Invoice_Goods_description_addon.createCell(1).setCellValue(Invoice_Goods_description_addon);
		System.out.println(Invoice_Goods_description_addon);

		String Invoice_Goods_description_addon2= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[4]/td[2]")).getText();
		row_Invoice_Goods_description_addon2.createCell(1).setCellValue(Invoice_Goods_description_addon2);
		System.out.println(Invoice_Goods_description_addon2);



		String automated_Invoice_Goods_description_Linux = row_Invoice_Goods_description_Linux.getCell(1).getStringCellValue();
		String automated_Invoice_Goods_description_addon = row_Invoice_Goods_description_addon.getCell(1).getStringCellValue();
		String automated_Invoice_Goods_description_addon2 = row_Invoice_Goods_description_addon2.getCell(1).getStringCellValue();

		String default_Invoice_Goods_description_Linux = row_Invoice_Goods_description_Linux.getCell(0).getStringCellValue();
		String default_Invoice_Goods_description_addon = row_Invoice_Goods_description_addon.getCell(0).getStringCellValue();
		String default_Invoice_Goods_description_addon2 = row_Invoice_Goods_description_addon2.getCell(0).getStringCellValue();




		String Invoice_Goods_description_Linux_HSC_Code= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[2]/td[3]")).getText();
		row_Invoice_Goods_description_Linux.createCell(3).setCellValue(Invoice_Goods_description_Linux_HSC_Code);
		System.out.println(Invoice_Goods_description_Linux_HSC_Code);

		String Invoice_Goods_description_addon_HSC_Code= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[3]/td[3]")).getText();
		row_Invoice_Goods_description_addon.createCell(3).setCellValue(Invoice_Goods_description_addon_HSC_Code);
		System.out.println(Invoice_Goods_description_addon_HSC_Code);

		String Invoice_Goods_description_addon2_HSC_Code= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[4]/td[3]")).getText();
		row_Invoice_Goods_description_addon2.createCell(3).setCellValue(Invoice_Goods_description_addon2_HSC_Code);
		System.out.println(Invoice_Goods_description_addon2_HSC_Code);


		String automated_Invoice_Goods_description_Linux_HSC_Code = row_Invoice_Goods_description_Linux.getCell(3).getStringCellValue();
		String automated_Invoice_Goods_description_addon_HSC_Code = row_Invoice_Goods_description_addon.getCell(3).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_HSC_Code = row_Invoice_Goods_description_addon2.getCell(3).getStringCellValue();

		String default_Invoice_Goods_description_Linux_HSC_Code = row_Invoice_Goods_description_Linux.getCell(2).getStringCellValue();
		String default_Invoice_Goods_description_addon_HSC_Code = row_Invoice_Goods_description_addon.getCell(2).getStringCellValue();
		String default_Invoice_Goods_description_addon2_HSC_Code= row_Invoice_Goods_description_addon2.getCell(2).getStringCellValue();

		
		//		DataFormatter formatter = new DataFormatter();
		//String val = formatter.formatCellValue(sheet.getRow(56).getCell(5));


		String Invoice_Goods_description_Linux_quantity= (String) driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[2]/td[4]")).getText();
		row_Invoice_Goods_description_Linux.createCell(5).setCellValue(Invoice_Goods_description_Linux_quantity);
		//        String val = formatter.formatCellValue(sheet.getRow(56).getCell(5));
		//  sheet.getRow(56).createCell(5).setCellType(String);
		System.out.println(Invoice_Goods_description_Linux_quantity);

		String Invoice_Goods_description_addon_quantity= (String) driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[3]/td[4]")).getText();
		row_Invoice_Goods_description_addon.createCell(5).setCellValue(Invoice_Goods_description_addon_quantity);
		//        String val1 = formatter.formatCellValue(sheet.getRow(56).getCell(5));
		System.out.println(Invoice_Goods_description_addon_quantity);

		String Invoice_Goods_description_addon2_quantity= (String) driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[4]/td[4]")).getText();
		row_Invoice_Goods_description_addon2.createCell(5).setCellValue(Invoice_Goods_description_addon2_quantity);
		//        String val2 = formatter.formatCellValue(sheet.getRow(56).getCell(5));
		System.out.println(Invoice_Goods_description_addon2_quantity);


		String automated_Invoice_Goods_description_Linux_quantity =  row_Invoice_Goods_description_Linux.getCell(5).getStringCellValue();
		String automated_Invoice_Goods_description_addon_quantity = row_Invoice_Goods_description_addon.getCell(5).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_quantity =  row_Invoice_Goods_description_addon2.getCell(5).getStringCellValue();

		String default_Invoice_Goods_description_Linux_quantity =  row_Invoice_Goods_description_Linux.getCell(4).getStringCellValue();
		String default_Invoice_Goods_description_addon_quantity = row_Invoice_Goods_description_addon.getCell(4).getStringCellValue();
		String default_Invoice_Goods_description_addon2_quantity=  row_Invoice_Goods_description_addon2.getCell(4).getStringCellValue();




		String Invoice_Goods_description_Linux_UOM= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[2]/td[5]")).getText();
		row_Invoice_Goods_description_Linux.createCell(7).setCellValue(Invoice_Goods_description_Linux_UOM);
		System.out.println(Invoice_Goods_description_Linux_UOM);

		String Invoice_Goods_description_addon_UOM= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[3]/td[5]")).getText();
		row_Invoice_Goods_description_addon.createCell(7).setCellValue(Invoice_Goods_description_addon_UOM);
		System.out.println(Invoice_Goods_description_addon_UOM);

		String Invoice_Goods_description_addon2_UOM= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[4]/td[5]")).getText();
		row_Invoice_Goods_description_addon2.createCell(7).setCellValue(Invoice_Goods_description_addon2_UOM);
		System.out.println(Invoice_Goods_description_addon2_UOM);

		String automated_Invoice_Goods_description_Linux_UOM = row_Invoice_Goods_description_Linux.getCell(7).getStringCellValue();
		String automated_Invoice_Goods_description_addon_UOM = row_Invoice_Goods_description_addon.getCell(7).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_UOM =row_Invoice_Goods_description_addon2.getCell(7).getStringCellValue();

		String default_Invoice_Goods_description_Linux_UOM = row_Invoice_Goods_description_Linux.getCell(6).getStringCellValue();
		String default_Invoice_Goods_description_addon_UOM = row_Invoice_Goods_description_addon.getCell(6).getStringCellValue();
		String default_Invoice_Goods_description_addon2_UOM= row_Invoice_Goods_description_addon2.getCell(6).getStringCellValue();




		String Invoice_Goods_description_Linux_Rate= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[2]/td[6]")).getText();
		row_Invoice_Goods_description_Linux.createCell(9).setCellValue(Invoice_Goods_description_Linux_Rate);
		System.out.println(Invoice_Goods_description_Linux_Rate);

		String Invoice_Goods_description_addon_Rate= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[3]/td[6]")).getText();
		row_Invoice_Goods_description_addon.createCell(9).setCellValue(Invoice_Goods_description_addon_Rate);
		System.out.println(Invoice_Goods_description_addon_Rate);

		String Invoice_Goods_description_addon2_Rate= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[4]/td[6]")).getText();
		row_Invoice_Goods_description_addon2.createCell(9).setCellValue(Invoice_Goods_description_addon2_Rate);
		System.out.println(Invoice_Goods_description_addon2_Rate);

		String automated_Invoice_Goods_description_Linux_Rate = row_Invoice_Goods_description_Linux.getCell(9).getStringCellValue();
		String automated_Invoice_Goods_description_addon_Rate = row_Invoice_Goods_description_addon.getCell(9).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_Rate = row_Invoice_Goods_description_addon2.getCell(9).getStringCellValue();

		String default_Invoice_Goods_description_Linux_Rate = row_Invoice_Goods_description_Linux.getCell(8).getStringCellValue();
		String default_Invoice_Goods_description_addon_Rate = row_Invoice_Goods_description_addon.getCell(8).getStringCellValue();
		String default_Invoice_Goods_description_addon2_Rate= row_Invoice_Goods_description_addon2.getCell(8).getStringCellValue();




		String Invoice_Goods_description_Linux_Total= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[2]/td[7]")).getText();
		row_Invoice_Goods_description_Linux.createCell(11).setCellValue(Invoice_Goods_description_Linux_Total);
		System.out.println(Invoice_Goods_description_Linux_Total);

		String Invoice_Goods_description_addon_Total= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[3]/td[7]")).getText();
		row_Invoice_Goods_description_addon.createCell(11).setCellValue(Invoice_Goods_description_addon_Total);
		System.out.println(Invoice_Goods_description_addon_Total);

		String Invoice_Goods_description_addon2_Total= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[4]/td[7]")).getText();
		row_Invoice_Goods_description_addon2.createCell(11).setCellValue(Invoice_Goods_description_addon2_Total);
		System.out.println(Invoice_Goods_description_addon2_Total);


		String automated_Invoice_Goods_description_Linux_Total = row_Invoice_Goods_description_Linux.getCell(11).getStringCellValue();
		String automated_Invoice_Goods_description_addon_Total = row_Invoice_Goods_description_addon.getCell(11).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_Total= row_Invoice_Goods_description_addon2.getCell(11).getStringCellValue();

		String default_Invoice_Goods_description_Linux_Total = row_Invoice_Goods_description_Linux.getCell(10).getStringCellValue();
		String default_Invoice_Goods_description_addon_Total = row_Invoice_Goods_description_addon.getCell(10).getStringCellValue();
		String default_Invoice_Goods_description_addon2_Total= row_Invoice_Goods_description_addon2.getCell(10).getStringCellValue();



		String Invoice_Goods_description_Linux_Taxable_value= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[2]/td[8]")).getText();
		row_Invoice_Goods_description_Linux.createCell(13).setCellValue(Invoice_Goods_description_Linux_Taxable_value);
		System.out.println(Invoice_Goods_description_Linux_Taxable_value);

		String Invoice_Goods_description_addon_Taxable_value= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[3]/td[8]")).getText();
		row_Invoice_Goods_description_addon.createCell(13).setCellValue(Invoice_Goods_description_addon_Taxable_value);
		System.out.println(Invoice_Goods_description_addon_Taxable_value);

		String Invoice_Goods_description_addon2_Taxable_value= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[4]/td[8]")).getText();
		row_Invoice_Goods_description_addon2.createCell(13).setCellValue(Invoice_Goods_description_addon2_Taxable_value);
		System.out.println(Invoice_Goods_description_addon2_Taxable_value);


		String automated_Invoice_Goods_description_Linux_Taxable_value = row_Invoice_Goods_description_Linux.getCell(13).getStringCellValue();
		String automated_Invoice_Goods_description_addon_Taxable_value = row_Invoice_Goods_description_addon.getCell(13).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_Taxable_value= row_Invoice_Goods_description_addon2.getCell(13).getStringCellValue();

		String default_Invoice_Goods_description_Linux_Taxable_value = row_Invoice_Goods_description_Linux.getCell(12).getStringCellValue();
		String default_Invoice_Goods_description_addon_Taxable_value = row_Invoice_Goods_description_addon.getCell(12).getStringCellValue();
		String default_Invoice_Goods_description_addon2_Taxable_value= row_Invoice_Goods_description_addon2.getCell(12).getStringCellValue();



		String Invoice_SubTotal= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[5]/td[2]")).getText();
		sheet.getRow(64).createCell(13).setCellValue(Invoice_SubTotal);
		System.out.println(Invoice_SubTotal);

		String Invoice_Total_Amount= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[6]/td[2]")).getText();
		sheet.getRow(65).createCell(13).setCellValue(Invoice_Total_Amount);
		System.out.println(Invoice_Total_Amount);

		
		String automated_Invoice_SubTotal= sheet.getRow(64).getCell(13).getStringCellValue();
		String automated_Invoice_Total_Amount = sheet.getRow(65).getCell(13).getStringCellValue();

		String default_Invoice_SubTotal = sheet.getRow(64).getCell(12).getStringCellValue();
		String default_Invoice_Total_Amount= sheet.getRow(65).getCell(12).getStringCellValue();



		if(automated_Invoice_Goods_description_Linux.equals(default_Invoice_Goods_description_Linux) 
				&& automated_Invoice_Goods_description_Linux_HSC_Code.equals(default_Invoice_Goods_description_Linux_HSC_Code) 
				&& automated_Invoice_Goods_description_Linux_quantity==(default_Invoice_Goods_description_Linux_quantity) 
				&& automated_Invoice_Goods_description_Linux_UOM.equals(default_Invoice_Goods_description_Linux_UOM)
				&& automated_Invoice_Goods_description_Linux_Rate.equals(default_Invoice_Goods_description_Linux_Rate) 
				&& automated_Invoice_Goods_description_Linux_Total.equals(default_Invoice_Goods_description_Linux_Total) 
				&& automated_Invoice_Goods_description_Linux_Taxable_value.equals(default_Invoice_Goods_description_Linux_Taxable_value))
		{
			row_Invoice_Goods_description_Linux.createCell(14).setCellValue("pass");
		}
		else
		{
			row_Invoice_Goods_description_Linux.createCell(14).setCellValue("fail");
		}


		if(automated_Invoice_Goods_description_addon.equals(default_Invoice_Goods_description_addon) 
				&& automated_Invoice_Goods_description_addon_HSC_Code.equals(default_Invoice_Goods_description_addon_HSC_Code) 
				&& automated_Invoice_Goods_description_addon_quantity==(default_Invoice_Goods_description_addon_quantity) 
				&& automated_Invoice_Goods_description_addon_UOM.equals(default_Invoice_Goods_description_addon_UOM)
				&& automated_Invoice_Goods_description_addon_Rate.equals(default_Invoice_Goods_description_addon_Rate) 
				&& automated_Invoice_Goods_description_addon_Total.equals(default_Invoice_Goods_description_addon_Total)
				&& automated_Invoice_Goods_description_addon_Taxable_value.equals(default_Invoice_Goods_description_addon_Taxable_value))
		{
			row_Invoice_Goods_description_addon.createCell(14).setCellValue("pass");
		}
		else
		{
			row_Invoice_Goods_description_addon.createCell(14).setCellValue("fail");
		}


		if(automated_Invoice_Goods_description_addon2.equals(default_Invoice_Goods_description_addon2) 
				&& automated_Invoice_Goods_description_addon2_HSC_Code.equals(default_Invoice_Goods_description_addon2_HSC_Code) 
				&& automated_Invoice_Goods_description_addon2_quantity==(default_Invoice_Goods_description_addon2_quantity) 
				&& automated_Invoice_Goods_description_addon2_UOM.equals(default_Invoice_Goods_description_addon2_UOM)
				&& automated_Invoice_Goods_description_addon2_Rate.equals(default_Invoice_Goods_description_addon2_Rate) 
				&& automated_Invoice_Goods_description_addon2_Total.equals(default_Invoice_Goods_description_addon2_Total) 
				&& automated_Invoice_Goods_description_addon2_Taxable_value.equals(default_Invoice_Goods_description_addon2_Taxable_value))
		{
			row_Invoice_Goods_description_addon2.createCell(14).setCellValue("pass");
		}
		else
		{
			row_Invoice_Goods_description_addon2.createCell(14).setCellValue("fail");
		}



		if(automated_Invoice_SubTotal.equals(default_Invoice_SubTotal))
		{
			sheet.getRow(64).createCell(14).setCellValue("pass");
		}
		else
		{
			sheet.getRow(64).createCell(14).setCellValue("fail");
		}


		if(automated_Invoice_Total_Amount.equals(default_Invoice_Total_Amount))
		{
			sheet.getRow(65).createCell(14).setCellValue("pass");
		}
		else
		{
			sheet.getRow(65).createCell(14).setCellValue("fail");
		}



		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
	}

	
	
	public static void capture_invoice_after_cancellation(WebDriver driver,String name_of_the_sheet) throws Exception {
		
		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(name_of_the_sheet);


		Thread.sleep(5000);


		//INVOICE
		
		
		String Invoice_Number= driver.findElement(By.xpath("(//table[@class='invoice']//table)[3]/tbody[1]/tr[1]/td[2]")).getText();
		sheet.getRow(53).createCell(1).setCellValue(Invoice_Number);
		System.out.println(Invoice_Number);
				
		String Invoice_Date= driver.findElement(By.xpath("(//table[@class='invoice']//table)[3]/tbody[1]/tr[2]/td[2]")).getText();
		sheet.getRow(54).createCell(1).setCellValue(Invoice_Date);
		System.out.println(Invoice_Date);

		String Invoice_Due_Date= driver.findElement(By.xpath("(//table[@class='invoice']//table)[4]/tbody[1]/tr[1]/td[2]")).getText();
		sheet.getRow(55).createCell(1).setCellValue(Invoice_Due_Date);
		System.out.println(Invoice_Due_Date);
		
		String Status= driver.findElement(By.xpath("(//table[@class='invoice']//table)[4]/tbody[1]/tr[2]/td[1]/b[1]")).getText();
		sheet.getRow(56).createCell(1).setCellValue(Status);
		System.out.println(Status);



		int start_row = 59;
		
		
		int number_of_rows_present_in_web_table = 4;
		
		
		//Description
		for(int i=2; i<=number_of_rows_present_in_web_table; i++)
		{
			String description =  driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr["+i+"]/td[2]")).getText();
			sheet.getRow(start_row + i).getCell(1).setCellValue(description);
			System.out.println(description);
		}
		
		//HSC_Code
		for(int i=2; i<=number_of_rows_present_in_web_table; i++)
		{
															   
			String HSC_Code =  driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr["+i+"]/td[3]")).getText();
			sheet.getRow(start_row + i).getCell(3).setCellValue(HSC_Code);
			System.out.println(HSC_Code);
		}
		
		//Quantity
		for(int i=2; i<=number_of_rows_present_in_web_table; i++)
		{
													
			String quantity =  driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr["+i+"]/td[4]")).getText();
			sheet.getRow(start_row + i).getCell(5).setCellValue(quantity);
			System.out.println(quantity);
		}

		//UOM
		for(int i=2; i<=number_of_rows_present_in_web_table; i++)
		{
			
			String UOM =  driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr["+i+"]/td[5]")).getText();
			sheet.getRow(start_row + i).getCell(7).setCellValue(UOM);
			System.out.println(UOM);
		}


		//Rate
		for(int i=2; i<=number_of_rows_present_in_web_table; i++)
		{
											 	 	 	
			String rate =  driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr["+i+"]/td[6]")).getText();
			sheet.getRow(start_row + i).getCell(9).setCellValue(rate);
			System.out.println(rate);
		}


		//Total
		for(int i=2; i<=number_of_rows_present_in_web_table; i++)
		{
															
			String total =  driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr["+i+"]/td[7]")).getText();
			sheet.getRow(start_row + i).getCell(11).setCellValue(total);
			System.out.println(total);
		}
		
		//Taxable Value
		for(int i=2; i<=number_of_rows_present_in_web_table; i++)
		{

			String Taxable_value =  driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr["+i+"]/td[8]")).getText();
			sheet.getRow(start_row + i).getCell(13).setCellValue(Taxable_value);
			System.out.println(Taxable_value);
		}
		
		

		String automated_Invoice_Goods_description_Linux = sheet.getRow(start_row+2).getCell(1).getStringCellValue();
		String automated_Invoice_Goods_description_addon = sheet.getRow(start_row+3).getCell(1).getStringCellValue();
		String automated_Invoice_Goods_description_addon2 = sheet.getRow(start_row+4).getCell(1).getStringCellValue();

		String default_Invoice_Goods_description_Linux = sheet.getRow(start_row+2).getCell(0).getStringCellValue();
		String default_Invoice_Goods_description_addon = sheet.getRow(start_row+3).getCell(0).getStringCellValue();
		String default_Invoice_Goods_description_addon2 = sheet.getRow(start_row+4).getCell(0).getStringCellValue();



		String automated_Invoice_Goods_description_Linux_HSC_Code = sheet.getRow(start_row+2).getCell(3).getStringCellValue();
		String automated_Invoice_Goods_description_addon_HSC_Code =  sheet.getRow(start_row+3).getCell(3).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_HSC_Code =  sheet.getRow(start_row+4).getCell(3).getStringCellValue();

		String default_Invoice_Goods_description_Linux_HSC_Code =  sheet.getRow(start_row+2).getCell(2).getStringCellValue();
		String default_Invoice_Goods_description_addon_HSC_Code =  sheet.getRow(start_row+3).getCell(2).getStringCellValue();
		String default_Invoice_Goods_description_addon2_HSC_Code=  sheet.getRow(start_row+4).getCell(2).getStringCellValue();

		

		String automated_Invoice_Goods_description_Linux_quantity =   sheet.getRow(start_row+2).getCell(5).getStringCellValue();
		String automated_Invoice_Goods_description_addon_quantity = sheet.getRow(start_row+3).getCell(5).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_quantity =  sheet.getRow(start_row+4).getCell(5).getStringCellValue();

		String default_Invoice_Goods_description_Linux_quantity =  sheet.getRow(start_row+2).getCell(4).getStringCellValue();
		String default_Invoice_Goods_description_addon_quantity = sheet.getRow(start_row+3).getCell(4).getStringCellValue();
		String default_Invoice_Goods_description_addon2_quantity=  sheet.getRow(start_row+4).getCell(4).getStringCellValue();


		
		String automated_Invoice_Goods_description_Linux_UOM = sheet.getRow(start_row+2).getCell(7).getStringCellValue();
		String automated_Invoice_Goods_description_addon_UOM = sheet.getRow(start_row+3).getCell(7).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_UOM = sheet.getRow(start_row+4).getCell(7).getStringCellValue();

		String default_Invoice_Goods_description_Linux_UOM = sheet.getRow(start_row+2).getCell(6).getStringCellValue();
		String default_Invoice_Goods_description_addon_UOM = sheet.getRow(start_row+3).getCell(6).getStringCellValue();
		String default_Invoice_Goods_description_addon2_UOM= sheet.getRow(start_row+4).getCell(6).getStringCellValue();



		String automated_Invoice_Goods_description_Linux_Rate = sheet.getRow(start_row+2).getCell(9).getStringCellValue();
		String automated_Invoice_Goods_description_addon_Rate = sheet.getRow(start_row+3).getCell(9).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_Rate = sheet.getRow(start_row+4).getCell(9).getStringCellValue();

		String default_Invoice_Goods_description_Linux_Rate = sheet.getRow(start_row+2).getCell(8).getStringCellValue();
		String default_Invoice_Goods_description_addon_Rate = sheet.getRow(start_row+3).getCell(8).getStringCellValue();
		String default_Invoice_Goods_description_addon2_Rate= sheet.getRow(start_row+4).getCell(8).getStringCellValue();



		String automated_Invoice_Goods_description_Linux_Total = sheet.getRow(start_row+2).getCell(11).getStringCellValue();
		String automated_Invoice_Goods_description_addon_Total = sheet.getRow(start_row+3).getCell(11).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_Total= sheet.getRow(start_row+4).getCell(11).getStringCellValue();

		String default_Invoice_Goods_description_Linux_Total = sheet.getRow(start_row+2).getCell(10).getStringCellValue();
		String default_Invoice_Goods_description_addon_Total = sheet.getRow(start_row+3).getCell(10).getStringCellValue();
		String default_Invoice_Goods_description_addon2_Total= sheet.getRow(start_row+4).getCell(10).getStringCellValue();



		String automated_Invoice_Goods_description_Linux_Discount = sheet.getRow(start_row+2).getCell(13).getStringCellValue();
		String automated_Invoice_Goods_description_addon_Discount = sheet.getRow(start_row+3).getCell(13).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_Discount = sheet.getRow(start_row+4).getCell(13).getStringCellValue();

		String default_Invoice_Goods_description_Linux_Discount = sheet.getRow(start_row+2).getCell(12).getStringCellValue();
		String default_Invoice_Goods_description_addon_Discount = sheet.getRow(start_row+3).getCell(12).getStringCellValue();
		String default_Invoice_Goods_description_addon2_Discount= sheet.getRow(start_row+4).getCell(12).getStringCellValue();



		String automated_Invoice_Goods_description_Linux_Taxable_value = sheet.getRow(start_row+2).getCell(15).getStringCellValue();
		String automated_Invoice_Goods_description_addon_Taxable_value = sheet.getRow(start_row+3).getCell(15).getStringCellValue();
		String automated_Invoice_Goods_description_addon2_Taxable_value= sheet.getRow(start_row+4).getCell(15).getStringCellValue();

		String default_Invoice_Goods_description_Linux_Taxable_value = sheet.getRow(start_row+2).getCell(14).getStringCellValue();
		String default_Invoice_Goods_description_addon_Taxable_value = sheet.getRow(start_row+3).getCell(14).getStringCellValue();
		String default_Invoice_Goods_description_addon2_Taxable_value= sheet.getRow(start_row+4).getCell(14).getStringCellValue();


		String Invoice_SubTotal= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[5]/td[2]")).getText();
		sheet.getRow(65).getCell(11).setCellValue(Invoice_SubTotal);
		System.out.println(Invoice_SubTotal);

		String Invoice_Total_Amount= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[6]/td[2]")).getText();
		sheet.getRow(66).getCell(11).setCellValue(Invoice_Total_Amount);
		System.out.println(Invoice_Total_Amount);


		String automated_Invoice_SubTotal= sheet.getRow(65).getCell(11).getStringCellValue();
		String automated_Invoice_Total_Amount = sheet.getRow(66).getCell(11).getStringCellValue();

		String default_Invoice_SubTotal = sheet.getRow(65).getCell(10).getStringCellValue();
		String default_Invoice_Total_Amount= sheet.getRow(66).getCell(10).getStringCellValue();



		if(automated_Invoice_Goods_description_Linux.equals(default_Invoice_Goods_description_Linux) 
				&& automated_Invoice_Goods_description_Linux_HSC_Code.equals(default_Invoice_Goods_description_Linux_HSC_Code) 
				&& automated_Invoice_Goods_description_Linux_quantity==(default_Invoice_Goods_description_Linux_quantity) 
				&& automated_Invoice_Goods_description_Linux_UOM.equals(default_Invoice_Goods_description_Linux_UOM)
				&& automated_Invoice_Goods_description_Linux_Rate.equals(default_Invoice_Goods_description_Linux_Rate) 
				&& automated_Invoice_Goods_description_Linux_Total.equals(default_Invoice_Goods_description_Linux_Total)
				&& automated_Invoice_Goods_description_Linux_Discount.equals(default_Invoice_Goods_description_Linux_Discount) 
				&& automated_Invoice_Goods_description_Linux_Taxable_value.equals(default_Invoice_Goods_description_Linux_Taxable_value))
		{
			sheet.getRow(start_row+2).getCell(14).setCellValue("pass");
		}
		else
		{
			sheet.getRow(start_row+2).getCell(14).setCellValue("fail");
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
			sheet.getRow(start_row+3).getCell(14).setCellValue("pass");
		}
		else
		{
			sheet.getRow(start_row+3).getCell(14).setCellValue("fail");
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
			sheet.getRow(start_row+4).getCell(14).setCellValue("pass");
		}
		else
		{
			sheet.getRow(start_row+4).getCell(14).setCellValue("fail");
		}


		if(automated_Invoice_SubTotal.equals(default_Invoice_SubTotal))
		{
			sheet.getRow(65).getCell(12).setCellValue("pass");
		}
		else
		{
			sheet.getRow(65).getCell(12).setCellValue("fail");
		}


		if(automated_Invoice_Total_Amount.equals(default_Invoice_Total_Amount))
		{
			sheet.getRow(66).createCell(12).setCellValue("pass");
		}
		else
		{
			sheet.getRow(66).createCell(12).setCellValue("fail");
		}

		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
		fi.close();
		fos.close();

		
		
	}
		
		
		
	}
