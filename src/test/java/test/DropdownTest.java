package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DropDownPage;

public class DropdownTest extends BaseTest {
    private DropDownPage dropdownPage;

    @Test(priority = 1)
    public void testSelectDropdownValue() {
        driver.get("https://example.com/dropdown");
        dropdownPage = new DropDownPage();

        dropdownPage.selectOptionByValue("Option1");

        Assert.assertEquals(dropdownPage.getSelectedOption(), "Option1", "Dropdown selection failed");
    }
}
