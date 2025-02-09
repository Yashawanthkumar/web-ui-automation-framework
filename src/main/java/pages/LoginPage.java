package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class LoginPage extends BasePage {
	private final By usernameField = By.id("username");
	private final By passwordField = By.id("password");
	private final By loginButton = By.id("loginButton");

	public LoginPage() {
		super();
	}

	public void enterUsername(String username) {
		enterText(usernameField, username); // Using BasePage method
	}

	public void enterPassword(String password) {
		enterText(passwordField, password); // Using BasePage method
	}

	public void clickLogin() {
		click(loginButton); // Using BasePage method
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
}
