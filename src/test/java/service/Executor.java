package service;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Executor {
    private static JavascriptExecutor javascriptExecutor;
    private static Actions actions;

    public Executor(WebDriver driver) {
        javascriptExecutor = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    public static void clickElementWithJS(WebElement element) {
        javascriptExecutor.executeScript("arguments[0].click();", element);
    }

    public static void clickElementWithActions(WebElement element) {
        actions.moveToElement(element).click(element).perform();
    }
}
