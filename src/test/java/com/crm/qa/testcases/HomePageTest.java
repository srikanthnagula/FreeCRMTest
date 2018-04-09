package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;
	
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		testutil = new TestUtil();
		contactspage = new ContactsPage();
		loginpage = new LoginPage();
		homepage= loginpage.login(Prop.getProperty("username"),Prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void VerifyHomePageTitleTest() {
		String HomePageTitle=homepage.verifyHomePageTitle();
		Assert.assertEquals(HomePageTitle, "CRMPRO","HomePage Title is not Matching");
		}
	
	@Test(priority=2)
	public void VerifyUserNameTest() {
		testutil.SwitchToFrame();
		Assert.assertTrue(homepage.verifyCorrectUserName());
		
	}
		
	@Test(priority=3)
	public void VerifyContactsLinkTest() {
		testutil.SwitchToFrame();
		contactspage=homepage.clickOnContactsLink();
		
	}
	
	
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
}
