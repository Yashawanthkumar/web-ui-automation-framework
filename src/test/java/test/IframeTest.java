package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.IframePage;

public class IframeTest extends BaseTest {
    private IframePage iframePage;

    @Test(priority = 1)
    public void testSwitchToIframe() {
        driver.get("https://example.com/iframe");
        iframePage = new IframePage();

        iframePage.switchToframe();
        String textInsideIframe = iframePage.getIframeText();

        Assert.assertEquals(textInsideIframe, "Expected Text", "Iframe text mismatch");
        
        // Switch back to the main page
        iframePage.switchToDefaultContent();
    }
}