package features;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import methods.Adding_partner;
import methods.After_account_creation;
import methods.Auto_Renewable;
import methods.Choosing_hosting_custom_plan;
import methods.Invoice1;
import methods.Invoice2;
import methods.Invoice_partner;
import methods.New_account1;
import methods.New_account_partners;
import methods.Open_Q11_portal;
import methods.Order_Details_Page;
import methods.Order_summary_page;
import methods.Payments;
import methods.Receipt;
import methods.Subscription_Details;
import methods.Switch_tab;
import java.util.ArrayList;
import org.openqa.selenium.JavascriptExecutor;

public class QA11_hostinglinux {

	public WebDriver driver;
	
	private static Logger logger = LogManager.getLogger(QA11_hostinglinux.class);


	//Buying Product via Bank(sheet_name = Hosting_bank)

	@Given("Ronald login into Q11 Website")
	public void ronald_login_into_Q11_Website() throws Exception {

		driver = Open_Q11_portal.open_Q11_Website();
		logger.info("Welcome to Q11 portal");
		Thread.sleep(15000);

		try
		{

		//Settings DropDown
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#kt_header_menu>ul>li:nth-of-type(8)>a>span")));

		WebElement setting = driver.findElement(By.xpath("//span[text()='Settings']"));
		setting.click();		
		
		
		
		logger.info("try block ");
		
//		Thread.sleep(60000);
//		driver.findElement(By.cssSelector("div#kt_header_menu>ul>li:nth-of-type(7)>a>span")).click();
		
		//(//*[@class='kt-menu__link-text'])[85]
		
//		List<WebElement> ls= driver.findElements(By.xpath("//*[@class='kt-menu__link-text']"));
//		for(WebElement list : ls )
//		{
//		list.getLocation();
//			System.out.println(list.getCssValue("Settings"));
//		}
//		
		
//		driver.findElement(By.xpath("(//*[@class='kt-menu__link-text'])[85]")).click();
		
		logger.info("Settings Openend");

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

		ac.moveToElement(driver.findElement(By.xpath("(//span[contains(.,'Offers')])[2]")));
		ac.pause(20);
		Thread.sleep(2000);
		ac.moveToElement(driver.findElement(By.xpath("(//a[@href='/adminp/products-type/product-type-list']//span)[2]"))).click().perform();
		Thread.sleep(2000);

	}


	@Then("Ronald Choose Linux Hosting Gold Offer plan")
	public void ronald_choose_linux_hosting_gold_offer_plan() throws Exception {
		
		
		driver = Choosing_hosting_custom_plan.select_hosting_plan(driver, "monthly");
		logger.info("Monthly plan is opened");
		

	}


	@When("Ronald open Monthly plan and add it to cart")
	public void ronald_open_monthly_plan_and_add_it_to_cart() throws Exception {

		//Choosing Domain
		driver = Adding_domain.entering_the_domin_from_admin_panel(driver);
		

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


	@Then("Ronald creates new account")
	public void ronald_creates_new_account() throws Exception {


		//Calling Method for NEW ACCOUNT CREATION
		New_account1.creating_new_account_from_admin_panel(driver,"Hosting_bank",3,10);

		///After Account Creation
		logger.info("After Account Creation");
		Thread.sleep(7000);

		After_account_creation.capture_data_after_account_creation_from_admin_panel(driver, "Hosting_bank");
		
		logger.info("All Details after creating an account is captured");

		Thread.sleep(5000);

	}


	@Then("Ronald pay it by bank payment")
	public void ronald_pay_it_by_bank_payment() throws Exception {

		logger.info("Mode of Payment Bank");
		
		Payments.payment_with_bank(driver,"Hosting_bank");
		
		logger.info("Payment Sucessfully done");

		Thread.sleep(5000);	
		
//		driver.close();
		
		driver = Switch_tab.switch_previous_tab2(driver);

		
		
		
	}

	
	// Approving order and verifying Invoice via bank

	@And("Arthur view Billing")
	public void arthur_view_billing() throws Exception {
		


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

		Order_Details_Page.capture_data_of_order_details_page_before_approval(driver, "Hosting_bank");



	}


	@Then("Arthur Approve for product")
	public void arthur_approve_for_product() throws Exception {


		Order_Details_Page.approve_order(driver);

		Order_Details_Page.capture_data_of_order_details_page_after_approval(driver, "Hosting_bank");



	}


	@And("Arthur clicks on invoice")
	public void arthur_clicks_on_invoice() throws Exception {

		Order_Details_Page.go_to_invoice(driver);
		Thread.sleep(3000);



	}


	@Then("Arthur verifies the invoice")

	public void arthur_verifies_the_invoice() throws Exception {


		Switch_tab.switch_next_tab(driver);

		Invoice1.capture_invoice_ordered_with_bank(driver, "Hosting_bank");

		Thread.sleep(7000);

		driver.quit();
	}

	



	
	
	


	//Buying Product via Paypal(sheet_name = Hosting_paypal)
	
	@Given("Ginny login into Q11 Website")
	public void ginny_login_into_Q11_website() throws Exception {


		driver = Open_Q11_portal.open_Q11_Website();

		try
		{

		logger.info("try block ");
		//Settings DropDown
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#kt_header_menu>ul>li:nth-of-type(8)>a>span")));

		WebElement setting = driver.findElement(By.cssSelector("div#kt_header_menu>ul>li:nth-of-type(8)>a>span"));
		setting.click();					
		logger.info("Settings Openend");

		}
		catch(Exception x)
		{
			logger.info("Catch Block .....Please help me.......");
			System.out.println(x.getStackTrace());
			driver.navigate().refresh();
			logger.info("Page Refreshed");
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			Thread.sleep(30000);
			
			//Settings DropDown
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Settings']")));
			WebElement setting = driver.findElement(By.xpath("//span[text()='Settings']"));
			setting.click();	
			logger.info("Settings Openend");
			
		}


		Thread.sleep(2000);
		Actions ac = new Actions(driver);

		ac.moveToElement(driver.findElement(By.xpath("(//span[contains(.,'Offers')])[2]")));
		ac.moveToElement(driver.findElement(By.xpath("//span[contains(.,'Basic Configuration')]"))).click().perform();
		Thread.sleep(2000);

	}


	@Then("Ginny Choose Linux Hosting Gold Offer plan")
	public void ginny_choose_linux_hosting_gold_offer_plan() throws Exception {

		//Opening monthly Plan link
		driver = Choosing_hosting_custom_plan.select_hosting_plan(driver, "monthly");



	}


	@When("Ginny open Monthly plan add it to cart")
	public void ginny_open_monthly_plan_add_it_to_cart() throws Exception {
		
		//Domain
		Adding_domain.entering_the_domin_from_admin_panel(driver);

		Order_summary_page.capture_data_from_order_summary_page(driver,"Hosting_paypal");

		//Add to cart button
		driver.findElement(By.id("submit")).click();
		Thread.sleep(5000);

		
		driver.findElement(By.id("next_without_login")).click();


		//create an Account
		driver.findElement(By.id("sign-up-sec")).click();
		Thread.sleep(3000);

	}


	@And("Ginny creates new account")
	public void ginny_creates_new_account() throws Exception {

//		Calling Method for CREATIION OF NEW CUSTOMER ACCOUNT
		New_account1.creating_new_account_from_admin_panel(driver, "Hosting_paypal",3,10);

		///After Account Creation
		System.out.println("After account creation");
		Thread.sleep(7000);


		After_account_creation.capture_data_after_account_creation_from_admin_panel(driver, "Hosting_paypal");

	}


	@Then("Ginny pay it by paypal payment")
	public void ginny_pay_it_by_paypal_payment() throws Exception {


		Payments.payment_with_paypal(driver, "Hosting_paypal");	

		driver = Switch_tab.switch_previous_tab2(driver);
	}


	//Verifying Product Order and Invoice paid via paypal 


	@And("Snape view Billing")
	public void snape_view_billing() throws Exception {
		
		
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

		Order_Details_Page.capture_data_of_order_details_page_before_approval(driver, "Hosting_paypal");
		Thread.sleep(5000);
		
		

	}
	

	@Then("Snape verifies the invoice")
	public void snape_verifies_the_invoice() throws Exception {
		

		Order_Details_Page.go_to_invoice(driver);
		Thread.sleep(3000);
		
		Switch_tab.switch_next_tab(driver);


		Thread.sleep(5000);
		
		Invoice1.capture_invoice_ordered_with_paypal(driver, "Hosting_paypal");


		Thread.sleep(7000);
		//Closes both Tabs 
		driver.quit();
	}









	//Customer adding Lending Credit and again Order via Credit Limit  (Sheet Name = "Hosting_CreditLimit")

	@Given("Fred register with Q11 Website")
	public void fred_register_with_q11_website() throws Exception {
		
		//Launching Browser
		driver = Open_Q11_portal.open_Q11_Website();
		Thread.sleep(5000);
		
		
	}


	@Then("Fred open his account and add credit limit")
	public void fred_open_his_account_and_add_credit_limit() throws Exception {
		

		Adding_customer.add_customer(driver, "Hosting_CreditLimit");
	
		
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


	@Then("Fred Choose Linux Hosting Gold Offer plan")
	public void fred_choose_linux_hosting_gold_offer_plan() throws Exception {


		try
		{
		//Settings DropDown
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#kt_header_menu>ul>li:nth-of-type(7)>a>span")));

		WebElement setting = driver.findElement(By.xpath("//span[text()='Settings']"));
		setting.click();		
		
		logger.info("try block ");
		
		logger.info("Settings Openend");

		}
		catch(Exception x)
		{
			logger.info("Catch Block .....Please help me.......");
			System.out.println(x.getStackTrace());
			driver.navigate().refresh();
			logger.info("Page Refreshed");
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			Thread.sleep(60000);
			driver.findElement(By.cssSelector("div#kt_header_menu>ul>li:nth-of-type(7)>a>span")).click();	
			
		}

		Thread.sleep(2000);
		Actions ac = new Actions(driver);

		ac.moveToElement(driver.findElement(By.xpath("(//span[contains(.,'Offers')])[2]")));
		ac.moveToElement(driver.findElement(By.xpath("//span[contains(.,'Basic Configuration')]"))).click().perform();
		Thread.sleep(2000);

		
		try {
		
			driver = Choosing_hosting_custom_plan.select_hosting_plan(driver,"Monthly");

		}
		catch(Exception x)
		{
			Thread.sleep(5000);
			driver.navigate().refresh();
			driver = Choosing_hosting_custom_plan.select_hosting_plan(driver,"Monthly");
			
		}
		
		
	}


	@When("Fred open Monthly plan add it to cart")
	public void fred_open_monthly_plan_add_it_to_cart() throws Exception {

		//Domain
		driver = Adding_domain.entering_the_domin_from_admin_panel(driver);
		Thread.sleep(3000);

		Order_summary_page.capture_data_from_order_summary_page(driver, "Hosting_CreditLimit");
		Thread.sleep(5000);

		//Add to cart button
		driver.findElement(By.id("submit")).click();
		Thread.sleep(3000);

		//next button
		driver.findElement(By.id("next_without_login")).click();


	}


	@And("Fred login with his account")
	public void fred_login_with_his_account() throws Exception {

		//Location Of Excel Sheet
		String xlpath = System.getProperty("user.dir") + "/src/main/resources/Q11-Hosting.xlsx";

		///Opening Excel Sheet
		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet("Hosting_CreditLimit");


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


	@Then("Fred pay it by credit payment")
	public void fred_pay_it_by_credit_payment() throws Exception {

			///previoulsy partner panel
		After_account_creation.capture_data_after_account_creation_from_admin_panel(driver, "Hosting_CreditLimit");
		
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
		
		driver = Switch_tab.switch_previous_tab2(driver);

	}

	
	//Verifying Product Order and Invoice paid via credit limit
	
	@And("McGonagall view Billing")
	public void mcgonagall_view_billing() throws Exception {
		
		
		
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

		Order_Details_Page.capture_data_of_order_details_page_before_approval(driver, "Hosting_CreditBalance");
		Thread.sleep(5000);
		
		

	}


	@Then("McGonagall verifies the invoice")
	public void mcgonagall_verifies_the_invoice() throws Exception {
		

		Order_Details_Page.go_to_invoice(driver);
		
		Switch_tab.switch_next_tab(driver);


		Thread.sleep(5000);
		
		Invoice1.capture_invoice_ordered_with_credit_limit(driver, "Hosting_CreditLimit");


		Thread.sleep(7000);
		//Closes both Tabs 
		driver.quit();
	}





	////DOBBY is adding adding credit Balance and ordering Product via Credit Balance(Sheet Name = "Hosting_CreditBalance")

	@Given("Dobby register with Q11 Website")
	public void dobby_register_with_q11_website() throws Exception {
		//Launching Browser
		
		driver = Open_Q11_portal.open_Q11_Website();
		Thread.sleep(5000);
				
	}


	@Then("Dobby open his account and add credit balance")
	public void dobby_open_his_account_and_add_credit_balance() throws Exception {
		
		//Customer,ie.Dobby creating account 
		Adding_customer.add_customer(driver, "Hosting_CreditBalance");
	
		
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


		
	}
	
	
	@Then("Dobby Choose Linux Hosting Gold Offer plan")
	public void dobby_choose_linux_hosting_gold_offer_plan() throws Exception {
		
		
		
		
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
		
			driver = Choosing_hosting_custom_plan.select_hosting_plan(driver,"Monthly");

		}
		catch(Exception x)
		{
			Thread.sleep(5000);
			driver.navigate().refresh();
			driver = Choosing_hosting_custom_plan.select_hosting_plan(driver,"Monthly");
			
		}
	   
		
		
		
	}
	
	
	@When("Dobby open Monthly plan add it to cart")
	public void dobby_open_monthly_plan_add_it_to_cart() throws Exception {
		
		
		driver = Adding_domain.entering_the_domin_from_admin_panel(driver);
		
		Order_summary_page.capture_data_from_order_summary_page(driver, "Hosting_CreditBalance");
		
		 //Add to cart button
        driver.findElement(By.id("submit")).click();
        
		Thread.sleep(5000);

		//next button
		driver.findElement(By.id("next_without_login")).click();
		
	}
	
	
	@When("Dobby login with his account")
	public void dobby_login_with_his_account() throws Exception {
		
		//Location Of Excel Sheet
				String xlpath = System.getProperty("user.dir") + "/src/main/resources/Q11-Hosting.xlsx";

				///Opening Excel Sheet
				File source = new File(xlpath);
				FileInputStream fi = new FileInputStream(source);
				XSSFWorkbook wb = new XSSFWorkbook(fi);
				XSSFSheet sheet = wb.getSheet("Hosting_CreditBalance");


				String Username = sheet.getRow(3).getCell(10).getStringCellValue();
				String password = sheet.getRow(4).getCell(10).getStringCellValue();


				driver.findElement(By.name("user")).sendKeys(Username);
				Thread.sleep(3000);

				driver.findElement(By.id("login_form_password")).sendKeys(password);
				Thread.sleep(3000);


				driver.findElement(By.name("log_in")).click();
				

				FileOutputStream fos = new FileOutputStream(source);
				wb.write(fos);
				wb.close();
				fi.close();
				fos.close();
				
				Thread.sleep(5000);
				
				
		
	}
	
	
	@Then("Dobby pay it by credit balance")
	public void dobby_pay_it_by_credit_balance() throws Exception {
		
			
			After_account_creation.capture_data_after_account_creation_from_admin_panel(driver, "Hosting_CreditBalance");
			
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
			
			driver = Switch_tab.switch_previous_tab2(driver);

	}
	
	//Verifying Product Order and Invoice paid via credit_balance
	
	@Then("Dumbledore view Billing")
	public void dumbledore_view_billing() throws Exception {
		
		
		
		try {
			logger.info("In try block wait for billing ");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(.,'Billing')])[1]")));
	

		driver.findElement(By.xpath("(//span[contains(.,'Billing')])[1]")).click();

			}
		catch(Exception x)
		{
			logger.info("In catch block wait for billing ");
			
			driver.navigate().refresh();
			
			logger.info("page refreshed");
			
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

		Order_Details_Page.capture_data_of_order_details_page_before_approval(driver, "Hosting_CreditBalance");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//h3[@class='kt-portlet__head-title']//a[1]")).click();
		Thread.sleep(5000);
	
		
		
	}

	
	@Then("Dumbledore verifies the invoice")
	public void dumbledore_verifies_the_invoice() throws Exception {
		
		Switch_tab.switch_next_tab(driver);

		Invoice1.capture_invoice_ordered_with_credit_balance(driver, "Hosting_CreditBalance");

		Thread.sleep(7000);

		driver.quit();
		
		
	}
	
	
	
	
	
	
	
	////Justin is buying Product via Bank(sheet_name = Hosting_bank)
	///Oliver is adding Receipt
	
	@Given("Justin login into Q11 Website")
	public void justin_login_into_q11_website() throws Exception {
		
		driver = Open_Q11_portal.open_Q11_Website();
		logger.info("Welcome to Q11 portal");
		Thread.sleep(15000);

		try
		{
			logger.info("try block ");

		//Settings DropDown
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#kt_header_menu>ul>li:nth-of-type(8)>a>span")));

		WebElement setting = driver.findElement(By.xpath("//span[text()='Settings']"));
		setting.click();		
		
		logger.info("Settings Openend");

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

		ac.moveToElement(driver.findElement(By.xpath("(//span[contains(.,'Offers')])[2]")));
		ac.pause(20);
		Thread.sleep(2000);
		ac.moveToElement(driver.findElement(By.xpath("(//a[@href='/adminp/products-type/product-type-list']//span)[2]"))).click().perform();
		Thread.sleep(2000);
		
		
	}

	
	@Then("Justin Choose Linux Hosting Gold Offer plan")
	public void justin_choose_linux_hosting_gold_offer_plan() throws Exception {
		
		driver = Choosing_hosting_custom_plan.select_hosting_plan(driver, "monthly");
		logger.info("Monthly plan is opened");
		
	}
	
	
	@When("Justin open Monthly plan and add it to cart")
	public void justin_open_monthly_plan_and_add_it_to_cart() throws Exception {
		//Choosing Domain
				driver = Adding_domain.entering_the_domin_from_admin_panel(driver);
				

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
	
	
	@When("Justin creates new account")
	public void justin_creates_new_account() throws Exception {
		//Calling Method for NEW ACCOUNT CREATION
				New_account1.creating_new_account_from_admin_panel(driver,"Hosting_bank",3,10);

				///After Account Creation
				logger.info("After Account Creation");
				Thread.sleep(7000);

				After_account_creation.capture_data_after_account_creation_from_admin_panel(driver, "Hosting_bank");
				
				logger.info("All Details after creating an account is captured");

				Thread.sleep(5000);
	}
	
	
	@Then("Justin pay it by bank payment")
	public void justin_pay_it_by_bank_payment() throws Exception {
		logger.info("Mode of Payment Bank");
		
		Payments.payment_with_bank(driver,"Hosting_bank");
		
		logger.info("Payment Sucessfully done");

		Thread.sleep(5000);	
		
//		driver.close();
		
		driver = Switch_tab.switch_previous_tab2(driver);

	}
	
	
	@And("Oliver opens Justin Profile")
	public void oliver_opens_justin_profile() throws Exception {
	   
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

	
	
	@Then("Oliver added receipt which is paid by Justin")
	public void oliver_added_receipt_which_is_paid_by_justin() throws Exception {
		
			
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
	

	
	@Then("Oliver approves for the product")
	public void oliver_approves_for_the_product() throws Exception {
		
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

		Order_Details_Page.capture_data_of_order_details_page_before_approval(driver, "Hosting_bank");
		
		
		
		Order_Details_Page.approve_order(driver);

		Order_Details_Page.capture_data_of_order_details_page_after_approval(driver, "Hosting_bank");
		
		
	}
	
	
	
	@Then("Oliver verifies the invoice")
	public void oliver_verifies_the_invoice() throws Exception {
		
		Order_Details_Page.go_to_invoice(driver);
		Thread.sleep(3000);
		
		Switch_tab.switch_next_tab(driver);


		Thread.sleep(5000);
		
		Invoice2.capture_invoice_details_status_paid(driver, "Hosting_bank");

		Thread.sleep(7000);
		//Closes both Tabs 
		driver.quit();
	
	
	
	
	}
	
	
	
	
	
	///Invoice Generation with AutoRenewal Off
	
	
	@Given("Joseph login into Q11 Website")
	public void joseph_login_into_q11_website() throws Exception {
		
		driver = Open_Q11_portal.open_Q11_Website();

		try
		{

		logger.info("try block ");
		//Settings DropDown
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#kt_header_menu>ul>li:nth-of-type(8)>a>span")));

		WebElement setting = driver.findElement(By.cssSelector("div#kt_header_menu>ul>li:nth-of-type(8)>a>span"));
		setting.click();					
		logger.info("Settings Openend");

		}
		catch(Exception x)
		{
			logger.info("Catch Block .....Please help me.......");
			System.out.println(x.getStackTrace());
			driver.navigate().refresh();
			logger.info("Page Refreshed");
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			Thread.sleep(30000);
			
			//Settings DropDown
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Settings']")));
			WebElement setting = driver.findElement(By.xpath("//span[text()='Settings']"));
			setting.click();	
			logger.info("Settings Openend");
			
		}


		Thread.sleep(2000);
		Actions ac = new Actions(driver);

		ac.moveToElement(driver.findElement(By.xpath("(//span[contains(.,'Offers')])[2]")));
		ac.moveToElement(driver.findElement(By.xpath("//span[contains(.,'Basic Configuration')]"))).click().perform();
		Thread.sleep(2000);
		
		
	}

	
	@Then("Joseph Choose Linux Hosting Gold Offer plan")
	public void joseph_choose_linux_hosting_gold_offer_plan() throws Exception {
		
		//Opening monthly Plan link
		driver = Choosing_hosting_custom_plan.select_hosting_plan(driver, "monthly");
		
	}
	
	
	@When("Joseph open Monthly plan add it to cart")
	public void joseph_open_monthly_plan_add_it_to_cart() throws Exception {
		
		//Domain
				Adding_domain.entering_the_domin_from_admin_panel(driver);

				Order_summary_page.capture_data_from_order_summary_page(driver,"Hosting_paypal");

				//Add to cart button
				driver.findElement(By.id("submit")).click();
				Thread.sleep(5000);

				
				driver.findElement(By.id("next_without_login")).click();


				//create an Account
				driver.findElement(By.id("sign-up-sec")).click();
				Thread.sleep(3000);
	}
	
	
	@When("Joseph creates new account")
	public void joseph_creates_new_account() throws Exception {
		
//		Calling Method for CREATIION OF NEW CUSTOMER ACCOUNT
		New_account1.creating_new_account_from_admin_panel(driver, "Hosting_paypal",3,10);

		///After Account Creation
		System.out.println("After account creation");
		Thread.sleep(7000);


		After_account_creation.capture_data_after_account_creation_from_admin_panel(driver, "Hosting_paypal");

		
	}
	
	
	@Then("Joseph pay it by paypal payment")
	public void joseph_pay_it_by_paypal_payment() throws Exception {
		Payments.payment_with_paypal(driver, "Hosting_paypal");	

		driver = Switch_tab.switch_previous_tab2(driver);	
		
	}
	
	
	@Then("Leo opens Joseph Profile")
	public void leo_opens_joseph_profile() throws Exception {
		
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
	
	
	@Then("Leo turns off Joseph auto renewal service off")
	public void leo_turns_off_joseph_auto_renewal_service_off() throws Exception {
		
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
		
		
	}
	
	
	@Then("Leo generates invoice")
	public void leo_generates_invoice() throws Exception {
		
		//Subscription
		driver.findElement(By.xpath("(//span[text()='Subscriptions'])[4]")).click();
		Thread.sleep(3000);
		
		//Select check box 
		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/thead[1]/tr[1]/th[1]/label[1]/span[1]")).click();
		
		
		driver.findElement(By.xpath("(//span[text()='Invoices'])[3]")).click();
		Thread.sleep(3000);
	    
		
		
	}
	
	
	
	@Then("Leo verifies the invoice")
	public void leo_verifies_the_invoice() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}



	
	
	
	
	
	
	//Creating Addon
	
	@Given("Mario login into Q11 Website")
	public void mario_login_into_q11_website() throws Exception {
		
		driver = Open_Q11_portal.open_Q11_Website();

		try
		{

		logger.info("try block ");
		//Settings DropDown
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#kt_header_menu>ul>li:nth-of-type(8)>a>span")));

		WebElement setting = driver.findElement(By.cssSelector("div#kt_header_menu>ul>li:nth-of-type(8)>a>span"));
		setting.click();					
		logger.info("Settings Openend");

		}
		catch(Exception x)
		{
			logger.info("Catch Block .....Please help me.......");
			System.out.println(x.getStackTrace());
			driver.navigate().refresh();
			logger.info("Page Refreshed");
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			Thread.sleep(30000);
			
			//Settings DropDown
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Settings']")));
			WebElement setting = driver.findElement(By.xpath("//span[text()='Settings']"));
			setting.click();	
			logger.info("Settings Openend");
			
		}


		Thread.sleep(2000);
		Actions ac = new Actions(driver);

		ac.moveToElement(driver.findElement(By.xpath("(//span[contains(.,'Offers')])[2]")));
		ac.moveToElement(driver.findElement(By.xpath("//span[contains(.,'Basic Configuration')]"))).click().perform();
		Thread.sleep(2000);
		
		
	}

	
	@Then("Mario Choose Linux Hosting Gold Offer plan")
	public void mario_choose_linux_hosting_gold_offer_plan() throws Exception {
		
		//Opening monthly Plan link
		driver = Choosing_hosting_custom_plan.select_hosting_plan(driver, "monthly");
		
	}
	
	
	@When("Mario open Monthly plan add it to cart")
	public void mario_open_monthly_plan_add_it_to_cart() throws Exception {

		//Choosing Domain
		driver = Adding_domain.entering_the_domin_from_admin_panel_without_addon(driver);

		//Add to cart button
		driver.findElement(By.id("submit")).click();
		Thread.sleep(5000);
		
		
		driver.findElement(By.id("next_without_login")).click();


		//create an Account
		driver.findElement(By.id("sign-up-sec")).click();
		Thread.sleep(3000);
		logger.info("Going to Create New Account");
	}
	
	
	@And("Mario creates new account")
	public void mario_creates_new_account() throws Exception {

		//Calling Method for CREATIION OF NEW CUSTOMER ACCOUNT
		New_account1.creating_new_account_from_admin_panel(driver, "Hosting_paypal",3,10);

		///After Account Creation
		System.out.println("After account creation");
		Thread.sleep(7000);

	
	}
	
	
	@Then("Mario pay it by paypal payment")
	public void mario_pay_it_by_paypal_payment() throws Exception {
		
		Payments.payment_with_paypal(driver, "Hosting_paypal");
		driver = Switch_tab.switch_previous_tab2(driver);	
		
	}
	
	
	@And("Luigi opens Mario Profile")
	public void luigi_opens_mario_profile() throws Exception {
		
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
	
	
	@Then("Luigi adds Addons to Mario subscription plan")
	public void luigi_adds_addons_to_mario_subscription_plan() throws Exception {
		
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
	
	
	@Then("Luigi verifies generated Order")
	public void luigi_verifies_generated_order() throws Exception {
		
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
//		String order_status= driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[6]/span[1]")).getText();
//		System.out.println(order_status);
 		

	}
	
	
	@And("Luigi adds receipt")
	public void luigi_adds_receipt() throws Exception {
		
		try {
		//Receipt
		driver.findElement(By.xpath("(//span[text()='Receipts'])[3]")).click();
		logger.info("try block receipt section opened");
		Thread.sleep(7000);
		
		}
		catch(Exception x)
		{
			//Receipt
			driver.findElement(By.cssSelector("div#kt_aside_menu>ul>li:nth-of-type(4)>div>ul>li:nth-of-type(4)>a>span")).click();
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
	
	}
	
	
	@Then("Luigi approves for the product")
	public void luigi_approves_for_the_product() throws Exception {
		
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
		Thread.sleep(7000);
		
		driver.findElement(By.xpath("//h3[@class='kt-portlet__head-title']//a[1]")).click();
		
		Switch_tab.switch_next_tab(driver);
		
		String paid_date = driver.findElement(By.xpath("(//table[@class='invoice']//table)[4]/tbody[1]/tr[2]/td[2]")).getText();
		System.out.println(paid_date);
		
	}


	
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
		
		driver = Choosing_hosting_custom_plan.select_hosting_plan(driver, "monthly");
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
		
//		driver.close();
		
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
		

		Order_Details_Page.go_to_invoice(driver);
		Thread.sleep(3000);
		
		Switch_tab.switch_next_tab(driver);


		Thread.sleep(5000);
		
		Invoice_partner.capture_invoice_ordered_with_bank(driver, "Hosting_bank_partner");


		Thread.sleep(7000);
		//Closes both Tabs 
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
		
		driver = Choosing_hosting_custom_plan.select_hosting_plan(driver, "monthly");
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


		Thread.sleep(5000);
		
		Invoice_partner.capture_invoice_ordered_with_paypal(driver, "Hosting_paypal_partner");


		Thread.sleep(7000);
		//Closes both Tabs 
		driver.quit();
		
		
	}
	
	
	
	
	
	
	//Customer adding Lending Credit and again Order via Credit Limit  (Sheet Name = "Hosting_CreditLimit_partner")
	
	@Given("Susan register with Q11 partner portal")
	public void susan_register_with_q11_partner_portal() throws Exception {
		
		//Launching Browser
		driver = Open_Q11_portal.open_Q11_Website();
		Thread.sleep(5000);
			
	}


	@Then("Susan open his account and add credit limit")
	public void susan_open_his_account_and_add_credit_limit() throws Exception {

		Adding_customer.add_customer(driver, "Hosting_CreditLimit_partner");
	
		
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
		
			driver = Choosing_hosting_custom_plan.select_hosting_plan(driver,"Monthly");

		}
		catch(Exception x)
		{
			Thread.sleep(5000);
			driver.navigate().refresh();
			driver = Choosing_hosting_custom_plan.select_hosting_plan(driver,"Monthly");
			
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


		Thread.sleep(5000);
		
		
		//Invoice must be unpaid
		Invoice_partner.capture_invoice_ordered_with_bank(driver, "Hosting_CreditLimit_partner");


		Thread.sleep(7000);
		//Closes both Tabs 
		driver.quit();
		
	}

	
	

	
	//HARRY is adding adding credit Balance and ordering Product via Credit Balance(Sheet Name = "Hosting_CreditBalance_partner")
	
	
	@Given("Harry register with Q11 partner portal")
	public void harry_register_with_q11_partner_portal() throws Exception {
		//Launching Browser
		driver = Open_Q11_portal.open_Q11_Website();
		Thread.sleep(5000);
	}


	@Then("Harry open his account and add credit balance")
	public void harry_open_his_account_and_add_credit_balance() throws Exception {
		
		//Customer,ie.Harry creating account 
				Adding_customer.add_customer(driver, "Hosting_CreditBalance_partner");
			
				
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
		
			driver = Choosing_hosting_custom_plan.select_hosting_plan(driver,"Monthly");

		}
		catch(Exception x)
		{
			Thread.sleep(5000);
			driver.navigate().refresh();
			driver = Choosing_hosting_custom_plan.select_hosting_plan(driver,"Monthly");
			
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


		Thread.sleep(5000);
		
		Invoice_partner.capture_invoice_ordered_with_paypal(driver, "Hosting_CreditLimit_partner");


		Thread.sleep(7000);
		//Closes both Tabs 
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
	    
		driver = Choosing_hosting_custom_plan.select_hosting_plan(driver, "monthly");
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
		
//		driver.close();
		
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


		Thread.sleep(5000);
		
		Invoice2.capture_invoice_details_status_paid_for_partner(driver, "Hosting_bank_partner");

		Thread.sleep(7000);
		//Closes both Tabs 
		driver.quit();
	    
	}

	
	
	
	
	
	
	
	

	
	
	//Creating Receipt 

	@Given("Customer is in his dashboard page")
	public void customer_is_in_his_dashboard_page() throws Exception {
		
//		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/following::table/tbody[1]/tr[1]/td[1]/a[1]")).click();
//		Thread.sleep(2000);
		
		//Testing purpose 
		
//		driver = Open_Q11_portal.open_Q11_Website();
//		Thread.sleep(5000);
		
		
		
		
		driver.findElement(By.xpath("(//span[text()='Accounts'])[1]")).click();
		
		Actions ac = new Actions(driver);
		
		ac.moveToElement(driver.findElement(By.xpath("(//span[text()='Customers'])[1]")));
		
		ac.moveToElement(driver.findElement(By.xpath("(//span[text()='List'])[1]"))).click().perform();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[3]/a[1]")).click();
		
		//Testing ends ///
	
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
		
	}

	@Then("Customer added Receipt")
	public void customer_added_receipt() throws Exception {
		
		
		
	
		
		
        
		//capture details of receipt page and Switch Tabs
		
		Receipt.capture_details_of_receipt(driver, "Hosting_bank");
		
		((JavascriptExecutor)driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		

	}
	
	@Then("Customer verifies the payment by checking invoice")
	public void customer_verifies_the_payment_by_checking_invoice() throws Exception {
	
		//Clicks on Invoice
		driver.findElement(By.xpath("(//span[text()='Invoices'])[3]")).click();
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(5000);
		
		//Remember receipt date and paid date must be same so validate it
//		Invoice1.capture_performa_invoice(driver, "Hosting_bank", 81);
		
		driver.navigate().back();

	}
	
	@Then("Customer generated invoice with autoRenewable ON")
	public void customer_generated_invoice_with_auto_renewable_on() throws Exception {
		
		Auto_Renewable.go_to_subscription_details_page(driver);
		
		Auto_Renewable.auto_renewable_on(driver);
		
		
	
	}
	
	@Then("Customer generated invoice with autorenewable OFF")
	public void customer_generated_invoice_with_autorenewable_off() throws Exception {
	
		//Open Billing Section
		driver.findElement(By.xpath("(//span[text()='Billing'])[4]"));
		Thread.sleep(2000);
		
		//Clicks on Invoice
		driver.findElement(By.xpath("(//span[text()='Invoices'])[3]")).click();
		Thread.sleep(3000);
		
		//Select product
		driver.findElement(By.cssSelector("div#list_data>div>table>thead>tr>th>label>span")).click();
		
		
		
		
		
		
	}






}










