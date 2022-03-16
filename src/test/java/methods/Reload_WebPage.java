package methods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Reload_WebPage {


	public static void reload_reload(WebDriver driver)
	{
		List <WebElement> reload_element = driver.findElements(By.id("reload-button"));
		
		while(reload_element.size() != 0)
		{
			System.out.println("Website crashed");
			for (WebElement reload : reload_element) {
				reload.click();
				break;
			}
		
		}
	
	}

	
	

	
	
	
	
	
	
	
	
	
	
}
