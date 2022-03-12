package methods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Open_Q11_portal extends BaseClass{
	

	public static WebDriver open_Q11_Website() throws Exception {
	
		//Launching Browser
				
				WebDriverManager.chromedriver().setup();
				
				//Headless Mode 
//				ChromeOptions options =new ChromeOptions();
//				options.setHeadless(true);
//				WebDriver driver = new ChromeDriver(options);
				
				WebDriver driver = new ChromeDriver();
				
				
				
				driver.manage().window().maximize();
//				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
				driver.get(BaseUrl);
				Thread.sleep(3000);
				
				
				
				//creating a reference 
				JavascriptExecutor js = (JavascriptExecutor) driver;
				
				
//				
//				WebDriverWait wait = new WebDriverWait(driver,60);
//				wait.until(null)
//				
//				//wait until the page return complete as its status
//				wait.until(js.executeScript("return document.readyState").equals("complete"),true);
//				
				
				try
				{
				//Login input
				driver.findElement(By.id("login_username")).sendKeys(valid_admin_username);
				
				logger.info("Username Entered");
				
				Thread.sleep(1000);
				driver.findElement(By.id("login_password")).sendKeys(valid_admin_password);
				Thread.sleep(1000);
				
				logger.info("Password Entered");
				driver.findElement(By.id("kt_login_signin_submit_form")).click();
				logger.info("login button clicked");
				
				}
				
				catch(Exception x)
				{
					
					logger.info("pheww.....catch section help me.....");
					
					
					driver.navigate().refresh();
					
					logger.info("Page refreshed");
					
					driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
					driver.findElement(By.id("login_username")).sendKeys(valid_admin_username);
					
					logger.info("Username Entered");
					
					Thread.sleep(1000);
					driver.findElement(By.id("login_password")).sendKeys(valid_admin_password);
					Thread.sleep(1000);
					
					logger.info("Password Entered");
					driver.findElement(By.id("kt_login_signin_submit_form")).click();
					logger.info("login button clicked");
					
				}
				
				return driver;
				
	
	}
	
	
	
	
	
	
	
	
	public static WebDriver open_Q11_Partnerpanel() throws Exception {
		
		//Launching Browser
				
				WebDriverManager.chromedriver().setup();
				
				//Headless Mode 
//				ChromeOptions options =new ChromeOptions();
//				options.setHeadless(true);
//				WebDriver driver = new ChromeDriver(options);
				
				WebDriver driver = new ChromeDriver();
				
				
				
				driver.manage().window().maximize();
//				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
				driver.get(BaseUrl_partner);
				Thread.sleep(3000);
				
				
				
				//creating a reference 
				JavascriptExecutor js = (JavascriptExecutor) driver;
				
				
//				
//				WebDriverWait wait = new WebDriverWait(driver,60);
//				wait.until(null)
//				
//				//wait until the page return complete as its status
//				wait.until(js.executeScript("return document.readyState").equals("complete"),true);
//				
				
				try
				{
				//Login input
				driver.findElement(By.id("login_username")).sendKeys(valid_partner_username);
				
				logger.info("Username Entered");
				
				Thread.sleep(1000);
				driver.findElement(By.id("login_password")).sendKeys(valid_partner_password);
				Thread.sleep(1000);
				
				logger.info("Password Entered");
				driver.findElement(By.id("kt_login_signin_submit_form")).click();
				logger.info("login button clicked");
				
				}
				
				catch(Exception x)
				{
					
					logger.info("pheww.....catch section help me.....");
					
					
					driver.navigate().refresh();
					
					logger.info("Page refreshed");
					
					driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
					driver.findElement(By.id("login_username")).sendKeys(valid_partner_username);
					
					logger.info("Username Entered");
					
					Thread.sleep(1000);
					driver.findElement(By.id("login_password")).sendKeys(valid_partner_password);
					Thread.sleep(1000);
					
					logger.info("Password Entered");
					driver.findElement(By.id("kt_login_signin_submit_form")).click();
					logger.info("login button clicked");
					
				}
				
				return driver;
				
	
	}
	

	

}
