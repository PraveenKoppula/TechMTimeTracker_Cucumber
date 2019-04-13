package com.techm.timetracker.stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.techm.timetracker.base.TestBase;
import com.techm.timetracker.pages.HomePage;
import com.techm.timetracker.pages.LoginPage;
import com.techm.timetracker.pages.TimeSheetPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Calendar;

public class StepDefinition_TimesheetPage_VerifyCurrentWeekDisplayedByDefault extends TestBase {

  private LoginPage loginPage;
  private HomePage homePage;
  private TimeSheetPage tsPage;

  @Given("^user on timesheet page$")
  public void user_on_timesheet_page() {
    initialization();
    loginPage = new LoginPage();
    homePage =  loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    tsPage = homePage.enterToTSPage();
  }

  @Then("^current week is displayed default$")
  public void current_week_is_displayed_default() {

    boolean bCurrentWeekIsdisplayed = false;
    // To get the text of last option from the week range combo
    int currentWeekNumber = tsPage.listOfWeeks().size() - 1;

    String presentWeekNumber = tsPage.listOfWeeks().get(currentWeekNumber).getAttribute("value");
    System.out.println("Present week range: " + presentWeekNumber);
    // Trim week number from the complete text

    Calendar cal = Calendar.getInstance();
    // Get WEEK_OF_YEAR from Calendar class
    System.out.println("Week of the year from calendar obj : " + cal.get(Calendar.WEEK_OF_YEAR));

    if (Integer.parseInt(presentWeekNumber) == cal.get(Calendar.WEEK_OF_YEAR)) {
      System.out.println("Week number matched. Current week displayed !!!");
      bCurrentWeekIsdisplayed = true;
    } else {
      System.out.println("Week number NOT matched. Current week NOT displayed !!!");
    }

    assertTrue( bCurrentWeekIsdisplayed);
  }

  @Then("^browser closes$")
  public void browser_closes() {
    driver.quit();
  }

}
