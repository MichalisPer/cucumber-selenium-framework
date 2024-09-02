package com.personal.mp.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public void navigateToSwagLabs() {
        this.driver.get("https://www.saucedemo.com/");
    }

    public WebDriverWait getWait() {
        return this.wait;
    }
}
