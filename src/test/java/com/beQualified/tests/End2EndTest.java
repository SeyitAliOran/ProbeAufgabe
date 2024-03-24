package com.beQualified.tests;

import com.beQualified.pages.CartPage;
import com.beQualified.pages.CheckOutPage;
import com.beQualified.pages.LoginPage;
import com.beQualified.pages.ProductPage;
import com.beQualified.utilities.Hooks;
import org.testng.annotations.Test;

public class End2EndTest extends Hooks {

    private LoginPage loginPage;
    private CartPage cartPage;
    private CheckOutPage checkOutPage;
    private ProductPage productPage;

    @Test()
    public void end2endTest() {
        loginPage = new LoginPage(page);
        loginPage.login();
        productPage = new ProductPage(page);
        productPage.verifyProductPage();
        productPage.addToCart();
        productPage.openCartPage();
        cartPage = new CartPage(page);
        cartPage.verifyProducts();
        cartPage.clickCheckout();
        checkOutPage = new CheckOutPage(page);
        checkOutPage.enterInformation();
        checkOutPage.clickFinish();
        checkOutPage.verifyCheckOutMessage();
        checkOutPage.backHome();
        productPage.logOut();
        loginPage.verifyLoginPage();
    }

}