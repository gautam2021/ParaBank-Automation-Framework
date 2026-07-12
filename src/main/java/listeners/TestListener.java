package listeners;

import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utility.LoggerUtil;
import utility.ScreenshotUtil;

public class TestListener implements ITestListener {

    private static final Logger logger = LoggerUtil.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {

	logger.info("");
	logger.info("====================================================");
	logger.info("STARTING TEST : {}.{}", result.getTestClass().getRealClass().getSimpleName(),
		result.getMethod().getMethodName());
	logger.info("====================================================");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

	logger.info("====================================================");
	logger.info("TEST PASSED : {}.{}", result.getTestClass().getRealClass().getSimpleName(),
		result.getMethod().getMethodName());
	logger.info("====================================================");
    }

    @Override
    public void onTestFailure(ITestResult result) {

	logger.info("====================================================");
	logger.info("TEST FAILED : {}.{}", result.getTestClass().getRealClass().getSimpleName(),
		result.getMethod().getMethodName());

	logger.error(result.getThrowable());
	String path = ScreenshotUtil.captureScreenshot(result.getMethod().getMethodName());
	logger.error("Screenshot Saved : {}", path);

	logger.error("====================================================");

    }

    @Override
    public void onTestSkipped(ITestResult result) {

	logger.info("====================================================");
	logger.info("TEST SKIPPED : {}.{}", result.getTestClass().getRealClass().getSimpleName(),
		result.getMethod().getMethodName());
	logger.info("====================================================");
    }

}
