package com.crm.SeleniumProject_Maven.Script;



import org.testng.annotations.Test;

import com.crm.SeleniumProject_Maven.GenericsLib.BaseClass;
import com.crm.SeliumProject_Maven.Organization.CreateOrganizationPage;
import com.crm.SeliumProject_Maven.Organization.HomePage;
import com.crm.SeliumProject_Maven.Organization.OrganizationPage;


public class TC_04_CreateOrganizationTest extends BaseClass {

   /**
 * @throws Throwable 
    * 
    */
	
	@Test(groups="RegressionSuite")
	public void CreateOrganization() throws Throwable {
		
	HomePage hp = new HomePage(driver);
	hp.clickOnOrganization();
	
	OrganizationPage OrgPage=new OrganizationPage(driver);
	OrgPage.clickOnOrganization();
	
	CreateOrganizationPage createOrg=new CreateOrganizationPage(driver);
	createOrg.dropDownOfType();
	
	}

}
