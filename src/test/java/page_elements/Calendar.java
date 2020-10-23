package page_elements;

import formatter.TimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import service.Executor;
import service.Waiter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Calendar {
    private WebElement calendar;

    public Calendar(WebElement calendar) {
        this.calendar = calendar;
    }

    public void selectPeriod(LocalDate firstDate, LocalDate secondDate) {
        openCalendar();
        findMonth(LocalDate.now(), firstDate);
        selectDate(firstDate);
        findMonth(firstDate, secondDate);
        selectDate(secondDate);
    }

    private void openCalendar() {
        By locator = By.xpath(".//div[@class = 'xp__dates-inner']");
        WebElement checkInCheckOutField = calendar.findElement(locator);
        Waiter.clickElementAndWaitAppearanceOfOther(checkInCheckOutField, By.xpath(".//div[@class = 'bui-calendar']"));
    }

    private void findMonth(LocalDate currentDate, LocalDate neededDate) {
        WebElement calendarNext = calendar.findElement(By.xpath(".//div[@data-bui-ref = 'calendar-next']"));
        long countOfMonths = ChronoUnit.MONTHS.between(currentDate, neededDate);
        for (int i = 0; i < countOfMonths; i++) {
            Executor.clickElementWithActions(calendarNext);
        }
    }

    private void selectDate(LocalDate date) {
        By locator = By.xpath("//td[@data-date = '" + date + "']");
        Waiter.waitUntilElementWillBePresent(locator);
        WebElement calendarDate = calendar.findElement(locator);
        Executor.clickElementWithActions(calendarDate);
    }

    public LocalDate getDate() {
        WebElement dateDisplay = calendar.findElement(By.xpath(".//div[@class = 'sb-date-field__display']"));
        return TimeFormatter.getDateFromStringWithDayOfWeek(dateDisplay.getText());
    }
}
