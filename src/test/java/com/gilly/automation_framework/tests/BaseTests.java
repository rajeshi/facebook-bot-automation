package com.gilly.automation_framework.tests;

import com.gilly.automation_framework.base.DriverFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import net.lightbody.bmp.BrowserMobProxy;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class BaseTests extends Assert {

    public BrowserMobProxy proxy;

    @BeforeMethod
    public void setupTest() throws MalformedURLException {
        DriverFactory.createWebDriverInstance();
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownTest(ITestResult itr) throws IOException {
        if (DriverFactory.getDriver() == null) {
        } else {
            DriverFactory.getHttpTraffic();
            if (itr.isSuccess()) {
            } else {
                Screenshot screenshot = new AShot()
                        .takeScreenshot(DriverFactory.getDriver());
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                File file = new File(System.getProperty("user.dir") + "");
                File fileScr = new File(file.getAbsolutePath() + "/target/surefire-reports/screenshots/" + itr.getMethod().getMethodName() + "_" + itr.getStartMillis() + ".png");
                ImageIO.write(screenshot.getImage(), "PNG", baos);
                FileUtils.writeByteArrayToFile(fileScr, baos.toByteArray());
            }
        }
        DriverFactory.getDriver().quit();
    }
}
