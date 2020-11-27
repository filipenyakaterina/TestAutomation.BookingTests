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
    private static final String STYLE_ATTRIBUTE = "style";
    private static final String STYLE_ATTRIBUTE_DISPLAY_VALUE = "display: block;";
    private static final String STYLE_ATTRIBUTE_HIDDEN_VALUE = "overflow: hidden;";
    private static final String CLASS_ATTRIBUTE = "class";
    private static final String BODY_TAG = "body";
    private static final String BODY_LOADING_CLASS = "iconfont_is_loading";
    private static final String BODY_UPLOADED_STYLE = "overflow: auto;";

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

    public static void waitUntilBodyNotBeHidden() {
        driverWait.until(driver -> ((WebDriver) driver).findElement(By.tagName(BODY_TAG)).getAttribute(STYLE_ATTRIBUTE).isEmpty());
    }

    public static void clickAndWaitUntilBodyBeHidden(WebElement clickableElement){
        driverWait.until(driver -> {
            Executor.clickElementWithJS(clickableElement);
            return ((WebDriver) driver).findElement(By.tagName(BODY_TAG)).getAttribute(STYLE_ATTRIBUTE).contains(STYLE_ATTRIBUTE_HIDDEN_VALUE);
        });
    }

    public static void clickElementAndWaitAppearanceOfOther(WebElement clickableElement, By appearedElement) {
        driverWait.until(driver -> {
            Executor.clickElementWithActions(clickableElement);
            return ((WebDriver) driver).findElement(appearedElement).getAttribute(STYLE_ATTRIBUTE).equals(STYLE_ATTRIBUTE_DISPLAY_VALUE);
        });
    }

    public static void waitUntilPopupWillBeExpanded(WebElement popup, WebElement optionList) {
        driverWait.until(driver -> {
            String popupAttr = popup.getAttribute(ARIA_EXPANDED_ATTRIBUTE);
            String optionListAttr = optionList.getAttribute(STYLE_ATTRIBUTE);
            if (popupAttr == null) return optionListAttr.equals(STYLE_ATTRIBUTE_DISPLAY_VALUE);
            return popupAttr.equals(TRUE_VALUE) || optionListAttr.equals(STYLE_ATTRIBUTE_DISPLAY_VALUE);
        });
    }

    public static void waitUntilElementWillBePresent(By locator) {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitUntilPageWillBeReloaded() {
        driverWait.until(driver -> ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0"));
    }

    public static void waitUntilPageBodyWillBeUploaded() {
        driverWait.until(driver -> {
            WebElement body = ((WebDriver) driver).findElement(By.tagName(BODY_TAG));
            return !(body.getAttribute(CLASS_ATTRIBUTE).contains(BODY_LOADING_CLASS)) && (body.getAttribute(STYLE_ATTRIBUTE).equals(BODY_UPLOADED_STYLE));
        });
    }
}
