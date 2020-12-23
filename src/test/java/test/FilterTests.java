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
                getFilterBox().filterByOwnBudget(testInstance.getMinPricePerNight(), testInstance.getMaxPricePerNight()).getResultsList().getPrices();
        int daysCount = (int) ChronoUnit.DAYS.between(testInstance.getCheckInDate(), testInstance.getCheckOutDate());
        int minPrice = testInstance.getMinPricePerNight() * daysCount;
        int maxPrice = testInstance.getMaxPricePerNight() * daysCount;
        Assert.assertTrue(Conditions.checkIfListConsistsOfNumbersInRange(prices, minPrice, maxPrice),
                "Check if list of filtered prices consists of numbers in range from " + minPrice + " to " + maxPrice);
    }

    @Test(description = "Check filter by review score on Search Results page")
    public void checkFilterByReviewScore() {
        Instance testInstance = InstanceCreator.getInstanceFromProperty();
        List<Double> scores = new BookingHomePage(driver).openPage().selectCurrency(CURRENCY_CODE).selectLanguage(LANGUAGE_CODE).searchBooking().
                enterSearchData(testInstance.getDeparture(), testInstance.getCheckInDate(), testInstance.getCheckOutDate(),
                        testInstance.getAdultsCount(), testInstance.getChildrenCount(), testInstance.getRoomsCount()).
                getFilterBox().filterByReviewScore(testInstance.getReviewScore()).getResultsList().getScores();
        Assert.assertTrue(Conditions.checkIfListNotContainNumberLessThen(scores, testInstance.getReviewScore().getDataValue()),
                "Check if list of filtered scores doesn't contain number less than " + testInstance.getReviewScore().getDataValue());
    }

    @Test(description = "Check filter by star rating on Search Results page")
    public void checkFilterByStarRating() {
        Instance testInstance = InstanceCreator.getInstanceFromProperty();
        List<Integer> starCounts = new BookingHomePage(driver).openPage().selectCurrency(CURRENCY_CODE).selectLanguage(LANGUAGE_CODE).searchBooking().
                enterSearchData(testInstance.getDeparture(), testInstance.getCheckInDate(), testInstance.getCheckOutDate(), testInstance.getAdultsCount(),
                        testInstance.getChildrenCount(), testInstance.getRoomsCount()).getFilterBox().
                filterByStarRating(testInstance.getStarRating()).getResultsList().getStarsCounts();
        Assert.assertTrue(Conditions.checkIfListConsistsOf(starCounts, testInstance.getStarRating().getDataValue()),
                "Check if list of filtered stars quantities consists of values " + testInstance.getStarRating().getDataValue());
    }

    @Test(description = "Check filter by distance from city center on Search Results page")
    public void checkFilterByDistance() {
        Instance testInstance = InstanceCreator.getInstanceFromProperty();
        List<Integer> distances = new BookingHomePage(driver).openPage().selectCurrency(CURRENCY_CODE).selectLanguage(LANGUAGE_CODE).searchBooking().
                enterSearchData(testInstance.getDeparture(), testInstance.getCheckInDate(), testInstance.getCheckOutDate(), testInstance.getAdultsCount(),
                        testInstance.getChildrenCount(), testInstance.getRoomsCount()).getFilterBox().
                filterByDistance(testInstance.getDistance()).getResultsList().getDistances();
        Assert.assertTrue(Conditions.checkIfListConsistsOfNumbersNoMoreThen(distances, testInstance.getDistance().getDataValue()),
                "Check if list of filtered distances consists of values no more then " + testInstance.getDistance().getDataValue());
    }
}
