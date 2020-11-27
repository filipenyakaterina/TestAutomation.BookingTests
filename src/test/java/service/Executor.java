package service;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
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

    public static void scrollToElement(WebElement element) {
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void clickElementWithActions(WebElement element) {
        Action clickElement = actions.moveToElement(element).click(element).build();
        clickElement.perform();
    }

    public static void dragAndDropElementHorizontally (WebElement element, int offset){
        Action dragAndDropElement = actions.moveToElement(element).dragAndDropBy(element,offset,0).build();
        dragAndDropElement.perform();
    }
}
