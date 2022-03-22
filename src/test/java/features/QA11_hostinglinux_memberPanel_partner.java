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
import methods.Order_Details_Page;
import methods.Payments;
import methods.Switch_tab;
import methods_for_member_panel.Invoice_renewable;
import methods_for_member_panel.Open_Qa11_adminportal;
import methods_for_member_panel.Payments_for_member_panel;
import methods_for_member_panel.Renewable_on_off;
import methods_for_member_panel.Service_details;
import methods_for_member_panel_partner.Open_Qa11_memberportal_partner;
import methods_for_member_panel_partner.Open_Qa11_partnerportal;
import utilities.ReadConfig;
import utilities.XLutils;

public class QA11_hostinglinux_memberPanel_partner {
	
	public WebDriver driver;
	private static Logger logger = LogManager.getLogger(QA11_hostinglinux_memberPanel.class);
	public static ReadConfig readconfig = new ReadConfig();
	//Location Of Excel Sheet
	public static String xlpath = System.getProperty("user.dir") + "/src/main/resources/Q11-Hosting.xlsx";
	
	
	
	
	@Given("Cami buys the monthly plan of Hosting")
	public void cami_buys_the_monthly_plan_of_hosting() throws Exception {
		driver = Open_Qa11_partnerportal.open_Q11_partnerportal();
		
		//Choosing Domain
		driver = Adding_domain.entering_the_domin_from_partner_panel(driver);
		
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


	@Then("Cami creates her account")
	public void cami_creates_her_account() throws Exception {
		//Calling Method for NEW ACCOUNT CREATION
		New_account1.creating_new_account_from_partner_panel(driver,"Hosting_Memberpanel_partner",3,19);
	}
	
	
	@Then("Cami pays from paypal gateway")
	public void cami_pays_from_paypal_gateway() throws Exception {
		logger.info("Mode of Payment Paypal");

		Payments.payment_with_paypal(driver,"Hosting_paypal");

		logger.info("Payment Sucessfully done");
		
		driver.manage().deleteAllCookies();

		Thread.sleep(5000);	

		driver.close();

		driver = Switch_tab.switch_previous_tab2(driver);
		
		driver.manage().deleteAllCookies();
	}
	
	
	@Then("Cami login into her account")
	public void cami_login_into_her_account() throws Exception {
		
		driver =Open_Qa11_memberportal_partner.open_Q11_Website_general(driver, "Hosting_Memberpanel_partner",  3, 19);
		logger.info("Welcome to Q11 portal");
		Thread.sleep(10000);
	}
	
	
	@Then("Cami view her subscription")
	public void cami_view_her_subscription() throws Exception {
		Thread.sleep(7000);

		WebDriverWait waitInvoice = new WebDriverWait(driver, 60);
		waitInvoice.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='My Billing']")));

		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='My Billing']")).click();



		WebDriverWait wait2 = new WebDriverWait(driver, 60);
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Invoices']")));


		WebElement Invoice = driver.findElement(By.xpath("//span[text()='Invoices']"));
		//Creating the JavascriptExecutor interface object by Type casting		
		JavascriptExecutor js2 = (JavascriptExecutor)driver;

