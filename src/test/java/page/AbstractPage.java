package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import service.Executor;
import service.Waiter;

public abstract class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        new Waiter(driver);
        new Executor(driver);
        PageFactory.initElements(driver, this);
    }

    public abstract AbstractPage openPage();
}
