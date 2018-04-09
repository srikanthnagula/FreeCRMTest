package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(name="client_lookup")
	WebElement Company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement SaveButton;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	
	
	public void createNewContact(String title, String Fname, String Lname, String company) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstname.sendKeys(Fname);
		lastname.sendKeys(Lname);
		Company.sendKeys(company);
		SaveButton.click();
	}
	
	
	
}
