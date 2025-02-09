package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;

public class ScreenshotTest extends BaseTest {
    private HomePage homePage;

    @Test(priority = 1)
    public void testTakeScreenshot() {
        driver.get("https://example.com/home");
        homePage = new HomePage();

        String screenshotPath = homePage.captureScreenshot(driver, "homePage");

        Assert.assertNotNull(screenshotPath, "Screenshot failed");
    }
}
