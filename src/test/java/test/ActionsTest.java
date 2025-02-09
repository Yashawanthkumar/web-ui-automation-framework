package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ActionsPage;

public class ActionsTest extends BaseTest {
    private ActionsPage actionsPage;

    @Test(priority = 1)
    public void testHoverAndClick() {
        driver.get("https://example.com/actions");
        actionsPage = new ActionsPage();

        actionsPage.hoverOverElement();
        actionsPage.clickOnHiddenButton();

        Assert.assertTrue(actionsPage.isSuccessMessageDisplayed(), "Action failed");
    }
}
