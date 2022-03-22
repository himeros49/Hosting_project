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
import methods.Payments;
import methods.Switch_tab;
import methods_for_manageSubcription_admin.Create_subscription_admin;
import methods_for_manageSubcription_admin.Open_Qa11_adminportal_manage_subscription;
import methods_for_manageSubcription_admin.Suspend_subscription_admin;
import methods_for_manageSubcription_admin.Terminate_subscription_admin;
import methods_for_manageSubcription_admin.Unsuspend_subscription_admin;
import utilities.ReadConfig;

public class QA11_hostinglinux_manageSubscription_Admin {
	
	public WebDriver driver;
	private static Logger logger = LogManager.getLogger(QA11_hostinglinux_manageSubscription_Admin.class);
	public static ReadConfig readconfig = new ReadConfig();
	//Location Of Excel Sheet
	public static String xlpath = System.getProperty("user.dir") + "/src/main/resources/Q11-Hosting.xlsx";
	
	
	//Suspend Subscription
	
	@Given("Pluto login into Q11 Website")
	public void pluto_login_into_q11_website() throws Exception {
		driver = Open_Qa11_adminportal_manage_subscription.open_Q11_adminportal();
		
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


	@And("Pluto creates new account")
	public void pluto_creates_new_account() throws Exception {
		//Calling Method for NEW ACCOUNT CREATION
		New_account1.creating_new_account_from_admin_panel(driver,"Hosting_Memberpanel",3,19);
	}
	
	
	@Then("Pluto pay it by paypal payment")
	public void pluto_pay_it_by_paypal_payment() throws Exception {
		logger.info("Mode of Payment Paypal");

		Payments.payment_with_paypal(driver,"Hosting_paypal");

		logger.info("Payment Sucessfully done");
		
		driver.manage().deleteAllCookies();

		Thread.sleep(5000);	

		driver.close();

		driver = Switch_tab.switch_previous_tab2(driver);
	}
	
	
	@Then("Mickey view Billing")
	public void mickey_view_billing() throws Exception {
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
	}
	

	@Then("Mickey opens Pluto profile")
	public void mickey_opens_pluto_profile() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@class,'table table-bordered')]/following::table/tbody[1]/tr[1]/td[1]/a[1]")));
		
		WebElement user = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/following::table/tbody[1]/tr[1]/td[1]/a[1]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Perform Click on button using JavascriptExecutor		
        js.executeScript("arguments[0].click();", user);
        
        Switch_tab.switch_next_tab(driver);
        
        Thread.sleep(7000);

		
	}

	
	@Then("Mickey Suspends Pluto order")
	public void mickey_suspends_pluto_order() throws Exception {
	   
		Suspend_subscription_admin.suspend_my_subscription(driver);
        
        driver.quit();
 
	}

	
	
	
	//Unsuspend Subscription
	
	@Given("Wade login into Q11 Website")
	public void wade_login_into_q11_website() throws Exception {
		driver = Open_Qa11_adminportal_manage_subscription.open_Q11_adminportal();
		
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

	
	@And("Wade creates new account")
	public void wade_creates_new_account() throws Exception {
		//Calling Method for NEW ACCOUNT CREATION
				New_account1.creating_new_account_from_admin_panel(driver,"Hosting_Memberpanel",3,19);
	}
	
	
	@Then("Wade pay it by paypal payment")
	public void wade_pay_it_by_paypal_payment() throws Exception {
		logger.info("Mode of Payment Paypal");

		Payments.payment_with_paypal(driver,"Hosting_paypal");

		logger.info("Payment Sucessfully done");
		
		driver.manage().deleteAllCookies();

		Thread.sleep(5000);	

		driver.close();

		driver = Switch_tab.switch_previous_tab2(driver);
	}
	
	
	@Then("Foster view Billing")
	public void foster_view_billing() throws Exception {
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
	}

	
	@Then("Foster opens Wade profile")
	public void foster_opens_wade_profile() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@class,'table table-bordered')]/following::table/tbody[1]/tr[1]/td[1]/a[1]")));
		
		WebElement user = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/following::table/tbody[1]/tr[1]/td[1]/a[1]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Perform Click on button using JavascriptExecutor		
        js.executeScript("arguments[0].click();", user);
        
        Switch_tab.switch_next_tab(driver);
        
        Thread.sleep(7000);
	}

	
	@Then("Foster Unsuspends Wade order")
	public void foster_unsuspends_wade_order() throws Exception {
		Unsuspend_subscription_admin.unsuspend_my_subscription(driver);
        
        driver.quit();
	}

	
	
	
	//Terminate Subscription
	
	@Given("June login into Q11 Website")
	public void june_login_into_q11_website() throws Exception {
		driver = Open_Qa11_adminportal_manage_subscription.open_Q11_adminportal();
		
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

	
	@And("June creates new account")
	public void june_creates_new_account() throws Exception {
		//Calling Method for NEW ACCOUNT CREATION
		New_account1.creating_new_account_from_admin_panel(driver,"Hosting_Memberpanel",3,19);
	}
	
	
	@Then("June pay it by paypal payment")
	public void june_pay_it_by_paypal_payment() throws Exception {
		logger.info("Mode of Payment Paypal");

		Payments.payment_with_paypal(driver,"Hosting_paypal");

		logger.info("Payment Sucessfully done");
		
		driver.manage().deleteAllCookies();

		Thread.sleep(5000);	

		driver.close();

		driver = Switch_tab.switch_previous_tab2(driver);
	}
	
	
	@Then("Monty view Billing")
	public void monty_view_billing() throws Exception {
	    
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
		
		
	}
	
	
	@Then("Monty opens June profile")
	public void monty_opens_june_profile() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@class,'table table-bordered')]/following::table/tbody[1]/tr[1]/td[1]/a[1]")));
		
		WebElement user = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/following::table/tbody[1]/tr[1]/td[1]/a[1]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Perform Click on button using JavascriptExecutor		
        js.executeScript("arguments[0].click();", user);
        
        Switch_tab.switch_next_tab(driver);
        
        Thread.sleep(7000);
	}
	
	
	@Then("Monty terminate June order")
	public void monty_terminate_june_order() throws Exception {
	   Terminate_subscription_admin.terminate_my_subscription(driver);
	   
	   driver.quit();
		
		
	}
	
	
	
	
	//Create Subscription
	
	@Given("Daniel login into Q11 Website")
	public void daniel_login_into_q11_website() throws Exception {
		driver = Open_Qa11_adminportal_manage_subscription.open_Q11_adminportal();
		
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


	
	@And("Daniel creates new account")
	public void daniel_creates_new_account() throws Exception {
		//Calling Method for NEW ACCOUNT CREATION
		New_account1.creating_new_account_from_admin_panel(driver,"Hosting_Memberpanel",3,19);
	}
	
	
	@Then("Daniel pay it by paypal payment")
	public void daniel_pay_it_by_paypal_payment() throws Exception {
		logger.info("Mode of Payment Paypal");

		Payments.payment_with_paypal(driver,"Hosting_paypal");

		logger.info("Payment Sucessfully done");
		
		driver.manage().deleteAllCookies();

		Thread.sleep(5000);	

		driver.close();

		driver = Switch_tab.switch_previous_tab2(driver);
	}
	
	
	@Then("Oscar view Billing")
	public void oscar_view_billing() throws Exception {
	   
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
	}
	
	
	@Then("Oscar opens Daniel profile")
	public void oscar_opens_daniel_profile() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@class,'table table-bordered')]/following::table/tbody[1]/tr[1]/td[1]/a[1]")));
		
		WebElement user = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/following::table/tbody[1]/tr[1]/td[1]/a[1]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Perform Click on button using JavascriptExecutor		
        js.executeScript("arguments[0].click();", user);
        
        Switch_tab.switch_next_tab(driver);
        
        Thread.sleep(7000);
	}
	
	
	@Then("Oscar Create Daniel order")
	public void oscar_create_daniel_order() throws Exception {
	    
		Create_subscription_admin.create_my_subscription(driver);
		
		driver.quit();
		
	}

	

	
	
}
