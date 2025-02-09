package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import utils.LogManagerUtil;

public class RetryListener implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            LogManagerUtil.warn("Retrying test: " + result.getName() + " | Attempt: " + retryCount);
            return true;
        }
        return false;
    }
}
