package com.qualitypointtech.testrunners;

import org.junit.runner.RunWith;

import org.junit.Test;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/main/resources/features/qualitypointtech.feature",
		glue="com.qualitypointtech.stepdefinations",
		tags = "@TC_01",
		monochrome=true,
		dryRun=false,
		plugin= {"pretty","json:target/cucumber.json"}
		) 

public class Runner {
	

}
