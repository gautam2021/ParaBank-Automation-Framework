package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import base.BasePage;
import utility.LoggerUtil;

public class AccountOverviewPage extends BasePage {

    private static final Logger logger = LoggerUtil.getLogger(AccountOverviewPage.class);
    private final By confirmUserName = By.xpath("//div[@id='rightPanel']//h1[@class='title']");
    private final By sucessMessage = By.xpath("//div[@id='rightPanel']//p");
    private final By logoutBtn = By.xpath("//a[text()='Log Out']");
    private final By accountsOverviewHeading = By.xpath("//h1[contains(.,'Accounts Overview')]");

    public String getWelcomeMessage() {
	return getText(confirmUserName);
    }

    public String getSuccessMessage() {
	return getText(sucessMessage);
    }

    public HomePage logout() {
	logger.info("Logging out user");
	click(logoutBtn);
	return new HomePage();
    }

    public boolean isAccountOverviewDisplayed() {
	return isDisplayed(accountsOverviewHeading);
    }

  
}
