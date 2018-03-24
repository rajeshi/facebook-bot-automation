package com.gilly.automation_framework.workflow;

import com.gilly.automation_framework.data.BasicInfo;
import com.gilly.automation_framework.data.ContactInfo;
import com.gilly.automation_framework.data.MarketingInfo;
import com.gilly.automation_framework.pages.web.FacebookHomePage;
import com.gilly.automation_framework.pages.web.FacebookLoginPage;
import com.gilly.automation_framework.pages.web.FacebookResultDetailsAboutTab;
import com.gilly.automation_framework.pages.web.FacebookResultPagesAll;
import com.gilly.automation_framework.pages.web.FacebookResultPagesPageTab;
import java.util.List;

public interface FacebookBotWorkflows {

    public FacebookLoginPage openFacebookLoginPage(String url);

    public FacebookHomePage loginToFacebook(FacebookLoginPage loginPage, String username, String password);

    public FacebookResultPagesAll searchForBusinessByKeyword(FacebookHomePage homePage, String keyword);

    public FacebookResultPagesPageTab navigateToPagesTab(FacebookResultPagesAll resultPages);

    public List<BasicInfo> getBasicInfoFromResults(FacebookResultPagesPageTab resultPages);

    public FacebookResultDetailsAboutTab navigateToTheResultAboutPage(BasicInfo basicInfo);

    public MarketingInfo navigateToContactUsPageOnWebsite();

    public void sendEmailsFromMyAccountToTheBusinessContact(ContactInfo contact);

    public void fillContactUsFormInformation(String name, String email, String contactNumber, String message);

}
