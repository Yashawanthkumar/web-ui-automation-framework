package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.LogManagerUtil;
import utils.ScreenshotUtils;
import base.WebDriverManager;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        LogManagerUtil.info("Test Suite Started: " + context.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogManagerUtil.info("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogManagerUtil.error("Test Failed: " + result.getName());
        ScreenshotUtils.captureScreenshot(result.getName(), WebDriverManager.getDriver());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogManagerUtil.warn("Test Skipped: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        LogManagerUtil.info("Test Suite Finished: " + context.getName());
    }
}
