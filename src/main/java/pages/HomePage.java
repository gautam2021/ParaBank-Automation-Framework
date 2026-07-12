package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import base.BasePage;
import utility.LoggerUtil;

public class HomePage extends BasePage {
    private static final Logger logger = LoggerUtil.getLogger(HomePage.class);
    
    private final By createAccountRegistration = By.xpath("//a[contains(@href,'register.htm')]");

    public RegistrationPage createAccount() {
	logger.info("Going to create an Account");
	click(createAccountRegistration);
	return new RegistrationPage();
    }

    public LoginPage navigateToLoginPage() {
	return new LoginPage();
    }
}
