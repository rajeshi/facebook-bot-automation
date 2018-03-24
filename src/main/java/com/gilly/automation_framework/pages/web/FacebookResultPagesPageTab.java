package com.gilly.automation_framework.pages.web;

import com.gilly.automation_framework.data.BasicInfo;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FacebookResultPagesPageTab extends BasePage {

    By resultsSection = By.id("initial_browse_result");
    By endOfResultsSection = By.xpath("//div[text()='End of Results']");

    public boolean isResultsSectionPresent() {
        return isElementPresent(resultsSection, 20);
    }

    public FacebookResultPagesPageTab scrollTillEndOfResultsAndGoToTop() {
        int cnt = 1;
        while (!hasElement(endOfResultsSection)) {
            getJavaScriptExecutor().executeScript("window.scrollBy(0,2500);");
            cnt++;
        }
        getJavaScriptExecutor().executeScript("window.scrollBy(0," + (-cnt * 2500) + ");");
        return this;
    }

    public List<BasicInfo> getBasicInfoFromResults() {
        List<WebElement> elements = waitForElement(resultsSection).findElements(By.xpath(".//a[@data-testid]"));
        List<BasicInfo> basicInfos = new ArrayList<>();
        for (WebElement element : elements) {
            BasicInfo basicInfo = new BasicInfo();
            basicInfo.setName(element.findElement(By.xpath(".//span")).getText());
            basicInfo.setUrl(element.getAttribute("href"));
            basicInfos.add(basicInfo);
        }
        return basicInfos;
    }
}
