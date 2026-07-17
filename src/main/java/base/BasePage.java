package base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import factory.DriverManager;
import factory.WaitManager;
import utility.WaitUtil;

public abstract class BasePage {

    protected void click(By locator) {

	WaitUtil.waitForClickable(locator).click();

    }

    protected void type(By locator, String text) {
	WaitUtil.waitForVisibility(locator).sendKeys(text);
    }

    protected String getText(By locator) {
	return WaitUtil.waitForVisibility(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
	return WaitUtil.waitForVisibility(locator).isDisplayed();
    }

    protected List<WebElement> findElements(By locator) {
	return DriverManager.getDriver().findElements(locator);
    }

    protected void clear(By locator) {

	WaitUtil.waitForVisibility(locator).clear();
    }

    protected WebElement getWebElement(By locator) {
	WaitManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
	return DriverManager.getDriver().findElement(locator);
    }

}