package com.personal.mp.utils;

public class TestContext {
    private final WebDriverManager webDriverManager;
    private final PageObjectManager pageObjectManager;

    public TestContext() {
        this.webDriverManager = new WebDriverManager();
        this.pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
}
