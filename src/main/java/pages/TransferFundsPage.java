package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class TransferFundsPage extends BasePage {

    private final By enterAmmount = By.id("amount");
    private final By fromAccount = By.xpath("//select[@id='fromAccountId']");
    private final By transferComplete = By.xpath("//h1[text()='Transfer Complete!']");
    private final By ammountResult = By.xpath("//span[@id='amountResult']");
    private final By fromAccountResult = By.id("fromAccountIdResult");
    private final By toAccountResult = By.id("toAccountIdResult");
    private final By tranferBtn = By.xpath("//input[@value='Transfer']");
    private final By transferFundsButton = By.xpath("//a[@href='transfer.htm' and contains(text(),'Transfer Funds')]");

    public void ClickOnTransferFundsButton() {
	click(transferFundsButton);
    }

    public void enterAmmountForTransfer(String amount) {
	type(enterAmmount, amount);
    }

    private final By toAccount = By.id("toAccountId");

    public void clickOnTranferFundButton() {
	click(tranferBtn);
    }

    public void selectFromAccount(String fromAccountNumber) {
	Select select = new Select(getWebElement(fromAccount));
	select.selectByVisibleText(fromAccountNumber);
    }

    public void selectToAccount(String accountNumber) {
	Select select = new Select(getWebElement(toAccount));
	select.selectByVisibleText(accountNumber);
    }

    public String getSucssfullTransferFundMessage() {
	return getText(transferComplete);
    }

    public String validateTransferAmmount() {
	// Grabs everything before the decimal point and removes the "$"
	return getText(ammountResult).split("\\.")[0].replace("$", "");
    }

    public int getFromAccountNumber() {
	return Integer.parseInt(getText(fromAccountResult));
    }

    public int getToAccountNumber() {
	return Integer.parseInt(getText(toAccountResult));
    }

}
