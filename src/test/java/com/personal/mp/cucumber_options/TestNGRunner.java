package com.personal.mp.cucumber_options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features",
        glue = "com/personal/mp/step_defs", monochrome = true,
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"})
public class TestNGRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object [][] scenarios() {
        return super.scenarios();
    }
}
