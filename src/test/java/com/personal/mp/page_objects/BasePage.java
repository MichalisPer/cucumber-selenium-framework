package com.personal.mp.page_objects;

import com.personal.mp.config.FileReaderManager;
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

    public void navigateToApplication() {
        this.driver.get(FileReaderManager.getInstance().getConfigFileReader().getApplicationUrl());
    }

    public WebDriverWait getWait() {
        return this.wait;
    }
}
