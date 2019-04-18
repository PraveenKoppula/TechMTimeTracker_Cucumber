package com.techm.timetracker.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/java/com/techm/timetracker/features",
		glue={"com.techm.timetracker.stepDefinitions"},
		format={"pretty","html:test-output"},
		monochrome = true,
		//dryRun = true,
		strict = true
		)

public class TestRunner {

}
