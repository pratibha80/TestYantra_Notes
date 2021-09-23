package com.crm.SeleniumProject_Maven.GenericsLib;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 * @author Pratibha
 *
 */

public class WebDriverUtility {
	public WebDriver driver;
	
	/**
	 * 
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * 
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * 
	 */
	public void select (WebElement element,String value)
	{
		Select sel=new Select(element);
		
		sel.selectByVisibleText(value);
	}
	/**
	 * 
	 */
       public void select (WebElement element,int index)
       {
    	   Select sel=new Select(element);
    	   sel.selectByIndex(index);
       }
       
       /**
        * 
        */
       
       
       
       public void mouseOver(WebDriver driver,WebElement element)
       {
    	   Actions act=new Actions(driver);
    	   act.moveToElement(element).perform();
       }
       /**
        * 
        */
       public void rightClick(WebDriver driver,WebElement element)
       {
    	   Actions act=new Actions(driver);
    	   act.contextClick(element).perform();
       }
       /**
        * 
        */
       public void doubleClick(WebDriver driver,WebElement element)
       {
    	   Actions act=new Actions(driver);
    	   act.doubleClick(element).perform();
       }
       /**
        * 
        */
       public void acceptAlert(WebDriver driver)
       {
    	   driver.switchTo().alert().accept();
       }
       /**
        * 
        */
       public void dismissAlert(WebDriver driver)
       {
    	   driver.switchTo().alert().dismiss();
       }
       /**
        * 
        */
       
       public void swithToFrame(WebDriver driver,int index)
       {
    	   driver.switchTo().frame(index);
       }
       /**
        * 
        */
       public void swithToFrame(WebDriver driver,String frameid)
       {
    	   driver.switchTo().frame(frameid);
       }
       /**
        * 
        */
       public void swithToFrame(WebDriver driver,WebElement frameElement)
       {
    	   driver.switchTo().frame(frameElement);
       }
       /**
        * 
        */
       
       public void swithToWindow(WebDriver driver,String partialWinTitle)
       {
    	   Set<String> windowhandles = driver.getWindowHandles();
    	   Iterator<String> it = windowhandles.iterator();
    	   
    	   while(it.hasNext())
    	   {
    		   String winId = it.next();
    		   String actTitle = driver.switchTo().window(winId).getTitle();
    		   if(actTitle.contains(partialWinTitle))
    		   {
    			   driver.switchTo().window(actTitle);
    			   break;
    		   }
    	   }
       }
       
       
}
