package service;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    public static final int WAITING_PERIOD = 100;
    private static final String ARIA_EXPANDED_ATTRIBUTE = "aria-expanded";
    private static final String FALSE_VALUE = "false";
    private static final String TRUE_VALUE = "true";
    private static final String ID_ATTRIBUTE = "id";
    private static final String SEARCH_RESULTS_VALUE = "searchresultsPage";
    private static final String STYLE_ATTRIBUTE = "style";
    private static final String STYLE_ATTRIBUTE_DISPLAY_VALUE = "display: block;";

    private static FluentWait driverWait;

    public Waiter(WebDriver driver) {
        driverWait = new WebDriverWait(driver, WAITING_PERIOD).
                ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
    }

    public static void expandElementAndWait(WebElement element) {
        driverWait.until(driver -> {
            Executor.clickElementWithJS(element);
            return element.getAttribute(ARIA_EXPANDED_ATTRIBUTE).equals(TRUE_VALUE);
        });
    }

    public static void waitUntilElementWillBeClickable(By locator) {
        driverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitUntilElementNotBeExpanded(By locator) {
        driverWait.until(ExpectedConditions.attributeToBe(locator, ARIA_EXPANDED_ATTRIBUTE, FALSE_VALUE));
    }

    public static void waitUntilElementNotBeHidden(By locator) {
        driverWait.until(driver -> ((WebDriver) driver).findElement(locator).getAttribute(STYLE_ATTRIBUTE).isEmpty());
    }

    public static void waitUntilSearchResultsBeDisplayed(By locator) {
        driverWait.until(ExpectedConditions.attributeContains(locator, ID_ATTRIBUTE, SEARCH_RESULTS_VALUE));
    }

    public static void clickElementAndWaitAppearanceOfOther(WebElement clickableElement, By appearedElement) {
        driverWait.until(driver -> {
            Executor.clickElementWithActions(clickableElement);
            return ((WebDriver) driver).findElement(appearedElement).getAttribute(STYLE_ATTRIBUTE).equals(STYLE_ATTRIBUTE_DISPLAY_VALUE);
        });
    }

    public static void waitUntilElementWillBePresent(By locator) {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
