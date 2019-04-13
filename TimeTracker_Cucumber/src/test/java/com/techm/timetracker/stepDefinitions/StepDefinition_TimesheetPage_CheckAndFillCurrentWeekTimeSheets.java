package com.techm.timetracker.stepDefinitions;

import static org.junit.Assert.assertEquals;

import com.techm.timetracker.base.TestBase;
import com.techm.timetracker.pages.HomePage;
import com.techm.timetracker.pages.LoginPage;
import com.techm.timetracker.pages.TimeSheetPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import java.util.Calendar;

public class StepDefinition_TimesheetPage_CheckAndFillCurrentWeekTimeSheets extends TestBase {

  private LoginPage loginPage;
  private HomePage homePage;
  private TimeSheetPage tsPage;
  private boolean bAllTimeSheetsFilled;

  @Given("^user on fill timesheet page$")
  public void user_on_filltimesheet_page() {
    initialization();
    loginPage = new LoginPage();
    homePage =  loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    tsPage = homePage.enterToTSPage();
  }


  @Then("^user checks current week timesheets$")
  public void user_checks_current_week_timesheets() throws InterruptedException {
    int currentWeekNumber = tsPage.listOfWeeks().size() - 1;
    String presentWeekRange = tsPage.listOfWeeks().get(currentWeekNumber).getText();
    System.out.println("Present week range: " + presentWeekRange);
    bAllTimeSheetsFilled = false;


    if (tsPage.bTimesheetsFilledForSelectedWeek()){
      System.out.println("Timesheets filled for current week");
      bAllTimeSheetsFilled = true;
    } else {
      System.out.println("Timesheets not filled/partially filled for current week");
      for (int dayNumber = 0; dayNumber < 5; dayNumber++) {

        if (!tsPage.isItCurrentDay(dayNumber)) {
          if (!tsPage.bDayTimesheetFilled(dayNumber)) {
            tsPage.clickDayToExpand(dayNumber);
            if (tsPage.submitBtnPresent(dayNumber)) {
              tsPage.enterTimeForADay(dayNumber);
            } else {
              System.out.println("Timesheets filled for all days...");
              bAllTimeSheetsFilled = true;
              break;
            }
          }
        } else {
          if (!tsPage.bDayTimesheetFilled(dayNumber)) {
            tsPage.clickDayToExpand(dayNumber);
            tsPage.enterTimeForADay(dayNumber);
            bAllTimeSheetsFilled = true;
            break;
          }
        }
      }
    }
  }

  @Then("^message displayed on success and browser closes$")
  public void message_displayed_on_success_and_browser_closes() {
      if(bAllTimeSheetsFilled){
        System.out.println("All time sheets filled till current day ... good day ... !!! ");
      }else{
        System.out.println("Some error .... All time sheets are NOT filled.. !!! ");
      }

      driver.quit();
  }

}
