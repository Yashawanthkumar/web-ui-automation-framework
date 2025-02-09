package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class IframePage extends BasePage {
    private By iframe = By.id("iframeId");
    private By iframeText = By.tagName("p");

    public IframePage() {
    	super();
    }

    public void switchToframe() {
    	switchToIFrame(iframe);
    }

    public String getIframeText() {
        return getText(iframeText);
    }
    
    public void switchToDefaultContent() {
    	mainswitchToDefaultContent();
    }
}
