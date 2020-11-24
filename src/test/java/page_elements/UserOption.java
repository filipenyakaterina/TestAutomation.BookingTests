package page_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import service.Executor;
import service.Waiter;

public abstract class UserOption {
    protected By linkLocator;
    protected By buttonLocator;
    protected By optionLocator;
    private WebDriver driver;

    public UserOption(WebDriver driver) {
        this.driver = driver;
    }

    public abstract void select(String code);

    protected void selectLocator() {
        if (!driver.findElements(linkLocator).isEmpty()) {
            selectOptionWithLink();
        } else if (!driver.findElements(buttonLocator).isEmpty()) {
            selectOptionWithButton();
        }
    }

    private void selectOptionWithLink() {
        WebElement link = driver.findElement(linkLocator);
        Waiter.expandElementAndWait(link);
        selectOption();
        Waiter.waitUntilElementWillBeClickable(linkLocator);
        Waiter.waitUntilElementNotBeExpanded(linkLocator);
    }

    private void selectOptionWithButton() {
        WebElement button = driver.findElement(buttonLocator);
        Executor.clickElementWithJS(button);
        selectOption();
        Waiter.waitUntilElementNotBeHidden(By.tagName("body"));
    }

    private void selectOption() {
        WebElement option = driver.findElement(optionLocator);
        Executor.clickElementWithJS(option);
    }
}
