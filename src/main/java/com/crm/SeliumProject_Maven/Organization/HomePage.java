package com.crm.SeliumProject_Maven.Organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.SeleniumProject_Maven.GenericsLib.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement organizationlnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorlnk;
	
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutlnk;


	public WebElement getOrganizationlnk() {
		return organizationlnk;
	}


	public WebElement getAdministratorlnk() {
		return administratorlnk;
	}


	public WebElement getSignoutlnk() {
		return signoutlnk;
	}
	
	
	public void clickOnOrganization()
	{
		organizationlnk.click();
	}
	
	public void signout(WebDriver driver)
	{
		
		mouseOver(driver, administratorlnk);
		signoutlnk.click();
	}
	

}
