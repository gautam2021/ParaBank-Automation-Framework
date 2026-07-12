package tests;

import java.lang.reflect.Method;
import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import factory.BrowserFactory;
import factory.DriverManager;
import factory.WaitManager;
import utility.ConfigReader;
import utility.DataUtil;
import utility.LoggerUtil;

public class BaseTest {

    private static final Logger logger = LoggerUtil.getLogger(BaseTest.class);

    @BeforeMethod
    public void setup(Method method) {

	logger.info("Launching {} Browser", ConfigReader.getProperty("browser"));

	// setup
	DriverManager.setDriver(BrowserFactory.getBrowser(ConfigReader.getProperty("browser")));
	DriverManager.getDriver().manage().window().maximize();
	DriverManager.getDriver().get(ConfigReader.getProperty("url"));
	DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

    }

    // teardown
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
	logger.info("Closing Browser");

	WaitManager.removeWait();
	DriverManager.quitDriver();
	DataUtil.clearCustomer();
    }
}
