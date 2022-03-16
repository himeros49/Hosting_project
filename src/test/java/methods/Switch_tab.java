package methods;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Switch_tab extends BaseClass {
	
	
	
	public static WebDriver switch_next_tab(WebDriver driver)

	{
		
		String parentId = driver.getWindowHandle();
		System.out.println(parentId);


		Set<String> allWindowHandles = driver.getWindowHandles();

		System.out.println(allWindowHandles);

		int count =1 ;
		for(String window: allWindowHandles)
		{
			System.out.println(count + ":" + window);
			count++;
		}

		try {
			Thread.sleep(3000);

			for(String window : allWindowHandles)
			{
				if(!window.equalsIgnoreCase(parentId))
				{
					driver.switchTo().window(window);
					return driver;
				}
			}

		}
		catch(Exception x)
		{
			x.printStackTrace();
		}
		
		return driver;
	}
	
	
	public static WebDriver switch_back_the_tab(WebDriver driver)
	{
		
		String parentId = driver.getWindowHandle();
		System.out.println(parentId);


		Set<String> allWindowHandles = driver.getWindowHandles();

		System.out.println(allWindowHandles);

		int count =1 ;
		for(String window: allWindowHandles)
		{
			System.out.println(count + ":" + window);
			count++;
		}

		try {
			Thread.sleep(3000);

			for(String window : allWindowHandles)
			{
				driver.switchTo().window(parentId);
			}

		}
		catch(Exception x)
		{
			x.printStackTrace();
		}
//		
		driver.switchTo().window(parentId);
		return driver;
		
	}
	
	
	public static WebDriver switch_next_tab2 (WebDriver driver)

	{
		((JavascriptExecutor)driver).executeScript("window.open()");//opens new tab
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        return driver.switchTo().window(tabs.get(1));
		
	}
	
	public static WebDriver switch_previous_tab2 (WebDriver driver)

	{
		//((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        return driver.switchTo().window(tabs.get(0));
		
	}
	
	

}
