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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Subcontact extends BaseClass {


	private static String username = readconfig.get_scusername();
	private static String first_name = readconfig.get_scFirst_name();
	private static String last_name = readconfig.get_scLast_name();
	private static String email = readconfig.get_scemail();
	private static String company_name = readconfig.get_scCompany_name();
	private static String address1 = readconfig.get_scAddress1();
	private static String country_name = readconfig.get_scCountry_name();
	private static String state_name = readconfig.get_scState_name();
	private static String city_name = readconfig.get_scCity_name();
	private static String mobileNumber = readconfig.get_scMobile_number();
	private static String phoneNumber = readconfig.get_scPhone_number();
	private static String pincode = readconfig.get_scPincode_number();


	public static void create_sub_contact(WebDriver driver, String sheetname) throws Exception {

		
		Switch_tab.switch_next_tab(driver);
		

		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(sheetname);


		int initial_row = 16;
		int initial_cell = 10;

		String generateStringInAlphanumeric = RandomStringUtils.randomAlphanumeric(6);
		String generateStringInNumber = RandomStringUtils.randomNumeric(5);


		//Adding Personal Details

		//Adding Username
		WebElement username_element= driver.findElement(By.id("username"));
		String Username = (username + generateStringInNumber).trim();
		sheet.getRow(initial_row).createCell(initial_cell).setCellValue(Username);
		username_element.sendKeys(Username);
		Thread.sleep(3000);

		//Adding Firstname
		WebElement first_name_element = driver.findElement(By.id("firstname"));
		first_name_element.sendKeys(first_name);
		sheet.getRow(initial_row+2).createCell(initial_cell).setCellValue(first_name);
		Thread.sleep(3000);

		//Adding Lastname
		WebElement last_name_element = driver.findElement(By.id("lastname"));
		last_name_element.sendKeys(last_name);
		sheet.getRow(initial_row+3).createCell(initial_cell).setCellValue(last_name);
		Thread.sleep(3000);

		//Adding Email
		WebElement email_element = driver.findElement(By.name("email"));
		sheet.getRow(initial_row+4).createCell(initial_cell).setCellValue(email);
		email_element.sendKeys(email);
		Thread.sleep(3000);


		//Adding Password
		WebElement password_element = driver.findElement(By.id("password"));
		String psswrd= generateStringInAlphanumeric;
		sheet.getRow(initial_row+1).createCell(initial_cell).setCellValue(psswrd);
		password_element.sendKeys(psswrd);
		Thread.sleep(3000);

		//Adding Company Details
		WebElement company_name_element = driver.findElement(By.id("companyname"));
		company_name_element.sendKeys(company_name);
		sheet.getRow(initial_row+5).createCell(initial_cell).setCellValue(company_name);
		Thread.sleep(3000);

		//Adding Status
		WebElement status_element = driver.findElement(By.id("subaccount"));
		Select status_element_dropdown = new Select(status_element);
		status_element_dropdown.selectByVisibleText("Active");
		Thread.sleep(3000);

		//Adding Address		  
		WebElement Address1_element = driver.findElement(By.id("address1"));
		Address1_element.sendKeys(address1);
		sheet.getRow(initial_row+6).createCell(initial_cell).setCellValue(address1);
		Thread.sleep(3000);

		//Adding Country
		try{
			WebElement country_element = driver.findElement(By.xpath("(//span[@class='multiselect-selected-text'])[2]"));
			Select DropDownCountry= new Select(country_element);
			DropDownCountry.selectByVisibleText(country_name);
			sheet.getRow(initial_row+7).createCell(initial_cell).setCellValue(country_name);
			Thread.sleep(10000);
		}
		catch(Exception x)
		{
			WebElement country_element = driver.findElement(By.xpath("(//span[@class='multiselect-selected-text'])[2]"));
			country_element.click();
			driver.findElement(By.xpath("(//input[@class='form-control multiselect-search'])[2]")).sendKeys("India");
			driver.findElement(By.xpath("//input[@value='99']")).click();
			
		}


		//Adding State/Region
		WebElement region_element = driver.findElement(By.xpath("//span[text()='Select State']"));
		region_element.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@placeholder='Search'])[3]")).sendKeys(state_name);
		driver.findElement(By.xpath("(//input[@type='radio'])[261]")).click();


		//Adding city
		WebElement city_element = driver.findElement(By.id("city"));
		city_element.sendKeys(city_name);
		Thread.sleep(3000);

		//Adding Zipcode
		WebElement pin_code_element = driver.findElement(By.id("zipcode"));
		pin_code_element.sendKeys(pincode);
		Thread.sleep(3000);

		//Adding Mobile Number
		WebElement mobile_number_element = driver.findElement(By.id("mobilenumber"));
		mobile_number_element.sendKeys(mobileNumber);
		Thread.sleep(3000);

		//Adding Phone Number
		WebElement phone_number_element = driver.findElement(By.id("phonenumber"));
		phone_number_element.sendKeys(phoneNumber);
		Thread.sleep(3000);
		
		//Email Notification
		driver.findElement(By.xpath("(//input[@name='email_notification[]']/following-sibling::span)[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@name='email_notification[]']/following-sibling::span)[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@name='email_notification[]']/following-sibling::span)[3]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@name='email_notification[]']/following-sibling::span)[4]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@name='email_notification[]']/following-sibling::span)[5]")).click();
		Thread.sleep(3000);
	
		
		//Allowing Permissions
		driver.findElement(By.cssSelector("form#add_edit_form>div:nth-of-type(2)>div:nth-of-type(7)>div>div>label>span")).click();
		Thread.sleep(3000);
		
		
		//Save button
		driver.findElement(By.id("save_update_button")).click();


		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		wb.close();
		fi.close();
		fos.close();

		
		try
		{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='alert-text'])[3]")));
		}
		catch(Exception x) 
		{
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#alert-msg-flash-success>div:nth-of-type(2)")));
		}

		
		driver.close();
		
		driver = Switch_tab.switch_previous_tab2(driver);	
		
		
	}

}
