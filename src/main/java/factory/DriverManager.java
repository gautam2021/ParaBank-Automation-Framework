package factory;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
    private DriverManager() {
    }

    private static final ThreadLocal<WebDriver> thDriver = new ThreadLocal<>();

    // set driver
    public static void setDriver(WebDriver driver) {
	thDriver.set(driver);
    }

    // get driver
    public static WebDriver getDriver() {
	return thDriver.get();
    }

    // quit driver
    public static void quitDriver() {
	if (thDriver.get() != null)

	{
	    thDriver.get().quit();
	    thDriver.remove();
	}
    }
}
