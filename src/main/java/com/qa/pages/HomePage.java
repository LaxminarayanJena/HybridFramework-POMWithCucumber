package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;



public class HomePage extends TestBase {
	
	
	@FindBy(xpath="//*[contains(text(),'Michael heard')]")
	WebElement  userName ;
	
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContact;
	

	//Initialise the pageobjects
	public HomePage()
	{
		PageFactory.initElements(driver, this);
		//PageFactory.initElements(driver, LoginPage.class);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyuserName() {
		return userName.isDisplayed();
	}
	
	public void clickOnNewContactLink()
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContact.click();
	}
	
	
	


	
	
	
	

}
