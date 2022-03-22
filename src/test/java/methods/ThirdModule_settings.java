package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ThirdModule_settings extends BaseClass{
	
	
	public static WebDriver change_to_third_module(WebDriver driver,String plan) throws Exception
	{
		//Select Hosting
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Hosting']")));
		driver.findElement(By.xpath("//a[@title='Hosting']")).click();
		Thread.sleep(5000);

		//Select cPanel
		driver.findElement(By.xpath("//a[@title='cPanel']")).click();
		Thread.sleep(5000);

		//Select Linux
		driver.findElement(By.xpath("//a[@title='Linux Hosting New']")).click();
		Thread.sleep(5000);

		//Select Gold
		driver.findElement(By.partialLinkText("Gold")).click();
		Thread.sleep(5000);
		
		//Module Settings
		driver.findElement(By.partialLinkText("Module Settings")).click();
		Thread.sleep(5000);
		
	{
		try
		{
			WebElement provisioning_setting  =  driver.findElement(By.name("autosetup"));
			Select provisioning_setting_dropdown = new Select(provisioning_setting);
			try {
			provisioning_setting_dropdown.selectByIndex(2);
			}
			
			catch(Exception x)
			{
				provisioning_setting_dropdown.selectByValue("on");
			}
			
			Thread.sleep(3000);
		}
		catch(Exception x)
		{
			WebElement provisioning_setting = driver.findElement(By.cssSelector("form#update_module_settings>div:nth-of-type(2)>div>div>select"));
			Select provisioning_setting_dropdown = new Select(provisioning_setting);
			try {
				provisioning_setting_dropdown.selectByIndex(2);
				}
				
				catch(Exception y)
				{
					provisioning_setting_dropdown.selectByValue("on");
				}
		}
		
		driver.findElement(By.id("module_setting_btn")).click();
		
		
		try 
		{
			logger.info("I am in try block waiting for 3rd module to be changed");
		WebDriverWait wait2 = new WebDriverWait(driver, 60);
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='alert-text'])[3]")));
		
		}
		catch(Exception x)
		{
			logger.info("I am in catch block ");
			logger.info("I think it ain't goin' to be change");
			WebDriverWait wait2 = new WebDriverWait(driver, 50);
			wait2.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#alert-msg-flash-success>div:nth-of-type(2)")));
		}
		
		Thread.sleep(5000);
		
	}
		

		//Open Offer Link
		driver.findElement(By.partialLinkText("Offer Links")).click();
		Thread.sleep(3000);
		
		
		
		//Selecting plan
		if(plan.equalsIgnoreCase("monthly"))
		{
		
		//Opening monthly Plan link
		//String monthly_plan = driver.findElement(By.xpath("//table[@class='table table-bordered']//tr[2]//td[2]")).getText();
			String monthly = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[2]/td[2]")).getText();
			
			driver = Switch_tab.switch_next_tab2(driver); 
			
	        driver.get(monthly);
		

		}
		else if(plan.equalsIgnoreCase("Quarterly"))
		{
			
				//Opening Quarterly Plan link
				String Quarterly = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[3]/td[2]")).getText();
				driver.get(Quarterly);
		
		}
		else if(plan.equalsIgnoreCase("Semi_Annually"))
				{
					
				//Opening Semi-Annually Plan link
				String Semi_Annually = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[4]/td[2]")).getText();
				driver.get(Semi_Annually);
				
				}
		else if(plan.equalsIgnoreCase("Annually"))
				{
					
				//Opening Annually Plan link
				String Annually = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[5]/td[2]]")).getText();
				driver.get(Annually);
				
				}
		else if(plan.equalsIgnoreCase("Biennially"))
				{
					
				//Opening Biennially Plan link
				String Biennially = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[6]/td[2]")).getText();
				driver.get(Biennially);
				
				}
		else if(plan.equalsIgnoreCase("Triennially"))
				{
					
				//Opening Triennially Plan link
				String Triennially = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[7]/td[2]")).getText();
				driver.get(Triennially);
				
				}
		else if(plan.equalsIgnoreCase("Quadrennial"))
				{
					
				//Opening Quadrennial Plan link
				String Quadrennial = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[8]/td[2]")).getText();
				driver.get(Quadrennial);
				
				}
		else if(plan.equalsIgnoreCase("Quinquennial"))
				{
					
				//Opening Quinquennial Plan link
				String Quinquennial = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[9]/td[2]")).getText();
				driver.get(Quinquennial);
				
				}
		else if(plan.equalsIgnoreCase("Decennial"))
				{
					
				//Opening Decennial Plan link
				String Decennial = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[10]/td[2]")).getText();
				driver.get(Decennial);
				
				}
		
		
		open_link : 
		
		
		
			
		
		
		return driver;
		
	}

}
