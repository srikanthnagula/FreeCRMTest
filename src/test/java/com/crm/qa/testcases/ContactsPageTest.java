package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	public ContactsPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		testutil = new TestUtil();
		contactspage= new ContactsPage();
		loginpage = new LoginPage();
		homepage = loginpage.login(Prop.getProperty("username"),Prop.getProperty("password"));
		testutil.SwitchToFrame();
		contactspage= homepage.clickOnContactsLink();
		
		}

	
	
	@Test (priority=1)
	public void VerifyContactsPageLabelTest() {
		Assert.assertTrue(contactspage.VerifyContactsLabel(),"Contacts Label is Missing on the Page");
	}
	
	@DataProvider
	public void getTestData() {
		
	}
	
	
	
	@Test (priority=2)
	public void validateCreateNewContact() {
		homepage.ClickonNewContactLink();;
		contactspage.createNewContact("Mr.", "TOM","Peter", "Google");
		
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
