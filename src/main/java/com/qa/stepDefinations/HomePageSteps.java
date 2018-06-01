package com.qa.stepDefinations;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestBase;
import com.qa.util.TestUtil;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class HomePageSteps  extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	
	@Given("^user opens browser$")
	public void user_opens_browser() {
		TestBase.initialization();
	   
	    
	}

	@Then("^user is on login page$")
	public void user_is_on_login_page() {
		loginpage = new LoginPage();
	  String title= loginpage.validateLoginPageTitle();
	  Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");

	    
	}

	@Then("^user enters username and password and login$") 
	public void user_enters_username_and_password() throws InterruptedException {
	   
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	
	@Then("^validate home page title$")
	public void validate_home_page_title() {
		String hometitle=homepage.verifyHomePageTitle();  
		
		  Assert.assertEquals(hometitle, "CRMPRO"); 
	    
	}

	@Then("^validate logged in username$")
	public void validate_logged_in_username() {
		 testutil = new TestUtil() ;
		testutil.switchToFrame();
		
	    boolean flag=homepage.verifyuserName();
	    Assert.assertTrue(flag);
	}


}
