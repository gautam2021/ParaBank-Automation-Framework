package utility;

import net.datafaker.Faker;

public final class FakerUtil {
    private final static net.datafaker.Faker faker = new Faker();

    private FakerUtil() {
	// so no one can create an object
    }

    public static String getFirstName() {
	return faker.name().firstName();
    }

    public static String getLastName() {
	return faker.name().lastName();
    }

    public static String getStreetAddress() {
	return faker.address().streetAddress();
    }

    public static String getCity() {
	return faker.address().city();
    }

    public static String getState() {
	return faker.address().state();
    }

    public static String getZipCode() {
	return faker.address().zipCode();
    }

    public static String getPhoneNumber() {
	return faker.number().digits(10);
    }

    public static String getSSN() {
	return faker.number().digits(9);
    }

    public static String getUserName() {
	return "user" + System.currentTimeMillis() + faker.number().digits(3);

    }

    public static String getPassword() {
	return ConfigReader.getProperty("password");
    }
}
