package com.techm.timetracker.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\Praveen Koppula\\eclipse-workspace\\TimeTracker_Cucumber\\TimeTracker_Cucumber\\src\\main\\java\\com\\techm\\timetracker\\features\\login.feature"
		,glue={"com.techm.timetracker.stepDefinitions"}
		,format={"pretty","html:test-output"}
		)

public class TestRunner {

}
