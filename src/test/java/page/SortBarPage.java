package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import service.Waiter;
import utils.TestLogger;

public class SortBarPage extends AbstractPage {
    @FindBy(xpath = "//li/a[contains(text(),'Price')]")
    private WebElement priceSort;

    public SortBarPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage openPage() {
        throw new RuntimeException("Cannot open Sort bar on Search results " +
                "page without executing search on Booking search page.");
    }

    public ResultsListPage sortByPrice() {
        priceSort.click();
        Waiter.waitUntilPageWillBeReloaded();
        TestLogger.writeMessage("Search results were sorted by price.");
        return new ResultsListPage(driver);
    }
}
