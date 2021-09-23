package com.crm.SeliumProject_Maven.Organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.SeleniumProject_Maven.GenericsLib.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility {
	
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	
	@FindBy(name="website")
	private WebElement websiteEdt;

	@FindBy(name="industry")
	private WebElement IndustryType;
	
	@FindBy(xpath="(//select[@class='small'])[4]")
	private WebElement TypedropDown;

	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}


	public WebElement getWebsiteEdt() {
		return websiteEdt;
	}
	
	public WebElement getIndustryType() {
		return IndustryType;
	}

	public WebElement getTypedropDown() {
		return TypedropDown;
	}


	public void createOrganization(String OrgName)
	{
		OrgNameEdt.sendKeys(OrgName);
	}
	public void createWebsite(String webName )
	{
		websiteEdt.sendKeys(webName);
	}
	
	public void dropDownIndustry()
	{
		
		IndustryType.click();
	}
	
	public void createOrganizationwithIndustry(String OrgName)
	{
		OrgNameEdt.sendKeys(OrgName);
	     
	}
	
	public void OrganizationWithIndustry(String IndType)
	{
		select(IndustryType, IndType);
	}
	
	public void dropDownOfType()
	{
		TypedropDown.click();
	}
	
	
	
	public void TypeOfOrganization(String Type) 
	{
		select(TypedropDown, Type);
	}
}
