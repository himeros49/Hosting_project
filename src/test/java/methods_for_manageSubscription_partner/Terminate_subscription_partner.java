package methods_for_manageSubscription_partner;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Terminate_subscription_partner {
	
	
	
	public static void terminate_my_subscription(WebDriver driver) throws Exception
	{
		
		//Subscription Section present in the left panel
				WebElement subscription =driver.findElement(By.xpath("(//span[text()='Subscriptions'])[3]"));
				JavascriptExecutor js = (JavascriptExecutor)driver;
				
				//Perform Click on button using JavascriptExecutor		
		        js.executeScript("arguments[0].click();", subscription);
		        Thread.sleep(3000);

		        //Sub Subscription
		        WebElement subscription2 = driver.findElement(By.xpath("(//span[text()='Subscriptions'])[4]"));
		        JavascriptExecutor js2 = (JavascriptExecutor)driver;

		        //Perform Click on button using JavascriptExecutor		
		        js2.executeScript("arguments[0].click();", subscription2);
		        Thread.sleep(3000);


		        //choose subscription details 
		        WebElement details = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[2]/a[1]"));
		        JavascriptExecutor js3 = (JavascriptExecutor)driver;

		        //Perform Click on button using JavascriptExecutor		
		        js3.executeScript("arguments[0].click();", details);
		        Thread.sleep(5000);	

		        //choose manage subscription  
		        WebElement manage_sub = driver.findElement(By.cssSelector("div#headingOne6mm>div"));
		        JavascriptExecutor js4 = (JavascriptExecutor)driver;

		        //Perform Click on button using JavascriptExecutor		
		        js4.executeScript("arguments[0].click();", manage_sub);
		        Thread.sleep(5000);	

		        //choose manage subscription  
		        WebElement suspend = driver.findElement(By.linkText("Terminate"));
		        JavascriptExecutor js9 = (JavascriptExecutor)driver;

		        //Perform Click on button using JavascriptExecutor		
		        js9.executeScript("arguments[0].click();", suspend);
		        Thread.sleep(5000);
		        
		        WebDriverWait waitforokaybutton = new WebDriverWait(driver, 60);
		        waitforokaybutton.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Ok']")));

		        //Suspend 
		        WebElement suspend_okay = driver.findElement(By.xpath("//button[text()='Ok']"));
		        JavascriptExecutor js5 = (JavascriptExecutor)driver;

		        //Perform Click on button using JavascriptExecutor		
		        js5.executeScript("arguments[0].click();", suspend_okay);
		        Thread.sleep(5000);
				
		        
		        driver.findElement(By.id("service_action_reason")).sendKeys("I am done");
		        Thread.sleep(3000);
		        driver.findElement(By.id("set_service_reason")).click();
		        
		        WebDriverWait waitformesssage = new WebDriverWait(driver, 60);
		        waitformesssage.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#alert-msg-flash-success>div:nth-of-type(2)")));
		        
		        String successmessage = driver.findElement(By.cssSelector("div#alert-msg-flash-success>div:nth-of-type(2)")).getText();
		        String actualmesssage = "Account terminated successfully.";
		        
		        Assert.assertEquals(actualmesssage, successmessage);
		        Thread.sleep(5000);
		        

		
	}

}
