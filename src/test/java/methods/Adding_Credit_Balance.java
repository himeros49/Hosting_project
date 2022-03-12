package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Adding_Credit_Balance extends BaseClass {
	
	
	public static void add_credit_balance(WebDriver driver) throws Exception
	{
		
			//Transaction Type*
		Select dropdown = new Select(driver.findElement(By.id("transactiontype")));
			dropdown.selectByIndex(2);
			Thread.sleep(3000);
			
			
			//Transaction Category*
			Select dropdown2 = new Select(driver.findElement(By.id("category")));
			dropdown2.selectByIndex(1);
			Thread.sleep(3000);
			
			//Date*
			driver.findElement(By.id("tdate")).sendKeys(getTodaysDate());
			driver.findElement(By.id("tdate")).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			
			
			//Transaction Description*
			driver.findElement(By.xpath("(//input[@id='description'])[2]")).sendKeys("Hi I am Dobby");
			
			
			//Payment Method
			Select dropdown3 = new Select(driver.findElement(By.id("payment")));
			dropdown3.selectByIndex(5);
			Thread.sleep(3000);
			
			
			//Invoice Number Tick other Options(Checkbox options)
			driver.findElement(By.xpath("//input[@id='other_inv']/following-sibling::span[1]")).click();
			Thread.sleep(3000);
			
			
			//Invoice Number
			String invoice_number = randomnumber(5); 
			driver.findElement(By.id("other_inv_number")).sendKeys(invoice_number);
			System.out.println(invoice_number);
			
			//Description*
			driver.findElement(By.id("other_item_desc")).sendKeys("I am a house-elf protagonist ");
			
			
			//Rate*
			driver.findElement(By.id("other_item_unit_price")).sendKeys("500");
			
			
			//Billing Period*
			driver.findElement(By.id("other_item_start_billing_date")).sendKeys(getTodaysDate());
			driver.findElement(By.id("other_item_start_billing_date")).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			//to
			driver.findElement(By.id("other_item_end_billing_date")).sendKeys(getfurtherDate(10));
			driver.findElement(By.id("other_item_end_billing_date")).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			
			
			//Save Button
			driver.findElement(By.id("submit")).click();
		
	
		
	}
	
	
	
	
	

}
