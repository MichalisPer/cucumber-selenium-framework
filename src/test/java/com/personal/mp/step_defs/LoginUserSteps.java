package com.personal.mp.step_defs;

import com.personal.mp.page_objects.LoginPage;
import com.personal.mp.utils.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginUserSteps {

     TestContext testContext;
    LoginPage loginPage;

    public LoginUserSteps(TestContext testContext) {
        this.testContext = testContext;
        this.loginPage = testContext.getPageObjectManager().getLoginPage();
    }

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        loginPage.navigateToSwagLabs();
    }

    @When("they login with username {} and password {}")
    public void theyLoginWithUsernameAndPassword(String username, String password) {
        loginPage.loginUser(username, password);
    }

    @Then("they should be redirected to the homepage")
    public void theyShouldBeRedirectedToTheHomepage() {
        Assert.assertEquals(testContext.getWebDriverManager().getDriver().getCurrentUrl(),
                "https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(testContext.getWebDriverManager().getDriver().getTitle(),
                "Swag Labs");
    }

    @Then("they should get a warning message")
    public void theyShouldGetAWarningMessage() {
        Assert.assertTrue(loginPage.getWait().until(
                ExpectedConditions.
                        textToBePresentInElementLocated(
                                By.className("error-message-container"),
                                "user has been locked out")));
    }
}
