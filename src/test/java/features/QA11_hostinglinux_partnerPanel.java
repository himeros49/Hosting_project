package features;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import methods.Adding_Credit_Balance;
import methods.Adding_customer;
import methods.Adding_domain;
import methods.After_account_creation;
import methods.Auto_Renewable;
import methods.Cancel_order;
import methods.Choosing_hosting_custom_plan;
import methods.Custom_invoice;
import methods.Invoice1;
import methods.Invoice2;
import methods.Invoice_partner;
import methods.Ledger;
import methods.Logs_and_Emails;
import methods.New_account1;
import methods.Open_Q11_portal;
import methods.Order_Details_Page;
import methods.Order_summary_page;
import methods.Payments;
import methods.Receipt;
import methods.Reload_WebPage;
import methods.Subcontact;
import methods.Subscription_Details;
import methods.Switch_tab;
import methods.ThirdModule_settings;

import org.openqa.selenium.JavascriptExecutor;
import java.util.ArrayList;
import java.util.Set;

public class QA11_hostinglinux_partnerPanel {

	public WebDriver driver;

	private static Logger logger = LogManager.getLogger(QA11_hostinglinux_partnerPanel.class);


	// ***********  From Partner Panel ***********//




	//Buying Product via Bank from Partner panel   (Excel sheet-- "Hosting_bank_partner")


	@Given("Neville login into Q11 partner portal")
	public void neville_login_into_q11_partner_portal() throws Exception {

		driver = Open_Q11_portal.open_Q11_Partnerpanel();
		logger.info("Welcome to Q11 Partner portal");
		Thread.sleep(15000);

		try
		{

			//Settings DropDown
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Settings")));

			WebElement setting = driver.findElement(By.partialLinkText("Settings"));
			setting.click();	
			logger.info("try block ");

		}
		catch(Exception x)
		{
			logger.info("Catch Block .....Please help me.......");
			System.out.println(x.getStackTrace());
			driver.navigate().refresh();
			logger.info("Page Refreshed");
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			Thread.sleep(30000);
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Settings']")));
			WebElement setting = driver.findElement(By.xpath("//span[text()='Settings']"));
			setting.click();

		}

		Thread.sleep(2000);
		Actions ac = new Actions(driver);

		ac.moveToElement(driver.findElement(By.xpath("//span[text()='Offers']")));
		ac.pause(20);
		Thread.sleep(2000);
		ac.moveToElement(driver.findElement(By.xpath("//span[text()='Basic Configuration']"))).click().perform();
		Thread.sleep(2000);

	}

	
	@Then("Neville Choose Linux Hosting Gold Offer plan")
	public void neville_choose_linux_hosting_gold_offer_plan() throws Exception {

		driver = Choosing_hosting_custom_plan.select_hosting_plan_partner_panel(driver, "monthly");
		logger.info("Monthly plan is opened");


	}

	
	@When("Neville open Monthly plan and add it to cart")
	public void neville_open_monthly_plan_and_add_it_to_cart() throws Exception {


		//Choosing Domain
		driver = Adding_domain.entering_the_domin_from_partner_panel(driver);


		//calling Order Summary Page Method 
		Order_summary_page.capture_data_from_order_summary_page(driver, "Hosting_bank");
		logger.info("All Details from summary Page is captured");


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


	@And("Neville creates new account")
	public void neville_creates_new_account() throws Exception {

		//Calling Method for NEW ACCOUNT CREATION
		New_account1.creating_new_account_from_partner_panel(driver,"Hosting_bank_partner",3,10);


		///After Account Creation
		logger.info("After Account Creation");
		Thread.sleep(7000);

		After_account_creation.capture_data_after_account_creation_from_partner_panel(driver, "Hosting_bank_partner");

		logger.info("All Details after creating an account is captured");

		Thread.sleep(5000);

	}


	@Then("Neville pay it by bank payment")
	public void neville_pay_it_by_bank_payment() throws Exception {

		logger.info("Mode of Payment Bank");

		Payments.payment_with_bank(driver,"Hosting_bank_partner");

		logger.info("Payment Sucessfully done");

		Thread.sleep(5000);	

		driver.close();

		driver = Switch_tab.switch_previous_tab2(driver);
	}


	@And("Lockhart view Billing")
	public void lockhart_view_billing() throws Exception {

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

		Order_Details_Page.capture_data_of_order_details_page_before_approval(driver, "Hosting_bank_partner");

	}


	@Then("Lockhart Approve for product")
	public void lockhart_approve_for_product() throws Exception {

		Order_Details_Page.approve_order(driver);

		Order_Details_Page.capture_data_of_order_details_page_after_approval(driver, "Hosting_bank_partner");


	}


	@And("Lockhart clicks on invoice")
	public void lockhart_clicks_on_invoice() throws Exception {

		Order_Details_Page.go_to_invoice(driver);
		Thread.sleep(3000);

	}


	@Then("Lockhart verifies the invoice")
	public void lockhart_verifies_the_invoice() throws Exception {

		Switch_tab.switch_next_tab(driver);
		
//      ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//      driver.switchTo().window(tabs.get(1));

		Thread.sleep(5000);

		Invoice_partner.capture_invoice_ordered_with_bank(driver, "Hosting_bank_partner");
		
		Thread.sleep(7000);

		driver.close();
		
		Thread.sleep(3000);
		
		Switch_tab.switch_previous_tab2(driver);	
	}


	@And("Lockhart opens Ronald profile")
	public void lockhart_opens_ronald_profile() throws Exception {
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/following::table/tbody[1]/tr[1]/td[1]/a[1]")).click();
		
		Thread.sleep(5000);
		
		Switch_tab.switch_next_tab(driver);
		
		
	}


	@Then("Lockhart verifies the log and emails")
	public void lockhart_verifies_the_log_and_emails() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Supports']")));
		
		//Open Support Section
		driver.findElement(By.xpath("//span[text()='Supports']")).click();
		Thread.sleep(2000);

		//click on logs
		driver.findElement(By.xpath("//span[text()='Logs']")).click();
		Thread.sleep(3000);
		
		
		//capture data of logs
		Logs_and_Emails.capture_details_of_logs(driver, "Hosting_bank",5);
		Thread.sleep(5000);
		
		//clicks on email
		driver.findElement(By.xpath("//span[text()='Email Logs']")).click();
		
		Thread.sleep(3000);
		
		////capture data of emails
		Logs_and_Emails.capture_details_of_emails(driver, "Hosting_bank",2);
	
		driver.quit();
		
		
	}




	//Buying Product via Paypal from Partner panel   (Excel sheet-- "Hosting_paypal_partner")

	
	@Given("Hermione login into Q11 partner portal")
	public void hermione_login_into_q11_partner_portal() throws Exception {

		driver = Open_Q11_portal.open_Q11_Partnerpanel();
		logger.info("Welcome to Q11 Partner portal");
		Thread.sleep(15000);

		try
		{

			//Settings DropDown
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Settings")));

			WebElement setting = driver.findElement(By.partialLinkText("Settings"));
			setting.click();	
			logger.info("try block ");

		}
		catch(Exception x)
		{
			logger.info("Catch Block .....Please help me.......");
			System.out.println(x.getStackTrace());
			driver.navigate().refresh();
			logger.info("Page Refreshed");
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			Thread.sleep(30000);
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Settings']")));
			WebElement setting = driver.findElement(By.xpath("//span[text()='Settings']"));
			setting.click();

		}

		Thread.sleep(2000);
		Actions ac = new Actions(driver);

		ac.moveToElement(driver.findElement(By.xpath("//span[text()='Offers']")));
		ac.pause(20);
		Thread.sleep(2000);
		ac.moveToElement(driver.findElement(By.xpath("//span[text()='Basic Configuration']"))).click().perform();
		Thread.sleep(2000);

	}

	
	@Then("Hermione Choose Linux Hosting Gold Offer plan")
	public void hermione_choose_linux_hosting_gold_offer_plan() throws Exception {

		driver = Choosing_hosting_custom_plan.select_hosting_plan_partner_panel(driver, "monthly");
		logger.info("Monthly plan is opened");

	}

	
	@When("Hermione open Monthly plan add it to cart")
	public void hermione_open_monthly_plan_add_it_to_cart() throws Exception {

		//Choosing Domain
		driver = Adding_domain.entering_the_domin_from_partner_panel(driver);


		//calling Order Summary Page Method 
		Order_summary_page.capture_data_from_order_summary_page(driver, "Hosting_paypal_partner");
		logger.info("All Details from summary Page is captured");


		//Add to cart button
		driver.findElement(By.id("submit")).click();
		Thread.sleep(5000);

		driver.findElement(By.id("next_without_login")).click();
		Thread.sleep(3000);


		//create an Account
		driver.findElement(By.id("sign-up-sec")).click();
		Thread.sleep(3000);
		logger.info("Going to Create New Account");

	}


