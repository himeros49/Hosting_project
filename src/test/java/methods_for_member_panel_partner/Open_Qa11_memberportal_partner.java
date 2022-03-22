package methods_for_member_panel_partner;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import methods.BaseClass;

public class Open_Qa11_memberportal_partner extends BaseClass {
	

	
	
	public static WebDriver open_Q11_Website() throws Exception {
		
		//Launching Browser
				
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();

				
				driver.manage().window().maximize();
//				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				driver.get(BaseUrl_member_partner);
				Thread.sleep(3000);		
				
				
				//Capturing username and password
				
				String[]  cred = Login_credentials.get_login_credentials(driver, "Hosting_Memberpanel_partner");
				
				String valid_member_username = cred[0];
				
				String valid_member_password = cred[1];
				
				//**************************************//
				
				
				try
				{
				//Login input
				driver.findElement(By.id("username")).sendKeys(valid_member_username);
				
				logger.info("Username Entered");
				
				Thread.sleep(1000);
				driver.findElement(By.id("password")).sendKeys(valid_member_password);
				Thread.sleep(1000);
				
				logger.info("Password Entered");
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				logger.info("login button clicked");
				
				}
				
				catch(Exception x)
				{
					
					logger.info("pheww.....catch section help me.....");
			
					driver.navigate().refresh();
					
					logger.info("Page refreshed");
					
					driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
					driver.findElement(By.id("username")).sendKeys(valid_member_username);
					
					logger.info("Username Entered");
					
					Thread.sleep(1000);
					driver.findElement(By.id("password")).sendKeys(valid_member_password);
					Thread.sleep(1000);
					
					logger.info("Password Entered");
					driver.findElement(By.xpath("//input[@type='submit']")).click();
					logger.info("login button clicked");
					
				}
				
				return driver;
				
	
	}

		
	public static WebDriver open_Q11_Website_using_subUser_credentials(WebDriver driver) throws Exception {
		
//		//Launching Browser
//				
//				WebDriverManager.chromedriver().setup();
//				WebDriver driver = new ChromeDriver();
//
//				
//				driver.manage().window().maximize();
////				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				driver.manage().deleteAllCookies();
				
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				driver.navigate().to(BaseUrl_member_partner);
				Thread.sleep(3000);		
				
				
				//Capturing username and password
				
				String[]  cred_sub = Login_credentials.get_login_credentials_of_SubUser(driver, "Hosting_Memberpanel_partner");
				
				String valid_member_username = cred_sub[0];
				
				String valid_member_password = cred_sub[1];
				
				//**************************************//
				
				
				try
				{
				//Login input
				driver.findElement(By.id("username")).sendKeys(valid_member_username);
				
				logger.info("Username Entered");
				
				Thread.sleep(1000);
				driver.findElement(By.id("password")).sendKeys(valid_member_password);
				Thread.sleep(1000);
				
				logger.info("Password Entered");
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				logger.info("login button clicked");
				
				}
				
				catch(Exception x)
				{
					
					logger.info("pheww.....catch section help me.....");
			
					driver.navigate().refresh();
					
					logger.info("Page refreshed");
					
					driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
					driver.findElement(By.id("username")).sendKeys(valid_member_username);
					
					logger.info("Username Entered");
					
					Thread.sleep(1000);
					driver.findElement(By.id("password")).sendKeys(valid_member_password);
					Thread.sleep(1000);
					
					logger.info("Password Entered");
					driver.findElement(By.xpath("//input[@type='submit']")).click();
					logger.info("login button clicked");
					
				}
				
				return driver;
				
	
	}

	
	public static WebDriver open_Q11_Website_general(WebDriver driver, String name_of_the_sheet, int row, int column ) throws Exception {
		

				
				driver.manage().deleteAllCookies();
				
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				driver.navigate().to(BaseUrl_member_partner);
				Thread.sleep(3000);		
				
				
				//Capturing username and password
				
				String[]  cred_sub = Login_credentials.get_login_credentials_general(driver, name_of_the_sheet, row, column);
				
				String valid_member_username = cred_sub[0];
				
				String valid_member_password = cred_sub[1];
				
				//**************************************//
				
				
				try
				{
				//Login input
				driver.findElement(By.id("username")).sendKeys(valid_member_username);
				
				logger.info("Username Entered");
				
				Thread.sleep(1000);
				driver.findElement(By.id("password")).sendKeys(valid_member_password);
				Thread.sleep(1000);
				
				logger.info("Password Entered");
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				logger.info("login button clicked");
				
				
				

				List<WebElement> login_error=  driver.findElements(By.className("m-alert__text"));
				if(login_error.size() != 0)
				{
				
					//Login input
					WebElement username_ = driver.findElement(By.id("username"));
					username_.clear();
					username_.sendKeys(valid_member_username);
					
					logger.info("Username Entered");
					
					Thread.sleep(1000);
					WebElement password_ =driver.findElement(By.id("password"));
					password_.clear();
					password_.sendKeys(valid_member_password);
					Thread.sleep(1000);
					
					logger.info("Password Entered");
					driver.findElement(By.xpath("//input[@type='submit']")).click();
					logger.info("login button clicked");
				}
				
			
				
				
				
				}
				
				catch(Exception x)
				{
					
					
					logger.info("pheww.....catch section help me.....");
			
					driver.navigate().refresh();
					
					logger.info("Page refreshed");
					
					driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
					driver.findElement(By.id("username")).sendKeys(valid_member_username);
					
					logger.info("Username Entered");
					
					Thread.sleep(1000);
					driver.findElement(By.id("password")).sendKeys(valid_member_password);
					Thread.sleep(1000);
					
					logger.info("Password Entered");
					driver.findElement(By.xpath("//input[@type='submit']")).click();
					logger.info("login button clicked");
					
				}
				
				return driver;
				
	
	}
	
	
	
}
