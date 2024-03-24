package beQualified.test.pages;

import beQualified.test.utilities.ConfigurationReader;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage {

    private final Page page;


    public LoginPage(Page page) {
        this.page = page;
    }

    public void login() {
        String userName = ConfigurationReader.get("userName");
        String password = ConfigurationReader.get("password");
        page.locator("[data-test=\"username\"]").fill(userName);
        page.locator("[data-test=\"password\"]").fill(password);
        page.locator("[data-test=\"login-button\"]").click();
    }
    public void verifyLoginPage(){
        assertThat(page.locator("[data-test=\"login-button\"]")).containsText("Login");
    }
}