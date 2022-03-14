package methods;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Adding_domain extends BaseClass  {
	
	public static WebDriver entering_the_domin_from_admin_panel(WebDriver driver) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(7000);
        try
        {
            String domain = ("phoenix" + randomnumber(3) + randomstring(2)).trim();
            driver.findElement(By.id("new_domain_name")).sendKeys(domain);
            driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();
            Thread.sleep(7000);

            ///terms and condition checkbox
            List<WebElement> terms = driver.findElements(By.xpath("//span[text()='Entered domain name is not available.']"));
            if(terms.size() != 0)
            {
                System.out.println("Element present");
                String domain2 = ("phoenix" + randomnumber(4) + randomstring(2)).trim();
                driver.findElement(By.id("new_domain_name")).clear();
                driver.findElement(By.id("new_domain_name")).sendKeys(domain2);
                driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();
                Thread.sleep(7000);
            }
            else
            {
                System.out.println("Element not present");
            }
            driver.findElement(By.xpath("(//input[@type='button'])[2]")).click();
            Thread.sleep(3000);
        }
        
        catch(Exception e)
        {
        	 driver.navigate().refresh();
        	 String domain = ("phoenix" + randomnumber(4) + randomstring(3)).trim();
             driver.findElement(By.id("new_domain_name")).sendKeys(domain);
             driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();
             Thread.sleep(7000);

             ///terms and condition Checkbox
             List<WebElement> terms = driver.findElements(By.xpath("//span[text()='Entered domain name is not available.']"));
             if(terms.size() != 0)
             {
                 System.out.println("Element present");
                 String domain2 = ("phoenix" + randomnumber(4) + randomstring(2)).trim();
                 driver.findElement(By.id("new_domain_name")).clear();
                 driver.findElement(By.id("new_domain_name")).sendKeys(domain2);
                 driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();
                 Thread.sleep(7000);
             }
             else
             {
                 System.out.println("Element not present");
             }
             driver.findElement(By.xpath("(//input[@type='button'])[2]")).click();
             Thread.sleep(3000);
        }

        Thread.sleep(5000);

        //plus button up
        driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[1]")).click();
        Thread.sleep(3000);

        //plus button down
        driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[2]")).click();

        return driver;
	}

	
	public static WebDriver entering_the_domin_from_admin_panel_without_addon(WebDriver driver) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(7000);
        try
        {
            String domain = ("phoenix" + randomnumber(3) + randomstring(2)).trim();
            driver.findElement(By.id("new_domain_name")).sendKeys(domain);
            driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();
            Thread.sleep(7000);

            ///terms and condition checkbox
            List<WebElement> terms = driver.findElements(By.xpath("//span[text()='Entered domain name is not available.']"));
            if(terms.size() != 0)
            {
                System.out.println("Element present");
                String domain2 = ("phoenix" + randomnumber(4) + randomstring(2)).trim();
                driver.findElement(By.id("new_domain_name")).clear();
                driver.findElement(By.id("new_domain_name")).sendKeys(domain2);
                driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();
                Thread.sleep(7000);
            }
            else
            {
                System.out.println("Element not present");
            }
            driver.findElement(By.xpath("(//input[@type='button'])[2]")).click();
            Thread.sleep(3000);
        }
        
        catch(Exception e)
        {
        	 driver.navigate().refresh();
        	 String domain = ("phoenix" + randomnumber(4) + randomstring(3)).trim();
             driver.findElement(By.id("new_domain_name")).sendKeys(domain);
             driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();
             Thread.sleep(7000);

             ///terms and condition Checkbox
             List<WebElement> terms = driver.findElements(By.xpath("//span[text()='Entered domain name is not available.']"));
             if(terms.size() != 0)
             {
                 System.out.println("Element present");
                 String domain2 = ("phoenix" + randomnumber(4) + randomstring(2)).trim();
                 driver.findElement(By.id("new_domain_name")).clear();
                 driver.findElement(By.id("new_domain_name")).sendKeys(domain2);
                 driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();
                 Thread.sleep(7000);
             }
             else
             {
                 System.out.println("Element not present");
             }
             driver.findElement(By.xpath("(//input[@type='button'])[2]")).click();
             Thread.sleep(3000);
        }

        Thread.sleep(5000);
        return driver;
	}
	
	
	
	public static WebDriver entering_the_domin_from_partner_panel(WebDriver driver) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		try
		{
			logger.info("Let me Try");
			driver.findElement(By.cssSelector("section#use_ms_dom_section>label>i")).click();
		}
		catch(Exception x)
		{
			logger.info("catch block...... help me!!!!!!!");
			driver.navigate().refresh();
			driver.findElement(By.xpath("(//label[@class='radio']//strong)[2]")).click();
		}
		
		
        Thread.sleep(3000);
        
        try
        {
            String domain = ("phoenix" + randomnumber(3) + randomstring(2)).trim();
           
            driver.findElement(By.id("msother_domainname")).sendKeys(domain);
            
            driver.findElement(By.id("domain_select_button1")).click();
            Thread.sleep(7000);

            ///terms and condition checkbox
            List<WebElement> terms = driver.findElements(By.xpath("//span[@class='common_error_msg unavailable']"));
            if(terms.size() != 0)
            {
                System.out.println("Element present");
                String domain2 = ("phoenix" + randomnumber(4) + randomstring(2)).trim();
                driver.findElement(By.id("msother_domainname")).clear();
                driver.findElement(By.id("msother_domainname")).sendKeys(domain2);
                driver.findElement(By.id("domain_select_button1")).click();
                Thread.sleep(7000);
            }
            else
            {
                System.out.println("Element not present");
            }
            
        }
        
        catch(Exception e)
        {
        	 driver.navigate().refresh();
        	 String domain = ("phoenix" + randomnumber(4) + randomstring(3)).trim();
             driver.findElement(By.id("msother_domainname")).sendKeys(domain);
             driver.findElement(By.id("domain_select_button1")).click();
             Thread.sleep(7000);

             ///terms and condition Checkbox
             List<WebElement> terms = driver.findElements(By.xpath("//span[text()='Entered domain name is not available.']"));
             if(terms.size() != 0)
             {
            	 System.out.println("Element present");
                 String domain2 = ("phoenix" + randomnumber(4) + randomstring(2)).trim();
                 driver.findElement(By.id("msother_domainname")).clear();
                 driver.findElement(By.id("msother_domainname")).sendKeys(domain2);
                 driver.findElement(By.id("domain_select_button1")).click();
                 Thread.sleep(7000);
             }
             else
             {
                 System.out.println("Element not present");
             }
          
        }

        Thread.sleep(5000);

        //plus button up
        driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[1]")).click();
        Thread.sleep(3000);

        //plus button down
        driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[2]")).click();

        return driver;
	}

	
	public static WebDriver entering_the_domin_from_partner_panel_without_addon(WebDriver driver) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		try
		{
			logger.info("Let me Try");
			driver.findElement(By.cssSelector("section#use_ms_dom_section>label>i")).click();
		}
		catch(Exception x)
		{
			logger.info("catch block...... help me!!!!!!!");
			driver.navigate().refresh();
			driver.findElement(By.xpath("(//label[@class='radio']//strong)[2]")).click();
		}
		
		
        Thread.sleep(3000);
        
        try
        {
            String domain = ("phoenix" + randomnumber(3) + randomstring(2)).trim();
           
            driver.findElement(By.id("msother_domainname")).sendKeys(domain);
            
            driver.findElement(By.id("domain_select_button1")).click();
            Thread.sleep(7000);

            ///terms and condition checkbox
            List<WebElement> terms = driver.findElements(By.xpath("//span[@class='common_error_msg unavailable']"));
            if(terms.size() != 0)
            {
                System.out.println("Element present");
                String domain2 = ("phoenix" + randomnumber(4) + randomstring(2)).trim();
                driver.findElement(By.id("msother_domainname")).clear();
                driver.findElement(By.id("msother_domainname")).sendKeys(domain2);
                driver.findElement(By.id("domain_select_button1")).click();
                Thread.sleep(7000);
            }
            else
            {
                System.out.println("Element not present");
            }
            
        }
        
        catch(Exception e)
        {
        	 driver.navigate().refresh();
        	 String domain = ("phoenix" + randomnumber(4) + randomstring(3)).trim();
             driver.findElement(By.id("msother_domainname")).sendKeys(domain);
             driver.findElement(By.id("domain_select_button1")).click();
             Thread.sleep(7000);

             ///terms and condition Checkbox
             List<WebElement> terms = driver.findElements(By.xpath("//span[text()='Entered domain name is not available.']"));
             if(terms.size() != 0)
             {
            	 System.out.println("Element present");
                 String domain2 = ("phoenix" + randomnumber(4) + randomstring(2)).trim();
                 driver.findElement(By.id("msother_domainname")).clear();
                 driver.findElement(By.id("msother_domainname")).sendKeys(domain2);
                 driver.findElement(By.id("domain_select_button1")).click();
                 Thread.sleep(7000);
             }
             else
             {
                 System.out.println("Element not present");
             }
          
        }

        Thread.sleep(5000);

        return driver;
	}
	
	
	
	
	
}
