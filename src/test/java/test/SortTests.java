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
        List<Integer> prices = new BookingHomePage(driver).openPage().selectLanguage(LANGUAGE_KEY).
                enterSearchData(testInstance.getDeparture(), testInstance.getCheckInDate(), testInstance.getCheckOutDate(),
                        testInstance.getAdultsCount(), testInstance.getChildrenCount(), testInstance.getRoomsCount()).
                getSortBar().sortByPrice().getPrices();
        Assert.assertTrue(Conditions.checkIfListSortedByAscending(prices));
    }

    @Test(description = "Check sort by count of stars on Search Results page")
    public void checkSortByStarsCount() {
        Instance testInstance = InstanceCreator.getInstanceFromProperty();
        List<Integer> starsCounts = new BookingHomePage(driver).openPage().selectLanguage(LANGUAGE_KEY).
                enterSearchData(testInstance.getDeparture(), testInstance.getCheckInDate(), testInstance.getCheckOutDate(),
                        testInstance.getAdultsCount(), testInstance.getChildrenCount(), testInstance.getRoomsCount()).
                getSortBar().sortByStars().getStarsCounts();
        Assert.assertTrue(Conditions.checkIfListSortedByDescending(starsCounts));
    }

    @Test(description = "Check sort by distance from downtown on Search Results page")
    public void checkSortByDistance() {
        Instance testInstance = InstanceCreator.getInstanceFromProperty();
        try {
            List<Integer> distances = new BookingHomePage(driver).openPage().selectLanguage(LANGUAGE_KEY).
                    enterSearchData(testInstance.getDeparture(), testInstance.getCheckInDate(), testInstance.getCheckOutDate(),
                            testInstance.getAdultsCount(), testInstance.getChildrenCount(), testInstance.getRoomsCount()).
                    getSortBar().sortByDistance().getDistances();
            Assert.assertTrue(Conditions.checkIfListSortedByAscending(distances));
        } catch (NoSuchSortCategoryException e) {
            e.printStackTrace();
        }
    }
}
