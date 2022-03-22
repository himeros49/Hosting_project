package methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Receipt extends BaseClass{
	
	
	
	//Fill The Receipt Page 
	public static void add_receipt(WebDriver driver) throws Exception
	{
		String TransactionID =  randomnumber(8);
		driver.findElement(By.id("tran_id")).sendKeys(TransactionID);
		Thread.sleep(1000);
		
		
		driver.findElement(By.id("description")).sendKeys("Last of Us");
		Thread.sleep(1000);
	
		
		driver.findElement(By.id("tdate")).sendKeys(getTodaysDate());
		driver.findElement(By.id("tdate")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		
		String Invoice_number = randomstring(3)+ randomnumber(5); 
		driver.findElement(By.id("invoice_num")).sendKeys(Invoice_number);
		Thread.sleep(1000);
		
		
		driver.findElement(By.id("amount")).sendKeys("500");
		Thread.sleep(1000);
		
		
		Select payment_method = new Select(driver.findElement(By.id("paymentmethod")));
		payment_method.selectByIndex(5);
		Thread.sleep(3000);
		
		
		driver.findElement(By.id("submit_btn")).click();;
		
				
		// explicit wait - to wait for the message to be displayed
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(.,'has been added successfully.')])[8]")));
		
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	}
	
	
	
	
	
	//Capture Details Of Receipt Page 
	public static void capture_details_of_receipt(WebDriver driver,String name_of_sheet) throws Exception
	{
		
		Switch_tab.switch_next_tab(driver);
		
		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(name_of_sheet);
		
		
		/*
		 (//table[@class='invoice']//table)[2]/tbody[1]/tr[2-6]/td[1]
		  
		  (//table[@class='invoice']//table)[2]/tbody[1]/tr[2-6]/td[2]
		  
		  
		  
		  
		 */
		
		
		for(int i=2; i <7; i++ )
		{
			
			String receipt_values = driver.findElement(By.xpath("(//table[@class='invoice']//table)[2]/tbody[1]/tr["+ i +"]/td[2]")).getText();
			sheet.createRow(i + 70).createCell(1).setCellValue(receipt_values);
		}
	
		
		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
		fi.close();
		fos.close();
		
		Thread.sleep(2000);
		
//		driver.close();
		
		Switch_tab.switch_previous_tab2(driver);
		
		driver.navigate().refresh();
		
		Thread.sleep(5000);
		
	}
	
	
	
	
	
	

}
