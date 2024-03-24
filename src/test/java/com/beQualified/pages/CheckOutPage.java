package com.beQualified.pages;

import com.beQualified.utilities.ConfigurationReader;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckOutPage {
    private final Page page;

    public CheckOutPage(Page page) {
        this.page = page;
    }
    public void enterInformation() {
        page.fill("[data-test=\"firstName\"]", ConfigurationReader.get("firstName"));
        page.fill("[data-test=\"lastName\"]", ConfigurationReader.get("lastName"));
        page.fill("[data-test=\"postalCode\"]", ConfigurationReader.get("postalCode"));
        page.locator("[data-test=\"continue\"]").click();

    }
    public void clickFinish(){
        page.locator("[data-test=\"finish\"]").click();
    }
    public void verifyCheckOutMessage(){
        assertThat(page.getByRole(AriaRole.HEADING)).containsText("Thank you for your order!");
    }
    public void backHome(){
        page.locator("[data-test=\"back-to-products\"]").click();
    }
}
