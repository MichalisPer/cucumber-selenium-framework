package com.personal.mp.step_defs;

import com.personal.mp.utils.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {

    TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @After
    public void quitDriver() {
        testContext.getWebDriverManager().quitDriver();
    }

}
