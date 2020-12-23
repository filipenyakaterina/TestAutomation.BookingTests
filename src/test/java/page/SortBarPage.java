package page;

import exceptions.NoSuchSortCategoryException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import service.Executor;
import service.Waiter;
import utils.TestLogger;

public class SortBarPage extends AbstractPage {
    @FindBy(xpath = "//li/a[contains(text(),'Price')]")
    private WebElement priceSort;

    @FindBy(xpath = "//li[@data-id='dropdown']/a|//li[@class='sort_more_options']/button")
    private WebElement moreOptionsButton;

    @FindBy(xpath = "//li/a[contains(text(),'Stars')]")
    private WebElement starsSort;

    @FindBy(xpath = "//a[contains(text(),'Stars')]//following-sibling::ul")
    private WebElement listStarsSorts;

    @FindBy(xpath = "//li/a[contains(text(),'stars [5')]")
    private WebElement starsSortByDescending;

    public SortBarPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage openPage() {
        throw new RuntimeException("Cannot open Sort bar on Search results " +
                "page without executing search on Booking search page.");
    }

    public SearchResultsPage sortByPrice() {
        priceSort.click();
        Waiter.waitUntilPageWillBeReloaded();
        TestLogger.writeMessage("Search results were sorted by price.");
        return new SearchResultsPage(driver);
    }

    public SearchResultsPage sortByStars() {
        if (!starsSort.isDisplayed()) {
            Executor.clickElementWithJS(moreOptionsButton);
        }
        Executor.clickElementWithJS(starsSort);
        Waiter.waitUntilPopupWillBeExpanded(starsSort, listStarsSorts);
        Executor.clickElementWithJS(starsSortByDescending);
        Waiter.waitUntilPageWillBeReloaded();
        TestLogger.writeMessage("Search results were sorted by descending of stars count.");
        return new SearchResultsPage(driver);
    }

    public SearchResultsPage sortByDistance() throws NoSuchSortCategoryException {
        String distanceSortXpath = "//li[@class = ' sort_category   sort_distance_from_search ']/a";
        By distanceSortLocator = By.xpath(distanceSortXpath);
        WebElement distanceSort;

        if (driver.findElements(distanceSortLocator).isEmpty())
            throw new NoSuchSortCategoryException("Sort category with xpath " + distanceSortXpath + " is absent.");
        Executor.clickElementWithJS(moreOptionsButton);
        distanceSort = driver.findElement(distanceSortLocator);
        Executor.clickElementWithJS(distanceSort);
        Waiter.waitUntilPageWillBeReloaded();
        TestLogger.writeMessage("Search results were sorted by distance from downtown.");
        return new SearchResultsPage(driver);
    }
}
