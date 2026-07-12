package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import base.BasePage;
import utility.LoggerUtil;

public class LoginPage extends BasePage {

    private final static Logger logger=LoggerUtil.getLogger(LoginPage.class);
    private final By userName = By.name("username");
    private final By password = By.name("password");
    private final By loginBtn = By.xpath("//input[@value='Log In']");
    private final By errorMsg = By.xpath("//div[@id='rightPanel']//h1");
    

    public void enterUserName(String uName) {
	logger.info("Entering UserName: "+uName);
	type(userName, uName);
    }

    public void enterPassword(String pwd) {
	logger.info("Entering Password");
	type(password, pwd);
    }

    public void clickLoginButton() {
	click(loginBtn);
    }

    private void login(String uName, String pwd) {
	enterUserName(uName);
	enterPassword(pwd);
	clickLoginButton();
    }

    public LoginPage loginAsInvalidUser(String user, String pwd) {
	login(user, pwd);

	return this;
    }

    public AccountOverviewPage loginAsValidUser(String user, String pwd) {
	login(user, pwd);

	return new AccountOverviewPage();
    }
    
    public String getErrorMessage() {
	return getText(errorMsg);
	
    }
}
