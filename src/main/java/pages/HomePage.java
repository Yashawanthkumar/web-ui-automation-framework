package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class HomePage extends BasePage {
    private By dashboardHeading = By.xpath("//h1[contains(text(), 'Dashboard')]");

    public HomePage() {
    	super();
    }

    public boolean isDashboardDisplayed() {
        return isElementDisplayed(dashboardHeading);
    }
}
