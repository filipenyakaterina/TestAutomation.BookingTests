package test;

import exceptions.NoSuchSortCategoryException;
import model.Instance;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.BookingHomePage;
import service.Conditions;
import service.InstanceCreator;

import java.util.List;


public class SortTests extends CommonConditions {
    @Test(description = "Check sort by price on Search Results page")
    public void checkSortByPrice() {
        Instance testInstance = InstanceCreator.getInstanceFromProperty();
        List<Integer> prices = new BookingHomePage(driver).openPage().selectCurrency(CURRENCY_CODE).selectLanguage(LANGUAGE_CODE).searchBooking().
                enterSearchData(testInstance.getDeparture(), testInstance.getCheckInDate(), testInstance.getCheckOutDate(),
                        testInstance.getAdultsCount(), testInstance.getChildrenCount(), testInstance.getRoomsCount()).
                getSortBar().sortByPrice().getResultsList().getPrices();
        Assert.assertTrue(Conditions.checkIfListSortedByAscending(prices),
                "Check if list of sorted prices consists of price values sorted by ascending.");
    }

    @Test(description = "Check sort by count of stars on Search Results page")
    public void checkSortByStarsCount() {
        Instance testInstance = InstanceCreator.getInstanceFromProperty();
        List<Integer> starsCounts = new BookingHomePage(driver).openPage().selectCurrency(CURRENCY_CODE).selectLanguage(LANGUAGE_CODE).searchBooking().
                enterSearchData(testInstance.getDeparture(), testInstance.getCheckInDate(), testInstance.getCheckOutDate(),
                        testInstance.getAdultsCount(), testInstance.getChildrenCount(), testInstance.getRoomsCount()).
                getSortBar().sortByStars().getResultsList().getStarsCounts();
        Assert.assertTrue(Conditions.checkIfListSortedByDescending(starsCounts),
                "Check if list of sorted stars quantities consists of values sorted by descending.");
    }

    @Test(description = "Check sort by distance from downtown on Search Results page")
    public void checkSortByDistance() {
        Instance testInstance = InstanceCreator.getInstanceFromProperty();
        try {
            List<Integer> distances = new BookingHomePage(driver).openPage().selectCurrency(CURRENCY_CODE).selectLanguage(LANGUAGE_CODE).searchBooking().
                    enterSearchData(testInstance.getDeparture(), testInstance.getCheckInDate(), testInstance.getCheckOutDate(),
                            testInstance.getAdultsCount(), testInstance.getChildrenCount(), testInstance.getRoomsCount()).
                    getSortBar().sortByDistance().getResultsList().getDistances();
            Assert.assertTrue(Conditions.checkIfListSortedByAscending(distances),
                    "Check if list of sorted distances consists of values sorted by ascending.");
        } catch (NoSuchSortCategoryException e) {
            e.printStackTrace();
        }
    }
}
