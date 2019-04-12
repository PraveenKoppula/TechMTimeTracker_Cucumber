package com.techm.timetracker.stepDefinitions;

import static org.junit.Assert.assertEquals;

import com.techm.timetracker.base.TestBase;
import com.techm.timetracker.pages.HomePage;
import com.techm.timetracker.pages.LoginPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition extends TestBase{
	LoginPage loginPage; 
	HomePage homePage;
	
	public LoginStepDefinition()
	{
		super();
	}
	
	@Given("^user on Login page$")
	public void user_on_Login_page(){
		initialization();
		loginPage = new LoginPage();
	}
	
	@When("^URL name is TechmTimeTracker$")
	public void url_name_is_TechmTimeTracker(){
		String siteTitle = driver.getTitle();
		System.out.println("site Title : " + siteTitle);
		assertEquals("MyTime Login", siteTitle);		
	}

	@Then("^user enters details and login$")
	public void user_enters_details_and_login() {
		homePage =  loginPage.login(prop.getProperty("username"), prop.getProperty("password"));		
	}

	@Then("^user is on Home page$")
	public void user_is_on_Home_page() {
		assertEquals(true, homePage.checkIfFillTSImagePresent());
		driver.quit();
	}
	
}
