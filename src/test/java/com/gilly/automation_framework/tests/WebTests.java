package com.gilly.automation_framework.tests;

import com.gilly.automation_framework.base.Configurations;
import com.gilly.automation_framework.base.DriverFactory;
import com.gilly.automation_framework.data.BasicInfo;
import com.gilly.automation_framework.data.ContactInfo;
import com.gilly.automation_framework.data.MarketingInfo;
import com.gilly.automation_framework.pages.web.FacebookHomePage;
import com.gilly.automation_framework.pages.web.FacebookLoginPage;
import com.gilly.automation_framework.pages.web.FacebookResultDetailsAboutTab;
import com.gilly.automation_framework.pages.web.FacebookResultPagesAll;
import com.gilly.automation_framework.pages.web.FacebookResultPagesPageTab;
import com.gilly.automation_framework.utils.Excel;
import com.gilly.automation_framework.utils.ExcelContext;
import com.gilly.automation_framework.workflow.FacebookBotWorkFlowImplementations;
import com.gilly.automation_framework.workflow.FacebookBotWorkflows;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WebTests extends BaseTests {

    @Test(dataProvider = "testData")
    public void facebookBotTest(String keyword) {
        FacebookBotWorkflows fbw = new FacebookBotWorkFlowImplementations();
        FacebookLoginPage loginPage = fbw.openFacebookLoginPage("https://www.facebook.com");
        assertTrue(loginPage.isFacebookLoginPageLoaded(), "Facebook Login page not loaded");

        FacebookHomePage homePage = fbw.loginToFacebook(loginPage, Configurations.FACEBOOK_EMAIL, Configurations.FACEBOOK_PASSWORD);
        assertTrue(homePage.isSearchTextBoxPresent(), "Facebook Home page not loaded");

        FacebookResultPagesAll resultsPage = fbw.searchForBusinessByKeyword(homePage, keyword);
        assertTrue(resultsPage.isPagesTabPresent(), "Facebook Results page not loaded");

        FacebookResultPagesPageTab pageTab = fbw.navigateToPagesTab(resultsPage);
        assertTrue(pageTab.isResultsSectionPresent(), "Facebook Results Page Tab not loaded");

        List<BasicInfo> basicInfos = fbw.getBasicInfoFromResults(pageTab);
        assertTrue(!basicInfos.isEmpty(), "No basic information collected");

        List<ContactInfo> contacts = new ArrayList<>();
        for (BasicInfo basicInfo : basicInfos) {
            FacebookResultDetailsAboutTab aboutTab = fbw.navigateToTheResultAboutPage(basicInfo);
            if (aboutTab.isAdditionalContactInfoSectionPresent()) {
                ContactInfo contact = aboutTab.getContactInfoFromAboutPage();
                if (contact.getCompanyUrl().isEmpty()) {
                } else {
                    WebDriver driver = DriverFactory.getDriver();
                    driver.navigate().to(contact.getCompanyUrl());
                    MarketingInfo marketingInfo = fbw.navigateToContactUsPageOnWebsite();
                }
                contacts.add(contact);
            }
        }
        if (contacts.isEmpty()) {
            System.out.println("No information available for keyword: " + keyword);
        }
        //assertTrue(!contacts.isEmpty(), "No contact information collected");
    }

    @Test
    public void testPickingUpInfo() {

        List<ContactInfo> contacts = new ArrayList<>();

        ContactInfo contact1 = new ContactInfo();
        contact1.setCompanyUrl("https://www.novikovmiami.com");

        ContactInfo contact2 = new ContactInfo();
        contact2.setCompanyUrl("http://nomamiami.com/");

        contacts.add(contact1);
        contacts.add(contact2);

        FacebookBotWorkflows fbw = new FacebookBotWorkFlowImplementations();
        for (ContactInfo contact : contacts) {
            if (contact.getCompanyUrl().isEmpty()) {
            } else {
                WebDriver driver = DriverFactory.getDriver();
                driver.navigate().to(contact.getCompanyUrl());
                MarketingInfo marketingInfo = fbw.navigateToContactUsPageOnWebsite();
            }
        }
    }

    @Test
    public void testEmailUtility() {
        ContactInfo contact = new ContactInfo();
        contact.setEmail("rajesh.n.iyer@gmail.com");

        FacebookBotWorkflows fbw = new FacebookBotWorkFlowImplementations();
        fbw.sendEmailsFromMyAccountToTheBusinessContact(contact);
    }

    @DataProvider(name = "testData", parallel = false)
    public static Object[][] getTestData() {
        ExcelContext context = new ExcelContext();
        context.setExcelFile("testData/Facebook.xlsx");
        context.setSheetName("Sheet1");
        Excel excelObj = new Excel(context);
        String[][] testData = excelObj.getData("keyword");
        return testData;
    }
}
