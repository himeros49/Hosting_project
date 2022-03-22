package methods_for_member_panel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Top_up {
	
	
	public static void recharge_my_account(WebDriver driver) throws Exception
	{
		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@class,'btn m-btn--pill')]"))).click();
		
//		WebElement top_up = driver.findElement(By.xpath("//a[contains(@class,'btn m-btn--pill')]"));
//		top_up.click();
		
		
		
		WebDriverWait wait_for_payment_gateway = new WebDriverWait(driver, 50);
		wait_for_payment_gateway.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//strong[text()='Paypal']/following-sibling::span")));

		//Paypal Button
		WebElement paypal_bal = driver.findElement(By.xpath("//strong[text()='Paypal']/following-sibling::span"));
		if(paypal_bal.isDisplayed())
		{
			paypal_bal.click();
			Thread.sleep(5000);
			//OK button
			driver.findElement(By.xpath("//button[contains(@class,'swal2-confirm btn')]")).click();
		}
		
		
		
		
		
	}

	
	
	
	
}
