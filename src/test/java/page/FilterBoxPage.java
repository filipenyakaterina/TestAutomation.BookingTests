package page;

import model.Distance;
import model.ReviewScore;
import model.StarRating;
import org.openqa.selenium.By;
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

    public SearchResultsPage filterByOwnBudget(int minBudgetValue, int maxBudgetValue) {
        Executor.clickElementWithJS(budgetSwitcher);
        new BudgetHandler(lowerHandler, upperHandler).setRange(minBudgetValue, maxBudgetValue);
        Waiter.waitUntilPageWillBeReloaded();
        TestLogger.writeMessage("Search results were filtered according to the price per night from " +
                minBudgetValue + CURRENCY_CODE + " to " + maxBudgetValue + CURRENCY_CODE);
        return new SearchResultsPage(driver);
    }

    public SearchResultsPage filterByReviewScore(ReviewScore reviewScoreValue) {
        WebElement reviewScore = driver.findElement(By.xpath("//div[@id='filter_review']//a[@data-id='review_score-" + reviewScoreValue.getDataValue() + "0']"));
        Executor.clickElementWithJS(reviewScore);
        Waiter.waitUntilPageWillBeReloaded();
        TestLogger.writeMessage("Search results were filtered according to the review score " + reviewScoreValue);
        return new SearchResultsPage(driver);
    }

    public SearchResultsPage filterByStarRating(StarRating starRatingValue) {
        WebElement starRating = driver.findElement(By.xpath("//div[@id='filter_class']//a[@data-id='class-" + starRatingValue.getDataValue() + "']"));
        Executor.scrollToElement(starRating);
        Executor.clickElementWithJS(starRating);
        Waiter.waitUntilPageWillBeReloaded();
        TestLogger.writeMessage("Search results were filtered according to the star rating " + starRatingValue);
        return new SearchResultsPage(driver);
    }

    public SearchResultsPage filterByDistance(Distance distanceValue) {
        WebElement distance = driver.findElement(By.xpath("//div[@id='filter_distance']//a[@data-id='distance-" + distanceValue.getDataValue() + "']"));
        Executor.scrollToElement(distance);
        Executor.clickElementWithJS(distance);
        Waiter.waitUntilPageWillBeReloaded();
        TestLogger.writeMessage("Search results were filtered according to the distance from city center " + distanceValue);
        return new SearchResultsPage(driver);
    }
}
