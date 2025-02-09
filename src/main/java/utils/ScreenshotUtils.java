package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {
    
    public static void captureScreenshot(String testName, WebDriver driver) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String filePath = "screenshots/" + testName + "_" + timestamp + ".png";
            
            FileUtils.copyFile(srcFile, new File(filePath));
            LogManagerUtil.info("Screenshot captured: " + filePath);
        } catch (IOException e) {
            LogManagerUtil.error("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
