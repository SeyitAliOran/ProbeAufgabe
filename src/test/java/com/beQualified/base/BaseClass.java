package com.beQualified.base;

import com.microsoft.playwright.*;

public class BaseClass {

    Playwright playwright;
    BrowserType browserType;
    Browser browser;
    BrowserContext context;
    public Page page;
    public void launchPlaywright(String browserName, String headless) {
        playwright = Playwright.create();

        switch (browserName.toLowerCase()) {
            case "chromium":
                browserType = playwright.chromium();
                break;
            case "firefox":
                browserType = playwright.firefox();
                break;
            case "webkit":
                browserType = playwright.webkit();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        boolean isHeadless = Boolean.parseBoolean(headless);
        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(isHeadless));

        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1920, 1080)
        );

        page = context.newPage();
    }
    public void launchApplication(String url) {
        page.navigate(url);

    }

    public void closePlaywright() {
        page.close();
        browser.close();
        playwright.close();
    }
}