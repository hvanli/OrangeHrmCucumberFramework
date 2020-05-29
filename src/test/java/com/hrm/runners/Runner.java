package com.hrm.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.*;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features"
		, glue = "com/hrm/steps"
		, dryRun = true
//		, tags = "smoke"
		, monochrome = true
		)



public class Runner {

}
