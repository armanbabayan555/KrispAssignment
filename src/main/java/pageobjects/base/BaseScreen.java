package pageobjects.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import setup.WaitUtils;

import java.util.ArrayList;
import java.util.List;

import static setup.DriverUtils.getDriver;

public abstract class BaseScreen {
    protected static WebDriver driver;
    protected Actions actions;

    public BaseScreen() {
        driver = getDriver();
        actions = new Actions(driver);
    }

    public void click(By locator) {
        WebElement element = WaitUtils.getInstance().waitForElementToBeClickable(locator);
        element.click();
    }

    public void click(By locator, int index) {
        List<WebElement> elements = WaitUtils.getInstance().waitForElementsToBeVisible(locator);
        elements.get(index).click();
    }

    public void switchToTab(int index) {
        ArrayList<String> switchTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(switchTabs.get(index));
    }

    public String getLink() {
        return driver.getCurrentUrl();
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getText(By locator) {
        try {
            return WaitUtils.getInstance().waitForElementToBeVisible(locator).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void typeTextInField(By locator, String text) {
        WebElement element = WaitUtils.getInstance().waitForElementToBeClickable(locator);
        element.click();
        element.sendKeys(text);
    }
}
