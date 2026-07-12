package utility;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    private ExtentTestManager() {
	// prevent object creation
    }

    // set test
    public static void setTest(ExtentTest test) {
	extentTest.set(test);
    }

    // get test
    public static ExtentTest getTest() {
	return extentTest.get();
    }

    // unload test
    public static void removeTest() {
	extentTest.remove();
    }

}
