package methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.ReadConfig;

public class New_account1 extends BaseClass {
	
	private static String username = readconfig.get_username();
	private static String email = readconfig.get_email();
	private static String first_name = readconfig.getFirst_name();
	private static String last_name = readconfig.getLast_name();
	private static String company_name = readconfig.getCompany_name();
	private static String address1 = readconfig.getAddress1();
	private static String country_name = readconfig.getCountry_name();
	private static String state_name = readconfig.getState_name();
	private static String city_name = readconfig.getCity_name();
	private static String phoneNumber = readconfig.getPhone_number();
	private static String pincode = readconfig.getPincode_number();
	private static String where_do_you_live = readconfig.getWhere_do_you_live();
	private static String favourite_place = readconfig.getFavourite_place();
	

	
	
	
	
	///This Method is for Creating New Accounts For Customers
	
	
	public static void creating_new_account_from_admin_panel(WebDriver driver, String sheetname, int set_row,int set_cell) throws Exception{
		

		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(sheetname);
		
		int row = set_row;
	    int cell = set_cell;

		driver.findElement(By.id("regi_username")).sendKeys(username);

		Thread.sleep(2000);

		driver.findElement(By.id("regi_email")).sendKeys(email);
		Thread.sleep(2000);
		


		///If UserName is Failed 

		if(driver.findElement(By.xpath("//span[contains(@id,'check_username')]")).isDisplayed())
		{


			WebElement userid = driver.findElement(By.id("regi_username"));
			String username2=(username + randomnumber(5)).trim();

			userid.sendKeys(username2);
			System.out.println("Your userid " + username2);
			
			sheet.getRow(row).getCell(set_cell).setCellValue(username2);//1
			System.out.println(username2);
			

		}	


		Thread.sleep(3000);

		
		//password
		String pass= (randomAlphanumeric(5) + randomnumber(3)).trim();
		driver.findElement(By.id("password")).sendKeys(pass);
		Thread.sleep(2000);

		driver.findElement(By.id("con_password")).sendKeys(pass);
		System.out.println("Your Password is :" + pass);
		
		
		sheet.getRow(row+1).createCell(set_cell).setCellValue(pass);//2
		Thread.sleep(2000);


		WebElement first_name_locator = driver.findElement(By.name("firstname"));
		first_name_locator.sendKeys(first_name);
		sheet.getRow(row+2).createCell(set_cell).setCellValue(first_name);//3
		Thread.sleep(2000);

		WebElement last_name_locator=driver.findElement(By.name("lastname"));
		last_name_locator.sendKeys(last_name);
		sheet.getRow(row+3).createCell(set_cell).setCellValue(last_name);//4
		Thread.sleep(2000);

		
		driver.findElement(By.name("companyname")).sendKeys(company_name);
		sheet.getRow(row+4).createCell(set_cell).setCellValue(company_name);//5
		Thread.sleep(2000);
		

		driver.findElement(By.name("address1")).sendKeys(address1);
		sheet.getRow(row+5).createCell(set_cell).setCellValue(address1);//6
		Thread.sleep(2000);


		//Select country By value
		WebElement country=driver.findElement(By.name("countryid"));

		Select DropDownCountry= new Select(country);


		DropDownCountry.selectByVisibleText(country_name);
		sheet.getRow(row+6).createCell(set_cell).setCellValue(country_name);//7

		Thread.sleep(4000);

		try {
			
			logger.info("Try block");
		//Select State By value
		WebElement state = driver.findElement(By.id("state"));

		Select DropDownState= new Select(state);

		DropDownState.selectByVisibleText(state_name);
		sheet.getRow(row+7).createCell(set_cell).setCellValue(state_name);//8

		Thread.sleep(2000);

		}
		catch (Exception x)
		{
			logger.info("Catch block");
			//Select country By value
			WebElement country1=driver.findElement(By.name("countryid"));

			Select DropDownCountry_alien= new Select(country1);
			DropDownCountry_alien.selectByVisibleText("Iceland");
			Thread.sleep(5000);
			DropDownCountry_alien.selectByVisibleText(country_name);
			Thread.sleep(5000);
			
			WebElement state = driver.findElement(By.id("state"));

			Select DropDownState= new Select(state);

			DropDownState.selectByVisibleText(state_name);
			sheet.getRow(row+7).createCell(set_cell).setCellValue(state_name);//8
	
			
		}
		//Select Currency By Index
		WebElement currency = driver.findElement(By.name("currency"));

		Select DropDownCurrency= new Select(currency);
		sheet.getRow(row+8).createCell(set_cell).setCellValue("$");//9

		DropDownCurrency.selectByIndex(2);
		Thread.sleep(2000);


		driver.findElement(By.name("city")).sendKeys(city_name);
		sheet.getRow(row+9).createCell(set_cell).setCellValue(city_name);//10
		Thread.sleep(2000);

		driver.findElement(By.name("contact_no")).sendKeys(phoneNumber);
		sheet.getRow(row+10).createCell(set_cell).setCellValue(phoneNumber);//11
		Thread.sleep(2000);


		driver.findElement(By.name("pincode")).sendKeys(pincode);
		//sheet.getRow(row+11).getCell(set_cell).setCellValue(pincode);//12
		Thread.sleep(2000);

		driver.findElement(By.id("security_answer2")).sendKeys(where_do_you_live);
		//sheet.getRow(row+12).getCell(set_cell).setCellValue(where_do_you_live);//13
		Thread.sleep(2000);

		driver.findElement(By.id("security_answer1")).sendKeys(favourite_place);
		//sheet.getRow(row+13).getCell(set_cell).setCellValue(favourite_place);//14
		Thread.sleep(2000);


		driver.findElement(By.name("mail_product_update")).click();
		Thread.sleep(2000);

		driver.findElement(By.name("mail_promotion")).click();
		Thread.sleep(2000);

		
		///terms and condition checkbox
		List <WebElement> terms = driver.findElements(By.id("terms"));
		if(terms.size() != 0)
		{
			System.out.println("Element present");
			driver.findElement(By.id("terms")).click();
		}
		else
		{
			System.out.println("Element not present");
		}
		
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("submit")).click();
		
		
		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
	
		
	}

	
	public static void creating_new_account_from_partner_panel(WebDriver driver, String sheetname, int set_row,int set_cell) throws Exception{
		

		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(sheetname);
		
		int row = set_row;
	    int cell = set_cell;

		driver.findElement(By.id("regi_username")).sendKeys(username);

		Thread.sleep(2000);

		driver.findElement(By.id("regi_email")).sendKeys(email);
		Thread.sleep(2000);
		


		///If UserName is Failed 

		if(driver.findElement(By.xpath("//span[contains(@id,'check_username')]")).isDisplayed())
		{


			WebElement userid = driver.findElement(By.id("regi_username"));
			String username2=(username + randomnumber(5)).trim();

			userid.sendKeys(username2);
			System.out.println("Your userid " + username2);
			
			sheet.getRow(row).getCell(set_cell).setCellValue(username2);//1
			System.out.println(username2);
			

		}	


		Thread.sleep(3000);

		
		//password
		String pass= (randomAlphanumeric(5) + randomnumber(3)).trim();
		driver.findElement(By.id("password")).sendKeys(pass);
		Thread.sleep(2000);

		driver.findElement(By.id("con_password")).sendKeys(pass);
		System.out.println("Your Password is :" + pass);
		
		
		sheet.getRow(row+1).createCell(set_cell).setCellValue(pass);//2
		Thread.sleep(2000);


		WebElement first_name_locator = driver.findElement(By.name("firstname"));
		first_name_locator.sendKeys(first_name);
		sheet.getRow(row+2).createCell(set_cell).setCellValue(first_name);//3
		Thread.sleep(2000);

		WebElement last_name_locator=driver.findElement(By.name("lastname"));
		last_name_locator.sendKeys(last_name);
		sheet.getRow(row+3).createCell(set_cell).setCellValue(last_name);//4
		Thread.sleep(2000);

		
		driver.findElement(By.name("companyname")).sendKeys(company_name);
		sheet.getRow(row+4).createCell(set_cell).setCellValue(company_name);//5
		Thread.sleep(2000);
		

		driver.findElement(By.name("address1")).sendKeys(address1);
		sheet.getRow(row+5).createCell(set_cell).setCellValue(address1);//6
		Thread.sleep(2000);


		//Select country By value
		WebElement country=driver.findElement(By.name("countryid"));

		Select DropDownCountry= new Select(country);


		DropDownCountry.selectByVisibleText(country_name);
		sheet.getRow(row+6).createCell(set_cell).setCellValue(country_name);//7

		Thread.sleep(4000);

		try {
			
			logger.info("Try block");
		//Select State By value
		WebElement state = driver.findElement(By.id("state"));

		Select DropDownState= new Select(state);

		DropDownState.selectByVisibleText(state_name);
		sheet.getRow(row+7).createCell(set_cell).setCellValue(state_name);//8

		Thread.sleep(2000);

		}
		catch (Exception x)
		{
			logger.info("Catch block");
			//Select country By value
			WebElement country1=driver.findElement(By.name("countryid"));

			Select DropDownCountry_alien= new Select(country1);
			DropDownCountry_alien.deselectAll();
			DropDownCountry_alien.selectByVisibleText("Iceland");
			Thread.sleep(5000);
			DropDownCountry_alien.selectByVisibleText(country_name);
			Thread.sleep(5000);
			
			WebElement state = driver.findElement(By.id("state"));

			Select DropDownState= new Select(state);

			DropDownState.deselectAll();
			DropDownState.selectByIndex(4);
			sheet.getRow(row+7).createCell(set_cell).setCellValue(state_name);//8
	
			
		}
		
		
		
		try {
			logger.info("Leeme Try...............");
		//Select Currency By Index
		WebElement currency = driver.findElement(By.name("currency"));

		Select DropDownCurrency= new Select(currency);
		DropDownCurrency.selectByIndex(1);
		Thread.sleep(3000);
		
		}
		catch(Exception x)
		{
			logger.info("Catch block........help me!!!!!!!!!!!!!!");
			//Select Currency By Index
			WebElement currency = driver.findElement(By.name("currency"));

			Select DropDownCurrency= new Select(currency);
			DropDownCurrency.selectByVisibleText("$");
			
		}


		driver.findElement(By.name("city")).sendKeys(city_name);
		sheet.getRow(row+9).createCell(set_cell).setCellValue(city_name);//10
		Thread.sleep(2000);

		driver.findElement(By.name("contact_no")).sendKeys(phoneNumber);
		sheet.getRow(row+10).createCell(set_cell).setCellValue(phoneNumber);//11
		Thread.sleep(2000);


		driver.findElement(By.name("pincode")).sendKeys(pincode);
		//sheet.getRow(row+11).getCell(set_cell).setCellValue(pincode);//12
		Thread.sleep(2000);

		driver.findElement(By.id("security_answer2")).sendKeys(where_do_you_live);
		//sheet.getRow(row+12).getCell(set_cell).setCellValue(where_do_you_live);//13
		Thread.sleep(2000);

		driver.findElement(By.id("security_answer1")).sendKeys(favourite_place);
		//sheet.getRow(row+13).getCell(set_cell).setCellValue(favourite_place);//14
		Thread.sleep(2000);


		driver.findElement(By.name("mail_product_update")).click();
		Thread.sleep(2000);

		driver.findElement(By.name("mail_promotion")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.name("submit")).click();
		Thread.sleep(5000);
		
		driver.navigate().back();
		Thread.sleep(5000);
		
		
		
		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
	
		
	}
}
