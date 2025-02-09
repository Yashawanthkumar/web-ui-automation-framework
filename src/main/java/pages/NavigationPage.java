package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class NavigationPage extends BasePage {
    private By contactPageLink = By.linkText("Contact");

    public NavigationPage() {
    	super();
    }

    public void navigateToContactPage() {
        click(contactPageLink);
    }

    public boolean isContactPageDisplayed() {
        return getPageTitle().contains("Contact");
    }
}
