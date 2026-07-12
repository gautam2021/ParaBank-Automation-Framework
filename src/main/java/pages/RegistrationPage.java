package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import base.BasePage;
import utility.LoggerUtil;

public class RegistrationPage extends BasePage {

    
    private static final Logger logger = LoggerUtil.getLogger(RegistrationPage.class);
    private final By firstName = By.id("customer.firstName");
    private final By lastName = By.id("customer.lastName");
    private final By streetAddress = By.id("customer.address.street");
    private final By city = By.id("customer.address.city");
    private final By state = By.id("customer.address.state");
    private final By zipCode = By.id("customer.address.zipCode");
    private final By phoneNumber = By.id("customer.phoneNumber");
    private final By ssn = By.id("customer.ssn");
    private final By username = By.id("customer.username");
    private final By password = By.id("customer.password");
    private final By confirmPassword = By.id("repeatedPassword");
    private final By register = By.xpath("//input[@value='Register']");
    

    private final By signUpMessage = By.xpath("//h1[text()='Signing up is easy!']");

    public void enterFirstName(String fName) {
	type(firstName, fName);
    }

    public void enterLastName(String lName) {
	type(lastName, lName);
    }

    public void enterStreetAddress(String add) {
	type(streetAddress, add);
    }

    public void enterCity(String cty) {
	type(city, cty);
    }

    public void enterState(String st) {
	type(state, st);
    }

    public void enterZipCode(String zpCode) {
	type(zipCode, zpCode);
    }

    public void enterPhoneNumber(String phNum) {
	type(phoneNumber, phNum);
    }

    public void enterSSN(String ssnNum) {
	type(ssn, ssnNum);
    }

    public void enterUserName(String uName) {
	type(username, uName);
    }

    public void enterPassword(String pwd) {
	type(password, pwd);
    }

    public void enterConfirmPassword(String confPwd) {
	type(confirmPassword, confPwd);
    }

    public AccountOverviewPage clickRegisterButton() {
	logger.info("Clicking Register Button");
	click(register);
	return new AccountOverviewPage();
    }

    public String validateSignUpMessage() {
	return getText(signUpMessage);
    }

   

}
