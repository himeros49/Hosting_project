package methods_for_member_panel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Renewable_on_off {
	
	
	public static void turn_off_renewable(WebDriver driver) throws Exception
	{
		
		WebElement renewable_notification = driver.findElement(By.name("renewal_notification"));
		Select renewable_notification_dropdown = new Select(renewable_notification);
		renewable_notification_dropdown.selectByVisibleText("OFF");
		
		Thread.sleep(10000);
		try 
		{

			WebElement update_btn = driver.findElement(By.name("update"));
			Actions actions = new Actions(driver);
			actions.moveToElement(update_btn);
			actions.perform();
			actions.click().perform();
			
			System.out.println(update_btn.isEnabled());
			System.out.println(update_btn.isDisplayed());
			

			JavascriptExecutor js = (JavascriptExecutor) driver;
			
//			js.executeScript("arguments[0].scrollIntoView()", update_btn); 
//			
//			js.executeScript("arguments[0].click();", update_btn);
			
			
			
//			js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", update_btn);
			

		}
		catch(Exception x)
		{
			WebElement update_btn = driver.findElement(By.xpath("//input[@value='Update']"));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", update_btn);
		}
		 
		try 
		{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'swal2-confirm btn')]")));
		
		driver.findElement(By.xpath("//button[contains(@class,'swal2-confirm btn')]")).click();
		
		}
		catch(Exception x)
		{
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Ok']")));
			
			driver.findElement(By.xpath("//button[text()='Ok']")).click();
			
		}
		
		
	}
	
	
	public static void turn_on_renewable(WebDriver driver) throws Exception
	{
		
		WebElement renewable_notification = driver.findElement(By.name("renewal_notification"));
		Select renewable_notification_dropdown = new Select(renewable_notification);
		renewable_notification_dropdown.selectByVisibleText("ON");
		
		Thread.sleep(7000);
		
//		try 
//		{
//			WebDriverWait wait = new WebDriverWait(driver, 60);
//			wait.until(ExpectedConditions.presenceOfElementLocated(By.name("update")));
//
//			WebElement update_btn = driver.findElement(By.name("update"));
//			
//			driver.switchTo().activeElement();
//
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].click();", update_btn);
//
//		}
//		catch(Exception x)
//		{
//			WebDriverWait wait = new WebDriverWait(driver, 60);
//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Update']")));
//			
//			WebElement update_btn = driver.findElement(By.xpath("//input[@value='Update']"));
//
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].click();", update_btn);
//		}
//		
//		try 
//		{
//		WebDriverWait wait = new WebDriverWait(driver, 50);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'swal2-confirm btn')]")));
//		
//		driver.findElement(By.xpath("//button[contains(@class,'swal2-confirm btn')]")).click();
//		}
//		catch(Exception x)
//		{
//			WebDriverWait wait = new WebDriverWait(driver, 50);
//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Ok']")));
//			
//			driver.findElement(By.xpath("//button[text()='Ok']")).click();
//			
//		}
	}
	
	
	
	
	
	

}
