package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class WaitPage extends BasePage {

	public WaitPage() {
		super();
	}

	// Explicit Wait: Wait until the element is visible
	public void waitForElementVisible(By locator, int timeoutInSeconds) {
		explicitWaitToVisible(locator, timeoutInSeconds);
	}

	// Explicit Wait: Wait until the element is clickable
	public void waitForElementClickable(By locator, int timeoutInSeconds) {
		explicitWaitToClickable(locator, timeoutInSeconds);
	}

	// Fluent Wait: Custom wait with polling time
	public WebElement customWaitWithPollingTime(By locator, int timeoutInSeconds, int pollingTime) {
		return fluentWaitForElement(locator, timeoutInSeconds, pollingTime);
	}

	// Implicit Wait: Apply implicit wait
	public void setImplicitWait(int seconds) {
		implicitWait(seconds);
	}

	// Static Wait (Thread.sleep) - Use only if necessary
	public void staticWait(int milliseconds) {
		staticWait(milliseconds);
	}
}
