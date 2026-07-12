package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import dataprovider.LoginDataProvider;
import pages.AccountOverviewPage;
import pages.HomePage;
import pages.LoginPage;
import utility.DataUtil;
import utility.UserRegistrationHelper;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {
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

    }

    @Test(dataProvider = "invalidLogin", dataProviderClass = LoginDataProvider.class)
    public void inValidLogin(String userName, String password, String errorMessage) {
	LoginPage loginPage = new LoginPage();
	loginPage.loginAsInvalidUser(userName, password);

	// verify error Message for invalid login
	Assert.assertTrue(loginPage.getErrorMessage().contains("Error!"));

    }

}
