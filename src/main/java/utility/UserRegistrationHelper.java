package utility;

import org.apache.logging.log4j.Logger;

import model.Customer;
import pages.AccountOverviewPage;
import pages.HomePage;
import pages.RegistrationPage;

public class UserRegistrationHelper {

    private static final Logger logger = LoggerUtil.getLogger(UserRegistrationHelper.class);
    public static AccountOverviewPage createUser() {

	Customer customer = new Customer(); // coming from pojo class

	customer.setFirstName(FakerUtil.getFirstName());
	customer.setLastName(FakerUtil.getLastName());
	customer.setStreetAddress(FakerUtil.getStreetAddress());
	customer.setCity(FakerUtil.getCity());
	customer.setState(FakerUtil.getState());
	customer.setZipCode(FakerUtil.getZipCode());
	customer.setPhoneNumber(FakerUtil.getPhoneNumber());
	customer.setSsn(FakerUtil.getSSN());
	customer.setUsername(FakerUtil.getUserName());
	customer.setPassword(ConfigReader.getProperty("password"));

	logger.info("Generating customer test data");
	DataUtil.setCustomer(customer);
	logger.info("Generated Username : {}", customer.getUsername());
	logger.info("Registered new customer");
	
	HomePage homePage = new HomePage();
	RegistrationPage registrationPage = homePage.createAccount();

	registrationPage.enterFirstName(customer.getFirstName());
	registrationPage.enterLastName(customer.getLastName());
	registrationPage.enterStreetAddress(customer.getStreetAddress());
	registrationPage.enterCity(customer.getCity());
	registrationPage.enterState(customer.getState());
	registrationPage.enterZipCode(customer.getZipCode());
	registrationPage.enterPhoneNumber(customer.getPhoneNumber());
	registrationPage.enterSSN(customer.getSsn());
	registrationPage.enterUserName(customer.getUsername());
	registrationPage.enterPassword(customer.getPassword());
	registrationPage.enterConfirmPassword(customer.getPassword());

	return registrationPage.clickRegisterButton();
    }
}