package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page_elements.Calendar;
import service.Waiter;
import utils.TestLogger;

import java.time.LocalDate;

public class SearchResultsPage extends AbstractPage {
    @FindBy(id = "ss")
    private WebElement departure;

    @FindBy(xpath = "//div[contains(@class,'checkin')]//div[@class = 'sb-date-field__wrapper']")
    private WebElement checkInAria;

    @FindBy(xpath = "//div[contains(@class,'checkout')]//div[@class = 'sb-date-field__wrapper']")
    private WebElement checkOutAria;

    @FindBy(xpath = "//select[@id='group_adults']//option[@selected]")
    private WebElement adultsCount;

    @FindBy(xpath = "//select[@id='group_children']//option[@selected]")
    private WebElement childrenCount;

    @FindBy(xpath = "//select[@id='no_rooms']//option[@selected]")
    private WebElement roomsCount;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        Waiter.waitUntilSearchResultsBeDisplayed(By.tagName("body"));
    }

    @Override
    public AbstractPage openPage() {
        throw new RuntimeException("Cannot open search results " +
                "page without executing search on Booking search page.");
    }

    public String getDeparture() {
        String departureValue = departure.getAttribute("value");
        TestLogger.writeMessage("The value of Departure field in Search results page is " + departureValue);
        return departureValue;
    }

    public LocalDate getCheckInDate() {
        Calendar checkInCalendar = new Calendar(checkInAria);
        LocalDate checkInDate = checkInCalendar.getDate();
        TestLogger.writeMessage("The value of Check-in-date field in Search results page is " + checkInDate);
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        Calendar checkOutCalendar = new Calendar(checkOutAria);
        LocalDate checkOutDate = checkOutCalendar.getDate();
        TestLogger.writeMessage("The value of Check-out-date field in Search results page is " + checkOutDate);
        return checkOutDate;
    }

    public Integer getAdultsCount() {
        Integer adultsCountValue = Integer.parseInt(adultsCount.getAttribute("value"));
        TestLogger.writeMessage("The value of Adults count field in Search results page is " + adultsCountValue);
        return adultsCountValue;
    }

    public Integer getChildrenCount() {
        Integer childrenCountValue = Integer.parseInt(childrenCount.getAttribute("value"));
        TestLogger.writeMessage("The value of Children count field in Search results page is " + childrenCountValue);
        return childrenCountValue;
    }

    public Integer getRoomsCount() {
        Integer roomsCountValue = Integer.parseInt(roomsCount.getAttribute("value"));
        TestLogger.writeMessage("The value of Rooms count field in Search results page is " + roomsCountValue);
        return roomsCountValue;
    }
}
