Feature: TimeTracker Home Page

Scenario: Verify user able to enter into timesheets page

Given user on home page
When timesheet image is present
Then user checks the acknowledge check box and clicks fill timesheet image
Then user taken to timesheet page 
