package methods;

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
		invoice_date.sendKeys(getfurtherDate(5));
		invoice_date.sendKeys(Keys.ENTER);
		
		
		//Invoice type
		try {
			
		logger.info("Try block");
		//Select State By value
		WebElement invoice_type = driver.findElement(By.id("invoice_type"));

		Select DropDowninvoice= new Select(invoice_type);

		DropDowninvoice.selectByVisibleText("Fresh");

		Thread.sleep(2000);

		}
		catch (Exception x)
		{
			logger.info("Catch block");
			
			//Select by index
			WebElement invoice_type = driver.findElement(By.id("invoice_type"));

			Select DropDowninvoice= new Select(invoice_type);

			DropDowninvoice.selectByIndex(0);

			Thread.sleep(2000);
		}
		
		
		
		//Subscription
		 WebElement subscription = driver.findElement(By.xpath("//span[text()='Select']"));
		 subscription.click();
		 Thread.sleep(3000);
		 
		 driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		
		 
		 
		 //Subscription/Addon
		 driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		 try {
				
				logger.info("Try block");
				//Select State By value
				WebElement subscription_type = driver.findElement(By.name("group[1][billitem][1][invoice_billitem]"));

				Select DropDownplan= new Select(subscription_type);

				DropDownplan.selectByVisibleText("Subscription");

				Thread.sleep(2000);

				}
				catch (Exception x)
				{
					logger.info("Catch block");
					
					//Select State By value
					WebElement subscription_type = driver.findElement(By.name("group[1][billitem][1][invoice_billitem]"));

					Select DropDownplan= new Select(subscription_type);

					DropDownplan.selectByIndex(2);
					
					Thread.sleep(2000);
				}
		 
		 
		 
		 //Billing Period
		 WebElement start_date =  driver.findElement(By.id("group[1][billitem][1][sdate]"));
		 start_date.sendKeys(getTodaysDate());
		 Thread.sleep(2000);
		 start_date.sendKeys(Keys.ENTER);
		 
		 WebElement end_date = driver.findElement(By.id("group[1][billitem][1][edate]"));
		 end_date.sendKeys(getfurtherDate(10));
		 end_date.sendKeys(Keys.ENTER);
		
		 
		 //Quantity
		 driver.findElement(By.id("group[1][billitem][1][quantity]")).sendKeys("1");
		 Thread.sleep(5000);
		 
		 
		 //Unit Price
		 driver.findElement(By.id("group[1][billitem][1][unit_price]")).sendKeys("10");///$10
		 Thread.sleep(5000);
		
		 
		 //Discount
		 driver.findElement(By.id("group[1][billitem][1][unit_price]")).sendKeys("1");///$1
		 Thread.sleep(5000);
		
		
		 driver.findElement(By.id("group[1][billitem][1][unit_price]")).click();
		 Thread.sleep(7000);
		
		
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#alert-msg-flash-success>div:nth-of-type(2)")));

			WebElement success_msg = driver.findElement(By.cssSelector("div#alert-msg-flash-success>div:nth-of-type(2)"));
			
		}
		catch(Exception x)
		{
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='alert-text'])[3]")));

			WebElement success_msg = driver.findElement(By.xpath("(//div[@class='alert-text'])[3]"));
			
		}
		
		driver.findElement(By.linkText("Invoices")).click();
		Thread.sleep(7000);
		
		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[2]/a[1]")).click();
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
