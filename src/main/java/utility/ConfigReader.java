package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private ConfigReader() {
    }

    private static final Properties prop = new Properties();
    static {
	String path = System.getProperty("user.dir") + File.separator + "resources" + File.separator
		+ "config.properties";

	try (FileInputStream fis = new FileInputStream(path)) {
	    prop.load(fis);
	} catch (Exception e) {
	    throw new RuntimeException("File is not present at- " + path, e);
	}
    }

    public static String getProperty(String key) {
	String value = prop.getProperty(key);
	if (value == null) {
	    throw new RuntimeException("Propertied not found " + key);
	}
	return value;

    }

}
