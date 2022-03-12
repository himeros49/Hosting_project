package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Auto_Renewable {
	
	
	
		public static void go_to_subscription_details_page(WebDriver driver) throws Exception
		{
			//Click on Subscription
			driver.findElement(By.id("(//span[text()='Subscriptions'])[3]")).click();	
			Thread.sleep(2000);
			
			//Again click on Subscription
			driver.findElement(By.xpath("(//span[text()='Subscriptions'])[4]")).click();
			Thread.sleep(2000);
			
			//Click on plan bought
			driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[2]/a[1]")).click();
	
		}
	

		public static void auto_renewable_on(WebDriver driver) throws Exception {
			
			//This method only be called when user is on Subscription Details Page
			
			Select dropdown = new Select (driver.findElement(By.name("auto_renewal_action")));
			dropdown.selectByVisibleText("ON");
			Thread.sleep(2000);
			
			driver.findElement(By.cssSelector("a#submit_btn"));
			
			// explicit wait - to wait for the message to be displayed
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Subscription details have been updated successfully.']")));
			
			driver.navigate().back();
		}
	
		
		public static void auto_renewable_off(WebDriver driver) throws Exception {
			
			//This method only be called when user is on Subscription Details Page
			
			Select dropdown = new Select (driver.findElement(By.name("auto_renewal_action")));
			dropdown.selectByVisibleText("OFF");
			Thread.sleep(2000);
			
			driver.findElement(By.cssSelector("a#submit_btn"));
			
			// explicit wait - to wait for the message to be displayed
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Subscription details have been updated successfully.']")));
			
			driver.navigate().back();
		}
	

}
