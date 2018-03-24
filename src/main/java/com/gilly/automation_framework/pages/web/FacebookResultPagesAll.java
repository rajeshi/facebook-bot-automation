package com.gilly.automation_framework.pages.web;

import org.openqa.selenium.By;

public class FacebookResultPagesAll extends BasePage {

    By pagesTab = By.xpath("//li[@data-edge='keywords_pages']//a//div[text()='Pages']");

    public boolean isPagesTabPresent() {
        return isElementPresent(pagesTab, 20);
    }

    public FacebookResultPagesPageTab clickPagesLink() {
        waitForElement(pagesTab).click();
        return new FacebookResultPagesPageTab();
    }
}
