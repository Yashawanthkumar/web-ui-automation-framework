package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;

public class AlertTest extends BaseTest {
    private AlertsPage alertsPage;

    @Test
    public void testHandleAlert() {
        driver.get("https://example.com/alerts");
        alertsPage = new AlertsPage();
        
        alertsPage.clickAlertButton();
        String alertText = alertsPage.getAlertTextAndAccept();

        Assert.assertEquals(alertText, "Expected Alert Text", "Alert text mismatch");
    }
}
