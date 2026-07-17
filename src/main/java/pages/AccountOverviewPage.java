package pages;

import java.util.ArrayList;
import java.util.List;

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
    private final By accountOverviewButton = By
	    .xpath("//a[@href='overview.htm' and contains(text(),'Accounts Overview')]");
    private final By firstAccountNumber = By.xpath("(//a[contains(@href,'activity.htm?id=')])[1]");

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

    public int getFirstAccountNumber() {
	return Integer.parseInt(getText(firstAccountNumber));
    }

    public boolean isAccountOverviewDisplayed() {
	return isDisplayed(accountsOverviewHeading);
    }

    public void clickOnAccountOverviewButton() {
	click(accountOverviewButton);
    }

    public List<Integer> getBalanceAndAvailableAmount(int accountNumber) {
	String accountNumb = String.valueOf(accountNumber);
	System.out.println("Account number: " + accountNumber);
	// 1. Define the By locators dynamically based on the account number
	By balanceLocator = By
		.xpath("//a[starts-with(@href, 'activity.htm?id=" + accountNumb + "')]/ancestor::tr/td[2]");
	By availableLocator = By
		.xpath("//a[starts-with(@href, 'activity.htm?id=" + accountNumb + "')]/ancestor::tr/td[3]");

	// 2. Retrieve the text using the By locators
	String balanceText = getWebElement(balanceLocator).getText();
	String availableText = getWebElement(availableLocator).getText();

	// 3. Clean the strings and convert to integers
	int balance = (int) Double.parseDouble(balanceText.replace("$", "").replace(",", ""));
	int available = (int) Double.parseDouble(availableText.replace("$", "").replace(",", ""));

	// 4. Pack and return
	List<Integer> amounts = new ArrayList<>();
	amounts.add(balance);
	amounts.add(available);

	return amounts;
    }

}
