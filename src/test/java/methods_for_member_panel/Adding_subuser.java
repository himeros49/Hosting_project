package methods_for_member_panel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import methods.BaseClass;

public class Adding_subuser extends BaseClass{
	
	
	
	private static String username = readconfig.get_suusername();
	private static String first_name = readconfig.get_suFirst_name();
	private static String last_name = readconfig.get_suLast_name();
	private static String email = readconfig.get_suemail();
	private static String company_name = readconfig.get_suCompany_name();
	private static String address1 = readconfig.get_suAddress1();
	private static String country_name = readconfig.get_suCountry_name();
	private static String state_name = readconfig.get_suState_name();
	private static String city_name = readconfig.get_suCity_name();
	private static String mobileNumber = readconfig.get_suMobile_number();
	private static String phoneNumber = readconfig.get_suPhone_number();
	private static String pincode = readconfig.get_suPincode_number();
	
	
	
	
	public static void adding_subuser(WebDriver driver, String sheetname) throws Exception {
					
			

			File source = new File(xlpath);
			FileInputStream fi = new FileInputStream(source);
			XSSFWorkbook wb = new XSSFWorkbook(fi);
			XSSFSheet sheet = wb.getSheet(sheetname);


			int initial_row = 16;
			int initial_cell = 19;

			String generateStringInAlphanumeric = RandomStringUtils.randomAlphanumeric(6);
			String generateStringInNumber = RandomStringUtils.randomNumeric(5);


			//Adding Personal Details

			//Adding Username
			WebElement username_element= driver.findElement(By.id("c_username"));
			String Username = (username + generateStringInNumber).trim();
			sheet.getRow(initial_row).createCell(initial_cell).setCellValue(Username);
			username_element.sendKeys(Username);
			Thread.sleep(3000);

			//Adding Firstname
			WebElement first_name_element = driver.findElement(By.id("c_firstname"));
			first_name_element.sendKeys(first_name);
			sheet.getRow(initial_row+2).createCell(initial_cell).setCellValue(first_name);
			Thread.sleep(3000);

			//Adding Lastname
			WebElement last_name_element = driver.findElement(By.id("c_lastname"));
			last_name_element.sendKeys(last_name);
			sheet.getRow(initial_row+3).createCell(initial_cell).setCellValue(last_name);
			Thread.sleep(3000);

			//Adding Email
			WebElement email_element = driver.findElement(By.id("c_email"));
			sheet.getRow(initial_row+4).createCell(initial_cell).setCellValue(email);
			email_element.sendKeys(email);
			Thread.sleep(3000);


			//Adding Password
			WebElement password_element = driver.findElement(By.id("c_password"));
			String psswrd= (generateStringInAlphanumeric+generateStringInNumber).trim();
			sheet.getRow(initial_row+1).createCell(initial_cell).setCellValue(psswrd);
			password_element.sendKeys(psswrd);
			Thread.sleep(3000);

			//Adding Company Details
			WebElement company_name_element = driver.findElement(By.id("c_companyname"));
			company_name_element.sendKeys(company_name);
			sheet.getRow(initial_row+5).createCell(initial_cell).setCellValue(company_name);
			Thread.sleep(3000);

			//Adding Address		  
			WebElement Address1_element = driver.findElement(By.id("c_address1"));
			Address1_element.sendKeys(address1);
			sheet.getRow(initial_row+6).createCell(initial_cell).setCellValue(address1);
			Thread.sleep(3000);
			
			
			//Adding city
			WebElement city_element = driver.findElement(By.id("client_contacts_city"));
			city_element.sendKeys(city_name);
			Thread.sleep(3000);
			

			//Adding Country
			try{
				WebElement country_element = driver.findElement(By.id("c_countryid"));
				Select DropDownCountry= new Select(country_element);
				DropDownCountry.selectByVisibleText(country_name);
				sheet.getRow(initial_row+7).createCell(initial_cell).setCellValue(country_name);
				Thread.sleep(10000);
			}
			catch(Exception x)
			{
				WebElement country_element = driver.findElement(By.cssSelector("select#c_countryid"));
				country_element.click();
				driver.findElement(By.xpath("(//input[@class='form-control multiselect-search'])[2]")).sendKeys("India");
				driver.findElement(By.xpath("//input[@value='99']")).click();
				
			}


			//Adding State/Region
			WebElement region_element = driver.findElement(By.id("statestate"));
			Select DropDown_region_element= new Select(region_element);
			DropDown_region_element.selectByVisibleText(state_name);
			sheet.getRow(initial_row+8).createCell(initial_cell).setCellValue(state_name);
			Thread.sleep(10000);
			


			//Adding Zipcode
			WebElement pin_code_element = driver.findElement(By.id("client_contacts_pincode"));
			pin_code_element.sendKeys(pincode);
			sheet.getRow(initial_row+9).createCell(initial_cell).setCellValue(pincode);
			Thread.sleep(3000);

			//Adding Mobile Number
			WebElement mobile_number_element = driver.findElement(By.id("client_contacts_mobile"));
			mobile_number_element.sendKeys(mobileNumber);
			sheet.getRow(initial_row+10).createCell(initial_cell).setCellValue(mobileNumber);
			Thread.sleep(3000);

			//Adding Phone Number
			WebElement phone_number_element = driver.findElement(By.id("client_contacts_phone"));
			phone_number_element.sendKeys(phoneNumber);
			sheet.getRow(initial_row+11).createCell(initial_cell).setCellValue(phoneNumber);
			Thread.sleep(3000);
			
			//Adding Sub_Account
			driver.findElement(By.xpath("//input[@name='subaccount']/following-sibling::span[1]")).click();
			Thread.sleep(5000);
			
			
			//Allowing Permissions
			try {
				WebElement allow_permission = driver.findElement(By.xpath("(//input[@type='checkbox']/following-sibling::span)[2]"));
				Thread.sleep(3000);

				JavascriptExecutor js = (JavascriptExecutor) driver;

				js.executeScript("arguments[0].scrollIntoView()", allow_permission); 

				js.executeScript("arguments[0].click();", allow_permission);
			}
			catch(Exception x)
			{
				WebElement allow_permission = driver.findElement(By.xpath("(//table[contains(@class,'table table-bordered')]//table)[6]/tbody[1]/tr[1]/th[1]/label[1]/span[1]"));
				
				JavascriptExecutor js = (JavascriptExecutor) driver;

				js.executeScript("arguments[0].scrollIntoView()", allow_permission); 

				js.executeScript("arguments[0].click();", allow_permission);
				
				
				Thread.sleep(3000);
			}
			
			//Save button
			driver.findElement(By.id("add_sub_user")).click();
			Thread.sleep(5000);
			
			//OK button
			
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Ok']")));
			WebElement okay = driver.findElement(By.xpath("//button[text()='Ok']"));
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			js.executeScript("arguments[0].click();", okay);


			FileOutputStream fos = new FileOutputStream(source);
			wb.write(fos);
			wb.close();
			fi.close();
			fos.close();

			
			try
			{
			WebDriverWait wait2 = new WebDriverWait(driver, 60);
			wait2.until(ExpectedConditions.presenceOfElementLocated(By.className("m-accordion__item-title")));
			}
			catch(Exception x) 
			{
				WebDriverWait wait2 = new WebDriverWait(driver, 60);
				wait2.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#m_accordion_1>div>div>span:nth-of-type(2)")));
			}			
		
	}

	
	
}
