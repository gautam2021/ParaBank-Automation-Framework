package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AccountOverviewPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OpenAccountPage;
import pages.TransferFundsPage;
import utility.ConfigReader;
import utility.DataUtil;
import utility.UserRegistrationHelper;

public class TransferFundsTest extends BaseTest {

    @Test
    public void transferFund() {

        // Step 1 - Register User
        AccountOverviewPage accountOverviewPage = UserRegistrationHelper.createUser();

        // Step 2 - Logout
        HomePage homePage = accountOverviewPage.logout();

        // Step 3 - Login
        LoginPage loginPage = homePage.navigateToLoginPage();

        accountOverviewPage = loginPage.loginAsValidUser(
                DataUtil.getCustomer().getUsername(),
                DataUtil.getCustomer().getPassword());

        Assert.assertTrue(accountOverviewPage.isAccountOverviewDisplayed(),
                "Account Overview page should be displayed");

        // Step 4 - Get the existing (default) account BEFORE creating a new one
        accountOverviewPage.clickOnAccountOverviewButton();

        int defaultAccount = accountOverviewPage.getFirstAccountNumber();

        System.out.println("Default Account : " + defaultAccount);

        // Step 5 - Open a new Savings Account
        OpenAccountPage openAccountPage = new OpenAccountPage();

        openAccountPage.openNewAccount();
        openAccountPage.selectSavingAccount();
        openAccountPage.openAccount();

        Assert.assertTrue(
                openAccountPage.getAccountOpenSuccessMessage()
                        .contains("Congratulations"),
                "Account should be created successfully");

        int newAccount = openAccountPage.getCreatedAccountNumber();

        System.out.println("New Account : " + newAccount);

        // Step 6 - Get balance before transfer
        accountOverviewPage.clickOnAccountOverviewButton();

        List<Integer> beforeBalance =
                accountOverviewPage.getBalanceAndAvailableAmount(newAccount);

        // Step 7 - Transfer Funds
        TransferFundsPage transferFundsPage = new TransferFundsPage();

        transferFundsPage.ClickOnTransferFundsButton();

        transferFundsPage.enterAmmountForTransfer(
                ConfigReader.getProperty("transferAmount"));

        transferFundsPage.selectFromAccount(String.valueOf(defaultAccount));

        transferFundsPage.selectToAccount(String.valueOf(newAccount));

        transferFundsPage.clickOnTranferFundButton();

        // Step 8 - Verify Transfer Success
        Assert.assertEquals(
                transferFundsPage.getSucssfullTransferFundMessage(),
                "Transfer Complete!",
                "Transfer success message is incorrect.");

        Assert.assertEquals(
                transferFundsPage.validateTransferAmmount(),
                ConfigReader.getProperty("transferAmount"),
                "Transferred amount is incorrect.");

        Assert.assertEquals(
                transferFundsPage.getFromAccountNumber(),
                defaultAccount,
                "From Account number mismatch.");

        Assert.assertEquals(
                transferFundsPage.getToAccountNumber(),
                newAccount,
                "To Account number mismatch.");

        // Step 9 - Verify Updated Balance
        accountOverviewPage.clickOnAccountOverviewButton();

        List<Integer> afterBalance =
                accountOverviewPage.getBalanceAndAvailableAmount(newAccount);

        int transferAmount =
                Integer.parseInt(ConfigReader.getProperty("transferAmount"));

        Assert.assertEquals(
                afterBalance.get(0),
                beforeBalance.get(0) + transferAmount,
                "Balance not updated correctly.");

        Assert.assertEquals(
                afterBalance.get(1),
                beforeBalance.get(1) + transferAmount,
                "Available Balance not updated correctly.");
    }
}