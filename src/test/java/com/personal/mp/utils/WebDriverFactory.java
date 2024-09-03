package com.personal.mp.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {

    static final String URL_GRID = System.getenv("GRID_URL");

    public static WebDriver createWebDriver(String browser, String runMode) {
        switch (runMode.toLowerCase()) {
            case "grid":
                return createGridDriver(browser);
            case "local":
            default:
                return createLocalDriver(browser);
        }
    }

    private static WebDriver createLocalDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "firefox":
                return WebDriverManager.firefoxdriver().create();
            case "chrome":
            default:
                return WebDriverManager.chromedriver().capabilities(new ChromeOptions().addArguments("--headless")).create();
        }
    }

    private static WebDriver createGridDriver(String browser) {
        try {
            switch (browser.toLowerCase()) {
                case "firefox":
                    return new RemoteWebDriver(new URL(URL_GRID), new FirefoxOptions());
                case "chrome":
                default:
                    return new RemoteWebDriver(new URL(URL_GRID), new ChromeOptions());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the Selenium Grid at " + URL_GRID);
        }
    }

}
