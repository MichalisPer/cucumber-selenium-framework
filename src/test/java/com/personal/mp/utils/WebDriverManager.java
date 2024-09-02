package com.personal.mp.utils;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {

    private WebDriver driver = null;

    public WebDriver getDriver() {
        String browser = System.getProperty("browser", "chrome");
        String runMode = System.getProperty("runMode", "local");
        if (driver == null) {
            driver = WebDriverFactory.createWebDriver(browser, runMode);
        }
        return driver;
    }

    public  void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
