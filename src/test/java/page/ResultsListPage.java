package page;

import formatter.ValueFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ResultsListPage extends AbstractPage {
    @FindBy(xpath = "//div[contains(@class,'bui-price-display__value')]")
    List<WebElement> priceLabels;

    public ResultsListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage openPage() {
        throw new RuntimeException("Cannot open list of search results " +
                "page without executing search on Booking search page.");
    }

    public List<Integer> getPrices() {
        return priceLabels.stream().map(priceLabel ->
                ValueFormatter.getValueFromPrice(priceLabel.getText())).collect(Collectors.toList());
    }
}
