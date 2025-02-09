package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class AlertsPage extends BasePage{
    private By alertButton = By.id("alertButton");

    public AlertsPage() {
    	super();
    }

    public void clickAlertButton() {
        click(alertButton);
    }

    public String getAlertTextAndAccept() {
        return acceptAndGetAlertText(alertButton);
    }
}
