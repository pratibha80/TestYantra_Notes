package com.crm.genericUnit;

	import java.util.List;
	   
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.testng.annotations.Test;

	import com.crm.genericUnit.JSONFileUtilty;

	public class DynamicSelect {
		
		
		WebDriver driver;
		@Test
		public void handlingDynamicWebTable() throws Throwable {
			JSONFileUtilty jsonLib = new JSONFileUtilty();
			String URL = jsonLib.readDataFromJSON("url");
			String USERNAME = jsonLib.readDataFromJSON("username");
			String PASSWORD = jsonLib.readDataFromJSON("password");
			String BROWSER = jsonLib.readDataFromJSON("browser");
			
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				driver=new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("firefox"))
			{
				driver=new FirefoxDriver();
				
			}
			else
			{
				driver=new InternetExplorerDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.get(URL);
			
			
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			driver.findElement(By.linkText("Organizations")).click();
			
			//List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td/input[@name='selected_id]"));
			 //List<WebElement> list = driver.findElements(By.id("4"));
			//List<WebElement> list = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr[@class='lvtColData']/td/input[@name='selected_id']"));
	       List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td/input[@name='selected_id']"));
	          for(int i=1;i<list.size();i++)
	         {
	        	  for(WebElement wb:list)
	        	  {
	        		  System.out.println(wb.getText());
	        	  }
	          }

	                list.get(list.size()-1).click();
	              //for(WebElement web:list) {
	            	//  web.click();
	              //}  
	                //int count=0;
	        		//for(WebElement web:list) {
	        			//System.out.println(web.getText());
	        		//}
	        		//driver.close();
	        		//System.out.println("Count " + list.size());
			
		}

	}



