package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import factory.DriverManager;

public class ScreenshotUtil {
    private ScreenshotUtil() {
    }

    public static String captureScreenshot(String testName) {

	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

	String path = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + testName + "_"
		+ timeStamp + ".png";

	TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
	File source = ts.getScreenshotAs(OutputType.FILE);

	File destination = new File(path);

	try {
	    FileUtils.copyFile(source, destination);
	} catch (IOException e) {

	    e.printStackTrace();
	}
	return path;

    }
}
