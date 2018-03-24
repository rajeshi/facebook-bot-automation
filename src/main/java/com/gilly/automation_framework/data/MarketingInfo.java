package com.gilly.automation_framework.data;

/**
 *
 * @author abc
 */
public class MarketingInfo {
    String email;
    boolean emailSent;
    boolean contactUsFilled;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmailSent() {
        return emailSent;
    }

    public void setEmailSent(boolean emailSent) {
        this.emailSent = emailSent;
    }

    public boolean isContactUsFilled() {
        return contactUsFilled;
    }

    public void setContactUsFilled(boolean contactUsFilled) {
        this.contactUsFilled = contactUsFilled;
    }

}
