package com.crm.SeleniumProject_Maven.Script;



import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.SeleniumProject_Maven.GenericsLib.BaseClass;
import com.crm.SeliumProject_Maven.Organization.CreateOrganizationPage;
import com.crm.SeliumProject_Maven.Organization.HomePage;
import com.crm.SeliumProject_Maven.Organization.OrganizationPage;


public class TC_01_CreateOrganizationTest extends BaseClass {

	
   /**
 * @throws Throwable 
    * 
    */
	
	@Test(groups="SmokeSuite")
	public void CreateOrganization() throws Throwable {
		
	HomePage hp = new HomePage(driver);
	
	String OrgName = eLib.getExcelData("Sheet1",1,2) + jLib.getRandomNum();
	String webName = eLib.getExcelData("Sheet1",1,3) + jLib.getRandomNum();
	
	
	hp.clickOnOrganization();
	OrganizationPage OrgPage=new OrganizationPage(driver);
	OrgPage.clickOnOrganization();
	
	CreateOrganizationPage createOrg=new CreateOrganizationPage(driver);
	createOrg.createOrganization(OrgName);
	createOrg.createWebsite(webName);
	
	
	}
	
	@Test
	public void CreateOrgInd()
	{
		System.out.println("check the regional regression testing ");
	}
	

}
