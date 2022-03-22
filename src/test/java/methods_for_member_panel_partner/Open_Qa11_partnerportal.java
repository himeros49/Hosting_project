package methods_for_member_panel_partner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import methods.BaseClass;
import methods.Switch_tab;

public class Open_Qa11_partnerportal extends BaseClass{

	
	public static WebDriver open_Q11_partnerportal()  throws Exception {
		
		//Launching Browser
				
				WebDriverManager.chromedriver().setup();

				
				WebDriver driver = new ChromeDriver();

				driver.manage().window().maximize();
//				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
				driver.get(BaseUrl_partner);
				Thread.sleep(3000);
				
				
				
				//creating a reference 
				JavascriptExecutor js = (JavascriptExecutor) driver;
				
				driver.manage().window().maximize();
//				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
				driver.get(BaseUrl_partner);
				Thread.sleep(3000);
				
				
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
					
					driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
					
					Thread.sleep(3000);
					
					
					driver.findElement(By.id("login_username")).sendKeys(valid_partner_username);
					
					logger.info("Username Entered");
					
					Thread.sleep(1000);
					driver.findElement(By.id("login_password")).sendKeys(valid_partner_password);
					Thread.sleep(1000);
					
					logger.info("Password Entered");
					driver.findElement(By.id("kt_login_signin_submit_form")).click();
					logger.info("login button clicked");
					
				}
				
			
				
				
				//Open Monthly plan
				String monthly = "https://managebhavitmohod2233.qa11.dotbricks.net/order/hosting.php?id=OTg=&billingcycle=TW9udGhseQ==";
				
				driver = Switch_tab.switch_next_tab2(driver); 
				
		        driver.get(monthly);
				
				
				return driver;
				
	
	}
	
	
	
}
