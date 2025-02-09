package base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.ConfigReader;

public class WebDriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            initializeDriver();
        }
        return driver.get();
    }

    private static void initializeDriver() {
        // Fetch environment dynamically
        String environment = ConfigReader.getEnvironment(); // Now using the updated ConfigReader

        System.out.println("Running tests on: " + environment);

        if ("docker".equalsIgnoreCase(environment)) {
            try {
                URL gridUrl = new URL("http://localhost:4444/wd/hub"); // Adjust Grid URL if needed
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName("chrome");
                driver.set(new RemoteWebDriver(gridUrl, capabilities));
            } catch (MalformedURLException e) {
                throw new RuntimeException("Failed to connect to Selenium Grid", e);
            }
        } else {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
            driver.set(new ChromeDriver());
        }
    }


    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
