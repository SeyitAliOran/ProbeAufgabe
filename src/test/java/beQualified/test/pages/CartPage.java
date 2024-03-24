package beQualified.test.pages;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CartPage {
    private final Page page;

    public CartPage(Page page) {
        this.page = page;
    }
    public void clickCheckout(){
        page.locator("[data-test=\"checkout\"]").click();
    }
    public void verifyProducts(){
        assertThat(page.locator("#item_4_title_link")).containsText("Sauce Labs Backpack");
        assertThat(page.locator("#item_0_title_link")).containsText("Sauce Labs Bike Light");
    }
}
