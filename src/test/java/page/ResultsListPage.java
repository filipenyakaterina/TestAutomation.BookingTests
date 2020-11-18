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

    @FindBy(xpath = "//span[@class = 'c-accommodation-classification-rating']//span[contains(@aria-label,'out of 5')]")
    List<WebElement> ratingSpans;

    @FindBy(xpath = "//span[contains(text(),'from center')]")
    List<WebElement> distanceSpans;

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

    public List<Integer> getStarsCounts() {
        return ratingSpans.stream().map(ratingSpan ->
                ValueFormatter.getValueFromRating(ratingSpan.getAttribute("aria-label"))).collect(Collectors.toList());
    }

    public List<Integer> getDistances() {
        return distanceSpans.stream().map(distanceSpan ->
                ValueFormatter.getValueInMetersFromDistance(distanceSpan.getText())).collect(Collectors.toList());
    }
}
