package methods_for_member_panel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import methods.BaseClass;

public class Payments_for_member_panel extends BaseClass {


	public static void paypal_payment(WebDriver driver) throws Exception{ 


		String paypal_email = readconfig.getpaypal_username();
		String paypal_password = readconfig.getpaypal_password();



		Thread.sleep(2000);

		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//strong[contains(.,'Paypal')]")));

			WebElement paypal_button= driver.findElement(By.xpath("//strong[contains(.,'Paypal')]"));
			//Creating the JavascriptExecutor interface object by Type casting		
	        JavascriptExecutor js1 = (JavascriptExecutor)driver;
	        
	        js1.executeScript("arguments[0].scrollIntoView(true);", paypal_button);
	        Thread.sleep(500); 
	        
	        
	        //Perform Click on LOGIN button using JavascriptExecutor		
	        js1.executeScript("arguments[0].click();", paypal_button);

			WebDriverWait wait3 = new WebDriverWait(driver, 30);
			wait3.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[text()='Ok']")));	
			//OK button
			WebElement okay = driver.findElement(By.xpath("//button[text()='Ok']"));
			okay.click();

		}
		catch(Exception x )
		{
			driver.findElement(By.xpath("//strong[text()='Paypal']")).click();
			Thread.sleep(3000);
			WebDriverWait wait3 = new WebDriverWait(driver, 30);
			wait3.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[contains(@class,'swal2-confirm btn')]")));	
			//OK button
			WebElement okay = driver.findElement(By.xpath("//button[contains(@class,'swal2-confirm btn')]"));
			okay.click();	
		}

		
		try {
			WebElement email = driver.findElement(By.id("email"));
			
			if(!(email.isDisplayed()))
			{
				driver.findElement(By.xpath("//strong[text()='Paypal']")).click();
				Thread.sleep(3000);
				WebDriverWait wait3 = new WebDriverWait(driver, 30);
				wait3.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[contains(@class,'swal2-confirm btn')]")));	
				//OK button
				WebElement okay = driver.findElement(By.xpath("//button[contains(@class,'swal2-confirm btn')]"));
				okay.click();
				
			}
			
			
		}	
		catch(Exception x)
		{
			System.out.println(x.getStackTrace());
		}
		
		
		
		
		

		WebDriverWait wait4 = new WebDriverWait(driver, 30);
		wait4.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("email")));	

		driver.findElement(By.id("email")).sendKeys(paypal_email);
		Thread.sleep(5000);	

		driver.findElement(By.id("btnNext")).click();
		Thread.sleep(3000);		

		driver.findElement(By.id("password")).sendKeys(paypal_password);
		Thread.sleep(3000);


		WebDriverWait wait7 = new WebDriverWait(driver, 30);
		wait7.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("btnLogin")));
		driver.findElement(By.id("btnLogin")).click();
		//Thread.sleep(3000);
		
		
		List<WebElement> cookie_paypal = driver.findElements(By.id("acceptAllButton"));
		if(cookie_paypal.size() != 0)
		{
			driver.findElement(By.id("acceptAllButton")).click();
		}
		
		
		List<WebElement> cross_paypal = driver.findElements(By.xpath("//button[contains(@class,'icon-button')]"));
		if(cross_paypal.size() != 0)
		{
			driver.findElement(By.xpath("//button[contains(@class,'icon-button')]")).click();
		}
		

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
			Thread.sleep(5000);	

		}

		catch(Exception x)
		{
			logger.info("catch block");
			WebDriverWait waitforsuccess = new WebDriverWait(driver, 30);
			waitforsuccess.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#nav-home>div")));

			String success= driver.findElement(By.cssSelector("div#nav-home>div")).getText();
			System.out.println(success);

			
			Thread.sleep(5000);
		}
	}


	
	public static void paypal_payment_without_login(WebDriver driver) throws Exception{ 





		Thread.sleep(2000);

		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//strong[contains(.,'Paypal')]")));

			WebElement paypal_button= driver.findElement(By.xpath("//strong[contains(.,'Paypal')]"));
			//Creating the JavascriptExecutor interface object by Type casting		
	        JavascriptExecutor js1 = (JavascriptExecutor)driver;
	        
	        js1.executeScript("arguments[0].scrollIntoView(true);", paypal_button);
	        Thread.sleep(500); 
	        
	        
	        //Perform Click on LOGIN button using JavascriptExecutor		
	        js1.executeScript("arguments[0].click();", paypal_button);

			WebDriverWait wait3 = new WebDriverWait(driver, 30);
			wait3.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[text()='Ok']")));	
			//OK button
			WebElement okay = driver.findElement(By.xpath("//button[text()='Ok']"));
			okay.click();

		}
		catch(Exception x )
		{
			driver.findElement(By.xpath("//strong[text()='Paypal']")).click();
			Thread.sleep(3000);
			WebDriverWait wait3 = new WebDriverWait(driver, 30);
			wait3.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[contains(@class,'swal2-confirm btn')]")));	
			//OK button
			WebElement okay = driver.findElement(By.xpath("//button[contains(@class,'swal2-confirm btn')]"));
			okay.click();	
		}

		
		try {
			WebElement email = driver.findElement(By.id("email"));
			
			if(!(email.isDisplayed()))
			{
				driver.findElement(By.xpath("//strong[text()='Paypal']")).click();
				Thread.sleep(3000);
				WebDriverWait wait3 = new WebDriverWait(driver, 30);
				wait3.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[contains(@class,'swal2-confirm btn')]")));	
				//OK button
				WebElement okay = driver.findElement(By.xpath("//button[contains(@class,'swal2-confirm btn')]"));
				okay.click();
				
			}
			
			
		}	
		catch(Exception x)
		{
			System.out.println(x.getStackTrace());
		}
		
		
		List<WebElement> cookie_paypal = driver.findElements(By.id("acceptAllButton"));
		if(cookie_paypal.size() != 0)
		{
			driver.findElement(By.id("acceptAllButton")).click();
		}
		
		
		List<WebElement> cross_paypal = driver.findElements(By.xpath("//button[contains(@class,'icon-button')]"));
		if(cross_paypal.size() != 0)
		{
			driver.findElement(By.xpath("//button[contains(@class,'icon-button')]")).click();
		}
		

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
			Thread.sleep(5000);	

		}

		catch(Exception x)
		{
			logger.info("catch block");
			WebDriverWait waitforsuccess = new WebDriverWait(driver, 30);
			waitforsuccess.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#nav-home>div")));

			String success= driver.findElement(By.cssSelector("div#nav-home>div")).getText();
			System.out.println(success);

			
			Thread.sleep(5000);
		}
	}




}


