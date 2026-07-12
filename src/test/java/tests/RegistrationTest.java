package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AccountOverviewPage;
import utility.DataUtil;
import utility.UserRegistrationHelper;

public class RegistrationTest extends BaseTest {

    @Test
    public void registration() {

        AccountOverviewPage accountOverviewPage =
                UserRegistrationHelper.createUser();

        Assert.assertTrue(
                accountOverviewPage.getWelcomeMessage()
                        .contains(DataUtil.getCustomer().getUsername()),
                "Username is incorrect");

        Assert.assertTrue(
                accountOverviewPage.getSuccessMessage()
                        .contains("Your account was created successfully. You are now logged in."),
                "Success message is not displayed");
    }
}
