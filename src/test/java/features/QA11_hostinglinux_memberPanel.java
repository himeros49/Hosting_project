package features;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import methods.Adding_domain;
import methods.New_account1;
import methods.Open_Q11_portal;
import methods.Order_Details_Page;
import methods.Payments;
import methods.Subcontact;
import methods.Switch_tab;
import methods_for_member_panel.Adding_subuser;
import methods_for_member_panel.Invoice_renewable;
import methods_for_member_panel.Open_Qa11_adminportal;
import methods_for_member_panel.Open_Qa11_memberportal;
import methods_for_member_panel.Payments_for_member_panel;
import methods_for_member_panel.Renewable_on_off;
import methods_for_member_panel.Service_details;
import utilities.ReadConfig;
import utilities.XLutils;

public class QA11_hostinglinux_memberPanel {
	
	public WebDriver driver;
	private static Logger logger = LogManager.getLogger(QA11_hostinglinux_memberPanel.class);
	public static ReadConfig readconfig = new ReadConfig();
	//Location Of Excel Sheet
	public static String xlpath = System.getProperty("user.dir") + "/src/main/resources/Q11-Hosting.xlsx";
	
	
	
	//Renew_service_with_autorenewal_on (Excel Sheet = "Hosting_Memberpanel")
	
	
	@Given("Marlin buys the monthly plan of Hosting")
	public void marlin_buys_the_monthly_plan_of_hosting() throws Exception {
		driver = Open_Qa11_adminportal.open_Q11_adminportal();
		
		//Choosing Domain
		driver = Adding_domain.entering_the_domin_from_admin_panel(driver);
		
		//Add to cart button
		driver.findElement(By.id("submit")).click();
		Thread.sleep(3000);


		Thread.sleep(5000);
		driver.findElement(By.id("next_without_login")).click();


		//create an Account
		driver.findElement(By.id("sign-up-sec")).click();
		Thread.sleep(3000);
		logger.info("Going to Create New Account");

	}

	
	@Then("Marlin creates her account")
	public void marlin_creates_her_account() throws Exception {
		//Calling Method for NEW ACCOUNT CREATION
		New_account1.creating_new_account_from_admin_panel(driver,"Hosting_Memberpanel",3,19);
	}
	
	
	@And("Marlin pays from paypal gateway")
	public void marlin_pays_from_paypal_gateway() throws Exception {
		
		logger.info("Mode of Payment Paypal");

		Payments.payment_with_paypal(driver,"Hosting_paypal");

		logger.info("Payment Sucessfully done");
		
		driver.manage().deleteAllCookies();

		Thread.sleep(5000);	

		driver.close();

		driver = Switch_tab.switch_previous_tab2(driver);
		
		driver.manage().deleteAllCookies();
		
		
	    
	}


	@Then("Marlin login into her account")
	public void marlin_login_into_her_account() throws Exception {
		
		driver =Open_Qa11_memberportal.open_Q11_Website_general(driver, "Hosting_Memberpanel",  3, 19);
		logger.info("Welcome to Q11 portal");
		Thread.sleep(10000);
		
	}

	
	@Then("Marlin view her subscription")
	public void marlin_view_her_subscription() throws Exception {
	   
		Thread.sleep(7000);

		WebDriverWait waitInvoice = new WebDriverWait(driver, 60);
		waitInvoice.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Invoices")));

		driver.findElement(By.linkText("Invoices")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@class,'dropdown-item clearfix')]")).click();



