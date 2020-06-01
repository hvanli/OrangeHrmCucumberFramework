package com.hrm.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.*;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features/AddEmployee.feature"
		, glue = "com/hrm/steps"
		, dryRun = true
//		,plugin = {"pretty", "html:target/html/cucumber-default"}
//		, tags = "smoke"
		, monochrome = true
		)
public class Runner {

}
