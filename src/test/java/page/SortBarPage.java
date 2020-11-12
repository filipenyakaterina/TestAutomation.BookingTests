package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import service.Executor;
import service.Waiter;
import utils.TestLogger;

public class SortBarPage extends AbstractPage {
    @FindBy(xpath = "//div[@data-block-id='hotel_list']")
    WebElement hotelList;

    @FindBy(xpath = "//li/a[contains(text(),'Price')]")
    private WebElement priceSort;

    @FindBy(xpath = "//li[@data-id='dropdown']/a|//li[@class='sort_more_options']/button")
    private WebElement moreOptionsButton;

    @FindBy(xpath = "//ul[@id='sortbar_dropdown_options']")
    private WebElement moreOptions;

    @FindBy(xpath = "//li/a[contains(text(),'Stars')]")
    private WebElement starsSort;

    @FindBy(xpath = "//a[contains(text(),'Stars')]//following-sibling::ul")
    private WebElement listSortDirections;

    @FindBy(xpath = "//li/a[contains(text(),'stars [5')]")
    private WebElement starsSortDirection;

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

    public ResultsListPage sortByStars() {
        if (!starsSort.isDisplayed()) {
            Executor.clickElementWithJS(moreOptionsButton);
        }
        Executor.clickElementWithJS(starsSort);
        Waiter.waitUntilPopupWillBeExpanded(starsSort, listSortDirections);
        Executor.clickElementWithJS(starsSortDirection);
        Waiter.waitUntilPageWillBeReloaded();
        TestLogger.writeMessage("Search results were sorted by stars count.");
        return new ResultsListPage(driver);
    }
}
