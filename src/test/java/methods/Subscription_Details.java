package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Subscription_Details extends BaseClass{
	
	
	
	public static void turn_off_renewable(WebDriver driver) throws Exception
	{
		WebElement Auto_renewal= driver.findElement(By.id("auto_renewal_action"));
		
		try {
			
		logger.info("auto renewable try block--->method Subscription_Details");
		Select Auto_renewal_dropdown = new Select(Auto_renewal);
		Auto_renewal_dropdown.selectByVisibleText("OFF");
		Thread.sleep(5000);
		
		}
		catch(Exception x)
		{
			logger.info("auto renewable catch block--->method Subscription_Details");
			Select Auto_renewal_dropdown = new Select(Auto_renewal);
			Auto_renewal_dropdown.selectByIndex(0);
			Thread.sleep(5000);
		}
		
		
		driver.findElement(By.cssSelector("a#submit_btn")).click();
		
		try {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#alert-msg-flash-success>div:nth-of-type(2)")));
		}
		catch(Exception x)
		{
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='alert-text'])[3]")));
		}
		
	}
		
	
	public static void turn_on_renewable(WebDriver driver) throws Exception
	{
		WebElement Auto_renewal= driver.findElement(By.id("auto_renewal_action"));
		
		try {
			
		logger.info("auto renewable try block--->method Subscription_Details");
		Select Auto_renewal_dropdown = new Select(Auto_renewal);
		Auto_renewal_dropdown.selectByVisibleText("ON");
		Thread.sleep(5000);
		
		}
		catch(Exception x)
		{
			logger.info("auto renewable catch block--->method Subscription_Details");
			Select Auto_renewal_dropdown = new Select(Auto_renewal);
			Auto_renewal_dropdown.selectByIndex(1);
			Thread.sleep(5000);
		}
		
		
		driver.findElement(By.cssSelector("a#submit_btn")).click();
		
		try {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#alert-msg-flash-success>div:nth-of-type(2)")));
		}
		catch(Exception x)
		{
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='alert-text'])[3]")));
		}
		
	}
	

	public static void create_addon(WebDriver driver) throws InterruptedException {
	
	try 
	{
		driver.findElement(By.cssSelector("a#create_addon_services")).click();
		Thread.sleep(5000);
	}
	catch(Exception x)
	{
		driver.findElement(By.linkText("Create Addon")).click();
		Thread.sleep(5000);
	}
	
	WebElement Hosting_quantity = driver.findElement(By.id("quantity_98_73"));
	Hosting_quantity.click();
	Thread.sleep(5000);
//	Hosting_quantity.clear();
//	Thread.sleep(5000);
	Hosting_quantity.sendKeys("1");
	Thread.sleep(7000);
	
	//select button
	driver.findElement(By.id("selectproduct_98_73")).click();
	Thread.sleep(7000);
	
	WebElement Hosting_managed_percentage =driver.findElement(By.id("quantity_98_74"));
	Hosting_managed_percentage.click();
	Thread.sleep(5000);
//	Hosting_managed_percentage.clear();
//	Thread.sleep(5000);
	Hosting_managed_percentage.sendKeys("1");
	Thread.sleep(7000);
	
	//select button
	driver.findElement(By.id("selectproduct_98_74")).click();
	Thread.sleep(7000);
	
	
	
	//place Order
	driver.findElement(By.id("submit_order")).click();
	Thread.sleep(10000);
	
	
	try {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#alert-msg-flash-success>div:nth-of-type(2)")));
		}
		catch(Exception x)
		{
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='alert-text'])[3]")));
		}
	
	
		}
	
	

}
