package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page_elements.BudgetHandler;
import service.Executor;
import service.Waiter;
import utils.TestLogger;

import static test.CommonConditions.CURRENCY_CODE;

public class FilterBoxPage extends AbstractPage {
    @FindBy(xpath = "//div[contains(@class,'bui-switch')]")
    private WebElement budgetSwitcher;

    @FindBy(xpath = "//div[@class='noUi-handle noUi-handle-lower']")
    private WebElement lowerHandler;

    @FindBy(xpath = "//div[@class='noUi-handle noUi-handle-upper']")
    private WebElement upperHandler;

    public FilterBoxPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage openPage() {
        throw new RuntimeException("Cannot open Filter box on Search results " +
                "page without executing search on Booking search page.");
    }

    public ResultsListPage filterByOwnBudget(int minBudgetValue, int maxBudgetValue) {
        Executor.clickElementWithJS(budgetSwitcher);
        new BudgetHandler(lowerHandler, upperHandler).setRange(minBudgetValue, maxBudgetValue);
        Waiter.waitUntilPageWillBeReloaded();
        TestLogger.writeMessage("Search results were filtered according to the price per night from " +
                minBudgetValue + CURRENCY_CODE + " to " + maxBudgetValue + CURRENCY_CODE);
        return new ResultsListPage(driver);
    }
}
