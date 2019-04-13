package com.techm.timetracker.stepDefinitions;

import static com.techm.timetracker.base.TestBase.initialization;
import static com.techm.timetracker.base.TestBase.prop;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.techm.timetracker.base.TestBase;
import com.techm.timetracker.pages.HomePage;
import com.techm.timetracker.pages.LoginPage;
import com.techm.timetracker.pages.TimeSheetPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition_HomePage_NavigatingToTimesheetPage extends TestBase {

  private LoginPage loginPage;
  private HomePage homePage;
  private TimeSheetPage tsPage;

  @Given("^user on home page$")
  public void user_on_home_page() {

    initialization();
    loginPage = new LoginPage();
    homePage =  loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
  }

  @When("^timesheet image is present$")
  public void timesheet_image_is_present() {
    assertTrue (homePage.checkIfFillTSImagePresent());
  }

  @Then("^user checks the acknowledge check box and clicks fill timesheet image$")
  public void user_checks_the_acknowledge_check_box_and_clicks_fill_timesheet_image() {
    tsPage = homePage.enterToTSPage();
  }

  @Then("^user taken to timesheet page$")
  public void user_taken_to_timesheet_page() {
    assertTrue (tsPage.empClassificationPresent());
    driver.quit();
  }

}
