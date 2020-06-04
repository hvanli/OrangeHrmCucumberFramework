package com.hrm.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.*;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features"
		, glue = "com/hrm/steps"
		, dryRun = false
		,plugin = {"pretty", "html:target/html/cucumber-default", "json:target/cucumber.json", "rerun:target/failed.txt"}
//		, tags = "smoke"
		, monochrome = true
		)
public class Runner {

}
