package methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Custom_invoice extends BaseClass {


	public static void fill_generate_custom_invoice_for_admin_panel(WebDriver driver) throws Exception {

		//Invoice Date
		WebElement invoice_date = driver.findElement(By.id("invoice_date"));
		invoice_date.click();
		Thread.sleep(2000);
		invoice_date.clear();
		Thread.sleep(2000);
		invoice_date.sendKeys(getfurtherDate(5));
		Thread.sleep(2000);
		invoice_date.sendKeys(Keys.ENTER);
		Thread.sleep(2000);


		//Invoice type
		try {

			logger.info("Try block");
			//Select State By value
			WebElement invoice_type = driver.findElement(By.id("invoice_type"));

			Select DropDowninvoice= new Select(invoice_type);

			DropDowninvoice.selectByVisibleText("Fresh");

			Thread.sleep(5000);

		}
		catch (Exception x)
		{
			logger.info("Catch block");

			//Select by index
			WebElement invoice_type = driver.findElement(By.id("invoice_type"));

			Select DropDowninvoice= new Select(invoice_type);

			DropDowninvoice.selectByIndex(0);

			Thread.sleep(5000);
		}



		//Subscription
		WebElement subscription = driver.findElement(By.xpath("//span[text()='Select']"));
		subscription.click();
		Thread.sleep(3000);
		//Choose plan(Linux Hosting New Gold)
		driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		Thread.sleep(5000);



		//Subscription/Addon
		try {

			logger.info("Try block");
			//Select State By value
			WebElement subscription_type = driver.findElement(By.name("group[1][billitem][2][invoice_billitem]"));

			Select DropDownplan= new Select(subscription_type);

			DropDownplan.selectByVisibleText("Subscription");

			WebDriverWait wait1 = new WebDriverWait(driver, 20);
			wait1.until(ExpectedConditions.presenceOfElementLocated(By.name("group[1][billitem][1][sdate]")));

		}
		catch (Exception x)
		{
			logger.info("Catch block");

			//Select State By value
			WebElement subscription_type = driver.findElement(By.name("group[1][billitem][1][invoice_billitem]"));

			Select DropDownplan= new Select(subscription_type);

			DropDownplan.selectByIndex(2);

			WebDriverWait wait1 = new WebDriverWait(driver, 20);
			wait1.until(ExpectedConditions.presenceOfElementLocated(By.name("group[1][billitem][1][sdate]")));
		}



		//Billing Period
		WebElement start_date =  driver.findElement(By.name("group[1][billitem][1][sdate]"));
		start_date.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//table[@class='table-condensed']/tbody[1]/tr[3]/td[6]")).click();


		WebElement end_date = driver.findElement(By.name("group[1][billitem][1][edate]"));
		end_date.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//table[@class='table-condensed']/tbody[1]/tr[4]/td[6]")).click();



		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.name("group[1][billitem][1][quantity]")));


		//Quantity
		driver.findElement(By.name("group[1][billitem][1][quantity]")).sendKeys("1");
		Thread.sleep(5000);


		//Unit Price
		driver.findElement(By.name("group[1][billitem][1][unit_price]")).sendKeys("10");///$10
		Thread.sleep(5000);


		//Discount
		driver.findElement(By.name("group[1][billitem][1][discount_amount]")).sendKeys("1");///$1
		Thread.sleep(5000);



		//		 
		//		 //Add button
		//		 WebElement add = driver.findElement(By.xpath("(//table[@class='invoice']//table)[6]/tbody[1]/tr[18]/td[2]/button[1]/i[1]"));
		//		 add.click();
		//		 Thread.sleep(5000);
		//		 
		//		 // *********ADDONS *********
		//		 
		//		 
		//		//Subscription/Addon
		//		 try {
		//				
		//				logger.info("Try block");
		//				//Select State By value
		//				WebElement subscription_type = driver.findElement(By.name("group[1][billitem][2][invoice_billitem]"));
		//
		//				Select DropDownplan= new Select(subscription_type);
		//
		//				DropDownplan.selectByVisibleText("Addon");
		//
		//				WebDriverWait wait3 = new WebDriverWait(driver, 20);
		//				wait3.until(ExpectedConditions.presenceOfElementLocated(By.name("group[1][billitem][1][sdate]")));
		//
		//				}
		//				catch (Exception x)
		//				{
		//					logger.info("Catch block");
		//					
		//					//Select State By value
		//					WebElement subscription_type = driver.findElement(By.name("group[1][billitem][1][invoice_billitem]"));
		//
		//					Select DropDownplan= new Select(subscription_type);
		//
		//					DropDownplan.selectByIndex(1);
		//					
		//					WebDriverWait wait3 = new WebDriverWait(driver, 20);
		//					wait3.until(ExpectedConditions.presenceOfElementLocated(By.name("group[1][billitem][1][sdate]")));
		//				}
		//		 
		//		 	//Select Addon
		//		 	
		//		 	WebElement addon1 = driver.findElement(By.id("group[1][billitem][2][addon][1][addon_id]"));
		//		 	Select DropDownaddon1= new Select(addon1);
		//
		//		 	DropDownaddon1.selectByIndex(1);
		//
		//			Thread.sleep(5000);
		//			
		//			 //Billing Period
		//			 WebElement start_date_addon1 =  driver.findElement(By.name("group[1][billitem][2][addon][1][sdate]"));
		//			 start_date.click();
		//			 Thread.sleep(3000);
		//			 driver.findElement(By.xpath("//table[@class='table-condensed']/tbody[1]/tr[4]/td[1]")).click();
		//
		//			 
		//			 WebElement end_date_addon1 = driver.findElement(By.name("group[1][billitem][2][addon][1][edate]"));
		//			 end_date.click();
		//			 Thread.sleep(3000);
		//			 driver.findElement(By.xpath("//table[@class='table-condensed']/tbody[1]/tr[4]/td[6]")).click();
		//
		//			 
		//			 
		//			 WebDriverWait wait4 = new WebDriverWait(driver, 20);
		//			 wait4.until(ExpectedConditions.presenceOfElementLocated(By.name("group[1][billitem][2][addon][1][quantity]")));
		//			
		//			 
		//			 //Quantity
		//			 driver.findElement(By.name("group[1][billitem][2][addon][1][quantity]")).sendKeys("1");
		//			 Thread.sleep(5000);
		//			 
		//			 
		//			 //Unit Price
		//			 driver.findElement(By.name("group[1][billitem][2][addon][1][unit_price]")).sendKeys("10");///$10
		//			 Thread.sleep(5000);
		//			
		//			 
		//			 //Discount
		//			 driver.findElement(By.name("group[1][billitem][2][addon][1][discount_amount]")).sendKeys("1");///$1
		//			 Thread.sleep(5000);
		//			 
		//			 
		//			 //Add button
		//			 driver.findElement(By.cssSelector("tbody#invoiceitems>tr:nth-of-type(13)>td:nth-of-type(2)>button>i")).click();
		//			 Thread.sleep(5000);
		//			 
		//			 
		//			 
		//			 
		//			 
		//		 










		//Preview Button
		driver.findElement(By.xpath("(//button[contains(@class,'btn btn-success')])[4]")).click();


		WebDriverWait wait9 =new WebDriverWait(driver, 50);
		wait9.until(ExpectedConditions.presenceOfElementLocated(By.id("generate_invoice")));

		//Generate Invoice
		driver.findElement(By.id("generate_invoice")).click();

		//OK Button
		driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled']")).click();


		try {

			WebDriverWait wait10 = new WebDriverWait(driver, 50);
			wait10.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#alert-msg-flash-success>div:nth-of-type(2)")));

			WebElement success_msg = driver.findElement(By.cssSelector("div#alert-msg-flash-success>div:nth-of-type(2)"));
			System.out.println(success_msg);

		}
		catch(Exception x)
		{
			WebDriverWait wait11 = new WebDriverWait(driver, 50);
			wait11.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='alert-text'])[3]")));

			WebElement success_msg = driver.findElement(By.xpath("(//div[@class='alert-text'])[3]"));
			System.out.println(success_msg);

		}

		driver.findElement(By.linkText("Invoices")).click();
		Thread.sleep(7000);

		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[2]/a[1]")).click();


	}




	public static void capture_data_of_custom_invoice_admin_panel(WebDriver driver,String name_of_the_sheet) throws Exception
	{

		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(name_of_the_sheet);


		Thread.sleep(5000);

		//INVOICE
		String Invoice_Number= driver.findElement(By.xpath("(//table[@class='invoice']//table)[3]/tbody[1]/tr[1]/td[2]")).getText();
		sheet.getRow(73).createCell(1).setCellValue(Invoice_Number);
		System.out.println(Invoice_Number);

		String Invoice_Date= driver.findElement(By.xpath("(//table[@class='invoice']//table)[3]/tbody[1]/tr[2]/td[2]")).getText();
		sheet.getRow(74).createCell(1).setCellValue(Invoice_Date);
		System.out.println(Invoice_Date);

		String Invoice_Due_Date= driver.findElement(By.xpath("(//table[@class='invoice']//table)[4]/tbody[1]/tr[1]/td[2]")).getText();
		sheet.getRow(75).createCell(1).setCellValue(Invoice_Due_Date);
		System.out.println(Invoice_Due_Date);

		String Invoice_Unpaid= driver.findElement(By.xpath("(//table[@class='invoice']//table)[4]/tbody[1]/tr[2]/td[1]/b[1]")).getText();
		sheet.getRow(76).createCell(1).setCellValue(Invoice_Unpaid);
		System.out.println(Invoice_Unpaid);


		XSSFRow row_Invoice_Goods_description_Linux = sheet.getRow(80);

		
		String Invoice_Goods_description_Linux= driver.findElement(By.xpath("(//table[@class='invoice']//table)[8]/tbody[1]/tr[2]/td[2]")).getText();
		row_Invoice_Goods_description_Linux.createCell(0).setCellValue(Invoice_Goods_description_Linux);
		System.out.println(Invoice_Goods_description_Linux);

		String Invoice_Goods_description_Linux_HSC_Code= driver.findElement(By.xpath("(//table[@class='invoice']//table)[8]/tbody[1]/tr[2]/td[3]")).getText();
		row_Invoice_Goods_description_Linux.createCell(1).setCellValue(Invoice_Goods_description_Linux_HSC_Code);
		System.out.println(Invoice_Goods_description_Linux_HSC_Code);

		String Invoice_Goods_description_Linux_quantity= (String) driver.findElement(By.xpath("(//table[@class='invoice']//table)[8]/tbody[1]/tr[2]/td[4]")).getText();
		row_Invoice_Goods_description_Linux.createCell(2).setCellValue(Invoice_Goods_description_Linux_quantity);
		System.out.println(Invoice_Goods_description_Linux_quantity);

		String Invoice_Goods_description_Linux_UOM= driver.findElement(By.xpath("(//table[@class='invoice']//table)[8]/tbody[1]/tr[2]/td[5]")).getText();
		row_Invoice_Goods_description_Linux.createCell(3).setCellValue(Invoice_Goods_description_Linux_UOM);
		System.out.println(Invoice_Goods_description_Linux_UOM);

		String Invoice_Goods_description_Linux_Rate= driver.findElement(By.xpath("(//table[@class='invoice']//table)[8]/tbody[1]/tr[2]/td[6]")).getText();
		row_Invoice_Goods_description_Linux.createCell(4).setCellValue(Invoice_Goods_description_Linux_Rate);
		System.out.println(Invoice_Goods_description_Linux_Rate);

		String Invoice_Goods_description_Linux_Total= driver.findElement(By.xpath("(//table[@class='invoice']//table)[8]/tbody[1]/tr[2]/td[7]")).getText();
		row_Invoice_Goods_description_Linux.createCell(5).setCellValue(Invoice_Goods_description_Linux_Total);
		System.out.println(Invoice_Goods_description_Linux_Total);

		String Invoice_Goods_description_Linux_Discount= driver.findElement(By.xpath("(//table[@class='invoice']//table)[8]/tbody[1]/tr[2]/td[8]")).getText();
		row_Invoice_Goods_description_Linux.createCell(6).setCellValue(Invoice_Goods_description_Linux_Discount);
		System.out.println(Invoice_Goods_description_Linux_Discount);

		String Invoice_Goods_description_Linux_Taxable_value= driver.findElement(By.xpath("(//table[@class='invoice']//table)[8]/tbody[1]/tr[2]/td[9]")).getText();
		row_Invoice_Goods_description_Linux.createCell(7).setCellValue(Invoice_Goods_description_Linux_Taxable_value);
		System.out.println(Invoice_Goods_description_Linux_Taxable_value);

		String Invoice_Total_Discount= driver.findElement(By.xpath("(//table[@class='invoice']//table)[8]/tbody[1]/tr[3]/td[2]")).getText();
		sheet.getRow(81).createCell(7).setCellValue(Invoice_Total_Discount);
		System.out.println(Invoice_Total_Discount);

		String Invoice_SubTotal= driver.findElement(By.xpath("(//table[@class='invoice']//table)[8]/tbody[1]/tr[4]/td[2]")).getText();
		sheet.getRow(82).createCell(7).setCellValue(Invoice_SubTotal);
		System.out.println(Invoice_SubTotal);

		String Invoice_Total_Amount= driver.findElement(By.xpath("(//table[@class='invoice']//table)[8]/tbody[1]/tr[5]/td[2]")).getText();
		sheet.getRow(83).createCell(7).setCellValue(Invoice_Total_Amount);
		System.out.println(Invoice_Total_Amount);
		
		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
		fi.close();
		fos.close();
		



	}

	
	public static void capture_data_of_custom_invoice_partner_panel(WebDriver driver,String name_of_the_sheet) throws Exception
	{

		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(name_of_the_sheet);


		Thread.sleep(5000);

		//INVOICE
		String Invoice_Number= driver.findElement(By.xpath("(//table[@class='invoice']//table)[3]/tbody[1]/tr[1]/td[2]")).getText();
		sheet.getRow(73).createCell(1).setCellValue(Invoice_Number);
		System.out.println(Invoice_Number);

		String Invoice_Date= driver.findElement(By.xpath("(//table[@class='invoice']//table)[3]/tbody[1]/tr[2]/td[2]")).getText();
		sheet.getRow(74).createCell(1).setCellValue(Invoice_Date);
		System.out.println(Invoice_Date);

		String Invoice_Due_Date= driver.findElement(By.xpath("(//table[@class='invoice']//table)[4]/tbody[1]/tr[1]/td[2]")).getText();
		sheet.getRow(75).createCell(1).setCellValue(Invoice_Due_Date);
		System.out.println(Invoice_Due_Date);

		String Invoice_Unpaid= driver.findElement(By.xpath("(//table[@class='invoice']//table)[4]/tbody[1]/tr[2]/td[1]/b[1]")).getText();
		sheet.getRow(76).createCell(1).setCellValue(Invoice_Unpaid);
		System.out.println(Invoice_Unpaid);


		XSSFRow row_Invoice_Goods_description_Linux = sheet.getRow(80);

		
		String Invoice_Goods_description_Linux= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[2]/td[2]")).getText();
		row_Invoice_Goods_description_Linux.createCell(0).setCellValue(Invoice_Goods_description_Linux);
		System.out.println(Invoice_Goods_description_Linux);

		String Invoice_Goods_description_Linux_HSC_Code= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[2]/td[3]")).getText();
		row_Invoice_Goods_description_Linux.createCell(1).setCellValue(Invoice_Goods_description_Linux_HSC_Code);
		System.out.println(Invoice_Goods_description_Linux_HSC_Code);

		String Invoice_Goods_description_Linux_quantity= (String) driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[2]/td[4]")).getText();
		row_Invoice_Goods_description_Linux.createCell(2).setCellValue(Invoice_Goods_description_Linux_quantity);
		System.out.println(Invoice_Goods_description_Linux_quantity);

		String Invoice_Goods_description_Linux_UOM= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[2]/td[5]")).getText();
		row_Invoice_Goods_description_Linux.createCell(3).setCellValue(Invoice_Goods_description_Linux_UOM);
		System.out.println(Invoice_Goods_description_Linux_UOM);

		String Invoice_Goods_description_Linux_Rate= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[2]/td[6]")).getText();
		row_Invoice_Goods_description_Linux.createCell(4).setCellValue(Invoice_Goods_description_Linux_Rate);
		System.out.println(Invoice_Goods_description_Linux_Rate);

		String Invoice_Goods_description_Linux_Total= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[2]/td[7]")).getText();
		row_Invoice_Goods_description_Linux.createCell(5).setCellValue(Invoice_Goods_description_Linux_Total);
		System.out.println(Invoice_Goods_description_Linux_Total);

		String Invoice_Goods_description_Linux_Discount= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[2]/td[8]")).getText();
		row_Invoice_Goods_description_Linux.createCell(6).setCellValue(Invoice_Goods_description_Linux_Discount);
		System.out.println(Invoice_Goods_description_Linux_Discount);

		String Invoice_Goods_description_Linux_Taxable_value= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[2]/td[9]")).getText();
		row_Invoice_Goods_description_Linux.createCell(7).setCellValue(Invoice_Goods_description_Linux_Taxable_value);
		System.out.println(Invoice_Goods_description_Linux_Taxable_value);

		String Invoice_Total_Discount= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[3]/td[2]")).getText();
		sheet.getRow(81).createCell(7).setCellValue(Invoice_Total_Discount);
		System.out.println(Invoice_Total_Discount);

		String Invoice_SubTotal= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[4]/td[2]")).getText();
		sheet.getRow(82).createCell(7).setCellValue(Invoice_SubTotal);
		System.out.println(Invoice_SubTotal);

		String Invoice_Total_Amount= driver.findElement(By.xpath("(//table[@class='invoice']//table)[7]/tbody[1]/tr[5]/td[2]")).getText();
		sheet.getRow(83).createCell(7).setCellValue(Invoice_Total_Amount);
		System.out.println(Invoice_Total_Amount);
		
		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
		fi.close();
		fos.close();
		



	}





















}
