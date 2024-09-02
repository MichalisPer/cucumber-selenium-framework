package com.personal.mp.cucumber_options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
        glue = "com/personal/mp/step_defs", monochrome = true,
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"})
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