	@When("Hermione creates new account")
	public void hermione_creates_new_account() throws Exception {

		//Calling Method for NEW ACCOUNT CREATION
		New_account1.creating_new_account_from_partner_panel(driver,"Hosting_paypal_partner",3,10);


		///After Account Creation
		logger.info("After Account Creation");
		Thread.sleep(7000);

		After_account_creation.capture_data_after_account_creation_from_partner_panel(driver, "Hosting_paypal_partner");

		logger.info("All Details after creating an account is captured");

		Thread.sleep(5000);

	}


	@Then("Hermione pay it by paypal payment")
	public void hermione_pay_it_by_paypal_payment() throws Exception {

		Payments.payment_with_paypal(driver, "Hosting_paypal_partner");	
		
		driver.close();		

		driver = Switch_tab.switch_previous_tab2(driver);

	}


	@Then("Hagrid view Billing")
	public void hagrid_view_billing() throws Exception {

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

		Order_Details_Page.capture_data_of_order_details_page_before_approval(driver, "Hosting_paypal_partner");
		Thread.sleep(5000);
	}


	@Then("Hagrid verifies the invoice")
	public void hagrid_verifies_the_invoice() throws Exception {

		Order_Details_Page.go_to_invoice(driver);
		Thread.sleep(3000);

		Switch_tab.switch_next_tab(driver);
		

//      ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//      driver.switchTo().window(tabs.get(1));


		Thread.sleep(5000);

		Invoice_partner.capture_invoice_ordered_with_paypal(driver, "Hosting_paypal_partner");


		Thread.sleep(7000);
		//Closes both Tabs 
		driver.quit();


	}

	
	


	//Customer adding Lending Credit and again Order via Credit Limit  (Sheet Name = "Hosting_CreditLimit_partner")

	
	@Given("Susan login into Q11 partner portal")
	public void susan_login_into_q11_partner_portal() throws Exception {

		//Launching Browser
		driver = Open_Q11_portal.open_Q11_Partnerpanel();
		logger.info("Welcome to Q11 Partner portal");
		Thread.sleep(15000);

	}

	
	@Then("Susan open his account and add credit limit")
	public void susan_open_his_account_and_add_credit_limit() throws Exception {

		Adding_customer.add_customer_in_partner_panel(driver, "Hosting_CreditLimit_partner");


		Thread.sleep(7000);

		try {
			//selecting customer
			driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[3]/a[1]")).click();

		}
		catch(Exception x)
		{

			driver.navigate().refresh();
			Thread.sleep(10000);
			driver.findElement(By.xpath("(//table[@class='table table-bordered']//a)[1]")).click();

		}

		//Profile
		driver.findElement(By.xpath("//span[text()='Profile']")).click();

		Thread.sleep(5000);

		//Billing Details 
		driver.findElement(By.linkText("Billing Details")).click();

		Thread.sleep(5000);

		//adding credit
		driver.findElement(By.id("credit_limit")).sendKeys("3000");

		//Update Button
		driver.findElement(By.id("client_update_button")).click();

		Thread.sleep(5000);
	}

	
	@Then("Susan Choose Linux Hosting Gold Offer plan")
	public void susan_choose_linux_hosting_gold_offer_plan() throws Exception {

		try
		{

			//Settings DropDown
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Settings']")));

			WebElement setting = driver.findElement(By.xpath("//span[text()='Settings']"));
			setting.click();		



			logger.info("try block ");


			logger.info("Settings Openend");
			Thread.sleep(3000);
			Actions ac = new Actions(driver);

			ac.moveToElement(driver.findElement(By.xpath("(//span[contains(.,'Offers')])[2]")));
			ac.moveToElement(driver.findElement(By.xpath("//span[contains(.,'Basic Configuration')]"))).click().perform();
			Thread.sleep(2000);

		}
		catch(Exception x)
		{
			logger.info("Catch Block .....Please help me.......");
			System.out.println(x.getStackTrace());
			driver.navigate().refresh();
			logger.info("Page Refreshed");
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			Thread.sleep(60000);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#kt_header_menu>ul>li:nth-of-type(8)>a>span")));

			driver.findElement(By.cssSelector("div#kt_header_menu>ul>li:nth-of-type(8)>a>span")).click();
			Actions ac = new Actions(driver);

			ac.moveToElement(driver.findElement(By.xpath("(//span[contains(.,'Offers')])[2]")));
			ac.moveToElement(driver.findElement(By.xpath("//span[contains(.,'Basic Configuration')]"))).click().perform();
			Thread.sleep(2000);

		}


		try {

			driver = Choosing_hosting_custom_plan.select_hosting_plan_admin_panel(driver,"Monthly");

		}
		catch(Exception x)
		{
			Thread.sleep(5000);
			driver.navigate().refresh();
			driver = Choosing_hosting_custom_plan.select_hosting_plan_admin_panel(driver,"Monthly");

		}



	}

	
	@When("Susan open Monthly plan add it to cart")
	public void susan_open_monthly_plan_add_it_to_cart() throws Exception {

		//Choosing Domain
		driver = Adding_domain.entering_the_domin_from_partner_panel(driver);


		//calling Order Summary Page Method 
		Order_summary_page.capture_data_from_order_summary_page(driver, "Hosting_CreditLimit_partner");
		logger.info("All Details from summary Page is captured");


		//Add to cart button
		driver.findElement(By.id("submit")).click();
		Thread.sleep(5000);

		driver.findElement(By.id("next_without_login")).click();
		Thread.sleep(3000);

	}


	@When("Susan login with his account")
	public void susan_login_with_his_account() throws Exception {

		//Location Of Excel Sheet
		String xlpath = System.getProperty("user.dir") + "/src/main/resources/Q11-Hosting.xlsx";

		///Opening Excel Sheet
		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet("Hosting_CreditLimit_partner");


		String Username = sheet.getRow(3).getCell(10).getStringCellValue();
		String password = sheet.getRow(4).getCell(10).getStringCellValue();


		driver.findElement(By.name("user")).sendKeys(Username);
		Thread.sleep(3000);

		driver.findElement(By.id("login_form_password")).sendKeys(password);
		Thread.sleep(3000);


		driver.findElement(By.name("log_in")).click();
		Thread.sleep(3000);

		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
		fi.close();
		fos.close();

	}


	@Then("Susan pay it by credit payment")
	public void susan_pay_it_by_credit_payment() throws Exception {

		After_account_creation.capture_data_after_account_creation_from_admin_panel(driver, "Hosting_CreditLimit_partner");

		Thread.sleep(5000);

		driver.findElement(By.id("make_payment")).click();

		Thread.sleep(5000);

		try 
		{

			driver.findElement(By.id("adjust_with_credit")).click();

		}
		catch(Exception x)
		{
			driver.findElement(By.name("adjust_with_credit")).click();
		}
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[contains(@class,'confirm btn')]")).click();

		Thread.sleep(7000);
		
		driver.close();

		driver = Switch_tab.switch_previous_tab2(driver);

	}


