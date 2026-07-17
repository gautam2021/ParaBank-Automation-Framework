package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AccountOverviewPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OpenAccountPage;
import utility.DataUtil;
import utility.UserRegistrationHelper;

public class OpenAccountTest extends BaseTest{


    @Test
    public void openSavingsAccount() {
	 
	AccountOverviewPage accountOverviewPage = new AccountOverviewPage();
	// Step 1 - Register User
	accountOverviewPage = UserRegistrationHelper.createUser();

	// Step 2 - Logout
	HomePage homePage = accountOverviewPage.logout();

	// Step 3 - Login with same credentials
	LoginPage loginPage = homePage.navigateToLoginPage();

	accountOverviewPage = loginPage.loginAsValidUser(DataUtil.getCustomer().getUsername(),
		DataUtil.getCustomer().getPassword());

	// Step 4 - Verify
	Assert.assertTrue(accountOverviewPage.isAccountOverviewDisplayed(),
		"Account Overview page should be displayed");
	
	// Step 5- Click Open New Account
	OpenAccountPage openAccountPage=new OpenAccountPage();
	openAccountPage.openNewAccount();
	openAccountPage.selectSavingAccount();
	openAccountPage.openAccount();
	
	Assert.assertTrue(openAccountPage.getAccountOpenSuccessMessage().contains("Congratulations, your account is now open"),"Sucessful message should be displayed");
	Assert.assertTrue(openAccountPage.getCreatedAccountNumber()>0);
	
	
    }

    @Test
    public void openCheckingAccount() {
	AccountOverviewPage accountOverviewPage = new AccountOverviewPage();
	// Step 1 - Register User
	accountOverviewPage = UserRegistrationHelper.createUser();

	// Step 2 - Logout
	HomePage homePage = accountOverviewPage.logout();

	// Step 3 - Login with same credentials
	LoginPage loginPage = homePage.navigateToLoginPage();

	accountOverviewPage = loginPage.loginAsValidUser(DataUtil.getCustomer().getUsername(),
		DataUtil.getCustomer().getPassword());

	// Step 4 - Verify
	Assert.assertTrue(accountOverviewPage.isAccountOverviewDisplayed(),
		"Account Overview page should be displayed");
	
	// Step 5- Click Open New Account
	OpenAccountPage openAccountPage=new OpenAccountPage();
	openAccountPage.openNewAccount();
	openAccountPage.selectCheckingAccount();
	openAccountPage.openAccount();
	
	Assert.assertTrue(openAccountPage.getAccountOpenSuccessMessage().contains("Congratulations, your account is now open"),"Sucessful message should be displayed");
	Assert.assertTrue(openAccountPage.getCreatedAccountNumber()>0);
    }
}
