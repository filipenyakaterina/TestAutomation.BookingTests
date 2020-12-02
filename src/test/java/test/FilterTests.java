package test;

import model.Instance;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.BookingHomePage;
import service.Conditions;
import service.InstanceCreator;

import java.time.temporal.ChronoUnit;
import java.util.List;

public class FilterTests extends CommonConditions {
    @Test(description = "Check filter by price per night on Search Results page")
    public void checkFilterByPrice() {
        Instance testInstance = InstanceCreator.getInstanceFromProperty();
        List<Integer> prices = new BookingHomePage(driver).openPage().selectCurrency(CURRENCY_CODE).selectLanguage(LANGUAGE_CODE).searchBooking().
                enterSearchData(testInstance.getDeparture(), testInstance.getCheckInDate(), testInstance.getCheckOutDate(),
                        testInstance.getAdultsCount(), testInstance.getChildrenCount(), testInstance.getRoomsCount()).
                getFilterBox().filterByOwnBudget(testInstance.getMinPricePerNight(), testInstance.getMaxPricePerNight()).getPrices();
        int daysCount = (int) ChronoUnit.DAYS.between(testInstance.getCheckInDate(), testInstance.getCheckOutDate());
        Assert.assertTrue(Conditions.checkIfListConsistsOfNumbersInRange(prices,
                testInstance.getMinPricePerNight() * daysCount, testInstance.getMaxPricePerNight() * daysCount));
    }
}
