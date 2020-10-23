package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page_elements.Calendar;
import page_elements.Counter;
import utils.TestLogger;

import java.time.LocalDate;

public class BookingSearchPage extends AbstractPage {
    @FindBy(id = "ss")
    private WebElement departureInput;

    @FindBy(xpath = "//div[@class = 'xp__dates xp__group']")
    private WebElement calendarAria;

    @FindBy(xpath = "//input[@data-sb-id = 'main']")
    private WebElement searchButton;

    @FindBy(xpath = "//label[@id = 'xp__guests__toggle']")
    private WebElement guestsLabel;

    @FindBy(xpath = "//div[@class = 'sb-group__field sb-group__field-adults']")
    private WebElement adultsCounter;

    @FindBy(xpath = "//div[@class = 'sb-group__field sb-group-children ']")
    private WebElement childrenCounter;

    @FindBy(xpath = "//div[@class = 'sb-group__field sb-group__field-rooms']")
    private WebElement roomsCounter;

    public BookingSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage openPage() {
        throw new RuntimeException("Cannot open search page without executing selection language on Booking homepage.");
    }

    public SearchResultsPage enterSearchData(String departure, LocalDate checkInDate,
                                             LocalDate checkOutDate, int adultsCount, int childrenCount, int roomsCount) {
        departureInput.sendKeys(departure);
        Calendar calendar = new Calendar(calendarAria);
        calendar.selectPeriod(checkInDate, checkOutDate);
        guestsLabel.click();
        Counter adults = new Counter(adultsCounter);
        adults.setCount(adultsCount);
        Counter children = new Counter(childrenCounter);
        children.setCount(childrenCount);
        Counter rooms = new Counter(roomsCounter);
        rooms.setCount(roomsCount);
        searchButton.submit();
        TestLogger.writeMessage("Search fields are filled with values: " + departure + " (departure), "
                + checkInDate + " - " + checkOutDate + ", " + adultsCount + " (count of adults), " + childrenCount +
                " (count of children), " + roomsCount + " (count of rooms).");
        return new SearchResultsPage(driver);
    }
}
