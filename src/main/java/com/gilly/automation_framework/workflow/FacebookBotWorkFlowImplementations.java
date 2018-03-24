package com.gilly.automation_framework.workflow;

import com.gilly.automation_framework.base.Configurations;
import com.gilly.automation_framework.base.DriverFactory;
import com.gilly.automation_framework.base.Res;
import com.gilly.automation_framework.data.BasicInfo;
import com.gilly.automation_framework.data.ContactInfo;
import com.gilly.automation_framework.data.MarketingInfo;
import com.gilly.automation_framework.maps.DataMaps;
import com.gilly.automation_framework.pages.web.FacebookHomePage;
import com.gilly.automation_framework.pages.web.FacebookLoginPage;
import com.gilly.automation_framework.pages.web.FacebookResultDetailsAboutTab;
import com.gilly.automation_framework.pages.web.FacebookResultDetailsPage;
import com.gilly.automation_framework.pages.web.FacebookResultPagesAll;
import com.gilly.automation_framework.pages.web.FacebookResultPagesPageTab;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacebookBotWorkFlowImplementations implements FacebookBotWorkflows {

    @Override
    public FacebookLoginPage openFacebookLoginPage(String url) {
        DriverFactory.getDriver().get(url);
        return new FacebookLoginPage();
    }

    @Override
    public FacebookHomePage loginToFacebook(FacebookLoginPage loginPage, String username, String password) {
        return loginPage.enterEmail(username)
                .enterPassword(password)
                .clickLogin();
    }

    @Override
    public FacebookResultPagesAll searchForBusinessByKeyword(FacebookHomePage homePage, String keyword) {
        return homePage.enterSearchKeyword(keyword)
                .clickSearchButton();
    }

    @Override
    public FacebookResultDetailsAboutTab navigateToTheResultAboutPage(BasicInfo basicInfo) {
        FacebookResultDetailsPage detailsPage = getResultDetails(basicInfo);
        return detailsPage.clickAboutTab();
    }

    @Override
    public void sendEmailsFromMyAccountToTheBusinessContact(ContactInfo contact) {
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.user", Configurations.GMAIL_ID + "@gmail.com");
        props.put("mail.smtp.password", Configurations.GMAIL_PASSWORD);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props, null);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Configurations.GMAIL_ID + "@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(contact.getEmail()));
            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler,"
                    + "\n\n No spam to my email, please!");
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", Configurations.GMAIL_ID + "@gmail.com", Configurations.GMAIL_PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void fillContactUsFormInformation(String name, String email, String contactNumber, String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FacebookResultPagesPageTab navigateToPagesTab(FacebookResultPagesAll resultPages) {
        return resultPages.clickPagesLink();
    }

    @Override
    public List<BasicInfo> getBasicInfoFromResults(FacebookResultPagesPageTab resultPages) {
        return resultPages.scrollTillEndOfResultsAndGoToTop()
                .getBasicInfoFromResults();
    }

    private FacebookResultDetailsPage getResultDetails(BasicInfo basicInfo) {
        DriverFactory.getDriver().navigate().to(basicInfo.getUrl());
        return new FacebookResultDetailsPage();
    }

    @Override
    public MarketingInfo navigateToContactUsPageOnWebsite() {

        WebDriver driver = DriverFactory.getDriver();
        MarketingInfo marketingInfo = new MarketingInfo();

        String url = driver.getCurrentUrl();
        String regex = "(http|https)://(.*)\\.(com|net|org)/";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);

        if (driver.getPageSource().contains("mailto:")) {
            marketingInfo.setEmail(getEmailFromPage(driver.getPageSource()));
        } else {
            if (matcher.find()) {
                String updatedUrl = matcher.group(0);
                String[] contactUsMatches = new String[]{"contact", "contactus", "CONTACT", "CONTACTUS", "ContactUs", "Contact", "About"};

                for (String contactUsMatch : contactUsMatches) {
                    driver.navigate().to(updatedUrl + contactUsMatch);
                    String pageSource = driver.getPageSource();
                    if (pageSource.contains("404 Not Found")) {
                    } else {
                        if (pageSource.contains("mailto:")) {
                            marketingInfo.setEmail(getEmailFromPage(pageSource));
                            break;
                        } else {
                            boolean done = false;
                            try {
                                done = fillOutTheContactUsForm(driver);
                            } catch (URISyntaxException ex) {
                            } catch (IOException ex) {
                            }
                            marketingInfo.setContactUsFilled(done);
                            break;
                        }
                    }
                }
            }
        }
        return marketingInfo;
    }

    private String getEmailFromPage(String pageSource) {
        Pattern validEmailAddresses = Pattern.compile("mailTo:[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = validEmailAddresses.matcher(pageSource);
        if (matcher.find()) {
            return matcher.group(0).replace("mailto:", "");
        } else {
            return null;
        }
    }

    private boolean fillOutTheContactUsForm(WebDriver driver) throws URISyntaxException, IOException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> inputs = null;
        List<WebElement> buttons = null;
        WebElement textArea = null;
        try {
            inputs = driver.findElements(By.xpath("//form//input"));
        } catch (NoSuchElementException ex) {
        }
        try {
            buttons = driver.findElements(By.xpath("//form//button"));
        } catch (NoSuchElementException ex) {
        }
        try {
            textArea = driver.findElement(By.xpath("//form//textarea"));
        } catch (NoSuchElementException ex) {
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
        List<WebElement> textboxes = filterTextboxesFromInputs(inputs);
        List<WebElement> inputButtons = filterButtonsFromInputs(inputs);

        fillOutTheTextBoxes(textboxes);
        fillOutTheTextArea(textArea);
        if (inputButtons.isEmpty()) {
            clickTheSubmitButton(buttons);
        } else {
            clickTheInputSubmitButton(inputButtons);
        }
        if (driver.getPageSource().contains("Thank You")) {
            return true;
        } else {
            return false;
        }
    }

    private List<WebElement> filterTextboxesFromInputs(List<WebElement> inputs) {
        return filterInputsByType(inputs, "text");
    }

    private List<WebElement> filterButtonsFromInputs(List<WebElement> inputs) {
        return filterInputsByType(inputs, "submit");
    }

    private Map<String, String> getAllAttributes(WebElement input) {
        return (Map<String, String>) ((JavascriptExecutor) DriverFactory.getDriver()).executeScript("var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;", input);
    }

    private List<WebElement> filterInputsByType(List<WebElement> inputs, String type) {
        List<WebElement> tbs = new ArrayList<>();
        for (WebElement input : inputs) {
            if (getAllAttributes(input).get("type").equalsIgnoreCase(type)) {
                tbs.add(input);
            }
        }
        return tbs;
    }

    private void fillOutTheTextBoxes(List<WebElement> textboxes) {
        for (WebElement textbox : textboxes) {
            Map<String, String> attribs = getAllAttributes(textbox);
            addToTheInputTextBox(attribs, textbox, "Name");
            addToTheInputTextBox(attribs, textbox, "Email");
            addToTheInputTextBox(attribs, textbox, "Subject");
        }
    }

    private void fillOutTheTextArea(WebElement textArea) throws URISyntaxException, IOException {
        File file = new File(Res.getResource("messages").toURI());
        Random rand = new Random();
        int rnd = rand.nextInt(file.listFiles().length);
        File txtFile = new File(Res.getResource("messages/message" + rnd + ".txt").toURI());
        String message = FileUtils.readFileToString(txtFile);

        textArea.sendKeys(message);
    }

    private void clickTheInputSubmitButton(List<WebElement> buttons) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void clickTheSubmitButton(List<WebElement> buttons) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void addToTheInputTextBox(Map<String, String> attribs, WebElement textbox, String info) {
        if (attribs.containsKey("id")) {
            if (attribs.get("id").toUpperCase().contains(info.toUpperCase())) {
                textbox.sendKeys(DataMaps.dataMaps.get(info));
            }
        } else if (attribs.containsKey("name")) {
            if (attribs.get("name").toUpperCase().contains(info.toUpperCase())) {
                textbox.sendKeys(DataMaps.dataMaps.get(info));
            }
        } else {
            for (Map.Entry<String, String> attrib : attribs.entrySet()) {
                if (attrib.getValue().contains(info)) {
                    textbox.sendKeys(DataMaps.dataMaps.get(info));
                    break;
                }
            }
        }
    }
}
