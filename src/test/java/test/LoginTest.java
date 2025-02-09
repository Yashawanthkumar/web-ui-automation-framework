package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.LoginPageFactory;
import utils.ConfigReader;

public class LoginTest extends BaseTest  {
    private LoginPage loginPage;
    private LoginPageFactory loginPageFactory;
    private static final Logger logger = LogManager.getLogger(LoginTest.class);

    @Test(priority = 1, retryAnalyzer = listeners.RetryListener.class)
    public void testLoginWithPOM() {
        loginPage = new LoginPage();
        logger.info("Testing login with Page Object Model");
        loginPage.enterUsername(ConfigReader.getProperty("validUsername"));
        loginPage.enterPassword(ConfigReader.getProperty("validPassword"));
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getPageTitle(), "Dashboard", "Login Failed using POM");
        logger.info("Login successful using POM");
    }

    @Test(priority = 2)
    public void testLoginWithPageFactory() {
        logger.info("Testing login with Page Factory");
        loginPageFactory.enterUsername(ConfigReader.getProperty("validUsername"));
        loginPageFactory.enterPassword(ConfigReader.getProperty("validPassword"));
        loginPageFactory.clickLogin();
        Assert.assertEquals(loginPageFactory.getPageTitle(), "Dashboard", "Login Failed using Page Factory");
        logger.info("Login successful using Page Factory");
    }
}