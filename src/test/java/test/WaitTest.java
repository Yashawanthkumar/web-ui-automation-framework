package test;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.WaitPage;

public class WaitTest extends BaseTest {
    private WaitPage waitPage;

    @Test(priority = 1)
    public void testExplicitWait() {
        driver.get("https://example.com/wait");
        waitPage = new WaitPage();

    }
}
