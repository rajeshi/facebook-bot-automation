package com.gilly.automation_framework.pages.web;

import org.openqa.selenium.By;

public class FacebookLoginPage extends BasePage {

    By emailTextBox = By.id("email");
    By passwordTextBox = By.id("pass");
    By loginButton = By.xpath("//input[@value='Log In']");

    public FacebookLoginPage enterEmail(String email) {
        waitForElement(emailTextBox).sendKeys(email);
        return this;
    }

    public boolean isFacebookLoginPageLoaded() {
        return isElementPresent(emailTextBox, 15);
    }

    public FacebookLoginPage enterPassword(String password) {
        waitForElement(passwordTextBox).sendKeys(password);
        return this;
    }

    public FacebookHomePage clickLogin() {
        waitForElement(loginButton).click();
        return new FacebookHomePage();
    }
}
