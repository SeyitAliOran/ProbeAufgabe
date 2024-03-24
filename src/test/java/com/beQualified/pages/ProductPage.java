package com.beQualified.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductPage {
    private final Page page;

    public ProductPage(Page page) {
        this.page = page;
    }

    public void verifyProductPage() {
        assertThat(page.locator("#header_container")).containsText("Products");
    }

    public void addToCart() {
        page.locator("#add-to-cart-sauce-labs-backpack").click();
        page.locator("#add-to-cart-sauce-labs-bike-light").click();
    }

    public void openCartPage() {
        page.locator("a").filter(new Locator.FilterOptions().setHasText("2")).click();
    }

    public void logOut() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Open Menu")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout")).click();
    }

}
