package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class loginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	
	public loginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();		
	}
	
	@Test(priority=1)
	public void loginpageTitleTest() {
		String title=loginpage.validateloginpageTitle();
		Assert.assertEquals(title,"Free CRM in the cloud software boosts sales");
	}
	
	@Test(priority=2)
	public void crmlogoImageTest() {
		boolean flag= loginpage.validateCRMimage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() {
		homepage= loginpage.login(Prop.getProperty("username"),Prop.getProperty("password"));
		//Assert.assert
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
