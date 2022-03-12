package methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.ReadConfig;

public class After_account_creation extends BaseClass {
	
	
	public static void capture_data_after_account_creation_from_partner_panel(WebDriver driver, String name_of_the_sheet) throws Exception {
		
		 int row_for_account_creation= 26;
		 int column_for_account_creation= 0;
		 
		 
		 	File source = new File(xlpath);
			FileInputStream fi = new FileInputStream(source);
			XSSFWorkbook wb = new XSSFWorkbook(fi);
			XSSFSheet sheet = wb.getSheet(name_of_the_sheet);



	        String linux_item=  driver.findElement(By.xpath("//p[text()='Linux Hosting New']")).getText();
	        System.out.println(linux_item);


	        String linux_subitem=  driver.findElement(By.xpath("(//p[@class='item_name']/following::p[@class='ItemSubTitle'])[1]")).getText();
	        System.out.println(linux_subitem);


	        String item_name = linux_item + " " +linux_subitem;

	        sheet.getRow(row_for_account_creation).createCell(column_for_account_creation+1).setCellValue(item_name);
	        sheet.getRow(row_for_account_creation).createCell(column_for_account_creation).setCellValue(item_name);



	        String linux_quantity=  driver.findElement(By.xpath("(//div[@class='add-auto-renewal-cart']//div)[1]")).getText();
	        System.out.println(linux_quantity);
	        sheet.getRow(row_for_account_creation).createCell(column_for_account_creation+3).setCellValue(linux_quantity);



	        String linux_duration=  driver.findElement(By.xpath("(//div[@class='add-auto-renewal-cart'])[2]")).getText();
	        System.out.println(linux_duration);
	        sheet.getRow(row_for_account_creation).createCell(5).setCellValue(linux_duration);


	        String linux_price=  driver.findElement(By.xpath("(//div[@class='price-section-right text-right']//div)[2]")).getText();
	        System.out.println(linux_price);
	        sheet.getRow(row_for_account_creation).createCell(7).setCellValue(linux_price);

	        String automated_item_name= sheet.getRow(row_for_account_creation).getCell(column_for_account_creation+1).getStringCellValue();
	        String automated_linux_quantity = sheet.getRow(row_for_account_creation).getCell(column_for_account_creation+3).getStringCellValue();
	        String automated_linux_duration = sheet.getRow(row_for_account_creation).getCell(column_for_account_creation+5).getStringCellValue();
	        String automated_linux_price1 = sheet.getRow(row_for_account_creation).getCell(column_for_account_creation+7).getStringCellValue();


	        String default_item_name = sheet.getRow(row_for_account_creation).getCell(column_for_account_creation).getStringCellValue();
	        String default_linux_quantity = sheet.getRow(row_for_account_creation).getCell(column_for_account_creation+2).getStringCellValue();
	        String default_linux_duration = sheet.getRow(row_for_account_creation).getCell(column_for_account_creation+4).getStringCellValue();
	        String default_linux_price1 = sheet.getRow(row_for_account_creation).getCell(column_for_account_creation+6).getStringCellValue();


	        if(automated_item_name.equals(default_item_name)
	                && automated_linux_quantity.equals(default_linux_quantity)
	                && automated_linux_duration.equals(default_linux_duration)
	                && automated_linux_price1.equals(default_linux_price1))
	        {
	            sheet.getRow(row_for_account_creation).createCell(column_for_account_creation+8).setCellValue("Pass");

	        }
	        else
	        {
	            sheet.getRow(row_for_account_creation).createCell(column_for_account_creation+8).setCellValue("Fail");
	        }




	        String addon_item= driver.findElement(By.xpath("(//p[@class='item_name addon'])[1]")).getText();
	        System.out.println(addon_item);
	        sheet.getRow(row_for_account_creation+1).createCell(1).setCellValue(addon_item);

	        String addon_quantity= driver.findElement(By.xpath("(//label[@class='input'])[1]")).getText();
	        System.out.println(addon_quantity);
	        sheet.getRow(row_for_account_creation+1).createCell(3).setCellValue(addon_quantity);

	        String addon_duration= driver.findElement(By.xpath("(//div[@class='add-auto-renewal-cart'])[4]")).getText();
	        System.out.println(addon_duration);
	        sheet.getRow(row_for_account_creation+1).createCell(5).setCellValue(addon_duration);

	        String addon_price= driver.findElement(By.xpath("(//div[@class='CartSubTotal addon'])[1]")).getText();
	        System.out.println(addon_price);
	        sheet.getRow(row_for_account_creation+1).createCell(7).setCellValue(addon_price);


	        String automated_addon_item= sheet.getRow(row_for_account_creation+1).getCell(column_for_account_creation+1).getStringCellValue();
	        String automated_addon_quantity = sheet.getRow(row_for_account_creation+1).getCell(column_for_account_creation+3).getStringCellValue();
	        String automated_addon_duration = sheet.getRow(row_for_account_creation+1).getCell(column_for_account_creation+5).getStringCellValue();
	        String automated_addon_price = sheet.getRow(row_for_account_creation+1).getCell(column_for_account_creation+7).getStringCellValue();


	        String default_addon_item = sheet.getRow(row_for_account_creation+1).getCell(column_for_account_creation).getStringCellValue();
	        String default_addon_quantity = sheet.getRow(row_for_account_creation+1).getCell(column_for_account_creation+2).getStringCellValue();
	        String default_addon_duration = sheet.getRow(row_for_account_creation+1).getCell(column_for_account_creation+4).getStringCellValue();
	        String default_addon_price = sheet.getRow(row_for_account_creation+1).getCell(column_for_account_creation+6).getStringCellValue();


	        if(automated_addon_item.equals(default_addon_item)
	                && automated_addon_quantity.equals(default_addon_quantity)
	                && automated_addon_duration.equals(default_addon_duration)
	                && automated_addon_price.equals(default_addon_price))
	        {
	            sheet.getRow(row_for_account_creation+1).createCell(column_for_account_creation+8).setCellValue("Pass");

	        }
	        else
	        {
	            sheet.getRow(row_for_account_creation+1).createCell(column_for_account_creation+8).setCellValue("Fail");
	        }




	        String addon2_item= driver.findElement(By.xpath("(//p[@class='item_name addon'])[2]")).getText();
	        System.out.println(addon2_item);
	        sheet.getRow(row_for_account_creation+2).createCell(column_for_account_creation+1).setCellValue(addon2_item);


	        String addon2_quantity= driver.findElement(By.xpath("(//label[@class='input'])[2]")).getText();
	        System.out.println(addon2_quantity);
	        sheet.getRow(row_for_account_creation+2).createCell(column_for_account_creation+3).setCellValue(addon2_quantity);

	        String addon2_duration= driver.findElement(By.xpath("//div[@id='order-summary']/div[1]/div[2]/div[4]/div[1]/div[3]/div[2]")).getText();
	        System.out.println(addon2_duration);
	        sheet.getRow(row_for_account_creation+2).createCell(column_for_account_creation+5).setCellValue(addon2_duration);

	        String addon2_price= driver.findElement(By.xpath("(//div[@class='CartSubTotal addon'])[2]")).getText();
	        System.out.println(addon2_price);
	        sheet.getRow(row_for_account_creation+2).createCell(column_for_account_creation+7).setCellValue(addon2_price);




	        String automated_addon2_item= sheet.getRow(row_for_account_creation+2).getCell(column_for_account_creation+1).getStringCellValue();
	        String automated_addon2_quantity = sheet.getRow(row_for_account_creation+2).getCell(column_for_account_creation+3).getStringCellValue();
	        String automated_addon2_duration = sheet.getRow(row_for_account_creation+2).getCell(column_for_account_creation+5).getStringCellValue();
	        String automated_addon2_price = sheet.getRow(row_for_account_creation+2).getCell(column_for_account_creation+7).getStringCellValue();


	        String default_addon2_item = sheet.getRow(row_for_account_creation+2).getCell(column_for_account_creation).getStringCellValue();
	        String default_addon2_quantity = sheet.getRow(row_for_account_creation+2).getCell(column_for_account_creation+2).getStringCellValue();
	        String default_addon2_duration = sheet.getRow(row_for_account_creation+2).getCell(column_for_account_creation+4).getStringCellValue();
	        String default_addon2_price = sheet.getRow(row_for_account_creation+2).getCell(column_for_account_creation+6).getStringCellValue();


	        if(automated_addon2_item.equals(default_addon2_item)
	                && automated_addon2_quantity.equals(default_addon2_quantity)
	                && automated_addon2_duration.equals(default_addon2_duration)
	                && automated_addon2_price.equals(default_addon2_price))
	        {
	            sheet.getRow(row_for_account_creation+2).createCell(column_for_account_creation+8).setCellValue("Pass");

	        }
	        else
	        {
	            sheet.getRow(row_for_account_creation+2).createCell(column_for_account_creation+8).setCellValue("Fail");
	        }



	        String linux_subtotal=  driver.findElement(By.xpath("(//span[@class='right-prices'])[1]")).getText();
	        System.out.println(linux_subtotal);
	        sheet.getRow(row_for_account_creation+4).createCell(column_for_account_creation+7).setCellValue(linux_subtotal);
	        

	        String linux_discount=  driver.findElement(By.xpath("(//span[@class='right-prices'])[2]")).getText();
	        System.out.println(linux_discount);
	        sheet.getRow(row_for_account_creation+5).createCell(column_for_account_creation+7).setCellValue(linux_discount);




	        String automated_linux_subtotal= sheet.getRow(row_for_account_creation+4).getCell(column_for_account_creation+7).getStringCellValue();
	        String automated_linux_total = sheet.getRow(row_for_account_creation+5).getCell(column_for_account_creation+7).getStringCellValue();



	        String default_linux_subtotal = sheet.getRow(row_for_account_creation+4).getCell(column_for_account_creation+6).getStringCellValue();
	        String default_linux_total = sheet.getRow(row_for_account_creation+5).getCell(column_for_account_creation+6).getStringCellValue();



	        if(automated_linux_subtotal.equals(default_linux_subtotal))
	        {
	            sheet.getRow(row_for_account_creation+4).createCell(column_for_account_creation+8).setCellValue("Pass");

	        }
	        else
	        {
	            sheet.getRow(row_for_account_creation+4).createCell(column_for_account_creation+8).setCellValue("Fail");
	        }

	        if(automated_linux_total.equals(default_linux_total))
	        {
	            sheet.getRow(row_for_account_creation+5).createCell(column_for_account_creation+8).setCellValue("Pass");

	        }
	        else
	        {
	            sheet.getRow(row_for_account_creation+5).createCell(column_for_account_creation+8).setCellValue("Fail");
	        }


	        FileOutputStream fos = new FileOutputStream(source);
	        wb.write(fos);
	        wb.close();

	        Thread.sleep(10000);
		
	} 
	
	
	
	
	
	
	public static void capture_data_after_account_creation_from_admin_panel(WebDriver driver, String name_of_the_sheet) throws Exception {
	
		

		 int row_for_account_creation= 26;
		 int column_for_account_creation= 0;
		 
		 
		 	File source = new File(xlpath);
			FileInputStream fi = new FileInputStream(source);
			XSSFWorkbook wb = new XSSFWorkbook(fi);
			XSSFSheet sheet = wb.getSheet(name_of_the_sheet);



	        String linux_item=  driver.findElement(By.xpath("//p[text()='Linux Hosting New']")).getText();
	        System.out.println(linux_item);


	        String linux_subitem=  driver.findElement(By.xpath("(//p[@class='item_name']/following::p[@class='ItemSubTitle'])[1]")).getText();
	        System.out.println(linux_subitem);


	        String item_name = linux_item + " " +linux_subitem;

	        sheet.getRow(row_for_account_creation).createCell(column_for_account_creation+1).setCellValue(item_name);
	        sheet.getRow(row_for_account_creation).createCell(column_for_account_creation).setCellValue(item_name);



	        String linux_quantity=  driver.findElement(By.xpath("(//div[@class='add-auto-renewal-cart']//div)[1]")).getText();
	        System.out.println(linux_quantity);
	        sheet.getRow(row_for_account_creation).createCell(column_for_account_creation+3).setCellValue(linux_quantity);



	        String linux_duration=  driver.findElement(By.xpath("(//div[@class='add-auto-renewal-cart'])[2]")).getText();
	        System.out.println(linux_duration);
	        sheet.getRow(row_for_account_creation).createCell(5).setCellValue(linux_duration);


	        String linux_price=  driver.findElement(By.xpath("(//div[@class='price-section-right text-right']//div)[2]")).getText();
	        System.out.println(linux_price);
	        sheet.getRow(row_for_account_creation).createCell(7).setCellValue(linux_price);

	        String automated_item_name= sheet.getRow(row_for_account_creation).getCell(column_for_account_creation+1).getStringCellValue();
	        String automated_linux_quantity = sheet.getRow(row_for_account_creation).getCell(column_for_account_creation+3).getStringCellValue();
	        String automated_linux_duration = sheet.getRow(row_for_account_creation).getCell(column_for_account_creation+5).getStringCellValue();
	        String automated_linux_price1 = sheet.getRow(row_for_account_creation).getCell(column_for_account_creation+7).getStringCellValue();


	        String default_item_name = sheet.getRow(row_for_account_creation).getCell(column_for_account_creation).getStringCellValue();
	        String default_linux_quantity = sheet.getRow(row_for_account_creation).getCell(column_for_account_creation+2).getStringCellValue();
	        String default_linux_duration = sheet.getRow(row_for_account_creation).getCell(column_for_account_creation+4).getStringCellValue();
	        String default_linux_price1 = sheet.getRow(row_for_account_creation).getCell(column_for_account_creation+6).getStringCellValue();


	        if(automated_item_name.equals(default_item_name)
	                && automated_linux_quantity.equals(default_linux_quantity)
	                && automated_linux_duration.equals(default_linux_duration)
	                && automated_linux_price1.equals(default_linux_price1))
	        {
	            sheet.getRow(row_for_account_creation).createCell(column_for_account_creation+8).setCellValue("Pass");

	        }
	        else
	        {
	            sheet.getRow(row_for_account_creation).createCell(column_for_account_creation+8).setCellValue("Fail");
	        }




	        String addon_item= driver.findElement(By.xpath("(//p[@class='item_name addon'])[1]")).getText();
	        System.out.println(addon_item);
	        sheet.getRow(row_for_account_creation+1).createCell(1).setCellValue(addon_item);

	        String addon_quantity= driver.findElement(By.xpath("(//label[@class='input'])[1]")).getText();
	        System.out.println(addon_quantity);
	        sheet.getRow(row_for_account_creation+1).createCell(3).setCellValue(addon_quantity);

	        String addon_duration= driver.findElement(By.xpath("(//div[@class='add-auto-renewal-cart'])[4]")).getText();
	        System.out.println(addon_duration);
	        sheet.getRow(row_for_account_creation+1).createCell(5).setCellValue(addon_duration);

	        String addon_price= driver.findElement(By.xpath("(//div[@class='CartSubTotal addon'])[1]")).getText();
	        System.out.println(addon_price);
	        sheet.getRow(row_for_account_creation+1).createCell(7).setCellValue(addon_price);


	        String automated_addon_item= sheet.getRow(row_for_account_creation+1).getCell(column_for_account_creation+1).getStringCellValue();
	        String automated_addon_quantity = sheet.getRow(row_for_account_creation+1).getCell(column_for_account_creation+3).getStringCellValue();
	        String automated_addon_duration = sheet.getRow(row_for_account_creation+1).getCell(column_for_account_creation+5).getStringCellValue();
	        String automated_addon_price = sheet.getRow(row_for_account_creation+1).getCell(column_for_account_creation+7).getStringCellValue();


	        String default_addon_item = sheet.getRow(row_for_account_creation+1).getCell(column_for_account_creation).getStringCellValue();
	        String default_addon_quantity = sheet.getRow(row_for_account_creation+1).getCell(column_for_account_creation+2).getStringCellValue();
	        String default_addon_duration = sheet.getRow(row_for_account_creation+1).getCell(column_for_account_creation+4).getStringCellValue();
	        String default_addon_price = sheet.getRow(row_for_account_creation+1).getCell(column_for_account_creation+6).getStringCellValue();


	        if(automated_addon_item.equals(default_addon_item)
	                && automated_addon_quantity.equals(default_addon_quantity)
	                && automated_addon_duration.equals(default_addon_duration)
	                && automated_addon_price.equals(default_addon_price))
	        {
	            sheet.getRow(row_for_account_creation+1).createCell(column_for_account_creation+8).setCellValue("Pass");

	        }
	        else
	        {
	            sheet.getRow(row_for_account_creation+1).createCell(column_for_account_creation+8).setCellValue("Fail");
	        }




	        String addon2_item= driver.findElement(By.xpath("(//p[@class='item_name addon'])[2]")).getText();
	        System.out.println(addon2_item);
	        sheet.getRow(row_for_account_creation+2).createCell(column_for_account_creation+1).setCellValue(addon2_item);


	        String addon2_quantity= driver.findElement(By.xpath("(//label[@class='input'])[2]")).getText();
	        System.out.println(addon2_quantity);
	        sheet.getRow(row_for_account_creation+2).createCell(column_for_account_creation+3).setCellValue(addon2_quantity);

	        String addon2_duration= driver.findElement(By.xpath("//div[@id='order-summary']/div[1]/div[2]/div[4]/div[1]/div[3]/div[2]")).getText();
	        System.out.println(addon2_duration);
	        sheet.getRow(row_for_account_creation+2).createCell(column_for_account_creation+5).setCellValue(addon2_duration);

	        String addon2_price= driver.findElement(By.xpath("(//div[@class='CartSubTotal addon'])[2]")).getText();
	        System.out.println(addon2_price);
	        sheet.getRow(row_for_account_creation+2).createCell(column_for_account_creation+7).setCellValue(addon2_price);




	        String automated_addon2_item= sheet.getRow(row_for_account_creation+2).getCell(column_for_account_creation+1).getStringCellValue();
	        String automated_addon2_quantity = sheet.getRow(row_for_account_creation+2).getCell(column_for_account_creation+3).getStringCellValue();
	        String automated_addon2_duration = sheet.getRow(row_for_account_creation+2).getCell(column_for_account_creation+5).getStringCellValue();
	        String automated_addon2_price = sheet.getRow(row_for_account_creation+2).getCell(column_for_account_creation+7).getStringCellValue();


	        String default_addon2_item = sheet.getRow(row_for_account_creation+2).getCell(column_for_account_creation).getStringCellValue();
	        String default_addon2_quantity = sheet.getRow(row_for_account_creation+2).getCell(column_for_account_creation+2).getStringCellValue();
	        String default_addon2_duration = sheet.getRow(row_for_account_creation+2).getCell(column_for_account_creation+4).getStringCellValue();
	        String default_addon2_price = sheet.getRow(row_for_account_creation+2).getCell(column_for_account_creation+6).getStringCellValue();


	        if(automated_addon2_item.equals(default_addon2_item)
	                && automated_addon2_quantity.equals(default_addon2_quantity)
	                && automated_addon2_duration.equals(default_addon2_duration)
	                && automated_addon2_price.equals(default_addon2_price))
	        {
	            sheet.getRow(row_for_account_creation+2).createCell(column_for_account_creation+8).setCellValue("Pass");

	        }
	        else
	        {
	            sheet.getRow(row_for_account_creation+2).createCell(column_for_account_creation+8).setCellValue("Fail");
	        }



	        String linux_subtotal=  driver.findElement(By.xpath("(//span[@class='right-prices'])[1]")).getText();
	        System.out.println(linux_subtotal);
	        sheet.getRow(row_for_account_creation+4).createCell(column_for_account_creation+7).setCellValue(linux_subtotal);
	        

	        String linux_discount=  driver.findElement(By.xpath("(//span[@class='right-prices'])[2]")).getText();
	        System.out.println(linux_discount);
	        sheet.getRow(row_for_account_creation+5).createCell(column_for_account_creation+7).setCellValue(linux_discount);
	        
	        
	        String total=  driver.findElement(By.xpath("(//span[@class='right-prices'])[3]")).getText();
	        System.out.println(total);
	        sheet.getRow(row_for_account_creation+6).createCell(column_for_account_creation+7).setCellValue(total);



	        String automated_linux_subtotal= sheet.getRow(row_for_account_creation+4).getCell(column_for_account_creation+7).getStringCellValue();
	        String automated_linux_discount = sheet.getRow(row_for_account_creation+5).getCell(column_for_account_creation+7).getStringCellValue();
	        String automated_linux_total = sheet.getRow(row_for_account_creation+6).getCell(column_for_account_creation+7).getStringCellValue();



	        String default_linux_subtotal = sheet.getRow(row_for_account_creation+4).getCell(column_for_account_creation+6).getStringCellValue();
	        String default_linux_discount = sheet.getRow(row_for_account_creation+5).getCell(column_for_account_creation+6).getStringCellValue();
	        String default_linux_total = sheet.getRow(row_for_account_creation+6).getCell(column_for_account_creation+6).getStringCellValue();


	        if(automated_linux_subtotal.equals(default_linux_subtotal))
	        {
	            sheet.getRow(row_for_account_creation+4).createCell(column_for_account_creation+8).setCellValue("Pass");

	        }
	        else
	        {
	            sheet.getRow(row_for_account_creation+4).createCell(column_for_account_creation+8).setCellValue("Fail");
	        }
	        
	        if(automated_linux_discount.equals(default_linux_discount))
	        {
	            sheet.getRow(row_for_account_creation+5).createCell(column_for_account_creation+8).setCellValue("Pass");

	        }
	        else
	        {
	            sheet.getRow(row_for_account_creation+5).createCell(column_for_account_creation+8).setCellValue("Fail");
	        }

	        if(automated_linux_total.equals(default_linux_total))
	        {
	            sheet.getRow(row_for_account_creation+6).createCell(column_for_account_creation+8).setCellValue("Pass");

	        }
	        else
	        {
	            sheet.getRow(row_for_account_creation+6).createCell(column_for_account_creation+8).setCellValue("Fail");
	        }


	        FileOutputStream fos = new FileOutputStream(source);
	        wb.write(fos);
	        wb.close();

	        Thread.sleep(10000);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
