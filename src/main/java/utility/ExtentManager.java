package utility;

import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private final static Logger logger = LoggerUtil.getLogger(ExtentManager.class);
    private static ExtentReports extent;

    private ExtentManager() {
	// avoid object creation
    }

    public static ExtentReports getExtentReport() {
	if (extent == null) {
	    ExtentSparkReporter sparkReport = new ExtentSparkReporter("report/extentReport.html");
	    sparkReport.config().setDocumentTitle("ParaBank Automation Report");
	    sparkReport.config().setDocumentTitle("UI Automation Report- ParaBank");

	    extent = new ExtentReports();
	    extent.attachReporter(sparkReport);

	    extent.setSystemInfo("Author", "Mohit-SDET");
	    extent.setSystemInfo("Framework", "Selenium Java-TestNG");
	    extent.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
	    extent.setSystemInfo("Environment", "QA");

	    logger.info("Extent Report Initialized");
	}
	return extent;
    }
}
