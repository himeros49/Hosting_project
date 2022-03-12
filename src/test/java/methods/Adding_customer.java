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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ReadConfig;

public class Adding_customer extends BaseClass{
	
	
	static ReadConfig rd = new ReadConfig();
	
public static void add_customer(WebDriver driver, String name_of_the_sheet ) throws Exception {
		
		rd.getImplicitlyWait();
		///Opening Excel Sheet
		File source = new File(xlpath);
		FileInputStream fi = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(name_of_the_sheet);


			int initial_row = 3;
			int initial_cell = 10;
			
			//XSSFRow  row = sheet.getRow(initial_row);
					
			String generateStringInAlphanumeric = RandomStringUtils.randomAlphanumeric(6);
			String generateStringInNumber = RandomStringUtils.randomNumeric(4);
			
			
			///Accounts Button
			try {
				
				logger.info("I am in try block");
				driver.findElement(By.xpath("(//span[text()='Accounts'])[1]")).click();
			
			}
			
			catch(Exception x)
			{
				
				logger.info("I am in catch block");
				driver.findElement(By.xpath("(//span[@class='kt-menu__link-text'][contains(.,'Accounts')])[1]")).click();
				
			}
			
			
			Thread.sleep(3000);
			
			
			Actions ac = new Actions(driver);

			ac.moveToElement(driver.findElement(By.xpath("(//span[text()='Customers'])[1]")));
			ac.moveToElement(driver.findElement(By.xpath("(//span[text()='Add'])[1]"))).click().perform();
			Thread.sleep(5000);
			
			
			//Adding Personal Details
			 WebElement Bussiness_unit = driver.findElement(By.id("VentureSelect1"));
			
			Select DropDownBussinessUnit= new Select(Bussiness_unit);
			DropDownBussinessUnit.selectByIndex(1);
			Thread.sleep(5000);
				
			 
			 WebElement Username = driver.findElement(By.id("username"));
			 String username = (rd.getUsername2() + generateStringInNumber).trim();
			
			 sheet.getRow(initial_row).createCell(initial_cell).setCellValue(username);
			 Username.sendKeys(username);
			 		 
		
			 
			 WebElement email = driver.findElement(By.name("email"));
			 email.click();
			 Thread.sleep(5000);
			 String emailid = rd.getEmail2();
			 sheet.getRow(initial_row+4).createCell(initial_cell).setCellValue(emailid);
			 email.sendKeys(emailid);
			 Thread.sleep(3000);
		
			 
		/*	 WebElement email = driver.findElement(By.name("email"));
			 email.sendKeys(rd. getEmail2());
		*/
			 
			 WebElement first_name = driver.findElement(By.id("firstname"));
			 first_name.sendKeys(rd.getFirstName2());
			 sheet.getRow(initial_row+2).createCell(initial_cell).setCellValue(rd.getFirstName2());
			
			 Thread.sleep(3000);
			 WebElement last_name = driver.findElement(By.id("lastname"));
			 last_name.sendKeys(rd.getLastName2());
			 sheet.getRow(initial_row+3).createCell(initial_cell).setCellValue(rd.getLastName2());
			
			 Thread.sleep(3000);
			 WebElement password = driver.findElement(By.id("password"));
			// String psswrd= generateStringInAlphanumeric;
			 sheet.getRow(initial_row+1).createCell(initial_cell).setCellValue( rd.getPassword2());
			 password.sendKeys(rd.getPassword2());
			 
			 Thread.sleep(3000);
			 WebElement confirm_password = driver.findElement(By.id("confirm_password"));
			 confirm_password.sendKeys(rd.getConfirmPass2());
			
			 //Adding Company Details 
			 driver.findElement(By.partialLinkText("Company Details")).click();
			 WebElement company_name = driver.findElement(By.id("company_name"));
			 company_name.sendKeys(rd.getCompany2());
			
			 WebElement company_website = driver.findElement(By.name("website"));
			 company_website.sendKeys(rd.getWebsite2());
			 
			 //Adding Address
			 driver.findElement(By.partialLinkText("Address")).click();
			  
			 WebElement Address1 = driver.findElement(By.id("address1"));
			 Address1.sendKeys(rd.getAddress2());
			 Thread.sleep(3000);
			 
			 
			 WebElement Address2 = driver.findElement(By.id("address2"));
			 Address2.sendKeys(rd.getAddress2_());
			 Thread.sleep(7000);
			 
			 
			 WebElement country = driver.findElement(By.id("countryid"));
			 
			 Select DropDownCountry= new Select(country);
			 DropDownCountry.selectByVisibleText(rd.getCountry());
			 Thread.sleep(10000);
			 
			 
			 
			 WebElement region = driver.findElement(By.xpath("(//span[contains(.,'Select')])[4]"));
			 region.click();
			 Thread.sleep(5000);
			 
			 
			 driver.findElement(By.xpath("(//input[@placeholder='Search'])[3]")).sendKeys(rd.getRegion());
			 
			 driver.findElement(By.xpath("(//input[@type='radio'])[261]")).click();
			
				
			 
			WebElement city = driver.findElement(By.id("city"));
			city.sendKeys(rd.getCity2());
			Thread.sleep(2000);
			 
			 WebElement pin_code = driver.findElement(By.id("zipcode"));
			 pin_code.sendKeys(rd.getZipcode2());
			 Thread.sleep(3000);
			 
			
			 WebElement check_box = driver.findElement(By.xpath("(//label[contains(@class,'kt-checkbox kt-checkbox--tick')])[1]"));
			 check_box.click();
			 Thread.sleep(5000);
			 
			 
			 
			 //Contact Details
			 driver.findElement(By.partialLinkText("Contact Details")).click();
			 Thread.sleep(5000);
			 
			 
			 WebElement mobile_number = driver.findElement(By.id("mobilenumber"));
			 mobile_number.sendKeys(rd.getContact2());
			 Thread.sleep(2000);
			 
			// driver.findElement(By.xpath("(//button[contains(@class,'btn btn-success')])[2]")).click();
			// Thread.sleep(5000);
			// 
			 
			 driver.findElement(By.id("phonenumber")).click();
			 Thread.sleep(5000);
			 
			 //Billing Details
			 driver.findElement(By.partialLinkText("Billing Details")).click();
			 Thread.sleep(10000);
			 
			 WebElement currency = driver.findElement(By.id("currency"));
			
			 Select DropDownCurrency= new Select(currency);
			 DropDownCurrency.selectByIndex(1);
			 Thread.sleep(5000);
			 
			 
			 WebElement tax_exempt = driver.findElement(By.id("taxexempt"));
			 
			 Select DropDownTaxExempt = new Select(tax_exempt);
			 DropDownTaxExempt.selectByIndex(0);
			 Thread.sleep(5000);
			 
			 
			// 
			// driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
			// Thread.sleep(5000);
			 
			 
			 //Other Details
			 driver.findElement(By.partialLinkText("Other Details")).click();
			 Thread.sleep(5000);
			 
			 
			 WebElement status = driver.findElement(By.id("clientstatus"));
			 
			 Select DropDownStatus = new Select(status);
			 DropDownStatus.selectByIndex(1);
			 Thread.sleep(2000);
			 
			 
			 WebElement sms_notification = driver.findElement(By.id("recievesms"));
			 
			 Select DropDownSMSNotification = new Select(sms_notification);
			 DropDownSMSNotification.selectByIndex(0);
			 Thread.sleep(2000);
			 
			 WebElement Admin_note = driver.findElement(By.id("recievesms"));
			 Admin_note.sendKeys("done");
			 
			 
			driver.findElement(By.xpath("(//button[contains(@class,'btn btn-success')])[2]")).click();




			FileOutputStream fos = new FileOutputStream(source);
			wb.write(fos);
			wb.close();
			fi.close();
			fos.close();
					
					
				}

}
