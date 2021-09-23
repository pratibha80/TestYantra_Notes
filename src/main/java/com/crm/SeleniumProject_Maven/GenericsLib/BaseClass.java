package com.crm.SeleniumProject_Maven.GenericsLib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.SeliumProject_Maven.Organization.HomePage;
import com.crm.SeliumProject_Maven.Organization.LoginPage;
import com.crm.genericUnit.JSONFileUtilty;

/**
 * 
 * @author Pratibha
 *
 */

public class BaseClass {
	

	public DataBaseUtility dbLib=new DataBaseUtility();
	public JSONFileUtilty jsonLib=new JSONFileUtilty();
	public WebDriverUtility wLib=new WebDriverUtility();
	public ExcelFileUtility eLib=new ExcelFileUtility();
	public JavaUtility jLib=new JavaUtility();
	
	public   WebDriver driver;
	public static WebDriver staticdriver;
	
	
	@BeforeSuite(groups={"SmokeSuite","RegressionSuite"})
	public void CoonectDB()
	{
		//dLib.connectToDB();
		System.out.println("===MakeDBConnection====");
	}
	
	//@Parameters("Browser")
	@BeforeClass(groups={"SmokeSuite","RegressionSuite"})
	public void launchBrowser() throws Throwable
	{
		System.out.println("==launchBrowser===");
		String BROWSER = jsonLib.readDataFromJSON("browser");
		String URL = jsonLib.readDataFromJSON("url");
		
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
			System.out.println("invalid browser");
		}
		
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		staticdriver=driver;
	}
	
	@BeforeMethod(groups={"SmokeSuite","RegressionSuite"})
	public void loginToApp() throws Throwable
	{
		System.out.println("==loginToApp===");
		
		String USERNAME = jsonLib.readDataFromJSON("username");
		String PASSWORD = jsonLib.readDataFromJSON("password");
		  
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
	}
	
	
	@AfterMethod(groups={"SmokeSuite","RegressionSuite"})
	public void logoutApp()
	
	{
		System.out.println("==logoutApp====");
		HomePage hp=new HomePage(driver);
		hp.signout(driver);
	}

	@AfterClass(groups={"SmokeSuite","RegressionSuite"})
	public void closeBrowser()
	{
		System.out.println("===========close the browser========");
		driver.close();
	}
	
	@AfterSuite(groups={"SmokeSuite","RegressionSuite"})
	public void closeDB() throws Throwable
	{
		//dbLib.closeDB();
		System.out.println("========close the db===========");
	}
	
	public String getscreenshot(String name) throws IOException
	{
		File srcfile=((TakesScreenshot) staticdriver).getScreenshotAs(OutputType.FILE);
		String destfile=System.getProperty("user.dir")+"/Screenshots/"+name+".png";
		File finaldest=new File(destfile);
		FileUtils.copyFile(srcfile, finaldest);
		
		return destfile;
	}
} 