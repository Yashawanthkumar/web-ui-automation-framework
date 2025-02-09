package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.NavigationPage;

public class NavigationTest extends BaseTest {
    private NavigationPage navigationPage;
    private HomePage homePage;

    @Test(priority = 1)
    public void testBrowserNavigation() {
        driver.get("https://example.com/home");
        homePage = new HomePage();
        navigationPage = new NavigationPage();

        navigationPage.navigateToContactPage();
        Assert.assertTrue(navigationPage.isContactPageDisplayed(), "Navigation failed");

        driver.navigate().back();
        Assert.assertTrue(homePage.isDashboardDisplayed(), "Back navigation failed");

        driver.navigate().forward();
        Assert.assertTrue(navigationPage.isContactPageDisplayed(), "Forward navigation failed");
    }
}
