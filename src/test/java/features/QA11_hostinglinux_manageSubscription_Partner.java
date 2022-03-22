package features;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import methods.Payments;
import methods.Switch_tab;
import methods_for_manageSubcription_admin.Terminate_subscription_admin;
import methods_for_manageSubscription_partner.Create_subscription_partner;
import methods_for_manageSubscription_partner.Open_Qa11_partnerportal_manage_subscription;
import methods_for_manageSubscription_partner.Suspend_subscription_partner;
import methods_for_manageSubscription_partner.Unsuspend_subscription_partner;
import utilities.ReadConfig;

public class QA11_hostinglinux_manageSubscription_Partner {
	
	

	public WebDriver driver;
	private static Logger logger = LogManager.getLogger(QA11_hostinglinux_memberPanel.class);
	public static ReadConfig readconfig = new ReadConfig();
	//Location Of Excel Sheet
	public static String xlpath = System.getProperty("user.dir") + "/src/main/resources/Q11-Hosting.xlsx";
	
	
//	Hosting_manage_subscription_ptr
	@Given("Ash login into Q11 Website")
	public void ash_login_into_q11_website() throws Exception {
		driver = Open_Qa11_partnerportal_manage_subscription.open_Q11_partnerportal();
		
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

	
	@And("Ash creates new account")
	public void ash_creates_new_account() throws Exception {
		//Calling Method for NEW ACCOUNT CREATION
		New_account1.creating_new_account_from_partner_panel(driver,"Hosting_manage_subscription_ptr",3,19);
	}
	
	
	@Then("Ash pay it by paypal payment")
	public void ash_pay_it_by_paypal_payment() throws Exception {
		logger.info("Mode of Payment Paypal");

		Payments.payment_with_paypal(driver,"Hosting_paypal");

		logger.info("Payment Sucessfully done");
		
		driver.manage().deleteAllCookies();

		Thread.sleep(5000);	

		driver.close();

		driver = Switch_tab.switch_previous_tab2(driver);
	}
	
	
	@Then("Asher view Billing")
	public void asher_view_billing() throws Exception {
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
		
		
		
		
		
	}
	
	
	@Then("Asher opens Ash profile")
	public void asher_opens_ash_profile() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@class,'table table-bordered')]/following::table/tbody[1]/tr[1]/td[1]/a[1]")));
		
		WebElement user = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/following::table/tbody[1]/tr[1]/td[1]/a[1]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Perform Click on button using JavascriptExecutor		
        js.executeScript("arguments[0].click();", user);
        
        Switch_tab.switch_next_tab(driver);
        
        Thread.sleep(7000);
	}
	
	
	@Then("Asher Suspends Ash order")
	public void asher_suspends_ash_order() throws Exception {
		Suspend_subscription_partner.suspend_my_subscription(driver);
        
        driver.quit();
 
	}
	
	
	
	
	//Unsuspending subscription
	
	@Given("Xavier login into Q11 Website")
	public void xavier_login_into_q11_website() throws Exception {
		driver = Open_Qa11_partnerportal_manage_subscription.open_Q11_partnerportal();
		
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

	
	@And("Xavier creates new account")
	public void xavier_creates_new_account() throws Exception {
		//Calling Method for NEW ACCOUNT CREATION
				New_account1.creating_new_account_from_partner_panel(driver,"Hosting_manage_subscription_ptr",3,19);
	}
	
	
	@Then("Xavier pay it by paypal payment")
	public void xavier_pay_it_by_paypal_payment() throws Exception {
		logger.info("Mode of Payment Paypal");

		Payments.payment_with_paypal(driver,"Hosting_paypal");

		logger.info("Payment Sucessfully done");
		
		driver.manage().deleteAllCookies();

		Thread.sleep(5000);	

		driver.close();

		driver = Switch_tab.switch_previous_tab2(driver);
	}

	
	@Then("Timber view Billing")
	public void timber_view_billing() throws Exception {
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
	
	}
	
	
	@Then("Timber opens Xavier profile")
	public void timber_opens_xavier_profile() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@class,'table table-bordered')]/following::table/tbody[1]/tr[1]/td[1]/a[1]")));
		
		WebElement user = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/following::table/tbody[1]/tr[1]/td[1]/a[1]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Perform Click on button using JavascriptExecutor		
        js.executeScript("arguments[0].click();", user);
        
        Switch_tab.switch_next_tab(driver);
        
        Thread.sleep(7000);
	}
	
	
	@Then("Timber Suspends Xavier order")
	public void timber_suspends_xavier_order() throws Exception {
		Unsuspend_subscription_partner.unsuspend_my_subscription(driver);
        
        driver.quit();	;
	}

	
	
	
	//Terminate Subscription
	
	@Given("Axel login into Q11 Website")
	public void axel_login_into_q11_website() throws Exception {
		driver = Open_Qa11_partnerportal_manage_subscription.open_Q11_partnerportal();
		
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

	
	@And("Axel creates new account")
	public void axel_creates_new_account() throws Exception {
		//Calling Method for NEW ACCOUNT CREATION
		New_account1.creating_new_account_from_partner_panel(driver,"Hosting_manage_subscription_ptr",3,19);
	}
	
	
	@Then("Axel pay it by paypal payment")
	public void axel_pay_it_by_paypal_payment() throws Exception {
		logger.info("Mode of Payment Paypal");

		Payments.payment_with_paypal(driver,"Hosting_paypal");

		logger.info("Payment Sucessfully done");
		
		driver.manage().deleteAllCookies();

		Thread.sleep(5000);	

		driver.close();

		driver = Switch_tab.switch_previous_tab2(driver);
	}
	
	
	@Then("Aston view Billing")
	public void aston_view_billing() throws Exception {
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
	}
	
	
	@Then("Aston opens Axel profile")
	public void aston_opens_axel_profile() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@class,'table table-bordered')]/following::table/tbody[1]/tr[1]/td[1]/a[1]")));
		
		WebElement user = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/following::table/tbody[1]/tr[1]/td[1]/a[1]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Perform Click on button using JavascriptExecutor		
        js.executeScript("arguments[0].click();", user);
        
        Switch_tab.switch_next_tab(driver);
        
        Thread.sleep(7000);
	}
	
	
	@Then("Aston Suspends Axel order")
	public void aston_suspends_axel_order() throws Exception {
	    
		Terminate_subscription_admin.terminate_my_subscription(driver);
		
		driver.quit();
		
		
	}

	
	
	
	//Create Subscription
	
	@Given("David login into Q11 Website")
	public void david_login_into_q11_website() throws Exception {
		driver = Open_Qa11_partnerportal_manage_subscription.open_Q11_partnerportal();
		
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


	@And("David creates new account")
	public void david_creates_new_account() throws Exception {
		//Calling Method for NEW ACCOUNT CREATION
				New_account1.creating_new_account_from_partner_panel(driver,"Hosting_manage_subscription_ptr",3,19);
	}
	
	
	@Then("David pay it by paypal payment")
	public void david_pay_it_by_paypal_payment() throws Throwable {
		logger.info("Mode of Payment Paypal");

		Payments.payment_with_paypal(driver,"Hosting_paypal");

		logger.info("Payment Sucessfully done");
		
		driver.manage().deleteAllCookies();

		Thread.sleep(5000);	

		driver.close();

		driver = Switch_tab.switch_previous_tab2(driver);
		
	}
	
	
	@Then("Tyler view Billing")
	public void tyler_view_billing() throws Exception {
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
	}
	
	
	@Then("Tyler opens David profile")
	public void tyler_opens_david_profile() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@class,'table table-bordered')]/following::table/tbody[1]/tr[1]/td[1]/a[1]")));
		
		WebElement user = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/following::table/tbody[1]/tr[1]/td[1]/a[1]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Perform Click on button using JavascriptExecutor		
        js.executeScript("arguments[0].click();", user);
        
        Switch_tab.switch_next_tab(driver);
        
        Thread.sleep(7000);
	}
	
	
	@Then("Tyler Create David order")
	public void tyler_create_david_order() throws Exception {
	   Create_subscription_partner.create_my_subscription(driver);
	   
	   driver.quit();
	}
	
	
}
