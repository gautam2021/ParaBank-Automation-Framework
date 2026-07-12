package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import factory.WaitManager;

public final class WaitUtil {

    private WaitUtil() {
    }

    public static WebElement waitForVisibility(By locator) {
        return WaitManager.getWait()
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(By locator) {
        return WaitManager.getWait()
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForPresence(By locator) {
        return WaitManager.getWait()
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static boolean waitForInvisibility(By locator) {
        return WaitManager.getWait()
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static boolean waitForTitleContains(String title) {
        return WaitManager.getWait()
                .until(ExpectedConditions.titleContains(title));
    }

    public static boolean waitForUrlContains(String url) {
        return WaitManager.getWait()
                .until(ExpectedConditions.urlContains(url));
    }

    public static boolean waitForUrlToBe(String url) {
        return WaitManager.getWait()
                .until(ExpectedConditions.urlToBe(url));
    }
}