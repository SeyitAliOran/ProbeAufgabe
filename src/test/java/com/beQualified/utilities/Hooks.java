package com.beQualified.utilities;

import com.beQualified.base.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Hooks extends BaseClass {

    @BeforeClass
    @Parameters({ "url", "browserName" , "headless"})
    public void setUp(@Optional("https://www.saucedemo.com/") String url,
                      @Optional("chrome") String browserName, @Optional("false") String headless) {
        launchPlaywright("chromium", headless);
        launchApplication(url);
    }

    @AfterClass
    public void tearDown() {
        closePlaywright();
    }
}