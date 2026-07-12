package factory;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.LoggerUtil;

public final class BrowserFactory {

    private final static Logger logger = LoggerUtil.getLogger(BrowserFactory.class);

    private BrowserFactory() {
	// Prevent instantiation
    }

    public static WebDriver getBrowser(String browserName) {

	WebDriver driver;

	switch (browserName.toLowerCase()) {

	case "chrome":
	    logger.info("Launching Chrome Browser");
	    WebDriverManager.chromedriver().setup();

	    ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.setExperimentalOption("prefs", getChromePreferences());
	    chromeOptions.addArguments("--disable-save-password-bubble");

	    boolean isCI = System.getenv("CI") != null;

	    if (isCI) {

		logger.info("Running in GitHub Actions - Launching Headless Chrome");

		chromeOptions.addArguments("--headless=new");
		chromeOptions.addArguments("--no-sandbox");
		chromeOptions.addArguments("--disable-dev-shm-usage");
		chromeOptions.addArguments("--window-size=1920,1080");
	    }

	    driver = new ChromeDriver(chromeOptions);
	    break;

	case "edge":
	    logger.info("Launching Edge Browser");
	    WebDriverManager.edgedriver().setup();

	    EdgeOptions edgeOptions = new EdgeOptions();
	    edgeOptions.setExperimentalOption("prefs", getChromePreferences());
	    edgeOptions.addArguments("--disable-save-password-bubble");

	    driver = new EdgeDriver(edgeOptions);
	    break;

	case "firefox":
	    logger.info("Launching Firefox Browser");
	    WebDriverManager.firefoxdriver().setup();

	    FirefoxOptions firefoxOptions = new FirefoxOptions();

	    driver = new FirefoxDriver(firefoxOptions);
	    break;

	default:
	    logger.error("Unsupported Browser: " + browserName);
	    throw new IllegalArgumentException("Unsupported Browser: " + browserName);
	}

	return driver;
    }

    private static Map<String, Object> getChromePreferences() {

	Map<String, Object> prefs = new HashMap<>();

	// Disable Save Address popup
	prefs.put("autofill.profile_enabled", false);

	// Disable Password Manager
	prefs.put("credentials_enable_service", false);
	prefs.put("profile.password_manager_enabled", false);

	// Disable Browser Notifications
	prefs.put("profile.default_content_setting_values.notifications", 2);

	return prefs;
    }
}