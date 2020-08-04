package com.hrm.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
				glue = "com.hrm.Api.steps",
				dryRun = false,
				tags="@generateToken"	
		)
public class ApiRunner {

}
