package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class MultipleWindowsPage extends BasePage{
    private By newWindowButton = By.id("newWindow");

    public MultipleWindowsPage() {
        super();
    }

    public void clickNewWindowButton() {
        click(newWindowButton);
    }

    public boolean isNewWindowDisplayed() {
        return getPageTitle().contains("New Window");
    }
    
    public void switchToNewWindow() {
    	mainSwitchToNewWindow();
    }
}