		WebDriverWait wait2 = new WebDriverWait(driver, 60);
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@href='javascript:void(0);'])[1]")));


		WebElement Invoice = driver.findElement(By.xpath("(//a[@href='javascript:void(0);'])[1]"));
		//Creating the JavascriptExecutor interface object by Type casting		
		JavascriptExecutor js2 = (JavascriptExecutor)driver;

		//Perform Click on LOGIN button using JavascriptExecutor		
		js2.executeScript("arguments[0].click();", Invoice);
		
		
		Invoice_renewable.capture_details_of_invoice_autoRenewable_on(driver, "Hosting_Memberpanel");
		
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath("//button[text()='Close']")).click();
		
		
		try
	    {
	    	driver.findElement(By.xpath("//span[text()='My Services']")).click();
	    	Thread.sleep(3000);
	    	driver.findElement(By.xpath("//span[text()='List/Search Services']")).click();
	    	WebDriverWait wait = new WebDriverWait(driver, 50);
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Linux Hosting New - Gold")));
	    }
	    catch(Exception x)
	    {
	    	driver.findElement(By.cssSelector("div#m_header_menu>ul>li:nth-of-type(2)>a>span:nth-of-type(2)")).click();
	    	Thread.sleep(3000);
	    	driver.findElement(By.cssSelector("div#m_header_menu>ul>li:nth-of-type(2)>div>ul>li>a>span")).click();
	    	WebDriverWait wait = new WebDriverWait(driver, 50);
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Linux Hosting New - Gold")));
	    }
		
		
		Service_details.capture_current_service(driver, "Hosting_Memberpanel", 15);
	    
		Thread.sleep(5000);
		
	    driver.findElement(By.partialLinkText("Linux Hosting New - Gold")).click();
	    
	    WebDriverWait wait = new WebDriverWait(driver, 50);
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.name("update")));
	    
		
		
		
	}
	
	
	@And("Marlin turns ON renewal service")
	public void marlin_turns_on_renewal_service() throws Exception {
	   
	Thread.sleep(7000);
	Renewable_on_off.turn_on_renewable(driver);
	
	}
	
	
	@Then("Marlin Renew her services")
	public void marlin_renew_her_services() throws Exception {
	    
		
		//Renewable Centre
		driver.findElement(By.partialLinkText("Renewal Center")).click();
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Renew Now']")));
		
		
		Service_details.capture_service_details(driver, "Hosting_Memberpanel", 15);
		Thread.sleep(3000);
		
		
		//Renew Now Button
		WebElement renew_btn = driver.findElement(By.xpath("//button[text()='Renew Now']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Perform Click on button using JavascriptExecutor		
        js.executeScript("arguments[0].click();", renew_btn);
		
		Thread.sleep(5000);
		
		//confirmation Button
		driver.findElement(By.xpath("//button[contains(@class,'swal2-confirm btn')]")).click();
		
		
	}
	
	
	@And("Marlin again pay for the service from Paypal")
	public void marlin_again_pay_for_the_service_from_paypal() throws Exception {


		
		Payments_for_member_panel.paypal_payment_without_login(driver);


	}
	
	
	@Then("Marlin verfies the invoice")
	public void marlin_verfies_the_invoice() throws Exception {
	    
		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//li[@class='link login']//a)[2]")));

		WebElement account = driver.findElement(By.xpath("(//li[@class='link login']//a)[2]"));
		//Creating the JavascriptExecutor interface object by Type casting		
		JavascriptExecutor js1 = (JavascriptExecutor)driver;

		//Perform Click on LOGIN button using JavascriptExecutor		
		js1.executeScript("arguments[0].click();", account);
				
				
				try
			    {
			    	driver.findElement(By.xpath("//span[text()='My Services']")).click();
			    	Thread.sleep(3000);
			    	driver.findElement(By.xpath("//span[text()='List/Search Services']")).click();
			    	WebDriverWait wait = new WebDriverWait(driver, 50);
			    	wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Linux Hosting New - Gold")));
			    }
			    catch(Exception x)
			    {
			    	driver.findElement(By.cssSelector("div#m_header_menu>ul>li:nth-of-type(2)>a>span:nth-of-type(2)")).click();
			    	Thread.sleep(3000);
			    	driver.findElement(By.cssSelector("div#m_header_menu>ul>li:nth-of-type(2)>div>ul>li>a>span")).click();
			    	WebDriverWait wait = new WebDriverWait(driver, 50);
			    	wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Linux Hosting New - Gold")));
			    }
				
				
				Service_details.capture_current_service(driver, "Hosting_Memberpanel", 16);
				Thread.sleep(5000);
				driver.quit();

	}
	

	
	
	@Given("Virgo buys the monthly plan of Hosting")
	public void virgo_buys_the_monthly_plan_of_hosting() throws Exception {
	driver = Open_Qa11_adminportal.open_Q11_adminportal();
		
		//Choosing Domain
		driver = Adding_domain.entering_the_domin_from_admin_panel(driver);
		
		//Add to cart button
		driver.findElement(By.id("submit")).click();
		Thread.sleep(3000);


		Thread.sleep(5000);
		driver.findElement(By.id("next_without_login")).click();


		//create an Account
		driver.findElement(By.id("sign-up-sec")).click();
		Thread.sleep(3000);
		logger.info("Going to Create New Account");
	}

	@Then("Virgo creates her account")
	public void virgo_creates_her_account() throws Exception {
		//Calling Method for NEW ACCOUNT CREATION
				New_account1.creating_new_account_from_admin_panel(driver,"Hosting_Memberpanel",3,19);
	}
	
	@Then("Virgo pays from paypal gateway")
	public void virgo_pays_from_paypal_gateway() throws Exception {

		logger.info("Mode of Payment Paypal");

		Payments.payment_with_paypal(driver,"Hosting_paypal");

		logger.info("Payment Sucessfully done");
		
		driver.manage().deleteAllCookies();

		Thread.sleep(5000);	

		driver.close();

		driver = Switch_tab.switch_previous_tab2(driver);
		
		driver.manage().deleteAllCookies();
	}
	
	@Then("Virgo login into her account")
	public void virgo_login_into_her_account() throws Exception {
		driver =Open_Qa11_memberportal.open_Q11_Website_general(driver, "Hosting_Memberpanel",  3, 19);
		logger.info("Welcome to Q11 portal");
		Thread.sleep(10000);
	}
	
	@Then("Virgo view her subscription")
	public void virgo_view_her_subscription() throws Exception {
		Thread.sleep(7000);

		WebDriverWait waitInvoice = new WebDriverWait(driver, 60);
		waitInvoice.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Invoices")));

		driver.findElement(By.linkText("Invoices")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@class,'dropdown-item clearfix')]")).click();



		WebDriverWait wait2 = new WebDriverWait(driver, 60);
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@href='javascript:void(0);'])[1]")));


		WebElement Invoice = driver.findElement(By.xpath("(//a[@href='javascript:void(0);'])[1]"));
		//Creating the JavascriptExecutor interface object by Type casting		
		JavascriptExecutor js2 = (JavascriptExecutor)driver;

		//Perform Click on LOGIN button using JavascriptExecutor		
		js2.executeScript("arguments[0].click();", Invoice);
		
		
		Invoice_renewable.capture_details_of_invoice_autoRenewable_off(driver, "Hosting_Memberpanel");
		
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath("//button[text()='Close']")).click();
		
		
		try
	    {
	    	driver.findElement(By.xpath("//span[text()='My Services']")).click();
	    	Thread.sleep(3000);
	    	driver.findElement(By.xpath("//span[text()='List/Search Services']")).click();
	    	WebDriverWait wait = new WebDriverWait(driver, 50);
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Linux Hosting New - Gold")));
	    }
	    catch(Exception x)
	    {
	    	driver.findElement(By.cssSelector("div#m_header_menu>ul>li:nth-of-type(2)>a>span:nth-of-type(2)")).click();
	    	Thread.sleep(3000);
	    	driver.findElement(By.cssSelector("div#m_header_menu>ul>li:nth-of-type(2)>div>ul>li>a>span")).click();
	    	WebDriverWait wait = new WebDriverWait(driver, 50);
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Linux Hosting New - Gold")));
	    }
		
		
		Service_details.capture_current_service(driver, "Hosting_Memberpanel", 32);
	    
		Thread.sleep(5000);
		
	    driver.findElement(By.partialLinkText("Linux Hosting New - Gold")).click();
	    
	    WebDriverWait wait = new WebDriverWait(driver, 50);
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.name("update")));
	    
	
	}
	
	
	@Then("Virgo turns OFF renewal service")
	public void virgo_turns_off_renewal_service() throws Exception {
		Thread.sleep(7000);
		Renewable_on_off.turn_off_renewable(driver);
	}
	
	
	@Then("Virgo Renew her services")
	public void virgo_renew_her_services() throws Exception {
		//Renewable Centre
				driver.findElement(By.partialLinkText("Renewal Center")).click();
				WebDriverWait wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Renew Now']")));
				
				
				Service_details.capture_service_details(driver, "Hosting_Memberpanel", 15);
				Thread.sleep(3000);
				
				
				//Renew Now Button
				WebElement renew_btn = driver.findElement(By.xpath("//button[text()='Renew Now']"));
				
				JavascriptExecutor js = (JavascriptExecutor)driver;
				
				//Perform Click on button using JavascriptExecutor		
		        js.executeScript("arguments[0].click();", renew_btn);
				
				Thread.sleep(5000);
				
				//confirmation Button
				driver.findElement(By.xpath("//button[contains(@class,'swal2-confirm btn')]")).click();
	}
	
	
	@Then("Virgo again pay for the service from Paypal")
	public void virgo_again_pay_for_the_service_from_paypal() throws Exception {
		Payments_for_member_panel.paypal_payment_without_login(driver);
	}
	
	
	@Then("Virgo verfies the invoice")
	public void virgo_verfies_the_invoice() throws Exception {
		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//li[@class='link login']//a)[2]")));

		WebElement account = driver.findElement(By.xpath("(//li[@class='link login']//a)[2]"));
		//Creating the JavascriptExecutor interface object by Type casting		
		JavascriptExecutor js1 = (JavascriptExecutor)driver;

		//Perform Click on LOGIN button using JavascriptExecutor		
		js1.executeScript("arguments[0].click();", account);
				
				
				try
			    {
			    	driver.findElement(By.xpath("//span[text()='My Services']")).click();
			    	Thread.sleep(3000);
			    	driver.findElement(By.xpath("//span[text()='List/Search Services']")).click();
			    	WebDriverWait wait = new WebDriverWait(driver, 50);
			    	wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Linux Hosting New - Gold")));
			    }
			    catch(Exception x)
			    {
			    	driver.findElement(By.cssSelector("div#m_header_menu>ul>li:nth-of-type(2)>a>span:nth-of-type(2)")).click();
			    	Thread.sleep(3000);
			    	driver.findElement(By.cssSelector("div#m_header_menu>ul>li:nth-of-type(2)>div>ul>li>a>span")).click();
			    	WebDriverWait wait = new WebDriverWait(driver, 50);
			    	wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Linux Hosting New - Gold")));
			    }
				
				
				Service_details.capture_current_service(driver, "Hosting_Memberpanel", 33);
				Thread.sleep(5000);
				driver.quit();
		
		
	}
	
	
	
	
	//Customer i.e., Dipper is Updating his Service plan
	
	@Given("Dipper login into her account")
	public void dipper_login_into_her_account() throws Exception {
		
		driver = Open_Qa11_memberportal.open_Q11_Website();
		logger.info("Welcome to Q11 portal");
		Thread.sleep(10000);
	}

	
	@Then("Dipper view his subscription")
	public void dipper_view_his_subscription() throws Exception {
		try
	    {
	    	driver.findElement(By.xpath("//span[text()='My Services']")).click();
	    	Thread.sleep(3000);
	    	driver.findElement(By.xpath("//span[text()='List/Search Services']")).click();
	    	WebDriverWait wait = new WebDriverWait(driver, 50);
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Linux Hosting New - Gold")));
	    }
	    catch(Exception x)
	    {
	    	driver.findElement(By.cssSelector("div#m_header_menu>ul>li:nth-of-type(2)>a>span:nth-of-type(2)")).click();
	    	Thread.sleep(3000);
	    	driver.findElement(By.cssSelector("div#m_header_menu>ul>li:nth-of-type(2)>div>ul>li>a>span")).click();
	    	WebDriverWait wait = new WebDriverWait(driver, 50);
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Linux Hosting New - Gold")));
	    }
		
		Thread.sleep(3000);
		Service_details.capture_current_service(driver, "Hosting_Memberpanel", 40);
		Thread.sleep(3000);
	    
		
		driver.findElement(By.partialLinkText("Linux Hosting New - Gold")).click();
	    WebDriverWait wait = new WebDriverWait(driver, 50);
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.name("update")));
	}
	
	
	@Then("Dipper update his subscription")
	public void dipper_update_his_subscription() throws Exception {
		
		//Renewable Centre
		driver.findElement(By.partialLinkText("Renewal Center")).click();
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Renew Now']")));
		
		Thread.sleep(3000);
		
		//3 Months Plan 
		driver.findElement(By.xpath("//table[@id='radio_selected']/tbody[2]/tr[1]/td[1]/label[1]/span[1]")).click();
		Thread.sleep(3000);
		
		
		//Update Button
		driver.findElement(By.id("upgrade_service")).click();
		Thread.sleep(5000);
		
		
		//Confirm Button
		driver.findElement(By.xpath("//button[text()='Ok']")).click();
		

		
	}
	
	
	@Then("Dipper checks his plan")
	public void dipper_checks_his_plan() throws Exception {
	    
		
		Payments_for_member_panel.paypal_payment(driver);
		
		//Account
		WebElement account = driver.findElement(By.xpath("//i[@class='fa fa-edit']"));
		account.click();
		
		Thread.sleep(10000);
		
		
		try
	    {
	    	driver.findElement(By.xpath("//span[text()='My Services']")).click();
	    	Thread.sleep(3000);
	    	driver.findElement(By.xpath("//span[text()='List/Search Services']")).click();
	    	WebDriverWait wait = new WebDriverWait(driver, 50);
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Linux Hosting New - Gold")));
	    }
	    catch(Exception x)
	    {
	    	driver.findElement(By.cssSelector("div#m_header_menu>ul>li:nth-of-type(2)>a>span:nth-of-type(2)")).click();
	    	Thread.sleep(3000);
	    	driver.findElement(By.cssSelector("div#m_header_menu>ul>li:nth-of-type(2)>div>ul>li>a>span")).click();
	    	WebDriverWait wait = new WebDriverWait(driver, 50);
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Linux Hosting New - Gold")));
	    }
		
		
		Service_details.capture_current_service(driver, "Hosting_Memberpanel", 41);
		Thread.sleep(5000);
		driver.quit();

		
	}
	
	
	
	
	//Order Payment (Excel Sheet = "Hosting_Memberpanel")
	
	@Given("Alice buys the monthly plan of Hosting")
	public void alice_buys_the_monthly_plan_of_hosting() throws Exception {
		driver = Open_Qa11_adminportal.open_Q11_adminportal();
		
		//Choosing Domain
		driver = Adding_domain.entering_the_domin_from_admin_panel(driver);
		
		//Add to cart button
		driver.findElement(By.id("submit")).click();
		Thread.sleep(3000);


		Thread.sleep(5000);
		driver.findElement(By.id("next_without_login")).click();


		//create an Account
		driver.findElement(By.id("sign-up-sec")).click();
		Thread.sleep(3000);
		logger.info("Going to Create New Account");
	}


	@Then("Alice creates her account")
	public void alice_creates_her_account() throws Exception {
		//Calling Method for NEW ACCOUNT CREATION
				New_account1.creating_new_account_from_admin_panel(driver,"Hosting_Memberpanel",62,1);
	}
	
	
	@And("Alice pays from bank gateway")
	public void alice_pays_from_bank_gateway() throws Exception {
		logger.info("Mode of Payment Bank");

		Payments.payment_with_bank(driver,"Hosting_bank");

		logger.info("Payment Sucessfully done");

		Thread.sleep(5000);	

		driver.close();

		driver = Switch_tab.switch_previous_tab2(driver);
	}
	
	
	@Then("Alice order get reviewed from Admin Panel")
	public void alice_order_get_reviewed_from_admin_panel() throws Exception {
		try {
			logger.info("In try block wait for billing ");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(.,'Billing')])[1]")));


			driver.findElement(By.xpath("(//span[contains(.,'Billing')])[1]")).click();

		}
		catch(Exception x)
		{
			logger.info("In catch block wait for billing ");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#kt_header_menu>ul>li:nth-of-type(4)>a>span")));


			driver.findElement(By.cssSelector("div#kt_header_menu>ul>li:nth-of-type(4)>a>span")).click();

		}

		Thread.sleep(5000);
		Actions ac = new Actions(driver);


		ac.moveToElement(driver.findElement(By.xpath("(//span[contains(.,'Orders')])[1]")));
		ac.moveToElement(driver.findElement(By.xpath("(//span[contains(.,'List')])[6]"))).click().perform();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[2]/a[1]")).click();
		
		
		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[1]")));
		
		String order_number = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[1]")).getText();
		XLutils.setCellData(xlpath , "Hosting_Memberpanel" , 63 , 3 , order_number);
		
		String order_status = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[4]/span[1]")).getText();
		XLutils.setCellData(xlpath , "Hosting_Memberpanel" , 63 , 4 , order_status);

		Thread.sleep(7000);
		
	
	}
	
	
	@And("Alice login into her account in memeber panel")
	public void alice_login_into_her_account_in_memeber_panel() throws Exception {
		
		Switch_tab.switch_next_tab2(driver);

		Open_Qa11_memberportal.open_Q11_Website_general(driver, "Hosting_Memberpanel",  62, 1);
		
		Thread.sleep(7000);	
	}
	
	
	@Then("Alice pays the due amount")
	public void alice_pays_the_due_amount() throws Exception {
		
		
		//Orders
		driver.findElement(By.partialLinkText("Orders")).click();
		
		Thread.sleep(5000);
		
		//All
		driver.findElement(By.xpath("(//a[contains(@class,'dropdown-item clearfix')])[3]")).click();
		
		
		Thread.sleep(5000);
		
		//Current order
		try
		{
			driver.findElement(By.xpath("//span[@class='m-widget6__text']//a[1]")).click();
		}
		catch(Exception x)
		{
			driver.findElement(By.xpath("//a[@href='javascript:void(0);']")).click();
		}
		
		
		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Next")));
		
		//Next button
		driver.findElement(By.linkText("Next")).click();
		
		Thread.sleep(5000);
		
		//Okay button
		driver.findElement(By.xpath("//button[text()='Ok']")).click();
		
		Thread.sleep(5000);
		
		
		Payments_for_member_panel.paypal_payment(driver);
		
		driver.close();
		
		Switch_tab.switch_previous_tab2(driver);
	
		
	}
	
	
	@Then("Alice verifies the invoice")
	public void alice_verifies_the_invoice() throws Exception {
		
		driver.navigate().refresh();
		
		
		String order_number = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[1]")).getText();
		XLutils.setCellData(xlpath , "Hosting_Memberpanel" , 65 , 3 , order_number);
		
		String order_status = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[4]/span[1]")).getText();
		XLutils.setCellData(xlpath , "Hosting_Memberpanel" , 65 , 4 , order_status);

		Thread.sleep(7000);
		
		
	}
	
	
	
	
	
	
	//Invoice Payment (Excel Sheet = "Hosting_Memberpanel")
	@Given("Helly buys the monthly plan of Hosting")
	public void helly_buys_the_monthly_plan_of_hosting() throws Exception {

		driver = Open_Qa11_adminportal.open_Q11_adminportal();

		//Choosing Domain
		driver = Adding_domain.entering_the_domin_from_admin_panel(driver);

		//Add to cart button
		driver.findElement(By.id("submit")).click();
		Thread.sleep(3000);


		Thread.sleep(5000);
		driver.findElement(By.id("next_without_login")).click();


		//create an Account
		driver.findElement(By.id("sign-up-sec")).click();
		Thread.sleep(3000);
		logger.info("Going to Create New Account");


	}


	@Then("Helly creates her account")
	public void helly_creates_her_account() throws Exception {
		//Calling Method for NEW ACCOUNT CREATION
		New_account1.creating_new_account_from_admin_panel(driver,"Hosting_Memberpanel",47,1);
	}


	@And("Helly pays from bank gateway")
	public void helly_pays_from_bank_gateway() throws Exception {
		logger.info("Mode of Payment Bank");

		Payments.payment_with_bank(driver,"Hosting_bank");

		logger.info("Payment Sucessfully done");

		Thread.sleep(5000);	

		driver.close();

		driver = Switch_tab.switch_previous_tab2(driver);


	}


	@Then("Helly order get approved from Admin Panel")
	public void helly_order_get_approved_from_admin_panel() throws Exception {
		try {
			logger.info("In try block wait for billing ");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(.,'Billing')])[1]")));


			driver.findElement(By.xpath("(//span[contains(.,'Billing')])[1]")).click();

		}
		catch(Exception x)
		{
			logger.info("In catch block wait for billing ");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#kt_header_menu>ul>li:nth-of-type(4)>a>span")));


			driver.findElement(By.cssSelector("div#kt_header_menu>ul>li:nth-of-type(4)>a>span")).click();

		}

		Thread.sleep(5000);
		Actions ac = new Actions(driver);


		ac.moveToElement(driver.findElement(By.xpath("(//span[contains(.,'Orders')])[1]")));
		ac.moveToElement(driver.findElement(By.xpath("(//span[contains(.,'List')])[6]"))).click().perform();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(7000);


		Order_Details_Page.approve_order(driver);


		Order_Details_Page.go_to_invoice(driver);


		Switch_tab.switch_next_tab(driver);


		String invoice_number = driver.findElement(By.xpath("(//table[@class='invoice']//table)[3]/tbody[1]/tr[1]/td[2]")).getText();
		XLutils.setCellData(xlpath , "Hosting_Memberpanel" , 48 , 3 , invoice_number);

		String invoice_status = driver.findElement(By.xpath("(//table[@class='invoice']//table)[4]/tbody[1]/tr[2]/td[1]/b[1]")).getText();
		XLutils.setCellData(xlpath , "Hosting_Memberpanel" , 48 , 4 , invoice_status);

		Thread.sleep(5000);

		driver.close();


	}


	@Then("Helly login into her account in memeber panel")
	public void helly_login_into_her_account_in_memeber_panel() throws Exception {

		Thread.sleep(5000);

		Switch_tab.switch_previous_tab2(driver);
		
		Thread.sleep(3000);
		
		Switch_tab.switch_next_tab2(driver);

		Open_Qa11_memberportal.open_Q11_Website_general(driver, "Hosting_Memberpanel",  47, 1);

		Thread.sleep(7000);		
	}


	@And("Helly pays the due amount")
	public void helly_pays_the_due_amount() throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@class,'btn m-btn--pill')]")));

		WebElement top_up = driver.findElement(By.xpath("//a[contains(@class,'btn m-btn--pill')]"));

		//Creating the JavascriptExecutor interface object by Type casting		
		JavascriptExecutor js = (JavascriptExecutor)driver;

		//Perform Click on LOGIN button using JavascriptExecutor		
		js.executeScript("arguments[0].click();", top_up);



		WebDriverWait wait_for_payment_gateway = new WebDriverWait(driver, 50);
		wait_for_payment_gateway.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//strong[text()='Paypal']/following-sibling::span")));


		WebElement amount = driver.findElement(By.id("amount1"));
		amount.sendKeys("2.45");


		Payments_for_member_panel.paypal_payment(driver);
		
		driver.close();
		
		Switch_tab.switch_previous_tab2(driver);


	}


	@Then("Helly verifies the invoice")
	public void helly_verifies_the_invoice() throws Exception {
		
		driver.navigate().refresh();
		
		Thread.sleep(7000);
		
		String order_status = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[4]/span[1]")).getText();
		XLutils.setCellData(xlpath , "Hosting_Memberpanel" , 50 , 4 , order_status);
		
		
		Order_Details_Page.go_to_invoice(driver);
		
		Switch_tab.switch_next_tab(driver);
		
		Thread.sleep(5000);
		
		
		String invoice_number = driver.findElement(By.xpath("(//table[@class='invoice']//table)[3]/tbody[1]/tr[1]/td[2]")).getText();
		XLutils.setCellData(xlpath , "Hosting_Memberpanel" , 50 , 3 , invoice_number);

		
		
		
		
		

//		WebDriverWait wait1 = new WebDriverWait(driver, 60);
//		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//li[@class='link login']//a)[2]")));
//
//		WebElement account = driver.findElement(By.xpath("(//li[@class='link login']//a)[2]"));
//		//Creating the JavascriptExecutor interface object by Type casting		
//		JavascriptExecutor js1 = (JavascriptExecutor)driver;
//
//		//Perform Click on LOGIN button using JavascriptExecutor		
//		js1.executeScript("arguments[0].click();", account);
//
//
//		Thread.sleep(7000);
//
//		WebDriverWait waitInvoice = new WebDriverWait(driver, 60);
//		waitInvoice.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Invoices")));
//
//		driver.findElement(By.linkText("Invoices")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//a[contains(@class,'dropdown-item clearfix')]")).click();
//
//
//
//		WebDriverWait wait2 = new WebDriverWait(driver, 60);
//		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@href='javascript:void(0);'])[1]")));
//
//
//
//
//
//		WebElement Invoice = driver.findElement(By.xpath("(//a[@href='javascript:void(0);'])[1]"));
//		//Creating the JavascriptExecutor interface object by Type casting		
//		JavascriptExecutor js2 = (JavascriptExecutor)driver;
//
//		//Perform Click on LOGIN button using JavascriptExecutor		
//		js2.executeScript("arguments[0].click();", Invoice);
//
//
//
//
//		WebDriverWait wait3 = new WebDriverWait(driver, 60);
//		wait3.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h1")));
//
//		String Invoice_status = driver.findElement(By.tagName("h1")).getText();
//		XLutils.setCellData(xlpath , "Hosting_Memberpanel" , 50 , 4 , Invoice_status);
//
//		Thread.sleep(5000);
//
//
//		WebElement close =   driver.findElement(By.xpath("//button[text()='Close']"));
//		//Creating the JavascriptExecutor interface object by Type casting		
//		JavascriptExecutor js3 = (JavascriptExecutor)driver;
//
//		//Perform Click on LOGIN button using JavascriptExecutor		
//		js3.executeScript("arguments[0].click();", close);
//
//
//
//		WebDriverWait wait4 = new WebDriverWait(driver, 60);
//		wait4.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@href='javascript:void(0);'])[1]")));
//
//
//		logger.info("Invoice number captured ");
//
//		String Invoice_number = driver.findElement(By.xpath("(//a[@href='javascript:void(0);'])[1]")).getText();
//		XLutils.setCellData(xlpath , "Hosting_Memberpanel" , 50 , 3 , Invoice_number);
//
		Thread.sleep(5000);



		driver.quit();
	}





	//Profile Update

	@Given("Maxine login into his account")
	public void maxine_login_into_his_account() throws Exception {

		driver = Open_Qa11_memberportal.open_Q11_Website();
		logger.info("Welcome to Q11 portal");
		Thread.sleep(10000);

	}

	@Then("Maxine view his profile")
	public void maxine_view_his_profile() throws Exception {


		//Go to profile
		WebElement profile = driver.findElement(By.className("m-topbar__username"));
		profile.click();

		Thread.sleep(3000);

		//Open profile
		WebElement open_profile = driver.findElement(By.xpath("//span[text()='My Profile']"));
		open_profile.click();

		Thread.sleep(7000);

	}

	@And("Maxine Updates his profile")
	public void maxine_updates_his_profile() throws Exception {

		driver.findElement(By.id("edit_personal_details")).click();

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ephone")));

		WebElement phone_number =  driver.findElement(By.id("ephone"));
		String number = "3141592653";
		phone_number.clear();
		phone_number.sendKeys(number);

		WebElement place=  driver.findElement(By.id("security_answer1"));
		place.clear();
		place.sendKeys("Heaven");

		Thread.sleep(5000);
		//Update Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		WebDriverWait wait2 = new WebDriverWait(driver, 50);
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='OK']"))).click();

		String phone_number_updated =  driver.findElement(By.id("pphone")).getText();

		Assert.assertEquals(phone_number_updated, number);

		Thread.sleep(7000);

		driver.quit();

	}






	//Customer is adding SubUser

	@Given("Mabel login into her account")
	public void mabel_login_into_her_account() throws Exception {

		driver = Open_Qa11_memberportal.open_Q11_Website();
		logger.info("Welcome to Q11 portal");
		Thread.sleep(10000);
	}


	@Then("Mabel view his profile")
	public void mabel_view_his_profile() throws Exception {

		//Go to profile
		WebElement profile = driver.findElement(By.className("m-topbar__username"));
		profile.click();

		Thread.sleep(3000);

		//Open profile
		WebElement open_profile = driver.findElement(By.xpath("//span[text()='My Profile']"));
		open_profile.click();

		Thread.sleep(7000);


	}


	@And("Mabel adds subuser Jake")
	public void mabel_adds_subuser_jake() throws Exception {

		//Subuser
		WebElement subuser =driver.findElement(By.partialLinkText("Subusers"));
		subuser.click();

		Thread.sleep(5000);

		WebElement add_subuser =driver.findElement(By.partialLinkText("Add Subuser"));
		add_subuser.click();

		Thread.sleep(5000);

		Adding_subuser.adding_subuser(driver, "Hosting_Memberpanel");

		Thread.sleep(5000);
		driver.manage().deleteAllCookies();


	}




	@Then("Jake login into Mabel account")
	public void jake_login_into_mabel_account() throws Exception {

		Switch_tab.switch_next_tab2(driver);
		driver.manage().deleteAllCookies();

		Thread.sleep(5000);

		driver = Open_Qa11_memberportal.open_Q11_Website_using_subUser_credentials(driver);
		logger.info("Welcome to Q11 portal");
		Thread.sleep(10000);

		String first_name = readconfig.get_suFirst_name();
		String profile_name = driver.findElement(By.className("m-topbar__username")).getText();

		Assert.assertEquals(profile_name, first_name);
		logger.info("username matched ");

		driver.quit();



	}




	

}
