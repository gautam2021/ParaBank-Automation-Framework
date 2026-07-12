package factory;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ConfigReader;

public class WaitManager {
    private static final ThreadLocal<WebDriverWait> thWait = new ThreadLocal<>();
    private static final Duration WAIT_DURATION = Duration
	    .ofSeconds(Long.parseLong(ConfigReader.getProperty("explicitWait")));

    // get wait
    public static WebDriverWait getWait() {
	if (thWait.get() == null) {
	    thWait.set(new WebDriverWait(DriverManager.getDriver(), WAIT_DURATION));
	}
	return thWait.get();
    }

    // remove wait
    public static void removeWait() {
	thWait.remove();

    }
}