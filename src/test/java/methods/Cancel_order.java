package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Cancel_order {
	
	
	
	public static void cancel_my_order(WebDriver driver) throws Exception
	{
		
		//Cancel Order
		driver.findElement(By.xpath("(//button[contains(@class,'btn btn-secondary')])[2]")).click();
		Thread.sleep(5000);
				
		//Ok button
		driver.findElement(By.xpath("//button[text()='Ok']")).click();
		Thread.sleep(3000);
		
		
		//Cancellation Reason
		WebElement reason_element =  driver.findElement(By.id("cancellation_reason"));
		Select reason_dropdown = new Select(reason_element);
		reason_dropdown.selectByVisibleText("None");
		
		
		//Cancellation Description
		driver.findElement(By.id("cancellation_description")).sendKeys("I don't know, I don't know");
		Thread.sleep(5000);
		
		//Save button
		driver.findElement(By.id("submit_btn_id")).click();
		Thread.sleep(5000);
		
		try {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='alert-text'])[3]")));
		}
		catch(Exception x)
		{
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#alert-msg-flash-success>div:nth-of-type(2)")));
		}
		
	}

}
