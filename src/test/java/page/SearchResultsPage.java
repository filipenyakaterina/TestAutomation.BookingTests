package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import service.Waiter;

public class SearchResultsPage extends AbstractPage {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
        Waiter.waitUntilSearchResultsBeDisplayed(By.tagName("body"));
    }

    @Override
    public AbstractPage openPage() {
        throw new RuntimeException("Cannot open search results " +
                "page without executing search on Booking search page.");
    }

    public SearchBoxPage getSearchBox() {
        return new SearchBoxPage(driver);
    }

    public SortBarPage getSortBar() {
        return new SortBarPage(driver);
    }
}
