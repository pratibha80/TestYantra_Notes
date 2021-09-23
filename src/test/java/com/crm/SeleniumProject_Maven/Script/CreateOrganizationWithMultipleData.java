package com.crm.SeleniumProject_Maven.Script;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.SeleniumProject_Maven.GenericsLib.BaseClass;
import com.crm.SeliumProject_Maven.Organization.CreateOrganizationPage;
import com.crm.SeliumProject_Maven.Organization.HomePage;
import com.crm.SeliumProject_Maven.Organization.OrganizationPage;

//@Listeners(com.crm.SeleniumProject_Maven.GenericsLib.ListenerS.class)
   public class CreateOrganizationWithMultipleData extends BaseClass {
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		return eLib.getExcelData("Sheet2");
	}
	
	@Test(dataProvider="getData",retryAnalyzer=com.crm.SeleniumProject_Maven.GenericsLib.RetryAnalyzer.class)
	public void createOrganizationWithMultipleData(String OrgName,String IndType)
	{
		//navigate to Organizations
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganization();
		
	
		//click on create Organization
		OrganizationPage Orgp=new OrganizationPage(driver);
		Orgp.clickOnOrganization();
		
		//create Org
		CreateOrganizationPage cp=new CreateOrganizationPage(driver);
		cp.createOrganizationwithIndustry(OrgName);
		cp.OrganizationWithIndustry(IndType);
		Assert.assertEquals(false, true);
	}

}
