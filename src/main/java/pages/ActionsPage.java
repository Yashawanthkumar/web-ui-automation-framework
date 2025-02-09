package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class ActionsPage extends BasePage {
    private By hoverElement = By.id("hover");
    private By hiddenButton = By.id("hiddenButton");
    private By successMessage = By.id("successMessage");

    public ActionsPage() {
    	super();
    }

    public void hoverOverElement() {
        hoverOverElement(hoverElement);
    }

    public void clickOnHiddenButton() {
        click(hiddenButton);
    }

    public boolean isSuccessMessageDisplayed() {
        return isElementDisplayed(successMessage);
    }
}
