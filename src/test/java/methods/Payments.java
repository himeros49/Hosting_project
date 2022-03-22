package methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Payments extends BaseClass {
	
	
	public static void payment_with_bank(WebDriver driver, String nameofsheet) throws Exception
	{
		try {
		driver.findElement(By.id("make_payment")).click();
		Thread.sleep(3000);
		
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("banktransfer")));
		
		}
		catch(Exception x)
		{
			driver.navigate().refresh();
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("make_payment")));
			driver.findElement(By.id("make_payment")).click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("banktransfer")));
			
		}
		
		
		driver.findElement(By.id("banktransfer")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@class='confirm btn btn-lg btn-warning']")).click();

		Thread.sleep(5000);
		
		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(nameofsheet);


		String Order_Successfull = driver.findElement(By.xpath("//div[contains(@class,'message')]")).getText();
		sheet.getRow(34).createCell(1).setCellValue(Order_Successfull);
		System.out.println(Order_Successfull);

		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();

		Thread.sleep(5000);		
		
	}
	
	
	
	public static void payment_with_paypal(WebDriver driver,String name_of_sheet) throws Exception {
		
		
		String paypal_email = readconfig.getpaypal_username();
		String paypal_password = readconfig.getpaypal_password();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("make_payment")));
		
		try {
			driver.findElement(By.id("make_payment")).click();
			Thread.sleep(3000);
			
			
			WebDriverWait wait3 = new WebDriverWait(driver, 40);
			wait3.until(ExpectedConditions.presenceOfElementLocated(By.id("paypal")));
			
			}
			catch(Exception x)
			{
				driver.navigate().refresh();
				WebDriverWait wait3 = new WebDriverWait(driver, 40);
				wait3.until(ExpectedConditions.presenceOfElementLocated(By.id("make_payment")));
				driver.findElement(By.id("make_payment")).click();
				wait3.until(ExpectedConditions.presenceOfElementLocated(By.id("paypal")));
				
			}

		driver.findElement(By.id("paypal")).click();
		Thread.sleep(3000);

		try {

		WebDriverWait wait3 = new WebDriverWait(driver, 30);
		wait3.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[@class='confirm btn btn-lg btn-warning']")));	
		//ok button
		driver.findElement(By.xpath("//button[@class='confirm btn btn-lg btn-warning']")).click();
		
		}
		catch(Exception x )
		{
			driver.findElement(By.id("paypal")).click();
			Thread.sleep(3000);
			WebDriverWait wait3 = new WebDriverWait(driver, 30);
			wait3.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[@class='confirm btn btn-lg btn-warning']")));	
			//ok button
			driver.findElement(By.xpath("//button[@class='confirm btn btn-lg btn-warning']")).click();	
		}
		
		
		Thread.sleep(10000);
			
		driver.findElement(By.id("email")).sendKeys(paypal_email);
		//Thread.sleep(3000);	
		
		driver.findElement(By.id("btnNext")).click();
		//Thread.sleep(3000);		
		
		driver.findElement(By.id("password")).sendKeys(paypal_password);
		//Thread.sleep(3000);
		
		
		WebDriverWait wait7 = new WebDriverWait(driver, 30);
		wait7.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("btnLogin")));
		driver.findElement(By.id("btnLogin")).click();
		//Thread.sleep(3000);
		
		try 
		{
		driver.findElement(By.id("payment-submit-btn")).click();
		Thread.sleep(20000);
		}
		
		catch(Exception x)
		{
			WebElement pay_btn = driver.findElement(By.id("payment-submit-btn"));
			//Creating the JavascriptExecutor interface object by Type casting		
	        JavascriptExecutor js = (JavascriptExecutor)driver;
	        
	        //Declare and set the start time		
	        long start_time = System.currentTimeMillis();			
	        
	        //Call executeAsyncScript() method to wait for 5 seconds		
	        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
	        
	        //Perform Click on LOGIN button using JavascriptExecutor		
	        js.executeScript("arguments[0].click();", pay_btn);
	        
	        
	        //Get the difference (currentTime - startTime)  of times.		
	        System.out.println("Passed time: " + (System.currentTimeMillis() - start_time));
	        
		}
		
		//Verification 
		
		
		try {
			 logger.info("try block");
		WebDriverWait waitforsuccess = new WebDriverWait(driver, 30);
		waitforsuccess.until(ExpectedConditions.visibilityOfElementLocated(By.className("paymentsuccess")));

		String success= driver.findElement(By.className("paymentsuccess")).getText();
		System.out.println(success);

		//Location Of Excel Sheet
		String xlpath = System.getProperty("user.dir") + "/src/main/resources/Q11-Hosting.xlsx";
		
		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(name_of_sheet);

		String Order_Successfull = driver.findElement(By.className("paymentsuccess")).getText();
		sheet.getRow(14).createCell(5).setCellValue(Order_Successfull);
		System.out.println(Order_Successfull);

		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
		fi.close();
		fos.close();
		Thread.sleep(5000);	
		
		}
		
		catch(Exception x)
		{
			logger.info("catch block");
			WebDriverWait waitforsuccess = new WebDriverWait(driver, 30);
			waitforsuccess.until(ExpectedConditions.visibilityOfElementLocated(By.className("paymentsuccess")));

			String success= driver.findElement(By.className("paymentsuccess")).getText();
			System.out.println(success);

			//Location Of Excel Sheet
			String xlpath = System.getProperty("user.dir") + "/src/main/resources/Q11-Hosting.xlsx";
			
			File source = new File(xlpath);
			FileInputStream fi = new FileInputStream(source);
			XSSFWorkbook wb = new XSSFWorkbook(fi);
			XSSFSheet sheet = wb.getSheet(name_of_sheet);

			String Order_Successfull = driver.findElement(By.xpath("//div[contains(@class,'message')]")).getText();
			sheet.getRow(14).createCell(5).setCellValue(Order_Successfull);
			System.out.println(Order_Successfull);

			FileOutputStream fos = new FileOutputStream(source);
			wb.write(fos);
			wb.close();
			fi.close();
			fos.close();
			Thread.sleep(5000);
		}
		
		
		

	}
	
	

}