		//Perform Click on LOGIN button using JavascriptExecutor		
		js2.executeScript("arguments[0].click();", Invoice);
		
		
		WebDriverWait wait3 = new WebDriverWait(driver, 60);
		wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@class='la la-ellipsis-h']")));
		
		WebElement Invoicedd = driver.findElement(By.xpath("//i[@class='la la-ellipsis-h']"));
		//Creating the JavascriptExecutor interface object by Type casting		
				JavascriptExecutor js3 = (JavascriptExecutor)driver;

				//Perform Click on LOGIN button using JavascriptExecutor		
				js3.executeScript("arguments[0].click();", Invoicedd);
		
		
				Thread.sleep(3000);
				WebElement view_Invoice= driver.findElement(By.xpath("//a[contains(.,'View Invoice')]"));
				//Creating the JavascriptExecutor interface object by Type casting		
				JavascriptExecutor js4= (JavascriptExecutor)driver;

				//Perform Click on LOGIN button using JavascriptExecutor		
				js4.executeScript("arguments[0].click();", view_Invoice);
		
		
		
		Thread.sleep(5000);
		
		
		Invoice_renewable.capture_details_of_invoice_autoRenewable_on(driver, "Hosting_Memberpanel_partner");
		
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
	
	
	@Then("Cami turns ON renewal service")
	public void cami_turns_on_renewal_service() throws Exception {
		Thread.sleep(7000);
		Renewable_on_off.turn_on_renewable(driver);
	}
	
	
	@Then("Cami Renew her services")
	public void cami_renew_her_services() throws Exception {
		//Renewable Centre
				driver.findElement(By.partialLinkText("Renewal Center")).click();
				WebDriverWait wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Renew Now']")));
				
				
				Service_details.capture_service_details(driver, "Hosting_Memberpanel_partner", 15);
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
	
	
	@Then("Cami again pay for the service from Paypal")
	public void cami_again_pay_for_the_service_from_paypal() throws Exception {
		Payments_for_member_panel.paypal_payment_without_login(driver);
	}
	
	
	@Then("Cami verfies the invoice")
	public void cami_verfies_the_invoice() throws Exception {
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
				
				
				Service_details.capture_current_service(driver, "Hosting_Memberpanel_partner", 16);
				Thread.sleep(5000);
				driver.quit();
	}

	
	
	
	
	
	@Given("Clara buys the monthly plan of Hosting")
	public void clara_buys_the_monthly_plan_of_hosting() throws Exception {
driver = Open_Qa11_partnerportal.open_Q11_partnerportal();
		
		//Choosing Domain
		driver = Adding_domain.entering_the_domin_from_partner_panel(driver);
		
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

	
	@Then("Clara creates her account")
	public void clara_creates_her_account() throws Exception {
		//Calling Method for NEW ACCOUNT CREATION
		New_account1.creating_new_account_from_partner_panel(driver,"Hosting_Memberpanel_partner",3,19);
	}
	
	
	@Then("Clara pays from paypal gateway")
	public void clara_pays_from_paypal_gateway() throws Exception {
		logger.info("Mode of Payment Paypal");

		Payments.payment_with_paypal(driver,"Hosting_paypal");

		logger.info("Payment Sucessfully done");
		
		driver.manage().deleteAllCookies();

		Thread.sleep(5000);	

		driver.close();

		driver = Switch_tab.switch_previous_tab2(driver);
		
		driver.manage().deleteAllCookies();
	}
	
	
	@Then("Clara login into her account")
	public void clara_login_into_her_account() throws Exception {
		driver =Open_Qa11_memberportal_partner.open_Q11_Website_general(driver, "Hosting_Memberpanel_partner",  3, 19);
		logger.info("Welcome to Q11 portal");
		Thread.sleep(10000);
	}
	
	
	@Then("Clara view her subscription")
	public void clara_view_her_subscription() throws Exception {
		Thread.sleep(7000);

		WebDriverWait waitInvoice = new WebDriverWait(driver, 60);
		waitInvoice.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='My Billing']")));

		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='My Billing']")).click();



		WebDriverWait wait2 = new WebDriverWait(driver, 60);
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Invoices']")));


		WebElement Invoice = driver.findElement(By.xpath("//span[text()='Invoices']"));
		//Creating the JavascriptExecutor interface object by Type casting		
		JavascriptExecutor js2 = (JavascriptExecutor)driver;

		//Perform Click on LOGIN button using JavascriptExecutor		
		js2.executeScript("arguments[0].click();", Invoice);
		
		
		WebDriverWait wait3 = new WebDriverWait(driver, 60);
		wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@class='la la-ellipsis-h']")));
		
		WebElement Invoicedd = driver.findElement(By.xpath("//i[@class='la la-ellipsis-h']"));
		//Creating the JavascriptExecutor interface object by Type casting		
				JavascriptExecutor js3 = (JavascriptExecutor)driver;

				//Perform Click on LOGIN button using JavascriptExecutor		
				js3.executeScript("arguments[0].click();", Invoicedd);
		
		
				Thread.sleep(3000);
				WebElement view_Invoice= driver.findElement(By.xpath("//a[contains(.,'View Invoice')]"));
				//Creating the JavascriptExecutor interface object by Type casting		
				JavascriptExecutor js4= (JavascriptExecutor)driver;

				//Perform Click on LOGIN button using JavascriptExecutor		
				js4.executeScript("arguments[0].click();", view_Invoice);
		
		
		
		Thread.sleep(5000);
		
		
		Invoice_renewable.capture_details_of_invoice_autoRenewable_on(driver, "Hosting_Memberpanel_partner");
		
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
	
	
	@Then("Clara turns OFF renewal service")
	public void clara_turns_off_renewal_service() throws Exception {
		Thread.sleep(7000);
		Renewable_on_off.turn_off_renewable(driver);
	}
	
	
	@Then("Clara Renew her services")
	public void clara_renew_her_services() throws Exception {
		//Renewable Centre
		driver.findElement(By.partialLinkText("Renewal Center")).click();
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Renew Now']")));
		
		
		Service_details.capture_service_details(driver, "Hosting_Memberpanel_partner", 15);
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
	
	
	@Then("Clara again pay for the service from Paypal")
	public void clara_again_pay_for_the_service_from_paypal() throws Exception {
		Payments_for_member_panel.paypal_payment_without_login(driver);
	}
	
	
	@Then("Clara verfies the invoice")
	public void clara_verfies_the_invoice() throws Exception {
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
				
				
				Service_details.capture_current_service(driver, "Hosting_Memberpanel_partner", 16);
				Thread.sleep(5000);
				driver.quit();
	}




	//Customer i.e., Chole is Updating his Service plan
	
	@Given("Chole login into her account")
	public void chole_login_into_her_account() throws Exception {
		driver = Open_Qa11_memberportal_partner.open_Q11_Website();
		logger.info("Welcome to Q11 portal");
		Thread.sleep(10000);
	}



	@Then("Chole view his subscription")
	public void chole_view_his_subscription() throws Exception {
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
		Service_details.capture_current_service(driver, "Hosting_Memberpanel_partner", 40);
		Thread.sleep(3000);
	    
		
		driver.findElement(By.partialLinkText("Linux Hosting New - Gold")).click();
	    WebDriverWait wait = new WebDriverWait(driver, 50);
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.name("update")));
	}
	
	
	
	@Then("Chole update his subscription")
	public void chole_update_his_subscription() throws Exception {
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
	
	
	@Then("Chole checks his plan")
	public void chole_checks_his_plan() throws Exception {
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
		
		
		Service_details.capture_current_service(driver, "Hosting_Memberpanel_partner", 41);
		Thread.sleep(5000);
		driver.quit();
	}


	
	
	
	
	@Given("Noami buys the monthly plan of Hosting")
	public void noami_buys_the_monthly_plan_of_hosting() throws Exception {
		driver = Open_Qa11_partnerportal.open_Q11_partnerportal();
		
		//Choosing Domain
		driver = Adding_domain.entering_the_domin_from_partner_panel(driver);
		
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


	@Then("Noami creates her account")
	public void noami_creates_her_account() throws Exception {
		//Calling Method for NEW ACCOUNT CREATION
		New_account1.creating_new_account_from_partner_panel(driver,"Hosting_Memberpanel_partner",3,19);
		
	}
	
	
	@Then("Noami pays from bank gateway")
	public void noami_pays_from_bank_gateway() throws Exception {
		logger.info("Mode of Payment Bank");

		Payments.payment_with_bank(driver,"Hosting_bank_partner");

		logger.info("Payment Sucessfully done");

		Thread.sleep(5000);	

		driver.close();

		driver = Switch_tab.switch_previous_tab2(driver);
	}
	
	
	@Then("Noami order get reviewed from Admin Panel")
	public void noami_order_get_reviewed_from_admin_panel() throws Exception {
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
		ac.moveToElement(driver.findElement(By.xpath("(//span[text()='List'])[5]"))).click().perform();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(7000);
		
		
		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[1]")));
		
		String order_number = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[1]")).getText();
		XLutils.setCellData(xlpath , "Hosting_Memberpanel_partner" , 63 , 3 , order_number);
		
		String order_status = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[4]/span[1]")).getText();
		XLutils.setCellData(xlpath , "Hosting_Memberpanel_partner" , 63 , 4 , order_status);

		Thread.sleep(7000);
	}
	
	
	
	@Then("Noami login into her account in memeber panel")
	public void noami_login_into_her_account_in_memeber_panel() throws Exception {
		
		Switch_tab.switch_next_tab2(driver);
		
		driver =Open_Qa11_memberportal_partner.open_Q11_Website_general(driver, "Hosting_Memberpanel_partner",  3, 19);
		logger.info("Welcome to Q11 portal");
		Thread.sleep(10000);
		
	}
	
	
	@Then("Noami pays the due amount")
	public void noami_pays_the_due_amount() throws Exception {
		Thread.sleep(7000);

		WebDriverWait waitInvoice = new WebDriverWait(driver, 60);
		waitInvoice.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='My Billing']")));

		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='My Billing']")).click();



		WebDriverWait wait2 = new WebDriverWait(driver, 60);
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Orders']")));


		WebElement orders = driver.findElement(By.xpath("//span[text()='Orders']"));
		//Creating the JavascriptExecutor interface object by Type casting		
		JavascriptExecutor js2 = (JavascriptExecutor)driver;

		//Perform Click on LOGIN button using JavascriptExecutor		
		js2.executeScript("arguments[0].click();", orders);
		
		
		WebDriverWait wait3 = new WebDriverWait(driver, 60);
		wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@class='la la-ellipsis-h']")));
		
		WebElement orderdd = driver.findElement(By.xpath("//i[@class='la la-ellipsis-h']"));
		//Creating the JavascriptExecutor interface object by Type casting		
				JavascriptExecutor js3 = (JavascriptExecutor)driver;

				//Perform Click on LOGIN button using JavascriptExecutor		
				js3.executeScript("arguments[0].click();", orderdd);
		
		
				Thread.sleep(3000);
				WebElement next= driver.findElement(By.linkText("Next"));
				//Creating the JavascriptExecutor interface object by Type casting		
				JavascriptExecutor js4= (JavascriptExecutor)driver;

				//Perform Click on LOGIN button using JavascriptExecutor		
				js4.executeScript("arguments[0].click();", next);
				
				Thread.sleep(5000);
				
				//Okay button
				driver.findElement(By.xpath("//button[text()='Ok']")).click();
				
				Thread.sleep(5000);
				
				
				Payments_for_member_panel.paypal_payment(driver);
				
				driver.close();
				
				Switch_tab.switch_previous_tab2(driver);
	}

	
	@Then("Noami verifies the order")
	public void noami_verifies_the_order() throws Exception {
		
		driver.navigate().refresh();
		
		
		String order_number = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[1]")).getText();
		XLutils.setCellData(xlpath , "Hosting_Memberpanel_partner" , 65 , 3 , order_number);
		
		String order_status = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[4]/span[1]")).getText();
		XLutils.setCellData(xlpath , "Hosting_Memberpanel_partner" , 65 , 4 , order_status);

		Thread.sleep(7000);
		driver.quit();
	}

	
	
	
	
	
	@Given("Violet buys the monthly plan of Hosting")
	public void violet_buys_the_monthly_plan_of_hosting() throws Exception {
driver = Open_Qa11_partnerportal.open_Q11_partnerportal();
		
		//Choosing Domain
		driver = Adding_domain.entering_the_domin_from_partner_panel(driver);
		
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

	
	@Then("Violet creates her account")
	public void violet_creates_her_account() throws Exception {
		//Calling Method for NEW ACCOUNT CREATION
				New_account1.creating_new_account_from_partner_panel(driver,"Hosting_Memberpanel_partner",3,19);
	}
	
	
	@Then("Violet pays from bank gateway")
	public void violet_pays_from_bank_gateway() throws Exception {
		logger.info("Mode of Payment Bank");

		Payments.payment_with_bank(driver,"Hosting_bank_partner");

		logger.info("Payment Sucessfully done");

		Thread.sleep(5000);	

		driver.close();

		driver = Switch_tab.switch_previous_tab2(driver);
	}
	
	
	@Then("Violet order get approved from Admin Panel")
	public void violet_order_get_approved_from_admin_panel() throws Exception {
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
		ac.moveToElement(driver.findElement(By.xpath("(//span[text()='List'])[5]"))).click().perform();

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
	
	
	@Then("Violet login into her account in memeber panel")
	public void violet_login_into_her_account_in_memeber_panel() throws Exception {
		
		Thread.sleep(5000);

		Switch_tab.switch_previous_tab2(driver);
		
		Thread.sleep(3000);
		
		Switch_tab.switch_next_tab2(driver);
		
		driver =Open_Qa11_memberportal_partner.open_Q11_Website_general(driver, "Hosting_Memberpanel_partner",  3, 19);
		logger.info("Welcome to Q11 portal");
		Thread.sleep(10000);
	}
	
	
	@Then("Violet pays the due amount")
	public void violet_pays_the_due_amount() throws Exception {
		Thread.sleep(7000);

		WebDriverWait waitInvoice = new WebDriverWait(driver, 60);
		waitInvoice.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='My Billing']")));

		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='My Billing']")).click();



		WebDriverWait wait2 = new WebDriverWait(driver, 60);
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Invoices']")));


		WebElement Invoice = driver.findElement(By.xpath("//span[text()='Invoices']"));
		//Creating the JavascriptExecutor interface object by Type casting		
		JavascriptExecutor js2 = (JavascriptExecutor)driver;

		//Perform Click on LOGIN button using JavascriptExecutor		
		js2.executeScript("arguments[0].click();", Invoice);
		
		
		WebDriverWait wait3 = new WebDriverWait(driver, 60);
		wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@onclick='renew_these();']")));
		
		WebElement next = driver.findElement(By.xpath("//a[@onclick='renew_these();']"));
		//Creating the JavascriptExecutor interface object by Type casting		
				JavascriptExecutor js3 = (JavascriptExecutor)driver;

				//Perform Click on LOGIN button using JavascriptExecutor		
				js3.executeScript("arguments[0].click();", next);
		
		
				Thread.sleep(3000);
				WebElement okay= driver.findElement(By.xpath("//button[text()='Ok']"));
				//Creating the JavascriptExecutor interface object by Type casting		
				JavascriptExecutor js4= (JavascriptExecutor)driver;

				//Perform Click on LOGIN button using JavascriptExecutor		
				js4.executeScript("arguments[0].click();", okay);
			
				
				Payments_for_member_panel.paypal_payment(driver);
				
				driver.close();
				
				Switch_tab.switch_previous_tab2(driver);
				
				
				
				
	}
	
	
	@Then("Violet verifies the invoice")
	public void violet_verifies_the_invoice() throws Exception {
		driver.navigate().refresh();
		
		Thread.sleep(7000);
		
		String order_status = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[4]/span[1]")).getText();
		XLutils.setCellData(xlpath , "Hosting_Memberpanel_partner" , 50 , 4 , order_status);
		
		
		Order_Details_Page.go_to_invoice(driver);
		
		Switch_tab.switch_next_tab(driver);
		
		Thread.sleep(5000);
		
		
		String invoice_number = driver.findElement(By.xpath("(//table[@class='invoice']//table)[3]/tbody[1]/tr[1]/td[2]")).getText();
		XLutils.setCellData(xlpath , "Hosting_Memberpanel_partner" , 50 , 3 , invoice_number);
		
		Thread.sleep(5000);
		
		driver.quit();
		
		
	}

	
	
	
	
	@Given("Pearl login into his account")
	public void pearl_login_into_his_account() throws Exception {
		
		
		
		driver =Open_Qa11_memberportal_partner.open_Q11_Website();
		logger.info("Welcome to Q11 portal");
		Thread.sleep(10000);
	}


	@Then("Pearl view his profile")
	public void pearl_view_his_profile() throws Exception {
		//Go to profile
				WebElement profile = driver.findElement(By.className("m-topbar__username"));
				profile.click();

				Thread.sleep(3000);

				//Open profile
				WebElement open_profile = driver.findElement(By.xpath("//span[text()='My Profile']"));
				open_profile.click();

				Thread.sleep(7000);
	}
	
	
	@Then("Pearl Updates his profile")
	public void pearl_updates_his_profile() throws Exception {
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

	
	
	

}
