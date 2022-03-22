package methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Invoice3 extends BaseClass {
	
	
	public static void capture_invoice_ordered_without_addon(WebDriver driver,String name_of_the_sheet) throws Exception {
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

		String Invoice_Unpaid= driver.findElement(By.xpath("(//table[@class='invoice']//table)[4]/tbody[1]/tr[2]/td[1]/b[1]")).getText();
		sheet.getRow(53).createCell(2).setCellValue(Invoice_Unpaid);
		System.out.println(Invoice_Unpaid);



		XSSFRow row_Invoice_Goods_description_Linux = sheet.getRow(61);



		String Invoice_Goods_description_Linux= driver.findElement(By.xpath("(//table[@class='invoice']//table)[8]/tbody[1]/tr[2]/td[2]")).getText();
		row_Invoice_Goods_description_Linux.createCell(1).setCellValue(Invoice_Goods_description_Linux);

		row_Invoice_Goods_description_Linux.createCell(0).setCellValue(Invoice_Goods_description_Linux);
		System.out.println(Invoice_Goods_description_Linux);

		String automated_Invoice_Goods_description_Linux = row_Invoice_Goods_description_Linux.getCell(1).getStringCellValue();
	

		String default_Invoice_Goods_description_Linux = row_Invoice_Goods_description_Linux.getCell(0).getStringCellValue();




		String Invoice_Goods_description_Linux_HSC_Code= driver.findElement(By.xpath("(//table[@class='invoice']//table)[8]/tbody[1]/tr[2]/td[3]")).getText();
		row_Invoice_Goods_description_Linux.createCell(3).setCellValue(Invoice_Goods_description_Linux_HSC_Code);
		System.out.println(Invoice_Goods_description_Linux_HSC_Code);


		String automated_Invoice_Goods_description_Linux_HSC_Code = row_Invoice_Goods_description_Linux.getCell(3).getStringCellValue();


		String default_Invoice_Goods_description_Linux_HSC_Code = row_Invoice_Goods_description_Linux.getCell(2).getStringCellValue();


		String Invoice_Goods_description_Linux_quantity= (String) driver.findElement(By.xpath("(//table[@class='invoice']//table)[8]/tbody[1]/tr[2]/td[4]")).getText();
		row_Invoice_Goods_description_Linux.createCell(5).setCellValue(Invoice_Goods_description_Linux_quantity);
	
		System.out.println(Invoice_Goods_description_Linux_quantity);


		String automated_Invoice_Goods_description_Linux_quantity =  row_Invoice_Goods_description_Linux.getCell(5).getStringCellValue();
	

		String default_Invoice_Goods_description_Linux_quantity =  row_Invoice_Goods_description_Linux.getCell(4).getStringCellValue();



		String Invoice_Goods_description_Linux_UOM= driver.findElement(By.xpath("(//table[@class='invoice']//table)[8]/tbody[1]/tr[2]/td[5]")).getText();
		row_Invoice_Goods_description_Linux.createCell(7).setCellValue(Invoice_Goods_description_Linux_UOM);
		System.out.println(Invoice_Goods_description_Linux_UOM);


		String automated_Invoice_Goods_description_Linux_UOM = row_Invoice_Goods_description_Linux.getCell(7).getStringCellValue();


		String default_Invoice_Goods_description_Linux_UOM = row_Invoice_Goods_description_Linux.getCell(6).getStringCellValue();




		String Invoice_Goods_description_Linux_Rate= driver.findElement(By.xpath("(//table[@class='invoice']//table)[8]/tbody[1]/tr[2]/td[6]")).getText();
		row_Invoice_Goods_description_Linux.createCell(9).setCellValue(Invoice_Goods_description_Linux_Rate);
		System.out.println(Invoice_Goods_description_Linux_Rate);

		String automated_Invoice_Goods_description_Linux_Rate = row_Invoice_Goods_description_Linux.getCell(9).getStringCellValue();


		String default_Invoice_Goods_description_Linux_Rate = row_Invoice_Goods_description_Linux.getCell(8).getStringCellValue();




		String Invoice_Goods_description_Linux_Total= driver.findElement(By.xpath("(//table[@class='invoice']//table)[8]/tbody[1]/tr[2]/td[7]")).getText();
		row_Invoice_Goods_description_Linux.createCell(11).setCellValue(Invoice_Goods_description_Linux_Total);
		System.out.println(Invoice_Goods_description_Linux_Total);


		String automated_Invoice_Goods_description_Linux_Total = row_Invoice_Goods_description_Linux.getCell(11).getStringCellValue();
	

		String default_Invoice_Goods_description_Linux_Total = row_Invoice_Goods_description_Linux.getCell(10).getStringCellValue();
	



		String Invoice_Goods_description_Linux_Discount= driver.findElement(By.xpath("(//table[@class='invoice']//table)[8]/tbody[1]/tr[2]/td[8]")).getText();
		row_Invoice_Goods_description_Linux.createCell(13).setCellValue(Invoice_Goods_description_Linux_Discount);
		System.out.println(Invoice_Goods_description_Linux_Discount);


		String automated_Invoice_Goods_description_Linux_Discount = row_Invoice_Goods_description_Linux.getCell(13).getStringCellValue();

		String default_Invoice_Goods_description_Linux_Discount = row_Invoice_Goods_description_Linux.getCell(12).getStringCellValue();






		String Invoice_Goods_description_Linux_Taxable_value= driver.findElement(By.xpath("(//table[@class='invoice']//table)[8]/tbody[1]/tr[2]/td[9]")).getText();
		row_Invoice_Goods_description_Linux.createCell(15).setCellValue(Invoice_Goods_description_Linux_Taxable_value);
		System.out.println(Invoice_Goods_description_Linux_Taxable_value);


		String automated_Invoice_Goods_description_Linux_Taxable_value = row_Invoice_Goods_description_Linux.getCell(15).getStringCellValue();


		String default_Invoice_Goods_description_Linux_Taxable_value = row_Invoice_Goods_description_Linux.getCell(14).getStringCellValue();
	



		String Invoice_Total_Discount= driver.findElement(By.xpath("(//table[@class='invoice']//table)[8]/tbody[1]/tr[5]/td[2]")).getText();
		sheet.getRow(65).createCell(11).setCellValue(Invoice_Total_Discount);
		System.out.println(Invoice_Total_Discount);

		String Invoice_SubTotal= driver.findElement(By.xpath("(//table[@class='invoice']//table)[8]/tbody[1]/tr[6]/td[2]")).getText();
		sheet.getRow(66).createCell(11).setCellValue(Invoice_SubTotal);
		System.out.println(Invoice_SubTotal);

		String Invoice_Total_Amount= driver.findElement(By.xpath("(//table[@class='invoice']//table)[8]/tbody[1]/tr[7]/td[2]")).getText();
		sheet.getRow(67).createCell(11).setCellValue(Invoice_Total_Amount);
		System.out.println(Invoice_Total_Amount);


		String automated_Invoice_Total_Discount = sheet.getRow(65).getCell(11).getStringCellValue();
		String automated_Invoice_SubTotal= sheet.getRow(66).getCell(11).getStringCellValue();
		String automated_Invoice_Total_Amount = sheet.getRow(67).getCell(11).getStringCellValue();


		String default_Invoice_Total_Discount = sheet.getRow(65).getCell(10).getStringCellValue();
		String default_Invoice_SubTotal = sheet.getRow(66).getCell(10).getStringCellValue();
		String default_Invoice_Total_Amount= sheet.getRow(67).getCell(10).getStringCellValue();



		if(automated_Invoice_Goods_description_Linux.equals(default_Invoice_Goods_description_Linux) 
				&& automated_Invoice_Goods_description_Linux_HSC_Code.equals(default_Invoice_Goods_description_Linux_HSC_Code) 
				&& automated_Invoice_Goods_description_Linux_quantity==(default_Invoice_Goods_description_Linux_quantity) 
				&& automated_Invoice_Goods_description_Linux_UOM.equals(default_Invoice_Goods_description_Linux_UOM)
				&& automated_Invoice_Goods_description_Linux_Rate.equals(default_Invoice_Goods_description_Linux_Rate) 
				&& automated_Invoice_Goods_description_Linux_Total.equals(default_Invoice_Goods_description_Linux_Total)
				&& automated_Invoice_Goods_description_Linux_Discount.equals(default_Invoice_Goods_description_Linux_Discount) 
				&& automated_Invoice_Goods_description_Linux_Taxable_value.equals(default_Invoice_Goods_description_Linux_Taxable_value))
		{
			row_Invoice_Goods_description_Linux.createCell(16).setCellValue("pass");
		}
		else
		{
			row_Invoice_Goods_description_Linux.createCell(16).setCellValue("fail");
		}


		if(automated_Invoice_Total_Discount.equals(default_Invoice_Total_Discount))
		{
			sheet.getRow(65).createCell(12).setCellValue("pass");
		}
		else
		{
			sheet.getRow(65).createCell(12).setCellValue("fail");
		}


		if(automated_Invoice_SubTotal.equals(default_Invoice_SubTotal))
		{
			sheet.getRow(66).createCell(12).setCellValue("pass");
		}
		else
		{
			sheet.getRow(66).createCell(12).setCellValue("fail");
		}


		if(automated_Invoice_Total_Amount.equals(default_Invoice_Total_Amount))
		{
			sheet.getRow(67).createCell(12).setCellValue("pass");
		}
		else
		{
			sheet.getRow(67).createCell(12).setCellValue("fail");
		}



		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
		fi.close();
		fos.close();
		
		
	}

}
