Feature: TimeTracker Timesheet Page

Scenario: Verify the default week displayed is current week

Given user on timesheet page
Then current week is displayed default
Then browser closes

Scenario: Check the current week timesheets and fill if not filled

Given user on fill timesheet page
Then user checks current week timesheets
Then message displayed on success and browser closes

