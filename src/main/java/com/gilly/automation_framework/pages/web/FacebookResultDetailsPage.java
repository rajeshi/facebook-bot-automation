package com.gilly.automation_framework.pages.web;

import org.openqa.selenium.By;

/**
 *
 * @author abc
 */
public class FacebookResultDetailsPage extends BasePage {

    By aboutTab = By.xpath("//div[@data-key='tab_about']");

    public boolean isAboutTabDisplayed() {
        return isElementPresent(aboutTab, 20);
    }

    public FacebookResultDetailsAboutTab clickAboutTab() {
        waitForElement(aboutTab).click();
        return new FacebookResultDetailsAboutTab();
    }
}
