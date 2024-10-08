package com.personal.mp.step_defs;

import com.personal.mp.page_objects.HomePage;
import com.personal.mp.page_objects.LoginPage;
import com.personal.mp.utils.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SortingSteps {
    private TestContext testContext;
    private LoginPage loginPage;
    private HomePage homePage;

    public SortingSteps(TestContext testContext) {
        this.testContext = testContext;
        this.loginPage = testContext.getPageObjectManager().getLoginPage();
        this.homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Given("{string} is on the home page")
    public void userIsOnTheHomePage(String username) {
        loginPage.navigateToApplication();
        loginPage.loginUser(username, "secret_sauce");
    }

    @When("they select to sort products by price in {} order")
    public void theySelectToSortProductsByPriceInOrder(String order) {
        if (order.equals("ascending")) {
            homePage.selectSortOptionByText("Price (low to high)");
        } else if (order.equals("descending")) {
            homePage.selectSortOptionByText("Price (high to low)");
        }
    }

    @Then("the products are sorted by price in {} order")
    public void theProductsAreSortedInOrder(String order) {
        if (order.equals("ascending")) {
            Assert.assertTrue(homePage.arePricesSortedAscending());
        } else if (order.equals("descending")) {
            Assert.assertTrue(homePage.arePricesSortedDescending());
        }
    }

    @When("they select to sort products by name in {} order")
    public void theySelectToSortProductsByNameInOrder(String order) {
        if (order.equals("ascending")) {
            homePage.selectSortOptionByText("Name (A to Z)");
        } else if (order.equals("descending")) {
            homePage.selectSortOptionByText("Name (Z to A)");
        }
    }

    @Then("the products are sorted by name in {} order")
    public void theProductsAreSortedByNameInOrder(String order) {
        if (order.equals("ascending")) {
            Assert.assertTrue(homePage.areNamesSortedAscending());
        } else if (order.equals("descending")) {
            Assert.assertTrue(homePage.areNamesSortedDescending());
        }
    }
}
