package com.gilly.automation_framework.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class Configurations {

    public static final String BROWSER = getProp().getProperty("gilly.browser");//"ANDROID";
    public static final boolean REMOTE = Boolean.parseBoolean(getProp().getProperty("gilly.remote"));//false;
    public static String TEST_TYPE = getProp().getProperty("gilly.test_type");//"MOBILE";
    public static long TIME_OUT_SECONDS = Long.parseLong(getProp().getProperty("gilly.timeout.seconds"));
    public static String CHROME_DRIVER_EXE = getProp().getProperty("gilly.chrome.driver");
    public static String FIREFOX_DRIVER_EXE = getProp().getProperty("gilly.gecko.driver");
    public static String IE_DRIVER_EXE = getProp().getProperty("gilly.ie.driver");
    public static String FACEBOOK_EMAIL = getProp().getProperty("gilly.facebook.email");
    public static String FACEBOOK_PASSWORD = getProp().getProperty("gilly.facebook.password");
    public static String GMAIL_ID = getProp().getProperty("gilly.gmail.id");
    public static String GMAIL_PASSWORD = getProp().getProperty("gilly.gmail.password");
    public static String KEYWORD = getProp().getProperty("gilly.keyword");

    private static Properties prop;
    private static HashMap<String, String> urlMap;
    public static String SELENIUM_GRID_URL = getProp().getProperty("gilly.hub.url");

    private static Properties getProp() {

        if (prop == null) {
            prop = new Properties();
            InputStream input = null;

            try {
                input = new FileInputStream(new File(Res.getResource("system.properties").toURI()));
                prop.load(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return prop;
    }
}
