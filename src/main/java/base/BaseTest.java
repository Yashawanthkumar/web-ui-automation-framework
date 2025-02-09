package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utils.ConfigReader;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl = ConfigReader.getBaseUrl();

    @BeforeClass
    public void setUp() {
        driver = WebDriverManager.getDriver();
        driver.get(baseUrl);
    }

    @AfterClass
    public void tearDown() {
        WebDriverManager.quitDriver();
    }
}