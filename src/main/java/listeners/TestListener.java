package listeners;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utility.ExtentManager;
import utility.ExtentTestManager;
import utility.LoggerUtil;
import utility.ScreenshotUtil;

public class TestListener implements ITestListener {

    private static final Logger logger = LoggerUtil.getLogger(TestListener.class);
    private ExtentReports extent;

    @Override
    public void onStart(ITestContext context) {

	extent = ExtentManager.getExtentReport();

    }

    @Override
    public void onTestStart(ITestResult result) {

	logger.info("");
	logger.info("====================================================");
	logger.info("STARTING TEST : {}.{}", result.getTestClass().getRealClass().getSimpleName(),
		result.getMethod().getMethodName());
	logger.info("====================================================");
	ExtentTest test = extent.createTest(
		result.getTestClass().getRealClass().getSimpleName() + "." + result.getMethod().getMethodName());
	ExtentTestManager.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

	logger.info("====================================================");
	logger.info("TEST PASSED : {}.{}", result.getTestClass().getRealClass().getSimpleName(),
		result.getMethod().getMethodName());
	logger.info("====================================================");
	ExtentTestManager.getTest().pass("Test Passed");
	ExtentTestManager.removeTest();
    }

    @Override
    public void onTestFailure(ITestResult result) {

	logger.info("====================================================");
	logger.info("TEST FAILED : {}.{}", result.getTestClass().getRealClass().getSimpleName(),
		result.getMethod().getMethodName());

	logger.error(result.getThrowable());
	String path = ScreenshotUtil.captureScreenshot(result.getMethod().getMethodName());
	logger.error("Screenshot Saved : {}", path);

	ExtentTestManager.getTest().fail(result.getThrowable());
	ExtentTestManager.getTest().addScreenCaptureFromPath(path);
	logger.error("====================================================");
	ExtentTestManager.removeTest();

    }

    @Override
    public void onTestSkipped(ITestResult result) {

	logger.info("====================================================");
	logger.info("TEST SKIPPED : {}.{}", result.getTestClass().getRealClass().getSimpleName(),
		result.getMethod().getMethodName());
	ExtentTestManager.getTest().skip("Test Skipped");
	logger.info("====================================================");
	ExtentTestManager.removeTest();
    }

    @Override
    public void onFinish(ITestContext context) {

	extent.flush();
	logger.info("Extent Report generated successfully.");

    }

}