	@Then("BartyCrouch view Billing")
	public void barty_crouch_view_billing() throws Exception {

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
		try {
			ac.moveToElement(driver.findElement(By.xpath("(//span[text()='List'])[5]"))).click().perform();

		}
		catch(Exception x)
		{
			ac.moveToElement(driver.findElement(By.cssSelector("div#kt_header_menu>ul>li:nth-of-type(4)>div>ul>li>div>ul>li>a>span"))).click().perform();	
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(7000);

		Order_Details_Page.capture_data_of_order_details_page_before_approval(driver, "Hosting_CreditLimit_partner");
		Thread.sleep(5000);


	}


	@Then("BartyCrouch verifies the invoice")
	public void barty_crouch_verifies_the_invoice() throws Exception {

		Order_Details_Page.go_to_invoice(driver);
		Thread.sleep(3000);

		Switch_tab.switch_next_tab(driver);
		

//      ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//      driver.switchTo().window(tabs.get(1));


		Thread.sleep(5000);


		//Invoice must be unpaid
		Invoice_partner.capture_invoice_ordered_with_bank(driver, "Hosting_CreditLimit_partner");


		Thread.sleep(7000);
		//Closes both Tabs 
		driver.quit();

	}

	
	
	


	//HARRY is adding adding credit Balance and ordering Product via Credit Balance(Sheet Name = "Hosting_CreditBalance_partner")

	
	@Given("Harry login into Q11 partner portal")
	public void harry_login_into_q11_partner_portal() throws Exception {
		//Launching Browser
		driver = Open_Q11_portal.open_Q11_Website();
		Thread.sleep(5000);
	}

	
	@Then("Harry open his account and add credit balance")
	public void harry_open_his_account_and_add_credit_balance() throws Exception {

		//Customer,ie.Harry creating account 
		Adding_customer.add_customer_in_partner_panel(driver, "Hosting_CreditBalance_partner");


		Thread.sleep(7000);

		try {
			//selecting customer
			driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[3]/a[1]")).click();

		}
		catch(Exception x)
		{

			driver.navigate().refresh();
			Thread.sleep(10000);
			driver.findElement(By.xpath("(//table[@class='table table-bordered']//a)[1]")).click();

		}


		//Open Billing Section
		driver.findElement(By.xpath("(//span[text()='Billing'])[4]")).click();
		Thread.sleep(2000);

		//click on ledger
		driver.findElement(By.xpath("//span[text()='Ledger']")).click();
		Thread.sleep(3000);

		//Add Transaction
		driver.findElement(By.xpath("//span[text()='Add Transaction']")).click();
		Thread.sleep(5000);

		Adding_Credit_Balance.add_credit_balance(driver);
		Thread.sleep(5000);
		
		Ledger.capture_details_of_legder_before_payment(driver, "Hosting_CreditBalance_partner");
		Thread.sleep(5000);

	}


	@Then("Harry Choose Linux Hosting Gold Offer plan")
	public void harry_choose_linux_hosting_gold_offer_plan() throws Exception {

		try
		{

			//Settings DropDown
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Settings']")));

			WebElement setting = driver.findElement(By.xpath("//span[text()='Settings']"));
			setting.click();		



			logger.info("try block ");


			logger.info("Settings Openend");
			Thread.sleep(3000);
			Actions ac = new Actions(driver);

			ac.moveToElement(driver.findElement(By.xpath("(//span[contains(.,'Offers')])[2]")));
			ac.moveToElement(driver.findElement(By.xpath("//span[contains(.,'Basic Configuration')]"))).click().perform();
			Thread.sleep(2000);

		}
		catch(Exception x)
		{
			logger.info("Catch Block .....Please help me.......");
			System.out.println(x.getStackTrace());
			driver.navigate().refresh();
			logger.info("Page Refreshed");
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			Thread.sleep(60000);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#kt_header_menu>ul>li:nth-of-type(8)>a>span")));

			driver.findElement(By.cssSelector("div#kt_header_menu>ul>li:nth-of-type(8)>a>span")).click();
			Actions ac = new Actions(driver);

			ac.moveToElement(driver.findElement(By.xpath("(//span[contains(.,'Offers')])[2]")));
			ac.moveToElement(driver.findElement(By.xpath("//span[contains(.,'Basic Configuration')]"))).click().perform();
			Thread.sleep(2000);

		}


		try {

			driver = Choosing_hosting_custom_plan.select_hosting_plan_partner_panel(driver,"Monthly");

		}
		catch(Exception x)
		{
			Thread.sleep(5000);
			driver.navigate().refresh();
			driver = Choosing_hosting_custom_plan.select_hosting_plan_partner_panel(driver,"Monthly");

		}



	}


	@When("Harry open Monthly plan add it to cart")
	public void harry_open_monthly_plan_add_it_to_cart() throws Exception {
		//Choosing Domain
		driver = Adding_domain.entering_the_domin_from_partner_panel(driver);


		//calling Order Summary Page Method 
		Order_summary_page.capture_data_from_order_summary_page(driver, "Hosting_CreditLimit_partner");
		logger.info("All Details from summary Page is captured");


		//Add to cart button
		driver.findElement(By.id("submit")).click();
		Thread.sleep(5000);

		driver.findElement(By.id("next_without_login")).click();
		Thread.sleep(3000);

	}


	@When("Harry login with his account")
	public void harry_login_with_his_account() throws Exception {

		//Location Of Excel Sheet
		String xlpath = System.getProperty("user.dir") + "/src/main/resources/Q11-Hosting.xlsx";

		///Opening Excel Sheet
		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet("Hosting_CreditBalance_partner");


		String Username = sheet.getRow(3).getCell(10).getStringCellValue();
		String password = sheet.getRow(4).getCell(10).getStringCellValue();


		driver.findElement(By.name("user")).sendKeys(Username);
		Thread.sleep(3000);

		driver.findElement(By.id("login_form_password")).sendKeys(password);
		Thread.sleep(3000);


		driver.findElement(By.name("log_in")).click();
		Thread.sleep(3000);

		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
		fi.close();
		fos.close();

	}


	@Then("Harry pay it by credit balance")
	public void harry_pay_it_by_credit_balance() throws Exception {

		After_account_creation.capture_data_after_account_creation_from_admin_panel(driver, "Hosting_CreditLimit_partner");

		Thread.sleep(5000);

		driver.findElement(By.id("make_payment")).click();

		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@value='Next']")).click();
		}
		catch(Exception x)
		{
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("form#buildserver>div>div>div:nth-of-type(3)>div>div>input:nth-of-type(2)")).click();
		}


		try
		{	
			Thread.sleep(7000);

			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated((By.className("bay-bill-balance"))));
			WebElement success = driver.findElement(By.className("bay-bill-balance"));
			if(success.isDisplayed())
			{
				System.out.println(success.getText());
			}
			else
			{
				System.out.println("Timeout");
			}

		}
		catch(Exception x)
		{
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("form#buildserver>div>div>div:nth-of-type(3)>div>div>input:nth-of-type(2)")).click();
			Thread.sleep(7000);

			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("div#div_message>div"))));
			WebElement success =driver.findElement(By.cssSelector("div#div_message>div"));
			if(success.isDisplayed())
			{
				System.out.println(success.getText());
			}
			else
			{
				System.out.println("Timeout");
			}
		}

		Thread.sleep(7000);

		driver.close();
		
		driver = Switch_tab.switch_previous_tab2(driver);

	}


	@Then("Quirrell view Billing")
	public void quirrell_view_billing() throws Exception {

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
		try {
			ac.moveToElement(driver.findElement(By.xpath("(//span[text()='List'])[5]"))).click().perform();

		}
		catch(Exception x)
		{
			ac.moveToElement(driver.findElement(By.cssSelector("div#kt_header_menu>ul>li:nth-of-type(4)>div>ul>li>div>ul>li>a>span"))).click().perform();	
		}

		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(7000);

		Order_Details_Page.capture_data_of_order_details_page_before_approval(driver, "Hosting_CreditLimit_partner");
		Thread.sleep(5000);

	}


	@Then("Quirrell verifies the invoice")
	public void quirrell_verifies_the_invoice() throws Exception {

		Order_Details_Page.go_to_invoice(driver);
		Thread.sleep(3000);

		Switch_tab.switch_next_tab(driver);
		

//      ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//      driver.switchTo().window(tabs.get(1));


		Thread.sleep(5000);

		Invoice_partner.capture_invoice_ordered_with_paypal(driver, "Hosting_CreditLimit_partner");

		Thread.sleep(7000);

		driver.close();
		
		driver = Switch_tab.switch_previous_tab2(driver);
		
		Thread.sleep(5000);
	}

	
	@And("Quirrell checks the remaining credit balance")
	public void quirrell_checks_the_remaining_credit_balance() throws Exception {
		
		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/following::table/tbody[1]/tr[1]/td[1]/a[1]")).click();
		
		Thread.sleep(5000);
		
		Switch_tab.switch_next_tab(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()='Billing'])[4]")));
		
		//Open Billing Section
		driver.findElement(By.xpath("(//span[text()='Billing'])[4]")).click();
		Thread.sleep(2000);

		//click on ledger
		driver.findElement(By.xpath("//span[text()='Ledger']")).click();
		Thread.sleep(3000);
		
		
		Ledger.capture_details_of_legder_after_payment(driver, "Hosting_CreditBalance_partner");
		Thread.sleep(5000);
		
		
		driver.quit();
		
	}
	


	
	////James is buying Product via Bank(sheet_name = Hosting_bank_partner)
	///William is adding Receipt

	@Given("James login into Q11 partner portal")
	public void james_login_into_q11_partner_portal() throws Exception {
		driver = Open_Q11_portal.open_Q11_Partnerpanel();
		logger.info("Welcome to Q11 Partner portal");
		Thread.sleep(15000);

		try
		{

			//Settings DropDown
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Settings")));

			WebElement setting = driver.findElement(By.partialLinkText("Settings"));
			setting.click();	
			logger.info("try block ");

		}
		catch(Exception x)
		{
			logger.info("Catch Block .....Please help me.......");
			System.out.println(x.getStackTrace());
			driver.navigate().refresh();
			logger.info("Page Refreshed");
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			Thread.sleep(30000);
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Settings']")));
			WebElement setting = driver.findElement(By.xpath("//span[text()='Settings']"));
			setting.click();

		}

		Thread.sleep(2000);
		Actions ac = new Actions(driver);

		ac.moveToElement(driver.findElement(By.xpath("//span[text()='Offers']")));
		ac.pause(20);
		Thread.sleep(2000);
		ac.moveToElement(driver.findElement(By.xpath("//span[text()='Basic Configuration']"))).click().perform();
		Thread.sleep(2000);
	}


	@Then("James Choose Linux Hosting Gold Offer plan")
	public void james_choose_linux_hosting_gold_offer_plan() throws Exception {

		driver = Choosing_hosting_custom_plan.select_hosting_plan_partner_panel(driver, "monthly");
		logger.info("Monthly plan is opened");
	}


	@When("James open Monthly plan and add it to cart")
	public void james_open_monthly_plan_and_add_it_to_cart() throws Exception {


		//Choosing Domain
		driver = Adding_domain.entering_the_domin_from_partner_panel(driver);


		//calling Order Summary Page Method 
		Order_summary_page.capture_data_from_order_summary_page(driver, "Hosting_bank");
		logger.info("All Details from summary Page is captured");


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


	@When("James creates new account")
	public void james_creates_new_account() throws Exception {

		//Calling Method for NEW ACCOUNT CREATION
		New_account1.creating_new_account_from_partner_panel(driver,"Hosting_bank_partner",3,10);


		///After Account Creation
		logger.info("After Account Creation");
		Thread.sleep(7000);

		After_account_creation.capture_data_after_account_creation_from_partner_panel(driver, "Hosting_bank_partner");

		logger.info("All Details after creating an account is captured");

		Thread.sleep(5000);

	}


	@Then("James pay it by bank payment")
	public void james_pay_it_by_bank_payment() throws Exception {

		logger.info("Mode of Payment Bank");

		Payments.payment_with_bank(driver,"Hosting_bank_partner");

		logger.info("Payment Sucessfully done");

		Thread.sleep(5000);	

		driver.close();

		driver = Switch_tab.switch_previous_tab2(driver);


	}


	@Then("William opens Justin Profile")
	public void william_opens_justin_profile() throws Exception {

		try {
			logger.info("In try block waiting for Accounts ");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Accounts")));


			driver.findElement(By.partialLinkText("Accounts")).click();

		}
		catch(Exception x)
		{
			logger.info("In catch block waiting for Accounts ");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Accounts'])[1]")));


			driver.findElement(By.xpath("(//span[text()='Accounts'])[1]")).click();

		}

		Thread.sleep(5000);
		Actions ac = new Actions(driver);

		ac.moveToElement(driver.findElement(By.xpath("(//span[text()='Customers'])[1]")));
		ac.moveToElement(driver.findElement(By.xpath("(//span[text()='List'])[1]"))).click().perform();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[3]/a[1]")).click();
		Thread.sleep(7000);
	}


	@Then("William added receipt which is paid by James")
	public void william_added_receipt_which_is_paid_by_james() throws Exception {


		//Open Billing Section
		driver.findElement(By.xpath("(//span[text()='Billing'])[4]")).click();
		Thread.sleep(2000);

		//Open Receipt
		driver.findElement(By.xpath("(//span[text()='Receipts'])[3]")).click();
		Thread.sleep(2000);

		//Open Important Links
		driver.findElement(By.xpath("//span[text()='Important Links']")).click();
		Thread.sleep(2000);

		//Open Add Receipt
		driver.findElement(By.xpath("//span[text()='Add Receipt']")).click();
		Thread.sleep(2000);


		Receipt.add_receipt(driver);
		Thread.sleep(5000);


	}


	@Then("William approves for the product")
	public void william_approves_for_the_product() throws Exception {

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
		try {
			ac.moveToElement(driver.findElement(By.xpath("(//span[text()='List'])[5]"))).click().perform();

		}
		catch(Exception x)
		{
			ac.moveToElement(driver.findElement(By.cssSelector("div#kt_header_menu>ul>li:nth-of-type(4)>div>ul>li>div>ul>li>a>span"))).click().perform();	
		}

		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(7000);

		Order_Details_Page.capture_data_of_order_details_page_before_approval(driver, "Hosting_bank_partner");



		Order_Details_Page.approve_order(driver);

		Order_Details_Page.capture_data_of_order_details_page_after_approval(driver, "Hosting_bank_partner");


	}


	@Then("William verifies the invoice")
	public void william_verifies_the_invoice() throws Exception {

		Order_Details_Page.go_to_invoice(driver);
		Thread.sleep(3000);

		Switch_tab.switch_next_tab(driver);
		

//      ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//      driver.switchTo().window(tabs.get(1));


		Thread.sleep(5000);

		Invoice2.capture_invoice_details_status_paid_for_partner(driver, "Hosting_bank_partner");

		Thread.sleep(7000);
		//Closes both Tabs 
		driver.quit();

	}

	

	

	///Invoice Generation with AutoRenewal OFF


	@Given("Logan login into Q11 partner portal")
	public void logan_login_into_q11_partner_portal() throws Exception {

		driver = Open_Q11_portal.open_Q11_Partnerpanel();
		logger.info("Welcome to Q11 Partner portal");
		Thread.sleep(15000);

		try
		{

			//Settings DropDown
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Settings")));

			WebElement setting = driver.findElement(By.partialLinkText("Settings"));
			setting.click();	
			logger.info("try block ");

		}
		catch(Exception x)
		{
			logger.info("Catch Block .....Please help me.......");
			System.out.println(x.getStackTrace());
			driver.navigate().refresh();
			logger.info("Page Refreshed");
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			Thread.sleep(30000);
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Settings']")));
			WebElement setting = driver.findElement(By.xpath("//span[text()='Settings']"));
			setting.click();

		}

		Thread.sleep(2000);
		Actions ac = new Actions(driver);

		ac.moveToElement(driver.findElement(By.xpath("//span[text()='Offers']")));
		ac.pause(20);
		Thread.sleep(2000);
		ac.moveToElement(driver.findElement(By.xpath("//span[text()='Basic Configuration']"))).click().perform();
		Thread.sleep(2000);
	}


	@Then("Logan Choose Linux Hosting Gold Offer plan")
	public void logan_choose_linux_hosting_gold_offer_plan() throws Exception {

		driver = Choosing_hosting_custom_plan.select_hosting_plan_partner_panel(driver, "monthly");
		logger.info("Monthly plan is opened");

	}


	@When("Logan open Monthly plan add it to cart")
	public void logan_open_monthly_plan_add_it_to_cart() throws Exception {

		//Choosing Domain
		driver = Adding_domain.entering_the_domin_from_partner_panel(driver);


		//calling Order Summary Page Method 
		Order_summary_page.capture_data_from_order_summary_page(driver, "Hosting_paypal_partner");
		logger.info("All Details from summary Page is captured");


		//Add to cart button
		driver.findElement(By.id("submit")).click();
		Thread.sleep(5000);

		driver.findElement(By.id("next_without_login")).click();
		Thread.sleep(3000);


		//create an Account
		driver.findElement(By.id("sign-up-sec")).click();
		Thread.sleep(3000);
		logger.info("Going to Create New Account");


	}


	@When("Logan creates new account")
	public void logan_creates_new_account() throws Exception {
		//Calling Method for NEW ACCOUNT CREATION
		New_account1.creating_new_account_from_partner_panel(driver,"Hosting_paypal_partner",3,10);


		///After Account Creation
		logger.info("After Account Creation");
		Thread.sleep(7000);

		After_account_creation.capture_data_after_account_creation_from_partner_panel(driver, "Hosting_paypal_partner");

		logger.info("All Details after creating an account is captured");

		Thread.sleep(5000);
	}


	@Then("Logan pay it by paypal payment")
	public void logan_pay_it_by_paypal_payment() throws Exception {

		Payments.payment_with_paypal(driver, "Hosting_paypal_partner");	

		driver.close();
		
		driver = Switch_tab.switch_previous_tab2(driver);

	}


	@Then("Jackson opens Joseph Profile")
	public void jackson_opens_joseph_profile() throws Exception {

		try {
			logger.info("In try block wait for Accounts ");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Accounts'])[1]")));


			driver.findElement(By.xpath("(//span[text()='Accounts'])[1]")).click();

		}
		catch(Exception x)
		{
			logger.info("In catch block wait for billing ");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Accounts")));


			driver.findElement(By.partialLinkText("Accounts")).click();

		}

		Thread.sleep(5000);
		Actions ac = new Actions(driver);




		ac.moveToElement(driver.findElement(By.xpath("(//span[text()='Customers'])[1]")));
		ac.moveToElement(driver.findElement(By.xpath("(//span[text()='List'])[1]"))).click().perform();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[3]/a[1]")).click();
		Thread.sleep(7000);


	}


	@Then("Jackson turns off Logan auto renewal service off")
	public void jackson_turns_off_logan_auto_renewal_service_off() throws Exception {

		//Subscription Section present in the left panel
		driver.findElement(By.xpath("(//span[text()='Subscriptions'])[3]")).click();
		Thread.sleep(3000);

		//Sub Subscription
		driver.findElement(By.xpath("(//span[text()='Subscriptions'])[4]")).click();
		Thread.sleep(3000);

		//choose subscription details 
		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[2]/a[1]")).click();


		//AutoRenewal off
		Subscription_Details.turn_off_renewable(driver);
		Thread.sleep(3000);
	}


	@Then("Jackson generates invoice")
	public void jackson_generates_invoice() throws Exception {
		//Subscription
		driver.findElement(By.xpath("(//span[text()='Subscriptions'])[4]")).click();
		Thread.sleep(3000);

		//Select check box 
		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/thead[1]/tr[1]/th[1]/label[1]/span[1]")).click();
		Thread.sleep(3000);

		//Important links
		driver.findElement(By.xpath("//span[text()='Important Links']")).click();
		Thread.sleep(3000);

		//Generate Invoice 
		driver.findElement(By.xpath("//span[text()='Generate Invoice']")).click();
		Thread.sleep(3000);		

		//Ok button
		driver.findElement(By.xpath("//button[text()='Ok']")).click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='alert-text'])[1]")));
		}
		catch(Exception x)
		{
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#alert-msg-success>div:nth-of-type(2)")));			
		}

		Thread.sleep(5000);
	}


	@Then("Jackson verifies the invoice")
	public void jackson_verifies_the_invoice() throws Exception {

		//billing section present in left panel
		try {
			driver.findElement(By.xpath("(//span[text()='Billing'])[4]")).click();
			Thread.sleep(3000);
		}
		catch(Exception x)
		{
			driver.navigate().refresh();
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#kt_aside_menu>ul>li:nth-of-type(4)>a>span:nth-of-type(2)")));

			driver.findElement(By.cssSelector("div#kt_aside_menu>ul>li:nth-of-type(4)>a>span:nth-of-type(2)")).click();
			Thread.sleep(3000);
		}

		driver.findElement(By.xpath("(//span[text()='Invoices'])[3]")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(7000);

		String status = driver.findElement(By.xpath("(//table[@class='invoice']//table)[4]/tbody[1]/tr[2]/td[1]/b[1]")).getText();
		System.out.println(status);

		driver.navigate().back();
	}


	@Then("Jackson adds receipt")
	public void jackson_adds_receipt() throws Exception {

		try {
			//Receipt

			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()='Receipts'])[3]")));

			driver.findElement(By.xpath("(//span[text()='Receipts'])[3]")).click();
			logger.info("try block receipt section opened");
			Thread.sleep(7000);

		}
		catch(Exception x)
		{
			//Receipt
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#kt_aside_menu>ul>li:nth-of-type(5)>div>ul>li:nth-of-type(3)>a>span")));

			driver.findElement(By.cssSelector("div#kt_aside_menu>ul>li:nth-of-type(5)>div>ul>li:nth-of-type(3)>a>span")).click();
			logger.info("catch block receipt section opened");
			Thread.sleep(7000);

		}


		//Important links 
		driver.findElement(By.xpath("//span[text()='Important Links']")).click();
		Thread.sleep(3000);

		//Add Receipt
		driver.findElement(By.xpath("//span[text()='Add Receipt']")).click();
		Thread.sleep(7000);


		Receipt.add_receipt(driver);
		Thread.sleep(5000);
	}


	@Then("Jackson again verifies the invoice")
	public void jackson_again_verifies_the_invoice() throws Exception {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()='Invoices'])[3]")));

			driver.findElement(By.xpath("(//span[text()='Invoices'])[3]")).click();
			Thread.sleep(5000);
		}
		catch(Exception x)
		{
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@class='kt-menu__link active']//span)[2]")));
			driver.findElement(By.xpath("(//a[@class='kt-menu__link active']//span)[2]")).click();
			Thread.sleep(5000);

		}

		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(7000);

		String status = driver.findElement(By.xpath("(//table[@class='invoice']//table)[4]/tbody[1]/tr[2]/td[1]/b[1]")).getText();
		System.out.println(status);

		Thread.sleep(5000);
		driver.quit();
	}



	
	
	///Invoice Generation with AutoRenewal ON
	@Given("Luke login into Q11 partner portal")
	public void luke_login_into_q11_partner_portal() throws Exception {
		driver = Open_Q11_portal.open_Q11_Partnerpanel();
		logger.info("Welcome to Q11 Partner portal");
		Thread.sleep(15000);

		try
		{

			//Settings DropDown
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Settings")));

			WebElement setting = driver.findElement(By.partialLinkText("Settings"));
			setting.click();	
			logger.info("try block ");

		}
		catch(Exception x)
		{
			logger.info("Catch Block .....Please help me.......");
			System.out.println(x.getStackTrace());
			driver.navigate().refresh();
			logger.info("Page Refreshed");
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			Thread.sleep(30000);
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Settings']")));
			WebElement setting = driver.findElement(By.xpath("//span[text()='Settings']"));
			setting.click();

		}

		Thread.sleep(2000);
		Actions ac = new Actions(driver);

		ac.moveToElement(driver.findElement(By.xpath("//span[text()='Offers']")));
		ac.pause(20);
		Thread.sleep(2000);
		ac.moveToElement(driver.findElement(By.xpath("//span[text()='Basic Configuration']"))).click().perform();
		Thread.sleep(2000);
	}

	
	@Then("Luke Choose Linux Hosting Gold Offer plan")
	public void luke_choose_linux_hosting_gold_offer_plan() throws Exception {
		driver = Choosing_hosting_custom_plan.select_hosting_plan_partner_panel(driver, "monthly");
		logger.info("Monthly plan is opened");
	}

	
	@When("Luke open Monthly plan add it to cart")
	public void luke_open_monthly_plan_add_it_to_cart() throws Exception {
		//Choosing Domain
		driver = Adding_domain.entering_the_domin_from_partner_panel(driver);


		//calling Order Summary Page Method 
		Order_summary_page.capture_data_from_order_summary_page(driver, "Hosting_paypal_partner");
		logger.info("All Details from summary Page is captured");


		//Add to cart button
		driver.findElement(By.id("submit")).click();
		Thread.sleep(5000);

		driver.findElement(By.id("next_without_login")).click();
		Thread.sleep(3000);


		//create an Account
		driver.findElement(By.id("sign-up-sec")).click();
		Thread.sleep(3000);
		logger.info("Going to Create New Account");
	}

	
	@And("Luke creates new account")
	public void luke_creates_new_account() throws Exception {
		//Calling Method for NEW ACCOUNT CREATION
		New_account1.creating_new_account_from_partner_panel(driver,"Hosting_paypal_partner",3,10);


		///After Account Creation
		logger.info("After Account Creation");
		Thread.sleep(7000);

		After_account_creation.capture_data_after_account_creation_from_partner_panel(driver, "Hosting_paypal_partner");

		logger.info("All Details after creating an account is captured");

		Thread.sleep(5000);
	}

	
	@Then("Luke pay it by paypal payment")
	public void luke_pay_it_by_paypal_payment() throws Exception {

		Payments.payment_with_paypal(driver, "Hosting_paypal_partner");	
		
		driver.close();

		driver = Switch_tab.switch_previous_tab2(driver);
	}


	@And("Isaac opens Robert Profile")
	public void isaac_opens_robert_profile() throws Exception {
		try {
			logger.info("In try block wait for Accounts ");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Accounts'])[1]")));


			driver.findElement(By.xpath("(//span[text()='Accounts'])[1]")).click();

		}
		catch(Exception x)
		{
			logger.info("In catch block wait for billing ");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Accounts")));


			driver.findElement(By.partialLinkText("Accounts")).click();

		}

		Thread.sleep(5000);
		Actions ac = new Actions(driver);




		ac.moveToElement(driver.findElement(By.xpath("(//span[text()='Customers'])[1]")));
		ac.moveToElement(driver.findElement(By.xpath("(//span[text()='List'])[1]"))).click().perform();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[3]/a[1]")).click();
		Thread.sleep(7000);
	}


	@Then("Isaac turns off Luke auto renewal service on")
	public void isaac_turns_off_luke_auto_renewal_service_on() throws Exception {
		//Subscription Section present in the left panel
		driver.findElement(By.xpath("(//span[text()='Subscriptions'])[3]")).click();
		Thread.sleep(3000);

		//Sub Subscription
		driver.findElement(By.xpath("(//span[text()='Subscriptions'])[4]")).click();
		Thread.sleep(3000);

		//choose subscription details 
		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[2]/a[1]")).click();


		//AutoRenewal off
		Subscription_Details.turn_on_renewable(driver);
		Thread.sleep(3000);
	}


	@And("Isaac generates invoice")
	public void isaac_generates_invoice() throws Exception {
		//Subscription
		driver.findElement(By.xpath("(//span[text()='Subscriptions'])[4]")).click();
		Thread.sleep(3000);

		//Select check box 
		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/thead[1]/tr[1]/th[1]/label[1]/span[1]")).click();
		Thread.sleep(3000);

		//Important links
		driver.findElement(By.xpath("//span[text()='Important Links']")).click();
		Thread.sleep(3000);

		//Generate Invoice 
		driver.findElement(By.xpath("//span[text()='Generate Invoice']")).click();
		Thread.sleep(3000);		

		//Ok button
		driver.findElement(By.xpath("//button[text()='Ok']")).click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='alert-text'])[1]")));
		}
		catch(Exception x)
		{
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#alert-msg-success>div:nth-of-type(2)")));			
		}

		Thread.sleep(5000);
	}

	
	@Then("Isaac verifies the invoice")
	public void isaac_verifies_the_invoice() throws Exception {
		//billing section present in left panel
		try {
			driver.findElement(By.xpath("(//span[text()='Billing'])[4]")).click();
			Thread.sleep(3000);
		}
		catch(Exception x)
		{
			driver.navigate().refresh();
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#kt_aside_menu>ul>li:nth-of-type(4)>a>span:nth-of-type(2)")));

			driver.findElement(By.cssSelector("div#kt_aside_menu>ul>li:nth-of-type(4)>a>span:nth-of-type(2)")).click();
			Thread.sleep(3000);
		}

		driver.findElement(By.xpath("(//span[text()='Invoices'])[3]")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(7000);

		String status = driver.findElement(By.xpath("(//table[@class='invoice']//table)[4]/tbody[1]/tr[2]/td[1]/b[1]")).getText();
		System.out.println(status);

		driver.navigate().back();
	}

	
	@And("Isaac adds receipt")
	public void isaac_adds_receipt() throws Exception {
		try {
			//Receipt

			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()='Receipts'])[3]")));

			driver.findElement(By.xpath("(//span[text()='Receipts'])[3]")).click();
			logger.info("try block receipt section opened");
			Thread.sleep(7000);

		}
		catch(Exception x)
		{
			//Receipt
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#kt_aside_menu>ul>li:nth-of-type(5)>div>ul>li:nth-of-type(3)>a>span")));

			driver.findElement(By.cssSelector("div#kt_aside_menu>ul>li:nth-of-type(5)>div>ul>li:nth-of-type(3)>a>span")).click();
			logger.info("catch block receipt section opened");
			Thread.sleep(7000);

		}


		//Important links 
		driver.findElement(By.xpath("//span[text()='Important Links']")).click();
		Thread.sleep(3000);

		//Add Receipt
		driver.findElement(By.xpath("//span[text()='Add Receipt']")).click();
		Thread.sleep(7000);


		Receipt.add_receipt(driver);
		Thread.sleep(5000);
	}

	
	@Then("Isaac again verifies the invoice")
	public void isaac_again_verifies_the_invoice() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()='Invoices'])[3]")));

			driver.findElement(By.xpath("(//span[text()='Invoices'])[3]")).click();
			Thread.sleep(5000);
		}
		catch(Exception x)
		{
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@class='kt-menu__link active']//span)[2]")));
			driver.findElement(By.xpath("(//a[@class='kt-menu__link active']//span)[2]")).click();
			Thread.sleep(5000);

		}

		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(7000);

		String status = driver.findElement(By.xpath("(//table[@class='invoice']//table)[4]/tbody[1]/tr[2]/td[1]/b[1]")).getText();
		System.out.println(status);

		Thread.sleep(5000);
		driver.quit();
	}





	//Creating Addon 
	@Given("Thomas login into Q11 partner portal")
	public void thomas_login_into_q11_partner_portal() throws Exception {
		driver = Open_Q11_portal.open_Q11_Partnerpanel();
		logger.info("Welcome to Q11 Partner portal");
		Thread.sleep(15000);

		try
		{

			//Settings DropDown
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Settings")));

			WebElement setting = driver.findElement(By.partialLinkText("Settings"));
			setting.click();	
			logger.info("try block ");

		}
		catch(Exception x)
		{
			logger.info("Catch Block .....Please help me.......");
			System.out.println(x.getStackTrace());
			driver.navigate().refresh();
			logger.info("Page Refreshed");
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			Thread.sleep(30000);
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Settings']")));
			WebElement setting = driver.findElement(By.xpath("//span[text()='Settings']"));
			setting.click();

		}

		Thread.sleep(2000);
		Actions ac = new Actions(driver);

		ac.moveToElement(driver.findElement(By.xpath("//span[text()='Offers']")));
		ac.pause(20);
		Thread.sleep(2000);
		ac.moveToElement(driver.findElement(By.xpath("//span[text()='Basic Configuration']"))).click().perform();
		Thread.sleep(2000);
	}


	@Then("Thomas Choose Linux Hosting Gold Offer plan")
	public void thomas_choose_linux_hosting_gold_offer_plan() throws Exception {
		driver = Choosing_hosting_custom_plan.select_hosting_plan_partner_panel(driver, "monthly");
		logger.info("Monthly plan is opened");
	}


	@When("Thomas open Monthly plan add it to cart")
	public void thomas_open_monthly_plan_add_it_to_cart() throws Exception {
		//Choosing Domain
		driver = Adding_domain.entering_the_domin_from_partner_panel_without_addon(driver);


		//Add to cart button
		driver.findElement(By.id("submit")).click();
		Thread.sleep(5000);

		driver.findElement(By.id("next_without_login")).click();
		Thread.sleep(3000);


		//create an Account
		driver.findElement(By.id("sign-up-sec")).click();
		Thread.sleep(3000);
		logger.info("Going to Create New Account");

	}


	@When("Thomas creates new account")
	public void thomas_creates_new_account() throws Exception {
		//Calling Method for NEW ACCOUNT CREATION
		New_account1.creating_new_account_from_partner_panel(driver,"Hosting_paypal_partner",3,10);

		Thread.sleep(5000);
	}


	@Then("Thomas pay it by paypal payment")
	public void thomas_pay_it_by_paypal_payment() throws Exception {
		Payments.payment_with_paypal(driver, "Hosting_paypal_partner");	

		driver.close();
		
		driver = Switch_tab.switch_previous_tab2(driver);
	}


	@Then("Charles opens Thomas Profile")
	public void charles_opens_thomas_profile() throws Exception {
		try {
			logger.info("In try block wait for billing ");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Accounts'])[1]")));


			driver.findElement(By.xpath("(//span[text()='Accounts'])[1]")).click();

		}
		catch(Exception x)
		{
			logger.info("In catch block wait for billing ");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Accounts")));


			driver.findElement(By.partialLinkText("Accounts")).click();

		}

		Thread.sleep(5000);
		Actions ac = new Actions(driver);




		ac.moveToElement(driver.findElement(By.xpath("(//span[text()='Customers'])[1]")));
		ac.moveToElement(driver.findElement(By.xpath("(//span[text()='List'])[1]"))).click().perform();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[3]/a[1]")).click();
		Thread.sleep(7000);
	}


	@Then("Charles adds Addons to Thomas subscription plan")
	public void charles_adds_addons_to_thomas_subscription_plan() throws Exception {
		//Subscription Section present in the left panel
		driver.findElement(By.xpath("(//span[text()='Subscriptions'])[3]")).click();
		Thread.sleep(3000);

		//Sub Subscription
		driver.findElement(By.xpath("(//span[text()='Subscriptions'])[4]")).click();
		Thread.sleep(3000);

		//choose subscription details 
		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[2]/a[1]")).click();

		//Created Addon
		Subscription_Details.create_addon(driver);
	}


	@Then("Charles verifies generated Order")
	public void charles_verifies_generated_order() throws Exception {
		//Billing section
		try {
			driver.findElement(By.xpath("(//span[text()='Billing'])[4]")).click();
			Thread.sleep(3000);
		}
		catch(Exception x)
		{
			driver.findElement(By.cssSelector("div#kt_aside_menu>ul>li:nth-of-type(3)>a>span:nth-of-type(2)")).click();
			Thread.sleep(3000);
		}

		//orders 
		driver.findElement(By.xpath("(//span[text()='Orders'])[3]")).click();
		Thread.sleep(7000);

		//order status
		//			String order_status= driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[6]/span[1]")).getText();
		//			System.out.println(order_status);
	}


	@Then("Charles adds receipt")
	public void charles_adds_receipt() throws Exception {
		try {
			//Receipt

			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()='Receipts'])[3]")));

			driver.findElement(By.xpath("(//span[text()='Receipts'])[3]")).click();
			logger.info("try block receipt section opened");
			Thread.sleep(7000);

		}
		catch(Exception x)
		{
			//Receipt
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#kt_aside_menu>ul>li:nth-of-type(5)>div>ul>li:nth-of-type(3)>a>span")));

			driver.findElement(By.cssSelector("div#kt_aside_menu>ul>li:nth-of-type(5)>div>ul>li:nth-of-type(3)>a>span")).click();
			logger.info("catch block receipt section opened");
			Thread.sleep(7000);

		}


		//Important links 
		driver.findElement(By.xpath("//span[text()='Important Links']")).click();
		Thread.sleep(3000);

		//Add Receipt
		driver.findElement(By.xpath("//span[text()='Add Receipt']")).click();
		Thread.sleep(7000);


		Receipt.add_receipt(driver);
		Thread.sleep(5000);
	}


	@Then("Charles approves for the product")
	public void charles_approves_for_the_product() throws Exception {

		//orders 
		driver.findElement(By.xpath("(//span[text()='Orders'])[3]")).click();
		Thread.sleep(5000);

		//go to 1st row order
		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(5000);


		//Select checkbox
		try {

			driver.findElement(By.xpath("(//table[contains(@class,'table table-bordered')]/following::table)[2]/thead[1]/tr[1]/th[1]/label[1]/span[1]")).click();
			Thread.sleep(3000);
		}
		catch(Exception x)
		{
			driver.findElement(By.cssSelector("form#update_order>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div>div>table>thead>tr>th>label>span")).click();
			Thread.sleep(3000);
		}


		//Approve button
		try {
			driver.findElement(By.xpath("(//button[contains(@class,'btn btn-brand')])[1]")).click();
			Thread.sleep(5000);
		}
		catch(Exception x)
		{
			driver.findElement(By.xpath("//button[text()='Approve']")).click();
			Thread.sleep(5000);
		}

		driver.findElement(By.xpath("//button[text()='Ok']")).click();
//		Thread.sleep(7000);
		
		try {
		WebDriverWait wait_for_invoice = new WebDriverWait(driver, 90);
		wait_for_invoice.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='kt-portlet__head-title']//a[1]")));
		
		
		WebElement Invoice = driver.findElement(By.xpath("//h3[@class='kt-portlet__head-title']//a[1]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", Invoice);
		
		}
		catch(Exception x)
		{
			driver.get("https://managebhavitmohod2233.qa11.dotbricks.net/adminp/invoices/invoice-details/VzJxNTBXU09uTDloTE1RYlM5SUZOMUI0bytQY3dPSUI3cHBJQ3BMQUkvYz0%3D");
			Thread.sleep(8000);
		}
		
		
		Switch_tab.switch_next_tab(driver);
		

//      ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//      driver.switchTo().window(tabs.get(1));

		String paid_date = driver.findElement(By.xpath("(//table[@class='invoice']//table)[4]/tbody[1]/tr[2]/td[2]")).getText();
		System.out.println(paid_date);
		
		driver.quit();
	}


	
	
	

	//Subcontact (Excel sheet = "Hosting_Subcontact_partner")
	
	
	@Given("Kane login into Q11 partner portal")
	public void kane_login_into_q11_partner_portal() throws Exception {
		
		driver = Open_Q11_portal.open_Q11_Partnerpanel();
		logger.info("Welcome to Q11 Partner portal");
		Thread.sleep(15000);
	}

	
	@Then("Kane register his account")
	public void kane_register_his_account() throws Exception {
		
		//Customer,ie.Harry creating account 
		Adding_customer.add_customer_in_partner_panel(driver, "Hosting_Subcontact_partner");

		Thread.sleep(7000);

		try {
			//selecting customer
			driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[3]/a[1]")).click();
			Reload_WebPage.reload_reload(driver);
		}
		catch(Exception x)
		{

			driver.navigate().refresh();
			Thread.sleep(10000);
			driver.findElement(By.xpath("(//table[@class='table table-bordered']//a)[1]")).click();

		}
	}
	
	
	@Then("Kane creates SubContact")
	public void kane_creates_sub_contact() throws Exception {
		
		//SubContact 
		driver.findElement(By.xpath("(//a[contains(@class,'btn btn-icon-brand')])[4]")).click();
		Thread.sleep(5000);

		Subcontact.create_sub_contact(driver, "Hosting_Subcontact_partner");
	}
	
	
	@Then("Kane Choose Linux Hosting Gold Offer plan")
	public void kane_choose_linux_hosting_gold_offer_plan() throws Exception {
		try
		{

			//Settings DropDown
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Settings")));

			WebElement setting = driver.findElement(By.partialLinkText("Settings"));
			setting.click();	
			logger.info("try block ");

		}
		catch(Exception x)
		{
			logger.info("Catch Block .....Please help me.......");
			System.out.println(x.getStackTrace());
			driver.navigate().refresh();
			logger.info("Page Refreshed");
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			Thread.sleep(30000);
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Settings']")));
			WebElement setting = driver.findElement(By.xpath("//span[text()='Settings']"));
			setting.click();

		}

		Thread.sleep(2000);
		Actions ac = new Actions(driver);

		ac.moveToElement(driver.findElement(By.xpath("//span[text()='Offers']")));
		ac.pause(20);
		Thread.sleep(2000);
		ac.moveToElement(driver.findElement(By.xpath("//span[text()='Basic Configuration']"))).click().perform();
		Thread.sleep(2000);
		
		driver = Choosing_hosting_custom_plan.select_hosting_plan_partner_panel(driver, "monthly");
		logger.info("Monthly plan is opened");
		
		
	}
	
	
	@When("Kane open Monthly plan add it to cart")
	public void kane_open_monthly_plan_add_it_to_cart() throws Exception {
	   
		//Choosing Domain
				driver = Adding_domain.entering_the_domin_from_partner_panel_without_addon(driver);


				//Add to cart button
				driver.findElement(By.id("submit")).click();
				Thread.sleep(5000);

				driver.findElement(By.id("next_without_login")).click();
				Thread.sleep(3000);
	}
	
	
	@And("Kane login with the SubContact account")
	public void kane_login_with_the_sub_contact_account() throws Exception {
		//Location Of Excel Sheet
				String xlpath = System.getProperty("user.dir") + "/src/main/resources/Q11-Hosting.xlsx";

				///Opening Excel Sheet
				File source = new File(xlpath);
				FileInputStream fi = new FileInputStream(source);
				XSSFWorkbook wb = new XSSFWorkbook(fi);
				XSSFSheet sheet = wb.getSheet("Hosting_Subcontact_partner");


				String Username = sheet.getRow(16).getCell(10).getStringCellValue();
				String password = sheet.getRow(17).getCell(10).getStringCellValue();


				driver.findElement(By.name("user")).sendKeys(Username);
				Thread.sleep(3000);

				driver.findElement(By.id("login_form_password")).sendKeys(password);
				Thread.sleep(3000);


				driver.findElement(By.name("log_in")).click();
				Thread.sleep(3000);

				FileOutputStream fos = new FileOutputStream(source);
				wb.write(fos);
				wb.close();
				fi.close();
				fos.close();
	}
	
	
	@Then("Kane pay it by paypal")
	public void kane_pay_it_by_paypal() throws Exception {
		
		
		driver.navigate().back();

		Payments.payment_with_paypal(driver, "Hosting_Subcontact_partner");	
		
		driver.close();

		driver = Switch_tab.switch_previous_tab2(driver);
		
	}
	
	
	@Then("Wade view Billing")
	public void wade_view_billing() throws Exception {
		
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
		try {
			ac.moveToElement(driver.findElement(By.xpath("(//span[text()='List'])[5]"))).click().perform();

		}
		catch(Exception x)
		{
			ac.moveToElement(driver.findElement(By.cssSelector("div#kt_header_menu>ul>li:nth-of-type(4)>div>ul>li>div>ul>li>a>span"))).click().perform();	
		}

		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(7000);

		Order_Details_Page.capture_data_of_order_details_page_before_approval(driver, "Hosting_Subcontact_partner");
		Thread.sleep(5000);

	}
	    
	
	@Then("Wade verifies the invoice")
	public void wade_verifies_the_invoice() throws Exception {
		Order_Details_Page.go_to_invoice(driver);
		Thread.sleep(3000);

		Switch_tab.switch_next_tab(driver);
		

//      ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//      driver.switchTo().window(tabs.get(1));


		Thread.sleep(5000);

		Invoice2.capture_invoice_details_status_paid_for_partner(driver, "Hosting_Subcontact_partner");

		Thread.sleep(7000);
		//Closes both Tabs 
		driver.quit();

	}


	
	//Cancel_Whole_order_partnerpanel (Excel sheet = "Hosting_CancelledOrder_partner")
	
	@Given("Jerry login into Q11 Website")
	public void jerry_login_into_q11_website() throws Exception {
		driver = Open_Q11_portal.open_Q11_Partnerpanel();
		logger.info("Welcome to Q11 Partner portal");
		Thread.sleep(15000);

		try
		{

			//Settings DropDown
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Settings")));

			WebElement setting = driver.findElement(By.partialLinkText("Settings"));
			setting.click();	
			logger.info("try block ");

		}
		catch(Exception x)
		{
			logger.info("Catch Block .....Please help me.......");
			System.out.println(x.getStackTrace());
			driver.navigate().refresh();
			logger.info("Page Refreshed");
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			Thread.sleep(30000);
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Settings']")));
			WebElement setting = driver.findElement(By.xpath("//span[text()='Settings']"));
			setting.click();

		}

		Thread.sleep(2000);
		Actions ac = new Actions(driver);

		ac.moveToElement(driver.findElement(By.xpath("//span[text()='Offers']")));
		ac.pause(20);
		Thread.sleep(2000);
		ac.moveToElement(driver.findElement(By.xpath("//span[text()='Basic Configuration']"))).click().perform();
		Thread.sleep(2000);
	}

	
	@Then("Jerry Choose Linux Hosting Gold Offer plan")
	public void jerry_choose_linux_hosting_gold_offer_plan() throws Exception {
		driver = Choosing_hosting_custom_plan.select_hosting_plan_partner_panel(driver, "monthly");
		logger.info("Monthly plan is opened");
	}
	
	
	@When("Jerry open Monthly plan and add it to cart")
	public void jerry_open_monthly_plan_and_add_it_to_cart() throws Exception {
		//Choosing Domain
				driver = Adding_domain.entering_the_domin_from_partner_panel(driver);


				//calling Order Summary Page Method 
				Order_summary_page.capture_data_from_order_summary_page(driver, "Hosting_CancelledOrder_partner");
				logger.info("All Details from summary Page is captured");


				//Add to cart button
				driver.findElement(By.id("submit")).click();
				Thread.sleep(5000);

				driver.findElement(By.id("next_without_login")).click();
				Thread.sleep(3000);


				//create an Account
				driver.findElement(By.id("sign-up-sec")).click();
				Thread.sleep(3000);
				logger.info("Going to Create New Account");
	}
	
	
	@And("Jerry creates new account")
	public void jerry_creates_new_account() throws Exception {
		//Calling Method for NEW ACCOUNT CREATION
		New_account1.creating_new_account_from_partner_panel(driver,"Hosting_CancelledOrder_partner",3,10);


		///After Account Creation
		logger.info("After Account Creation");
		Thread.sleep(7000);

		After_account_creation.capture_data_after_account_creation_from_partner_panel(driver, "Hosting_CancelledOrder_partner");

		logger.info("All Details after creating an account is captured");

		Thread.sleep(5000);
	}
	
	
	@Then("Jerry pay it by paypal payment")
	public void jerry_pay_it_by_paypal_payment() throws Exception {
		
		Payments.payment_with_paypal(driver, "Hosting_CancelledOrder_partner");	
		
		driver.close();		

		driver = Switch_tab.switch_previous_tab2(driver);
	}
	
	
	@And("Tom view order")
	public void tom_view_order() throws Exception {
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


		try {
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("(//span[text()='Orders'])[1]")));
		ac.moveToElement(driver.findElement(By.xpath("(//span[text()='List'])[5]"))).click().perform();
		}
		
		catch(Exception x)
		{
			driver.get("https://managebhavitmohod2233.qa11.dotbricks.net/adminp/orders/orders-list");
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[2]/a[1]")));
		}
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(7000);

		Order_Details_Page.capture_data_of_order_details_page_before_approval(driver, "Hosting_CancelledOrder_partner");
	}
	
	
	@Then("Tom cancels the whole order")
	public void tom_cancels_the_whole_order() throws Exception {
		
		
		Cancel_order.cancel_my_order(driver);
		
		try 
		{
		
			driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/following::table/tbody[1]/tr[1]/td[1]/a[1]")).click();
		
		}
		catch(Exception x)
		{
			driver.navigate().back();
			WebDriverWait wait2 = new WebDriverWait(driver, 50);
			wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[3]/a[1]")));
			driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[3]/a[1]")).click();
		}
		
		//billing section present in left panel
				try {
					driver.findElement(By.xpath("(//span[text()='Billing'])[4]")).click();
					Thread.sleep(3000);
				}
				catch(Exception x)
				{
					driver.navigate().refresh();
					Thread.sleep(5000);

					WebDriverWait wait = new WebDriverWait(driver, 50);
					wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#kt_aside_menu>ul>li:nth-of-type(4)>a>span:nth-of-type(2)")));

					driver.findElement(By.cssSelector("div#kt_aside_menu>ul>li:nth-of-type(4)>a>span:nth-of-type(2)")).click();
					Thread.sleep(3000);
				}

				driver.findElement(By.xpath("(//span[text()='Invoices'])[3]")).click();
				Thread.sleep(5000);

				driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[2]/a[1]")).click();
				Thread.sleep(10000);
	}

	
	@And("Tom verifies the invoice")
	public void tom_verifies_the_invoice() throws Exception {
		String status = driver.findElement(By.xpath("(//table[@class='invoice']//table)[4]/tbody[1]/tr[2]/td[1]/b[1]")).getText();
		System.out.println(status);
		
		Invoice_partner.capture_invoice_after_cancellation(driver, "Hosting_CancelledOrder_partner");

		driver.quit();
	}

	
	
	
	//Custom_invoice (Excel sheet = "Hosting_CustomeInvoice_partner")
	
	@Given("Dennis login into dQ11 Website")
	public void dennis_login_into_d_q11_website() throws Exception {
		driver = Open_Q11_portal.open_Q11_Partnerpanel();
		logger.info("Welcome to Q11 Partner portal");
		Thread.sleep(15000);

		try
		{

			//Settings DropDown
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Settings")));

			WebElement setting = driver.findElement(By.partialLinkText("Settings"));
			setting.click();	
			logger.info("try block ");

		}
		catch(Exception x)
		{
			logger.info("Catch Block .....Please help me.......");
			System.out.println(x.getStackTrace());
			driver.navigate().refresh();
			logger.info("Page Refreshed");
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			Thread.sleep(30000);
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Settings']")));
			WebElement setting = driver.findElement(By.xpath("//span[text()='Settings']"));
			setting.click();

		}

		Thread.sleep(2000);
		Actions ac = new Actions(driver);

		ac.moveToElement(driver.findElement(By.xpath("//span[text()='Offers']")));
		ac.pause(20);
		Thread.sleep(2000);
		ac.moveToElement(driver.findElement(By.xpath("//span[text()='Basic Configuration']"))).click().perform();
		Thread.sleep(2000);
	}

	
	@Then("Dennis Choose Linux Hosting Gold Offer plan")
	public void dennis_choose_linux_hosting_gold_offer_plan() throws Exception {
		
		driver = Choosing_hosting_custom_plan.select_hosting_plan_partner_panel(driver, "monthly");
		logger.info("Monthly plan is opened");
	
	}
	
	
	@When("Dennis open Monthly plan and add it to cart")
	public void dennis_open_monthly_plan_and_add_it_to_cart() throws Exception {
		//Choosing Domain
		driver = Adding_domain.entering_the_domin_from_partner_panel(driver);


		//calling Order Summary Page Method 
		Order_summary_page.capture_data_from_order_summary_page(driver, "Hosting_CancelledOrder_partner");
		logger.info("All Details from summary Page is captured");


		//Add to cart button
		driver.findElement(By.id("submit")).click();
		Thread.sleep(5000);

		driver.findElement(By.id("next_without_login")).click();
		Thread.sleep(3000);


		//create an Account
		driver.findElement(By.id("sign-up-sec")).click();
		Thread.sleep(3000);
		logger.info("Going to Create New Account");
	}
	
	
	@And("Dennis creates new account")
	public void dennis_creates_new_account() throws Exception {
		//Calling Method for NEW ACCOUNT CREATION
		New_account1.creating_new_account_from_partner_panel(driver,"Hosting_CancelledOrder_partner",3,10);


		///After Account Creation
		logger.info("After Account Creation");
		Thread.sleep(7000);

		After_account_creation.capture_data_after_account_creation_from_partner_panel(driver, "Hosting_CancelledOrder_partner");

		logger.info("All Details after creating an account is captured");

		Thread.sleep(5000);
	}
	
	
	@Then("Dennis pay it by paypal payment")
	public void dennis_pay_it_by_paypal_payment() throws Exception {
		Payments.payment_with_paypal(driver, "Hosting_CancelledOrder_partner");	
		
		driver.close();		

		driver = Switch_tab.switch_previous_tab2(driver);
	}
	
	
	@And("Cason opens Francis Profile")
	public void cason_opens_francis_profile() throws Exception {
		try {
			logger.info("In try block wait for Accounts ");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Accounts'])[1]")));


			driver.findElement(By.xpath("(//span[text()='Accounts'])[1]")).click();

		}
		catch(Exception x)
		{
			logger.info("In catch block wait for billing ");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Accounts")));


			driver.findElement(By.partialLinkText("Accounts")).click();

		}

		Thread.sleep(5000);
		Actions ac = new Actions(driver);




		ac.moveToElement(driver.findElement(By.xpath("(//span[text()='Customers'])[1]")));
		ac.moveToElement(driver.findElement(By.xpath("(//span[text()='List'])[1]"))).click().perform();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[3]/a[1]")).click();
		Thread.sleep(7000);
	}
	
	
	@Then("Cason Generates custom invoice")
	public void cason_generates_custom_invoice() throws Exception {
		//billing section present in left panel
		try {
			driver.findElement(By.xpath("(//span[text()='Billing'])[4]")).click();
			Thread.sleep(3000);
		}
		catch(Exception x)
		{
			driver.navigate().refresh();
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#kt_aside_menu>ul>li:nth-of-type(4)>a>span:nth-of-type(2)")));

			driver.findElement(By.cssSelector("div#kt_aside_menu>ul>li:nth-of-type(4)>a>span:nth-of-type(2)")).click();
			Thread.sleep(3000);
		}

		driver.findElement(By.xpath("(//span[text()='Invoices'])[3]")).click();
		Thread.sleep(5000);
	    
		driver.findElement(By.xpath("//span[text()='Important Links']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//span[text()='Create Custom Invoice ']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("invoice_date")));
	}
	
	
	@And("Cason verifies the invoice")
	public void cason_verifies_the_invoice() throws Exception {
		Custom_invoice.fill_generate_custom_invoice_for_admin_panel(driver);
		
		//driver.get("https://manage.qa11.dotbricks.net/adminp/invoices/generate-custom-invoice/VVhENVVkWW85MEU3L1ROZHdDVFhBc2xic01DSjlRei9Wb2F5Y2ZLQ2xlOD0=");
		
		Thread.sleep(5000);
		
		Custom_invoice.capture_data_of_custom_invoice_partner_panel(driver, "Hosting_CustomeInvoice_partner");
		
		Thread.sleep(5000);
		
		driver.quit();
	}
	
	
	
	
	
	

}




