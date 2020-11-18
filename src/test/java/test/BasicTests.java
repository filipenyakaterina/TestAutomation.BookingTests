package test;

import model.Instance;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.BookingHomePage;
import service.InstanceCreator;

import java.time.LocalDate;

public class BasicTests extends CommonConditions {
    @Test(description = "Check field Departure on Search Results page")
    public void checkDeparture() {
        Instance testInstance = InstanceCreator.getInstanceFromProperty();
        String departure = new BookingHomePage(driver).openPage().selectLanguage(LANGUAGE_KEY).
                enterSearchData(testInstance.getDeparture(), testInstance.getCheckInDate(), testInstance.getCheckOutDate(),
                        testInstance.getAdultsCount(), testInstance.getChildrenCount(), testInstance.getRoomsCount()).
                getSearchBox().getDeparture();
        Assert.assertEquals(departure, testInstance.getDeparture());
    }

    @Test(description = "Check field Check-in-date on Search Results page")
    public void checkCheckInDate() {
        Instance testInstance = InstanceCreator.getInstanceFromProperty();
        LocalDate checkInDate = new BookingHomePage(driver).openPage().selectLanguage(LANGUAGE_KEY).
                enterSearchData(testInstance.getDeparture(), testInstance.getCheckInDate(), testInstance.getCheckOutDate(),
                        testInstance.getAdultsCount(), testInstance.getChildrenCount(), testInstance.getRoomsCount()).
                getSearchBox().getCheckInDate();
        Assert.assertEquals(checkInDate, testInstance.getCheckInDate());
    }

    @Test(description = "Check field Check-out-date on Search Results page")
    public void checkCheckOutDate() {
        Instance testInstance = InstanceCreator.getInstanceFromProperty();
        LocalDate checkOutDate = new BookingHomePage(driver).openPage().selectLanguage(LANGUAGE_KEY).
                enterSearchData(testInstance.getDeparture(), testInstance.getCheckInDate(), testInstance.getCheckOutDate(),
                        testInstance.getAdultsCount(), testInstance.getChildrenCount(), testInstance.getRoomsCount()).
                getSearchBox().getCheckOutDate();
        Assert.assertEquals(checkOutDate, testInstance.getCheckOutDate());
    }

    @Test(description = "Check field Adults on Search Results page")
    public void checkAdultsCount() {
        Instance testInstance = InstanceCreator.getInstanceFromProperty();
        int adultsCount = new BookingHomePage(driver).openPage().selectLanguage(LANGUAGE_KEY).
                enterSearchData(testInstance.getDeparture(), testInstance.getCheckInDate(), testInstance.getCheckOutDate(),
                        testInstance.getAdultsCount(), testInstance.getChildrenCount(), testInstance.getRoomsCount()).
                getSearchBox().getAdultsCount();
        Assert.assertEquals(adultsCount, testInstance.getAdultsCount());
    }

    @Test(description = "Check field Children on Search Results page")
    public void checkChildrenCount() {
        Instance testInstance = InstanceCreator.getInstanceFromProperty();
        int childrenCount = new BookingHomePage(driver).openPage().selectLanguage(LANGUAGE_KEY).
                enterSearchData(testInstance.getDeparture(), testInstance.getCheckInDate(), testInstance.getCheckOutDate(),
                        testInstance.getAdultsCount(), testInstance.getChildrenCount(), testInstance.getRoomsCount()).
                getSearchBox().getChildrenCount();
        Assert.assertEquals(childrenCount, testInstance.getChildrenCount());
    }

    @Test(description = "Check field Rooms on Search Results page")
    public void checkRoomsCount() {
        Instance testInstance = InstanceCreator.getInstanceFromProperty();
        int roomsCount = new BookingHomePage(driver).openPage().selectLanguage(LANGUAGE_KEY).
                enterSearchData(testInstance.getDeparture(), testInstance.getCheckInDate(), testInstance.getCheckOutDate(),
                        testInstance.getAdultsCount(), testInstance.getChildrenCount(), testInstance.getRoomsCount()).
                getSearchBox().getRoomsCount();
        Assert.assertEquals(roomsCount, testInstance.getRoomsCount());
    }
}
