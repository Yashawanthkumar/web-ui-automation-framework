package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.MultipleWindowsPage;

public class MultipleWindowsTest extends BaseTest {
    private MultipleWindowsPage multipleWindowsPage;

    @Test(priority = 1)
    public void testSwitchToNewWindow() {
        driver.get("https://example.com/windows");
        multipleWindowsPage = new MultipleWindowsPage();

        String mainWindow = driver.getWindowHandle();
        multipleWindowsPage.clickNewWindowButton();
        multipleWindowsPage.switchToNewWindow();

        Assert.assertTrue(multipleWindowsPage.isNewWindowDisplayed(), "New window is not displayed");

        // Close new window and switch back
        driver.close();
        driver.switchTo().window(mainWindow);
    }
}
