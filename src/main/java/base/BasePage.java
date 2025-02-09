package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;

	protected BasePage() {
		this.driver = WebDriverManager.getDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	protected boolean isElementDisplayed(By locator) {
		try {
			return wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator))).isDisplayed();
		} catch (Exception e) {
			return false; // Returns false if element is not found or not visible
		}
	}

	protected void staticWait(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	public void mainswitchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
	
	protected void implicitWait(int timeoutInSeconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeoutInSeconds));
	}

	protected void explicitWaitToVisible(By locator, int timeoutInSeconds) {
		new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	protected void explicitWaitToClickable(By locator, int timeoutInSeconds) {
		new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
				.until(ExpectedConditions.elementToBeClickable(locator));
	}

	protected WebElement fluentWaitForElement(By locator, int timeoutInSeconds, int pollingTime) {
		return new org.openqa.selenium.support.ui.FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeoutInSeconds))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(Exception.class)
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Common method to wait for an element to be visible
	protected WebElement waitForElementToBeVisible(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Common method to enter text
	protected void enterText(WebElement element, String text) {
		WebElement ele = waitForElementToBeVisible(element);
		ele.clear();
		ele.sendKeys(text);
	}

	// Common method to get page title
	protected String getPageTitle() {
		return driver.getTitle();
	}

	protected void click(By locator) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator))
				.click();
	}

	// Enter Text
	protected void enterText(By locator, String text) {
		WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(text);
	}

	// Get Text
	protected String getText(By locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
	}

	// Wait for Element to be Visible
	protected void waitForVisibility(By locator) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Accept Alert
	protected void acceptAlert() {
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent()).accept();
	}

	public String acceptAndGetAlertText(By locator) {
		Alert alert = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
		String text = alert.getText();
		alert.accept();
		return text;
	}

	// Switch to Frame
	protected void switchToIFrame(By frameLocator) {
		driver.switchTo().frame(driver.findElement(frameLocator));
	}

	// Switch to Default Frame
	protected void switchToDefault() {
		driver.switchTo().defaultContent();
	}

	// Take Screenshot
	protected void takeScreenshot(String filePath) {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir") + "/screenshots/" + filePath + ".png");

		try {
			// Copy file to destination
			FileUtils.copyFile(srcFile, destFile);
			System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
		} catch (IOException e) {
			System.err.println("Error while saving screenshot: " + e.getMessage());
		}
	}

	// Select dropdown by value
	public void selectByValue(By locator, String value) {
		WebElement dropdown = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
		new Select(dropdown).selectByValue(value);
	}

	// Select from Drop-down by Visible Text
	protected void selectByVisibleText(By locator, String text) {
		Select dropdown = new Select(driver.findElement(locator));
		dropdown.selectByVisibleText(text);
	}

	// Get selected option text from dropdown
	public String getSelectedOptionText(By locator) {
		WebElement dropdown = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return new Select(dropdown).getFirstSelectedOption().getText();
	}

	// Hover Over Element
	protected void hoverOverElement(By locator) {
		WebElement element = driver.findElement(locator);
		new Actions(driver).moveToElement(element).perform();
	}

	// Switch to New Window
	protected void mainSwitchToNewWindow() {
		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
		}
	}
	
	//Take screenshot of Driver/Web element
	public static String captureScreenshot(WebDriver driver, String fileName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String filePath = "screenshots/" + fileName + ".png";
        try {
            FileUtils.copyFile(srcFile, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }
}
