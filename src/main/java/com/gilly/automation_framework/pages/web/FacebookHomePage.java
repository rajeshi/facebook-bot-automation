package com.gilly.automation_framework.pages.web;

import org.openqa.selenium.By;

public class FacebookHomePage extends BasePage {

    By searchTextBox = By.xpath("//input[@data-testid='search_input']");
    By searchButton = By.xpath("//button[@data-testid='facebar_search_button']");

    public boolean isSearchTextBoxPresent() {
        return isElementPresent(searchTextBox, 20);
    }

    public FacebookHomePage enterSearchKeyword(String keyword) {
        waitForElement(searchTextBox).sendKeys(keyword);
        return this;
    }

    public FacebookResultPagesAll clickSearchButton() {
        waitForElement(searchButton).click();
        return new FacebookResultPagesAll();
    }
}
