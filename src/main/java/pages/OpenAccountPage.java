package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;
import utility.ConfigReader;

public class OpenAccountPage extends BasePage {

    private final By openNewAccountBtn = By.xpath("//a[@href='openaccount.htm']");
    private final By dropDown = By.id("type");
    private final By fromAccountId = By.id("fromAccountId");
   
    private final By openAccountBtn = By.xpath("//input[@value='Open New Account']");
    private final By sucessMessage = By.xpath("//div[@id='openAccountResult']//p[contains(text(),'Congratulations')]");
    private final By createdAccountNumber = By.xpath("//div[@id='openAccountResult']//a");
    private final By firstAccountNumber =
	        By.xpath("(//a[contains(@href,'activity.htm?id=')])[1]");

    public void openNewAccount() {
	click(openNewAccountBtn);
    }

    public int getFirstAccountNumber() {
	    return Integer.parseInt(getText(firstAccountNumber));
	}
    public void selectAccountNumber(String accountNumber) {
	    Select select = new Select(getWebElement(fromAccountId));
	    select.selectByVisibleText(accountNumber);
	}
    public void selectSavingAccount() {
	Select selectAccountType = new Select(getWebElement(dropDown));
	click(dropDown);
	selectAccountType.selectByVisibleText(ConfigReader.getProperty("savingAccount"));
    }
    public void selectCheckingAccount() {
	Select selectAccountType = new Select(getWebElement(dropDown));
	click(dropDown);
	selectAccountType.selectByVisibleText(ConfigReader.getProperty("checkingAccount"));
    }

  

    public OpenAccountPage openAccount() {
	click(openAccountBtn);
	return this;
    }

    public String getAccountOpenSuccessMessage() {
	return getText(sucessMessage);
    }

    public int getCreatedAccountNumber() {
	return Integer.parseInt(getText(createdAccountNumber));
	
    }
}
