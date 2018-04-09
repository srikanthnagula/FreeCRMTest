package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[@contains(text(),'User: srikanth nagula')]")
	WebElement usernameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontactlink;
	
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement TasksLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		
		return usernameLabel.isDisplayed();
	}
	
	
	public ContactsPage clickOnContactsLink() {
		
		ContactsLink.click();
		return new ContactsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		TasksLink.click();
		return new TasksPage();
	}
	
	public void ClickonNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(ContactsLink).build().perform();
		newcontactlink.click();
	}
	
	
	
}
