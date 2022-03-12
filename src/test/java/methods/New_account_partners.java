package methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class New_account_partners extends BaseClass {
	
	
	
	

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
	
	///This Method is for Creating New Accounts For Customers Partners  
	
	
public static void creating_new_account_for_partner(WebDriver driver, String sheetname) throws Exception{
		

		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(sheetname);
	    
		
		
		String generateStringInAlphanumeric = RandomStringUtils.randomAlphanumeric(5);

		String generateStringInNumber = RandomStringUtils.randomNumeric(4);

		//	String generateStringInASCII =RandomStringUtils.randomAscii(7);

		//	String genetrateStringInNumberForPincode = RandomStringUtils.randomNumeric(6);

		//	String genetrateStringInNumberForPhone = RandomStringUtils.randomNumeric(10);


		//WebElement username = 

		driver.findElement(By.id("regi_username")).sendKeys("Prometheus");
		//
		//	String usrnme="Prometheus";
		//
		//	//username.sendKeys(usrnme);
		//	System.out.println(usrnme);


		Thread.sleep(2000);

		driver.findElement(By.id("regi_email")).sendKeys("Prometheus" + "@gmail.com");
		Thread.sleep(2000);



		///If UserName is Failed 

		if(driver.findElement(By.xpath("//span[contains(@id,'check_username')]")).isDisplayed())
		{


			WebElement userid = driver.findElement(By.id("regi_username"));
			String usrnme2= "Prometheus"+ generateStringInNumber;

			userid.sendKeys(usrnme2);
			System.out.println("Your userid " + usrnme2);
			
			//sheet.getRow(3).createCell(10).setCellValue(usrnme2);
			System.out.println(usrnme2);
			

		}	


		Thread.sleep(3000);


		driver.findElement(By.id("password")).sendKeys(generateStringInAlphanumeric + generateStringInNumber);
		Thread.sleep(2000);

		WebElement passwrd = driver.findElement(By.id("con_password"));

		String pass = generateStringInAlphanumeric + generateStringInNumber ;
		passwrd.sendKeys(pass);
		System.out.println("Your Password is :" + pass);
		
		//sheet.getRow(4).createCell(10).setCellValue(pass);
		
		Thread.sleep(2000);


		String first_name = "James";
		WebElement first_name_locator = driver.findElement(By.name("firstname"));
		first_name_locator.sendKeys(first_name);
		//sheet.getRow(5).createCell(10).setCellValue(first_name);
		Thread.sleep(2000);


		String last_name= "Potter";
		WebElement last_name_locator=driver.findElement(By.name("lastname"));
		last_name_locator.sendKeys(last_name);
		//sheet.getRow(6).createCell(10).setCellValue(last_name);
		Thread.sleep(2000);

		
		
		
		driver.findElement(By.name("companyname")).sendKeys("Znet");
		Thread.sleep(2000);

		driver.findElement(By.name("address1")).sendKeys("Gravity Falls");	
		Thread.sleep(2000);


		//Select country By value
		WebElement country=driver.findElement(By.name("countryid"));

		Select DropDownCountry= new Select(country);


		DropDownCountry.selectByVisibleText("India");

		Thread.sleep(4000);


		//Select State By value
		WebElement state = driver.findElement(By.id("state"));

		Select DropDownState= new Select(state);

		DropDownState.selectByVisibleText("Maharashtra");

		Thread.sleep(2000);

		

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


		driver.findElement(By.name("city")).sendKeys("Pune");
		Thread.sleep(2000);

		driver.findElement(By.name("contact_no")).sendKeys("8210728014");
		Thread.sleep(2000);


		driver.findElement(By.name("pincode")).sendKeys("411027");
		Thread.sleep(2000);

		driver.findElement(By.id("security_answer2")).sendKeys("India");
		Thread.sleep(2000);

		driver.findElement(By.id("security_answer1")).sendKeys("Himalaya");
		Thread.sleep(2000);


		driver.findElement(By.name("mail_product_update")).click();
		Thread.sleep(2000);

		driver.findElement(By.name("mail_promotion")).click();
		Thread.sleep(2000);

		
		//This Element is not present in partner account creation 
//		driver.findElement(By.id("terms")).click();
//		Thread.sleep(2000);
		
		
		

		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
		
		driver.findElement(By.name("submit")).click();
		
		
		
}

}
