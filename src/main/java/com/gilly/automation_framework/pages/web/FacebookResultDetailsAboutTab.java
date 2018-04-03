package com.gilly.automation_framework.pages.web;

import com.gilly.automation_framework.data.ContactInfo;
import org.openqa.selenium.By;

public class FacebookResultDetailsAboutTab extends BasePage {

    By additionalContactInfoSection = By.xpath("//div[preceding-sibling::div/div[text()='ADDITIONAL CONTACT INFO' | text()='CONTACT INFO']]//a[@data-lynx-mode]//div");
    By emailSection = By.xpath("//div[preceding-sibling::div/div[text()='ADDITIONAL CONTACT INFO' | text()='CONTACT INFO']]//a[contains(@href,'mailto:')]");

    public boolean isAdditionalContactInfoSectionPresent() {
        return isElementPresent(additionalContactInfoSection, 5);
    }

    public boolean isEmailSectionPresent() {
        return isElementPresent(emailSection, 5);
    }

    public ContactInfo getContactInfoFromAboutPage() {
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setCompanyUrl(waitForElement(additionalContactInfoSection).getText());
        return contactInfo;
    }

    public ContactInfo getEmailFromAboutPage() {
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setEmail(waitForElement(emailSection).getText());
        return contactInfo;
    }
}
