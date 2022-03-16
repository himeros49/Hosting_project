package features;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import methods.Adding_Credit_Balance;
import methods.Adding_customer;
import methods.Adding_domain;
import methods.After_account_creation;
import methods.Choosing_hosting_custom_plan;
import methods.Invoice1;
import methods.Invoice2;
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

public class QA11_hostinglinux_adminPanel {
	
	public WebDriver driver;

	private static Logger logger = LogManager.getLogger(QA11_hostinglinux_adminPanel.class);

	
	
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


		driver = Choosing_hosting_custom_plan.select_hosting_plan_admin_panel(driver, "monthly");
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

		driver.close();

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
		

//        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));

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
		driver = Choosing_hosting_custom_plan.select_hosting_plan_admin_panel(driver, "monthly");



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

		//		Calling Method for CREATION OF NEW CUSTOMER ACCOUNT
		New_account1.creating_new_account_from_admin_panel(driver, "Hosting_paypal",3,10);

		///After Account Creation
		System.out.println("After account creation");
		Thread.sleep(7000);


		After_account_creation.capture_data_after_account_creation_from_admin_panel(driver, "Hosting_paypal");

	}


	@Then("Ginny pay it by paypal payment")
	public void ginny_pay_it_by_paypal_payment() throws Exception {


		Payments.payment_with_paypal(driver, "Hosting_paypal");	
		
		driver.close();

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
		
//      ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//      driver.switchTo().window(tabs.get(1));


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


		Adding_customer.add_customer_in_admin_panel(driver, "Hosting_CreditLimit");


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

			driver = Choosing_hosting_custom_plan.select_hosting_plan_admin_panel(driver,"Monthly");

		}
		catch(Exception x)
		{
			Thread.sleep(5000);
			driver.navigate().refresh();
			driver = Choosing_hosting_custom_plan.select_hosting_plan_admin_panel(driver,"Monthly");

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
		
		driver.close();

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
		
//      ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//      driver.switchTo().window(tabs.get(1));
		


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
		Adding_customer.add_customer_in_admin_panel(driver, "Hosting_CreditBalance");


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

			driver = Choosing_hosting_custom_plan.select_hosting_plan_admin_panel(driver,"Monthly");

		}
		catch(Exception x)
		{
			Thread.sleep(5000);
			driver.navigate().refresh();
			driver = Choosing_hosting_custom_plan.select_hosting_plan_admin_panel(driver,"Monthly");

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
		
		driver.close();

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
		
//      ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//      driver.switchTo().window(tabs.get(1));

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

		driver = Choosing_hosting_custom_plan.select_hosting_plan_admin_panel(driver, "monthly");
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

		driver.close();

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
//      ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//      driver.switchTo().window(tabs.get(1));


		Thread.sleep(5000);

		Invoice2.capture_invoice_details_status_paid(driver, "Hosting_bank");

		Thread.sleep(7000);
		
		//Closes both Tabs 
		driver.quit();




	}



	
	

	///Invoice Generation with AutoRenewal Off  (Excel Sheet = "Hosting_paypal")


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
		driver = Choosing_hosting_custom_plan.select_hosting_plan_admin_panel(driver, "monthly");

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
		
		driver.close();

		driver = Switch_tab.switch_previous_tab2(driver);	

	}


	@Then("Leo opens Joseph Profile")
	public void leo_opens_joseph_profile() throws Exception {

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
		Thread.sleep(3000);


	}


	@Then("Leo generates invoice")
	public void leo_generates_invoice() throws Exception {

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

		//Verification of Success
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


	@Then("Leo verifies the invoice")
	public void leo_verifies_the_invoice() throws Exception {

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
		Thread.sleep(5000);

	}


	@And("Leo adds receipt")
	public void leo_adds_receipt() throws Exception {

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
		
		///Open Receipt and cature details 
		//////      ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//      driver.switchTo().window(tabs.get(1));
		
		
		
	}


	@Then("Leo again verifies the invoice")
	public void leo_again_verifies_the_invoice() throws Exception {
		
		
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
	
	
	
	
	
	

	///Invoice Generation with AutoRenewal ON (Excel sheet = "Hosting_paypal")

	@Given("Robert login into Q11 Website")
	public void robert_login_into_q11_website() throws Exception {
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


	@Then("Robert Choose Linux Hosting Gold Offer plan")
	public void robert_choose_linux_hosting_gold_offer_plan() throws Exception {

		//Opening monthly Plan link
		driver = Choosing_hosting_custom_plan.select_hosting_plan_admin_panel(driver, "monthly");

	}


	@When("Robert open Monthly plan add it to cart")
	public void robert_open_monthly_plan_add_it_to_cart() throws Exception {
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


	@When("Robert creates new account")
	public void robert_creates_new_account() throws Exception {
		//			Calling Method for CREATIION OF NEW CUSTOMER ACCOUNT
		New_account1.creating_new_account_from_admin_panel(driver, "Hosting_paypal",3,10);

		///After Account Creation
		System.out.println("After account creation");
		Thread.sleep(7000);


		After_account_creation.capture_data_after_account_creation_from_admin_panel(driver, "Hosting_paypal");
	}


	@Then("Robert pay it by paypal payment")
	public void robert_pay_it_by_paypal_payment() throws Exception {
		Payments.payment_with_paypal(driver, "Hosting_paypal");
		
		driver.close();

		driver = Switch_tab.switch_previous_tab2(driver);

	}


	@Then("Victor opens Robert Profile")
	public void victor_opens_robert_profile() throws Exception {
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


	@Then("Victor turns off Robert auto renewal service on")
	public void victor_turns_off_robert_auto_renewal_service_on() throws Exception {

		//Subscription Section present in the left panel
		driver.findElement(By.xpath("(//span[text()='Subscriptions'])[3]")).click();
		Thread.sleep(3000);

		//Sub Subscription
		driver.findElement(By.xpath("(//span[text()='Subscriptions'])[4]")).click();
		Thread.sleep(3000);

		//choose subscription details 
		driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[2]/a[1]")).click();


		//AutoRenewal on
		Subscription_Details.turn_on_renewable(driver);
		Thread.sleep(3000);
	}


	@Then("Victor generates invoice")
	public void victor_generates_invoice() throws Exception {

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

			//verification of Success
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


	@Then("Victor verifies the invoice")
	public void victor_verifies_the_invoice() throws Exception {

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


	@Then("Victor adds receipt")
	public void victor_adds_receipt() throws Exception {
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
		///Open Receipt and cature details 
		//////      ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//      driver.switchTo().window(tabs.get(1));
	}


	@Then("Victor again verifies the invoice")
	public void victor_again_verifies_the_invoice() throws Exception {
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



	
	

	//Creating Addon (Excel Sheet = "Hosting_paypal" )

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
		driver = Choosing_hosting_custom_plan.select_hosting_plan_admin_panel(driver, "monthly");

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
		
		driver.close();
		
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
		
		///Open Receipt and cature details 
				//////      ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//		      driver.switchTo().window(tabs.get(1));
		

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

	
	
	
	
	


	//3rd Module Settings (Excel Sheet = "Hosting_3rdModule_admin")

	@Given("Jasper login into Q11 Website")
	public void jasper_login_into_q11_website() throws Exception {
		
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


	@Then("Jasper Choose Linux Hosting Gold Offer plan")
	public void jasper_choose_linux_hosting_gold_offer_plan() throws Exception {
		
		//Opening monthly Plan link
		driver = ThirdModule_settings.change_to_third_module(driver, "monthly");
	}


	@When("Jasper open Monthly plan add it to cart")
	public void jasper_open_monthly_plan_add_it_to_cart() throws Exception {
	
		//Domain
				Adding_domain.entering_the_domin_from_admin_panel(driver);

				Order_summary_page.capture_data_from_order_summary_page(driver,"Hosting_3rdModule_admin");

				//Add to cart button
				driver.findElement(By.id("submit")).click();
				Thread.sleep(5000);


				driver.findElement(By.id("next_without_login")).click();


				//create an Account
				driver.findElement(By.id("sign-up-sec")).click();
				Thread.sleep(3000);

	
	
	}


	@When("Jasper creates new account")
	public void jasper_creates_new_account() throws Exception {

//		Calling Method for CREATIION OF NEW CUSTOMER ACCOUNT
		New_account1.creating_new_account_from_admin_panel(driver, "Hosting_3rdModule_admin",3,10);

		///After Account Creation
		System.out.println("After account creation");
		Thread.sleep(7000);


		After_account_creation.capture_data_after_account_creation_from_admin_panel(driver, "Hosting_3rdModule_admin");

	}


	@Then("Jasper pay it by paypal payment")
	public void jasper_pay_it_by_paypal_payment() throws Exception {
		

		Payments.payment_with_paypal(driver, "Hosting_3rdModule_admin");
		
		driver.close();

		driver = Switch_tab.switch_previous_tab2(driver);
	}


	@And("Casper view Billing")
	public void casper_view_billing() throws Exception {
		
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

		Order_Details_Page.capture_data_of_order_details_page_before_approval(driver, "Hosting_3rdModule_admin");
		
		
	}
	
	
	@Then("Casper Approve for product")
	public void casper_approve_for_product() throws Exception {
		
		Order_Details_Page.approve_order(driver);

		Order_Details_Page.capture_data_of_order_details_page_after_approval(driver, "Hosting_3rdModule_admin");

		
	}

	
	@And("Casper clicks on invoice")
	public void casper_clicks_on_invoice() throws Exception {
		
		Order_Details_Page.go_to_invoice(driver);
		Thread.sleep(3000);
	
	}


	@Then("Casper verifies the invoice")
	public void casper_verifies_the_invoice() throws Exception {
		Switch_tab.switch_next_tab(driver);

		Invoice1.capture_invoice_ordered_with_bank(driver, "Hosting_3rdModule_admin");

		Thread.sleep(7000);

		driver.quit();
		
	}


	
	

	//Order for SubContact (Excel_sheet = "Hosting_Subcontact")

	@Given("Louis login into Q11 Website")
	public void louis_login_into_q11_website() throws Exception {

		driver = Open_Q11_portal.open_Q11_Website();
		Reload_WebPage.reload_reload(driver);


	}


	@Then("Louis register his account")
	public void louis_register_his_account() throws Exception {

		//Customer,ie.Louis creating account 
		Adding_customer.add_customer_in_admin_panel(driver, "Hosting_Subcontact");


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


	@And("Louis creates SubContact")
	public void louis_creates_sub_contact() throws Exception {

		//SubContact 
		driver.findElement(By.xpath("(//a[contains(@class,'btn btn-icon-brand')])[4]")).click();
		Thread.sleep(5000);

		Subcontact.create_sub_contact(driver, "Hosting_Subcontact");		

	}


	@Then("Louis Choose Linux Hosting Gold Offer plan")
	public void louis_choose_linux_hosting_gold_offer_plan() throws Exception {
		try
		{

			//Settings DropDown
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#kt_header_menu>ul>li:nth-of-type(8)>a>span")));

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

	
	@When("Louis open Monthly plan add it to cart")
	public void louis_open_monthly_plan_add_it_to_cart() throws Exception {


		//Opening monthly Plan link
		driver = Choosing_hosting_custom_plan.select_hosting_plan_admin_panel(driver, "monthly");

		//Domain
		Adding_domain.entering_the_domin_from_admin_panel(driver);

		Order_summary_page.capture_data_from_order_summary_page(driver,"Hosting_Subcontact");

		//Add to cart button
		driver.findElement(By.id("submit")).click();
		Thread.sleep(5000);

		driver.findElement(By.id("next_without_login")).click();



	}

	
	@And("Louis login with the SubContact account")
	public void louis_login_with_the_sub_contact_account() throws Exception {

		//Location Of Excel Sheet
		String xlpath = System.getProperty("user.dir") + "/src/main/resources/Q11-Hosting.xlsx";

		///Opening Excel Sheet
		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet("Hosting_Subcontact");


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


	@Then("Louis pay it by paypal")
	public void louis_pay_it_by_paypal() throws Exception {
		
		After_account_creation.capture_data_after_account_creation_from_admin_panel(driver, "Hosting_Subcontact");
		
		Payments.payment_with_paypal(driver, "Hosting_Subcontact");	

		driver = Switch_tab.switch_previous_tab2(driver);
		
		driver.close();
	}


	@And("Brian view Billing")
	public void brian_view_billing() throws Exception {
		
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

		Order_Details_Page.capture_data_of_order_details_page_before_approval(driver, "Hosting_Subcontact");
		Thread.sleep(5000);

	}

	
	@Then("Brian verifies the invoice")
	public void brian_verifies_the_invoice() throws Exception {

		Order_Details_Page.go_to_invoice(driver);
		Thread.sleep(3000);

		Switch_tab.switch_next_tab(driver);
		
		Thread.sleep(5000);

		Invoice1.capture_invoice_ordered_with_paypal(driver, "Hosting_Subcontact");

		Thread.sleep(7000);
		//Closes both Tabs 
		driver.quit();
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
