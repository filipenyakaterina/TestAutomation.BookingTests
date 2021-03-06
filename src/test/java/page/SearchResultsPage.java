package page;

import org.openqa.selenium.WebDriver;
import service.Waiter;

public class SearchResultsPage extends AbstractPage {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
        Waiter.waitUntilPageBodyWillBeUploaded();
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

    public FilterBoxPage getFilterBox() {
        return new FilterBoxPage(driver);
    }

    public ResultsListPage getResultsList() {
        return new ResultsListPage(driver);
    }
}
